package com.jefftc.viral.mechanics;

import com.jefftc.viral.ViralSimulation;

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
    private static final double HEAT_INFECTIOUSNESS = 0.2;
    private static final double DAMPNESS_INFECTIOUSNESS = 0.1;
    private static final double WEALTH_INFECTIOUSNESS = 0.4;
    protected static final double MINIMUM_INFECTION_MULTIPLIER = 0.005;

    /**
     * Thresholds before disease can jump borders
     */
    protected static final double NON_LAND_THRESHOLD = 0.4;
    protected static final double LAND_THRESHOLD = 0.2;

    protected static final Random RANDOM = new Random();

    protected ViralSimulation simulation;
    private HashMap<String, Country> countryMap;

    private String name;
    private int continentCode;
    protected int population;
    protected int infectedPopulation;
    protected double infectedPercentage;
    private double heat;
    private double dampness;
    protected double wealth;

    private double internalSpreadMultiplier;
    private double externalSpreadMultiplier;
    protected double internalSpreadChance;
    protected double externalSpreadChance;

    private String[] landConnectionNames;
    private String[] nonLandConnectionNames;
    protected List<Country> landConnections = new ArrayList<>();
    protected List<Country> nonLandConnections = new ArrayList<>();

    protected boolean bordersOpen = true;

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
    public Country(String name, int continentCode, String[] landConnectionNames,
                   String[] nonLandConnectionNames, double population, double heat, double dampness,
                   double wealth) {
        this.name = name;
        this.continentCode = continentCode;
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
     * @param simulation   the simulation object
     */
    public void init(HashMap<String, Country> allCountries, ViralSimulation simulation) {
        this.simulation = simulation;
        this.countryMap = allCountries;
        this.addConnections(this.landConnections, this.landConnectionNames);
        this.addConnections(this.nonLandConnections, this.nonLandConnectionNames);

        this.calculateMultipliers();
    }

    /**
     * Check for the existence of the connection names and then add them to the list of connections
     *
     * @param destination     the list to add connections to
     * @param connectionNames the array of Country names
     */
    private void addConnections(List<Country> destination, String[] connectionNames) {
        for (String name : connectionNames) {
            String lowerName = name.toLowerCase();
            if (this.countryMap.containsKey(lowerName)) {
                destination.add(this.countryMap.get(lowerName));
            }
        }
    }

    /**
     * Heat and dampness increase chance of spread (due to factors like parasitic insects)
     * Poverty increases the chance of spread as well (due to lack of preventative measures)
     */
    private void calculateMultipliers() {
        this.internalSpreadMultiplier = (
                heat * HEAT_INFECTIOUSNESS
                        + dampness * DAMPNESS_INFECTIOUSNESS
                        + (1.0 - this.wealth) * WEALTH_INFECTIOUSNESS
        );

        this.externalSpreadMultiplier = this.internalSpreadMultiplier;
        this.internalSpreadMultiplier /= LAND_THRESHOLD;
    }

    /**
     * Apply the infection multiplier from the symptoms
     */
    protected void applySymptoms() {
        for (Symptom symptom : this.simulation.getSymptoms()) {
            internalSpreadMultiplier += symptom.getInfectivity(this.heat, this.dampness, this.wealth);
        }
    }

    /**
     * Check if two Country objects are connected by land transport
     *
     * @param target the target Country
     * @return if the countries are connected
     */
    protected boolean isConnectedByLand(Country target) {
        if (target == null) {
            return false;
        }

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
    protected boolean isConnectedByNonLand(Country target) {
        if (target == null) {
            return false;
        }

        for (Country connection : this.nonLandConnections) {
            if (connection.getName().equals(target.getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get if the Country is connected to an infected Country with a percentage over the threshold
     *
     * @param threshold the point to determine if it is infected
     * @return if there is an infected connection
     */
    protected boolean isConnectedToInfectedCountry(double threshold) {
        return this.isConnectedToInfection(this.landConnections, threshold)
                || this.isConnectedToInfection(this.nonLandConnections, threshold);
    }

    /**
     * Get if the Country is connected to an infected Country by a list of connections
     *
     * @param connections the list of connections
     * @param threshold   the threshold to determine if it is infected
     * @return if there is an infected connection
     */
    private boolean isConnectedToInfection(List<Country> connections, double threshold) {
        for (Country connection : connections) {
            if (connection.infectedPercentage > threshold) {
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
    public boolean hasHealthPeople() {
        return this.infectedPopulation < this.population;
    }

    /**
     * Spread to a random healthy connected Country
     *
     * @param connections the list of connections
     */
    protected void spreadToHealthyCountry(List<Country> connections) {
        Continent connectionContinent = new Continent("", connections);
        List<Country> healthyCountries = connectionContinent.getHealthyCountries();

        if (healthyCountries.size() > 0) {
            int connectionIndex = RANDOM.nextInt(healthyCountries.size());
            this.infect(healthyCountries.get(connectionIndex));
        }
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
     * Closes the borders, decreasing chance of spread, controllable by player. Country objects
     * will automatically do this if their neighboring countries become infected
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

    protected void setInfectedPopulation(int infectedPopulation) {
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

    public boolean isBorderOpen() {
        return bordersOpen;
    }

    public int getContinentCode() {
        return continentCode;
    }
}
