package com.jefftc.viral;

import com.jefftc.engine.Command;
import com.jefftc.viral.countries.CoastalCountry;
import com.jefftc.viral.mechanics.Country;
import com.jefftc.viral.mechanics.Symptom;
import com.jefftc.viral.symptoms.Cough;
import com.jefftc.viral.symptoms.Fever;
import com.jefftc.viral.symptoms.RunnyNose;

import java.util.HashMap;

public class ViralSimulationData {

    public static final Command[] COMMANDS = new Command[]{
            new Command(new String[]{
                    "quit", "exit", "leave", "abandon", "stop"
            }, false),
            new Command(new String[]{
                    "info", "status"
            }, true)
    };

    /**
     * Array of all of the Countries and their stats
     */
    public static final Country[] COUNTRIES = new Country[]{
            // North America
            new CoastalCountry(
                    "Canada",
                    new String[]{
                            "United States of America",
                    },
                    new String[]{

                    },
                    36.0,
                    0.25,
                    0.3,
                    0.8
            ),
            new CoastalCountry(
                    "United States of America",
                    new String[]{
                            "Canada",
                            "Mexico"
                    },
                    new String[]{

                    },
                    323.0,
                    0.75,
                    0.75,
                    0.9
            ),
            new CoastalCountry(
                    "Mexico",
                    new String[]{
                            "United States of America",
                    },
                    new String[]{

                    },
                    128.0,
                    0.85,
                    0.4,
                    0.4
            )
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
        HashMap<String, Country> countryMap = new HashMap<>();
        for (Country country : COUNTRIES) {
            countryMap.put(country.getName(), country);
        }

        for (Country country : COUNTRIES) {
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
        for (Country country : COUNTRIES) {
            if (country.getName().equalsIgnoreCase(name)) {
                return country;
            }
        }

        return null;
    }

}
