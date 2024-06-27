// TestMain.java
package com.project;

import java.util.Locale;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.github.stefanbirkner.systemlambda.SystemLambda;

public class TestMain {

    @Test
    public void testPorcioTaula() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                // Executa la funció per a provar la seva sortida
                Main.porcioTaula(2, 4, 7);
            });
            text = text.replace("\r\n", "\n");

            String expectedOutput = "4 x 2 = 8\n5 x 2 = 10\n6 x 2 = 12\n7 x 2 = 14\n";
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0, 
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                diff +
                "<<<<<<<<<< <<<<<<<<<<\n");

            text = SystemLambda.tapSystemOut(() -> {
                // Executa la funció per a provar la seva sortida
                Main.porcioTaula(5, 3, 5);
            });
            text = text.replace("\r\n", "\n");

            expectedOutput = "3 x 5 = 15\n4 x 5 = 20\n5 x 5 = 25\n";
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
