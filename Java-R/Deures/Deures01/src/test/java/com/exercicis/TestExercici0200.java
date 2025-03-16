package com.exercicis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import static org.junit.jupiter.api.Assertions.*;
import com.github.stefanbirkner.systemlambda.SystemLambda;
import com.testStringUtils.TestStringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

class TestExercici0200 {

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
    void testAddImaginariesSimple(TestInfo testInfo) throws Exception {
        try {
            String text = Exercici0200.addImaginaries("1+2i", "4+5i");           
            text = text.replace("\r\n", "\n");
            String expectedOutput = "5+7i".trim().replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
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
    void testAddImaginariesNegative(TestInfo testInfo) throws Exception {
        try {
            String text = Exercici0200.addImaginaries("-1+2i", "4-3i");
            text = text.replace("\r\n", "\n");
            String expectedOutput = "3-1i".trim().replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
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
    void testAddImaginariesZero(TestInfo testInfo) throws Exception {
        try {
            String text = Exercici0200.addImaginaries("0+0i", "0+0i");
            text = text.replace("\r\n", "\n");
            String expectedOutput = "0+0i".trim().replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
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
    void testAddImaginariesWithZeroRealPart(TestInfo testInfo) throws Exception {
        try {
            String text = Exercici0200.addImaginaries("0+2i", "0+3i");
            text = text.replace("\r\n", "\n");
            String expectedOutput = "0+5i".trim().replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
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
    void testAddImaginariesWithZeroImaginaryPart(TestInfo testInfo) throws Exception {
        try {
            String text = Exercici0200.addImaginaries("3+0i", "-2+0i");
            text = text.replace("\r\n", "\n");
            String expectedOutput = "1+0i".trim().replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
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
    void testAddImaginariesLargeNumbers(TestInfo testInfo) throws Exception {
        try {
            String text = Exercici0200.addImaginaries("1000000+2000000i", "3000000+4000000i");
            text = text.replace("\r\n", "\n");
            String expectedOutput = "4000000+6000000i".trim().replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
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
    void testDrawPascalZero(TestInfo testInfo) throws Exception {
        try {
            String text = SystemLambda.tapSystemOut(() -> Exercici0200.drawPascal(0));
            text = text.trim().replace("\r\n", "\n");
            String expectedOutput = "".trim().replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
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
    void testDrawPascalOne(TestInfo testInfo) throws Exception {
        try {
            String text = SystemLambda.tapSystemOut(() -> Exercici0200.drawPascal(1));
            text = text.trim().replace("\r\n", "\n");
            String expectedOutput = "1".trim().replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
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
    void testDrawPascalTwo(TestInfo testInfo) throws Exception {
        try {
            String text = SystemLambda.tapSystemOut(() -> Exercici0200.drawPascal(2));
            text = text.trim().replace("\r\n", "\n");
            String expectedOutput = """
                1
                1 1
                """.trim().replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
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
    void testDrawPascalThree(TestInfo testInfo) throws Exception {
        try {
            String text = SystemLambda.tapSystemOut(() -> Exercici0200.drawPascal(3));
            text = text.trim().replace("\r\n", "\n");
            String expectedOutput = """
                1
                1 1
                1 2 1
                """.trim().replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
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
    void testDrawPascalFive(TestInfo testInfo) throws Exception {
        try {
            String text = SystemLambda.tapSystemOut(() -> Exercici0200.drawPascal(5));
            text = text.trim().replace("\r\n", "\n");
            String expectedOutput = """
                1
                1 1
                1 2 1
                1 3 3 1
                1 4 6 4 1
                """.trim().replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
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
    void testAddListEmpty(TestInfo testInfo) {
        try {
            ArrayList<Double> list = new ArrayList<>();
            double result = Exercici0200.addList(list);
            double expected = 0.0;

            String resultText = String.format("%.9f", result);
            String expectedText = String.format("%.9f", expected);

            String diff = TestStringUtils.findFirstDifference(resultText, expectedText);
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
    void testAddListSingleElement(TestInfo testInfo) {
        try {
            ArrayList<Double> list = new ArrayList<>(Arrays.asList(5.0));
            double result = Exercici0200.addList(list);
            double expected = 5.0;
    
            String resultText = String.format("%.9f", result);
            String expectedText = String.format("%.9f", expected);
    
            String diff = TestStringUtils.findFirstDifference(resultText, expectedText);
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
    void testAddListMultipleElements(TestInfo testInfo) {
        try {
            ArrayList<Double> list = new ArrayList<>(Arrays.asList(1.5, 2.5, 3.0));
            double result = Exercici0200.addList(list);
            double expected = 7.0;
    
            String resultText = String.format("%.9f", result);
            String expectedText = String.format("%.9f", expected);
    
            String diff = TestStringUtils.findFirstDifference(resultText, expectedText);
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
    void testAddListNegativeNumbers(TestInfo testInfo) {
        try {
            ArrayList<Double> list = new ArrayList<>(Arrays.asList(-1.5, -2.5, -3.0));
            double result = Exercici0200.addList(list);
            double expected = -7.0;
    
            String resultText = String.format("%.9f", result);
            String expectedText = String.format("%.9f", expected);
    
            String diff = TestStringUtils.findFirstDifference(resultText, expectedText);
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
    void testAddListMixedNumbers(TestInfo testInfo) {
        try {
            ArrayList<Double> list = new ArrayList<>(Arrays.asList(5.5, -2.5, 3.0, -1.0));
            double result = Exercici0200.addList(list);
            double expected = 5.0;
    
            String resultText = String.format("%.9f", result);
            String expectedText = String.format("%.9f", expected);
    
            String diff = TestStringUtils.findFirstDifference(resultText, expectedText);
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
    void testAddListDecimals(TestInfo testInfo) {
        try {
            ArrayList<Double> list = new ArrayList<>(Arrays.asList(0.1, 0.2, 0.3));
            double result = Exercici0200.addList(list);
            double expected = 0.6;
    
            String resultText = String.format("%.9f", result);
            String expectedText = String.format("%.9f", expected);
    
            String diff = TestStringUtils.findFirstDifference(resultText, expectedText);
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
    void testPrintMatrixSingleElement(TestInfo testInfo) throws Exception {
        try {
            int[][] matrix = {{42}};
            String output = SystemLambda.tapSystemOut(() -> Exercici0200.printMatrix(matrix)).trim().replace("\r\n", "\n");
            String expected = "42";

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
    void testPrintMatrixRow(TestInfo testInfo) throws Exception {
        try {
            int[][] matrix = {{1, 2, 3}};
            String output = SystemLambda.tapSystemOut(() -> Exercici0200.printMatrix(matrix)).trim().replace("\r\n", "\n");
            String expected = "1, 2, 3";

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
    void testPrintMatrixColumn(TestInfo testInfo) throws Exception {
        try {
            int[][] matrix = {
                {1},
                {2},
                {3}
            };
            String output = SystemLambda.tapSystemOut(() -> Exercici0200.printMatrix(matrix)).trim().replace("\r\n", "\n");
            String expected = """
                1
                2
                3
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
    void testPrintMatrixSquare(TestInfo testInfo) throws Exception {
        try {
            int[][] matrix = {
                {1, 2},
                {3, 4}
            };
            String output = SystemLambda.tapSystemOut(() -> Exercici0200.printMatrix(matrix)).trim().replace("\r\n", "\n");
            String expected = """
                1, 2
                3, 4
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
    void testPrintMatrixRectangular(TestInfo testInfo) throws Exception {
        try {
            int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
            };
            String output = SystemLambda.tapSystemOut(() -> Exercici0200.printMatrix(matrix)).trim().replace("\r\n", "\n");
            String expected = """
                1, 2, 3
                4, 5, 6
                7, 8, 9
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
    void testPrintMatrixEmpty(TestInfo testInfo) throws Exception {
        try {
            int[][] matrix = {};
            String output = SystemLambda.tapSystemOut(() -> Exercici0200.printMatrix(matrix)).trim().replace("\r\n", "\n");
            String expected = "";

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

    private static String matrixToString(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : matrix) {
            sb.append(Arrays.toString(row)).append("\n");
        }
        return sb.toString().trim().replace("\r\n", "\n");
    }

    @Test
    void testTransposeRectangularMatrix(TestInfo testInfo) {
        try {
            int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8}
            };
            int[][] expected = {
                {1, 5},
                {2, 6},
                {3, 7},
                {4, 8}
            };
    
            int[][] result = Exercici0200.transpose(matrix);
    
            String resultText = matrixToString(result);
            String expectedText = matrixToString(expected);
    
            String diff = TestStringUtils.findFirstDifference(resultText, expectedText);
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
    void testTransposeColumnMatrix(TestInfo testInfo) {
        try {
            int[][] matrix = {
                {1},
                {2},
                {3}
            };
            int[][] expected = {
                {1, 2, 3}
            };
    
            int[][] result = Exercici0200.transpose(matrix);
    
            String resultText = matrixToString(result);
            String expectedText = matrixToString(expected);
    
            String diff = TestStringUtils.findFirstDifference(resultText, expectedText);
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
    void testTransposeSingleElement(TestInfo testInfo) {
        try {
            int[][] matrix = {{7}};
            int[][] expected = {{7}};
    
            int[][] result = Exercici0200.transpose(matrix);
    
            String resultText = matrixToString(result);
            String expectedText = matrixToString(expected);
    
            String diff = TestStringUtils.findFirstDifference(resultText, expectedText);
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
    void testFirstNonRepeatedBasic(TestInfo testInfo) {
        try {
            char result = Exercici0200.firstNonRepeated("swiss");
            char expected = 'w';
    
            String resultText = Character.toString(result);
            String expectedText = Character.toString(expected);
    
            String diff = TestStringUtils.findFirstDifference(resultText, expectedText);
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
    void testFirstNonRepeatedAllRepeated(TestInfo testInfo) {
        try {
            char result = Exercici0200.firstNonRepeated("aabbcc");
            char expected = '_';
    
            String resultText = Character.toString(result);
            String expectedText = Character.toString(expected);
    
            String diff = TestStringUtils.findFirstDifference(resultText, expectedText);
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
    void testFirstNonRepeatedLongString(TestInfo testInfo) {
        try {
            char result = Exercici0200.firstNonRepeated("redivider");
            char expected = 'v';
    
            String resultText = Character.toString(result);
            String expectedText = Character.toString(expected);
    
            String diff = TestStringUtils.findFirstDifference(resultText, expectedText);
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
    void testInverIntPositive(TestInfo testInfo) {
        try {
            int result = Exercici0200.inverInt(3645);
            int expected = 5463;
    
            String resultText = Integer.toString(result);
            String expectedText = Integer.toString(expected);
    
            String diff = TestStringUtils.findFirstDifference(resultText, expectedText);
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
    void testInverIntWithZeros(TestInfo testInfo) {
        try {
            int result = Exercici0200.inverInt(1230);
            int expected = 321; // Els zeros inicials desapareixen
    
            String resultText = Integer.toString(result);
            String expectedText = Integer.toString(expected);
    
            String diff = TestStringUtils.findFirstDifference(resultText, expectedText);
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
    void testInverIntSingleDigit(TestInfo testInfo) {
        try {
            int result = Exercici0200.inverInt(7);
            int expected = 7;
    
            String resultText = Integer.toString(result);
            String expectedText = Integer.toString(expected);
    
            String diff = TestStringUtils.findFirstDifference(resultText, expectedText);
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
    void testMinMaxAddBasic(TestInfo testInfo) {
        try {
            ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(3, 6, 1, 5, 0));
            ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(9, 15));
    
            ArrayList<Integer> result = Exercici0200.minMaxAdd(nums);
    
            String resultText = result.toString();
            String expectedText = expected.toString();
    
            String diff = TestStringUtils.findFirstDifference(resultText, expectedText);
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
    void testMinMaxAddWithNegatives(TestInfo testInfo) {
        try {
            ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(-1, -2, -3, -4, -5));
            ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(-10, -6));
    
            ArrayList<Integer> result = Exercici0200.minMaxAdd(nums);
    
            String resultText = result.toString();
            String expectedText = expected.toString();
    
            String diff = TestStringUtils.findFirstDifference(resultText, expectedText);
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
    void testMinMaxAddWithDuplicates(TestInfo testInfo) {
        try {
            ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(4, 4, 4, 4, 4));
            ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(16, 16));
    
            ArrayList<Integer> result = Exercici0200.minMaxAdd(nums);
    
            String resultText = result.toString();
            String expectedText = expected.toString();
    
            String diff = TestStringUtils.findFirstDifference(resultText, expectedText);
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
    void testSumaSenseSumarPositiveNumbers(TestInfo testInfo) {
        try {
            int result = Exercici0200.sumaSenseSumar(5, 7);
            int expected = 12;
    
            String resultText = Integer.toString(result);
            String expectedText = Integer.toString(expected);
    
            String diff = TestStringUtils.findFirstDifference(resultText, expectedText);
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
    void testSumaSenseSumarNegativeNumbers(TestInfo testInfo) {
        try {
            int result = Exercici0200.sumaSenseSumar(-3, -7);
            int expected = -10;
    
            String resultText = Integer.toString(result);
            String expectedText = Integer.toString(expected);
    
            String diff = TestStringUtils.findFirstDifference(resultText, expectedText);
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
    void testSumaSenseSumarPositiveAndNegative(TestInfo testInfo) {
        try {
            int result = Exercici0200.sumaSenseSumar(-3, 3);
            int expected = 0;
    
            String resultText = Integer.toString(result);
            String expectedText = Integer.toString(expected);
    
            String diff = TestStringUtils.findFirstDifference(resultText, expectedText);
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
    void testSumaSenseSumarZero(TestInfo testInfo) {
        try {
            assertEquals(7, Exercici0200.sumaSenseSumar(7, 0));
            assertEquals(-5, Exercici0200.sumaSenseSumar(0, -5));
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
    void testSumaSenseSumarLargeNumbers(TestInfo testInfo) {
        try {
            int result = Exercici0200.sumaSenseSumar(500, 500);
            int expected = 1000;
    
            String resultText = Integer.toString(result);
            String expectedText = Integer.toString(expected);
    
            String diff = TestStringUtils.findFirstDifference(resultText, expectedText);
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
    void testMinDistancesBasic(TestInfo testInfo) {
        try {
            ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(3, 2, 1, 0, 1, 2, 2, 1, 0));
            ArrayList<Integer> result = Exercici0200.minDistances("algoritmo", 'o');
    
            String resultText = result.toString();
            String expectedText = expected.toString();
    
            String diff = TestStringUtils.findFirstDifference(resultText, expectedText);
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
    void testMinDistancesMultipleTargets(TestInfo testInfo) {
        try {
            ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 3, 2, 1, 0));
            ArrayList<Integer> result = Exercici0200.minDistances("abcdefga", 'a');
    
            String resultText = result.toString();
            String expectedText = expected.toString();
    
            String diff = TestStringUtils.findFirstDifference(resultText, expectedText);
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
    void testMinDistancesNoTargetFound(TestInfo testInfo) {
        try {
            ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(9, 9, 9, 9, 9, 9, 9, 9, 9));
            ArrayList<Integer> result = Exercici0200.minDistances("abcdefghi", 'z');
    
            String resultText = result.toString();
            String expectedText = expected.toString();
    
            String diff = TestStringUtils.findFirstDifference(resultText, expectedText);
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
    void testFindUniqueNumberBasic(TestInfo testInfo) {
        try {
            ArrayList<Double> nums = new ArrayList<>(Arrays.asList(2.0, 2.0, 1.0));
            double result = Exercici0200.findUniqueNumber(nums);
            double expected = 1.0;
    
            String resultText = String.format("%.9f", result);
            String expectedText = String.format("%.9f", expected);
    
            String diff = TestStringUtils.findFirstDifference(resultText, expectedText);
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
    void testFindUniqueNumberMultiplePairs(TestInfo testInfo) {
        try {
            ArrayList<Double> nums = new ArrayList<>(Arrays.asList(4.0, 1.0, 2.0, 1.0, 2.0));
            double result = Exercici0200.findUniqueNumber(nums);
            double expected = 4.0;
    
            String resultText = String.format("%.9f", result);
            String expectedText = String.format("%.9f", expected);
    
            String diff = TestStringUtils.findFirstDifference(resultText, expectedText);
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
    void testFindUniqueNumberNoUnique(TestInfo testInfo) {
        try {
            ArrayList<Double> nums = new ArrayList<>(Arrays.asList(3.0, 3.0, 5.5, 5.5, 7.7, 7.7));
            Double result = Exercici0200.findUniqueNumber(nums);
    
            assertNull(result, "Expected null but found a value.");
            
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
