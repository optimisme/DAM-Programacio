package com.project;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMain {

    @Test
    public void testMainOutput() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            // Captura la sortida del System.out
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(outputStream));

            // Executa el main
            Main.main(new String[0]);

            // Restaura la sortida original
            System.setOut(originalOut);

            // Obté la sortida del main
            String resultat = outputStream.toString().replace("\r\n", "\n");

            // Defineix la sortida esperada
            String expectedOutput = """
                    -----------------------------------------------------
                    | id  | ciutat     |   poblacio |  altitud | coster |
                    -----------------------------------------------------
                    | 0   | Barcelona  |    1620343 |       12 |   true |
                    | 1   | Madrid     |    3207247 |      667 |  false |
                    | 2   | València   |     791413 |       15 |   true |
                    | 3   | Màlaga     |     569130 |       11 |   true |
                    | 4   | Sevilla    |     688711 |        7 |  false |
                    | 5   | Alicante   |     330525 |       12 |   true |
                    | 6   | Zaragoza   |     664938 |      220 |  false |
                    | 7   | Gijón      |     275735 |        3 |   true |
                    | 8   | Palma de M |      22610 |       14 |   true |
                    | 9   | Bilbao     |     345821 |       30 |  false |
                    -----------------------------------------------------
                    """.replaceAll("                    ", "");

            // Compara la sortida obtinguda amb la sortida esperada
            String diff = TestStringUtils.findFirstDifference(resultat, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0,
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                diff +
                "<<<<<<<<<< <<<<<<<<<<\n");
        } finally {
            // Restaura la configuració regional per defecte
            Locale.setDefault(defaultLocale);
        }
    }
}
