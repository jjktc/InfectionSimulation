package com.jefftc.viral;

import com.jefftc.viral.countries.CoastalCountry;
import com.jefftc.viral.countries.LandLockedCountry;
import com.jefftc.viral.mechanics.Country;

/**
 * Class containing all of the Country data for the Viral Simulation
 */
public class ViralSimulationCountries {

    /**
     * Array of all of the Countries and their stats
     */
    public static final Country[] COUNTRIES = new Country[]{
            // North America
            new CoastalCountry("Greenland",
                    new String[]{
                    },
                    new String[]{
                            "Canada", "United States of America", "Iceland"
                    },
                    0.056, 0.1, 0.2, 0.85
            ),
            new CoastalCountry("Canada",
                    new String[]{
                            "United States of America"
                    },
                    new String[]{
                            "Greenland", "Iceland", "Russia"
                    },
                    36.0, 0.25, 0.3, 0.9
            ),
            new CoastalCountry("United States of America",
                    new String[]{
                            "Canada", "Mexico"
                    },
                    new String[]{
                            "Greenland", "Iceland", "Cuba", "Puerto Rico", "France", "United Kingdom",
                            "Panama", "Russia", "China", "Japan", "Korea", "Australia", "Brazil",
                            "Argentina", "Italy", "Thailand", "Philippines", "Egypt"
                    },
                    323.0, 0.75, 0.75, 1.0
            ),
            new CoastalCountry("Mexico",
                    new String[]{
                            "United States of America", "Guatemala"
                    },
                    new String[]{
                            "Cuba", "Puerto Rico"
                    },
                    128.0, 0.85, 0.4, 0.4
            ),
            new CoastalCountry("Cuba",
                    new String[]{
                    },
                    new String[]{
                            "United States of America", "Mexico", "Puerto Rico", "Guatemala"
                    },
                    11.5, 0.9, 0.6, 0.6
            ),
            new CoastalCountry("Puerto Rico",
                    new String[]{
                    },
                    new String[]{
                            "United States of America", "Cuba", "Mexico"
                    },
                    3.4, 0.85, 0.6, 0.65
            ),
            new CoastalCountry("Guatemala",
                    new String[]{
                            "Mexico", "Honduras"
                    },
                    new String[]{
                            "Cuba"
                    },
                    16.6, 0.85, 0.65, 0.3
            ),
            new LandLockedCountry("Honduras",
                    new String[]{
                            "Guatemala", "Nicaragua"
                    },
                    9.1, 0.85, 0.7, 0.3
            ),
            new LandLockedCountry("Nicaragua",
                    new String[]{
                            "Honduras", "Costa Rica"
                    },
                    6.15, 0.85, 0.7, 0.2
            ),
            new LandLockedCountry(
                    "Costa Rica",
                    new String[]{
                            "Nicaragua", "Panama"
                    },
                    4.85, 0.85, 0.7, 0.4
            ),
            new CoastalCountry("Panama",
                    new String[]{
                            "Costa Rica", "Colombia"
                    },
                    new String[]{
                            "United States of America"
                    },
                    4.0, 0.9, 0.8, 0.3
            ),
            // South America
            new LandLockedCountry("Colombia",
                    new String[]{
                            "Panama", "Venezuela", "Ecuador", "Brazil", "Peru"
                    },
                    48.65, 0.8, 0.75, 0.5
            ),
            new LandLockedCountry("Venezuela",
                    new String[]{
                            "Colombia", "Brazil"
                    },
                    31.6, 0.8, 0.75, 0.5
            ),
            new LandLockedCountry("Ecuador",
                    new String[]{
                            "Colombia", "Peru"
                    },
                    16.4, 0.75, 0.75, 0.4
            ),
            new LandLockedCountry("Peru",
                    new String[]{
                            "Colombia", "Ecuador", "Brazil", "Bolivia", "Chile"
                    },
                    31.8, 0.7, 0.7, 0.4
            ),
            new CoastalCountry("Brazil",
                    new String[]{
                            "Colombia", "Venezuela", "Peru", "Bolivia", "Paraguay", "Uruguay",
                            "Argentina", "South Africa"
                    },
                    new String[]{
                            "United States of America"
                    },
                    207.7, 0.6, 0.75, 0.5
            ),
            new LandLockedCountry("Bolivia",
                    new String[]{
                            "Peru", "Brazil", "Paraguay", "Argentina", "Chile"
                    },
                    10.9, 0.65, 0.75, 0.2
            ),
            new LandLockedCountry("Paraguay",
                    new String[]{
                            "Bolivia", "Brazil", "Argentina"
                    },
                    6.7, 0.65, 0.6, 0.3
            ),
            new LandLockedCountry("Uruguay",
                    new String[]{
                            "Brazil", "Argentina"
                    },
                    3.4, 0.6, 0.6, 0.4
            ),
            new LandLockedCountry("Chile",
                    new String[]{
                            "Peru", "Bolivia", "Argentina"
                    },
                    17.9, 0.7, 0.8, 0.4
            ),
            new CoastalCountry("Argentina",
                    new String[]{
                            "Chile", "Bolivia", "Paraguay", "Brazil", "Uruguay"
                    },
                    new String[]{
                            "United States of America"
                    },
                    43.85, 0.7, 0.8, 0.4
            ),
            // Europe
            new CoastalCountry("Iceland",
                    new String[]{
                    },
                    new String[]{
                            "United States of America", "Canada", "Greenland", "Ireland",
                            "United Kingdom", "Norway"
                    },
                    0.33, 0.1, 0.1, 0.95
            ),
            new CoastalCountry("Ireland",
                    new String[]{
                            "United Kingdom"
                    },
                    new String[]{
                            "Iceland", "Portugal", "Spain", "France"
                    },
                    4.8, 0.2, 0.15, 0.9
            ),
            new CoastalCountry("United Kingdom",
                    new String[]{
                            "Ireland"
                    },
                    new String[]{
                            "United States of America", "Portugal", "Spain", "France", "Germany",
                            "Denmark", "Norway", "Sweden", "China", "Italy"
                    },
                    65.6, 0.2, 0.15, 0.85
            ),
            new CoastalCountry("Norway",
                    new String[]{
                            "Sweden"
                    },
                    new String[]{
                            "United Kingdom", "Denmark", "Germany"
                    },
                    5.2, 0.1, 0.1, 1.0
            ),
            new CoastalCountry("Sweden",
                    new String[]{
                            "Norway", "Finland"
                    },
                    new String[]{
                            "United Kingdom"
                    },
                    9.9, 0.15, 0.2, 0.85
            ),
            new LandLockedCountry("Finland",
                    new String[]{
                            "Sweden", "Russia"
                    },
                    5.5, 0.15, 0.2, 0.8
            ),
            new CoastalCountry("Denmark",
                    new String[]{
                            "Germany"
                    },
                    new String[]{
                            "United Kingdom"
                    },
                    5.7, 0.3, 0.4, 0.75
            ),
            new CoastalCountry("Germany",
                    new String[]{
                            "Denmark", "France", "Poland", "Switzerland", "Austria"
                    },
                    new String[]{
                            "Norway", "United Kingdom"
                    }, 82.7, 0.45, 0.35, 0.7
            ),
            new LandLockedCountry("Switzerland",
                    new String[]{
                            "France", "Germany", "Italy", "Austria"
                    },
                    8.4, 0.2, 0.2, 1.0
            ),
            new LandLockedCountry("Poland",
                    new String[]{
                            "Germany", "Belarus", "Ukraine"
                    },
                    38.0, 0.3, 0.25, 0.4
            ),
            new LandLockedCountry("Belarus",
                    new String[]{
                            "Poland", "Russia", "Ukraine"
                    },
                    9.5, 0.35, 0.35, 0.3
            ),
            new CoastalCountry("France",
                    new String[]{
                            "Spain", "Germany", "Switzerland", "Italy"
                    },
                    new String[]{
                            "United States of America", "United Kingdom"
                    },
                    66.9, 0.5, 0.4, 0.6
            ),
            new CoastalCountry("Spain",
                    new String[]{
                            "Portugal", "France"
                    },
                    new String[]{
                            "United States of America", "United Kingdom", "Morocco", "Algeria"
                    },
                    46.7, 0.65, 0.5, 0.4
            ),
            new CoastalCountry("Portugal",
                    new String[]{
                            "Spain"
                    },
                    new String[]{
                            "United States of America", "United Kingdom", "Morocco"
                    },
                    10.3, 0.65, 0.5, 0.4
            ),
            new CoastalCountry("Italy",
                    new String[]{
                            "France", "Switzerland", "Austria"
                    },
                    new String[]{
                            "United States of America", "United Kingdom", "Algeria", "Tunisia",
                            "Libya", "Greece"
                    },
                    60.6, 0.7, 0.6, 0.55
            ),
            new LandLockedCountry("Austria",
                    new String[]{
                            "Germany", "Switzerland", "Italy"
                    },
                    8.75, 0.65, 0.5, 0.65
            ),
            new CoastalCountry("Romania",
                    new String[]{
                            "Ukraine"
                    },
                    new String[]{
                            "Turkey"
                    },
                    19.7, 0.65, 0.6, 0.3
            ),
            new LandLockedCountry("Bulgaria",
                    new String[]{
                            "Romania", "Greece", "Turkey"
                    },
                    7.1, 0.7, 0.6, 0.25
            ),
            new CoastalCountry("Greece",
                    new String[]{
                            "Bulgaria", "Turkey"
                    },
                    new String[]{
                            "Italy", "Libya", "Egypt"
                    },
                    10.75, 0.7, 0.75, 0.4
            ),
            new LandLockedCountry("Ukraine",
                    new String[]{
                            "Poland", "Belarus", "Russia", "Romania"
                    },
                    45.0, 0.6, 0.6, 0.15
            ),
            // Asia
            new CoastalCountry("Russia",
                    new String[]{
                            "Finland", "Belarus", "Ukraine", "Kazakhstan", "Mongolia", "China"
                    },
                    new String[]{
                            "United States of America", "Canada"
                    },
                    144.3, 0.1, 0.2, 0.2
            ),
            new CoastalCountry("Turkey",
                    new String[]{
                            "Bulgaria", "Greece", "Syria", "Iraq", "Iran"
                    },
                    new String[]{
                            "Egypt"
                    },
                    79.5, 0.75, 0.4, 0.25
            ),
            new LandLockedCountry("Syria",
                    new String[]{
                            "Turkey", "Iraq", "Israel"
                    },
                    18.4, 0.75, 0.5, 0.15
            ),
            new LandLockedCountry("Iraq",
                    new String[]{
                            "Syria", "Turkey", "Iran", "Saudi Arabia"
                    },
                    37.2, 0.8, 0.4, 0.25
            ),
            new LandLockedCountry("Iran",
                    new String[]{
                            "Turkey", "Iraq", "Turkmenistan", "Afghanistan", "Pakistan"
                    },
                    80.3, 0.8, 0.4, 0.3
            ),
            new LandLockedCountry("Israel",
                    new String[]{
                            "Syria", "Egypt"
                    },
                    8.5, 0.7, 0.4, 0.6
            ),
            new LandLockedCountry("Saudi Arabia",
                    new String[]{
                            "Egypt", "Iraq", "Iran", "Yemen", "Oman", "Egypt"
                    },
                    32.3, 0.85, 0.3, 0.45
            ),
            new LandLockedCountry("Yemen",
                    new String[]{
                            "Saudi Arabia", "Oman"
                    },
                    27.6, 0.8, 0.3, 0.1
            ),
            new CoastalCountry("Oman",
                    new String[]{
                            "Saudi Arabia", "Yemen"
                    },
                    new String[]{
                            "India", "Somalia"
                    },
                    4.4, 0.8, 0.3, 0.25
            ),
            new LandLockedCountry("Turkmenistan",
                    new String[]{
                            "Kazakhstan", "Uzbekistan", "Iran", "Afghanistan", "Pakistan"
                    },
                    5.7, 0.75, 0.35, 0.15
            ),
            new LandLockedCountry("Uzbekistan",
                    new String[]{
                            "Kazakhstan", "Turkmenistan", "Afghanistan", "Kyrgyzstan"
                    },
                    31.85, 0.75, 0.3, 0.1
            ),
            new LandLockedCountry("Kazakhstan",
                    new String[]{
                            "Russia", "Turkmenistan", "Uzbekistan", "China", "Kyrgyzstan"
                    },
                    17.8, 0.7, 0.3, 0.2
            ),
            new LandLockedCountry("Kyrgyzstan",
                    new String[]{
                            "Kazakhstan", "Uzbekistan", "China", "Tajikistan"
                    },
                    6.0, 0.75, 0.25, 0.1
            ),
            new LandLockedCountry("Tajikistan",
                    new String[]{
                            "Uzbekistan", "Kyrgyzstan", "China"
                    },
                    8.7, 0.8, 0.25, 0.1
            ),
            new LandLockedCountry("Afghanistan",
                    new String[]{
                            "Iran", "Turkmenistan", "Uzbekistan", "Tajikistan", "China", "Pakistan"
                    },
                    34.7, 0.9, 0.2, 0.0
            ),
            new LandLockedCountry("Pakistan",
                    new String[]{
                            "Iran", "Afghanistan", "China", "India"
                    },
                    193.2, 0.9, 0.2, 0.1
            ),
            new CoastalCountry("India",
                    new String[]{
                            "Pakistan", "China", "Nepal", "Bangladesh"
                    },
                    new String[]{
                            "Oman", "United States of America"
                    },
                    1324, 0.85, 0.2, 0.15
            ),
            new LandLockedCountry("Nepal",
                    new String[]{
                            "China", "India", "Bangladesh"
                    },
                    29.0, 0.8, 0.2, 0.1
            ),
            new CoastalCountry("China",
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
            new LandLockedCountry("Mongolia",
                    new String[]{
                            "Russia", "China"
                    },
                    3.0, 0.4, 0.4, 0.15
            ),
            new CoastalCountry("Korea",
                    new String[]{
                            "China"
                    },
                    new String[]{
                            "United States of America", "Japan"
                    },
                    51.25, 0.75, 0.6, 0.7
            ),
            new CoastalCountry("Japan",
                    new String[]{
                    },
                    new String[]{
                            "China", "Korea", "United States of America"
                    },
                    127.0, 0.7, 0.7, 0.85
            ),
            new LandLockedCountry("Bangladesh",
                    new String[]{
                            "India", "Myanmar"
                    },
                    163.0, 0.7, 0.6, 0.1
            ),
            new LandLockedCountry("Myanmar",
                    new String[]{
                            "Bangladesh", "China", "Laos", "Thailand"
                    },
                    52.9, 0.75, 0.8, 0.1
            ),
            new CoastalCountry("Thailand",
                    new String[]{
                            "Myanmar", "Laos", "Vietnam", "Cambodia", "Malaysia"
                    },
                    new String[]{
                            "United States of America"
                    },
                    68.9, 0.7, 0.8, 0.25
            ),
            new LandLockedCountry("Laos",
                    new String[]{
                            "Myanmar", "China", "Vietnam", "Cambodia"
                    },
                    6.8, 0.7, 0.75, 0.15
            ),
            new LandLockedCountry("Cambodia",
                    new String[]{
                            "Thailand", "Laos", "Vietnam"
                    },
                    15.8, 0.75, 0.7, 0.1
            ),
            new CoastalCountry("Vietnam",
                    new String[]{
                            "Cambodia", "Laos", "China"
                    },
                    new String[]{
                            "Philippines"
                    },
                    92.7, 0.7, 0.8, 0.2
            ),
            new CoastalCountry("Philippines",
                    new String[]{
                    },
                    new String[]{
                            "Vietnam", "China", "Indonesia", "United States of America"
                    },
                    103.3, 0.6, 0.65, 0.25
            ),
            new LandLockedCountry("Malaysia",
                    new String[]{
                            "Thailand", "Indonesia"
                    },
                    31.2, 0.7, 0.85, 0.35
            ),
            new CoastalCountry("Indonesia",
                    new String[]{
                            "Malaysia", "Papua New Guinea"
                    },
                    new String[]{
                            "Philippines", "Australia"
                    },
                    261.1, 0.65, 0.85, 0.25
            ),
            new CoastalCountry("Papua New Guinea",
                    new String[]{
                            "Indonesia"
                    },
                    new String[]{
                            "Australia"
                    },
                    8.1, 0.65, 0.85, 0.15
            ),
            // Australia
            new CoastalCountry("Australia",
                    new String[]{
                    },
                    new String[]{
                            "Indonesia", "Papua New Guinea", "New Zealand", "United States of America"
                    },
                    24.1, 0.6, 0.4, 0.9
            ),
            new CoastalCountry("New Zealand",
                    new String[]{
                    },
                    new String[]{
                            "Australia"
                    },
                    4.7, 0.55, 0.5, 0.8
            ),
            // Africa
            new CoastalCountry("Morocco",
                    new String[]{
                            "Algeria", "Western Sahara"
                    },
                    new String[]{
                            "Portugal", "Spain"
                    },
                    35.3, 0.7, 0.2, 0.2
            ),
            new CoastalCountry("Algeria",
                    new String[]{
                            "Morocco", "Mauritania", "Tunisia", "Libya", "Niger", "Mali"
                    },
                    new String[]{
                            "Spain", "Italy"
                    },
                    40.6, 0.8, 0.15, 0.25
            ),
            new CoastalCountry("Tunisia",
                    new String[]{
                            "Algeria", "Libya"
                    },
                    new String[]{
                            "Italy"
                    },
                    11.4, 0.75, 0.4, 0.25
            ),
            new CoastalCountry("Libya",
                    new String[]{
                            "Tunisia", "Algeria", "Egypt", "Sudan", "Chad", "Niger"
                    },
                    new String[]{
                            "Italy", "Greece"
                    },
                    6.3, 0.75, 0.3, 0.3
            ),
            new CoastalCountry("Egypt",
                    new String[]{
                            "Libya", "Israel", "Sudan", "Saudi Arabia"
                    },
                    new String[]{
                            "Turkey", "United States of America", "Greece"
                    },
                    95.7, 0.85, 0.2, 0.25
            ),
            new LandLockedCountry("Western Sahara",
                    new String[]{
                            "Morocco", "Mauritania"
                    },
                    0.5, 0.8, 0.15, 0.15
            ),
            new LandLockedCountry("Mauritania",
                    new String[]{
                            "Western Sahara", "Algeria", "Mali"
                    },
                    4.3, 0.8, 0.1, 0.1
            ),
            new LandLockedCountry("Mali",
                    new String[]{
                            "Mauritania", "Algeria", "Niger", "Guinea"
                    },
                    18.0, 0.9, 0.1, 0.1
            ),
            new LandLockedCountry("Niger",
                    new String[]{
                            "Mali", "Algeria", "Libya", "Chad", "Nigeria"
                    },
                    20.7, 0.9, 0.2, 0.05
            ),
            new LandLockedCountry("Chad",
                    new String[]{
                            "Niger", "Libya", "Sudan", "Central African Republic", "Cameroon", "Nigeria"
                    },
                    14.5, 0.9, 0.8, 0.05
            ),
            new LandLockedCountry("Sudan",
                    new String[]{
                            "Libya", "Egypt", "Eritrea", "Ethiopia", "South Sudan",
                            "Central African Republic", "Chad"
                    },
                    39.6, 0.9, 0.5, 0.15
            ),
            new LandLockedCountry("Eritrea",
                    new String[]{
                            "Sudan", "Ethiopia"
                    },
                    4.5, 0.9, 0.8, 0.05
            ),
            new LandLockedCountry("Guinea",
                    new String[]{
                            "Mali"
                    },
                    18.0, 0.9, 0.8, 0.05
            ),
            new LandLockedCountry("Nigeria",
                    new String[]{
                            "Niger", "Chad", "Cameroon"
                    },
                    186.0, 0.85, 0.9, 0.1
            ),
            new LandLockedCountry("Cameroon",
                    new String[]{
                            "Nigeria", "Chad", "Central African Republic", "Gabon"
                    },
                    23.4, 0.9, 0.85, 0.1
            ),
            new LandLockedCountry("Central African Republic",
                    new String[]{
                            "Cameroon", "Chad", "Sudan", "South Sudan"
                    },
                    4.6, 0.9, 0.9, 0.0
            ),
            new LandLockedCountry("South Sudan",
                    new String[]{
                            "Central African Republic", "Sudan", "Ethiopia", "Kenya", "Uganda", "DR Congo"
                    },
                    12.2, 0.8, 0.15, 0.05
            ),
            new LandLockedCountry("Ethiopia",
                    new String[]{
                            "South Sudan", "Sudan", "Eritrea", "Somalia", "Kenya"
                    },
                    102.4, 0.85, 0.2, 0.05
            ),
            new CoastalCountry("Somalia",
                    new String[]{
                            "Ethiopia", "Kenya"
                    },
                    new String[]{
                            "Oman"
                    },
                    14.3, 0.8, 0.6, 0.05
            ),
            new LandLockedCountry("Gabon",
                    new String[]{
                            "Cameroon"
                    },
                    2.0, 0.9, 0.9, 0.3
            ),
            new LandLockedCountry("DR Congo",
                    new String[]{
                            "Central African Republic", "South Sudan", "Uganda", "Tanzania", "Zambia",
                            "Angola", "Rwanda"
                    },
                    78.7, 0.9, 0.9, 0.05
            ),
            new LandLockedCountry("Uganda",
                    new String[]{
                            "DR Congo", "South Sudan", "Kenya", "Tanzania", "Rwanda"
                    },
                    41.5, 0.85, 0.95, 0.05
            ),
            new LandLockedCountry("Kenya",
                    new String[]{
                            "Uganda", "South Sudan", "Ethiopia", "Somalia", "Tanzania"
                    },
                    48.5, 0.9, 0.9, 0.1
            ),
            new LandLockedCountry("Angola",
                    new String[]{
                            "DR Congo", "Zambia", "Namibia"
                    },
                    28.8, 0.95, 0.1, 0.25
            ),
            new LandLockedCountry("Rwanda",
                    new String[]{
                            "Uganda", "DR Congo", "Tanzania"
                    },
                    11.9, 0.85, 0.85, 0.1
            ),
            new LandLockedCountry("Tanzania",
                    new String[]{
                            "Rwanda", "Uganda", "DR Congo", "Kenya", "Zambia", "Malawi", "Mozambique"
                    },
                    55.6, 0.8, 0.8, 0.1
            ),
            new LandLockedCountry("Zambia",
                    new String[]{
                            "Angola", "DR Congo", "Tanzania", "Malawi", "Mozambique", "Zimbabwe",
                            "Botswana", "Namibia"
                    },
                    16.6, 0.85, 0.8, 0.1
            ),
            new LandLockedCountry("Malawi",
                    new String[]{
                            "Zambia", "Tanzania", "Mozambique"
                    },
                    18.1, 0.8, 0.8, 0.0
            ),
            new CoastalCountry("Mozambique",
                    new String[]{
                            "South Africa", "Zimbabwe", "Zambia", "Tanzania", "Malawi"
                    },
                    new String[]{
                            "Madagascar"
                    },
                    28.8, 0.8, 0.8, 0.0
            ),
            new LandLockedCountry("Namibia",
                    new String[]{
                            "Angola", "Zambia", "Botswana", "South Africa"
                    },
                    2.5, 0.95, 0.1, 0.25
            ),
            new LandLockedCountry("Botswana",
                    new String[]{
                            "Namibia", "Zimbabwe", "South Africa"
                    },
                    2.25, 0.9, 0.15, 0.3
            ),
            new LandLockedCountry("Zimbabwe",
                    new String[]{
                            "Botswana", "Zambia", "Mozambique", "South Africa"
                    },
                    16.2, 0.85, 0.75, 0.1
            ),
            new CoastalCountry("South Africa",
                    new String[]{
                            "Namibia", "Botswana", "Zimbabwe", "Mozambique"
                    },
                    new String[]{
                            "Madagascar", "Brazil"
                    },
                    55.9, 0.9, 0.25, 0.35
            ),
            new CoastalCountry("Madagascar",
                    new String[]{
                    },
                    new String[]{
                            "Mozambique", "South Africa"
                    },
                    24.9, 0.85, 0.95, 0.05
            )
    };

}
