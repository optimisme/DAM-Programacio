package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;

public class TestMain {

    @Test
    public void testCalculateFactorial() throws Exception {
        Locale defaultLocale = Locale.getDefault();
        Locale.setDefault(Locale.US);

        try {
            // Test del factorial de 5
            long result5 = Main.calculateFactorial(5);
            long expected5 = 120;
            assertEquals(expected5, result5);

            // Test del factorial de 10
            long result10 = Main.calculateFactorial(10);
            long expected10 = 3628800;
            assertEquals(expected10, result10);

            // Test per entrada d'usuari negativa
            StringBuilder inputNegative = new StringBuilder();
            inputNegative.append("-5\n");

            String expectedOutputNegative = "Introdueix un número per calcular el seu factorial: El número ha de ser positiu.\n";

            String actualOutputNegative = tapSystemOut(() -> {
                System.setIn(new ByteArrayInputStream(inputNegative.toString().getBytes()));
                Main.main(new String[]{});
            });

            actualOutputNegative = actualOutputNegative.replace("\r\n", "\n");

            assertEquals(expectedOutputNegative, actualOutputNegative);

            // Test per entrada d'usuari 5
            StringBuilder input5 = new StringBuilder();
            input5.append("5\n");

            String expectedOutput5 = "Introdueix un número per calcular el seu factorial: El factorial de 5 és 120\n";

            String actualOutput5 = tapSystemOut(() -> {
                System.setIn(new ByteArrayInputStream(input5.toString().getBytes()));
                Main.main(new String[]{});
            });

            actualOutput5 = actualOutput5.replace("\r\n", "\n");

            assertEquals(expectedOutput5, actualOutput5, 
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                TestStringUtils.findFirstDifference(expectedOutput5, actualOutput5) +
                "<<<<<<<<<< <<<<<<<<<<\n");

        } finally {
            Locale.setDefault(defaultLocale);
        }
    }

    private interface ThrowingRunnable {
        void run() throws Exception;
    }

    private String tapSystemOut(ThrowingRunnable runnable) throws Exception {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        try {
            runnable.run();
        } finally {
            System.setOut(originalOut);
        }
        return outContent.toString();
    }
}
