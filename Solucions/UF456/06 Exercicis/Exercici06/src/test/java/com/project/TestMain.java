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
        String expectedOutput = "Atraccions al parc:\n" +
            "Atraccio[nom=Montanya Russa, tipus=Adrenalina, alturaMinima=120]\n\n" +
            "Restaurants al parc:\n" +
            "Restaurant[nom=El Gran Chef, tipusCuina=Italiana, capacitat=100]\n\n" +
            "Botigues al parc:\n" +
            "Botiga[nom=Records del Parc, tipusProducte=Souvenirs]";
        assertTrue(text.contains(expectedOutput), 
            ">>>>>>>>>> >>>>>>>>>>\n" +
            "El missatge de sortida no coincideix amb l'esperat. \n" +
            "Esperat: \n" + expectedOutput + "\n" + 
            "Obtingut: \n" + text + 
            "<<<<<<<<<<< <<<<<<<<<<\n");
    }

    @Test
    public void testMainValidation() throws Exception {
        // Crear una instància de ParcAtraccions
        ParcAtraccions parc = new ParcAtraccions();
    
        // Afegir components al parc
        parc.afegirAtraccio(new Atraccio("Dragon Khan", "Muntanya Russa", 130));
        parc.afegirRestaurant(new Restaurant("Casa Paella", "Espanyola", 80));
        parc.afegirBotiga(new Botiga("Magic Memories", "Fotos & Records"));
    
        // Validar que els components s'han afegit correctament
        assertEquals(1, parc.getAtraccions().size(), "Hauria d'haver 1 atracció afegida al parc.");
        assertEquals(1, parc.getRestaurants().size(), "Hauria d'haver 1 restaurant afegit al parc.");
        assertEquals(1, parc.getBotigues().size(), "Hauria d'haver 1 botiga afegida al parc.");
    
        // Validar informació específica dels components
        Atraccio atraccio = parc.getAtraccions().get(0);
        assertEquals("Dragon Khan", atraccio.getNom(), "El nom de l'atracció no coincideix.");
        assertEquals("Muntanya Russa", atraccio.getTipus(), "El tipus de l'atracció no coincideix.");
        assertEquals(130, atraccio.getAlturaMinima(), "L'altura mínima de l'atracció no coincideix.");
    
        Restaurant restaurant = parc.getRestaurants().get(0);
        assertEquals("Casa Paella", restaurant.getNom(), "El nom del restaurant no coincideix.");
        assertEquals("Espanyola", restaurant.getTipusCuina(), "El tipus de cuina del restaurant no coincideix.");
        assertEquals(80, restaurant.getCapacitat(), "La capacitat del restaurant no coincideix.");
    
        Botiga botiga = parc.getBotigues().get(0);
        assertEquals("Magic Memories", botiga.getNom(), "El nom de la botiga no coincideix.");
        assertEquals("Fotos & Records", botiga.getTipusProducte(), "El tipus de producte de la botiga no coincideix.");
    }   
    
    @Test
    public void testMainPrivateAttributes() {
        // Obtenim tots els camps de la classe Cotxe
        Field[] fields = ParcAtraccions.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " (ParcAtraccions) hauria de ser protected");
        }

        fields = Atraccio.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " (Atraccio) hauria de ser privat");
        }

        fields = Botiga.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " (Botiga) hauria de ser privat");
        }

        fields = Restaurant.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " (Restaurant) hauria de ser privat");
        }
    }
}
