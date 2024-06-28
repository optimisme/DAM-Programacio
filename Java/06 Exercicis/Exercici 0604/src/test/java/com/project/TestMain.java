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
        String expectedOutput = "OcellVolador{nom='Piolín', edat=2}, colorPlomatge='groc'\n" +
            "Piolín està volant!\n" +
            "Dofi{nom='Flipper', edat=5}, tipusPelatge='suau'\n" +
            "Flipper està nedant!\n";
        String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
        assertTrue(diff.compareTo("identical") == 0, 
            "\n>>>>>>>>>> >>>>>>>>>>\n" +
            diff +
            "<<<<<<<<<< <<<<<<<<<<\n");
    }

    @Test
    public void testMainValidation() throws Exception {
        // Redirigeix la sortida estàndard a un flux de sortida
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Crear noves instàncies amb dades diferents a les del main
        OcellVolador ocell2 = new OcellVolador("Corb", 4, "negre");
        Dofi dofi2 = new Dofi("Dolly", 8, "llis");

        // Processar i validar la sortida del mètode volar de l'ocell2
        ocell2.volar();
        String ocellOutput = outContent.toString().replace("\r\n", "\n");
        String expectedOcellOutput = "Corb està volant!\n";
        assertEquals(expectedOcellOutput, ocellOutput, "La sortida per al mètode volar de l'OcellVolador no és l'esperada.");

        // Reset output stream
        outContent.reset();

        // Processar i validar la sortida del mètode nadar del dofi2
        dofi2.nedar();
        String dofiOutput = outContent.toString().replace("\r\n", "\n");
        String expectedDofiOutput = "Dolly està nedant!\n";
        assertEquals(expectedDofiOutput, dofiOutput, "La sortida per al mètode nadar del Dofi no és l'esperada.");

        // Restaura els fluxos originals
        System.setOut(originalOut);

        // Validar la sobreescriptura correcta del mètode toString per a ocell2 i dofi2
        String expectedOcellToString = "OcellVolador{nom='Corb', edat=4}, colorPlomatge='negre'";
        assertEquals(expectedOcellToString, ocell2.toString(), "El mètode toString de l'OcellVolador no retorna el resultat esperat.");

        String expectedDofiToString = "Dofi{nom='Dolly', edat=8}, tipusPelatge='llis'";
        assertEquals(expectedDofiToString, dofi2.toString(), "El mètode toString del Dofi no retorna el resultat esperat.");
    }

    @Test
    public void testMainPrivateAttributes() {
        // Obtenim tots els camps de la classe Animal
        Field[] fields = Animal.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui protegit
        for (Field field : fields) {
            assertTrue(Modifier.isProtected(field.getModifiers()), "El camp " + field.getName() + " (Animal) hauria de ser protected");
        }

        // Obtenim tots els camps de la classe Mamifer
        fields = Mamifer.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " (Mamifer) hauria de ser privat");
        }

        // Obtenim tots els camps de la classe Ocell
        fields = Ocell.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " (Ocell) hauria de ser privat");
        }
    }
}
