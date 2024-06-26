package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.util.Locale;

public class TestMain {

    @Test
    public void testCalculaInteressos() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String expectedOutput = "Per un capital de 1000.00€, un interès del 5.00% i 10 mesos, els interessos són 500.00€\n" +
                                    "Per un capital de 2500.00€, un interès del 3.00% i 12 mesos, els interessos són 900.00€\n" +
                                    "Per un capital de 7464.00€, un interès del 4.00% i 14 mesos, els interessos són 4179.84€\n" +
                                    "Per un capital de 10000.00€, un interès del 2.00% i 24 mesos, els interessos són 4800.00€\n";

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
