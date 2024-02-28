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

        // Comprova que la sortida conté el text esperat
        String expectedOutput = "Temperatura mitjana: 21.75°C\n" + 
                        "Nova temperatura mitjana (20): 21.0°C\n" + 
                        "Nova temperatura mitjana (25): 22.5°C";
        assertTrue(text.contains(expectedOutput), 
            ">>>>>>>>>> >>>>>>>>>>\n" +
            "El missatge de sortida no coincideix amb l'esperat. \n" +
            "Esperat: \n" + expectedOutput + "\n" + 
            "Obtingut: \n" + text + 
            "<<<<<<<<<<< <<<<<<<<<<\n");
    }

    @Test
    public void testMainGetters() {
        // Reset dels atributs estàtics per a aquest test
        // Això podria requerir mètodes addicionals en la classe ControlTemperatura per a resetejar els valors estàtics
        // o bé podries inicialitzar aquests valors estàtics de nou de alguna manera.
    
        // Creació de zones amb temperatures inicials
        ControlTemperatura zona1 = new ControlTemperatura("Recepció", 21.5);
        ControlTemperatura zona2 = new ControlTemperatura("Oficina", 22.0);
        
        // Comprovació dels getters per a zona1
        assertEquals("Recepció", zona1.getNomZona(), "El nom de la zona1 no coincideix amb el esperat.");
        assertEquals(21.5, zona1.getTemperatura(), "La temperatura de la zona1 no coincideix amb l'esperada.");
        
        // Comprovació dels getters per a zona2
        assertEquals("Oficina", zona2.getNomZona(), "El nom de la zona2 no coincideix amb el esperat.");
        assertEquals(22.0, zona2.getTemperatura(), "La temperatura de la zona2 no coincideix amb l'esperada.");
    
        // Comprovació de la temperatura mitjana inicial
        double temperaturaMitjanaEsperada = (21.5 + 22.0) / 2;
        assertEquals(temperaturaMitjanaEsperada, ControlTemperatura.getTemperaturaMitjana(), "La temperatura mitjana inicial no coincideix amb l'esperada.");
    
        // Ajust de la temperatura de zona1 i comprovació de l'efecte sobre la temperatura mitjana
        zona1.ajustaTemperatura(20.0);
        temperaturaMitjanaEsperada = (20.0 + 22.0) / 2;
        assertEquals(temperaturaMitjanaEsperada, ControlTemperatura.getTemperaturaMitjana(), "La temperatura mitjana després de l'ajust de zona1 no coincideix amb l'esperada.");
    
        // Ajust de la temperatura de zona2 i comprovació de l'efecte sobre la temperatura mitjana
        zona2.ajustaTemperatura(23.0);
        temperaturaMitjanaEsperada = (20.0 + 23.0) / 2;
        assertEquals(temperaturaMitjanaEsperada, ControlTemperatura.getTemperaturaMitjana(), "La temperatura mitjana després de l'ajust de zona2 no coincideix amb l'esperada.");
    }
    
    

    @Test
    public void testMainPrivateAttributes() {
        // Obtenim tots els camps de la classe Cotxe
        Field[] fields = ControlTemperatura.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " hauria de ser privat");
        }
    }
}
