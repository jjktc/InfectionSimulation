package com.jefftc.viral;

import com.jefftc.engine.InputLayer;
import com.jefftc.engine.Simulation;
import com.jefftc.viral.mechanics.Country;

import java.util.ArrayList;
import java.util.List;

/**
 * Simulation of an infection (inspired by Plague Inc.)
 * User chooses the starting location of an infection and then can add symptoms once every unit
 * of time and gets feedback on how it has spread
 */
public class ViralSimulation extends Simulation {

    public int weeks = 0;

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
        ViralSimulationData.init();
        this.io.init(ViralSimulationData.COMMANDS);
        this.isRunning = true;

        this.io.println("What country would you like to start in?");
        for (int i = 0; i < ViralSimulationData.COUNTRIES.length; i++) {
            this.io.printlnIndented(i + "\t: " + ViralSimulationData.COUNTRIES[i].getName());
        }

        int startingCountryIndex = this.io.expectInt(0, ViralSimulationData.COUNTRIES.length);
        ViralSimulationData.COUNTRIES[startingCountryIndex].startInfection();
        this.io.println("Infection outbreak in " +
                ViralSimulationData.COUNTRIES[startingCountryIndex].getName());
    }

    /**
     * Process the user input at the beginning of each run
     */
    @Override
    public void processInput() {
        this.io.receiveInput();
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
            country.nextEpoch();

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
