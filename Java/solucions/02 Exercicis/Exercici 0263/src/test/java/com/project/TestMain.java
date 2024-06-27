// TestMain.java
package com.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.github.stefanbirkner.systemlambda.SystemLambda;

public class TestMain {

    @Test
    public void testConvertirArray() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String[] numeros = {"4", "5", "6", "7"};
            List<Integer> result = Main.convertirArray(numeros);

            List<Integer> expected = Arrays.asList(4, 5, 6, 7);
            assertEquals(expected, result);
        } finally {
            Locale.setDefault(defaultLocale); // Restaura la configuració regional per defecte
        }
    }

    @Test
    public void testConvertirLlista() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            ArrayList<String> numeros = new ArrayList<>(Arrays.asList("4", "5", "6", "7"));
            List<Integer> result = Main.convertirLlista(numeros);

            List<Integer> expected = Arrays.asList(4, 5, 6, 7);
            assertEquals(expected, result);
        } finally {
            Locale.setDefault(defaultLocale); // Restaura la configuració regional per defecte
        }
    }

    @Test
    public void testOutputArray() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                Main.main(new String[]{});
            });
            text = text.replace("\r\n", "\n");

            String expectedOutput = "Convertit des d'array: [4, 5, 6, 7]\n" +
                                    "Convertit des de llista: [4, 5, 6, 7]\n";
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0, 
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                diff +
                "<<<<<<<<<< <<<<<<<<<<\n");
        } finally {
            Locale.setDefault(defaultLocale); // Restaura la configuració regional per defecte
        }
    }
}
