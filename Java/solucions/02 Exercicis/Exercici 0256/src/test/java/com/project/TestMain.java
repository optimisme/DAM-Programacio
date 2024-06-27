package com.project;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMain {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
        outContent.reset();
    }

    @Test
    public void testPorcioTaula() {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            // Executa la funció per a provar la seva sortida
            Main.porcioTaula(2, 4, 7);
            String text = outContent.toString().replace("\r\n", "\n").trim();
            String expectedOutput = "4 x 2 = 8\n5 x 2 = 10\n6 x 2 = 12\n7 x 2 = 14";
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0, 
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                diff +
                "<<<<<<<<<< <<<<<<<<<<\n");

            // Reseteja el contingut de la sortida abans de la següent prova
            outContent.reset();

            // Executa la funció per a provar la seva sortida
            Main.porcioTaula(5, 3, 5);
            text = outContent.toString().replace("\r\n", "\n").trim();
            expectedOutput = "3 x 5 = 15\n4 x 5 = 20\n5 x 5 = 25";
            diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0, 
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                diff +
                "<<<<<<<<<< <<<<<<<<<<\n");
        } finally {
            Locale.setDefault(defaultLocale); // Restaura la configuració regional per defecte
        }
    }
}
