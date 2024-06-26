package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.io.ByteArrayInputStream;
import java.util.Locale;

public class TestMain {

    @Test
    public void testCalculaTarifa() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String[] inputs = {
                "148\n20\n",
                "264\n40\n",
                "420\n180\n",
                "520\n240\n"
            };
            String[] expectedOutputs = {
                "Introdueix el nombre de minuts parlats: Introdueix el nombre de SMS enviats: El cost mensual de la factura és 15.00€\n",
                "Introdueix el nombre de minuts parlats: Introdueix el nombre de SMS enviats: El cost mensual de la factura és 21.40€\n",
                "Introdueix el nombre de minuts parlats: Introdueix el nombre de SMS enviats: El cost mensual de la factura és 43.50€\n",
                "Introdueix el nombre de minuts parlats: Introdueix el nombre de SMS enviats: El cost mensual de la factura és 56.50€\n"
            };

            for (int i = 0; i < inputs.length; i++) {
                String input = inputs[i];
                String expectedOutput = expectedOutputs[i];

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
            }
        } finally {
            Locale.setDefault(defaultLocale); // Restaura la configuració regional per defecte
        }
    }
}
