package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;

public class TestMain {

    @Test
    public void testMainOutput() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String expectedOutput = "Són les paraules 'Mare' i 'Rema' anagrames? true\n" +
                                    "Són les paraules 'Porta' i 'Tropa' anagrames? true\n" +
                                    "Són les paraules 'Triangle' i 'Integral' anagrames? true\n" +
                                    "Són les paraules 'Sopa' i 'Posa' anagrames? true\n" +
                                    "Són les paraules 'Casa' i 'Sopa' anagrames? false\n" +
                                    "Són les paraules 'Gat' i 'Perro' anagrames? false\n";

            // Redirigeix la sortida estàndard a un flux de sortida
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(outContent));

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
        } finally {
            Locale.setDefault(defaultLocale); // Restaura la configuració regional per defecte
        }
    }
}
