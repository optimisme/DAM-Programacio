package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.util.Locale;

public class TestMain {

    @Test
    public void testEsParellOutput() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String expectedOutput = "1 és imparell\n" +
                                    "2 és parell\n" +
                                    "3 és imparell\n" +
                                    "4 és parell\n" +
                                    "5 és imparell\n" +
                                    "6 és parell\n" +
                                    "7 és imparell\n" +
                                    "8 és parell\n" +
                                    "9 és imparell\n" +
                                    "10 és parell\n";

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
