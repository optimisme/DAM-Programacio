package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.io.ByteArrayInputStream;
import java.util.Locale;

public class TestMain {

    @Test
    public void testCalculaConsum() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String[] inputs = {
                "800\n",
                "6000\n",
                "9000\n",
                "12000\n"
            };
            String[] expectedOutputs = {
                "Introdueix el nombre de litres consumits: La factura d'aigua per 800 litres és 10.00€\n",
                "Introdueix el nombre de litres consumits: La factura d'aigua per 6000 litres és 120.00€\n",
                "Introdueix el nombre de litres consumits: La factura d'aigua per 9000 litres és 210.00€\n",
                "Introdueix el nombre de litres consumits: La factura d'aigua per 12000 litres és 340.00€\n"
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
