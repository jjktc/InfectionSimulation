package com.jefftc.viral;

import com.jefftc.viral.countries.CoastalCountry;
import com.jefftc.viral.countries.LandLockedCountry;
import com.jefftc.viral.mechanics.Country;

import java.util.ArrayList;
import java.util.List;

/**
 * Class containing all of the Country data for the Viral Simulation
 */
public class ViralSimulationCountries {

    public static final int TOTAL_CONTINENTS = 6;
    public static final int NORTH_AMERICA = 0;
    public static final int SOUTH_AMERICA = 1;
    public static final int EUROPE = 2;
    public static final int ASIA = 3;
    public static final int AUSTRALIA = 4;
    public static final int AFRICA = 5;

    /**
     * Array of all of the Countries and their stats
     */
    public static final Country[] COUNTRIES = new Country[]{
            // North America
            new CoastalCountry("Greenland", NORTH_AMERICA,
                    new String[]{
                    },
                    new String[]{
                            "Canada", "United States of America", "Iceland"
                    },
                    0.056, 0.1, 0.2, 0.85
            ),
            new CoastalCountry("Canada", NORTH_AMERICA,
                    new String[]{
                            "United States of America"
                    },
                    new String[]{
                            "Greenland", "Iceland", "Russia"
                    },
                    36.0, 0.25, 0.3, 0.9
            ),
            new CoastalCountry("United States of America", NORTH_AMERICA,
                    new String[]{
                            "Canada", "Mexico"
                    },
                    new String[]{
                            "Greenland", "Iceland", "Cuba", "Puerto Rico", "France", "United Kingdom",
                            "Panama", "Russia", "China", "Japan", "Korea", "Australia", "Brazil",
                            "Argentina", "Italy", "Thailand", "Philippines", "Egypt", "New Zealand"
                    },
                    323.0, 0.75, 0.75, 1.0
            ),
            new CoastalCountry("Mexico", NORTH_AMERICA,
                    new String[]{
                            "United States of America", "Guatemala"
                    },
                    new String[]{
                            "Cuba", "Puerto Rico"
                    },
                    128.0, 0.85, 0.4, 0.4
            ),
            new CoastalCountry("Cuba", NORTH_AMERICA,
                    new String[]{
                    },
                    new String[]{
                            "United States of America", "Mexico", "Puerto Rico", "Guatemala"
                    },
                    11.5, 0.9, 0.6, 0.6
            ),
            new CoastalCountry("Puerto Rico", NORTH_AMERICA,
                    new String[]{
                    },
                    new String[]{
                            "United States of America", "Cuba", "Mexico"
                    },
                    3.4, 0.85, 0.6, 0.65
            ),
            new CoastalCountry("Guatemala", NORTH_AMERICA,
                    new String[]{
                            "Mexico", "Honduras"
                    },
                    new String[]{
                            "Cuba"
                    },
                    16.6, 0.85, 0.65, 0.3
            ),
            new LandLockedCountry("Honduras", NORTH_AMERICA,
                    new String[]{
                            "Guatemala", "Nicaragua"
                    },
                    9.1, 0.85, 0.7, 0.3
            ),
            new LandLockedCountry("Nicaragua", NORTH_AMERICA,
                    new String[]{
                            "Honduras", "Costa Rica"
                    },
                    6.15, 0.85, 0.7, 0.2
            ),
            new LandLockedCountry("Costa Rica", NORTH_AMERICA,
                    new String[]{
                            "Nicaragua", "Panama"
                    },
                    4.85, 0.85, 0.7, 0.4
            ),
            new CoastalCountry("Panama", NORTH_AMERICA,
                    new String[]{
                            "Costa Rica", "Colombia"
                    },
                    new String[]{
                            "United States of America"
                    },
                    4.0, 0.9, 0.8, 0.3
            ),
            // South America
            new LandLockedCountry("Colombia", SOUTH_AMERICA,
                    new String[]{
                            "Panama", "Venezuela", "Ecuador", "Brazil", "Peru"
                    },
                    48.65, 0.8, 0.75, 0.5
            ),
            new LandLockedCountry("Venezuela", SOUTH_AMERICA,
                    new String[]{
                            "Colombia", "Brazil"
                    },
                    31.6, 0.8, 0.75, 0.5
            ),
            new LandLockedCountry("Ecuador", SOUTH_AMERICA,
                    new String[]{
                            "Colombia", "Peru"
                    },
                    16.4, 0.75, 0.75, 0.4
            ),
            new LandLockedCountry("Peru", SOUTH_AMERICA,
                    new String[]{
                            "Colombia", "Ecuador", "Brazil", "Bolivia", "Chile"
                    },
                    31.8, 0.7, 0.7, 0.4
            ),
            new CoastalCountry("Brazil", SOUTH_AMERICA,
                    new String[]{
                            "Colombia", "Venezuela", "Peru", "Bolivia", "Paraguay", "Uruguay",
                            "Argentina", "South Africa"
                    },
                    new String[]{
                            "United States of America"
                    },
                    207.7, 0.6, 0.75, 0.5
            ),
            new LandLockedCountry("Bolivia", SOUTH_AMERICA,
                    new String[]{
                            "Peru", "Brazil", "Paraguay", "Argentina", "Chile"
                    },
                    10.9, 0.65, 0.75, 0.2
            ),
            new LandLockedCountry("Paraguay", SOUTH_AMERICA,
                    new String[]{
                            "Bolivia", "Brazil", "Argentina"
                    },
                    6.7, 0.65, 0.6, 0.3
            ),
            new LandLockedCountry("Uruguay", SOUTH_AMERICA,
                    new String[]{
                            "Brazil", "Argentina"
                    },
                    3.4, 0.6, 0.6, 0.4
            ),
            new LandLockedCountry("Chile", SOUTH_AMERICA,
                    new String[]{
                            "Peru", "Bolivia", "Argentina"
                    },
                    17.9, 0.7, 0.8, 0.4
            ),
            new CoastalCountry("Argentina", SOUTH_AMERICA,
                    new String[]{
                            "Chile", "Bolivia", "Paraguay", "Brazil", "Uruguay"
                    },
                    new String[]{
                            "United States of America"
                    },
                    43.85, 0.7, 0.8, 0.4
            ),
            // Europe
            new CoastalCountry("Iceland", EUROPE,
                    new String[]{
                    },
                    new String[]{
                            "United States of America", "Canada", "Greenland", "Ireland",
                            "United Kingdom", "Norway"
                    },
                    0.33, 0.1, 0.1, 0.95
            ),
            new CoastalCountry("Ireland", EUROPE,
                    new String[]{
                            "United Kingdom"
                    },
                    new String[]{
                            "Iceland", "Portugal", "Spain", "France"
                    },
                    4.8, 0.2, 0.15, 0.9
            ),
            new CoastalCountry("United Kingdom", EUROPE,
                    new String[]{
                            "Ireland"
                    },
                    new String[]{
                            "United States of America", "Portugal", "Spain", "France", "Germany",
                            "Denmark", "Norway", "Sweden", "China", "Italy"
                    },
                    65.6, 0.2, 0.15, 0.85
            ),
            new CoastalCountry("Norway", EUROPE,
                    new String[]{
                            "Sweden"
                    },
                    new String[]{
                            "United Kingdom", "Denmark", "Germany"
                    },
                    5.2, 0.1, 0.1, 1.0
            ),
            new CoastalCountry("Sweden", EUROPE,
                    new String[]{
                            "Norway", "Finland"
                    },
                    new String[]{
                            "United Kingdom"
                    },
                    9.9, 0.15, 0.2, 0.85
            ),
            new LandLockedCountry("Finland", EUROPE,
                    new String[]{
                            "Sweden", "Russia"
                    },
                    5.5, 0.15, 0.2, 0.8
            ),
            new CoastalCountry("Denmark", EUROPE,
                    new String[]{
                            "Germany"
                    },
                    new String[]{
                            "United Kingdom"
                    },
                    5.7, 0.3, 0.4, 0.75
            ),
            new CoastalCountry("Germany", EUROPE,
                    new String[]{
                            "Denmark", "France", "Poland", "Switzerland", "Austria"
                    },
                    new String[]{
                            "Norway", "United Kingdom"
                    }, 82.7, 0.45, 0.35, 0.7
            ),
            new LandLockedCountry("Switzerland", EUROPE,
                    new String[]{
                            "France", "Germany", "Italy", "Austria"
                    },
                    8.4, 0.2, 0.2, 1.0
            ),
            new LandLockedCountry("Poland", EUROPE,
                    new String[]{
                            "Germany", "Belarus", "Ukraine"
                    },
                    38.0, 0.3, 0.25, 0.4
            ),
            new LandLockedCountry("Belarus", EUROPE,
                    new String[]{
                            "Poland", "Russia", "Ukraine"
                    },
                    9.5, 0.35, 0.35, 0.3
            ),
            new CoastalCountry("France", EUROPE,
                    new String[]{
                            "Spain", "Germany", "Switzerland", "Italy"
                    },
                    new String[]{
                            "United States of America", "United Kingdom"
                    },
                    66.9, 0.5, 0.4, 0.6
            ),
            new CoastalCountry("Spain", EUROPE,
                    new String[]{
                            "Portugal", "France"
                    },
                    new String[]{
                            "United States of America", "United Kingdom", "Morocco", "Algeria"
                    },
                    46.7, 0.65, 0.5, 0.4
            ),
            new CoastalCountry("Portugal", EUROPE,
                    new String[]{
                            "Spain"
                    },
                    new String[]{
                            "United States of America", "United Kingdom", "Morocco"
                    },
                    10.3, 0.65, 0.5, 0.4
            ),
            new CoastalCountry("Italy", EUROPE,
                    new String[]{
                            "France", "Switzerland", "Austria"
                    },
                    new String[]{
                            "United States of America", "United Kingdom", "Algeria", "Tunisia",
                            "Libya", "Greece"
                    },
                    60.6, 0.7, 0.6, 0.55
            ),
            new LandLockedCountry("Austria", EUROPE,
                    new String[]{
                            "Germany", "Switzerland", "Italy"
                    },
                    8.75, 0.65, 0.5, 0.65
            ),
            new CoastalCountry("Romania", EUROPE,
                    new String[]{
                            "Ukraine"
                    },
                    new String[]{
                            "Turkey"
                    },
                    19.7, 0.65, 0.6, 0.3
            ),
            new LandLockedCountry("Bulgaria", EUROPE,
                    new String[]{
                            "Romania", "Greece", "Turkey"
                    },
                    7.1, 0.7, 0.6, 0.25
            ),
            new CoastalCountry("Greece", EUROPE,
                    new String[]{
                            "Bulgaria", "Turkey"
                    },
                    new String[]{
                            "Italy", "Libya", "Egypt"
                    },
                    10.75, 0.7, 0.75, 0.4
            ),
            new LandLockedCountry("Ukraine", EUROPE,
                    new String[]{
                            "Poland", "Belarus", "Russia", "Romania"
                    },
                    45.0, 0.6, 0.6, 0.15
            ),
            // Asia
            new CoastalCountry("Russia", ASIA,
                    new String[]{
                            "Finland", "Belarus", "Ukraine", "Kazakhstan", "Mongolia", "China"
                    },
                    new String[]{
                            "United States of America", "Canada"
                    },
                    144.3, 0.1, 0.2, 0.2
            ),
            new CoastalCountry("Turkey", ASIA,
                    new String[]{
                            "Bulgaria", "Greece", "Syria", "Iraq", "Iran"
                    },
                    new String[]{
                            "Egypt"
                    },
                    79.5, 0.75, 0.4, 0.25
            ),
            new LandLockedCountry("Syria", ASIA,
                    new String[]{
                            "Turkey", "Iraq", "Israel"
                    },
                    18.4, 0.75, 0.5, 0.15
            ),
            new LandLockedCountry("Iraq", ASIA,
                    new String[]{
                            "Syria", "Turkey", "Iran", "Saudi Arabia"
                    },
                    37.2, 0.8, 0.4, 0.25
            ),
            new LandLockedCountry("Iran", ASIA,
                    new String[]{
                            "Turkey", "Iraq", "Turkmenistan", "Afghanistan", "Pakistan"
                    },
                    80.3, 0.8, 0.4, 0.3
            ),
            new LandLockedCountry("Israel", ASIA,
                    new String[]{
                            "Syria", "Egypt"
                    },
                    8.5, 0.7, 0.4, 0.6
            ),
            new LandLockedCountry("Saudi Arabia", ASIA,
                    new String[]{
                            "Egypt", "Iraq", "Iran", "Yemen", "Oman", "Egypt"
                    },
                    32.3, 0.85, 0.3, 0.45
            ),
            new LandLockedCountry("Yemen", ASIA,
                    new String[]{
                            "Saudi Arabia", "Oman"
                    },
                    27.6, 0.8, 0.3, 0.1
            ),
            new CoastalCountry("Oman", ASIA,
                    new String[]{
                            "Saudi Arabia", "Yemen"
                    },
                    new String[]{
                            "India", "Somalia"
                    },
                    4.4, 0.8, 0.3, 0.25
            ),
            new LandLockedCountry("Turkmenistan", ASIA,
                    new String[]{
                            "Kazakhstan", "Uzbekistan", "Iran", "Afghanistan", "Pakistan"
                    },
                    5.7, 0.75, 0.35, 0.15
            ),
            new LandLockedCountry("Uzbekistan", ASIA,
                    new String[]{
                            "Kazakhstan", "Turkmenistan", "Afghanistan", "Kyrgyzstan"
                    },
                    31.85, 0.75, 0.3, 0.1
            ),
            new LandLockedCountry("Kazakhstan", ASIA,
                    new String[]{
                            "Russia", "Turkmenistan", "Uzbekistan", "China", "Kyrgyzstan"
                    },
                    17.8, 0.7, 0.3, 0.2
            ),
            new LandLockedCountry("Kyrgyzstan", ASIA,
                    new String[]{
                            "Kazakhstan", "Uzbekistan", "China", "Tajikistan"
                    },
                    6.0, 0.75, 0.25, 0.1
            ),
            new LandLockedCountry("Tajikistan", ASIA,
                    new String[]{
                            "Uzbekistan", "Kyrgyzstan", "China"
                    },
                    8.7, 0.8, 0.25, 0.1
            ),
            new LandLockedCountry("Afghanistan", ASIA,
                    new String[]{
                            "Iran", "Turkmenistan", "Uzbekistan", "Tajikistan", "China", "Pakistan"
                    },
                    34.7, 0.9, 0.2, 0.0
            ),
            new LandLockedCountry("Pakistan", ASIA,
                    new String[]{
                            "Iran", "Afghanistan", "China", "India"
                    },
                    193.2, 0.9, 0.2, 0.1
            ),
            new CoastalCountry("India", ASIA,
                    new String[]{
                            "Pakistan", "China", "Nepal", "Bangladesh"
                    },
                    new String[]{
                            "Oman", "United States of America"
                    },
                    1324, 0.85, 0.2, 0.15
            ),
            new LandLockedCountry("Nepal", ASIA,
                    new String[]{
                            "China", "India", "Bangladesh"
                    },
                    29.0, 0.8, 0.2, 0.1
            ),
            new CoastalCountry("China", ASIA,
                    new String[]{
                            "India", "Pakistan", "Afghanistan", "Tajikistan", "Kyrgyzstan", "Kazakhstan",
                            "Mongolia", "Russia", "Korea", "Nepal", "Bangladesh", "Myanmar", "Laos",
                            "Vietnam", "Philippines"
                    },
                    new String[]{
                            "United States of America", "Japan"
                    },
                    1379, 0.6, 0.6, 0.25
            ),
            new LandLockedCountry("Mongolia", ASIA,
                    new String[]{
                            "Russia", "China"
                    },
                    3.0, 0.4, 0.4, 0.15
            ),
            new CoastalCountry("Korea", ASIA,
                    new String[]{
                            "China"
                    },
                    new String[]{
                            "United States of America", "Japan"
                    },
                    51.25, 0.75, 0.6, 0.7
            ),
            new CoastalCountry("Japan", ASIA,
                    new String[]{
                    },
                    new String[]{
                            "China", "Korea", "United States of America"
                    },
                    127.0, 0.7, 0.7, 0.85
            ),
            new LandLockedCountry("Bangladesh", ASIA,
                    new String[]{
                            "India", "Myanmar"
                    },
                    163.0, 0.7, 0.6, 0.1
            ),
            new LandLockedCountry("Myanmar", ASIA,
                    new String[]{
                            "Bangladesh", "China", "Laos", "Thailand"
                    },
                    52.9, 0.75, 0.8, 0.1
            ),
            new CoastalCountry("Thailand", ASIA,
                    new String[]{
                            "Myanmar", "Laos", "Vietnam", "Cambodia", "Malaysia"
                    },
                    new String[]{
                            "United States of America"
                    },
                    68.9, 0.7, 0.8, 0.25
            ),
            new LandLockedCountry("Laos", ASIA,
                    new String[]{
                            "Myanmar", "China", "Vietnam", "Cambodia"
                    },
                    6.8, 0.7, 0.75, 0.15
            ),
            new LandLockedCountry("Cambodia", ASIA,
                    new String[]{
                            "Thailand", "Laos", "Vietnam"
                    },
                    15.8, 0.75, 0.7, 0.1
            ),
            new CoastalCountry("Vietnam", ASIA,
                    new String[]{
                            "Cambodia", "Laos", "China"
                    },
                    new String[]{
                            "Philippines"
                    },
                    92.7, 0.7, 0.8, 0.2
            ),
            new CoastalCountry("Philippines", ASIA,
                    new String[]{
                    },
                    new String[]{
                            "Vietnam", "China", "Indonesia", "United States of America"
                    },
                    103.3, 0.6, 0.65, 0.25
            ),
            new LandLockedCountry("Malaysia", ASIA,
                    new String[]{
                            "Thailand", "Indonesia"
                    },
                    31.2, 0.7, 0.85, 0.35
            ),
            new CoastalCountry("Indonesia", ASIA,
                    new String[]{
                            "Malaysia", "Papua New Guinea"
                    },
                    new String[]{
                            "Philippines", "Australia"
                    },
                    261.1, 0.65, 0.85, 0.25
            ),
            new CoastalCountry("Papua New Guinea", ASIA,
                    new String[]{
                            "Indonesia"
                    },
                    new String[]{
                            "Australia"
                    },
                    8.1, 0.65, 0.85, 0.15
            ),
            // Australia
            new CoastalCountry("Australia", AUSTRALIA,
                    new String[]{
                    },
                    new String[]{
                            "Indonesia", "Papua New Guinea", "New Zealand", "United States of America"
                    },
                    24.1, 0.6, 0.4, 0.9
            ),
            new CoastalCountry("New Zealand", AUSTRALIA,
                    new String[]{
                    },
                    new String[]{
                            "Australia",
                            "United States of America"
                    },
                    4.7, 0.55, 0.5, 0.8
            ),
            // Africa
            new CoastalCountry("Morocco", AFRICA,
                    new String[]{
                            "Algeria", "Western Sahara"
                    },
                    new String[]{
                            "Portugal", "Spain"
                    },
                    35.3, 0.7, 0.2, 0.2
            ),
            new CoastalCountry("Algeria", AFRICA,
                    new String[]{
                            "Morocco", "Mauritania", "Tunisia", "Libya", "Niger", "Mali"
                    },
                    new String[]{
                            "Spain", "Italy"
                    },
                    40.6, 0.8, 0.15, 0.25
            ),
            new CoastalCountry("Tunisia", AFRICA,
                    new String[]{
                            "Algeria", "Libya"
                    },
                    new String[]{
                            "Italy"
                    },
                    11.4, 0.75, 0.4, 0.25
            ),
            new CoastalCountry("Libya", AFRICA,
                    new String[]{
                            "Tunisia", "Algeria", "Egypt", "Sudan", "Chad", "Niger"
                    },
                    new String[]{
                            "Italy", "Greece"
                    },
                    6.3, 0.75, 0.3, 0.3
            ),
            new CoastalCountry("Egypt", AFRICA,
                    new String[]{
                            "Libya", "Israel", "Sudan", "Saudi Arabia"
                    },
                    new String[]{
                            "Turkey", "United States of America", "Greece"
                    },
                    95.7, 0.85, 0.2, 0.25
            ),
            new LandLockedCountry("Western Sahara", AFRICA,
                    new String[]{
                            "Morocco", "Mauritania"
                    },
                    0.5, 0.8, 0.15, 0.15
            ),
            new LandLockedCountry("Mauritania", AFRICA,
                    new String[]{
                            "Western Sahara", "Algeria", "Mali"
                    },
                    4.3, 0.8, 0.1, 0.1
            ),
            new LandLockedCountry("Mali", AFRICA,
                    new String[]{
                            "Mauritania", "Algeria", "Niger", "Guinea"
                    },
                    18.0, 0.9, 0.1, 0.1
            ),
            new LandLockedCountry("Niger", AFRICA,
                    new String[]{
                            "Mali", "Algeria", "Libya", "Chad", "Nigeria"
                    },
                    20.7, 0.9, 0.2, 0.05
            ),
            new LandLockedCountry("Chad", AFRICA,
                    new String[]{
                            "Niger", "Libya", "Sudan", "Central African Republic", "Cameroon", "Nigeria"
                    },
                    14.5, 0.9, 0.8, 0.05
            ),
            new LandLockedCountry("Sudan", AFRICA,
                    new String[]{
                            "Libya", "Egypt", "Eritrea", "Ethiopia", "South Sudan",
                            "Central African Republic", "Chad"
                    },
                    39.6, 0.9, 0.5, 0.15
            ),
            new LandLockedCountry("Eritrea", AFRICA,
                    new String[]{
                            "Sudan", "Ethiopia"
                    },
                    4.5, 0.9, 0.8, 0.05
            ),
            new LandLockedCountry("Guinea", AFRICA,
                    new String[]{
                            "Mali"
                    },
                    18.0, 0.9, 0.8, 0.05
            ),
            new LandLockedCountry("Nigeria", AFRICA,
                    new String[]{
                            "Niger", "Chad", "Cameroon"
                    },
                    186.0, 0.85, 0.9, 0.1
            ),
            new LandLockedCountry("Cameroon", AFRICA,
                    new String[]{
                            "Nigeria", "Chad", "Central African Republic", "Gabon"
                    },
                    23.4, 0.9, 0.85, 0.1
            ),
            new LandLockedCountry("Central African Republic", AFRICA,
                    new String[]{
                            "Cameroon", "Chad", "Sudan", "South Sudan"
                    },
                    4.6, 0.9, 0.9, 0.0
            ),
            new LandLockedCountry("South Sudan", AFRICA,
                    new String[]{
                            "Central African Republic", "Sudan", "Ethiopia", "Kenya", "Uganda", "DR Congo"
                    },
                    12.2, 0.8, 0.15, 0.05
            ),
            new LandLockedCountry("Ethiopia", AFRICA,
                    new String[]{
                            "South Sudan", "Sudan", "Eritrea", "Somalia", "Kenya"
                    },
                    102.4, 0.85, 0.2, 0.05
            ),
            new CoastalCountry("Somalia", AFRICA,
                    new String[]{
                            "Ethiopia", "Kenya"
                    },
                    new String[]{
                            "Oman"
                    },
                    14.3, 0.8, 0.6, 0.05
            ),
            new LandLockedCountry("Gabon", AFRICA,
                    new String[]{
                            "Cameroon"
                    },
                    2.0, 0.9, 0.9, 0.3
            ),
            new LandLockedCountry("DR Congo", AFRICA,
                    new String[]{
                            "Central African Republic", "South Sudan", "Uganda", "Tanzania", "Zambia",
                            "Angola", "Rwanda"
                    },
                    78.7, 0.9, 0.9, 0.05
            ),
            new LandLockedCountry("Uganda", AFRICA,
                    new String[]{
                            "DR Congo", "South Sudan", "Kenya", "Tanzania", "Rwanda"
                    },
                    41.5, 0.85, 0.95, 0.05
            ),
            new LandLockedCountry("Kenya", AFRICA,
                    new String[]{
                            "Uganda", "South Sudan", "Ethiopia", "Somalia", "Tanzania"
                    },
                    48.5, 0.9, 0.9, 0.1
            ),
            new LandLockedCountry("Angola", AFRICA,
                    new String[]{
                            "DR Congo", "Zambia", "Namibia"
                    },
                    28.8, 0.95, 0.1, 0.25
            ),
            new LandLockedCountry("Rwanda", AFRICA,
                    new String[]{
                            "Uganda", "DR Congo", "Tanzania"
                    },
                    11.9, 0.85, 0.85, 0.1
            ),
            new LandLockedCountry("Tanzania", AFRICA,
                    new String[]{
                            "Rwanda", "Uganda", "DR Congo", "Kenya", "Zambia", "Malawi", "Mozambique"
                    },
                    55.6, 0.8, 0.8, 0.1
            ),
            new LandLockedCountry("Zambia", AFRICA,
                    new String[]{
                            "Angola", "DR Congo", "Tanzania", "Malawi", "Mozambique", "Zimbabwe",
                            "Botswana", "Namibia"
                    },
                    16.6, 0.85, 0.8, 0.1
            ),
            new LandLockedCountry("Malawi", AFRICA,
                    new String[]{
                            "Zambia", "Tanzania", "Mozambique"
                    },
                    18.1, 0.8, 0.8, 0.0
            ),
            new CoastalCountry("Mozambique", AFRICA,
                    new String[]{
                            "South Africa", "Zimbabwe", "Zambia", "Tanzania", "Malawi"
                    },
                    new String[]{
                            "Madagascar"
                    },
                    28.8, 0.8, 0.8, 0.0
            ),
            new LandLockedCountry("Namibia", AFRICA,
                    new String[]{
                            "Angola", "Zambia", "Botswana", "South Africa"
                    },
                    2.5, 0.95, 0.1, 0.25
            ),
            new LandLockedCountry("Botswana", AFRICA,
                    new String[]{
                            "Namibia", "Zimbabwe", "South Africa"
                    },
                    2.25, 0.9, 0.15, 0.3
            ),
            new LandLockedCountry("Zimbabwe", AFRICA,
                    new String[]{
                            "Botswana", "Zambia", "Mozambique", "South Africa"
                    },
                    16.2, 0.85, 0.75, 0.1
            ),
            new CoastalCountry("South Africa", AFRICA,
                    new String[]{
                            "Namibia", "Botswana", "Zimbabwe", "Mozambique"
                    },
                    new String[]{
                            "Madagascar", "Brazil"
                    },
                    55.9, 0.9, 0.25, 0.35
            ),
            new CoastalCountry("Madagascar", AFRICA,
                    new String[]{
                    },
                    new String[]{
                            "Mozambique", "South Africa"
                    },
                    24.9, 0.85, 0.95, 0.05
            )
    };

    public static List<Country> northAmericanCountries = new ArrayList<>();
    public static List<Country> southAmericanCountries = new ArrayList<>();
    public static List<Country> europianCountries = new ArrayList<>();
    public static List<Country> asianCountries = new ArrayList<>();
    public static List<Country> australianCountries = new ArrayList<>();
    public static List<Country> africanCountries = new ArrayList<>();

}
