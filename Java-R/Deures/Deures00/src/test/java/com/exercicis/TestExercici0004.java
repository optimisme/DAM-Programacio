package com.exercicis;

import com.testStringUtils.TestStringUtils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.util.Locale;

class TestExercici0004 {

    @Test
    public void testContaMajuscules() {
        assertEquals(2, Exercici0004.contaMajuscules("PassWord123"));
        assertEquals(0, Exercici0004.contaMajuscules("password"));
        assertEquals(8, Exercici0004.contaMajuscules("PASSWORD123"));
        assertEquals(1, Exercici0004.contaMajuscules("P"));
        assertEquals(0, Exercici0004.contaMajuscules(""));
    }

    @Test
    public void testContaMinuscules() {
        assertEquals(6, Exercici0004.contaMinuscules("PassWord123"));
        assertEquals(8, Exercici0004.contaMinuscules("password"));
        assertEquals(0, Exercici0004.contaMinuscules("PASSWORD123"));
        assertEquals(1, Exercici0004.contaMinuscules("p"));
        assertEquals(0, Exercici0004.contaMinuscules(""));
    }

    @Test
    public void testValidaContrasenya() {
        assertEquals("La contrasenya és vàlida", Exercici0004.validaContrasenya("PassWord123"));
        assertEquals("La contrasenya NO és vàlida", Exercici0004.validaContrasenya("password"));
        assertEquals("La contrasenya NO és vàlida", Exercici0004.validaContrasenya("PASSWORD"));
        assertEquals("La contrasenya NO és vàlida", Exercici0004.validaContrasenya("Pass12"));
        assertEquals("La contrasenya és vàlida", Exercici0004.validaContrasenya("PassWord"));
        assertEquals("La contrasenya és vàlida", Exercici0004.validaContrasenya("ValidPass123"));
        assertEquals("La contrasenya és vàlida", Exercici0004.validaContrasenya("AnotherValid1"));
    }

    @Test
    public void testMainFunctionValidPwd() throws Exception {
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
                ">>>>>>>>>> >>>>>>>>>>\n" +
                diff +
                "<<<<<<<<<< <<<<<<<<<<\n");
        } finally {
            Locale.setDefault(defaultLocale);
        }
    }

    @Test
    public void testMainFunctionInvalidPwd() throws Exception {
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
                ">>>>>>>>>> >>>>>>>>>>\n" +
                diff +
                "<<<<<<<<<< <<<<<<<<<<\n");
        } finally {
            Locale.setDefault(defaultLocale);
        }
    }

    @Test
    public void testMainFunctionEdgeCase() throws Exception {
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
                ">>>>>>>>>> >>>>>>>>>>\n" +
                diff +
                "<<<<<<<<<< <<<<<<<<<<\n");
        } finally {
            Locale.setDefault(defaultLocale);
        }
    }
}
