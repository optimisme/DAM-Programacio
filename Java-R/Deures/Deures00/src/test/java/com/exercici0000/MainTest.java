package com.exercici0000;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testCalcularPreuFinal() {
        double preuBase = 100.0;
        double iva = 21.0; // 21%
        double descompte = 10.0; // 10%

        double resultatEsperat = 100.0 * 1.21 * 0.90;
        double resultatObtingut = Main.calcularPreuFinal(preuBase, iva, descompte);

        assertEquals(resultatEsperat, resultatObtingut, 0.01);
    }
}
