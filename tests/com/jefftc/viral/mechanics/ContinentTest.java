package com.jefftc.viral.mechanics;

import com.jefftc.viral.countries.CoastalCountry;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ContinentTest {

    private static final int MAX_POPULATION = 2000000000;

    private static final double NEW_ZEALAND_POPULATION = 4.7;
    private static final double NEW_ZEALAND_HEAT = 0.55;
    private static final double NEW_ZEALAND_DAMPNESS = 0.5;
    private static final double NEW_ZEALAND_WEALTH = 0.8;

    private Continent continent;

    /**
     * Reset all variables before each test
     */
    @Before
    public void reset() {
        this.continent = new Continent(
                "Name",
                Arrays.asList(new Country[]{
                        new CoastalCountry("New Zealand", 0,
                                new String[]{
                                },
                                new String[]{
                                },
                                NEW_ZEALAND_POPULATION, NEW_ZEALAND_HEAT, NEW_ZEALAND_DAMPNESS, NEW_ZEALAND_WEALTH
                        ),
                })
        );
    }

    /**
     * Check getting the list of healthy countries
     */
    @Test
    public void getHealthyCountriesTest() {
        assertEquals(1, this.continent.getHealthyCountries().size());
        assertEquals("New Zealand", this.continent.getHealthyCountries().get(0).getName());
    }

    /**
     * Test getting the list of healthy countries when there are none
     */
    @Test
    public void getHealthyCountriesNoneTest() {
        this.continent.getHealthyCountries().get(0).setInfectedPopulation(MAX_POPULATION);
        assertEquals(0, this.continent.getHealthyCountries().size());
    }

    /**
     * Test getting the list of infected countries
     */
    @Test
    public void getInfectedCountriesTest() {
        this.continent.getHealthyCountries().get(0).setInfectedPopulation(MAX_POPULATION);
        assertEquals(1, this.continent.getInfectedCountries().size());
        assertEquals("New Zealand", this.continent.getInfectedCountries().get(0).getName());
    }

    /**
     * Test getting the list of infected countries when there are none
     */
    @Test
    public void getInfectedCountriesNoneTest() {
        assertEquals(0, this.continent.getInfectedCountries().size());
    }

    /**
     * Check if infecting everyone in a continent allows it to be considered all infected
     */
    @Test
    public void isAllInfectedTest() {
        this.continent.getHealthyCountries().get(0).setInfectedPopulation(MAX_POPULATION);
        assertTrue(this.continent.isAllInfected());
    }

    /**
     * Test getting the infected population of the continent
     */
    @Test
    public void getInfectedPopulationTest() {
        this.continent.getHealthyCountries().get(0).setInfectedPopulation(MAX_POPULATION);
        assertEquals(this.continent.getInfectedCountries().get(0).getPopulation(),
                this.continent.getInfectedPopulation(), 0.01);
    }

    /**
     * Test getting the infected population when there are zero infected people
     */
    @Test
    public void getInfectedPopulationNoneTest() {
        assertEquals(0.0, this.continent.getInfectedPopulation(), 0.01);
    }

    /**
     * Test getting the infected percentage of the continent
     */
    @Test
    public void getInfectedPercentageTest() {
        this.continent.getHealthyCountries().get(0).setInfectedPopulation(MAX_POPULATION);
        assertEquals(1.0, this.continent.getInfectedPercentage(), 0.01);
    }

    /**
     * Test getting the infected percentage when there are zero infected people
     */
    @Test
    public void getInfectedPercentageNoneTest() {
        assertEquals(0.0, this.continent.getInfectedPercentage(), 0.01);
    }

}