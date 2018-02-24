package com.jefftc.viral.countries;

import com.jefftc.viral.mechanics.Country;

/**
 * A LandLockedCountry is a type of Country that can only transmit the infection over land
 */
public class LandLockedCountry extends Country {

    /**
     * Create a Country with a given name, population size, heat, dampness, and array of connections
     *
     * @param name            the name of the Country
     * @param connectionNames the array of connected Country objects
     * @param population      the total population size
     * @param heat            the heat (out of 1.0)
     * @param dampness        the dampness (out of 1.0)
     */
    public LandLockedCountry(String name, String[] connectionNames, int population, double heat, double dampness) {
        super(name, connectionNames, population, heat, dampness);
    }

    /**
     * Advance the Country Epoch. Should result in spreading the infection both internally
     * and potentially externally
     */
    @Override
    public void nextEpoch() {

    }

    /**
     * Start the infection by infecting a single member of the population
     */
    @Override
    public void startInfection() {

    }

    /**
     * Infect a specified Country. Must be connected
     *
     * @param target the Country to infect
     */
    @Override
    public void infect(Country target) {

    }

    /**
     * Spread the infection internally
     */
    @Override
    public void spreadInternally() {

    }

}
