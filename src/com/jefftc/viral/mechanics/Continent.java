package com.jefftc.viral.mechanics;

import java.util.ArrayList;
import java.util.List;

/**
 * A Continent is a collection of Country objects
 */
public class Continent {

    private String name;
    private List<Country> countries;

    /**
     * Create a Continent with a name and given list of Country objects
     *
     * @param name the name of the Continent
     * @param countries the list of Country objects
     */
    public Continent(String name, List<Country> countries) {
        this.name = name;
        this.countries = countries;
    }

    /**
     * Check if every Country in the Continent is entirely infected
     *
     * @return if there are any healthy people
     */
    public boolean isAllInfected() {
        for (Country country : this.countries) {
            if (country.hasHealthPeople()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Add a Country to the Continent
     *
     * @param country the Country to add
     */
    public void addCountry(Country country) {
        this.countries.add(country);
    }

    /**
     * Gets a list of Country objects that are healthy
     *
     * @return a list of healthy Country objects
     */
    public List<Country> getHealthyCountries() {
        List<Country> healthy = new ArrayList<>();
        for (Country country : this.countries) {
            if (country.getInfectedPopulation() == 0) {
                healthy.add(country);
            }
        }
        return healthy;
    }

    /**
     * Gets a list of Country objects that are infected
     *
     * @return a list of infected Country objects
     */
    public List<Country> getInfectedCountries() {
        List<Country> infected = new ArrayList<>();
        for (Country country : this.countries) {
            if (country.getInfectedPopulation() > 0) {
                infected.add(country);
            }
        }
        return infected;
    }

    /**
     * Get the total infected population from all the Country objects
     *
     * @return the total infected population
     */
    public double getInfectedPopulation() {
        List<Country> infectedCountries = this.getInfectedCountries();
        if (infectedCountries.size() == 0) {
            return 0.0;
        }

        double totalInfected = 0.0;
        for (Country country : infectedCountries) {
            totalInfected += country.getInfectedPopulation();
        }

        return totalInfected;
    }

    /**
     * Get the infected percentage from all the Country objects
     *
     * @return the infected percentage for the Continent
     */
    public double getInfectedPercentage() {
        List<Country> infectedCountries = this.getInfectedCountries();
        if (infectedCountries.size() == 0) {
            return 0.0;
        }

        double totalInfected = 0.0;
        double totalPopulation = 0.0;
        for (Country country : infectedCountries) {
            totalInfected += country.getInfectedPopulation();
            totalPopulation += country.getPopulation();
        }

        return (totalInfected / totalPopulation);
    }

    /* GETTERS AND SETTERS */

    public String getName() {
        return this.name;
    }

}
