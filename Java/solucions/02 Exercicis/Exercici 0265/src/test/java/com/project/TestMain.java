// TestMain.java
package com.project;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.github.stefanbirkner.systemlambda.SystemLambda;

public class TestMain {

    @Test
    public void testCalculaValors() {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            List<Integer> numeros1 = Arrays.asList(4, 8, 7, 2, 5, 3, 9);
            assertEquals(38, Main.calculaSuma(numeros1));
            assertEquals(9, Main.calculaMaxim(numeros1));
            assertEquals(2, Main.calculaMinim(numeros1));
            assertEquals(5.43, Main.calculaMitjana(numeros1), 0.01);

            List<Integer> numeros2 = Arrays.asList(7, 2, 4, 8, 4, 2);
            assertEquals(27, Main.calculaSuma(numeros2));
            assertEquals(8, Main.calculaMaxim(numeros2));
            assertEquals(2, Main.calculaMinim(numeros2));
            assertEquals(4.5, Main.calculaMitjana(numeros2), 0.01);
        } finally {
            Locale.setDefault(defaultLocale); // Restaura la configuració regional per defecte
        }
    }

    @Test
    public void testOutput() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                SystemLambda.withTextFromSystemIn("4,8,7,2,5,3,9").execute(() -> Main.main(new String[]{}));
            });
            text = text.replace("\r\n", "\n");

            String expectedOutput = "Introdueix una llista de números enters separats per comes:\n" +
                                    "Suma = 38, Màxim = 9, Mínim = 2, Mitjana = 5.43\n";
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0,
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                diff +
                "<<<<<<<<<< <<<<<<<<<<\n");

            text = SystemLambda.tapSystemOut(() -> {
                SystemLambda.withTextFromSystemIn("7,2,4,8,4,2").execute(() -> Main.main(new String[]{}));
            });
            text = text.replace("\r\n", "\n");

            expectedOutput = "Introdueix una llista de números enters separats per comes:\n" +
                             "Suma = 27, Màxim = 8, Mínim = 2, Mitjana = 4.50\n";
            diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0,
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                diff +
                "<<<<<<<<<< <<<<<<<<<<\n");
        } finally {
            Locale.setDefault(defaultLocale); // Restaura la configuració regional per defecte
        }
    }
}
