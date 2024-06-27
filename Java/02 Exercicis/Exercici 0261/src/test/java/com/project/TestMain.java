// TestMain.java
package com.project;

import java.util.Locale;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.github.stefanbirkner.systemlambda.SystemLambda;

public class TestMain {

    @Test
    public void testEscriuLlistaPartsDelDia() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String[] partsDelDia = {"Matí", "Tarda", "Vespre", "Nit"};
            String text = SystemLambda.tapSystemOut(() -> {
                Main.escriuLlista(partsDelDia);
            });
            text = text.replace("\r\n", "\n");

            String expectedOutput = "L'element a la posició 0 de la llista és 'Matí'\n" +
                                    "L'element a la posició 1 de la llista és 'Tarda'\n" +
                                    "L'element a la posició 2 de la llista és 'Vespre'\n" +
                                    "L'element a la posició 3 de la llista és 'Nit'\n";
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
    public void testEscriuLlistaDiesDeLaSetmana() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String[] diesDeLaSetmana = {"Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres", "Dissabte", "Diumenge"};
            String text = SystemLambda.tapSystemOut(() -> {
                Main.escriuLlista(diesDeLaSetmana);
            });
            text = text.replace("\r\n", "\n");

            String expectedOutput = "L'element a la posició 0 de la llista és 'Dilluns'\n" +
                                    "L'element a la posició 1 de la llista és 'Dimarts'\n" +
                                    "L'element a la posició 2 de la llista és 'Dimecres'\n" +
                                    "L'element a la posició 3 de la llista és 'Dijous'\n" +
                                    "L'element a la posició 4 de la llista és 'Divendres'\n" +
                                    "L'element a la posició 5 de la llista és 'Dissabte'\n" +
                                    "L'element a la posició 6 de la llista és 'Diumenge'\n";
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
    public void testEscriuLlistaMesosDeLAny() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String[] mesosDeLAny = {"Gener", "Febrer", "Març", "Abril", "Maig", "Juny", "Juliol", "Agost", "Setembre", "Octubre", "Novembre", "Desembre"};
            String text = SystemLambda.tapSystemOut(() -> {
                Main.escriuLlista(mesosDeLAny);
            });
            text = text.replace("\r\n", "\n");

            String expectedOutput = "L'element a la posició 0 de la llista és 'Gener'\n" +
                                    "L'element a la posició 1 de la llista és 'Febrer'\n" +
                                    "L'element a la posició 2 de la llista és 'Març'\n" +
                                    "L'element a la posició 3 de la llista és 'Abril'\n" +
                                    "L'element a la posició 4 de la llista és 'Maig'\n" +
                                    "L'element a la posició 5 de la llista és 'Juny'\n" +
                                    "L'element a la posició 6 de la llista és 'Juliol'\n" +
                                    "L'element a la posició 7 de la llista és 'Agost'\n" +
                                    "L'element a la posició 8 de la llista és 'Setembre'\n" +
                                    "L'element a la posició 9 de la llista és 'Octubre'\n" +
                                    "L'element a la posició 10 de la llista és 'Novembre'\n" +
                                    "L'element a la posició 11 de la llista és 'Desembre'\n";
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
