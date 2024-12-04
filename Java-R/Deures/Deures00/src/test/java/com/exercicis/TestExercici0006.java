package com.exercicis;

import com.testStringUtils.TestStringUtils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.util.Locale;

class TestExercici0006 {

    @Test
    public void testCalculaEntrada() {
        // Testar diferents casos per a calculaEntrada
        assertEquals(20.8, Exercici0006.calculaEntrada(1, 2, 1, "dimarts"), 0.01);
        assertEquals(24.5, Exercici0006.calculaEntrada(1, 2, 2, "dijous"), 0.01);
        assertEquals(32.0, Exercici0006.calculaEntrada(2, 0, 2, "dissabte"), 0.01);
        assertEquals(21.0, Exercici0006.calculaEntrada(1, 1, 1, "diumenge"), 0.01);
        assertEquals(28.5, Exercici0006.calculaEntrada(2, 3, 1, "dijous"), 0.01);
        assertEquals(84.0, Exercici0006.calculaEntrada(4, 4, 4, "dimecres"), 0.01);
    }

    @Test
    public void testMainFunction() throws Exception {
        Locale defaultLocale = Locale.getDefault(); 
        try {
            Locale.setDefault(Locale.US);

            String text = SystemLambda.tapSystemOut(() -> {
                String[] args = {};
                Exercici0006.main(args);
            });

            text = text.replace("\r\n", "\n");

            String expectedOutput = """
                Cas 1 (2 adults, 2 nens, 1 gran):  28.80€
                Cas 2 (1 adult,  2 nens, 0 grans): 12.50€
                Cas 3 (0 adults, 0 nens, 2 grans): 12.00€
                Cas 4 (1 adult,  0 nens, 0 grans): 10.00€
                Cas 5 (1 adult,  3 nens, 4 grans): 36.50€
                Cas 6 (2 adults, 2 nens, 1 gran):  36.00€
                """.replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> >>>>>>>>>>\n" +
                diff +
                "<<<<<<<<<< <<<<<<<<<<\n");
        } finally {
            Locale.setDefault(defaultLocale); 
        }
    }
}
