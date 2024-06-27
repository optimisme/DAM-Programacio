package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Locale;

public class TestMain {

    @Test
    public void testEsImparell() {
        Locale defaultLocale = Locale.getDefault();
        Locale.setDefault(Locale.US);

        try {
            // Test de números imparells
            assertTrue(Main.esImparell(1));
            assertTrue(Main.esImparell(3));
            assertTrue(Main.esImparell(5));
            assertTrue(Main.esImparell(7));
            assertTrue(Main.esImparell(9));

            // Test de números parells
            assertFalse(Main.esImparell(0));
            assertFalse(Main.esImparell(2));
            assertFalse(Main.esImparell(4));
            assertFalse(Main.esImparell(6));
            assertFalse(Main.esImparell(8));

            // Test del rang de números imparells entre 2 i 5
            String result1 = Main.getOddNumbersInRange(2, 5);
            result1 = result1.replace("\r\n", "\n");
            String expected1 = "3 5";

            assertTrue(TestStringUtils.findFirstDifference(result1, expected1).compareTo("identical") == 0, 
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                TestStringUtils.findFirstDifference(result1, expected1) +
                "<<<<<<<<<< <<<<<<<<<<\n");

            // Test del rang de números imparells entre 10 i 15
            String result2 = Main.getOddNumbersInRange(14, 18);
            result2 = result2.replace("\r\n", "\n");
            String expected2 = "15 17";

            assertTrue(TestStringUtils.findFirstDifference(result2, expected2).compareTo("identical") == 0, 
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                TestStringUtils.findFirstDifference(result2, expected2) +
                "<<<<<<<<<< <<<<<<<<<<\n");

            // Test del rang de números imparells entre 15 i 10 (ordre invers)
            String result3 = Main.getOddNumbersInRange(29, 25);
            result3 = result3.replace("\r\n", "\n");
            String expected3 = "25 27 29";

            assertTrue(TestStringUtils.findFirstDifference(result3, expected3).compareTo("identical") == 0, 
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                TestStringUtils.findFirstDifference(result3, expected3) +
                "<<<<<<<<<< <<<<<<<<<<\n");

        } finally {
            Locale.setDefault(defaultLocale);
        }
    }
}
