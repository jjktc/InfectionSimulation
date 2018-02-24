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
        for (Country country : ViralSimulationData.COUNTRIES) {
            country.nextEpoch();
        }
    }

    /**
     * Print out the information at the end of an epoch
     */
    @Override
    public void print() {
        List<String> infectedNames = new ArrayList<>();
        List<Double> infectedPercentages = new ArrayList<>();
        for (Country country : ViralSimulationData.COUNTRIES) {
            if (country.getInfectedPopulation() > 0) {
                infectedNames.add(country.getName());
                infectedPercentages.add(country.getInfectedPercentage());
            }
        }
        this.io.printAllBars(infectedNames, infectedPercentages);
    }
}
