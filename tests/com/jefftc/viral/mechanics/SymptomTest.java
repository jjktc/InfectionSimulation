package com.jefftc.viral.mechanics;

import com.jefftc.viral.symptoms.Cough;
import org.junit.Test;

import static org.junit.Assert.*;

public class SymptomTest {

    /**
     * Show that tweaking values can result in different infectivity ratings
     */
    @Test
    public void getInfectivity() {
        Symptom cough = new Cough();
        double poorInfectivity = cough.getInfectivity(0.5, 0.5, 0.1);
        double richInfectivity = cough.getInfectivity(0.5, 0.5, 0.9);
        assertTrue(poorInfectivity > richInfectivity);
    }

}