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
            String expectedOutput = "Són les paraules 'Mare' i 'Rema' anagrames? true\n" +
                                    "Són les paraules 'Porta' i 'Tropa' anagrames? true\n" +
                                    "Són les paraules 'Triangle' i 'Integral' anagrames? true\n" +
                                    "Són les paraules 'Sopa' i 'Posa' anagrames? true\n" +
                                    "Són les paraules 'Casa' i 'Sopa' anagrames? false\n" +
                                    "Són les paraules 'Gat' i 'Perro' anagrames? false\n";

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
