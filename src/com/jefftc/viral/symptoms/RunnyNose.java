package com.jefftc.viral.symptoms;

import com.jefftc.viral.mechanics.Symptom;

/**
 * A Symptom with effectiveness independent of region
 */
public class RunnyNose extends Symptom {

    private static final String name = "Runny Nose";
    private static final double infectivity = 0.3;

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
        return infectivity;
    }

}
