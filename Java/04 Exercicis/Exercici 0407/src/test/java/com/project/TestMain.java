package com.project;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestMain {

    @Test
    public void testMainOutput() throws Exception {
        // Redirigeix la sortida estàndard a un flux de sortida
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Executa el main per a provar la seva sortida
        String[] args = {}; // Passa els arguments necessaris si n'hi ha
        Main.main(args);

        // Restaura els fluxos originals
        System.setOut(originalOut);

        // Comprova que la sortida conté el text esperat
        String text = outContent.toString().replace("\r\n", "\n"); // Normalitza les noves línies
        String expectedOutput = "Idioma: Castellà, Zona Horaria: CET\n" + 
            "Configurant sistema amb idioma Castellà i zona horària CET\n";
        String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
        assertTrue(diff.compareTo("identical") == 0, 
            "\n>>>>>>>>>> >>>>>>>>>>\n" +
            diff +
            "<<<<<<<<<< <<<<<<<<<<\n");
    }

    @Test
    public void testMainSettersGetters() throws Exception {
        // Configuració inicial
        ConfiguracioGlobal config = ConfiguracioGlobal.getInstance();
        String idiomaOriginal = config.getIdioma();
        String zonaHorariaOriginal = config.getZonaHoraria();
    
        // Canviem la configuració
        config.setIdioma("Francès");
        config.setZonaHoraria("GMT");
    
        // Verifiquem els canvis
        assertEquals("Francès", config.getIdioma(), "El setter o el getter d'idioma no funciona correctament.");
        assertEquals("GMT", config.getZonaHoraria(), "El setter o el getter de zona horària no funciona correctament.");
    
        // Prova de les funcions específiques a través de Usuari i Sistema
        Usuari usuari = new Usuari();
        Sistema sistema = new Sistema();
    
        // Capturant la sortida de mostrarPreferencies i configurarSistema
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        usuari.mostrarPreferencies();
        String textUsuari = outContent.toString().replace("\r\n", "\n"); // Normalitza les noves línies
        outContent.reset();

        sistema.configurarSistema();
        String textSistema = outContent.toString().replace("\r\n", "\n"); // Normalitza les noves línies

        // Restaura els fluxos originals
        System.setOut(originalOut);

        // Verificació que les sortides contenen la configuració correcta
        assertTrue(textUsuari.contains("Francès") && textUsuari.contains("GMT"), "La funció mostrarPreferencies de Usuari no mostra la configuració correcta.");
        assertTrue(textSistema.contains("Francès") && textSistema.contains("GMT"), "La funció configurarSistema de Sistema no configura segons la configuració global correcta.");
    }
    
    @Test
    public void testMainPrivateAttributes() {
        // Obtenim tots els camps de la classe ConfiguracioGlobal
        Field[] fields = ConfiguracioGlobal.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " hauria de ser privat");
        }

        fields = Sistema.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " hauria de ser privat");
        }

        fields = Usuari.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " hauria de ser privat");
        }
    }
}
