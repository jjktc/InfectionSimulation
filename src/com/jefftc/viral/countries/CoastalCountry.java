package com.jefftc.viral.countries;

import com.jefftc.viral.mechanics.Continent;
import com.jefftc.viral.mechanics.Country;
import com.jefftc.viral.mechanics.Symptom;

import java.util.List;

/**
 * CoastalCountry is a type of Country that can pass the infection over air or water as well as land
 */
public class CoastalCountry extends Country {

    /**
     * The threshold of a connected Country that triggers a border close
     */
    private static final double BORDER_CLOSE_THRESHOLD = 0.5;

    /**
     * Chance of spreading when the border is closed
     */
    private static final double SPREAD_OVER_CLOSED_BORDER_CHANCE = 0.2;

    /**
     * Create a Country with a given name, population size, heat, dampness, and array of connections
     *
     * @param name                   the name of the Country
     * @param continentCode          the code of the continent it belongs to
     * @param landConnectionNames    the array of connected Country objects via land
     * @param nonLandConnectionNames the array of connected Country objects via non-land
     * @param population             the total population size (in millions)
     * @param heat                   the heat (out of 1.0)
     * @param dampness               the dampness (out of 1.0)
     * @param wealth                 the wealth (out of 1.0)
     */
    public CoastalCountry(String name, int continentCode, String[] landConnectionNames,
                          String[] nonLandConnectionNames, double population, double heat,
                          double dampness, double wealth) {
        super(name, continentCode, landConnectionNames, nonLandConnectionNames, population, heat,
                dampness, wealth);
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
            this.spreadByAir();
        }

        this.closeBorders();
    }

    /**
     * Both LandLocked and Coastal Country objects can spread the infection over land
     */
    private void spreadByLand() {
        if (this.landConnections.size() > 0) {
            if (this.infectedPercentage > LAND_THRESHOLD) {
                // Enough people infected to cross border
                if (RANDOM.nextDouble() < this.externalSpreadChance) {
                    // Infection spreads to another Country by land
                    this.spreadToHealthyCountry(this.landConnections);
                }
            }
        }
    }

    /**
     * Only Coastal Country objects can spread the infection by means other than land (ie planes/boats)
     */
    private void spreadByAir() {
        if (this.bordersOpen || Math.random() < SPREAD_OVER_CLOSED_BORDER_CHANCE) {
            // Unlike a Land border, non-land borders can be closed effectively to prevent spread
            if (this.nonLandConnections.size() > 0) {
                if (this.infectedPercentage > NON_LAND_THRESHOLD) {
                    // Enough people infected to cross border
                    if (RANDOM.nextDouble() < this.externalSpreadChance) {
                        // Infection spreads to another Country by air/sea
                        this.spreadToHealthyCountry(this.nonLandConnections);
                    }
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
            this.applySymptoms();
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
        if (this.isConnectedByLand(target) || this.isConnectedByNonLand(target)) {
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
        double minimumIncrease = MINIMUM_INFECTION_MULTIPLIER * this.getPopulation();
        if (infectedIncrease < minimumIncrease) {
            infectedIncrease = minimumIncrease;
        }

        this.setInfectedPopulation((int) (this.infectedPopulation + infectedIncrease));
    }

    /**
     * Closes the borders, decreasing chance of spread, controllable by player.
     * Coastal Country objects are more aggressive with border closing due to higher risk of spread.
     * Wealthy countries close borders earlier.
     * Coastal Countries close borders based on the overall world state
     */
    @Override
    public void closeBorders() {
        if (this.bordersOpen) {
            boolean imminentThreat =
                    this.simulation.getTotalInfectedPercentage() > BORDER_CLOSE_THRESHOLD;
            if (Math.random() < this.wealth) {
                // Wealthy nations are more likely to close borders since they detect it
                this.bordersOpen = !imminentThreat;
            }
        }
    }

}
