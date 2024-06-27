// TestMain.java
package com.project;

import java.util.Locale;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.github.stefanbirkner.systemlambda.SystemLambda;

public class TestMain {

    @Test
    public void testCalculaPreuFrase() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            testFrase("Hello World 123 AaBbZz", 2.10);
            testFrase("En Gabriel ha comprat 3 kg de taronges", 3.00);
            testFrase("Jo tinc 2 germans, un es diu Quim i l'altre Zahir", 3.70);
        } finally {
            Locale.setDefault(defaultLocale); // Restaura la configuració regional per defecte
        }
    }

    private void testFrase(String frase, double expectedPreu) throws Exception {
        String text = SystemLambda.tapSystemOut(() -> {
            // Executa el main per a provar la seva sortida
            String[] args = {}; // Passa els arguments necessaris si n'hi ha
            SystemLambda.withTextFromSystemIn(frase).execute(() -> Main.main(args));
        });
        text = text.replace("\r\n", "\n");

        // Comprova que la sortida conté el text esperat
        String expectedOutput = String.format("Introdueix una frase:\nEl preu de la frase '%s' és: %.2f\n", frase, expectedPreu);
        String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
        assertEquals("identical", diff, 
            "\n>>>>>>>>>> >>>>>>>>>>\n" +
            diff +
            "<<<<<<<<<< <<<<<<<<<<\n");
    }
}
