package com.project;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
        String expectedOutput = "Joan - Nota Mitjana: 4.75\n" + 
            "Maria - Nota Mitjana: 4.0\n";
        String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
        assertTrue(diff.compareTo("identical") == 0, 
            "\n>>>>>>>>>> >>>>>>>>>>\n" +
            diff +
            "<<<<<<<<<< <<<<<<<<<<\n");
    }

    @Test
    public void testMainSettersGetters() throws Exception {
        // Creació i verificació d'Estudiant
        Estudiant estudiant = new Estudiant("TestNom", 20);
        assertEquals("TestNom", estudiant.getNom(), "El nom de l'estudiant no és correcte");
        assertEquals(20, estudiant.getEdat(), "L'edat de l'estudiant no és correcta");
        
        // Actualització i verificació de la nota mitjana
        estudiant.actualitzaNotaMitjana(8.0);
        assertEquals(4.0, estudiant.getNotaMitjana(), "La nota mitjana de l'estudiant no s'ha actualitzat correctament");
        
        // Creació de Curs i afegiment d'estudiants
        Curs curs = new Curs("TestCurs", "TestProfessor");
        assertEquals("TestCurs", curs.getNomCurs(), "El nom del curs no és correcte");
        assertEquals("TestProfessor", curs.getProfessor(), "El nom del professor no és correcte");
        
        curs.afegeixEstudiant(estudiant);
        
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        
        curs.mostraEstudiants();
        
        // Restaura els fluxos originals
        System.setOut(originalOut);

        // Comprovació de la sortida de mostraEstudiants
        String text = outContent.toString().replace("\r\n", "\n"); // Normalitza les noves línies
        String expectedOutput = "TestNom - Nota Mitjana: 4.0\n";
        assertTrue(text.contains(expectedOutput), "La sortida de mostraEstudiants no és correcta");
        
        // Eliminació d'estudiant i comprovació que ja no es mostra
        curs.eliminaEstudiant("TestNom");

        outContent.reset();
        System.setOut(new PrintStream(outContent));
        
        curs.mostraEstudiants();

        // Restaura els fluxos originals
        System.setOut(originalOut);

        String textAfterRemoval = outContent.toString().replace("\r\n", "\n"); // Normalitza les noves línies
        assertFalse(textAfterRemoval.contains(expectedOutput), "L'estudiant no s'ha eliminat correctament del curs");
    }

    @Test
    public void testMainPrivateAttributes() {
        // Obtenim tots els camps de la classe Curs
        Field[] fields = Curs.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " hauria de ser privat");
        }

        fields = Estudiant.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " hauria de ser privat");
        }
    }
}
