package com.exercicis;

import com.exercici0202.*;
import com.testStringUtils.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.github.stefanbirkner.systemlambda.SystemLambda;

class TestExercici0202 {

    @Test
    public void testCreacioAutor() {
        Autor autor = new Autor("Gabriel García Márquez", "Colombiana");
        assertEquals("Gabriel García Márquez", autor.getNom(), "El nom de l'autor no és correcte.");
        assertEquals("Colombiana", autor.getNacionalitat(), "La nacionalitat de l'autor no és correcta.");
    }

    @Test
    public void testCreacioLlibre() {
        Autor autor = new Autor("Gabriel García Márquez", "Colombiana");
        Llibre llibre = new Llibre("Cien años de soledad", autor, 1967);
        assertEquals("Cien años de soledad", llibre.getTitol(), "El títol del llibre no és correcte.");
        assertEquals(autor, llibre.getAutor(), "L'autor del llibre no és correcte.");
        assertEquals(1967, llibre.getAnyPublicacio(), "L'any de publicació del llibre no és correcte.");
    }

    @Test
    public void testCreacioPrestec() {
        Autor autor = new Autor("Gabriel García Márquez", "Colombiana");
        Llibre llibre = new Llibre("Cien años de soledad", autor, 1967);
        Prestec prestec = new Prestec(llibre, "01/01/2024", "31/01/2024");

        assertEquals(llibre, prestec.getLlibre(), "El llibre del préstec no és correcte.");
        assertEquals("01/01/2024", prestec.getDataPrestec(), "La data de préstec no és correcta.");
        assertEquals("31/01/2024", prestec.getDataRetorn(), "La data de retorn no és correcta.");
    }

    @Test
    public void testEstaEnTermini() {
        Autor autor = new Autor("Gabriel García Márquez", "Colombiana");
        Llibre llibre = new Llibre("Cien años de soledad", autor, 1967);
        Prestec prestec = new Prestec(llibre, "01/01/2024", "31/01/2024");

        boolean resultat = prestec.estaEnTermini();
        assertFalse(resultat, "El llibre no hauria d'estar en termini.");
    }

    @Test
    public void testSortidaMain() throws Exception {
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
    }
}
