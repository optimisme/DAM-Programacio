package com.exercicis;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import com.github.stefanbirkner.systemlambda.SystemLambda;
import com.resolt0303.ConfiguracioGlobal;
import com.resolt0303.Sistema;
import com.resolt0303.Usuari;

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
    public void testSingletonInstance(TestInfo testInfo) throws Exception {
        try {
            ConfiguracioGlobal instance1 = ConfiguracioGlobal.getInstance();
            ConfiguracioGlobal instance2 = ConfiguracioGlobal.getInstance();
            assertSame(instance1, instance2, "Les instàncies del Singleton no són idèntiques.");
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
    public void testDefaultValues(TestInfo testInfo) throws Exception {
        try {
            ConfiguracioGlobal configuracio = ConfiguracioGlobal.getInstance();
            assertEquals("Anglès", configuracio.getIdioma(), "L'idioma predeterminat no és correcte.");
            assertEquals("UTC", configuracio.getZonaHoraria(), "La zona horària predeterminada no és correcta.");
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
    public void testSetAndGetIdioma(TestInfo testInfo) throws Exception {
        try {
            ConfiguracioGlobal configuracio = ConfiguracioGlobal.getInstance();
            configuracio.setIdioma("Francès");
            assertEquals("Francès", configuracio.getIdioma(), "L'idioma no s'ha configurat correctament.");
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
    public void testSetAndGetZonaHoraria(TestInfo testInfo) throws Exception {
        try {
            ConfiguracioGlobal configuracio = ConfiguracioGlobal.getInstance();
            configuracio.setZonaHoraria("GMT");
            assertEquals("GMT", configuracio.getZonaHoraria(), "La zona horària no s'ha configurat correctament.");
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
    public void testUsuariMostrarPreferencies(TestInfo testInfo) throws Exception {
        try {
            ConfiguracioGlobal configuracio = ConfiguracioGlobal.getInstance();
            configuracio.setIdioma("Francès");
            configuracio.setZonaHoraria("GMT");

            String text = SystemLambda.tapSystemOut(() -> {
                Usuari usuari = new Usuari();
                usuari.mostrarPreferencies();
            });

            String expectedOutput = 
                "Idioma: Francès, Zona Horaria: GMT\n" +
                "Langue Francès, Fuseau horaire de GMT\n";

            assertEquals(expectedOutput, text, "La sortida de mostrarPreferencies no és correcta.");
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
    public void testSistemaConfigurarSistema(TestInfo testInfo) throws Exception {
        try {
            ConfiguracioGlobal configuracio = ConfiguracioGlobal.getInstance();
            configuracio.setIdioma("Francès");
            configuracio.setZonaHoraria("GMT");

            String text = SystemLambda.tapSystemOut(() -> {
                Sistema sistema = new Sistema();
                sistema.configurarSistema();
            });

            String expectedOutput = 
                "Configuration du système en langue Francès et fuseau horaire de GMT\n";

            assertEquals(expectedOutput, text, "La sortida de configurarSistema no és correcta.");
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
