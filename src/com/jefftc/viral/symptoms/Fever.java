package com.jefftc.viral.symptoms;

import com.jefftc.viral.mechanics.Symptom;

/**
 * A Symptom that is especially effective in hot climates
 */
public class Fever extends Symptom {

    private static final String name = "Fever";
    private static final double infectivity = 2.0;

    /**
     * Get the name of the Symptom
     *
     * @return the name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Get the infectivity value of the Symptom
     *
     * @param heat     the heat of the Country
     * @param dampness the dampness of the Country
     * @param wealth   the wealth of the Country
     * @return the infectivity
     */
    @Override
    public double getInfectivity(double heat, double dampness, double wealth) {
        return infectivity * heat;
    }

}
