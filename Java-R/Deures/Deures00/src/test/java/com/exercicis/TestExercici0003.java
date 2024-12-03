package com.exercicis;

import com.testStringUtils.TestStringUtils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.util.Locale;

class TestExercici0003 {

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
                ">>>>>>>>>> >>>>>>>>>>\n" +
                diff +
                "<<<<<<<<<< <<<<<<<<<<\n");
        } finally {
            Locale.setDefault(defaultLocale); 
        }
    }
      
    @Test
    public void testCalcularPreuFinal() throws Exception {
        Locale defaultLocale = Locale.getDefault();
        try {
            Locale.setDefault(Locale.US); 

            // Exemple de dades d'entrada
            double preuBase = 100.0;
            double descompte = 15.0;
            double impostos = 21.0;

            double resultatObtingut = Exercici0003.calcularPreuFinal(preuBase, descompte, impostos);
            double resultatEsperat = 90.85;

            String resultatObtingutText = String.format(Locale.US, "%.2f", resultatObtingut);
            String resultatEsperatText = String.format(Locale.US, "%.2f", resultatEsperat);

            String diff = TestStringUtils.findFirstDifference(resultatObtingutText, resultatEsperatText);
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> >>>>>>>>>>\n" +
                diff +
                "<<<<<<<<<< <<<<<<<<<<\n");
        } finally {
            Locale.setDefault(defaultLocale); // Restaura el locale original
        }
    }
}
