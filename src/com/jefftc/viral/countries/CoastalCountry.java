package com.jefftc.viral.countries;

import com.jefftc.viral.mechanics.Country;

/**
 * CoastalCountry is a type of Country that can pass the infection over air or water as well as land
 */
public class CoastalCountry extends Country {

    /**
     * Create a Country with a given name, population size, heat, dampness, and array of connections
     *
     * @param name            the name of the Country
     * @param connectionNames the array of connected Country objects
     * @param population      the total population size
     * @param heat            the heat (out of 1.0)
     * @param dampness        the dampness (out of 1.0)
     */
    public CoastalCountry(String name, String[] connectionNames, int population, double heat, double dampness) {
        super(name, connectionNames, population, heat, dampness);
    }

    /**
     * Advance the Country Epoch. Should result in spreading the infection both internally
     * and potentially externally
     */
    @Override
    public void nextEpoch() {
        if (this.getInfectedPopulation() > 0) {
            this.spreadInternally();
        }
    }

    /**
     * Start the infection by infecting a single member of the population
     */
    @Override
    public void startInfection() {
        if (this.getInfectedPopulation() == 0) {
            this.setInfectedPopulation(INITIAL_INFECTION_COUNT);
        }
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
        double newInfectedPopulation = this.getInfectedPopulation() * 1.5 * (1 + this.getInternalSpreadChance());
        double minimumIncrease = 0.005 * this.getPopulation();
        if (newInfectedPopulation < minimumIncrease) {
            newInfectedPopulation = minimumIncrease;
        }
        this.setInfectedPopulation((int) (
                newInfectedPopulation
        ));
    }

}
