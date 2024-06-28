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
        String expectedOutput = "Maria Lopez - Salari Anual: 30000.0\n" +
            "Després de l'increment: 33000.0\n" +
            "Carlos Garcia [TI] - Salari Anual: 50000.0\n" +
            "Després de l'increment: 55000.0\n";
        String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
        assertTrue(diff.compareTo("identical") == 0, 
            "\n>>>>>>>>>> >>>>>>>>>>\n" +
            diff +
            "<<<<<<<<<< <<<<<<<<<<\n");
    }

    @Test
    public void testMainValidation() {
        // Creem una instància d'Empleat amb dades de prova
        Empleat empleatProva = new Empleat("Ana", "Pérez", 40000);
        assertEquals("Ana Pérez", empleatProva.getNomComplet(), "El nom complet de l'empleat no coincideix");
        assertEquals(40000, empleatProva.getSalariAnual(), "El salari anual inicial de l'empleat no coincideix");

        // Provem l'increment de salari
        empleatProva.incrementarSalari(25); // Incrementem un 25%
        assertEquals(50000, empleatProva.getSalariAnual(), "El salari anual després de l'increment no coincideix");

        // Creem una instància de Gerent amb dades de prova
        Gerent gerentProva = new Gerent("Juan", "Martínez", 60000, "Màrqueting");
        assertEquals("Juan Martínez [Màrqueting]", gerentProva.getNomComplet(), "El nom complet del gerent no coincideix");
        assertEquals(60000, gerentProva.getSalariAnual(), "El salari anual inicial del gerent no coincideix");

        // Provem l'increment de salari del gerent
        gerentProva.incrementarSalari(10); // Incrementem un 10%
        assertEquals(66000, gerentProva.getSalariAnual(), "El salari anual del gerent després de l'increment no coincideix");
    }

    @Test
    public void testMainPrivateAttributes() {
        // Obtenim tots els camps de la classe Empleat
        Field[] fields = Empleat.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " hauria de ser privat");
        }

        fields = Gerent.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " hauria de ser privat");
        }
    }
}
