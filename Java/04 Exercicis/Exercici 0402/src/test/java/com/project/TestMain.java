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
        String expectedOutput = """
                Intent registrant: Estudiant1. Total registrats: 2
                Intent registrant: Estudiant2. Total registrats: 3
                Intent registrant: Estudiant3. Total registrats: 4
                Intent registrant: Estudiant4. Total registrats: 5
                No es pot registrar l'estudiant. La capacitat màxima ha estat assolida.
                Intent registrant: Estudiant5. Total registrats: 5
                No es pot registrar l'estudiant. La capacitat màxima ha estat assolida.
                Intent registrant: Estudiant6. Total registrats: 5
                No hi ha més capacitat per a registrar estudiants.
                """.replaceAll("                ", "");
        String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
        assertTrue(diff.compareTo("identical") == 0,
            "\n>>>>>>>>>> >>>>>>>>>>\n" +
            diff +
            "<<<<<<<<<< <<<<<<<<<<\n");
    }

    @Test
    public void testMainSettersGetters() {
        // Reset del comptador d'estudiants per aquest test
        // Això requeriria d'un mètode estàtic en la classe Estudiant per a resetejar el comptador,
        // o bé es pot ometre si no es disposa d'aquesta funcionalitat.
        // Estudiant.resetComptador();

        // Assegura't que la capacitat permet crear almenys un estudiant
        assertTrue(Estudiant.hiHaCapacitat(), "Hauria d'haver capacitat per a registrar estudiants.");

        // Creació d'un estudiant
        Estudiant estudiant = new Estudiant("NomTest", "IDTest");

        // Verifica els getters
        assertEquals("NomTest", estudiant.getNom(), "El nom obtingut amb getNom no coincideix amb el esperat.");
        assertEquals("IDTest", estudiant.getId(), "L'ID obtingut amb getId no coincideix amb el esperat.");
    }

    @Test
    public void testMainPrivateAttributes() {
        // Obtenim tots els camps de la classe Estudiant
        Field[] fields = Estudiant.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " hauria de ser privat");
        }
    }
}
