package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;

public class TestMain {

    @Test
    public void testMenuOpcions() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String input = "1\n2\n3\n";
            String expectedOutput = "Menú:\n" +
                                    "1. Saluda\n" +
                                    "2. Parla\n" +
                                    "3. Sortir\n" +
                                    "Escull una opció: Hola!\n" +
                                    "Menú:\n" +
                                    "1. Saluda\n" +
                                    "2. Parla\n" +
                                    "3. Sortir\n" +
                                    "Escull una opció: (frase aleatòria)\n" +
                                    "Menú:\n" +
                                    "1. Saluda\n" +
                                    "2. Parla\n" +
                                    "3. Sortir\n" +
                                    "Escull una opció: Sortint...\n";

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

            // Elimina la frase aleatòria per a la comparació
            String actualOutputWithoutRandom = actualOutput.replaceAll("Tinc un gos que es diu Pelut|M'agrada menjar xocolata|Vull vitajar al Japó", "(frase aleatòria)");
            String diff = TestStringUtils.findFirstDifference(actualOutputWithoutRandom, expectedOutput);
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
