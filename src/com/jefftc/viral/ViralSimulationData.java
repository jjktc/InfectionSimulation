package com.jefftc.viral;

import com.jefftc.engine.Command;
import com.jefftc.viral.mechanics.Country;
import com.jefftc.viral.mechanics.Symptom;
import com.jefftc.viral.symptoms.Cough;
import com.jefftc.viral.symptoms.Fever;
import com.jefftc.viral.symptoms.RunnyNose;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Class containing all the public data for Viral Simulations
 */
public class ViralSimulationData {

    public static final int CMD_QUIT = 0;
    public static final int CMD_INFO = 1;

    private static HashMap<String, Country> countryMap;

    /**
     * Array of Command objects available to the user
     */
    public static final Command[] COMMANDS = new Command[]{
            new Command(new String[]{
                    "quit", "exit", "leave", "abandon", "stop"
            }, false),
            new Command(new String[]{
                    "info", "status"
            }, true)
    };

    /**
     * Array of all of the Symptoms
     */
    public static final Symptom[] SYMPTOMS = new Symptom[]{
            new Cough(),
            new Fever(),
            new RunnyNose()
    };

    /**
     * Initialize the data for ViralSimulation
     *
     * @param simulation the simulation object
     */
    public static void init(ViralSimulation  simulation) {
        Arrays.sort(ViralSimulationCountries.COUNTRIES, Comparator.comparing(Country::getName));
        countryMap = new HashMap<>();

        for (Country country : ViralSimulationCountries.COUNTRIES) {
            countryMap.put(country.getName().toLowerCase(), country);
            addToCountryList(country);
        }

        for (Country country : ViralSimulationCountries.COUNTRIES) {
            country.init(countryMap, simulation);
        }
    }

    /**
     * Add a country to the static country lists based on continent
     *
     * @param country the country to add
     */
    private static void addToCountryList(Country country) {
        ViralSimulationCountries.continents[country.getContinentCode()].addCountry(country);
    }

    /**
     * Get a Country object from the given name
     *
     * @param name the name of the Country
     * @return the Country object matching the name
     */
    public static Country findCountry(String name) {
        String lowerName = name.toLowerCase();
        if (countryMap.containsKey(lowerName)) {
            return countryMap.get(lowerName);
        }

        return null;
    }

}
