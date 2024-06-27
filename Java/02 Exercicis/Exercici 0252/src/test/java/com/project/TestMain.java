// TestMain.java
package com.project;

import java.util.Locale;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.github.stefanbirkner.systemlambda.SystemLambda;

public class TestMain {

    @Test
    public void testComptaVendes() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                // Executa el main per a provar la seva sortida
                String[] args = {}; // Passa els arguments necessaris si n'hi ha
                SystemLambda.withTextFromSystemIn("100.0\n200.0\n50.0\nfi").execute(() -> Main.main(args));
            });
            text = text.replace("\r\n", "\n");

            // Comprova que la sortida conté el text esperat
            String expectedOutput = "Introdueix el valor de les vendes (escriu 'fi' per acabar):\n" +
                                    "S'han apuntat 3 vendes, amb un total de 350.00 € i una mitjana de 116.67 €.\n";
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0, 
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                diff +
                "<<<<<<<<<< <<<<<<<<<<\n");
        } finally {
            Locale.setDefault(defaultLocale); // Restaura la configuració regional per defecte
        }
    }

    @Test
    public void testComptaVendesWithInvalidInput() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                // Executa el main per a provar la seva sortida
                String[] args = {}; // Passa els arguments necessaris si n'hi ha
                SystemLambda.withTextFromSystemIn("100.0\ninvalid\n200.0\nfi").execute(() -> Main.main(args));
            });
            text = text.replace("\r\n", "\n");

            // Comprova que la sortida conté el text esperat
            String expectedOutput = "Introdueix el valor de les vendes (escriu 'fi' per acabar):\n" +
                                    "Valor no vàlid, torna a intentar-ho.\n" +
                                    "S'han apuntat 2 vendes, amb un total de 300.00 € i una mitjana de 150.00 €.\n";
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
