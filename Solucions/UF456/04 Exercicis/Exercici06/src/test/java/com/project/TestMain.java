package com.project;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

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
        String expectedOutput = "UI: Inici de sessió\n" + 
            "API: Consulta de dades\n" + 
            "UI: Actualització de perfil\n" + 
            "API: Desconnexió" +
            "\n";
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
        String text;
        try {
            text = SystemLambda.tapSystemOut(registro::mostrarAccions);
            // Verifiquem que les accions s'han registrat correctament
            assertTrue(text.contains("UI: Test Accio UI"), "L'accio de la UI no s'ha registrat correctament.");
            assertTrue(text.contains("API: Test Accio API"), "L'accio de l'API no s'ha registrat correctament.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMainPrivateAttributes() {
        // Obtenim tots els camps de la classe Cotxe
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
