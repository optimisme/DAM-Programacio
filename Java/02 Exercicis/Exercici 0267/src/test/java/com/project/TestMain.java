// TestMain.java
package com.project;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestMain {

    @Test
    public void testOrdenaParaulesPerLongitud() {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            List<String> paraules = Arrays.asList("Hola", "ara", "mateix", "estem", "aprenent", "Java");
            List<String> expectedAscendent = Arrays.asList("ara", "Hola", "Java", "estem", "mateix", "aprenent");
            List<String> expectedDescendent = Arrays.asList("aprenent", "mateix", "estem", "Hola", "Java", "ara");

            List<String> resultAscendent = Main.ordenaParaulesPerLongitud(paraules, true);
            List<String> resultDescendent = Main.ordenaParaulesPerLongitud(paraules, false);

            assertEquals(expectedAscendent, resultAscendent);
            assertEquals(expectedDescendent, resultDescendent);
        } finally {
            Locale.setDefault(defaultLocale); // Restaura la configuració regional per defecte
        }
    }

    @Test
    public void testOutput() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String text = tapSystemOut(() -> {
                withTextFromSystemIn("Hola ara mateix estem aprenent Java");
                Main.main(new String[]{});
            });
            text = text.replace("\r\n", "\n");

            String expectedOutput = "Introdueix una frase:\n" +
                                    "Paraules ordenades de menys a més lletres: [ara, Hola, Java, estem, mateix, aprenent]\n" +
                                    "Paraules ordenades de més a menys lletres: [aprenent, mateix, estem, Hola, Java, ara]\n";
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0,
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                diff +
                "<<<<<<<<<< <<<<<<<<<<\n");

            text = tapSystemOut(() -> {
                withTextFromSystemIn("Demà és festa i anem a la platja");
                Main.main(new String[]{});
            });
            text = text.replace("\r\n", "\n");

            expectedOutput = "Introdueix una frase:\n" +
                             "Paraules ordenades de menys a més lletres: [i, a, és, la, Demà, anem, festa, platja]\n" +
                             "Paraules ordenades de més a menys lletres: [platja, festa, Demà, anem, és, la, i, a]\n";
            diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0,
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                diff +
                "<<<<<<<<<< <<<<<<<<<<\n");
        } finally {
            Locale.setDefault(defaultLocale); // Restaura la configuració regional per defecte
        }
    }

    private static String tapSystemOut(Runnable runnable) throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));
        try {
            runnable.run();
        } finally {
            System.setOut(originalOut);
        }
        return out.toString();
    }

    private static void withTextFromSystemIn(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
