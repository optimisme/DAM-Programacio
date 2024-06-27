// TestMain.java
package com.project;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMain {

    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut); // Restaura la sortida estàndard
        Locale.setDefault(defaultLocale); // Restaura la configuració regional per defecte
    }

    @Test
    public void testMainOutput() {
        // Simula la introducció de dades des del teclat
        System.setIn(new java.io.ByteArrayInputStream("10\n".getBytes()));
        Main.main(new String[]{}); // Executa el main

        String text = outContent.toString().replace("\r\n", "\n");

        // Comprova que la sortida conté el text esperat
        String expectedOutput = "Introdueix un número: 1\n3\n5\n7\n9\n";
        assertTrue(text.contains(expectedOutput),
                "\nExpected output: " + expectedOutput + "\nActual output: " + text);
    }
}
