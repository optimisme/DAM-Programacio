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
            String input = "Gattacca\nAndrew Niccol\n1997\nInception\nChristopher Nolan\n2010\n";
            String expectedOutput = "Introdueix el títol de la pel·lícula: Introdueix el director de la pel·lícula: Introdueix l'any de la pel·lícula: " +
                                    "Introdueix el títol de la pel·lícula: Introdueix el director de la pel·lícula: Introdueix l'any de la pel·lícula: " +
                                    "Títol: Gattacca, Director: Andrew Niccol, Any: 1997\n" +
                                    "Títol: Inception, Director: Christopher Nolan, Any: 2010\n";
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
