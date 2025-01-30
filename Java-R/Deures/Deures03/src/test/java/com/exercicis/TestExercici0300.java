package com.exercicis;

import com.exercici0300.*;
import com.testStringUtils.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import static org.junit.jupiter.api.Assertions.*;

import com.github.stefanbirkner.systemlambda.SystemLambda;

class TestExercici0300 {

    @BeforeEach
    public void resetEstudiantState() {
        // Reinicia el comptador d'estudiants abans de cada test
        try {
            java.lang.reflect.Field field = Estudiant.class.getDeclaredField("comptadorEstudiants");
            field.setAccessible(true);
            field.set(null, 0);
        } catch (Exception e) {
            throw new RuntimeException("Error al reiniciar l'estat de la classe Estudiant", e);
        }
    }

    @Test
    public void testMaxCapacityExceeded(TestInfo testInfo) throws Exception {
        try {
            String text = SystemLambda.tapSystemOut(() -> {
                String[] args = {};
                Main.main(args);
            });

            text = text.replace("\r\n", "\n");

            String expectedOutput = """
                Intent registrant: Estudiant1. Total registrats: 1
                Intent registrant: Estudiant2. Total registrats: 2
                Intent registrant: Estudiant3. Total registrats: 3
                Intent registrant: Estudiant4. Total registrats: 4
                Intent registrant: Estudiant5. Total registrats: 5
                Error: No es poden registrar més estudiants. Capacitat màxima assolida.
                Intent registrant: Estudiant6. Total registrats: 5
                No hi ha més capacitat per a registrar estudiants.
                """.replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");
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
    public void testRemainingCapacityCheck(TestInfo testInfo) throws Exception {
        try {
            String text = SystemLambda.tapSystemOut(() -> {
                for (int i = 1; i <= 4; i++) {
                    new Estudiant("Estudiant" + i, "ID" + i);
                }
                System.out.println(Estudiant.hiHaCapacitat() ? "Encara hi ha capacitat per a més estudiants." : "No hi ha més capacitat per a registrar estudiants.");
            });

            text = text.replace("\r\n", "\n");

            String expectedOutput = """
                Encara hi ha capacitat per a més estudiants.
                """.replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");

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
    public void testNoRemainingCapacity(TestInfo testInfo) throws Exception {
        try {
            String text = SystemLambda.tapSystemOut(() -> {
                for (int i = 1; i <= 5; i++) {
                    new Estudiant("Estudiant" + i, "ID" + i);
                }
                System.out.println(Estudiant.hiHaCapacitat() ? "Encara hi ha capacitat per a més estudiants." : "No hi ha més capacitat per a registrar estudiants.");
            });

            text = text.replace("\r\n", "\n");

            String expectedOutput = """
                No hi ha més capacitat per a registrar estudiants.
                """.replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");
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