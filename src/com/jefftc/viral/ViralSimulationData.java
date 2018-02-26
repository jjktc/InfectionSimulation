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

public class ViralSimulationData {

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
     */
    public static void init() {
        Arrays.sort(ViralSimulationCountries.COUNTRIES, Comparator.comparing(Country::getName));
        HashMap<String, Country> countryMap = new HashMap<>();

        for (Country country : ViralSimulationCountries.COUNTRIES) {
            countryMap.put(country.getName(), country);
        }

        for (Country country : ViralSimulationCountries.COUNTRIES) {
            country.init(countryMap);
        }
    }

    /**
     * Get a Country object from the given name
     *
     * @param name the name of the Country
     * @return the Country object matching the name
     */
    public static Country findCountry(String name) {
        for (Country country : ViralSimulationCountries.COUNTRIES) {
            if (country.getName().equalsIgnoreCase(name)) {
                return country;
            }
        }

        return null;
    }

}
