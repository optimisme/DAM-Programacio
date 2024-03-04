package com.project;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        String expectedOutput = "Llibre: Cien años de soledad - Autor: Gabriel García Márquez (Colombiana)\n" + 
                        "Data de Prestec: 01/01/2024 - Data de retorn: 31/01/2024\n" + 
                        "Està en termini? true\n" + 
                        "-----\n" + 
                        "Llibre: Harry Potter y la piedra filosofal - Autor: J.K. Rowling (Britànica)\n" + 
                        "Data de Prestec: 15/01/2024 - Data de retorn: 15/02/2024\n" + 
                        "Està en termini? true\n" + 
                        "-----";
        assertTrue(text.contains(expectedOutput), 
            ">>>>>>>>>> >>>>>>>>>>\n" +
            "El missatge de sortida no coincideix amb l'esperat. \n" +
            "Esperat: \n" + expectedOutput + "\n" + 
            "Obtingut: \n" + text + 
            "<<<<<<<<<<< <<<<<<<<<<\n");
    }

    @Test
    public void testMainSettersGetters() {
        // Test Autor
        Autor autor = new Autor("Test Autor", "Test Nacionalitat");
        assertEquals("Test Autor", autor.getNom(), "El nom de l'autor no es correspon amb el valor esperat.");
        assertEquals("Test Nacionalitat", autor.getNacionalitat(), "La nacionalitat de l'autor no es correspon amb el valor esperat.");
    
        // Canviar i verificar els valors amb els setters
        autor.setNom("Nou Nom");
        autor.setNacionalitat("Nova Nacionalitat");
        assertEquals("Nou Nom", autor.getNom(), "El setter de nom no funciona com s'esperava.");
        assertEquals("Nova Nacionalitat", autor.getNacionalitat(), "El setter de nacionalitat no funciona com s'esperava.");
    
        // Test Llibre
        Llibre llibre = new Llibre("Test Llibre", autor, 2000);
        assertEquals("Test Llibre", llibre.getTitol(), "El títol del llibre no es correspon amb el valor esperat.");
        assertEquals(autor, llibre.getAutor(), "L'autor del llibre no es correspon amb el valor esperat.");
        assertEquals(2000, llibre.getAnyPublicacio(), "L'any de publicació no es correspon amb el valor esperat.");
    
        // Canviar i verificar els valors amb els setters
        Autor nouAutor = new Autor("Alt Autor", "Alt Nacionalitat");
        llibre.setTitol("Nou Títol");
        llibre.setAutor(nouAutor);
        llibre.setAnyPublicacio(2020);
        assertEquals("Nou Títol", llibre.getTitol(), "El setter de títol no funciona com s'esperava.");
        assertEquals(nouAutor, llibre.getAutor(), "El setter d'autor no funciona com s'esperava.");
        assertEquals(2020, llibre.getAnyPublicacio(), "El setter d'any de publicació no funciona com s'esperava.");
    
        // Test Prestec
        Prestec prestec = new Prestec(llibre, "01/01/2024", "31/01/2024");
        assertEquals(llibre, prestec.getLlibre(), "El llibre del Prestec no es correspon amb el valor esperat.");
        assertEquals("01/01/2024", prestec.getDataPrestec(), "La data de Prestec no es correspon amb el valor esperat.");
        assertEquals("31/01/2024", prestec.getDataRetorn(), "La data de retorn no es correspon amb el valor esperat.");
    
        // Verificar funció especial estaEnTermini
        assertTrue(prestec.estaEnTermini(), "El mètode estaEnTermini no retorna el valor esperat.");
    
        // Canviar i verificar les dates amb els setters
        prestec.setDataPrestec("02/02/2024");
        prestec.setDataRetorn("02/03/2024");
        assertEquals("02/02/2024", prestec.getDataPrestec(), "El setter de data de Prestec no funciona com s'esperava.");
        assertEquals("02/03/2024", prestec.getDataRetorn(), "El setter de data de retorn no funciona com s'esperava.");
    }
    

    @Test
    public void testMainPrivateAttributes() {
        // Obtenim tots els camps de la classe Cotxe
        Field[] fields = Autor.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " hauria de ser privat");
        }

        fields = Llibre.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " hauria de ser privat");
        }

        fields = Prestec.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " hauria de ser privat");
        }
    }
}
