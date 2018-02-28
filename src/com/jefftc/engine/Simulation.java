package com.jefftc.engine;

public abstract class Simulation {

    protected InputLayer io;
    public boolean isRunning;

    /**
     * Create a Simulation with a given InputLayer
     *
     * @param io the InputLayer to use
     */
    public Simulation(InputLayer io) {
        this.io = io;
    }

    /**
     * Initialize the Simulation
     */
    public abstract void init();

    /**
     * Process the user input at the beginning of each run
     */
    public abstract void processInput();

    /**
     * The main game loop of the Simulation
     */
    public abstract void run();

    /**
     * Print out the information at the end of an epoch
     */
    public abstract void print();

    /**
     * Print out the final simulation message
     */
    public abstract void printEnding();

}
