package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.util.Locale;

public class TestMain {

    @Test
    public void testMainOutput() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String expectedOutput = "És la frase 'Anul·la la lluna' un palindrom? true\n" +
                                    "És la frase 'Atrapa'l o l'aparta' un palindrom? true\n" +
                                    "És la frase 'No sap pas on' un palindrom? true\n" +
                                    "És la frase 'Tramaran anar a Mart' un palindrom? true\n" +
                                    "És la frase 'Un pop nu' un palindrom? true\n" +
                                    "És la frase 'Aquesta frase no és un palíndrom' un palindrom? false\n" +
                                    "És la frase 'Aquest tampoc no ho és' un palindrom? false\n";

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
