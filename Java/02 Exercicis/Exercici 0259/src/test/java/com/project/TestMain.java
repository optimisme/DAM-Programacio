package com.project;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Locale;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMain {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    public void testMenuOpcioSortir() {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String input = "0";
            System.setIn(new ByteArrayInputStream(input.getBytes()));

            Main.main(new String[]{});
            String text = outContent.toString().replace("\r\n", "\n");

            String expectedOutput = "    CALCULADORA\n" +
                                    "    Menú Principal\n" +
                                    "    1 - Sumar\n" +
                                    "    2 - Restar\n" +
                                    "    3 - Multiplicar\n" +
                                    "    4 - Dividir\n" +
                                    "    0 - Sortir\n" +
                                    "Opció: ";
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0, 
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                diff +
                "<<<<<<<<<< <<<<<<<<<<\n");
        } finally {
            Locale.setDefault(defaultLocale); // Restaura la configuració regional per defecte
        }
    }

    @Test
    public void testOpcioIncorrecta() {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String input = "5\n0";
            System.setIn(new ByteArrayInputStream(input.getBytes()));

            Main.main(new String[]{});
            String text = outContent.toString().replace("\r\n", "\n");

            String expectedOutput = "    CALCULADORA\n" +
                                    "    Menú Principal\n" +
                                    "    1 - Sumar\n" +
                                    "    2 - Restar\n" +
                                    "    3 - Multiplicar\n" +
                                    "    4 - Dividir\n" +
                                    "    0 - Sortir\n" +
                                    "Opció: Opció incorrecta\n" +
                                    "    CALCULADORA\n" +
                                    "    Menú Principal\n" +
                                    "    1 - Sumar\n" +
                                    "    2 - Restar\n" +
                                    "    3 - Multiplicar\n" +
                                    "    4 - Dividir\n" +
                                    "    0 - Sortir\n" +
                                    "Opció: ";
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0, 
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                diff +
                "<<<<<<<<<< <<<<<<<<<<\n");
        } finally {
            Locale.setDefault(defaultLocale); // Restaura la configuració regional per defecte
        }
    }

    @Test
    public void testOperacions() {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String input = "1\n5\n3\n0";
            System.setIn(new ByteArrayInputStream(input.getBytes()));

            Main.main(new String[]{});
            String text = outContent.toString().replace("\r\n", "\n");

            String expectedOutput = "    CALCULADORA\n" +
                                    "    Menú Principal\n" +
                                    "    1 - Sumar\n" +
                                    "    2 - Restar\n" +
                                    "    3 - Multiplicar\n" +
                                    "    4 - Dividir\n" +
                                    "    0 - Sortir\n" +
                                    "Opció: Introdueix el primer número: Introdueix el segon número: El resultat de Sumar 5.000000 i 3.000000 és: 8.000000\n" +
                                    "    CALCULADORA\n" +
                                    "    Menú Principal\n" +
                                    "    1 - Sumar\n" +
                                    "    2 - Restar\n" +
                                    "    3 - Multiplicar\n" +
                                    "    4 - Dividir\n" +
                                    "    0 - Sortir\n" +
                                    "Opció: ";
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0, 
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                diff +
                "<<<<<<<<<< <<<<<<<<<<\n");
        } finally {
            Locale.setDefault(defaultLocale); // Restaura la configuració regional per defecte
        }
    }
}
