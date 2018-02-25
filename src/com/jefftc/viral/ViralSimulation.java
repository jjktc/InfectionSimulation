package com.jefftc.viral;

import com.jefftc.engine.Command;
import com.jefftc.engine.InputLayer;
import com.jefftc.engine.Simulation;
import com.jefftc.viral.mechanics.Country;
import com.jefftc.viral.mechanics.Symptom;

import java.util.ArrayList;
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
        ViralSimulationData.init();
        this.isRunning = true;

        this.io.println("What country would you like to start in?");
        for (int i = 0; i < ViralSimulationData.COUNTRIES.length; i++) {
            this.io.printlnIndented(i + "\t: " + ViralSimulationData.COUNTRIES[i].getName());
        }

        int startingCountryIndex = this.io.expectInt(0, ViralSimulationData.COUNTRIES.length);
        ViralSimulationData.COUNTRIES[startingCountryIndex].startInfection();
        this.io.println("Infection originates in " +
                ViralSimulationData.COUNTRIES[startingCountryIndex].getName());
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
        String fullInput = this.io.receiveInput();
        Command command = this.io.detectCommand(fullInput);

        if (command != null) {
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
                    System.out.println();
                    break;
            }
        }
    }

    /**
     * The main game loop of the Simulation
     */
    @Override
    public void run() {
        this.weeks++;
        this.io.println("Week #" + this.weeks);
        boolean healthyPeople = false;

        for (Country country : ViralSimulationData.COUNTRIES) {
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
        List<String> infectedNames = new ArrayList<>();
        List<Double> infectedPercentages = new ArrayList<>();
        int totalInfectedPopulation = 0;
        int totalWorldPopulation = 0;

        for (Country country : ViralSimulationData.COUNTRIES) {
            totalInfectedPopulation += country.getInfectedPopulation();
            totalWorldPopulation += country.getPopulation();

            if (country.getInfectedPopulation() > 0) {
                // Only print out bars for healthy countries
                infectedNames.add(country.getName());
                infectedPercentages.add(country.getInfectedPercentage());
            }
        }

        infectedNames.add("TOTAL");
        infectedPercentages.add((double) totalInfectedPopulation / (double) totalWorldPopulation);

        this.io.printAllBars(infectedNames, infectedPercentages);
    }

    /**
     * Print out the final simulation message
     */
    @Override
    public void printEnding() {
        this.io.println("After " + this.weeks + " weeks, every person on Earth has been infected.");
    }
}
