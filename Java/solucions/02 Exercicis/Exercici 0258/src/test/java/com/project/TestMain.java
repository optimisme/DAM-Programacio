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
    }

    @Test
    public void testMostrarTaula() {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            Main.mostrarTaula();
            String text = outContent.toString().replace("\r\n", "\n").trim();

            String expectedOutput = "0,0 1,0 2,0 3,0 4,0 5,0\n" +
                                    "0,1 1,1 2,1 3,1 4,1 5,1\n" +
                                    "0,2 1,2 2,2 3,2 4,2 5,2\n" +
                                    "0,3 1,3 2,3 3,3 4,3 5,3\n" +
                                    "0,4 1,4 2,4 3,4 4,4 5,4\n" +
                                    "0,5 1,5 2,5 3,5 4,5 5,5";
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0,
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                diff +
                "<<<<<<<<<< <<<<<<<<<<\n");
        } finally {
            Locale.setDefault(defaultLocale); // Restaura la configuració regional per defecte
        }
    }
}
