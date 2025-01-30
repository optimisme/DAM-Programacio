package com.exercicis;

import com.exercici0301.*;
import com.testStringUtils.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.github.stefanbirkner.systemlambda.SystemLambda;

class TestExercici0301 {

    @BeforeEach
    public void resetControlTemperaturaState() {
        // Reinicia els atributs estàtics abans de cada test
        try {
            java.lang.reflect.Field temperaturaTotalField = ControlTemperatura.class.getDeclaredField("temperaturaTotal");
            java.lang.reflect.Field comptadorZonesField = ControlTemperatura.class.getDeclaredField("comptadorZones");

            temperaturaTotalField.setAccessible(true);
            comptadorZonesField.setAccessible(true);

            temperaturaTotalField.set(null, 0.0);
            comptadorZonesField.set(null, 0);
        } catch (Exception e) {
            throw new RuntimeException("Error al reiniciar l'estat de la classe ControlTemperatura", e);
        }
    }

    @Test
    public void testTemperaturaMitjanaInicial() throws Exception {
        double mitjana = ControlTemperatura.getTemperaturaMitjana();
        assertEquals(0.0, mitjana, 0.01, "La temperatura mitjana inicial ha de ser 0.");
    }

    @Test
    public void testCreacioZones() throws Exception {
        ControlTemperatura zona1 = new ControlTemperatura("Zona 1", 22.5);
        ControlTemperatura zona2 = new ControlTemperatura("Zona 2", 25.0);

        assertEquals(23.75, ControlTemperatura.getTemperaturaMitjana(), 0.01, "La temperatura mitjana no és correcta després d'afegir dues zones.");
    }

    @Test
    public void testAjustarTemperatura() throws Exception {
        ControlTemperatura zona = new ControlTemperatura("Zona 1", 22.5);
        zona.ajustaTemperatura(24.0);

        assertEquals(24.0, zona.getTemperatura(), 0.01, "La temperatura de la zona no s'ha ajustat correctament.");
        assertEquals(24.0, ControlTemperatura.getTemperaturaMitjana(), 0.01, "La temperatura mitjana no s'ha ajustat correctament després del canvi.");
    }

    @Test
    public void testTemperaturaMitjanaDespresDeEliminarZones() throws Exception {
        ControlTemperatura zona1 = new ControlTemperatura("Zona 1", 22.5);
        ControlTemperatura zona2 = new ControlTemperatura("Zona 2", 25.0);

        zona1.ajustaTemperatura(0.0);

        assertEquals(12.5, ControlTemperatura.getTemperaturaMitjana(), 0.01, "La temperatura mitjana no és correcta després de canviar una zona a 0.");
    }
}
