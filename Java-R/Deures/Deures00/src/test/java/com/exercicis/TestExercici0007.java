package com.exercicis;

import com.testStringUtils.TestStringUtils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.util.Locale;

class TestExercici0007 {

    @Test
    public void testCalculaCostLloc() {
        String diff = TestStringUtils.findFirstDifference(
            String.valueOf(Exercici0007.calculaCostLloc("sala estàndard")),
            String.valueOf(100.0)
        );
        assertTrue(diff.compareTo("identical") == 0,
            ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "\n<<<<<<<<<< Diff end <<<<<<<<<<");

        diff = TestStringUtils.findFirstDifference(
            String.valueOf(Exercici0007.calculaCostLloc("jardí amb piscina")),
            String.valueOf(200.0)
        );
        assertTrue(diff.compareTo("identical") == 0,
            ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "\n<<<<<<<<<< Diff end <<<<<<<<<<");

        diff = TestStringUtils.findFirstDifference(
            String.valueOf(Exercici0007.calculaCostLloc("saló gran amb escenari")),
            String.valueOf(500.0)
        );
        assertTrue(diff.compareTo("identical") == 0,
            ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "\n<<<<<<<<<< Diff end <<<<<<<<<<");

        assertThrows(IllegalArgumentException.class, () -> Exercici0007.calculaCostLloc("lloc desconegut"));
    }

    @Test
    public void testCalculaCostMenjar() {
        String diff = TestStringUtils.findFirstDifference(
            String.valueOf(Exercici0007.calculaCostMenjar("menú bàsic", 20)),
            String.valueOf(300.0)
        );
        assertTrue(diff.compareTo("identical") == 0,
            ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "\n<<<<<<<<<< Diff end <<<<<<<<<<");

        diff = TestStringUtils.findFirstDifference(
            String.valueOf(Exercici0007.calculaCostMenjar("menú premium", 60)),
            String.valueOf(1710.0)
        ); // Inclou descompte del 5%
        assertTrue(diff.compareTo("identical") == 0,
            ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "\n<<<<<<<<<< Diff end <<<<<<<<<<");

        assertThrows(IllegalArgumentException.class, () -> Exercici0007.calculaCostMenjar("menú desconegut", 10));
    }

    @Test
    public void testCalculaCostEntreteniment() {
        String diff = TestStringUtils.findFirstDifference(
            String.valueOf(Exercici0007.calculaCostEntreteniment("màgia")),
            String.valueOf(250.0)
        );
        assertTrue(diff.compareTo("identical") == 0,
            ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "\n<<<<<<<<<< Diff end <<<<<<<<<<");

        diff = TestStringUtils.findFirstDifference(
            String.valueOf(Exercici0007.calculaCostEntreteniment("música en directe")),
            String.valueOf(500.0)
        );
        assertTrue(diff.compareTo("identical") == 0,
            ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "\n<<<<<<<<<< Diff end <<<<<<<<<<");

        diff = TestStringUtils.findFirstDifference(
            String.valueOf(Exercici0007.calculaCostEntreteniment("cap")),
            String.valueOf(0.0)
        );
        assertTrue(diff.compareTo("identical") == 0,
            ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "\n<<<<<<<<<< Diff end <<<<<<<<<<");

        assertThrows(IllegalArgumentException.class, () -> Exercici0007.calculaCostEntreteniment("entreteniment desconegut"));
    }

    @Test
    public void testCalculaFesta() {
        String diff = TestStringUtils.findFirstDifference(
            String.valueOf(Exercici0007.calculaFesta("sala estàndard", "menú bàsic", "cap", 20)),
            String.valueOf(400.0)
        );
        assertTrue(diff.compareTo("identical") == 0,
            ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "\n<<<<<<<<<< Diff end <<<<<<<<<<");

        diff = TestStringUtils.findFirstDifference(
            String.valueOf(Exercici0007.calculaFesta("jardí amb piscina", "menú premium", "màgia", 60)),
            String.valueOf(2160.0)
        );
        assertTrue(diff.compareTo("identical") == 0,
            ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "\n<<<<<<<<<< Diff end <<<<<<<<<<");

        diff = TestStringUtils.findFirstDifference(
            String.valueOf(Exercici0007.calculaFesta("jardí amb piscina", "menú bàsic", "música en directe", 40)),
            String.valueOf(1300.0)
        );
        assertTrue(diff.compareTo("identical") == 0,
            ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "\n<<<<<<<<<< Diff end <<<<<<<<<<");

        diff = TestStringUtils.findFirstDifference(
            String.valueOf(Exercici0007.calculaFesta("saló gran amb escenari", "menú premium", "música en directe", 70)),
            String.valueOf(2895.0)
        );
        assertTrue(diff.compareTo("identical") == 0,
            ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "\n<<<<<<<<<< Diff end <<<<<<<<<<");

        diff = TestStringUtils.findFirstDifference(
            String.valueOf(Exercici0007.calculaFesta("sala estàndard", "menú premium", "màgia", 15)),
            String.valueOf(800.0)
        );
        assertTrue(diff.compareTo("identical") == 0,
            ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "\n<<<<<<<<<< Diff end <<<<<<<<<<");
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

            String expectedOutput = """
Cas 1 ("sala estàndard", "menú bàsic", "cap", 20):                         400.00€
Cas 2 ("jardí amb piscina", "menú premium", "màgia", 60):                  2160.00€
Cas 3 ("jardí amb piscina", "menú bàsic", "música en directe", 40):        1300.00€
Cas 4 ("saló gran amb escenari", "menú premium", "música en directe", 70): 2895.00€
Cas 5 ("sala estàndard", "menú premium", "màgia", 15):                     800.00€
""";

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "\n<<<<<<<<<< Diff end <<<<<<<<<<");
        } finally {
            Locale.setDefault(defaultLocale);
        }
    }
}
