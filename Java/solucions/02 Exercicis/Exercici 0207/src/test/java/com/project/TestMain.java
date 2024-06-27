package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;

public class TestMain {

    @Test
    public void testMainOutput() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String input = "7.5\n8.0\n9.5\n"; // Simula l'entrada de l'usuari (7.5, 8.0, 9.5)
            String expectedOutput = "Introdueix la primera nota: Introdueix la segona nota: Introdueix la tercera nota: La nota mitjana entre 7.50, 8.00, 9.50 és 8.33\n";

            // Redirigeix la sortida estàndard a un flux de sortida
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(outContent));

            // Redirigeix l'entrada estàndard a un flux d'entrada
            ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
            System.setIn(inContent);

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
            System.setIn(System.in);
        } finally {
            Locale.setDefault(defaultLocale); // Restaura la configuració regional per defecte
        }
    }
}
