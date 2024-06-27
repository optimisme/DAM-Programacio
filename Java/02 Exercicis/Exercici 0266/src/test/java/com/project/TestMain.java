// TestMain.java
package com.project;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMain {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final Locale defaultLocale = Locale.getDefault();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        Locale.setDefault(Locale.US);
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        Locale.setDefault(defaultLocale);
    }

    @Test
    public void testSeparaVocals() {
        List<String> paraules = Arrays.asList("Si,", "avui", "fa", "fred");
        String[][] resultat = Main.separaVocals(paraules);

        String[] expectedVocals = {"avui"};
        String[] expectedConsonants = {"Si", "fa", "fred"};

        assertArrayEquals(expectedVocals, resultat[0]);
        assertArrayEquals(expectedConsonants, resultat[1]);
    }

    @Test
    public void testVocalsAlFinal() {
        List<String> paraules = Arrays.asList("Adeu,", "en", "Pere", "va", "a", "casa");
        List<String> resultat = Main.vocalsAlFinal(paraules);

        List<String> expected = Arrays.asList("Adeu",  "Pere", "va", "a", "casa");

        assertEquals(expected, resultat);
    }

    @Test
    public void testOutput() {
        System.setIn(new ByteArrayInputStream("Hola, ara mateix estem aprenent Basc\n".getBytes()));

        Main.main(new String[]{});
        String output = outContent.toString().replace("\r\n", "\n");

        String expectedOutput = "Introdueix una llista de paraules separades per espais:\n" +
                                "Paraules que comencen per vocal: [ara, estem, aprenent]\n" +
                                "Paraules que comencen per consonant: [Hola, mateix, Basc]\n" +
                                "Paraules amb vocals al final: [Hola, ara]\n";

        assertTrue(output.equals(expectedOutput),
            "\nExpected output:\n" + expectedOutput + "\nActual output:\n" + output);
    }

    @Test
    public void testOutput2() {
        System.setIn(new ByteArrayInputStream("Demà és festa i anem a la platja\n".getBytes()));

        Main.main(new String[]{});
        String output = outContent.toString().replace("\r\n", "\n");

        String expectedOutput = "Introdueix una llista de paraules separades per espais:\n" +
                                "Paraules que comencen per vocal: [és, i, anem, a]\n" +
                                "Paraules que comencen per consonant: [Demà, festa, la, platja]\n" +
                                "Paraules amb vocals al final: [Demà, festa, i, a, la, platja]\n";

        assertTrue(output.equals(expectedOutput),
            "\nExpected output:\n" + expectedOutput + "\nActual output:\n" + output);
    }
}
