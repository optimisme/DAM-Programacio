package com.exercicis;

import com.exercici0304.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.Locale;

import com.github.stefanbirkner.systemlambda.SystemLambda;
import com.testStringUtils.TestStringUtils;

class TestExercici0304 {

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
    void testModul(TestInfo testInfo) throws Exception {

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                NumComplex num = new NumComplex(3, 4);
                System.out.println("Modul: " + num.modul());
            });

            text = text.replace("\r\n", "\n");

            String expectedOutput = "Modul: 5.0\n".replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
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
    void testConjugat(TestInfo testInfo) throws Exception {

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                NumComplex num = new NumComplex(3, 4);
                System.out.println("Conjugat: " + num.conjugat());
            });

            text = text.replace("\r\n", "\n");

            String expectedOutput = "Conjugat: 3.0 - 4.0i\n".replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
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
    void testSuma(TestInfo testInfo) throws Exception {
    
        try {
            String text = SystemLambda.tapSystemOut(() -> {
                NumComplex num1 = new NumComplex(2, 3);
                NumComplex num2 = new NumComplex(4, -1);
                System.out.println("Suma: " + NumComplex.suma(num1, num2));
            });
    
            text = text.replace("\r\n", "\n");
    
            String expectedOutput = "Suma: 6.0 + 2.0i\n".replace("\r\n", "\n").replace("        ", "");
    
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
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
    void testResta(TestInfo testInfo) throws Exception {
    
        try {
            String text = SystemLambda.tapSystemOut(() -> {
                NumComplex num1 = new NumComplex(5, 7);
                NumComplex num2 = new NumComplex(2, 3);
                System.out.println("Resta: " + NumComplex.resta(num1, num2));
            });
    
            text = text.replace("\r\n", "\n");
    
            String expectedOutput = "Resta: 3.0 + 4.0i\n".replace("\r\n", "\n").replace("        ", "");
    
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
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
    void testMultiplica(TestInfo testInfo) throws Exception {
    
        try {
            String text = SystemLambda.tapSystemOut(() -> {
                NumComplex num1 = new NumComplex(1, 2);
                NumComplex num2 = new NumComplex(3, 4);
                System.out.println("Multiplica: " + NumComplex.multiplica(num1, num2));
            });
    
            text = text.replace("\r\n", "\n");
    
            String expectedOutput = "Multiplica: -5.0 + 10.0i\n".replace("\r\n", "\n").replace("        ", "");
    
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
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
    void testDivideix(TestInfo testInfo) throws Exception {
    
        try {
            String text = SystemLambda.tapSystemOut(() -> {
                NumComplex num1 = new NumComplex(4, 2);
                NumComplex num2 = new NumComplex(3, -1);
                System.out.println("Divideix: " + NumComplex.divideix(num1, num2));
            });
    
            text = text.replace("\r\n", "\n");
    
            String expectedOutput = "Divideix: 1.0 + 1.0i\n".replace("\r\n", "\n").replace("        ", "");
    
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
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
    void testDivideixPerZero(TestInfo testInfo) {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            NumComplex num1 = new NumComplex(4, 2);
            NumComplex num2 = new NumComplex(0, 0);
            NumComplex.divideix(num1, num2);
        });
    
        assertEquals("No es pot dividir per zero", exception.getMessage());
    }
    
    @Test
    void testMain(TestInfo testInfo) throws Exception {

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                Main.main(new String[]{});
            });

            text = text.replace("\r\n", "\n");

            String expectedOutput = (
                    "Número complex 1: 3.0 + 4.0i\n" +
                    "Número complex 2: 1.0 - 2.0i\n\n" +
                    "Mòdul de num1: 5.0\n" +
                    "Conjugat de num1: 3.0 - 4.0i\n\n" +
                    "Suma: 4.0 + 2.0i\n" +
                    "Resta: 2.0 + 6.0i\n" +
                    "Multiplicació: 11.0 - 2.0i\n" +
                    "Divisió: -1.0 + 2.0i\n"
            ).replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
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
