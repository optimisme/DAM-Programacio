package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.util.Locale;

public class TestMain {

    @Test
    public void testValidaContrasenyaOutput() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String expectedOutput = "La contrasenya 'PassWord123': La contrasenya és vàlida\n" +
                                    "La contrasenya 'password': La contrasenya NO és vàlida\n" +
                                    "La contrasenya 'PASSWORD': La contrasenya NO és vàlida\n" +
                                    "La contrasenya 'Pass12': La contrasenya NO és vàlida\n" +
                                    "La contrasenya 'PassWord': La contrasenya és vàlida\n" +
                                    "La contrasenya 'ValidPass123': La contrasenya és vàlida\n" +
                                    "La contrasenya 'AnotherValid1': La contrasenya és vàlida\n";

            String actualOutput = SystemLambda.tapSystemOut(() -> {
                Main.main(new String[]{});
            });

            actualOutput = actualOutput.replace("\r\n", "\n"); // Normalitza les noves línies
            String diff = TestStringUtils.findFirstDifference(actualOutput, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0,
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                diff +
                "<<<<<<<<<< <<<<<<<<<<\n");
        } finally {
            Locale.setDefault(defaultLocale); // Restaura la configuració regional per defecte
        }
    }
}
