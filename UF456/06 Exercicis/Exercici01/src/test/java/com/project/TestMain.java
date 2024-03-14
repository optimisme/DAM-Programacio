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
        String expectedOutput = "Electrodomèstic de la marca Samsung amb un consum energètic de 120 watts.\n" +
            "Aquesta nevera té una capacitat de 350 litres.\n" +
            "Electrodomèstic de la marca LG amb un consum energètic de 200 watts.\n" +
            "Aquesta rentadora té una capacitat de càrrega de 8 kg.";
        assertTrue(text.contains(expectedOutput), 
            ">>>>>>>>>> >>>>>>>>>>\n" +
            "El missatge de sortida no coincideix amb l'esperat. \n" +
            "Esperat: \n" + expectedOutput + "\n" + 
            "Obtingut: \n" + text + 
            "<<<<<<<<<<< <<<<<<<<<<\n");
    }

    @Test
    public void testMainValidation() throws Exception {
        // Crea objectes de prova amb dades diferents
        Electrodomestic microones = new Electrodomestic("Panasonic", 800);
        Nevera nevera = new Nevera("Bosch", 150, 250);
        Rentadora rentadora = new Rentadora("Samsung", 180, 5);
    
        // Comprova les propietats de la classe base Electrodomestic
        assertEquals("Panasonic", microones.marca, "La marca de l'electrodomèstic no coincideix");
        assertEquals(800, microones.consumEnergetic, "El consum energètic de l'electrodomèstic no coincideix");
    
        // Comprova la sortida del mètode mostrarInformacio per a Electrodomestic
        String expectedOutputMicroones = "Electrodomèstic de la marca Panasonic amb un consum energètic de 800 watts.";
        String outputMicroones = SystemLambda.tapSystemOut(() -> {
            System.out.println(microones);
        });
        assertTrue(outputMicroones.trim().equals(expectedOutputMicroones), "La sortida de mostrarInformacio per Electrodomestic no és l'esperada");
    
        // Comprova les propietats i el mètode mostrarInformacio de Nevera
        assertEquals("Bosch", nevera.marca, "La marca de la nevera no coincideix");
        assertEquals(150, nevera.consumEnergetic, "El consum energètic de la nevera no coincideix");
        assertEquals(250, nevera.getCapacitat(), "La capacitat de la nevera no coincideix");
    
        String expectedOutputNevera = expectedOutputMicroones.replace("Panasonic", "Bosch").replace("800", "150") + "\nAquesta nevera té una capacitat de 250 litres.";
        String outputNevera = SystemLambda.tapSystemOut(() -> {
            System.out.println(nevera);
        });
        assertTrue(outputNevera.trim().equals(expectedOutputNevera), "La sortida de mostrarInformacio per Nevera no és l'esperada");
    
        // Comprova les propietats i el mètode mostrarInformacio de Rentadora
        assertEquals("Samsung", rentadora.marca, "La marca de la rentadora no coincideix");
        assertEquals(180, rentadora.consumEnergetic, "El consum energètic de la rentadora no coincideix");
        assertEquals(5, rentadora.getCapacitat(), "La capacitat de càrrega de la rentadora no coincideix");
    
        String expectedOutputRentadora = "Electrodomèstic de la marca Samsung amb un consum energètic de 180 watts.\nAquesta rentadora té una capacitat de càrrega de 5 kg.";
        String outputRentadora = SystemLambda.tapSystemOut(() -> {
            System.out.println(rentadora);
        });
        assertTrue(outputRentadora.trim().equals(expectedOutputRentadora.replace("\r\n", "\n")), "La sortida de mostrarInformacio per Rentadora no és l'esperada");
    }
    
    @Test
    public void testMainPrivateAttributes() {
        // Obtenim tots els camps de la classe Cotxe
        Field[] fields = Electrodomestic.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isProtected(field.getModifiers()), "El camp " + field.getName() + " (Electrodomestic) hauria de ser protected");
        }

        fields = Nevera.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " (Nevera) hauria de ser privat");
        }

        fields = Rentadora.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " (Rentadora) hauria de ser privat");
        }
    }
}
