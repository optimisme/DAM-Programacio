// TestMain.java
package com.project;

import java.util.Locale;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.github.stefanbirkner.systemlambda.SystemLambda;

public class TestMain {

    @Test
    public void testCalculaNums() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                // Executa el main per a provar la seva sortida
                Main.main(new String[]{});
            });
            text = text.replace("\r\n", "\n");

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
