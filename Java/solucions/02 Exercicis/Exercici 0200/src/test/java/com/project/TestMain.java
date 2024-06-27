package com.project;

import java.util.Locale;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestMain {

    @Test
    public void testMainOutput() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            // Redirigeix la sortida estàndard a un flux de sortida
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(outContent));

            // Executa el main per a provar la seva sortida
            String[] args = {}; // Passa els arguments necessaris si n'hi ha
            Main.main(args);

            // Comprova que la sortida conté el text esperat
            String text = outContent.toString().replace("\r\n", "\n");

            String expectedOutput = "El resultat de la divisió és 21.015625\n" +
                                    "El resultat arrodonit de la divisió és 21.02\n";
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0, 
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                diff +
                "<<<<<<<<<< <<<<<<<<<<\n");

        } finally {
            // Restaura la configuració regional per defecte i el flux de sortida
            Locale.setDefault(defaultLocale);
            System.setOut(System.out);
        }
    }
}
