package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Year;
import java.util.Locale;

public class TestMain {

    @Test
    public void testValidaTargeta() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            int anyActual = Year.now().getValue();
            String[] inputs = {
                "2020\n",
                "2021\n",
                "2053\n",
                "2065\n",
                anyActual + "\n",
                (anyActual + 1) + "\n"
            };
            String[] expectedOutputs = {
                "Introdueix l'any de vigència de la targeta: La targeta ha caducat.\n",
                "Introdueix l'any de vigència de la targeta: La targeta ha caducat.\n",
                "Introdueix l'any de vigència de la targeta: La targeta és vigent.\n",
                "Introdueix l'any de vigència de la targeta: La targeta és vigent.\n",
                "Introdueix l'any de vigència de la targeta: La targeta és vigent.\n",
                "Introdueix l'any de vigència de la targeta: La targeta és vigent.\n"
            };

            for (int i = 0; i < inputs.length; i++) {
                String input = inputs[i];
                String expectedOutput = expectedOutputs[i];

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
            }
        } finally {
            Locale.setDefault(defaultLocale); // Restaura la configuració regional per defecte
        }
    }
}
