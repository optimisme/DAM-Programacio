package com.exercicis;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import static org.junit.jupiter.api.Assertions.*;
import com.github.stefanbirkner.systemlambda.SystemLambda;
import com.testStringUtils.TestStringUtils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

class TestExercici0201 {

    private Locale defaultLocale;

    @BeforeEach
    public void setUp() {
        defaultLocale = Locale.getDefault();
        Locale.setDefault(Locale.US);
    }

    @AfterEach
    public void tearDown() {
        Locale.setDefault(defaultLocale);
    }

    @Test
    void testGeneraArrayEnters(TestInfo testInfo) {
        try {
            int[] arr = Exercici0201.generaArrayEnters(10);
            assertEquals(10, arr.length);
            for (int n : arr) {
                assertTrue(n >= 0 && n < 100);
            }
            System.out.println("Test passed, succeeded!");
        } catch (AssertionError e) {
            System.out.println("Test failed: " + testInfo.getDisplayName());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
        }
    }

    @Test
    void testMostraArrayEstadistiques(TestInfo testInfo) throws Exception {
        try {
            int[] arr = {1, 2, 3, 4, 5};
            String output = SystemLambda.tapSystemOut(() -> Exercici0201.mostraArrayEstadistiques(arr)).trim().replace("\r\n", "\n");
            
            String expected = """
                Array: [1, 2, 3, 4, 5]
                Màxim: 5  Mínim: 1  Mitjana: 3.0
                """.trim().replace("\r\n", "\n");
    
            String diff = TestStringUtils.findFirstDifference(output, expected);
            assertTrue(diff.compareTo("identical") == 0, 
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");
    
            System.out.println("Test passed, succeeded!");
        } catch (AssertionError e) {
            System.out.println("Test failed: " + testInfo.getDisplayName());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
        }
    }
   
    @Test
    void testGeneraLlistaEnters(TestInfo testInfo) {
        try {
            ArrayList<Integer> list = Exercici0201.generaLlistaEnters(10);
            assertEquals(10, list.size());
            for (int n : list) {
                assertTrue(n >= 0 && n < 100);
            }
            System.out.println("Test passed, succeeded!");
        } catch (AssertionError e) {
            System.out.println("Test failed: " + testInfo.getDisplayName());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
        }
    }

    @Test
    void testMostraLlistaEstadistiques(TestInfo testInfo) throws Exception {
        try {
            ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30));
            String output = SystemLambda.tapSystemOut(() -> Exercici0201.mostraLlistaEstadistiques(list)).trim().replace("\r\n", "\n");
    
            String expected = """
                Llista: [10, 20, 30]
                Màxim: 30  Mínim: 10  Mitjana: 20.0
                """.trim().replace("\r\n", "\n");
    
            String diff = TestStringUtils.findFirstDifference(output, expected);
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");
    
            System.out.println("Test passed, succeeded!");
        } catch (AssertionError e) {
            System.out.println("Test failed: " + testInfo.getDisplayName());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
        }
    }
   
    @Test
    void testFiltraArrayParaulesAmbA(TestInfo testInfo) throws Exception {
        try {
            // Simula l'entrada de l'usuari
            String simulatedInput = "apple, banana, apricot, mango, avocado\n";
            InputStream originalSystemIn = System.in;
            ByteArrayInputStream testInput = new ByteArrayInputStream(simulatedInput.getBytes());
            System.setIn(testInput);
    
            // Reinicialitza el Scanner per llegir des del nou System.in
            Exercici0201.scanner = new Scanner(System.in);
    
            // Captura la sortida
            String output = SystemLambda.tapSystemOut(() -> Exercici0201.filtraArrayParaulesAmbA()).trim().replace("\r\n", "\n");
    
            // Restaura l'entrada original
            System.setIn(originalSystemIn);
    
            // Valida el resultat esperat
            String expected = """
                Escriu 5 paraules separades per ',' o ', ':
                Paraules que comencen amb 'a': apple, apricot, avocado
                """.trim().replace("\r\n", "\n");
    
            // Compara la sortida amb TestStringUtils.findFirstDifference()
            String diff = TestStringUtils.findFirstDifference(output, expected);
            assertTrue(diff.compareTo("identical") == 0, 
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");
    
            System.out.println("Test passed, succeeded!");
        } catch (AssertionError e) {
            System.out.println("Test failed: " + testInfo.getDisplayName());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
        }
    }
        
    @Test
    void testFiltraLlistaParaulesAmbA(TestInfo testInfo) throws Exception {
        try {
            // Simula l'entrada de l'usuari
            String simulatedInput = "apple, banana, apricot, mango, avocado\n";
            InputStream originalSystemIn = System.in;
            ByteArrayInputStream testInput = new ByteArrayInputStream(simulatedInput.getBytes());
            System.setIn(testInput);
    
            // Reinicialitza el Scanner per llegir des del nou System.in
            Exercici0201.scanner = new Scanner(System.in);
    
            // Captura la sortida
            String output = SystemLambda.tapSystemOut(() -> Exercici0201.filtraLlistaParaulesAmbA()).trim().replace("\r\n", "\n");
    
            // Restaura l'entrada original
            System.setIn(originalSystemIn);
    
            // Valida el resultat esperat
            String expected = """
                Escriu 5 paraules separades per ',' o ', ':
                Paraules que comencen amb 'a': apple, apricot, avocado
                """.trim().replace("\r\n", "\n");
    
            // Compara la sortida amb TestStringUtils.findFirstDifference()
            String diff = TestStringUtils.findFirstDifference(output, expected);
            assertTrue(diff.compareTo("identical") == 0, 
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");
    
            System.out.println("Test passed, succeeded!");
        } catch (AssertionError e) {
            System.out.println("Test failed: " + testInfo.getDisplayName());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
        }
    }
        
    @Test
    void testGeneraArrayDecimals(TestInfo testInfo) {
        try {
            double[] arr = Exercici0201.generaArrayDecimals(15);
            assertEquals(15, arr.length);
            for (double d : arr) {
                assertTrue(d >= 0 && d <= 100);
            }
            System.out.println("Test passed, succeeded!");
        } catch (AssertionError e) {
            System.out.println("Test failed: " + testInfo.getDisplayName());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
        }
    }

    @Test
    void testFiltraArrayDecimalsSuperiors50(TestInfo testInfo) throws Exception {
        try {
            double[] decimals = {10.0, 60.0, 50.0, 75.5};
            String output = SystemLambda.tapSystemOut(() -> Exercici0201.filtraArrayDecimalsSuperiors50(decimals)).trim().replace("\r\n", "\n");
    
            String expected = """
                Array original: [10.00, 60.00, 50.00, 75.50]
                Valors majors que 50: [60.00, 75.50]
                """.trim().replace("\r\n", "\n");
    
            // Comparació amb TestStringUtils.findFirstDifference()
            String diff = TestStringUtils.findFirstDifference(output, expected);
            assertTrue(diff.compareTo("identical") == 0, 
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");
    
            System.out.println("Test passed, succeeded!");
        } catch (AssertionError e) {
            System.out.println("Test failed: " + testInfo.getDisplayName());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
        }
    }   

    @Test
    void testGeneraLlistaDecimals(TestInfo testInfo) {
        try {
            ArrayList<Double> list = Exercici0201.generaLlistaDecimals(15);
            assertEquals(15, list.size());
            for (double d : list) {
                assertTrue(d >= 0 && d <= 100);
            }
            System.out.println("Test passed, succeeded!");
        } catch (AssertionError e) {
            System.out.println("Test failed: " + testInfo.getDisplayName());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
        }
    }

    @Test
    void testFiltraLlistaDecimalsSuperiors50(TestInfo testInfo) throws Exception {
        try {
            ArrayList<Double> list = new ArrayList<>(Arrays.asList(10.0, 60.0, 50.0, 75.5));
            String output = SystemLambda.tapSystemOut(() -> Exercici0201.filtraLlistaDecimalsSuperiors50(list)).trim().replace("\r\n", "\n");
    
            String expected = """
                Llista original: [10.00, 60.00, 50.00, 75.50]
                Valors majors que 50: [60.00, 75.50]
                """.trim().replace("\r\n", "\n");
    
            // Comparació amb TestStringUtils.findFirstDifference()
            String diff = TestStringUtils.findFirstDifference(output, expected);
            assertTrue(diff.compareTo("identical") == 0, 
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");
    
            System.out.println("Test passed, succeeded!");
        } catch (AssertionError e) {
            System.out.println("Test failed: " + testInfo.getDisplayName());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
        }
    }
    
    @Test
    void testMostrarLlistaOrdenadesPerEdat(TestInfo testInfo) throws Exception {
        try {
            HashMap<String, Integer> persones = new HashMap<>();
            persones.put("Anna", 25);
            persones.put("Joan", 30);
            persones.put("Marc", 20);
    
            String output = SystemLambda.tapSystemOut(() -> Exercici0201.mostrarLlistaOrdenadesPerEdat(persones)).trim().replace("\r\n", "\n");
    
            String expected = """
                Marc (20)
                Anna (25)
                Joan (30)
                """.trim().replace("\r\n", "\n");
    
            // Comparació amb TestStringUtils.findFirstDifference()
            String diff = TestStringUtils.findFirstDifference(output, expected);
            assertTrue(diff.compareTo("identical") == 0, 
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");
    
            System.out.println("Test passed, succeeded!");
        } catch (AssertionError e) {
            System.out.println("Test failed: " + testInfo.getDisplayName());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
        }
    }
    
    @Test
    void testMostrarFrecuenciaParaules(TestInfo testInfo) throws Exception {
        try {
            // Simula l'entrada de l'usuari
            String simulatedInput = "hello world hello\n"; // Afegim '\n' per simular Enter
            InputStream originalSystemIn = System.in;
            ByteArrayInputStream testInput = new ByteArrayInputStream(simulatedInput.getBytes());
            System.setIn(testInput);
    
            // Reinicialitza el Scanner per llegir des del nou System.in
            Exercici0201.scanner = new Scanner(System.in);
    
            // Captura la sortida
            String output = SystemLambda.tapSystemOut(() -> Exercici0201.mostrarFrecuenciaParaules()).trim().replace("\r\n", "\n");
    
            // Restaura l'entrada original
            System.setIn(originalSystemIn);
    
            // Valida el resultat esperat
            String expected = """
                Introdueix una frase:
                Freqüència de paraules:
                hello=2
                world=1
                """.trim().replace("\r\n", "\n");
    
            // Comparació amb TestStringUtils.findFirstDifference()
            String diff = TestStringUtils.findFirstDifference(output, expected);
            assertTrue(diff.compareTo("identical") == 0, 
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");
    
            System.out.println("Test passed, succeeded!");
        } catch (AssertionError e) {
            System.out.println("Test failed: " + testInfo.getDisplayName());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
        }
    }
        
    @Test
    void testInvertirMapaClauValor(TestInfo testInfo) throws Exception {
        try {
            // Captura la sortida de la funció
            String output = SystemLambda.tapSystemOut(() -> Exercici0201.invertirMapaClauValor()).trim().replace("\r\n", "\n");
    
            // Valida el resultat esperat
            String expected = """
                Mapa original: {A=1, B=2, C=3}
                Mapa invertit: {1=A, 2=B, 3=C}
                """.trim().replace("\r\n", "\n");
    
            // Comparació amb TestStringUtils.findFirstDifference()
            String diff = TestStringUtils.findFirstDifference(output, expected);
            assertTrue(diff.compareTo("identical") == 0, 
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");
    
            System.out.println("Test passed, succeeded!");
        } catch (AssertionError e) {
            System.out.println("Test failed: " + testInfo.getDisplayName());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
        }
    }
    
    @Test
    void testFusionarMapesSumantValors(TestInfo testInfo) throws Exception {
        try {
            // Captura la sortida de la funció
            String output = SystemLambda.tapSystemOut(() -> Exercici0201.fusionarMapesSumantValors()).trim().replace("\r\n", "\n");
    
            // Valida el resultat esperat
            String expected = """
                Mapa fusionat: {X=10, Y=25, Z=15}
                """.trim().replace("\r\n", "\n");
    
            // Comparació amb TestStringUtils.findFirstDifference()
            String diff = TestStringUtils.findFirstDifference(output, expected);
            assertTrue(diff.compareTo("identical") == 0, 
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");
    
            System.out.println("Test passed, succeeded!");
        } catch (AssertionError e) {
            System.out.println("Test failed: " + testInfo.getDisplayName());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
        }
    }
    
    @Test
    void testOrdenarMapaPerClaus(TestInfo testInfo) throws Exception {
        try {
            // Captura la sortida de la funció
            String output = SystemLambda.tapSystemOut(() -> Exercici0201.ordenarMapaPerClaus()).trim().replace("\r\n", "\n");
    
            // Valida el resultat esperat
            String expected = """
                Mapa ordenat per claus: {Banana=3, Poma=5, Taronja=2}
                """.trim().replace("\r\n", "\n");
    
            // Comparació amb TestStringUtils.findFirstDifference()
            String diff = TestStringUtils.findFirstDifference(output, expected);
            assertTrue(diff.compareTo("identical") == 0, 
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");
    
            System.out.println("Test passed, succeeded!");
        } catch (AssertionError e) {
            System.out.println("Test failed: " + testInfo.getDisplayName());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
        }
    }
    
    @Test
    void testCalcularEstadistiquesNotesEstudiants(TestInfo testInfo) throws Exception {
        try {
            // Captura la sortida de la funció
            String output = SystemLambda.tapSystemOut(() -> Exercici0201.calcularEstadistiquesNotesEstudiants()).trim().replace("\r\n", "\n");
    
            // Valida el resultat esperat
            String expected = """
                Mitjana: 7.333333333333333, Màxim: 8.5, Mínim: 6.0
                """.trim().replace("\r\n", "\n");
    
            // Comparació amb TestStringUtils.findFirstDifference()
            String diff = TestStringUtils.findFirstDifference(output, expected);
            assertTrue(diff.compareTo("identical") == 0, 
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");
    
            System.out.println("Test passed, succeeded!");
        } catch (AssertionError e) {
            System.out.println("Test failed: " + testInfo.getDisplayName());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
        }
    }    
}
