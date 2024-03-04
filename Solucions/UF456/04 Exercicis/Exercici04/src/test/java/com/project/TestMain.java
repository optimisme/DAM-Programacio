package com.project;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
        String expectedOutput = "Joan - Nota Mitjana: 4.75\n" + 
                        "Maria - Nota Mitjana: 4.0";
        assertTrue(text.contains(expectedOutput), 
            ">>>>>>>>>> >>>>>>>>>>\n" +
            "El missatge de sortida no coincideix amb l'esperat. \n" +
            "Esperat: \n" + expectedOutput + "\n" + 
            "Obtingut: \n" + text + 
            "<<<<<<<<<<< <<<<<<<<<<\n");
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
        String text = SystemLambda.tapSystemOut(() -> {
            curs.mostraEstudiants();
        });
        
        // Comprovació de la sortida de mostraEstudiants
        String expectedOutput = "TestNom - Nota Mitjana: 4.0";
        assertTrue(text.contains(expectedOutput), "La sortida de mostraEstudiants no és correcta");
        
        // Eliminació d'estudiant i comprovació que ja no es mostra
        curs.eliminaEstudiant("TestNom");
        String textAfterRemoval = SystemLambda.tapSystemOut(() -> {
            curs.mostraEstudiants();
        });
        
        assertFalse(textAfterRemoval.contains(expectedOutput), "L'estudiant no s'ha eliminat correctament del curs");
    }

    @Test
    public void testMainPrivateAttributes() {
        // Obtenim tots els camps de la classe Cotxe
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
