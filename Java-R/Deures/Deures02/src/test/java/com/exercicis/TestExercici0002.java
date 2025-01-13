package com.exercicis;

import com.testStringUtils.TestStringUtils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.util.Locale;

class TestExercici0002 {

    @Test
    public void testEuroToDollarConversion() throws Exception {
        Locale defaultLocale = Locale.getDefault();
        try {
            Locale.setDefault(Locale.US);

            String text = SystemLambda.tapSystemOut(() -> 
                SystemLambda.withTextFromSystemIn("80.3\n1.05\n").execute(() -> {
                    String[] args = {};
                    Exercici0002.main(args);
                })
            );

            text = text.replace("\r\n", "\n");

            String expectedOutput = """
                Escriu el valor en Euros: Escriu la tasa de conversió (ex: 1.25): El valor de 80.30€ són 84.32$
                """.replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);

            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");
        } finally {
            Locale.setDefault(defaultLocale);
        }
    }

    @Test
    public void testAnotherConversion() throws Exception {
        Locale defaultLocale = Locale.getDefault();
        try {
            Locale.setDefault(Locale.US);

            String text = SystemLambda.tapSystemOut(() -> 
                SystemLambda.withTextFromSystemIn("100.5\n1.2\n").execute(() -> {
                    String[] args = {};
                    Exercici0002.main(args);
                })
            );

            text = text.replace("\r\n", "\n");

            String expectedOutput = """
                Escriu el valor en Euros: Escriu la tasa de conversió (ex: 1.25): El valor de 100.50€ són 120.60$
                """.replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);

            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");
        } finally {
            Locale.setDefault(defaultLocale);
        }
    }
}
