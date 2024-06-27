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
            String input = "Gattacca\nAndrew Niccol\n1997\nInception\nChristopher Nolan\n2010\n";
            String expectedOutput = "Introdueix el títol de la pel·lícula: Introdueix el director de la pel·lícula: Introdueix l'any de la pel·lícula: " +
                                    "Introdueix el títol de la pel·lícula: Introdueix el director de la pel·lícula: Introdueix l'any de la pel·lícula: " +
                                    "Títol: Gattacca, Director: Andrew Niccol, Any: 1997\n" +
                                    "Títol: Inception, Director: Christopher Nolan, Any: 2010\n";

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
