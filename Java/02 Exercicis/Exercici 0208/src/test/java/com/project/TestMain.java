package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.io.ByteArrayInputStream;
import java.util.Locale;

public class TestMain {

    @Test
    public void testMainOutput() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String input = "5\n10\n7\n"; // Simula l'entrada de l'usuari (5, 10, 7)
            String expectedOutput = "Longitud de la primera base: Longitud de la segona base: Altura: L'àrea del trapèzi és: 52.50\nL'àrea del trapèzi amb les bases intercanviades és: 52.50\n";

            String actualOutput = SystemLambda.tapSystemOut(() -> {
                System.setIn(new ByteArrayInputStream(input.getBytes())); // Simula l'entrada de l'usuari
                Main.main(new String[]{});
            });

            actualOutput = actualOutput.replace("\r\n", "\n"); // Normalitza les noves línies
            String diff = TestStringUtils.findFirstDifference(actualOutput, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0, 
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                diff +
                "<<<<<<<<<< <<<<<<<<<<\n");
        } finally {
            Locale.setDefault(defaultLocale); // Restaura la configuració regional per defecte
        }
    }
}
