// TestMain.java
package com.project;

import java.util.Locale;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.github.stefanbirkner.systemlambda.SystemLambda;

public class TestMain {

    @Test
    public void testMenuOpcioSortir() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                // Simula l'entrada de l'opció 0 per sortir
                SystemLambda.withTextFromSystemIn("0").execute(() -> Main.main(new String[]{}));
            });
            text = text.replace("\r\n", "\n");

            String expectedOutput = "    CALCULADORA\n" +
                                    "    Menú Principal\n" +
                                    "    1 - Sumar\n" +
                                    "    2 - Restar\n" +
                                    "    3 - Multiplicar\n" +
                                    "    4 - Dividir\n" +
                                    "    0 - Sortir\n" +
                                    "Opció: ";
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
    public void testOpcioIncorrecta() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                // Simula l'entrada d'una opció incorrecta seguida de l'opció 0 per sortir
                SystemLambda.withTextFromSystemIn("5\n0").execute(() -> Main.main(new String[]{}));
            });
            text = text.replace("\r\n", "\n");

            String expectedOutput = "    CALCULADORA\n" +
                                    "    Menú Principal\n" +
                                    "    1 - Sumar\n" +
                                    "    2 - Restar\n" +
                                    "    3 - Multiplicar\n" +
                                    "    4 - Dividir\n" +
                                    "    0 - Sortir\n" +
                                    "Opció: Opció incorrecta\n" +
                                    "    CALCULADORA\n" +
                                    "    Menú Principal\n" +
                                    "    1 - Sumar\n" +
                                    "    2 - Restar\n" +
                                    "    3 - Multiplicar\n" +
                                    "    4 - Dividir\n" +
                                    "    0 - Sortir\n" +
                                    "Opció: ";
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
    public void testOperacions() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                // Simula l'entrada per sumar 5 i 3, després sortir
                SystemLambda.withTextFromSystemIn("1\n5\n3\n0").execute(() -> Main.main(new String[]{}));
            });
            text = text.replace("\r\n", "\n");

            String expectedOutput = "    CALCULADORA\n" +
                                    "    Menú Principal\n" +
                                    "    1 - Sumar\n" +
                                    "    2 - Restar\n" +
                                    "    3 - Multiplicar\n" +
                                    "    4 - Dividir\n" +
                                    "    0 - Sortir\n" +
                                    "Opció: Introdueix el primer número: Introdueix el segon número: El resultat de Sumar 5.000000 i 3.000000 és: 8.000000\n" +
                                    "    CALCULADORA\n" +
                                    "    Menú Principal\n" +
                                    "    1 - Sumar\n" +
                                    "    2 - Restar\n" +
                                    "    3 - Multiplicar\n" +
                                    "    4 - Dividir\n" +
                                    "    0 - Sortir\n" +
                                    "Opció: ";
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
