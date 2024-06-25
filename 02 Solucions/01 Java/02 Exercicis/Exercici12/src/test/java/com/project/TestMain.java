package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.io.ByteArrayInputStream;
import java.util.Locale;

public class TestMain {

    @Test
    public void testMainOutputOption1Then3() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String input = "1\n3\n"; // Simula l'entrada de l'usuari (opció 1, després opció 3)
            String expectedOutput = "        ********Menú Principal********\n" +
                                    "        1.                Veure perfil\n" +
                                    "        2.         Canviar contrasenya\n" +
                                    "        3.                      Sortir\n" +
                                    "Escull una opció: Veure perfil (1)\n" +
                                    "Escull una opció: Escull una opció: Sortir (3)\n";

            String actualOutput = SystemLambda.tapSystemOut(() -> {
                System.setIn(new ByteArrayInputStream(input.getBytes())); // Simula l'entrada de l'usuari
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

    @Test
    public void testMainOutputOption2Then3() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String input = "2\n3\n"; // Simula l'entrada de l'usuari (opció 2, després opció 3)
            String expectedOutput = "        ********Menú Principal********\n" +
                                    "        1.                Veure perfil\n" +
                                    "        2.         Canviar contrasenya\n" +
                                    "        3.                      Sortir\n" +
                                    "Escull una opció: Canviar contrasenya (2)\n" +
                                    "Escull una opció: Escull una opció: Sortir (3)\n";

            String actualOutput = SystemLambda.tapSystemOut(() -> {
                System.setIn(new ByteArrayInputStream(input.getBytes())); // Simula l'entrada de l'usuari
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

    @Test
    public void testMainOutputInvalidOptionThen3() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String input = "4\n3\n"; // Simula l'entrada de l'usuari (opció invàlida, després opció 3)
            String expectedOutput = "        ********Menú Principal********\n" +
                                    "        1.                Veure perfil\n" +
                                    "        2.         Canviar contrasenya\n" +
                                    "        3.                      Sortir\n" +
                                    "Escull una opció: Opció no vàlida\n" +
                                    "Escull una opció: Escull una opció: Sortir (3)\n";

            String actualOutput = SystemLambda.tapSystemOut(() -> {
                System.setIn(new ByteArrayInputStream(input.getBytes())); // Simula l'entrada de l'usuari
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
