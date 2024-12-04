package com.exercicis;

import com.testStringUtils.TestStringUtils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.util.Locale;

class TestExercici0007 {

    @Test
    public void testCalculaCostLloc() {
        assertEquals(100.0, Exercici0007.calculaCostLloc("sala estàndard"), 0.01);
        assertEquals(200.0, Exercici0007.calculaCostLloc("jardí amb piscina"), 0.01);
        assertEquals(500.0, Exercici0007.calculaCostLloc("saló gran amb escenari"), 0.01);
        assertThrows(IllegalArgumentException.class, () -> Exercici0007.calculaCostLloc("lloc desconegut"));
    }

    @Test
    public void testCalculaCostMenjar() {
        assertEquals(300.0, Exercici0007.calculaCostMenjar("menú bàsic", 20), 0.01);
        assertEquals(1710.0, Exercici0007.calculaCostMenjar("menú premium", 60), 0.01); // Inclou descompte del 5%
        assertThrows(IllegalArgumentException.class, () -> Exercici0007.calculaCostMenjar("menú desconegut", 10));
    }

    @Test
    public void testCalculaCostEntreteniment() {
        assertEquals(250.0, Exercici0007.calculaCostEntreteniment("màgia"), 0.01);
        assertEquals(500.0, Exercici0007.calculaCostEntreteniment("música en directe"), 0.01);
        assertEquals(0.0, Exercici0007.calculaCostEntreteniment("cap"), 0.01);
        assertThrows(IllegalArgumentException.class, () -> Exercici0007.calculaCostEntreteniment("entreteniment desconegut"));
    }

    @Test
    public void testCalculaFesta() {
        assertEquals(400.0, Exercici0007.calculaFesta("sala estàndard", "menú bàsic", "cap", 20), 0.01);
        assertEquals(2160.0, Exercici0007.calculaFesta("jardí amb piscina", "menú premium", "màgia", 60), 0.01);
        assertEquals(1300.0, Exercici0007.calculaFesta("jardí amb piscina", "menú bàsic", "música en directe", 40), 0.01);
        assertEquals(2895.0, Exercici0007.calculaFesta("saló gran amb escenari", "menú premium", "música en directe", 70), 0.01);
        assertEquals(800.0, Exercici0007.calculaFesta("sala estàndard", "menú premium", "màgia", 15), 0.01);
    }

    @Test
    public void testMainFunction() throws Exception {
        Locale defaultLocale = Locale.getDefault();
        try {
            Locale.setDefault(Locale.US);

            String text = SystemLambda.tapSystemOut(() -> {
                String[] args = {};
                Exercici0007.main(args);
            });

            text = text.replace("\r\n", "\n");

            String expectedOutput = """
Cas 1 ("sala estàndard", "menú bàsic", "cap", 20):                         400.00€
Cas 2 ("jardí amb piscina", "menú premium", "màgia", 60):                  2160.00€
Cas 3 ("jardí amb piscina", "menú bàsic", "música en directe", 40):        1300.00€
Cas 4 ("saló gran amb escenari", "menú premium", "música en directe", 70): 2895.00€
Cas 5 ("sala estàndard", "menú premium", "màgia", 15):                     800.00€
                """.replace("\r\n", "\n");

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
