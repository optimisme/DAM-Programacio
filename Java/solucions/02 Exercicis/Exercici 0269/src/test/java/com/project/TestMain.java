// TestMain.java
package com.project;

import java.util.Arrays;
import java.util.Locale;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMain {

    @Test
    public void testMesLlarg() {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            double[][] arrayExtrany = {
                {153.74, 149.08, 129.79, 171.06, 116.25, 131.41, 194.33},
                {181.87, 167.69, 149.67, 108.23, 103.14, 160.41, 182.72, 139.0},
                {171.8, 185.45, 134.96, 188.69, 130.93, 171.57, 113.02, 117.68, 163.42, 115.94},
                {169.12, 142.05, 159.83, 111.91, 113.3, 124.93},
                {167.24, 172.77, 172.17, 173.33, 155.55},
                {122.62, 159.59, 137.42, 163.53},
                {198.59, 110.02, 140.0, 173.99, 177.57, 198.21, 112.09, 182.33, 185.05},
                {197.01, 176.23, 119.21, 129.65, 184.99, 194.32, 186.76, 131.82},
                {196.99, 130.01, 137.59, 145.12, 131.61, 138.01, 117.73, 148.02, 112.45},
                {172.67, 189.0, 150.42, 106.44, 152.11, 122.04, 163.53, 157.69, 178.01, 124.56}
            };

            Object[] result = Main.mesLlarg(arrayExtrany);

            int expectedLength = 10;
            double[] expectedLongestElement = {171.8, 185.45, 134.96, 188.69, 130.93, 171.57, 113.02, 117.68, 163.42, 115.94};

            assertEquals(expectedLength, result[0]);
            assertArrayEquals(expectedLongestElement, (double[]) result[1]);
        } finally {
            Locale.setDefault(defaultLocale); // Restaura la configuració regional per defecte
        }
    }

    @Test
    public void testOutput() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String text = tapSystemOut(() -> {
                Main.main(new String[]{});
            });
            text = text.replace("\r\n", "\n");

            String expectedOutput = "La longitud de l'element més llarg: 10\n" +
                                    "L'element més llarg: [171.8, 185.45, 134.96, 188.69, 130.93, 171.57, 113.02, 117.68, 163.42, 115.94]\n";
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0,
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                diff +
                "<<<<<<<<<< <<<<<<<<<<\n");
        } finally {
            Locale.setDefault(defaultLocale); // Restaura la configuració regional per defecte
        }
    }

    private static String tapSystemOut(Runnable runnable) throws Exception {
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        java.io.PrintStream originalOut = System.out;
        System.setOut(new java.io.PrintStream(out));
        try {
            runnable.run();
        } finally {
            System.setOut(originalOut);
        }
        return out.toString();
    }
}
