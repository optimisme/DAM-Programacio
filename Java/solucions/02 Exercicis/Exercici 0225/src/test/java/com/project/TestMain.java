package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.io.ByteArrayInputStream;
import java.util.Locale;

public class TestMain {

    @Test
    public void testEscola() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String[] inputs = {
                "dilluns\n",
                "dimarts\n",
                "dimecres\n",
                "dijous\n",
                "divendres\n",
                "dissabte\n",
                "diumenge\n"
            };
            String[] expectedOutputs = {
                "Introdueix un dia de la setmana: S'ha d'anar a l'escola\n",
                "Introdueix un dia de la setmana: S'ha d'anar a l'escola\n",
                "Introdueix un dia de la setmana: S'ha d'anar a l'escola\n",
                "Introdueix un dia de la setmana: S'ha d'anar a l'escola\n",
                "Introdueix un dia de la setmana: S'ha d'anar a l'escola\n",
                "Introdueix un dia de la setmana: No s'ha d'anar a l'escola\n",
                "Introdueix un dia de la setmana: No s'ha d'anar a l'escola\n"
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
