package com.jefftc.viral.mechanics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * A Country is an abstract base class that determines how the infection spreads with different
 * actions available at different types of locations
 */
public abstract class Country {

    protected static final int INITIAL_INFECTION_COUNT = 1;
    private static final int MILLION = 1000000;

    /**
     * Heat and dampness increase the chance of disease spread
     * Wealth decreases the chance of disease spread
     */
    private static final double HEAT_INFECTIOUSNESS = 0.1;
    private static final double DAMPNESS_INFECTIOUSNESS = 0.2;
    private static final double WEALTH_INFECTIOUSNESS = 0.3;
    protected static final double MINIMUM_INFECTION_MULTIPLIER = 0.005;

    /**
     * Thresholds before disease can jump borders
     */
    protected static final double NON_LAND_THRESHOLD = 0.33;
    protected static final double LAND_THRESHOLD = 0.2;

    /**
     * Deduction (multiplicative) on crossing borders if borders are closed
     */
    protected static final double BORDER_CLOSED_SPREAD_DEDUCTION = 0.25;

    protected static final Random RANDOM = new Random();

    protected String name;
    protected int population;
    protected int infectedPopulation;
    protected double infectedPercentage;
    protected double heat;
    protected double dampness;
    protected double wealth;

    protected double internalSpreadMultiplier;
    protected double externalSpreadMultiplier;
    protected double internalSpreadChance;
    protected double externalSpreadChance;

    protected String[] landConnectionNames;
    protected String[] nonLandConnectionNames;
    protected List<Country> landConnections = new ArrayList<>();
    protected List<Country> nonLandConnections = new ArrayList<>();

    protected boolean landBordersOpen = true;
    protected boolean nonLandBordersOpen = true;

    /**
     * Create a Country with a given name, population size, heat, dampness, and array of connections
     *
     * @param name                   the name of the Country
     * @param landConnectionNames    the array of connected Country objects via land
     * @param nonLandConnectionNames the array of connected Country objects via non-land
     * @param population             the total population size (in millions)
     * @param heat                   the heat (out of 1.0)
     * @param dampness               the dampness (out of 1.0)
     * @param wealth                 the wealth (out of 1.0)
     */
    public Country(String name, String[] landConnectionNames, String[] nonLandConnectionNames,
                   double population, double heat, double dampness, double wealth) {
        this.name = name;
        this.landConnectionNames = landConnectionNames;
        this.nonLandConnectionNames = nonLandConnectionNames;
        this.population = (int) (population * MILLION);
        this.heat = heat;
        this.dampness = dampness;
        this.wealth = wealth;
    }

    /**
     * Initialize the Country properties
     *
     * @param allCountries the map of all the Country objects
     */
    public void init(HashMap<String, Country> allCountries) {
        for (String name : this.landConnectionNames) {
            if (allCountries.containsKey(name)) {
                this.landConnections.add(allCountries.get(name));
            }
        }

        for (String name : this.nonLandConnectionNames) {
            if (allCountries.containsKey(name)) {
                this.nonLandConnections.add(allCountries.get(name));
            }
        }

        this.internalSpreadMultiplier = (
                heat * HEAT_INFECTIOUSNESS
                        + dampness * DAMPNESS_INFECTIOUSNESS
                        + (1.0 - this.wealth) * WEALTH_INFECTIOUSNESS);
        this.internalSpreadMultiplier /= LAND_THRESHOLD;
        this.externalSpreadMultiplier = this.internalSpreadMultiplier * NON_LAND_THRESHOLD;
    }

    /**
     * Check if two Country objects are connected by land transport
     *
     * @param target the target Country
     * @return if the countries are connected
     */
    public boolean isConnectedByLand(Country target) {
        for (Country connection : this.landConnections) {
            if (connection.getName().equals(target.getName())) {
                return true;
            }
        }

        return false;
    }

    /**
     * Check if two Country objects are connected by other than land transport
     *
     * @param target the target Country
     * @return if the countries are connected
     */
    public boolean isConnectedByNonLand(Country target) {
        for (Country connection : this.nonLandConnections) {
            if (connection.getName().equals(target.getName())) {
                return true;
            }
        }

        return false;
    }

    /**
     * Check if the Country is 100% infected
     *
     * @return if the Country is infected entirely
     */
    public boolean isCompletelyInfected() {
        return this.infectedPopulation == this.population;
    }

    /**
     * Advance the Country Epoch. Should result in spreading the infection both internally
     * and potentially externally
     *
     * @param symptoms the list of Symptom objects to apply to infectivity
     */
    public abstract void nextEpoch(List<Symptom> symptoms);

    /**
     * Start the infection by infecting a single member of the population
     */
    public abstract void startInfection();

    /**
     * Infect a specified Country. Must be connected
     *
     * @param target the Country to infect
     */
    public abstract void infect(Country target);

    /**
     * Spread the infection internally
     *
     * @param symptoms the list of symptoms
     */
    public abstract void spreadInternally(List<Symptom> symptoms);

    /**
     * Closes the borders, decreasing chance of spread, controllable by player
     */
    public abstract void closeBorders();

    /* GETTERS AND SETTERS */

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public int getInfectedPopulation() {
        return infectedPopulation;
    }

    public void setInfectedPopulation(int infectedPopulation) {
        this.infectedPopulation = infectedPopulation;
        if (this.infectedPopulation > this.population) {
            this.infectedPopulation = this.population;
        }
        this.infectedPercentage = ((double) this.infectedPopulation / (double) this.population);
        this.internalSpreadChance = this.internalSpreadMultiplier * (this.infectedPercentage);
        this.externalSpreadChance = this.externalSpreadMultiplier * (this.infectedPercentage);
    }

    public double getInfectedPercentage() {
        return infectedPercentage;
    }

}
