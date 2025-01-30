package com.exercicis;

import com.testStringUtils.TestStringUtils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import static org.junit.jupiter.api.Assertions.*;

import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.util.Locale;

class TestExercici0006 {

    @Test
    public void testCalculaEntrada(TestInfo testInfo) throws Exception {
        try {
            String diff = TestStringUtils.findFirstDifference(
                String.valueOf(Exercici0006.calculaEntrada(1, 2, 1, "dimarts")),
                String.valueOf(20.8)
            );
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "\n<<<<<<<<<< Diff end <<<<<<<<<<");

            diff = TestStringUtils.findFirstDifference(
                String.valueOf(Exercici0006.calculaEntrada(1, 2, 2, "dijous")),
                String.valueOf(24.5)
            );
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "\n<<<<<<<<<< Diff end <<<<<<<<<<");

            diff = TestStringUtils.findFirstDifference(
                String.valueOf(Exercici0006.calculaEntrada(2, 0, 2, "dissabte")),
                String.valueOf(32.0)
            );
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "\n<<<<<<<<<< Diff end <<<<<<<<<<");

            diff = TestStringUtils.findFirstDifference(
                String.valueOf(Exercici0006.calculaEntrada(1, 1, 1, "diumenge")),
                String.valueOf(21.0)
            );
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "\n<<<<<<<<<< Diff end <<<<<<<<<<");

            diff = TestStringUtils.findFirstDifference(
                String.valueOf(Exercici0006.calculaEntrada(2, 3, 1, "dijous")),
                String.valueOf(28.5)
            );
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "\n<<<<<<<<<< Diff end <<<<<<<<<<");

            diff = TestStringUtils.findFirstDifference(
                String.valueOf(Exercici0006.calculaEntrada(4, 4, 4, "dimecres")),
                String.valueOf(84.0)
            );
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "\n<<<<<<<<<< Diff end <<<<<<<<<<");
                System.out.println("Test passed, succeeded!");

        } catch (AssertionError e) {
            System.out.println("Test failed: " + testInfo.getDisplayName());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
        }
    }

    @Test
    public void testMainFunction(TestInfo testInfo) throws Exception {
        Locale defaultLocale = Locale.getDefault(); 
        try {
            Locale.setDefault(Locale.US);

            String text = SystemLambda.tapSystemOut(() -> {
                String[] args = {};
                Exercici0006.main(args);
            });

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
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "\n<<<<<<<<<< Diff end <<<<<<<<<<");
        } finally {
            Locale.setDefault(defaultLocale); 
        }
    }
}
