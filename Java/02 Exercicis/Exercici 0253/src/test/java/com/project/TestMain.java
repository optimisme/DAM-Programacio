// TestMain.java
package com.project;

import java.util.Locale;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.github.stefanbirkner.systemlambda.SystemLambda;

public class TestMain {

    @Test
    public void testCalculaComissio() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                // Executa el main per a provar la seva sortida
                String[] args = {}; // Passa els arguments necessaris si n'hi ha
                SystemLambda.withTextFromSystemIn("500\n2000\n7000\nfi").execute(() -> Main.main(args));
            });
            text = text.replace("\r\n", "\n");

            // Comprova que la sortida conté el text esperat
            String expectedOutput = "Introdueix el valor de les vendes (escriu 'fi' per acabar):\n" +
                                    "S'han entrat 3 vendes, amb un total de 10365.00 € i una mitjana de 3166.67 €.\n" +
                                    "S'ha aconseguit una comissió de 865.00 €.\n";
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
    public void testCalculaComissioWithInvalidInput() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                // Executa el main per a provar la seva sortida
                String[] args = {}; // Passa els arguments necessaris si n'hi ha
                SystemLambda.withTextFromSystemIn("500\ninvalid\n3000\nfi").execute(() -> Main.main(args));
            });
            text = text.replace("\r\n", "\n");

            // Comprova que la sortida conté el text esperat
            String expectedOutput = "Introdueix el valor de les vendes (escriu 'fi' per acabar):\n" +
                                    "Valor no vàlid, torna a intentar-ho.\n" +
                                    "S'han entrat 2 vendes, amb un total de 3735.00 € i una mitjana de 1750.00 €.\n" +
                                    "S'ha aconseguit una comissió de 235.00 €.\n";
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
