package com.project;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMain {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final ByteArrayInputStream inContent = new ByteArrayInputStream(new byte[0]);
    private final java.io.InputStream originalIn = System.in;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
        outContent.reset();
    }

    @Test
    public void testCalculaPreuFrase() {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            testFrase("Hello World 123 AaBbZz", 2.10);
            testFrase("En Gabriel ha comprat 3 kg de taronges", 3.00);
            testFrase("Jo tinc 2 germans, un es diu Quim i l'altre Zahir", 3.70);
        } finally {
            Locale.setDefault(defaultLocale); // Restaura la configuració regional per defecte
        }
    }

    private void testFrase(String frase, double expectedPreu) {
        System.setIn(new ByteArrayInputStream(frase.getBytes()));
        Main.main(new String[]{});
        String text = outContent.toString().replace("\r\n", "\n").trim();

        // Comprova que la sortida conté el text esperat
        String expectedOutput = String.format("Introdueix una frase:\nEl preu de la frase '%s' és: %.2f", frase, expectedPreu);
        String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
        assertEquals("identical", diff, 
            "\n>>>>>>>>>> >>>>>>>>>>\n" +
            diff +
            "<<<<<<<<<< <<<<<<<<<<\n");
        outContent.reset();
    }
}
