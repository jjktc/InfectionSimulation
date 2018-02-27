package com.jefftc.viral.countries;

import com.jefftc.viral.mechanics.Country;
import com.jefftc.viral.mechanics.Symptom;

import java.util.List;

/**
 * A LandLockedCountry is a type of Country that can only transmit the infection over land
 */
public class LandLockedCountry extends Country {

    /**
     * Infection more likely to cross borders if the Country is land locked
     */
    private static final double LAND_LOCKED_PENALTY = 0.5;

    /**
     * The threshold of a connected Country that triggers a border close
     */
    private static final double BORDER_CLOSE_THRESHOLD = 0.75;

    /**
     * Create a Country with a given name, population size, heat, dampness, and array of connections
     *
     * @param name            the name of the Country
     * @param continentCode          the code of the continent it belongs to
     * @param connectionNames the array of connected Country objects
     * @param population      the total population size (in millions)
     * @param heat            the heat (out of 1.0)
     * @param dampness        the dampness (out of 1.0)
     * @param wealth          the wealth (out of 1.0)
     */
    public LandLockedCountry(String name, int continentCode, String[] connectionNames, double population,
                             double heat, double dampness, double wealth) {
        super(name, continentCode, connectionNames, new String[]{}, population, heat, dampness, wealth);
    }

    /**
     * Advance the Country Epoch. Should result in spreading the infection both internally
     * and potentially externally
     *
     * @param symptoms the list of Symptom objects to apply to infectivity
     */
    @Override
    public void nextEpoch(List<Symptom> symptoms) {
        if (this.infectedPopulation > 0) {
            // Infection can be spread
            this.spreadInternally(symptoms);
            this.spreadByLand();
        }

        this.closeBorders();
    }

    /**
     * Both LandLocked and Coastal Country objects can spread the infection over land.
     * LandLocked Countries face a penalty where it is extra likely to spread by land
     * (Logically this is because people only travel by land rather than air/sea)
     */
    private void spreadByLand() {
        if (this.landConnections.size() > 0) {
            if (this.infectedPercentage > LAND_THRESHOLD * LAND_LOCKED_PENALTY) {
                // Enough people infected to cross border
                if (RANDOM.nextDouble() < this.externalSpreadChance) {
                    // Infection spreads to another Country by land
                    int connectionIndex = RANDOM.nextInt(this.landConnections.size());
                    this.infect(this.landConnections.get(connectionIndex));
                }
            }
        }
    }

    /**
     * Start the infection by infecting a single member of the population
     */
    @Override
    public void startInfection() {
        if (this.infectedPopulation == 0) {
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
        if (this.isConnectedByLand(target)) {
            target.startInfection();
        }
    }

    /**
     * Spread the infection internally
     *
     * @param symptoms the list of symptoms
     */
    @Override
    public void spreadInternally(List<Symptom> symptoms) {
        double infectedIncrease = (this.population - this.infectedPopulation)
                * this.internalSpreadChance;
        double minimumIncrease = MINIMUM_INFECTION_MULTIPLIER * this.getPopulation()
                / LAND_LOCKED_PENALTY;
        if (infectedIncrease < minimumIncrease) {
            infectedIncrease = minimumIncrease;
        }

        this.setInfectedPopulation((int) (this.infectedPopulation + infectedIncrease));
    }

    /**
     * Closes the land borders, decreasing chance of spread, controllable by player.
     * Land Locked Countries are less likely to close the border until threat is higher.
     * Wealthier countries close borders earlier.
     * Land Locked Countries close borders based on neighboring countries being infected
     */
    @Override
    public void closeBorders() {
        if (this.bordersOpen) {
            boolean imminentThreat =
                    this.isConnectedToInfectedCountry(BORDER_CLOSE_THRESHOLD);
            if (Math.random() <= this.wealth) {
                // Wealthy nations are more likely to close borders since they detect it
                this.bordersOpen = !imminentThreat;
            }
        }
    }

}
