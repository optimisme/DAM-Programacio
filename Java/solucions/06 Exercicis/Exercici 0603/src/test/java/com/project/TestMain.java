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
        String expectedOutput = "Processant un pagament en efectiu:\n" +
            "El pagament en efectiu ha estat processat.\n\n" +
            "Processant un pagament amb targeta:\n" +
            "El pagament amb targeta ha estat autoritzat.\n" +
            "El pagament amb targeta ha estat processat.\n\n" +
            "Processant un pagament digital:\n" +
            "El pagament digital ha estat autoritzat.\n" +
            "El pagament digital ha estat processat.\n";
        assertStringEqualsWithDetail(expectedOutput, text);
    }

    private void assertStringEqualsWithDetail(String expected, String actual) {
        String diff = TestStringUtils.findFirstDifference(expected, actual);
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

        // Validació de la implementació de la interfície i la correcta crida de mètodes
        PagamentEfectiu pagamentEfectiu = new PagamentEfectiu();
        PagamentTargeta pagamentTargeta = new PagamentTargeta();
        PagamentDigital pagamentDigital = new PagamentDigital();

        // Processar pagament en efectiu
        pagamentEfectiu.processarPagament();
        String efectiuOutput = outContent.toString().replace("\r\n", "\n");
        outContent.reset();

        // Processar pagament amb targeta
        pagamentTargeta.autoritzarPagament();
        pagamentTargeta.processarPagament();
        String targetaOutput = outContent.toString().replace("\r\n", "\n");
        outContent.reset();

        // Processar pagament digital
        pagamentDigital.autoritzarPagament();
        pagamentDigital.processarPagament();
        String digitalOutput = outContent.toString().replace("\r\n", "\n");

        // Restaura els fluxos originals
        System.setOut(originalOut);

        // Validació de la sortida esperada
        String expectedEfectiuOutput = "El pagament en efectiu ha estat processat.\n";
        String expectedTargetaOutput = "El pagament amb targeta ha estat autoritzat.\nEl pagament amb targeta ha estat processat.\n";
        String expectedDigitalOutput = "El pagament digital ha estat autoritzat.\nEl pagament digital ha estat processat.\n";

        assertStringEqualsWithDetail(expectedEfectiuOutput, efectiuOutput);
        assertStringEqualsWithDetail(expectedTargetaOutput, targetaOutput);
        assertStringEqualsWithDetail(expectedDigitalOutput, digitalOutput);

        // Assegurem-nos que les classes implementen les interfícies esperades
        assertTrue(pagamentEfectiu instanceof Pagable, "PagamentEfectiu hauria d'implementar Pagable");
        assertTrue(pagamentTargeta instanceof Autoritzable, "PagamentTargeta hauria d'implementar Autoritzable i Pagable");
        assertTrue(pagamentDigital instanceof Autoritzable, "PagamentDigital hauria d'implementar Autoritzable i Pagable");
    }

    @Test
    public void testMainPrivateAttributes() {
        // Obtenim tots els camps de la classe PagamentEfectiu
        Field[] fields = PagamentEfectiu.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " hauria de ser privat");
        }

        // Obtenim tots els camps de la classe PagamentTargeta
        fields = PagamentTargeta.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " hauria de ser privat");
        }

        // Obtenim tots els camps de la classe PagamentDigital
        fields = PagamentDigital.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " hauria de ser privat");
        }
    }
}
