package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;

public class TestMain {

    @Test
    public void testGenerateCenteredTriangle() throws Exception {
        Locale defaultLocale = Locale.getDefault();
        Locale.setDefault(Locale.US);

        try {
            
            // Test del triangle d'asteriscs per 7
            String triangleResult7 = Main.generateCenteredTriangle(7);
            triangleResult7 = triangleResult7.replace("\r\n", "\n");
            String expectedTriangle7 = "    *\n" +
                                       "    **\n" +
                                       "   ***\n" +
                                       "   ****\n" +
                                       "  *****\n" +
                                       "  ******\n" +
                                       " *******\n";

            assertEquals(expectedTriangle7, triangleResult7, 
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                TestStringUtils.findFirstDifference(triangleResult7, expectedTriangle7) +
                "<<<<<<<<<< <<<<<<<<<<\n");

            // Test per número fora de rang
            StringBuilder input = new StringBuilder();
            input.append("11\n");

            String expectedOutput = "Introdueix un número entre 1 i 10 per generar un triangle d'asteriscs: El número ha d'estar entre 1 i 10.\n";

            String actualOutput = tapSystemOut(() -> {
                System.setIn(new ByteArrayInputStream(input.toString().getBytes()));
                Main.main(new String[]{});
            });

            actualOutput = actualOutput.replace("\r\n", "\n");

            assertEquals(expectedOutput, actualOutput, 
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                TestStringUtils.findFirstDifference(actualOutput, expectedOutput) +
                "<<<<<<<<<< <<<<<<<<<<\n");

            // Test de generateCenteredText
            String centeredText = Main.generateCenteredText("Test", 10);
            String expectedCenteredText = "   Test";

            assertEquals(expectedCenteredText, centeredText, 
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                TestStringUtils.findFirstDifference(centeredText, expectedCenteredText) +
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
