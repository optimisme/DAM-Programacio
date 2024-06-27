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
        System.setIn(System.in);
        Locale.setDefault(defaultLocale);
    }

    @Test
    public void testCalculaValors() {
        List<Integer> numeros1 = Arrays.asList(4, 8, 7, 2, 5, 3, 9);
        assertEquals(38, Main.calculaSuma(numeros1));
        assertEquals(9, Main.calculaMaxim(numeros1));
        assertEquals(2, Main.calculaMinim(numeros1));
        assertEquals(5.43, Main.calculaMitjana(numeros1), 0.01);

        List<Integer> numeros2 = Arrays.asList(7, 2, 4, 8, 4, 2);
        assertEquals(27, Main.calculaSuma(numeros2));
        assertEquals(8, Main.calculaMaxim(numeros2));
        assertEquals(2, Main.calculaMinim(numeros2));
        assertEquals(4.5, Main.calculaMitjana(numeros2), 0.01);
    }

    @Test
    public void testOutput() throws Exception {
        System.setIn(new ByteArrayInputStream("4,8,7,2,5,3,9\n".getBytes()));

        Main.main(new String[]{});
        String output = outContent.toString().replace("\r\n", "\n");

        String expectedOutput = "Introdueix una llista de números enters separats per comes:\n" +
                                "Suma = 38, Màxim = 9, Mínim = 2, Mitjana = 5.43\n";

        assertTrue(output.equals(expectedOutput),
            "\nExpected output:\n" + expectedOutput + "\nActual output:\n" + output);
    }

    @Test
    public void testOutput2() throws Exception {
        System.setIn(new ByteArrayInputStream("7,2,4,8,4,2\n".getBytes()));

        Main.main(new String[]{});
        String output = outContent.toString().replace("\r\n", "\n");

        String expectedOutput = "Introdueix una llista de números enters separats per comes:\n" +
                                "Suma = 27, Màxim = 8, Mínim = 2, Mitjana = 4.50\n";

        assertTrue(output.equals(expectedOutput),
            "\nExpected output:\n" + expectedOutput + "\nActual output:\n" + output);
    }
}
