package com.project;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.github.stefanbirkner.systemlambda.SystemLambda;

public class TestMain {

    @Test
    public void testMainOutput() throws Exception {
        String text = SystemLambda.tapSystemOut(() -> {
            // Executa el main per a provar la seva sortida
            String[] args = {}; // Passa els arguments necessaris si n'hi ha
            Main.main(args);
        });
        text = text.replace("\r\n", "\n");

        // Comprova que la sortida conté el text esperat
        String expectedOutput = "El Senyor dels Anells, J.R.R. Tolkien; 1954 - Disponible\n" + 
            "1984, George Orwell; 1949 - Disponible\n" + 
            "El Petit Príncep, Antoine de Saint-Exupéry; 1943 - Disponible\n" + 
            "\n" + 
            "Després dels préstecs:\n" + 
            "El Senyor dels Anells, J.R.R. Tolkien; 1954 - En préstec\n" + 
            "1984, George Orwell; 1949 - En préstec\n" + 
            "El Petit Príncep, Antoine de Saint-Exupéry; 1943 - Disponible\n" + 
            "\n" + 
            "Després de retornar el llibre1:\n" + 
            "El Senyor dels Anells, J.R.R. Tolkien; 1954 - Disponible" +
            "\n";
        String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0, 
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                diff +
                "<<<<<<<<<< <<<<<<<<<<\n");
    }

@Test
    public void testMainGettersSetters() {
        // Creació d'un objecte Llibre
        Llibre llibre1 = new Llibre("El Senyor dels Anells", "J.R.R. Tolkien", 1954);

        // Verifica els valors inicials
        assertEquals("El Senyor dels Anells", llibre1.getTitol(), "El títol del llibre no és correcte");
        assertEquals("J.R.R. Tolkien", llibre1.getAutor(), "L'autor del llibre no és correcte");
        assertEquals(1954, llibre1.getAnyPublicacio(), "L'any de publicació del llibre no és correcte");
        assertFalse(llibre1.estaPrestat(), "El llibre no hauria d'estar prestat");

        // Canvia l'estat del préstec a prestat i verifica
        llibre1.prestar();
        assertTrue(llibre1.estaPrestat(), "El llibre hauria d'estar prestat");

        // Retorna el llibre i verifica
        llibre1.retornar();
        assertFalse(llibre1.estaPrestat(), "El llibre hauria de ser disponible (no prestat)");

        // Creació de dos objectes Llibre més i verifica el seu estat inicial i final
        Llibre llibre2 = new Llibre("1984", "George Orwell", 1949);
        Llibre llibre3 = new Llibre("El Petit Príncep", "Antoine de Saint-Exupéry", 1943);

        // Verifica els valors inicials del llibre2 i llibre3
        assertEquals("1984", llibre2.getTitol(), "El títol del llibre2 no és correcte");
        assertEquals("El Petit Príncep", llibre3.getTitol(), "El títol del llibre3 no és correcte");

        // Canvia l'estat de préstec dels llibres 2 i 3 i verifica
        llibre2.prestar();
        llibre3.prestar();
        assertTrue(llibre2.estaPrestat(), "El llibre2 hauria d'estar prestat");
        assertTrue(llibre3.estaPrestat(), "El llibre3 hauria d'estar prestat");
    }

    @Test
    public void testMainPrivateAttributes() {
        // Obtenim tots els camps de la classe Cotxe
        Field[] fields = Llibre.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " hauria de ser privat");
        }
    }
}
