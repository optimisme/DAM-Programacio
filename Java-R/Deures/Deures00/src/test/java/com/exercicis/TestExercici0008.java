package com.exercicis;

import com.testStringUtils.TestStringUtils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.util.ArrayList;
import java.util.Locale;

class TestExercici0008 {

    @Test
    public void testGeneraImparells() {
        // Cas 1: Generar imparells fins a 15
        ArrayList<Integer> resultat = Exercici0008.generaImparells(15);
        ArrayList<Integer> esperat = new ArrayList<>();
        esperat.add(3);
        esperat.add(5);
        esperat.add(7);
        esperat.add(9);
        esperat.add(11);
        esperat.add(13);
        esperat.add(15);

        String diff = TestStringUtils.findFirstDifference(resultat.toString(), esperat.toString());
        assertTrue(diff.compareTo("identical") == 0,
            ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");

        // Cas 2: Generar imparells fins a 2 (no hi ha imparells)
        resultat = Exercici0008.generaImparells(2);
        esperat = new ArrayList<>(); // Buit

        diff = TestStringUtils.findFirstDifference(resultat.toString(), esperat.toString());
        assertTrue(diff.compareTo("identical") == 0,
            ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");

        // Cas 3: Generar imparells fins a 1 (fora de rang)
        resultat = Exercici0008.generaImparells(1);
        esperat = new ArrayList<>(); // Buit

        diff = TestStringUtils.findFirstDifference(resultat.toString(), esperat.toString());
        assertTrue(diff.compareTo("identical") == 0,
            ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");
    }

    @Test
    public void testMainFunction() throws Exception {
        Locale defaultLocale = Locale.getDefault();
        try {
            Locale.setDefault(Locale.US);

            // Cas 1: Nombres imparells fins a 15
            String text = SystemLambda.tapSystemOut(() -> 
                SystemLambda.withTextFromSystemIn("15\n").execute(() -> {
                    String[] args = {};
                    Exercici0008.main(args);
                })
            );

            String expectedOutput = """
                Introdueix un número: Nombres imparells entre 2 i 15: [3, 5, 7, 9, 11, 13, 15]
                """.replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");

            // Cas 2: Nombres imparells fins a 2 (fora de rang)
            text = SystemLambda.tapSystemOut(() -> 
                SystemLambda.withTextFromSystemIn("2\n").execute(() -> {
                    String[] args = {};
                    Exercici0008.main(args);
                })
            );

            expectedOutput = """
                Introdueix un número: No hi ha nombres imparells entre 2 i 2
                """.replace("\r\n", "\n").replace("        ", "");

            diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");

        } finally {
            Locale.setDefault(defaultLocale);
        }
    }
}
