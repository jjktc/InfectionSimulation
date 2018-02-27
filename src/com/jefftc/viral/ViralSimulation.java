package com.jefftc.viral;

import com.jefftc.engine.Command;
import com.jefftc.engine.InputLayer;
import com.jefftc.engine.Simulation;
import com.jefftc.viral.mechanics.Country;
import com.jefftc.viral.mechanics.Symptom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Simulation of an infection (inspired by Plague Inc.)
 * User chooses the starting location of an infection and then can add symptoms once every unit
 * of time and gets feedback on how it has spread
 */
public class ViralSimulation extends Simulation {

    private static final int INFO_COL_WIDTH = 12;

    private int weeks = 0;
    private List<Symptom> symptoms = new ArrayList<>();
    private double totalWorldPopulation = 0.0;
    private double totalInfectedPercentage = 0.0;
    private boolean receivedCommand = false;

    private double[] continentPopulations = new double[ViralSimulationCountries.TOTAL_CONTINENTS];
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

        this.io.println("What country would you like to start in?");
        Country[] countries = ViralSimulationCountries.COUNTRIES;
        for (int i = 0; i < countries.length; i++) {
            this.totalWorldPopulation += countries[i].getPopulation();
            this.continentPopulations[countries[i].getContinentCode()] += countries[i].getPopulation();

            this.io.printlnIndented(i + "\t: " + countries[i].getName());
        }

        int startingCountryIndex = this.io.expectInt(0, countries.length);
        countries[startingCountryIndex].startInfection();
        this.io.println("Infection originates in " +
                countries[startingCountryIndex].getName());
        System.out.println();

        this.io.println("What symptoms would you like to start with?");
        for (Symptom symptom : ViralSimulationData.SYMPTOMS) {
            if (this.useSymptom(symptom)) {
                this.symptoms.add(symptom);
            }
        }

        this.io.println("Simulation is now beginning (hit ENTER to advance one week)");
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
     * Process the user input at the beginning of each run.
     * In Viral Simulation, all the user input is at the beginning, the user can now merely check
     * on status
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
                        this.io.printFormatted(INFO_COL_WIDTH, true,
                                "Population:, " + country.getPopulation());
                        this.io.printFormatted(INFO_COL_WIDTH, true,
                                "Infected:, " + country.getInfectedPopulation());
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

        this.weeks++;
        this.io.println("Week #" + this.weeks);
        boolean healthyPeople = false;

        for (Country country : ViralSimulationCountries.COUNTRIES) {
            // Advance the time for each country
            country.nextEpoch(this.symptoms);

            if (!country.isCompletelyInfected()) {
                healthyPeople = true;
            }
        }

        if (!healthyPeople) {
            // Simulation is over
            this.isRunning = false;
        }
    }

    /**
     * Print out the information at the end of an epoch
     */
    @Override
    public void print() {
        if (this.receivedCommand) {
            return;
        }

        List<String> infectedNames = new ArrayList<>();
        List<Double> infectedPercentages = new ArrayList<>();
        double totalInfectedPopulation = 0.0;
        double[] continentInfectedPopulations = new double[ViralSimulationCountries.TOTAL_CONTINENTS];

        Arrays.sort(ViralSimulationCountries.COUNTRIES,
                Comparator.comparing(Country::getInfectedPercentage).reversed());

        for (Country country : ViralSimulationCountries.COUNTRIES) {
            totalInfectedPopulation += country.getInfectedPopulation();
            continentInfectedPopulations[country.getContinentCode()] += country.getInfectedPopulation();

            if (country.getInfectedPopulation() > 0) {
                // Only print out bars for healthy countries
                String countryTag = country.getName();
                if (!country.isBorderOpen()) {
                    countryTag += " [ CLOSED ]";
                }
                infectedNames.add(countryTag);
                infectedPercentages.add(country.getInfectedPercentage());
            }
        }

        this.totalInfectedPercentage = totalInfectedPopulation / this.totalWorldPopulation;
        for (int i = 0; i < ViralSimulationCountries.TOTAL_CONTINENTS; i++) {
            this.continentPercentages[i] = continentInfectedPopulations[i] / this.continentPopulations[i];
        }

        infectedNames.add("TOTAL");
        infectedPercentages.add(this.totalInfectedPercentage);
        this.io.printAllBars(infectedNames, infectedPercentages);

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
        this.io.println("After " + this.weeks + " weeks, every person on Earth has been infected.");
    }

    public double getTotalInfectedPercentage() {
        return this.totalInfectedPercentage;
    }
}
