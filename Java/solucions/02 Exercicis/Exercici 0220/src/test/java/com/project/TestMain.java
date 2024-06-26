package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.util.Locale;

public class TestMain {

    @Test
    public void testCalculaOperacioOutput() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String expectedOutput = "El resultat de suma entre 2.00 i 3.00 és 5.00\n" +
                                    "El resultat de multiplicació entre 3.00 i 4.00 és 12.00\n" +
                                    "El resultat de resta entre 5.00 i 2.00 és 3.00\n" +
                                    "El resultat de divisió entre 10.00 i 2.00 és 5.00\n";

            String actualOutput = SystemLambda.tapSystemOut(() -> {
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
