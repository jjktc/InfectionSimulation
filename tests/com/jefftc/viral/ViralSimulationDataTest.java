package com.jefftc.viral;

import com.jefftc.engine.InputLayer;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

public class ViralSimulationDataTest {

    /**
     * Initialize the country lists
     */
    @BeforeClass
    public static void setup() {
        ViralSimulationData.init(new ViralSimulation(new InputLayer(false)));
    }

    /**
     * Find a country by its name
     */
    @Test
    public void findCountryTest() {
        assertEquals("United States of America",
                Objects.requireNonNull(ViralSimulationData.findCountry("United States of America")).getName());
    }

    /**
     * Test finding a country by its name with incorrect case
     */
    @Test
    public void findCountryCaseInsensitiveTest() {
        assertEquals("United States of America",
                Objects.requireNonNull(ViralSimulationData.findCountry("united states of AMERICA")).getName());
    }

    /**
     * Test finding a country that does not exist
     */
    @Test
    public void findCountryDNETest() {
        assertNull(ViralSimulationData.findCountry("pluto"));
    }

    /**
     * Test finding a country with an empty name
     */
    @Test
    public void findCountryEmptyTest() {
        assertNull(ViralSimulationData.findCountry(""));
    }

}