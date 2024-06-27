package com.project;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
    public void testCalculaNums() {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            // Executa el main per a provar la seva sortida
            Main.main(new String[]{});
            String text = outContent.toString().replace("\r\n", "\n").trim();

            // Atès que el número es genera aleatòriament, no podem preveure el resultat exacte
            // per tant, només comprovarem que la sortida segueix el format esperat.
            String[] lines = text.split("\n");
            assertEquals(3, lines.length, "La sortida ha de tenir tres línies.");
            assertTrue(lines[0].matches("El número: \\d+"), "La primera línia ha de contenir el número generat.");
            assertTrue(lines[1].matches("El nombre de números parells: \\d+"), "La segona línia ha de contenir el nombre de números parells.");
            assertTrue(lines[2].matches("El nombre de números senars: \\d+"), "La tercera línia ha de contenir el nombre de números senars.");
        } finally {
            Locale.setDefault(defaultLocale); // Restaura la configuració regional per defecte
        }
    }

    @Test
    public void testCalculaNumsWithSpecificNumber() {
        long numero = 2468135790L;
        int[] resultat = Main.calculaNums(numero);

        assertEquals(5, resultat[0]);
        assertEquals(5, resultat[1]);
    }

    @Test
    public void testCalculaNumsWithAllEven() {
        long numero = 2468246824L;
        int[] resultat = Main.calculaNums(numero);

        assertEquals(10, resultat[0]);
        assertEquals(0, resultat[1]);
    }

    @Test
    public void testCalculaNumsWithAllOdd() {
        long numero = 1357913579L;
        int[] resultat = Main.calculaNums(numero);

        assertEquals(0, resultat[0]);
        assertEquals(10, resultat[1]);
    }
}
