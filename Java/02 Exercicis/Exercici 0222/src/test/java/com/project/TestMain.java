package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.util.Locale;

public class TestMain {

    @Test
    public void testNumeroAleatori() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            for (int i = 0; i < 5; i++) {
                String actualOutput = SystemLambda.tapSystemOut(() -> {
                    Main.main(new String[]{});
                });

                actualOutput = actualOutput.replace("\r\n", "\n"); // Normalitza les noves línies
                boolean outputIsValid = validateOutput(actualOutput);
                assertTrue(outputIsValid, "La sortida no és vàlida:\n" + actualOutput);
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
