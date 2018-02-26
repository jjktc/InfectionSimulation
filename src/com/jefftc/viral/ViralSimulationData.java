package com.jefftc.viral;

import com.jefftc.engine.Command;
import com.jefftc.viral.countries.CoastalCountry;
import com.jefftc.viral.countries.LandLockedCountry;
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
                    "Greenland",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "Canada",
                    new String[]{
                            "United States of America",
                    },
                    new String[]{

                    },
                    36.0, 0.25, 0.3, 0.8
            ),
            new CoastalCountry(
                    "United States of America",
                    new String[]{
                            "Canada",
                            "Mexico"
                    },
                    new String[]{

                    },
                    323.0, 0.75, 0.75, 0.9
            ),
            new CoastalCountry(
                    "Mexico",
                    new String[]{
                            "United States of America",
                    },
                    new String[]{

                    },
                    128.0, 0.85, 0.4, 0.4
            ),
            new CoastalCountry(
                    "Cuba",
                    new String[]{

                    },
                    new String[]{

                    },
                    128.0, 0.85, 0.4, 0.4
            ),
            new CoastalCountry(
                    "Dominican Republic",
                    new String[]{

                    },
                    new String[]{

                    },
                    128.0, 0.85, 0.4, 0.4
            ),
            new CoastalCountry(
                    "Puerto Rico",
                    new String[]{

                    },
                    new String[]{

                    },
                    128.0, 0.85, 0.4, 0.4
            ),
            new CoastalCountry(
                    "Guatemala",
                    new String[]{

                    },
                    new String[]{

                    },
                    128.0, 0.85, 0.4, 0.4
            ),
            new CoastalCountry(
                    "Honduras",
                    new String[]{

                    },
                    new String[]{

                    },
                    128.0, 0.85, 0.4, 0.4
            ),
            new CoastalCountry(
                    "Nicaragua",
                    new String[]{

                    },
                    new String[]{

                    },
                    128.0, 0.85, 0.4, 0.4
            ),
            new CoastalCountry(
                    "Costa Rica",
                    new String[]{

                    },
                    new String[]{

                    },
                    128.0, 0.85, 0.4, 0.4
            ),
            new CoastalCountry(
                    "Panama",
                    new String[]{

                    },
                    new String[]{

                    },
                    128.0, 0.85, 0.4, 0.4
            ),
            // South America
            new CoastalCountry(
                    "Colombia",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "Venezuela",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "Ecuador",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "Peru",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "Brazil",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Bolivia",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Paraguay",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Uruguay",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "Chile",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "Argentina",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            // Europe
            new CoastalCountry(
                    "Iceland",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "Ireland",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "United Kingdom",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "Norway",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "Sweden",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "Finland",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "Denmark",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "Germany",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "Belarus",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "France",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "Spain",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "Portugal",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "Italy",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Austria",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Romania",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "Greece",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Ukraine",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            // Asia
            new CoastalCountry(
                    "Russia",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "Turkey",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Syria",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Iraq",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Iran",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Israel",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "Saudi Arabia",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Yemen",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "Iceland",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "Oman",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Kazakhstan",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Uzbekistan",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Kyrgyzstan",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Afghanistan",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Pakistan",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "India",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Nepal",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "China",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Mongolia",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "Korea",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "Japan",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Myanmar",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "Thailand",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "Vietnam",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "Philippines",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "Malaysia",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "Indonesia",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "Papua New Guinea",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            // Australia
            new CoastalCountry(
                    "Australia",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "New Zealand",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            // Africa
            new CoastalCountry(
                    "Morocco",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "Algeria",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "Tunisia",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "Libya",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "Egypt",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Western Sahara",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Mauritania",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Mali",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Niger",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Chad",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Sudan",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Eritrea",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Guinea",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "Ghana",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Nigeria",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Cameroon",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Central African Republic",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "South Sudan",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Ethiopia",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "Somalia",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Gabon",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "DR Congo",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Uganda",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Kenya",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Angola",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Rwanda",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Tanzania",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Zambia",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Malawi",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Mozambique",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Namibia",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Botswana",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Zimbabwe",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "South Africa",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new LandLockedCountry(
                    "Swaziland",
                    new String[]{

                    },
                    0, 0, 0, 0
            ),
            new CoastalCountry(
                    "Madagascar",
                    new String[]{

                    },
                    new String[]{

                    },
                    0, 0, 0, 0
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
