package com.jefftc.engine;

import com.jefftc.viral.ViralSimulation;

/**
 * Allows the user to run the given simulation
 */
public class Engine {

    private static InputLayer io = new InputLayer(true);
    private static ViralSimulation simulation = new ViralSimulation(io);

    /**
     * Initialize and run the ViralSimulation
     *
     * @param args unused
     */
    public static void main(String[] args) {
        simulation.init();
        while (simulation.isRunning) {
            simulation.processInput();
            simulation.run();
            simulation.print();
        }
        simulation.printEnding();
    }

}
