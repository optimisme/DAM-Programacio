package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;

public class TestMain {

    @Test
    public void testMainOutputOption1Then3() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String input = "1\n3\n"; // Simula l'entrada de l'usuari (opció 1, després opció 3)
            String expectedOutput = "        ********Menú Principal********\n" +
                                    "        1.                Veure perfil\n" +
                                    "        2.         Canviar contrasenya\n" +
                                    "        3.                      Sortir\n" +
                                    "Escull una opció: Veure perfil (1)\n" +
                                    "Escull una opció: Escull una opció: Sortir (3)\n";

            // Redirigeix la sortida estàndard a un flux de sortida
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(outContent));

            // Simula l'entrada de l'usuari
            System.setIn(new ByteArrayInputStream(input.getBytes()));

            // Executa el main per a provar la seva sortida
            Main.main(new String[]{});

            // Comprova que la sortida conté el text esperat
            String actualOutput = outContent.toString().replace("\r\n", "\n"); // Normalitza les noves línies
            String diff = TestStringUtils.findFirstDifference(actualOutput, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0, 
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                diff +
                "<<<<<<<<<< <<<<<<<<<<\n");

            // Restaura els fluxos originals
            System.setOut(originalOut);
        } finally {
            Locale.setDefault(defaultLocale); // Restaura la configuració regional per defecte
        }
    }

    @Test
    public void testMainOutputOption2Then3() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String input = "2\n3\n"; // Simula l'entrada de l'usuari (opció 2, després opció 3)
            String expectedOutput = "        ********Menú Principal********\n" +
                                    "        1.                Veure perfil\n" +
                                    "        2.         Canviar contrasenya\n" +
                                    "        3.                      Sortir\n" +
                                    "Escull una opció: Canviar contrasenya (2)\n" +
                                    "Escull una opció: Escull una opció: Sortir (3)\n";

            // Redirigeix la sortida estàndard a un flux de sortida
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(outContent));

            // Simula l'entrada de l'usuari
            System.setIn(new ByteArrayInputStream(input.getBytes()));

            // Executa el main per a provar la seva sortida
            Main.main(new String[]{});

            // Comprova que la sortida conté el text esperat
            String actualOutput = outContent.toString().replace("\r\n", "\n"); // Normalitza les noves línies
            String diff = TestStringUtils.findFirstDifference(actualOutput, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0, 
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                diff +
                "<<<<<<<<<< <<<<<<<<<<\n");

            // Restaura els fluxos originals
            System.setOut(originalOut);
        } finally {
            Locale.setDefault(defaultLocale); // Restaura la configuració regional per defecte
        }
    }

    @Test
    public void testMainOutputInvalidOptionThen3() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String input = "4\n3\n"; // Simula l'entrada de l'usuari (opció invàlida, després opció 3)
            String expectedOutput = "        ********Menú Principal********\n" +
                                    "        1.                Veure perfil\n" +
                                    "        2.         Canviar contrasenya\n" +
                                    "        3.                      Sortir\n" +
                                    "Escull una opció: Opció no vàlida\n" +
                                    "Escull una opció: Escull una opció: Sortir (3)\n";

            // Redirigeix la sortida estàndard a un flux de sortida
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(outContent));

            // Simula l'entrada de l'usuari
            System.setIn(new ByteArrayInputStream(input.getBytes()));

            // Executa el main per a provar la seva sortida
            Main.main(new String[]{});

            // Comprova que la sortida conté el text esperat
            String actualOutput = outContent.toString().replace("\r\n", "\n"); // Normalitza les noves línies
            String diff = TestStringUtils.findFirstDifference(actualOutput, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0, 
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                diff +
                "<<<<<<<<<< <<<<<<<<<<\n");

            // Restaura els fluxos originals
            System.setOut(originalOut);
        } finally {
            Locale.setDefault(defaultLocale); // Restaura la configuració regional per defecte
        }
    }
}
