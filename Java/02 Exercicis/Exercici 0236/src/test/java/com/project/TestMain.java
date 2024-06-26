package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.util.Locale;
import java.io.ByteArrayInputStream;
import java.util.Random;

public class TestMain {

    @Test
    public void testEndevinaNumero() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            // Fixem el número secret per a la prova
            int numeroSecret = 5;
            String input = "0\n9\n1\n8\n2\n7\n3\n6\n5\n4\n";

            String actualOutput = SystemLambda.tapSystemOut(() -> {
                System.setIn(new ByteArrayInputStream(input.getBytes())); // Simula l'entrada de l'usuari
                Main.main(new String[]{});
            });

            actualOutput = actualOutput.replace("\r\n", "\n"); // Normalitza les noves línies
            assertTrue(actualOutput.toString().contains("Felicitats, has encertat amb"),
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                "El programa hauria de contenir el missatge d'encert amb el nombre d'intents correctes." +
                "<<<<<<<<<< <<<<<<<<<<\n");
        } finally {
            Locale.setDefault(defaultLocale); // Restaura la configuració regional per defecte
        }
    }
}