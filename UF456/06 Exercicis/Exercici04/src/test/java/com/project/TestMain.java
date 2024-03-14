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
        String expectedOutput = "OcellVolador{nom='Piolín', edat=2}, colorPlomatge='groc'\n" +
            "Piolín està volant!\n" +
            "Dofi{nom='Flipper', edat=5}, tipusPelatge='suau'\n" +
            "Flipper està nedant!";
        assertTrue(text.contains(expectedOutput), 
            ">>>>>>>>>> >>>>>>>>>>\n" +
            "El missatge de sortida no coincideix amb l'esperat. \n" +
            "Esperat: \n" + expectedOutput + "\n" + 
            "Obtingut: \n" + text + 
            "<<<<<<<<<<< <<<<<<<<<<\n");
    }

    @Test
    public void testMainValidation() throws Exception {
        // Crear noves instàncies amb dades diferents a les del main
        OcellVolador ocell2 = new OcellVolador("Corb", 4, "negre");
        Dofi dofi2 = new Dofi("Dolly", 8, "llis");
    
        // Capturar i validar la sortida del mètode volar de l'ocell2
        String expectedOcellOutput = "Corb està volant!\n";
        String ocellOutput = SystemLambda.tapSystemOut(() -> {
            ocell2.volar();
        });
        assertEquals(expectedOcellOutput, ocellOutput.replace("\r\n", "\n"), "La sortida per al mètode volar de l'OcellVolador no és l'esperada.");
    
        // Capturar i validar la sortida del mètode nadar del dofi2
        String expectedDofiOutput = "Dolly està nedant!\n";
        String dofiOutput = SystemLambda.tapSystemOut(() -> {
            dofi2.nedar();
        });
        assertEquals(expectedDofiOutput, dofiOutput.replace("\r\n", "\n"), "La sortida per al mètode nadar del Dofi no és l'esperada.");
    
        // Validar la sobreescriptura correcta del mètode toString per a ocell2 i dofi2
        String expectedOcellToString = "OcellVolador{nom='Corb', edat=4}, colorPlomatge='negre'";
        assertEquals(expectedOcellToString, ocell2.toString().replace("\r\n", "\n"), "El mètode toString de l'OcellVolador no retorna el resultat esperat.");
    
        String expectedDofiToString = "Dofi{nom='Dolly', edat=8}, tipusPelatge='llis'";
        assertEquals(expectedDofiToString, dofi2.toString().replace("\r\n", "\n"), "El mètode toString del Dofi no retorna el resultat esperat.");
    }
    
    
    @Test
    public void testMainPrivateAttributes() {
        // Obtenim tots els camps de la classe Cotxe
        Field[] fields = Animal.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isProtected(field.getModifiers()), "El camp " + field.getName() + " (Animal) hauria de ser protected");
        }

        fields = Mamifer.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " (Mamifer) hauria de ser privat");
        }

        fields = Ocell.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " (Ocell) hauria de ser privat");
        }
    }
}
