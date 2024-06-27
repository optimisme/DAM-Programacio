package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Locale;

public class TestMain {

    @Test
    public void testCalculateSumInRange() {
        Locale defaultLocale = Locale.getDefault();
        Locale.setDefault(Locale.US);

        try {
            String result1 = Main.calculateSumInRange(2, 5);
            String result2 = Main.calculateSumInRange(10, 15);
            String result3 = Main.calculateSumInRange(15, 10);
            String result4 = Main.calculateSumInRange(-5, 5);

            result1 = result1.replace("\r\n", "\n");
            result2 = result2.replace("\r\n", "\n");
            result3 = result3.replace("\r\n", "\n");
            result4 = result4.replace("\r\n", "\n");

            assertTrue(result1.contains("La suma entre 2 i 5 és 14"), "Test 1: " + result1);
            assertTrue(result2.contains("La suma entre 10 i 15 és 75"), "Test 2: " + result2);
            assertTrue(result3.contains("La suma entre 10 i 15 és 75"), "Test 3: " + result3);
            assertTrue(result4.contains("La suma entre -5 i 5 és 0"), "Test 4: " + result4);

        } finally {
            Locale.setDefault(defaultLocale);
        }
    }
}
