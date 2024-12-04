package com.exercicis;

import com.testStringUtils.TestStringUtils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.util.Locale;

class TestExercici0005 {

    @Test
    public void testIsPalindrom() {
        assertTrue(Exercici0005.isPalindrom("Anul·la la lluna"));
        assertFalse(Exercici0005.isPalindrom("Atrapa la lluna"));
        assertTrue(Exercici0005.isPalindrom("Atrapa'l o l'aparta"));
        assertFalse(Exercici0005.isPalindrom("Aparta'l o atrapa'l"));
        assertTrue(Exercici0005.isPalindrom("No sap pas on"));
        assertFalse(Exercici0005.isPalindrom("On sap pas qui"));
        assertTrue(Exercici0005.isPalindrom("Tramaran anar a Mart"));
        assertFalse(Exercici0005.isPalindrom("A Mart trobaràn art"));
        assertTrue(Exercici0005.isPalindrom("Un pop nu"));
        assertTrue(Exercici0005.isPalindrom("Nu pop un"));
    }

    @Test
    public void testNormalize() {
        assertEquals("anullalalluna", Exercici0005.normalize("Anul·la la lluna"));
        assertEquals("atrapalalluna", Exercici0005.normalize("Atrapa la lluna"));
        assertEquals("atrapalolaparta", Exercici0005.normalize("Atrapa'l o l'aparta"));
        assertEquals("apartaloatrapal", Exercici0005.normalize("Aparta'l o atrapa'l"));
        assertEquals("nosappason", Exercici0005.normalize("No sap pas on"));
        assertEquals("tramarananaramart", Exercici0005.normalize("Tramaran anar a Mart"));
    }

    @Test
    public void testMainOutput() throws Exception {
        Locale defaultLocale = Locale.getDefault();
        try {
            Locale.setDefault(Locale.US);

            String text = SystemLambda.tapSystemOut(() -> {
                String[] args = {};
                Exercici0005.main(args); // Invocar el main
            });

            text = text.replace("\r\n", "\n");

            String expectedOutput = """
                Anul·la la lluna (Si)
                Atrapa la lluna (No)
                Atrapa'l o l'aparta (Si)
                Aparta'l o atrapa'l (No)
                No sap pas on (Si)
                On sap pas qui (No)
                Tramaran anar a Mart (Si)
                A Mart trobaràn art (No)
                Un pop nu (Si)
                Nu pop un (Si)
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
