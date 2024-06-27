package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Locale;

public class TestMain {

    @Test
    public void testCountAs() {
        Locale defaultLocale = Locale.getDefault();
        Locale.setDefault(Locale.US);

        try {
            // Test amb el text "Hola, com estàs?"
            String result1 = "El text té " + Main.countAs("Hola, com estàs?") + " 'a'.";
            result1 = result1.replace("\r\n", "\n");

            String expected1 = "El text té 2 'a'.";

            assertTrue(TestStringUtils.findFirstDifference(result1, expected1).compareTo("identical") == 0, 
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                TestStringUtils.findFirstDifference(result1, expected1) +
                "<<<<<<<<<< <<<<<<<<<<\n");

        } finally {
            Locale.setDefault(defaultLocale);
        }
    }
}
