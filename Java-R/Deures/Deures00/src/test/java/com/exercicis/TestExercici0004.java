package com.exercicis;

import com.testStringUtils.TestStringUtils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import static org.junit.jupiter.api.Assertions.*;

import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.util.Locale;

class TestExercici0004 {

    @Test
    public void testContaMajuscules(TestInfo testInfo) throws Exception {
        try {
            String diff = TestStringUtils.findFirstDifference(
                String.valueOf(Exercici0004.contaMajuscules("PassWord123")), 
                "2"
            );
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<");

            diff = TestStringUtils.findFirstDifference(
                String.valueOf(Exercici0004.contaMajuscules("password")), 
                "0"
            );
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<");
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
    public void testContaMinuscules(TestInfo testInfo) throws Exception {
        try {
            String diff = TestStringUtils.findFirstDifference(
                String.valueOf(Exercici0004.contaMinuscules("PassWord123")), 
                "6"
            );
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<");

            diff = TestStringUtils.findFirstDifference(
                String.valueOf(Exercici0004.contaMinuscules("PASSWORD123")), 
                "0"
            );
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<");
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
    public void testValidaContrasenya(TestInfo testInfo) throws Exception {
        try {
            String diff = TestStringUtils.findFirstDifference(
                Exercici0004.validaContrasenya("PassWord123"), 
                "La contrasenya és vàlida"
            );
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<");

            diff = TestStringUtils.findFirstDifference(
                Exercici0004.validaContrasenya("password"), 
                "La contrasenya NO és vàlida"
            );
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<");
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
    public void testMainFunctionValidPwd(TestInfo testInfo) throws Exception {
        Locale defaultLocale = Locale.getDefault();
        try {
            Locale.setDefault(Locale.US);

            String text = SystemLambda.tapSystemOut(() -> 
                SystemLambda.withTextFromSystemIn("PassWord123\n").execute(() -> {
                    String[] args = {};
                    Exercici0004.main(args);
                })
            );

            text = text.replace("\r\n", "\n");

            String expectedOutput = """
                Escriu una contrasenya: La contrasenya 'PassWord123': La contrasenya és vàlida
                """.replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<");
        } finally {
            Locale.setDefault(defaultLocale);
        }
    }

    @Test
    public void testMainFunctionInvalidPwd(TestInfo testInfo) throws Exception {
        Locale defaultLocale = Locale.getDefault();
        try {
            Locale.setDefault(Locale.US);

            String text = SystemLambda.tapSystemOut(() -> 
                SystemLambda.withTextFromSystemIn("password\n").execute(() -> {
                    String[] args = {};
                    Exercici0004.main(args);
                })
            );

            text = text.replace("\r\n", "\n");

            String expectedOutput = """
                Escriu una contrasenya: La contrasenya 'password': La contrasenya NO és vàlida
                """.replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<");
        } finally {
            Locale.setDefault(defaultLocale);
        }
    }

    @Test
    public void testMainFunctionEdgeCase(TestInfo testInfo) throws Exception {
        Locale defaultLocale = Locale.getDefault();
        try {
            Locale.setDefault(Locale.US);

            String text = SystemLambda.tapSystemOut(() -> 
                SystemLambda.withTextFromSystemIn("Pass12\n").execute(() -> {
                    String[] args = {};
                    Exercici0004.main(args);
                })
            );

            text = text.replace("\r\n", "\n");

            String expectedOutput = """
                Escriu una contrasenya: La contrasenya 'Pass12': La contrasenya NO és vàlida
                """.replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<");
        } finally {
            Locale.setDefault(defaultLocale);
        }
    }
}
