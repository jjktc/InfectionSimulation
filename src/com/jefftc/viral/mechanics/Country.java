package com.jefftc.viral.mechanics;

/**
 * A Country is an abstract base class that determines how the infection spreads with different
 * actions available at different types of locations
 */
public abstract class Country {

    public int population;
    public int infectedPopulation;
    public double infectedPercentage;
    public int heat;
    public int dampness;

    public Country() {
    }

    public abstract void nextEpoch();

    public abstract void infect(Country target);

    public abstract void spreadInternally();

}
