package com.jefftc.viral;

import com.jefftc.engine.Command;
import com.jefftc.engine.InputLayer;
import com.jefftc.engine.Simulation;

/**
 * Simulation of an infection (inspired by Plague Inc.)
 * User chooses the starting location of an infection and then can add symptoms once every unit
 * of time and gets feedback on how it has spread
 */
public class ViralSimulation extends Simulation {

    public Command[] commands = new Command[]{
            new Command(new String[]{
                    "quit", "exit", "leave", "stop", "abandon"
            }, false)
    };

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
        this.io.init(this.commands);
        this.isRunning = true;
        this.io.println("What country would you like to start in?");
        String initialInput = this.io.receiveInput();
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

    }

    /**
     * Print out the information at the end of an epoch
     */
    @Override
    public void print() {

    }
}
