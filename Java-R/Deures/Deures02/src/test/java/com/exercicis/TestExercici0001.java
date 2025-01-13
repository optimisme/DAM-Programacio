package com.exercicis;

import com.testStringUtils.TestStringUtils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.util.Locale;

class TestExercici0001 {
    @Test
    public void testIMC() throws Exception {
        Locale defaultLocale = Locale.getDefault();
        try {
            Locale.setDefault(Locale.US);

            String text = SystemLambda.tapSystemOut(() -> 
                SystemLambda.withTextFromSystemIn("80\n180\n").execute(() -> {
                    String[] args = {};
                    Exercici0001.main(args);
                })
            );

            text = text.replace("\r\n", "\n");

            String expectedOutput = """
                Escriu el pes (kg): Escriu l'alçada (cm): imc = 24.69
                """.replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");
        } finally {
            Locale.setDefault(defaultLocale);
        }
    }

    @Test
    public void testIMCWithAnotherInput() throws Exception {
        Locale defaultLocale = Locale.getDefault();
        try {
            Locale.setDefault(Locale.US);

            String text = SystemLambda.tapSystemOut(() -> 
                SystemLambda.withTextFromSystemIn("65\n165\n").execute(() -> {
                    String[] args = {};
                    Exercici0001.main(args);
                })
            );

            text = text.replace("\r\n", "\n");

            String expectedOutput = """
                Escriu el pes (kg): Escriu l'alçada (cm): imc = 23.88
                """.replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");
        } finally {
            Locale.setDefault(defaultLocale);
        }
    }
}
