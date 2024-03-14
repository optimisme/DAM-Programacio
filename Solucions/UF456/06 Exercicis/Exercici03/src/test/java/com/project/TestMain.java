package com.project;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        String expectedOutput = "Processant un pagament en efectiu:\n" +
            "El pagament en efectiu ha estat processat.\n\n" +
            "Processant un pagament amb targeta:\n" +
            "El pagament amb targeta ha estat autoritzat.\n" +
            "El pagament amb targeta ha estat processat.\n\n" +
            "Processant un pagament digital:\n" +
            "El pagament digital ha estat autoritzat.\n" +
            "El pagament digital ha estat processat.";
        assertTrue(text.contains(expectedOutput), 
            ">>>>>>>>>> >>>>>>>>>>\n" +
            "El missatge de sortida no coincideix amb l'esperat. \n" +
            "Esperat: \n" + expectedOutput + "\n" + 
            "Obtingut: \n" + text + 
            "<<<<<<<<<<< <<<<<<<<<<\n");
    }

    @Test
    public void testMainValidation() throws Exception {
        // Validació de la implementació de la interfície i la correcta crida de mètodes
        PagamentEfectiu pagamentEfectiu = new PagamentEfectiu();
        PagamentTargeta pagamentTargeta = new PagamentTargeta();
        PagamentDigital pagamentDigital = new PagamentDigital();
    
        // Capturem i validem l'output de processarPagament i autoritzarPagament per PagamentTargeta
        String expectedTargetaOutput = "El pagament amb targeta ha estat autoritzat.\nEl pagament amb targeta ha estat processat.\n";
        String targetaOutput = SystemLambda.tapSystemOut(() -> {
            pagamentTargeta.autoritzarPagament();
            pagamentTargeta.processarPagament();
        });
        assertEquals(expectedTargetaOutput, targetaOutput.replace("\r\n", "\n");, "La sortida per a pagament amb targeta no és l'esperada.");
    
        // Capturem i validem l'output de processarPagament i autoritzarPagament per PagamentDigital
        String expectedDigitalOutput = "El pagament digital ha estat autoritzat.\nEl pagament digital ha estat processat.\n";
        String digitalOutput = SystemLambda.tapSystemOut(() -> {
            pagamentDigital.autoritzarPagament();
            pagamentDigital.processarPagament();
        });
        assertEquals(expectedDigitalOutput, digitalOutput.replace("\r\n", "\n");, "La sortida per a pagament digital no és l'esperada.");
    
        // Assegurem-nos que les classes implementen les interfícies esperades
        assertTrue(pagamentEfectiu instanceof Pagable, "PagamentEfectiu hauria d'implementar Pagable");
        assertTrue(pagamentTargeta instanceof Autoritzable, "PagamentTargeta hauria d'implementar Autoritzable i Pagable");
        assertTrue(pagamentDigital instanceof Autoritzable, "PagamentDigital hauria d'implementar Autoritzable i Pagable");
    }
    
}
