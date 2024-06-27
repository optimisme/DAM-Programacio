package com.project;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMain {

    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testConvertirArray() {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String[] numeros = {"4", "5", "6", "7"};
            List<Integer> result = Main.convertirArray(numeros);

            List<Integer> expected = Arrays.asList(4, 5, 6, 7);
            assertEquals(expected, result);
        } finally {
            Locale.setDefault(defaultLocale); // Restaura la configuració regional per defecte
        }
    }

    @Test
    public void testConvertirLlista() {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            ArrayList<String> numeros = new ArrayList<>(Arrays.asList("4", "5", "6", "7"));
            List<Integer> result = Main.convertirLlista(numeros);

            List<Integer> expected = Arrays.asList(4, 5, 6, 7);
            assertEquals(expected, result);
        } finally {
            Locale.setDefault(defaultLocale); // Restaura la configuració regional per defecte
        }
    }

    @Test
    public void testOutputArray() {
        try {
            Main.main(new String[]{});
            String text = outContent.toString().replace("\r\n", "\n");

            String expectedOutput = "Convertit des d'array: [4, 5, 6, 7]\n" +
                                    "Convertit des de llista: [4, 5, 6, 7]\n";
            assertTrue(text.contains(expectedOutput),
                "\nExpected output not found:\n" + text);
        } finally {
            Locale.setDefault(Locale.getDefault()); // Restaura la configuració regional per defecte
        }
    }
}
