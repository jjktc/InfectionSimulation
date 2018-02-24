package com.jefftc.viral.mechanics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A Country is an abstract base class that determines how the infection spreads with different
 * actions available at different types of locations
 */
public abstract class Country {

    protected static final int INITIAL_INFECTION_COUNT = 1;
    protected static final double HEAT_INFECTIOUSNESS = 0.01;
    protected static final double DAMPNESS_INFECTIOUSNESS = 0.025;

    private String name;
    private int population;
    private int infectedPopulation;
    private double infectedPercentage;
    private double heat;
    private double dampness;

    private double internalSpreadChance;

    private String[] connectionNames;
    private List<Country> connections = new ArrayList<>();

    /**
     * Create a Country with a given name, population size, heat, dampness, and array of connections
     *
     * @param name the name of the Country
     * @param connectionNames the array of connected Country objects
     * @param population the total population size
     * @param heat the heat (out of 1.0)
     * @param dampness the dampness (out of 1.0)
     */
    public Country(String name, String[] connectionNames, int population, double heat, double dampness) {
        this.name = name;
        this.connectionNames = connectionNames;
        this.population = population;
        this.heat = heat;
        this.dampness = dampness;
    }

    /**
     * Initialize the Country properties
     *
     * @param allCountries the map of all the Country objects
     */
    public void init(HashMap<String, Country> allCountries) {
        for (String name : this.connectionNames) {
            if (allCountries.containsKey(name)) {
                this.connections.add(allCountries.get(name));
            }
        }
        this.internalSpreadChance = (heat * HEAT_INFECTIOUSNESS + dampness * DAMPNESS_INFECTIOUSNESS);
    }

    /**
     * Check if two Country objects are connected
     *
     * @param target the target Country
     * @return if the countries are connected
     */
    public boolean isConnected(Country target) {
        for (Country connection : this.connections) {
            if (connection.getName().equals(target.getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Increase the number of people infected
     *
     * @param amount the amount to increase by
     */
    public void increaseInfectedPopulation(int amount) {
        int increaseAmount = amount;
        if (amount == 0) {
            increaseAmount++;
        }
        this.infectedPopulation += increaseAmount;
        this.setInfectedPopulation(this.infectedPopulation + increaseAmount);
    }

    /**
     * Advance the Country Epoch. Should result in spreading the infection both internally
     * and potentially externally
     */
    public abstract void nextEpoch();

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
     */
    public abstract void spreadInternally();

    /* GETTERS AND SETTERS */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
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
    }

    public double getInfectedPercentage() {
        return infectedPercentage;
    }

    public void setInfectedPercentage(double infectedPercentage) {
        this.infectedPercentage = infectedPercentage;
    }

    public double getHeat() {
        return heat;
    }

    public void setHeat(double heat) {
        this.heat = heat;
    }

    public double getDampness() {
        return dampness;
    }

    public void setDampness(double dampness) {
        this.dampness = dampness;
    }

    public String[] getConnectionNames() {
        return connectionNames;
    }

    public void setConnectionNames(String[] connectionNames) {
        this.connectionNames = connectionNames;
    }

    public List<Country> getConnections() {
        return connections;
    }

    public void setConnections(List<Country> connections) {
        this.connections = connections;
    }

    public double getInternalSpreadChance() {
        return internalSpreadChance;
    }

    public void setInternalSpreadChance(double internalSpreadChance) {
        this.internalSpreadChance = internalSpreadChance;
    }
}
