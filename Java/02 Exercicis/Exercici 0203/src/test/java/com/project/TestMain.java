package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestMain {

    @Test
    public void testMainOutput() throws Exception {
        String input = "gat\ncorre\npilota\n"; // Simula l'entrada de l'usuari
        String expectedOutput = "Digues un animal: Digues què fa l'animal: Digues un objecte: gat, corre, pilota\n";

        // Redirigeix la sortida estàndard a un flux de sortida
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Redirigeix l'entrada estàndard a un flux d'entrada
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        // Executa el main per a provar la seva sortida
        Main.main(new String[]{});

        // Comprova que la sortida conté el text esperat
        String actualOutput = outContent.toString().replace("\r\n", "\n"); // Normalitza les noves línies
        String diff = TestStringUtils.findFirstDifference(actualOutput, expectedOutput);
        assertTrue(diff.compareTo("identical") == 0, 
            "\n>>>>>>>>>> >>>>>>>>>>\n" +
            diff +
            "<<<<<<<<<< <<<<<<<<<<\n");

        // Restaura els fluxos originals
        System.setOut(originalOut);
        System.setIn(System.in);
    }
}
