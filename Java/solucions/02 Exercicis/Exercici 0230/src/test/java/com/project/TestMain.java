package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.io.ByteArrayInputStream;
import java.util.Locale;

public class TestMain {

    @Test
    public void testCalculaIRPF() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String[] inputs = {
                "7600\n",
                "16000\n",
                "26000\n",
                "32000\n",
                "54500\n",
                "64832\n",
                "275387\n",
                "765915\n"
            };
            String[] expectedOutputs = {
                "Introdueix els ingressos bruts: L'IRPF a pagar per uns ingressos de 7600.00€ és 1444.00€\n",
                "Introdueix els ingressos bruts: L'IRPF a pagar per uns ingressos de 16000.00€ és 3217.50€\n",
                "Introdueix els ingressos bruts: L'IRPF a pagar per uns ingressos de 26000.00€ és 5965.50€\n",
                "Introdueix els ingressos bruts: L'IRPF a pagar per uns ingressos de 32000.00€ és 7765.50€\n",
                "Introdueix els ingressos bruts: L'IRPF a pagar per uns ingressos de 54500.00€ és 15866.50€\n",
                "Introdueix els ingressos bruts: L'IRPF a pagar per uns ingressos de 64832.00€ és 20075.90€\n",
                "Introdueix els ingressos bruts: L'IRPF a pagar per uns ingressos de 275387.00€ és 114825.65€\n",
                "Introdueix els ingressos bruts: L'IRPF a pagar per uns ingressos de 765915.00€ és 344881.55€\n"
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
