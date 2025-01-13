package com.exercicis;

import com.testStringUtils.TestStringUtils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.util.Locale;

class TestExercici0003 {

    @Test
    public void testCalcularPreuFinal() {
        double resultat = Exercici0003.calcularPreuFinal(100, 21, 15);
        double esperat = 102.85;

        String diff = TestStringUtils.findFirstDifference(
            String.format(Locale.US, "%.2f", resultat),
            String.format(Locale.US, "%.2f", esperat)
        );

        assertTrue(diff.compareTo("identical") == 0,
            ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<");
    }

    @Test
    public void testMainFunction() throws Exception {
        Locale defaultLocale = Locale.getDefault();
        try {
            Locale.setDefault(Locale.US);

            String text = SystemLambda.tapSystemOut(() -> 
                SystemLambda.withTextFromSystemIn("100\n21\n15\n").execute(() -> {
                    String[] args = {};
                    Exercici0003.main(args);
                })
            );

            text = text.replace("\r\n", "\n");

            String expectedOutput = """
                Introdueix el preu base: Introdueix l'IVA (%): Introdueix el descompte (%): El preu final és: 102.85
                """.replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);

            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<");
        } finally {
            Locale.setDefault(defaultLocale); // Restaura el locale original.
        }
    }
}
