package com.exercicis;

import com.testStringUtils.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import static org.junit.jupiter.api.Assertions.*;

import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

class TestExercici0000 {

    @Test
    void testAddImaginariesSimple(TestInfo testInfo) throws Exception {
        try {
            String result = Exercici0000.addImaginaries("1+2i", "4+5i");
            assertEquals("5+7i", result);
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
            String result = Exercici0000.addImaginaries("-1+2i", "4-3i");
            assertEquals("3-1i", result);
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
            String result = Exercici0000.addImaginaries("0+0i", "0+0i");
            assertEquals("0+0i", result);
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
            String result = Exercici0000.addImaginaries("0+2i", "0+3i");
            assertEquals("0+5i", result);
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
            String result = Exercici0000.addImaginaries("3+0i", "-2+0i");
            assertEquals("1+0i", result);
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
            String result = Exercici0000.addImaginaries("1000000+2000000i", "3000000+4000000i");
            assertEquals("4000000+6000000i", result);
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
            String output = SystemLambda.tapSystemOut(() -> Exercici0000.drawPascal(0));
            assertEquals("", output.trim());
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
            String output = SystemLambda.tapSystemOut(() -> Exercici0000.drawPascal(1));
            assertEquals("1", output.trim());
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
            String output = SystemLambda.tapSystemOut(() -> Exercici0000.drawPascal(2));
            String expected = """
                1
                1 1
                """.trim();
            assertEquals(expected, output.trim());
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
            String output = SystemLambda.tapSystemOut(() -> Exercici0000.drawPascal(3));
            String expected = """
                1
                1 1
                1 2 1
                """.trim();
            assertEquals(expected, output.trim());
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
            String output = SystemLambda.tapSystemOut(() -> Exercici0000.drawPascal(5));
            String expected = """
                1
                1 1
                1 2 1
                1 3 3 1
                1 4 6 4 1
                """.trim();
            assertEquals(expected, output.trim());
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
            assertEquals(0.0, Exercici0000.addList(list), 1e-9);
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
            assertEquals(5.0, Exercici0000.addList(list), 1e-9);
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
            assertEquals(7.0, Exercici0000.addList(list), 1e-9);
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
            assertEquals(-7.0, Exercici0000.addList(list), 1e-9);
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
            assertEquals(5.0, Exercici0000.addList(list), 1e-9);
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
            assertEquals(0.6, Exercici0000.addList(list), 1e-9);
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
            String output = SystemLambda.tapSystemOut(() -> Exercici0000.printMatrix(matrix));
            assertEquals("42", output.trim());
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
            String output = SystemLambda.tapSystemOut(() -> Exercici0000.printMatrix(matrix));
            assertEquals("1, 2, 3", output.trim());
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
            String output = SystemLambda.tapSystemOut(() -> Exercici0000.printMatrix(matrix));
            String expected = """
                1
                2
                3
                """.trim();
            assertEquals(expected, output.trim());
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
            String output = SystemLambda.tapSystemOut(() -> Exercici0000.printMatrix(matrix));
            String expected = """
                1, 2
                3, 4
                """.trim();
            assertEquals(expected, output.trim());
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
            String output = SystemLambda.tapSystemOut(() -> Exercici0000.printMatrix(matrix));
            String expected = """
                1, 2, 3
                4, 5, 6
                7, 8, 9
                """.trim();
            assertEquals(expected, output.trim());
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
            String output = SystemLambda.tapSystemOut(() -> Exercici0000.printMatrix(matrix));
            assertEquals("", output.trim());
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
    void testTransposeSquareMatrix(TestInfo testInfo) {
        try {
            int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
            };
            int[][] expected = {
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}
            };
            assertArrayEquals(expected, Exercici0000.transpose(matrix));
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
            assertArrayEquals(expected, Exercici0000.transpose(matrix));
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
            assertArrayEquals(expected, Exercici0000.transpose(matrix));
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
            assertArrayEquals(expected, Exercici0000.transpose(matrix));
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
            assertEquals('w', Exercici0000.firstNonRepeated("swiss"));
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
            assertEquals('_', Exercici0000.firstNonRepeated("aabbcc"));
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
            assertEquals('v', Exercici0000.firstNonRepeated("redivider"));
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
            assertEquals(5463, Exercici0000.inverInt(3645));
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
            assertEquals(321, Exercici0000.inverInt(1230)); // 0321 es converteix a 321
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
            assertEquals(7, Exercici0000.inverInt(7));
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
            assertEquals(expected, Exercici0000.minMaxAdd(nums));
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
            assertEquals(expected, Exercici0000.minMaxAdd(nums));
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
            assertEquals(expected, Exercici0000.minMaxAdd(nums));
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
            assertEquals(12, Exercici0000.sumaSenseSumar(5, 7));
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
            assertEquals(-10, Exercici0000.sumaSenseSumar(-3, -7));
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
            assertEquals(0, Exercici0000.sumaSenseSumar(-3, 3));
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
            assertEquals(7, Exercici0000.sumaSenseSumar(7, 0));
            assertEquals(-5, Exercici0000.sumaSenseSumar(0, -5));
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
            assertEquals(1000, Exercici0000.sumaSenseSumar(500, 500));
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
            assertEquals(expected, Exercici0000.minDistances("algoritmo", 'o'));
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
            assertEquals(expected, Exercici0000.minDistances("abcdefga", 'a'));
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
            assertEquals(expected, Exercici0000.minDistances("abcdefghi", 'z'));
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
            assertEquals(1.0, Exercici0000.findUniqueNumber(nums));
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
            assertEquals(4.0, Exercici0000.findUniqueNumber(nums));
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
            assertNull(Exercici0000.findUniqueNumber(nums));
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
