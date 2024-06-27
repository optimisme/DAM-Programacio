// TestMain.java
package com.project;

import java.util.Locale;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMain {

    @Test
    public void testEscriuInformacioPerCategories() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            Object[][] inventariNetja = {
                {"Detergent", "Casa", 5.99},
                {"Netejador d'interiors", "Automoció", 7.99},
                {"Tovalloles de paper", "Casa", 2.99},
                {"Paper higiènic de luxe", "Personal", 7.99},
                {"Netejador de vidres", "Casa", 4.79},
                {"Aspiradora", "Casa", 29.69},
                {"Cera de cotxes", "Automoció", 8.49},
                {"Tovalloletes netejadores", "Personal", 6.29},
                {"Xampú per al cos", "Personal", 4.99},
                {"Sabó de mans líquid", "Personal", 2.49},
                {"Esprai netejador", "Casa", 3.49},
                {"Estopa de cotxes", "Automoció", 1.99},
            };

            String text = tapSystemOut(() -> {
                Main.escriuInformacioPerCategories(inventariNetja);
            });
            text = text.replace("\r\n", "\n");

            String expectedOutput = "Categoria 'Automoció':\n" +
                                    "- Netejador d'interiors, 7.99\n" +
                                    "- Cera de cotxes, 8.49\n" +
                                    "- Estopa de cotxes, 1.99\n" +
                                    "Categoria 'Casa':\n" +
                                    "- Detergent, 5.99\n" +
                                    "- Tovalloles de paper, 2.99\n" +
                                    "- Netejador de vidres, 4.79\n" +
                                    "- Aspiradora, 29.69\n" +
                                    "- Esprai netejador, 3.49\n" +
                                    "Categoria 'Personal':\n" +
                                    "- Paper higiènic de luxe, 7.99\n" +
                                    "- Tovalloletes netejadores, 6.29\n" +
                                    "- Xampú per al cos, 4.99\n" +
                                    "- Sabó de mans líquid, 2.49\n";
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0,
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                diff +
                "<<<<<<<<<< <<<<<<<<<<\n");
        } finally {
            Locale.setDefault(defaultLocale); // Restaura la configuració regional per defecte
        }
    }

    private static String tapSystemOut(Runnable runnable) throws Exception {
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        java.io.PrintStream originalOut = System.out;
        System.setOut(new java.io.PrintStream(out));
        try {
            runnable.run();
        } finally {
            System.setOut(originalOut);
        }
        return out.toString();
    }
}
