package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.io.ByteArrayInputStream;
import java.util.Locale;

public class TestMain {

    @Test
    public void testImpostos() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String[] inputs = {
                "9000\n",
                "20000\n",
                "60000\n"
            };
            String[] expectedOutputs = {
                "Introdueix una xifra entre 0 i 100.000: Per un import de 9000, els impostos que has de pagar són un 10% i el total és 9900.00\n",
                "Introdueix una xifra entre 0 i 100.000: Per un import de 20000, els impostos que has de pagar són un 20% i el total és 24000.00\n",
                "Introdueix una xifra entre 0 i 100.000: Per un import de 60000, els impostos que has de pagar són un 30% i el total és 78000.00\n"
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
