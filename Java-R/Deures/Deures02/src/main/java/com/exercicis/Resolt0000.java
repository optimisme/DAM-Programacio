package com.exercicis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Resolt0000 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(addImaginaries("1+2i", "4+5i"));

        drawPascal(5);

        ArrayList<Double> list = new ArrayList<>(Arrays.asList(1.5, 2.3, 3.7));
        System.out.println(addList(list));

        int[][] matrixA = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        printMatrix(matrixA);

        int[][] matrixB = {{1, 2, 3}, {4, 5, 6}};
        int[][] matrixC = {
            {1,  2,  3,  4,  5}, 
            {6,  7,  8,  9, 10}, 
            {11, 12, 13, 14, 15}, 
            {16, 17, 18, 19, 20}
        };

        printMatrix(transpose(matrixB));
        printMatrix(transpose(matrixC));

        System.out.println(firstNonRepeated("swiss"));     // w
        System.out.println(firstNonRepeated("redivider")); // v
        System.out.println(firstNonRepeated("aabbcc"));    // _

        System.out.println(inverInt(3645)); 

        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(3, 6, 1, 5, 0));
        System.out.println(minMaxAdd(nums));

        System.out.println(sumaSenseSumar(5, 6) + ":" + sumaSenseSumar(-3, 3) + ":" + sumaSenseSumar(10, -4));

        System.out.println(minDistances("algoritmo", 'o'));
        System.out.println(minDistances("abcdefga", 'a'));

        System.out.println(findUniqueNumber(new ArrayList<>(Arrays.asList(2.0, 2.0, 1.0))));
        System.out.println(findUniqueNumber(new ArrayList<>(Arrays.asList(4.0, 1.0, 2.0, 1.0, 2.0))));

        scanner.close();
    }

    private static int getImaginaryReal(String num) {
        return Integer.parseInt(num.split("\\+")[0]);
    }

    private static int getImaginary(String num) {
        int idx = num.indexOf("+");
        String str = num.substring(idx + 1, num.length() - 1);
        return Integer.parseInt(str);
    }

    /**
     * Fes una funció que sumi números inmaginaris 
     * definits per una cadena de text
     * 
     *  "1+2i" + "4+5i" = "5+7i"
     * 
     * @param String el primer número imaginari
     * @param String el segon número imaginari
     * @return String el resultat de la suma
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0000#testAddImaginariesSimple
     * @test ./runTest.sh com.exercicis.TestExercici0000#testAddImaginariesNegative
     * @test ./runTest.sh com.exercicis.TestExercici0000#testAddImaginariesZero
     * @test ./runTest.sh com.exercicis.TestExercici0000#testAddImaginariesWithZeroRealPart
     * @test ./runTest.sh com.exercicis.TestExercici0000#testAddImaginariesWithZeroImaginaryPart
     * @test ./runTest.sh com.exercicis.TestExercici0000#testAddImaginariesLargeNumbers
     */
    public static String addImaginaries(String num0, String num1) {
        int real0 = getImaginaryReal(num0);
        int img0 = getImaginary(num0);
        int real1 = getImaginaryReal(num1);
        int img1 = getImaginary(num1);
        int real = real0 + real1;
        int img = img0 + img1;
        return real + "+" + img + "i";
    }

    /**
     * Fes un programa que dibuixi el triangle de pascal
     * 
     * @param int nivells del triangle (0 fins a n)
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0000#testDrawPascalZero
     * @test ./runTest.sh com.exercicis.TestExercici0000#testDrawPascalOne
     * @test ./runTest.sh com.exercicis.TestExercici0000#testDrawPascalTwo
     * @test ./runTest.sh com.exercicis.TestExercici0000#testDrawPascalThree
     * @test ./runTest.sh com.exercicis.TestExercici0000#testDrawPascalFive
     */
    public static void drawPascal(int n) {

        for (int i = 0; i < n; i++) {
            int num = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(num + " ");
                num = num * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }

    /**
     * Fes una funció que sumi els valors d'un ArrayList<double>
     * 
     * @param llista de valors
     * @return resultat de la suma
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0000#testAddListEmpty
     * @test ./runTest.sh com.exercicis.TestExercici0000#testAddListSingleElement
     * @test ./runTest.sh com.exercicis.TestExercici0000#testAddListMultipleElements
     * @test ./runTest.sh com.exercicis.TestExercici0000#testAddListNegativeNumbers
     * @test ./runTest.sh com.exercicis.TestExercici0000#testAddListMixedNumbers
     * @test ./runTest.sh com.exercicis.TestExercici0000#testAddListDecimals
     */
    public static double addList(ArrayList<Double> list) {
        double sum = 0;
        for (double num : list) {
            sum += num;
        }
        return sum;
    }

    /** 
     * Fes una funció que dibuixi els valors d'una matriu
     * int[][] entrada = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
     * 
     * @param int[][] matriu a dibuixar
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0000#testPrintMatrixSingleElement
     * @test ./runTest.sh com.exercicis.TestExercici0000#testPrintMatrixRow
     * @test ./runTest.sh com.exercicis.TestExercici0000#testPrintMatrixColumn
     * @test ./runTest.sh com.exercicis.TestExercici0000#testPrintMatrixSquare
     * @test ./runTest.sh com.exercicis.TestExercici0000#testPrintMatrixRectangular
     * @test ./runTest.sh com.exercicis.TestExercici0000#testPrintMatrixEmpty
     */
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i]);
                if (i < row.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Fes una funció que retorni la trasposada d'una matriu
     * 
     * int[][] entrada = { {1, 2, 3}, {4, 5, 6} };
     * int[][] sortida = { {1, 4}, {2, 5}, {3, 6} };
     * 
     * int[][] entrada = { 
     *      {1,  2,  3,  4,  5}, 
     *      {6,  7,  8,  9, 10}, 
     *      {11, 12, 13, 14, 15}, 
     *      {16, 17, 18, 19, 20} };
     * 
     * int[][] sortida = { 
     *     {1, 6, 11, 16},
     *     {2, 7, 12, 17},
     *     {3, 8, 13, 18},
     *     {4, 9, 14, 19},
     *     {5, 10, 15, 20}
     * };
     * 
     * @param int[][] matriu a transposar
     * @return int[][] matriu transposada
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0000#testTransposeSquareMatrix
     * @test ./runTest.sh com.exercicis.TestExercici0000#testTransposeRectangularMatrix
     * @test ./runTest.sh com.exercicis.TestExercici0000#testTransposeColumnMatrix
     * @test ./runTest.sh com.exercicis.TestExercici0000#testTransposeSingleElement
     */
    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int transposedRows = cols;
        int transposedCols = rows;
        int[][] transposed = new int[transposedRows][transposedCols];

        for (int cntRow = 0; cntRow < rows; cntRow = cntRow + 1) {
            for (int cntCol = 0; cntCol < cols; cntCol = cntCol + 1) {
                transposed[cntCol][cntRow] = matrix[cntRow][cntCol];
            }
        }
        return transposed;
    }

    /**
     * Fes una funció que troba el primer caràcter que
     * no es repeteix dins d'una cadena de text
     * si totes les lletres es repeteixen torna '_'
     * 
     * Exemple:
     * 
     * Entrada: "swiss"
     * Sortida: 'w'
     * 
     * Entrada: "redivider"
     * Sortida: 'v'
     * 
     * @param String cadena de text
     * @return char primer caràcter que no es repeteix
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0000#testFirstNonRepeatedBasic
     * @test ./runTest.sh com.exercicis.TestExercici0000#testFirstNonRepeatedAllRepeated
     * @test ./runTest.sh com.exercicis.TestExercici0000#testFirstNonRepeatedLongString
     */
    public static char firstNonRepeated(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (str.indexOf(c) == str.lastIndexOf(c)) {
                return c;
            }
        }
        return '_';
    }

    /**
     * Fes una funció que inverteixi els caràcters
     * d'un número enter: 3645 > 5463
     * 
     * @param int número a invertir
     * @return int número resultant
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0000#testInverIntPositive
     * @test ./runTest.sh com.exercicis.TestExercici0000#testInverIntWithZeros
     * @test ./runTest.sh com.exercicis.TestExercici0000#testInverIntSingleDigit
     */
    public static int inverInt(int num) {
        String str = Integer.toString(num);
        String reversed = new StringBuilder(str).reverse().toString();
        return Integer.parseInt(reversed);
    }

    /**
     * Fes una funció que rebi una llista (`ArrayList`) amb 5 números
     * i calculi el número més petit i el número més gran
     * que es poden calcular sumant 4 dels 5 números rebuts.
     * 
     * Exemple:
     * 
     * Entrada: [3, 6, 1, 5, 0]
     * Sortida: [9, 15]
     * 
     * Explicació:
     *  9  = 0 + 1 + 3 + 5 (sumant els quatre números més petits)
     *  15 = 1 + 3 + 5 + 6 (sumant els quatre números més grans)
     * 
     * @param ArrayList<Integer> nums Llista de números d'entrada (exactament 5 números)
     * @return ArrayList<Integer> Llista amb els dos números de sortida [mínim, màxim]
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0000#testMinMaxAddBasic
     * @test ./runTest.sh com.exercicis.TestExercici0000#testMinMaxAddWithNegatives
     * @test ./runTest.sh com.exercicis.TestExercici0000#testMinMaxAddWithDuplicates
     */
    public static ArrayList<Integer> minMaxAdd(ArrayList<Integer> nums) {
        nums.sort((a, b) -> a.compareTo(b));
        int minSum = nums.get(0) + nums.get(1) + nums.get(2) + nums.get(3);
        int maxSum = nums.get(1) + nums.get(2) + nums.get(3) + nums.get(4);
        return new ArrayList<>(Arrays.asList(minSum, maxSum));
    }

    /**
     * Fes una funció que sumi dos números sense fer servir 
     * la operació de suma.
     * 
     * Exemple:
     * 
     * Entrada: 5, 7
     * Sortida: 12
     * 
     * Entrada: -3, 3
     * Sortida: 0
     * 
     * @param int a Primer número a sumar
     * @param int b Segon número a sumar
     * @return int Resultat de la suma de a i b sense utilitzar l'operació de suma
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0000#testSumaSenseSumarPositiveNumbers
     * @test ./runTest.sh com.exercicis.TestExercici0000#testSumaSenseSumarNegativeNumbers
     * @test ./runTest.sh com.exercicis.TestExercici0000#testSumaSenseSumarPositiveAndNegative
     * @test ./runTest.sh com.exercicis.TestExercici0000#testSumaSenseSumarZero
     * @test ./runTest.sh com.exercicis.TestExercici0000#testSumaSenseSumarLargeNumbers
     */
    public static int sumaSenseSumar(int a, int b) {
        String s1 = "x".repeat(Math.abs(a));
        String s2 = "x".repeat(Math.abs(b));
        
        int resultat = s1.length() + s2.length();
        
        if ((a < 0 && b >= 0) || (a >= 0 && b < 0)) {
            resultat = Math.max(s1.length(), s2.length()) - Math.min(s1.length(), s2.length());
        }
        
        return (a < 0 || b < 0) ? -resultat : resultat;
    }

    /**
     * Fes una funció que retorni les distàncies mínimes
     * de cada lletra fins a un caràcter d'una cadena de text.
     * 
     * Exemple:
     * 
     * Entrada: "algoritmo", 'o'
     * Sortida: [3, 2, 1, 0, 1, 2, 2, 1, 0]
     * 
     * Entrada: "abcdefga", 'a'
     * Sortida: [0, 1, 2, 3, 3, 2, 1, 0]
     * 
     * @param String text Cadena de text d'entrada
     * @param char target Caràcter objectiu
     * @return ArrayList<Integer> Llista de distàncies mínimes de cada lletra fins al caràcter objectiu
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0000#testMinDistancesBasic
     * @test ./runTest.sh com.exercicis.TestExercici0000#testMinDistancesMultipleTargets
     * @test ./runTest.sh com.exercicis.TestExercici0000#testMinDistancesNoTargetFound
     */
    public static ArrayList<Integer> minDistances(String text, char target) {
        int textLength = text.length();
        int[] left = new int[textLength];
        int[] right = new int[textLength];

        // Inicialitzar els arrays amb la longitud de la cadena
        Arrays.fill(left, textLength);
        Arrays.fill(right, textLength);

        // Distàncies mínimes de l'esquerra a la dreta
        int lastTargetIndex = -textLength;
        for (int cntChar = 0; cntChar < textLength; cntChar = cntChar + 1) {
            if (text.charAt(cntChar) == target) lastTargetIndex = cntChar;
            left[cntChar] = cntChar - lastTargetIndex;
        }

        // Distàncies mínimes de la dreta a l'esquerra
        lastTargetIndex = 2 * textLength;
        for (int cntChar = (textLength - 1); cntChar >= 0; cntChar = cntChar - 1) {
            if (text.charAt(cntChar) == target) lastTargetIndex = cntChar;
            right[cntChar] = lastTargetIndex - cntChar;
        }

        // Formar la llista de distàncies mínimes
        ArrayList<Integer> distances = new ArrayList<>(textLength);
        for (int cntChar = 0; cntChar < textLength; cntChar = cntChar + 1) {
            distances.add(Math.min(left[cntChar], right[cntChar]));
        }

        return distances;
    }

    /**
     * A partir d'una llista de números on cada 
     * número es repeteix dos cops excepte un, troba
     * el número que no es repeteix.
     * 
     * Exemple:
     * 
     * Entrada: [2.0, 2.0, 1.0]
     * Sortida: 1.0
     * 
     * Entrada: [4.0, 1.0, 2.0, 1.0, 2.0]
     * Sortida: 4.0
     * 
     * @param ArrayList<Double> nums Llista de números d'entrada
     * @return Double Número que no es repeteix
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0000#testFindUniqueNumberBasic
     * @test ./runTest.sh com.exercicis.TestExercici0000#testFindUniqueNumberMultiplePairs
     * @test ./runTest.sh com.exercicis.TestExercici0000#testFindUniqueNumberNoUnique
     */
    public static Double findUniqueNumber(ArrayList<Double> nums) {
        HashMap<Double, Integer> frequencyMap = new HashMap<>();

        // Guardar la freqüència de cada número en un HashMap
        for (Double num : nums) {
            if (frequencyMap.containsKey(num)) {
                frequencyMap.put(num, frequencyMap.get(num) + 1);
            } else {
                frequencyMap.put(num, 1);
            }
        }

        for (HashMap.Entry<Double, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return null;
    }
}
