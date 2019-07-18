package com.jefftc.viral;

import com.jefftc.engine.Command;
import com.jefftc.engine.InputLayer;
import com.jefftc.engine.Simulation;
import com.jefftc.viral.mechanics.Continent;
import com.jefftc.viral.mechanics.Country;
import com.jefftc.viral.mechanics.Symptom;

import java.util.*;

/**
 * Simulation of an infection (inspired by Plague Inc.) User chooses the
 * starting location of an infection and then can add symptoms once every unit
 * of time and gets feedback on how it has spread
 */
public class ViralSimulation extends Simulation {

    private static final int INFO_COL_WIDTH = 12;

    private int days = 0;
    private List<Symptom> symptoms = new ArrayList<>();
    private boolean receivedCommand = false;

    private double totalWorldPopulation = 0.0;
    private double totalInfectedPopulation = 0.0;
    private double totalInfectedPercentage = 0.0;

    private double[] continentPopulations = new double[ViralSimulationCountries.TOTAL_CONTINENTS];
    private double[] continentInfectedPopulations = new double[ViralSimulationCountries.TOTAL_CONTINENTS];
    private double[] continentPercentages = new double[ViralSimulationCountries.TOTAL_CONTINENTS];

    /**
     * Create a Simulation with a given InputLayer
     *
     * @param io the InputLayer to use
     */
    public ViralSimulation(InputLayer io) {
        super(io);
    }

    /**
     * Initialize the Simulation
     */
    @Override
    public void init() {
        this.io.init(ViralSimulationData.COMMANDS);
        ViralSimulationData.init(this);
        this.isRunning = true;

        this.inputSymptoms();
        this.inputStartingCountry();
        this.io.println("Simulation is now beginning (hit ENTER to advance one day)");
    }

    /**
     * Ask the User to choose Symptom objects
     */
    private void inputSymptoms() {
        this.io.println("What symptoms would you like to start with?");
        for (Symptom symptom : ViralSimulationData.SYMPTOMS) {
            if (this.useSymptom(symptom)) {
                this.symptoms.add(symptom);
            }
        }
        System.out.println();
    }

    /**
     * Ask the User to choose the starting Country for the disease
     */
    private void inputStartingCountry() {
        this.io.println("What country would you like to start in?");
        Country[] countries = ViralSimulationCountries.COUNTRIES;
        for (int i = 0; i < countries.length; i++) {
            this.totalWorldPopulation += countries[i].getPopulation();
            this.continentPopulations[countries[i].getContinentCode()] += countries[i].getPopulation();

            this.io.printlnIndented(i + "\t: " + countries[i].getName());
        }

        int startingCountryIndex = this.io.expectInt(0, countries.length);
        countries[startingCountryIndex].startInfection();
        this.io.println("Infection originates in " + countries[startingCountryIndex].getName());
        System.out.println();
    }

    /**
     * Ask if the user would like to start their infection with the given Symptom
     *
     * @param symptom the Symptom to ask about
     * @return if the user wants to use it
     */
    private boolean useSymptom(Symptom symptom) {
        this.io.println("Would you like to start with the symptom: " + symptom.getName());
        return this.io.expectBoolean();
    }

    /**
     * Process the user input at the beginning of each run. In Viral Simulation, all
     * the user input is at the beginning, the user can now merely check on status
     */
    @Override
    public void processInput() {
        this.receivedCommand = false;
        String fullInput = this.io.receiveInput();
        Command command = this.io.detectCommand(fullInput);

        if (command != null) {
            this.receivedCommand = true;
            String body = command.getBody(fullInput);

            switch (command.getCommand()) {
            case "quit":
                // Close the entire Simulation
                System.exit(0);
                break;

            case "info":
                // Print out info on the specified Country given in body
                Country country = ViralSimulationData.findCountry(body);
                if (country != null) {
                    this.io.println("Information for " + country.getName());
                    this.io.printFormatted(INFO_COL_WIDTH, true, "Population:, " + country.getPopulation());
                    this.io.printFormatted(INFO_COL_WIDTH, true, "Infected:, " + country.getInfectedPopulation());
                } else {
                    this.io.println("Could not find a Country with the given name");
                }
                break;

            default:
                this.io.println("Sorry, did not recognize the given command");
                break;
            }
        }
    }

    /**
     * The main game loop of the Simulation
     */
    @Override
    public void run() {
        if (this.receivedCommand) {
            return;
        }

        this.days++;
        this.io.println("Day #" + this.days);

        boolean simulationOver = this.advanceSimulation();
        if (simulationOver) {
            // Simulation is over
            this.isRunning = false;
        }
    }

    /**
     * Advance the state of the simulation and check if the simulation is over
     *
     * @return if the simulation has completed
     */
    private boolean advanceSimulation() {
        boolean healthyPeople = false;
        for (Country country : ViralSimulationCountries.COUNTRIES) {
            // Advance the time for each country
            country.nextEpoch(this.symptoms);

            if (country.hasHealthPeople()) {
                healthyPeople = true;
            }
        }

        return !healthyPeople;
    }

    /**
     * Print out the information at the end of an epoch
     */
    @Override
    public void print() {
        if (this.receivedCommand) {
            return;
        }

        this.printBars();
        this.printMap();
    }

    /**
     * Print out all the Country / Continent bars
     */
    private void printBars() {
        this.totalInfectedPopulation = 0.0;
        List<Country> infectedCountries = new ArrayList<>();
        List<String> infectedNames = new ArrayList<>();
        List<Double> infectedPercentages = new ArrayList<>();

        this.addAllContinentBars(infectedNames, infectedPercentages, infectedCountries);
        this.addAllCountryBars(infectedNames, infectedPercentages, infectedCountries);

        this.calculatePercentages();
        infectedNames.add("TOTAL");
        infectedPercentages.add(this.totalInfectedPercentage);
        this.io.printAllBars(infectedNames, infectedPercentages);
    }

    /**
     * Get the printable lists for the continents
     *
     * @param names       the destination list of names
     * @param percentages the destination list of percentages
     * @param infected    the destination list of countries
     */
    private void addAllContinentBars(List<String> names, List<Double> percentages, List<Country> infected) {
        for (Continent continent : ViralSimulationCountries.continents) {
            if (continent.isAllInfected()) {
                // Can treat all Countries in Continent as one unit
                this.totalInfectedPopulation += continent.getInfectedPopulation();

                names.add(continent.getName());
                percentages.add(continent.getInfectedPercentage());
            } else {
                // Handle all Countries separately
                infected.addAll(continent.getInfectedCountries());
            }
        }
    }

    /**
     * Get the printable lists for all the countries
     *
     * @param names       the destination list of names
     * @param percentages the destination list of percentages
     * @param infected    the list of countries to go through
     */
    private void addAllCountryBars(List<String> names, List<Double> percentages, List<Country> infected) {
        infected.sort(Comparator.comparing(Country::getInfectedPercentage).reversed());
        for (Country country : infected) {
            // Print out all individual infected Countries if Continent isn't entirely
            // infected
            this.totalInfectedPopulation += country.getInfectedPopulation();
            this.continentInfectedPopulations[country.getContinentCode()] += country.getInfectedPopulation();

            String countryTag = country.getName();
            if (!country.isBorderOpen()) {
                countryTag += " [ CLOSED ]";
            }

            names.add(countryTag);
            percentages.add(country.getInfectedPercentage());
        }
    }

    /**
     * Calculate the infection percentages for the world and by continent
     */
    private void calculatePercentages() {
        this.totalInfectedPercentage = this.totalInfectedPopulation / this.totalWorldPopulation;
        for (int i = 0; i < ViralSimulationCountries.TOTAL_CONTINENTS; i++) {
            this.continentPercentages[i] = this.continentInfectedPopulations[i] / this.continentPopulations[i];
        }
    }

    /**
     * Print out a visual map of the world to show spread of infection
     */
    private void printMap() {
        List<String> mapLines = MapPrinter.getFilterMap(this.continentPercentages);
        for (String line : mapLines) {
            System.out.println(line);
        }
    }

    /**
     * Print out the final simulation message
     */
    @Override
    public void printEnding() {
        this.io.println("After " + this.days + " days, every person on Earth has been infected.");
    }

    /* GETTERS AND SETTERS */

    public double getTotalInfectedPercentage() {
        return this.totalInfectedPercentage;
    }

    public List<Symptom> getSymptoms() {
        return symptoms;
    }
}
