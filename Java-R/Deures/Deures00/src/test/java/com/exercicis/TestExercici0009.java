package com.exercicis;

import com.testStringUtils.TestStringUtils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import static org.junit.jupiter.api.Assertions.*;

import com.github.stefanbirkner.systemlambda.SystemLambda;

class TestExercici0009 {

    @Test
    public void testDibuixarRectangle(TestInfo testInfo) throws Exception {
        try {
            // Cas 1: Rectangle de 5x3
            String text = SystemLambda.tapSystemOut(() -> {
                Exercici0009.dibuixarRectangle(5, 3);
            });
            String expectedOutput = """
                *****
                *ooo*
                *****
                """;

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0, 
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");

            // Cas 2: Rectangle de 8x4
            text = SystemLambda.tapSystemOut(() -> {
                Exercici0009.dibuixarRectangle(8, 4);
            });
            expectedOutput = """
                ********
                *oooooo*
                *oooooo*
                ********
                """;

            diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0, 
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");

            // Cas 3: Dimensions invàlides (ample o alt menor que 2)
            text = SystemLambda.tapSystemOut(() -> {
                Exercici0009.dibuixarRectangle(1, 2);
            });
            expectedOutput = "L'ample i l'alt han de ser com a mínim 2.\n";

            diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0, 
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");
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
        try {
            // Cas 1: Rectangle 5x3
            String text = SystemLambda.tapSystemOut(() -> 
                SystemLambda.withTextFromSystemIn("5\n3\n").execute(() -> {
                    String[] args = {};
                    Exercici0009.main(args);
                })
            );
            String expectedOutput = """
                Introdueix l'ample del rectangle: Introdueix l'alt del rectangle: Resultat:
                *****
                *ooo*
                *****
                """;

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0, 
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");

            // Cas 2: Dimensions invàlides
            text = SystemLambda.tapSystemOut(() -> 
                SystemLambda.withTextFromSystemIn("1\n2\n").execute(() -> {
                    String[] args = {};
                    Exercici0009.main(args);
                })
            );
            expectedOutput = """
                Introdueix l'ample del rectangle: Introdueix l'alt del rectangle: Resultat:
                L'ample i l'alt han de ser com a mínim 2.
                """;

            diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0, 
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");
            System.out.println("Test passed, succeeded!");

        } catch (AssertionError e) {
            System.out.println("Test failed: " + testInfo.getDisplayName());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
        }
    }
}
