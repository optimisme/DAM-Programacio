package com.exercicis;

import com.testStringUtils.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.util.Locale;

class TestExercici0000 {

    @Test
    public void testMainFunctionWith22And15() throws Exception {
        Locale defaultLocale = Locale.getDefault(); 
        try {
            Locale.setDefault(Locale.US);
    
            String text = SystemLambda.tapSystemOut(() -> 
                SystemLambda.withTextFromSystemIn("22\n15\n").execute(() -> {
                    String[] args = {}; 
                    Exercici0000.main(args);
                })
            );
    
            text = text.replace("\r\n", "\n");
    
            String expectedOutput = """
                Escriu el primer número: Escriu el segon número: El resultat de calcular 22 - 15 és 7
                """.replace("\r\n", "\n").replace("        ", "");
    
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");
        } finally {
            Locale.setDefault(defaultLocale); 
        }
    }
    
    @Test
    public void testMainFunctionWithMinus12AndMinus5() throws Exception {
        Locale defaultLocale = Locale.getDefault(); 
        try {
            Locale.setDefault(Locale.US);
    
            String text = SystemLambda.tapSystemOut(() -> 
                SystemLambda.withTextFromSystemIn("-12\n-5\n").execute(() -> {
                    String[] args = {}; 
                    Exercici0000.main(args);
                })
            );
    
            text = text.replace("\r\n", "\n");
    
            String expectedOutput = """
                Escriu el primer número: Escriu el segon número: El resultat de calcular -12 - -5 és -7
                """.replace("\r\n", "\n").replace("        ", "");
    
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");
        } finally {
            Locale.setDefault(defaultLocale); 
        }
    }
    
    @Test
    public void testMainFunctionWith10AndMinus8() throws Exception {
        Locale defaultLocale = Locale.getDefault(); 
        try {
            Locale.setDefault(Locale.US);
    
            String text = SystemLambda.tapSystemOut(() -> 
                SystemLambda.withTextFromSystemIn("10\n-8\n").execute(() -> {
                    String[] args = {}; 
                    Exercici0000.main(args);
                })
            );
    
            text = text.replace("\r\n", "\n");
    
            String expectedOutput = """
                Escriu el primer número: Escriu el segon número: El resultat de calcular 10 - -8 és 18
                """.replace("\r\n", "\n").replace("        ", "");
    
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");
        } finally {
            Locale.setDefault(defaultLocale); 
        }
    }
}
