package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Locale;
import java.util.Random;

public class TestMain {

    @Test
    public void testGenerateMultiplicationTable() {
        Locale defaultLocale = Locale.getDefault();
        Locale.setDefault(Locale.US);

        try {
            Random random = new Random();
            
            for (int i = 0; i < 3; i++) {
                int num = random.nextInt(10) + 1; // Genera un número aleatori entre 1 i 10

                String result = Main.generateMultiplicationTable(num);
                result = result.replace("\r\n", "\n");

                StringBuilder expected = new StringBuilder();
                for (int j = 0; j <= 10; j++) {
                    expected.append(j).append(" x ").append(num).append(" = ").append(j * num).append("\n");
                }
                String expectedString = expected.toString().trim();

                assertTrue(TestStringUtils.findFirstDifference(result, expectedString).compareTo("identical") == 0, 
                    "\n>>>>>>>>>> >>>>>>>>>>\n" +
                    TestStringUtils.findFirstDifference(result, expectedString) +
                    "<<<<<<<<<< <<<<<<<<<<\n");
            }

        } finally {
            Locale.setDefault(defaultLocale);
        }
    }
}
