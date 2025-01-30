package com.exercicis;

import com.exercici0303.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.stefanbirkner.systemlambda.SystemLambda;

class TestExercici0303 {

    @BeforeEach
    public void resetConfiguracioGlobal() {
        try {
            java.lang.reflect.Field instanciaField = ConfiguracioGlobal.class.getDeclaredField("instancia");
            instanciaField.setAccessible(true);
            instanciaField.set(null, null);
        } catch (Exception e) {
            throw new RuntimeException("Error al reiniciar l'estat de ConfiguracioGlobal", e);
        }
    }

    @Test
    public void testSingletonInstance() {
        ConfiguracioGlobal instance1 = ConfiguracioGlobal.getInstance();
        ConfiguracioGlobal instance2 = ConfiguracioGlobal.getInstance();
        assertSame(instance1, instance2, "Les instàncies del Singleton no són idèntiques.");
    }

    @Test
    public void testDefaultValues() {
        ConfiguracioGlobal configuracio = ConfiguracioGlobal.getInstance();
        assertEquals("Anglès", configuracio.getIdioma(), "L'idioma predeterminat no és correcte.");
        assertEquals("UTC", configuracio.getZonaHoraria(), "La zona horària predeterminada no és correcta.");
    }

    @Test
    public void testSetAndGetIdioma() {
        ConfiguracioGlobal configuracio = ConfiguracioGlobal.getInstance();
        configuracio.setIdioma("Francès");
        assertEquals("Francès", configuracio.getIdioma(), "L'idioma no s'ha configurat correctament.");
    }

    @Test
    public void testSetAndGetZonaHoraria() {
        ConfiguracioGlobal configuracio = ConfiguracioGlobal.getInstance();
        configuracio.setZonaHoraria("GMT");
        assertEquals("GMT", configuracio.getZonaHoraria(), "La zona horària no s'ha configurat correctament.");
    }

    @Test
    public void testUsuariMostrarPreferencies() throws Exception {
        ConfiguracioGlobal configuracio = ConfiguracioGlobal.getInstance();
        configuracio.setIdioma("Francès");
        configuracio.setZonaHoraria("GMT");

        String text = SystemLambda.tapSystemOut(() -> {
            Usuari usuari = new Usuari();
            usuari.mostrarPreferencies();
        });

        String expectedOutput = "Idioma: Francès, Zona Horaria: GMT\n";
        assertEquals(expectedOutput, text, "La sortida de mostrarPreferencies no és correcta.");
    }

    @Test
    public void testSistemaConfigurarSistema() throws Exception {
        ConfiguracioGlobal configuracio = ConfiguracioGlobal.getInstance();
        configuracio.setIdioma("Francès");
        configuracio.setZonaHoraria("GMT");

        String text = SystemLambda.tapSystemOut(() -> {
            Sistema sistema = new Sistema();
            sistema.configurarSistema();
        });

        String expectedOutput = "Configurant sistema amb idioma Francès i zona horària GMT\n";
        assertEquals(expectedOutput, text, "La sortida de configurarSistema no és correcta.");
    }
}
