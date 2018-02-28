package com.jefftc.viral.mechanics;

/**
 * A Symptom is an abstract "thing" that has altered infectivity depending on the region
 */
public abstract class Symptom {

    /**
     * Empty constructor
     */
    public Symptom() {
    }

    /**
     * Get the name of the Symptom
     *
     * @return the name
     */
    public abstract String getName();

    /**
     * Get the infectivity value of the Symptom
     *
     * @param heat     the heat of the Country
     * @param dampness the dampness of the Country
     * @param wealth   the wealth of the Country
     * @return the infectivity
     */
    public abstract double getInfectivity(double heat, double dampness, double wealth);

}
