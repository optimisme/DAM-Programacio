package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;

public class TestMain {

    @Test
    public void testNumeroAleatori() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            for (int i = 0; i < 5; i++) {
                // Redirigeix la sortida estàndard a un flux de sortida
                ByteArrayOutputStream outContent = new ByteArrayOutputStream();
                PrintStream originalOut = System.out;
                System.setOut(new PrintStream(outContent));

                // Executa el main per a provar la seva sortida
                Main.main(new String[]{});

                // Comprova que la sortida conté el text esperat
                String actualOutput = outContent.toString().replace("\r\n", "\n"); // Normalitza les noves línies
                boolean outputIsValid = validateOutput(actualOutput);
                assertTrue(outputIsValid, "La sortida no és vàlida:\n" + actualOutput);

                // Restaura els fluxos originals
                System.setOut(originalOut);
            }
        } finally {
            Locale.setDefault(defaultLocale); // Restaura la configuració regional per defecte
        }
    }

    private boolean validateOutput(String output) {
        String[] lines = output.split("\n");
        if (lines.length != 2) {
            return false;
        }
        String numeroLine = lines[0];
        String expectedPrefix = "El número escollit és: ";
        if (!numeroLine.startsWith(expectedPrefix)) {
            return false;
        }
        int numero;
        try {
            numero = Integer.parseInt(numeroLine.substring(expectedPrefix.length()));
        } catch (NumberFormatException e) {
            return false;
        }

        String expectedMessage;
        if (numero <= 25) {
            expectedMessage = "El número és petit";
        } else if (numero <= 74) {
            expectedMessage = "El número és mitjà";
        } else {
            expectedMessage = "El número és gran";
        }
        return expectedMessage.equals(lines[1]);
    }
}
