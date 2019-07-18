package com.jefftc.viral;

import java.util.ArrayList;
import java.util.List;

/**
 * Get a map UI for the user
 */
public class MapPrinter {

    private static final double THRESHOLD_FOUR = 0.97;
    private static final double THRESHOLD_THREE = 0.75;
    private static final double THRESHOLD_TWO = 0.5;
    private static final double THRESHOLD_ONE = 0.25;

    /**
     * ASCII map of the world filled with characters to represent continent
     */
    private static final String[] MAP = new String[] { "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠤⢀⣤⣶⢲⣶⡶⣂⢤⣤⣤⣤⣤⢤⠒⢶⢶⢲⢢⡤",
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡠⣄⡀⡀⣀⠀⣀⣀⢄⣶⣶⣿⠛⠉NNNNNNNNNNNN⠙⢹⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⢤⠒⢿⢿⢿⢿⢿⣀⣀⣀⣀⣀⡀⠀⠀⠀⣀⡀",
            "⠀⠀⠀⠀⠀⠀⠀⢠⠒⢾⢿⢿⢿⢿⡿⢶⣶⣶⢶⢶⢶⢷⠾NNNNNNNNNNN⣿⢿⣄NNNNNNNN⢉⠿⠿⠛⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⢤⢶⢲⢿⢶⠒⠤⡀⢀⠤⣤⣤⣤⢤⢽⠙⣻AAAAAAAAAAAAA⠙⢿⣿⢿⢿⠙⠙⢿⢿⢿⢶⢶⢶⢶⢶⢶⠒⢤⠤⣀⡀",
            "⠀⠀⠀⠀⡠⠛⠉⠉⢿⠙⠙NNNNNNNNNNNNNNNN⠛⠁⠛⠛⢤NN⡿⠃⠀⠀⠛⠘⡉⢿⠗⠛⡿⠀⠀⠀⠙⠛⠛⠁⠀⠀⠀⠀⢀⢴⠙⠁⡹EEEEEEEEEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA⢹⡉⣽ ⠙⠙⣿⠉⠁",
            "⠀⠀⠀⣬⠿⠛⠉⠀⠀⠀⠀⠉⠟NNNNNNNNNNNN⢷⠤⡀⠀⡠⠙⢿⠙⢿⢿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣶⡀⠀⠀⢹EEEEEEEEEEEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA⠁⠀⣾⠙⢢",
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡰⡉NNNNNNNNNNNNNN⠻⠚⠉NNNN⣙⡭⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⠛⣽⣹⡦⣶EEEEEEEEEEEEEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA⢿⣶⢄⠀⠀⠈⢿",
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⠁NNNNNNNNNNNNNNNN⣙⠛⣁⠧⠟   ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⡙EEEEEEEEEEEEEEEEEAAAAAAAAAAAAAAAAAAAAAAAAAAAAA⡟⠙⠈⢦",
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⠙NNNNNNNNNNNNNNNNN⡿⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡟⡟EEEE⢹⠀⠣⣿⣿⠽⡿⣿EEEEEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA⠟⡏⠁⠀⠘⡿",
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⢿NNNNNNNNNNNNNN⢹⠛⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢈⣛⣟⢥⡉   ⠙ ⠀ ⠀⠙⠛⣻⢻⠛⢹ ⢟⠉⢶AAAAAAAAAAAAAAAAAAAAAAAAA⠋⠉⣿⡆⡤⣴⣿⠆",
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⢹NNNNNNNNN⣙⠿⠙⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⢷⠽⣶⣶⣶⣶⣶⣶⢿⢶⢤⢿⠙⢶⢶⢶⣿⡱⠛⠿⡙⣿⡉   ⢟⣙AAAAAAAAAAAAAAAAAAAA⢷⠀⠀⠀⠛",
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣿NNNN⠟⠉⠉⠀⠀⠀ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡠⠛FFFFFFFFFFFFFFFFFFFFFFFF⣅⣻⡿⠿⠿⠿⠉⡟⠙AAAAAAAAAAAAAAAA⢹⣡",
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠱⢿⢿⣀⡀   ⠀⠉⠉⣿⢦⢤⢄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠙FFFFFFFFFFFFFFFFFFFFFFFFFF⡹⡿⠁⠀⠀⠀⠓⢿AAAA⡿⠉⠙⢿⠙AAAAA⠋⠉⠈",
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠛⢿⡻⠓⢶⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠙FFFFFFFFFFFFFFFFFFFFFFFF⡿⠛⠉⠀⠀⠀⠀⠀⠀⠀⡟A⢹⠁⠀⠀⠀⠀⠛⡿AAA⠢",
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⡟⣄⢤⡠⣿⢿⢿⢢⢤⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻FFFFFFFFFFFFFFFFFFFFFFFF⠒⡦⠀⠀⠀⠀⠀⠀⠀⠀⠈⣹⠟⠀⠀⠀⠀⠀⠀⢸⡇⠙⣿⠟",
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠙SSSSSS⢶⢶⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⣙⠿⠛⠛⠁⠻⠽FFFFFFFFFFFFF⠟⣱⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠰⣤⢱⠢",
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⢿SSSSSSSSSS⡦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠙FFFFFFFFFF⣻⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢿⢪⡁⠀⣷⠉⠙⡹⡾⣷⠃⠻⢀⠤⠀⣀",
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⠛SSSSSSSSSSSSSS⠙⠑⠤⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⣛FFFFFFF⠙⢹⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠑⠿⣀⣈⡉⠉⠈⠟⠃⠀⠉⠁⠉⠛⢿⢿⠑⢢⢠⣻⠃",
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠉SSSSSSSSSSSSSS⢙⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠙FFFFFFF⣹⠝⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀           ⠈⠉⠁⠉⠛",
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢿⢿SSSSSSSSSSS⠙⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⢿⠙FFFFFFF⠛⣹⠀⢀⠒⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢴⢶⠚⠙⠛⡀⢀⢿⡄",
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡟SSSSSSSSS⢿⣹⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡟⠙FFFFFF⠙⠁⠀⠀⢿⢿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡠⢲⢿UUUUUUU⠙⢿⡀",
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡟SSSSSSS⠙⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡉⠙FFFF⣿⠋⠀⠀⠀⠛⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠉UUUUUUUUUUU⠙⠙⡆",
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸SSSSSS⡙⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠙FF⠙⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⠙U⠙⠙⠙⢷⠙⠙UUUU⠙⡹⠁",
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸SSSSS⠫⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠛⠉⠉⠀⠀⠀⠀⠉⢻⠙⠙⠙⡿⠁⠀⠀⠀⠀⠀⠀⠀⡆",
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣿SS⡟⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡄⠟⠉",
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸SS⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠾⠛⠁",
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻S⢿", "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⠉⠁", };

    /**
     * Fill in and clear out junk from the main map to create one tailored for the
     * infection
     *
     * @param percentages the percent to fill in each continent
     * @return the filtered map
     */
    public static List<String> getFilterMap(double[] percentages) {
        List<String> filteredMap = new ArrayList<>();

        if (percentages.length == ViralSimulationCountries.TOTAL_CONTINENTS) {
            for (String line : MAP) {
                String filteredLine = line;
                filteredLine = filterLine(filteredLine, "N", percentages[ViralSimulationCountries.NORTH_AMERICA]);
                filteredLine = filterLine(filteredLine, "S", percentages[ViralSimulationCountries.SOUTH_AMERICA]);
                filteredLine = filterLine(filteredLine, "E", percentages[ViralSimulationCountries.EUROPE]);
                filteredLine = filterLine(filteredLine, "A", percentages[ViralSimulationCountries.ASIA]);
                filteredLine = filterLine(filteredLine, "U", percentages[ViralSimulationCountries.AUSTRALIA]);
                filteredLine = filterLine(filteredLine, "F", percentages[ViralSimulationCountries.AFRICA]);

                filteredMap.add(filteredLine);
            }
        }

        return filteredMap;
    }

    /**
     * Replace the filler character with a filled in one or space
     *
     * @param line            the line to filter
     * @param filterCharacter the character to replace
     * @param filterAmount    if it should be filled in or space
     * @return the filtered line
     */
    public static String filterLine(String line, String filterCharacter, double filterAmount) {
        if (filterAmount > THRESHOLD_FOUR) {
            return line.replaceAll(filterCharacter, "⣿");
        } else if (filterAmount > THRESHOLD_THREE) {
            return line.replaceAll(filterCharacter, "⢰");
        } else if (filterAmount > THRESHOLD_TWO) {
            return line.replaceAll(filterCharacter, "⠒");
        } else if (filterAmount > THRESHOLD_ONE) {
            return line.replaceAll(filterCharacter, "⠁");
        } else {
            return line.replaceAll(filterCharacter, " ");
        }
    }

}
