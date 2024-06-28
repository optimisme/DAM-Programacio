package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;

public class TestMain {

    @Test
    public void testConversio() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String[] inputs = {
                "1\n1000\n",
                "2\n1\n",
                "3\n1000\n",
                "4\n39.37\n",
                "5\n1000000\n",
                "6\n1\n"
            };
            String[] expectedOutputs = {
                "Conversió de mesures:\n" +
                "1. Metres a Milles\n" +
                "2. Milles a Metres\n" +
                "3. Metres a Polzades\n" +
                "4. Polzades a Metres\n" +
                "5. Polzades a Milles\n" +
                "6. Milles a Polzades\n" +
                "Escull una opció de conversió: S'ha escollit conversió 'Metres a Milles', introdueix la quantitat de metres: La conversió 'Metres a Milles' de 1000.00 és 0.62\n",

                "Conversió de mesures:\n" +
                "1. Metres a Milles\n" +
                "2. Milles a Metres\n" +
                "3. Metres a Polzades\n" +
                "4. Polzades a Metres\n" +
                "5. Polzades a Milles\n" +
                "6. Milles a Polzades\n" +
                "Escull una opció de conversió: S'ha escollit conversió 'Milles a Metres', introdueix la quantitat de milles: La conversió 'Milles a Metres' de 1.00 és 1609.34\n",

                "Conversió de mesures:\n" +
                "1. Metres a Milles\n" +
                "2. Milles a Metres\n" +
                "3. Metres a Polzades\n" +
                "4. Polzades a Metres\n" +
                "5. Polzades a Milles\n" +
                "6. Milles a Polzades\n" +
                "Escull una opció de conversió: S'ha escollit conversió 'Metres a Polzades', introdueix la quantitat de metres: La conversió 'Metres a Polzades' de 1000.00 és 39370.10\n",

                "Conversió de mesures:\n" +
                "1. Metres a Milles\n" +
                "2. Milles a Metres\n" +
                "3. Metres a Polzades\n" +
                "4. Polzades a Metres\n" +
                "5. Polzades a Milles\n" +
                "6. Milles a Polzades\n" +
                "Escull una opció de conversió: S'ha escollit conversió 'Polzades a Metres', introdueix la quantitat de polzades: La conversió 'Polzades a Metres' de 39.37 és 1.00\n",

                "Conversió de mesures:\n" +
                "1. Metres a Milles\n" +
                "2. Milles a Metres\n" +
                "3. Metres a Polzades\n" +
                "4. Polzades a Metres\n" +
                "5. Polzades a Milles\n" +
                "6. Milles a Polzades\n" +
                "Escull una opció de conversió: S'ha escollit conversió 'Polzades a Milles', introdueix la quantitat de polzades: La conversió 'Polzades a Milles' de 1000000.00 és 15.78\n",

                "Conversió de mesures:\n" +
                "1. Metres a Milles\n" +
                "2. Milles a Metres\n" +
                "3. Metres a Polzades\n" +
                "4. Polzades a Metres\n" +
                "5. Polzades a Milles\n" +
                "6. Milles a Polzades\n" +
                "Escull una opció de conversió: S'ha escollit conversió 'Milles a Polzades', introdueix la quantitat de milles: La conversió 'Milles a Polzades' de 1.00 és 63360.00\n"
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
