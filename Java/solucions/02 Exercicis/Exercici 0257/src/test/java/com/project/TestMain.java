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
    public void testTaulesSumar() {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            // Executa la funció per a provar la seva sortida
            Main.taulesSumar(3, 4);
            String text = outContent.toString().replace("\r\n", "\n").trim();
            String expectedOutput = "3 + 0 = 3\n3 + 1 = 4\n3 + 2 = 5\n3 + 3 = 6\n3 + 4 = 7\n-----\n" +
                                    "4 + 0 = 4\n4 + 1 = 5\n4 + 2 = 6\n4 + 3 = 7\n4 + 4 = 8\n-----";
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0, 
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                diff +
                "<<<<<<<<<< <<<<<<<<<<\n");

            // Reseteja el contingut de la sortida abans de la següent prova
            outContent.reset();

            // Executa la funció per a provar la seva sortida
            Main.taulesSumar(5, 7);
            text = outContent.toString().replace("\r\n", "\n").trim();
            expectedOutput = "5 + 0 = 5\n5 + 1 = 6\n5 + 2 = 7\n5 + 3 = 8\n5 + 4 = 9\n-----\n" +
                             "6 + 0 = 6\n6 + 1 = 7\n6 + 2 = 8\n6 + 3 = 9\n6 + 4 = 10\n-----\n" +
                             "7 + 0 = 7\n7 + 1 = 8\n7 + 2 = 9\n7 + 3 = 10\n7 + 4 = 11\n-----";
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
