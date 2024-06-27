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
    public void testCalculaComissio() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String input = "500\n2000\n7000\nfi";
            System.setIn(new ByteArrayInputStream(input.getBytes()));

            // Executa el main per a provar la seva sortida
            Main.main(new String[]{});
            String text = outContent.toString().replace("\r\n", "\n").trim();

            // Comprova que la sortida conté el text esperat
            String expectedOutput = "Introdueix el valor de les vendes (escriu 'fi' per acabar):\n" +
                                    "S'han entrat 3 vendes, amb un total de 10365.00 € i una mitjana de 3166.67 €.\n" +
                                    "S'ha aconseguit una comissió de 865.00 €.";
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
    public void testCalculaComissioWithInvalidInput() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String input = "500\ninvalid\n3000\nfi";
            System.setIn(new ByteArrayInputStream(input.getBytes()));

            // Executa el main per a provar la seva sortida
            Main.main(new String[]{});
            String text = outContent.toString().replace("\r\n", "\n").trim();

            // Comprova que la sortida conté el text esperat
            String expectedOutput = "Introdueix el valor de les vendes (escriu 'fi' per acabar):\n" +
                                    "Valor no vàlid, torna a intentar-ho.\n" +
                                    "S'han entrat 2 vendes, amb un total de 3735.00 € i una mitjana de 1750.00 €.\n" +
                                    "S'ha aconseguit una comissió de 235.00 €.";
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
