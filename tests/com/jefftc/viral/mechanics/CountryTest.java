package com.jefftc.viral.mechanics;

import com.jefftc.engine.InputLayer;
import com.jefftc.viral.ViralSimulation;
import com.jefftc.viral.ViralSimulationCountries;
import com.jefftc.viral.countries.CoastalCountry;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class CountryTest {

    private static Country[] countries = new Country[] {
            new CoastalCountry("Australia", ViralSimulationCountries.AUSTRALIA, new String[] {},
                    new String[] { "New Zealand" }, 24.1, 0.6, 0.4, 0.9),
            new CoastalCountry("New Zealand", ViralSimulationCountries.AUSTRALIA, new String[] {},
                    new String[] { "Australia" }, 4.7, 0.55, 0.5, 0.8),
            new CoastalCountry("Wakanda", ViralSimulationCountries.AFRICA, new String[] {}, new String[] {}, 0.5, 0.5,
                    0.5, 1.0) };

    /**
     * Prepare the country array
     */
    @BeforeClass
    public static void setup() {
        HashMap<String, Country> countryMap = new HashMap<>();
        ViralSimulation simulation = new ViralSimulation(new InputLayer(false));

        for (Country country : countries) {
            countryMap.put(country.getName().toLowerCase(), country);
        }

        for (Country country : countries) {
            country.init(countryMap, simulation);
        }
    }

    /**
     * Test checking if a given country is connected
     */
    @Test
    public void isConnectedTest() {
        assertTrue(countries[0].isConnectedByNonLand(countries[1]));
    }

    /**
     * Test checking if a given country is connected when it is not
     */
    @Test
    public void isConnectedNotConnectedTest() {
        assertFalse(countries[0].isConnectedByLand(countries[2]));
    }

    /**
     * Test checking if a given null country is connected
     */
    @Test
    public void isConnectedByLandNullTest() {
        assertFalse(countries[0].isConnectedByLand(null));
    }

    /**
     * Check if a country is connected to an infected country
     */
    @Test
    public void isConnectedToInfectedCountryTest() {
        assertFalse(countries[0].isConnectedToInfectedCountry(0.5));
    }

    /**
     * Check if a country has any healthy people
     */
    @Test
    public void hasHealthyPeopleTest() {
        assertTrue(countries[2].hasHealthPeople());
        countries[2].setInfectedPopulation(2000000000);
        assertFalse(countries[2].hasHealthPeople());
    }

}