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
    public void testCorrectPassword() {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String input = "1234";
            System.setIn(new ByteArrayInputStream(input.getBytes()));

            // Executa el main per a provar la seva sortida
            Main.main(new String[]{});
            String text = outContent.toString().replace("\r\n", "\n").trim();

            // Comprova que la sortida conté el text esperat
            String expectedOutput = "Introdueix la contrasenya: Accés permès";
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
    public void testIncorrectPassword() {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String input = "1111\n2222\n3333";
            System.setIn(new ByteArrayInputStream(input.getBytes()));

            // Executa el main per a provar la seva sortida
            Main.main(new String[]{});
            String text = outContent.toString().replace("\r\n", "\n").trim();

            // Comprova que la sortida conté el text esperat
            String expectedOutput = "Introdueix la contrasenya: Contrasenya incorrecta\n" +
                                    "Introdueix la contrasenya: Contrasenya incorrecta\n" +
                                    "Introdueix la contrasenya: Contrasenya incorrecta\n" +
                                    "Accés denegat. Has exhaurit els intents.";
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
    public void testMultipleAttemptsWithSuccess() {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String input = "1111\n2222\n1234";
            System.setIn(new ByteArrayInputStream(input.getBytes()));

            // Executa el main per a provar la seva sortida
            Main.main(new String[]{});
            String text = outContent.toString().replace("\r\n", "\n").trim();

            // Comprova que la sortida conté el text esperat
            String expectedOutput = "Introdueix la contrasenya: Contrasenya incorrecta\n" +
                                    "Introdueix la contrasenya: Contrasenya incorrecta\n" +
                                    "Introdueix la contrasenya: Accés permès";
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
