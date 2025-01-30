package com.exercicis;

import com.exercici0302.*;
import com.testStringUtils.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import static org.junit.jupiter.api.Assertions.*;

import com.github.stefanbirkner.systemlambda.SystemLambda;

class TestExercici0302 {

    @Test
    public void testCreacioAutor(TestInfo testInfo) throws Exception {
        try {
            Autor autor = new Autor("Gabriel García Márquez", "Colombiana");
            assertEquals("Gabriel García Márquez", autor.getNom(), "El nom de l'autor no és correcte.");
            assertEquals("Colombiana", autor.getNacionalitat(), "La nacionalitat de l'autor no és correcta.");
            System.out.println("Test passed, succeeded!");

        } catch (AssertionError e) {
            System.out.println("Test failed: " + testInfo.getDisplayName());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
        }
    }

    @Test
    public void testCreacioLlibre(TestInfo testInfo) throws Exception {
        try {
            Autor autor = new Autor("Gabriel García Márquez", "Colombiana");
            Llibre llibre = new Llibre("Cien años de soledad", autor, 1967);
            assertEquals("Cien años de soledad", llibre.getTitol(), "El títol del llibre no és correcte.");
            assertEquals(autor, llibre.getAutor(), "L'autor del llibre no és correcte.");
            assertEquals(1967, llibre.getAnyPublicacio(), "L'any de publicació del llibre no és correcte.");
            System.out.println("Test passed, succeeded!");

        } catch (AssertionError e) {
            System.out.println("Test failed: " + testInfo.getDisplayName());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
        }
    }

    @Test
    public void testCreacioPrestec(TestInfo testInfo) throws Exception {
        try {
            Autor autor = new Autor("Gabriel García Márquez", "Colombiana");
            Llibre llibre = new Llibre("Cien años de soledad", autor, 1967);
            Prestec prestec = new Prestec(llibre, "01/01/2024", "31/01/2024");

            assertEquals(llibre, prestec.getLlibre(), "El llibre del préstec no és correcte.");
            assertEquals("01/01/2024", prestec.getDataPrestec(), "La data de préstec no és correcta.");
            assertEquals("31/01/2024", prestec.getDataRetorn(), "La data de retorn no és correcta.");
            System.out.println("Test passed, succeeded!");

        } catch (AssertionError e) {
            System.out.println("Test failed: " + testInfo.getDisplayName());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
        }
    }

    @Test
    public void testEstaEnTermini(TestInfo testInfo) throws Exception {
        try {
            Autor autor = new Autor("Gabriel García Márquez", "Colombiana");
            Llibre llibre = new Llibre("Cien años de soledad", autor, 1967);
            Prestec prestec = new Prestec(llibre, "01/01/2024", "31/01/2024");

            boolean resultat = prestec.estaEnTermini();
            assertFalse(resultat, "El llibre no hauria d'estar en termini.");
            System.out.println("Test passed, succeeded!");

        } catch (AssertionError e) {
            System.out.println("Test failed: " + testInfo.getDisplayName());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
        }
    }

    @Test
    public void testSortidaMain(TestInfo testInfo) throws Exception {
        try {
            String text = SystemLambda.tapSystemOut(() -> {
                Main.main(new String[]{});
            });

            text = text.replace("\r\n", "\n");

            String expectedOutput = """
                Llibre: Cien años de soledad - Autor: Gabriel García Márquez (Colombiana)
                Data de Prestec: 01/01/2024 - Data de retorn: 31/01/2024
                Està en termini? false
                -----
                Llibre: Harry Potter y la piedra filosofal - Autor: J.K. Rowling (Britànica)
                Data de Prestec: 15/01/2024 - Data de retorn: 15/02/2024
                Està en termini? false
                -----
                """.replace("\r\n", "\n");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");
            System.out.println("Test passed, succeeded!");

        } catch (AssertionError e) {
            System.out.println("Test failed: " + testInfo.getDisplayName());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
        }
    }
}
