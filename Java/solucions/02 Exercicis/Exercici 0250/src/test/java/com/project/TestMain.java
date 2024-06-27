package com.project;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void testMainOutput() {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String input = "test@domain.com";
            System.setIn(new ByteArrayInputStream(input.getBytes()));

            // Executa el main per a provar la seva sortida
            Main.main(new String[]{});
            String text = outContent.toString().replace("\r\n", "\n").trim();

            // Comprova que la sortida conté el text esperat
            String expectedOutput = "Introdueix una direcció de correu electrònic: Correu electrònic vàlid: test@domain.com";
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertEquals("identical", diff, 
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                diff +
                "<<<<<<<<<< <<<<<<<<<<\n");
        } finally {
            Locale.setDefault(defaultLocale); // Restaura la configuració regional per defecte
        }
    }

    @Test
    public void testInvalidEmail() {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String input = "invalid-email\nvalid@example.com";
            System.setIn(new ByteArrayInputStream(input.getBytes()));

            // Executa el main per a provar la seva sortida
            Main.main(new String[]{});
            String text = outContent.toString().replace("\r\n", "\n").trim();

            // Comprova que la sortida conté el text esperat
            String expectedOutput = "Introdueix una direcció de correu electrònic: Correu electrònic no vàlid. Torna a intentar-ho.\n" +
                                    "Introdueix una direcció de correu electrònic: Correu electrònic vàlid: valid@example.com";
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertEquals("identical", diff, 
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                diff +
                "<<<<<<<<<< <<<<<<<<<<\n");
        } finally {
            Locale.setDefault(defaultLocale); // Restaura la configuració regional per defecte
        }
    }
}
