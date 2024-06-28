package com.project;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

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
        String expectedOutput = """
                UI: Test Accio UI
                API: Test Accio API
                UI: Inici de sessió
                API: Consulta de dades
                UI: Actualització de perfil
                API: Desconnexió
                """.replaceAll("                ","");
        String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
        assertTrue(diff.compareTo("identical") == 0, 
            "\n>>>>>>>>>> >>>>>>>>>>\n" +
            diff +
            "<<<<<<<<<< <<<<<<<<<<\n");
    }

    @Test
    public void testMainSettersGetters() {
        // Com aquest test es centra en un patró Singleton i en la interacció entre components,
        // i no en setters/getters tradicionals, es validaran les interaccions

        // Creació d'instàncies i realització d'accions
        InterficieUsuari ui = new InterficieUsuari();
        ApiBackend api = new ApiBackend();
        
        ui.realitzarAccio("Test Accio UI");
        api.executarAccio("Test Accio API");

        // Recuperem l'instància del Singleton i verifiquem que les accions s'han registrat correctament
        RegistreAccionsSingleton registro = RegistreAccionsSingleton.getInstance();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        registro.mostrarAccions();

        // Restaura els fluxos originals
        System.setOut(originalOut);

        // Verifiquem que les accions s'han registrat correctament
        String text = outContent.toString().replace("\r\n", "\n"); // Normalitza les noves línies
        assertTrue(text.contains("UI: Test Accio UI"), "L'accio de la UI no s'ha registrat correctament.");
        assertTrue(text.contains("API: Test Accio API"), "L'accio de l'API no s'ha registrat correctament.");
    }

    @Test
    public void testMainPrivateAttributes() {
        // Obtenim tots els camps de la classe ApiBackend
        Field[] fields = ApiBackend.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " hauria de ser privat");
        }

        fields = InterficieUsuari.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " hauria de ser privat");
        }

        fields = RegistreAccionsSingleton.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " hauria de ser privat");
        }
    }
}
