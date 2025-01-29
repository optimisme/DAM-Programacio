package com.exercicis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Exercici0000 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
/* 
        System.out.println(addImaginaries("1+2i", "4+5i"));

        NumIm a = new NumIm(1, 2);
        NumIm b = new NumIm(4, 5);
        NumIm c = NumIm.sumaEstatica(a, b);
        NumIm d = a.sumaInstancia(b);

        System.out.println(c);
        System.out.println(d);


        drawPascal(5);

        ArrayList<Double> test = new ArrayList<>();
        test.add(1.0);
        test.add(2.0);
        test.add(3.0);
        double testSum = addList(test);
        System.out.println(testSum);

        int[][] entrada = { {1, 2, 3}, {4, 5, 6} };
        int[][] transposada = transpose(entrada);
        printMatrix(transposada);

        System.out.println(firstNonRepeated("swiss"));
        System.out.println(firstNonRepeated("redivider"));

        System.out.println(inverInt(5432));

        ArrayList<Integer> test = new ArrayList<>();
        test.add(3);
        test.add(6);
        test.add(1);
        test.add(5);
        test.add(0);

        System.out.println(minMaxAdd(test));
*/
        System.out.println(sumaSenseSumar(5, 3));

        
        scanner.close();
    }

    private static int getReal(String num) {
        int rst = 0;
        int indexP = num.indexOf("+");
        rst = Integer.valueOf(num.substring(0, indexP));
        return rst;
    }

    private static int getImaginary(String num) {
        int rst = 0;
        int indexP = num.indexOf("+");
        rst = Integer.valueOf(num.substring(indexP, num.length() - 1));
        return rst;
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
     */
    private static String addImaginaries(String num0, String num1) {
        int r0 = getReal(num0);
        int i0 = getImaginary(num0);
        int r1 = getReal(num1);
        int i1 = getImaginary(num1);
        int sumR = r0 + r1;
        int sumI = i0 + i1;

        return sumR + "+" + sumI + "i";
    }

    /**
     * Fes un programa que dibuixi el triangle de pascal
     * 
     * @param int nivells del triangle (0 fins a n)
     */
    private static void drawPascal(int n) {
        ArrayList<ArrayList<Integer>> pascal = new ArrayList<>();
        pascal.add(new ArrayList<>(List.of(1)));
        pascal.add(new ArrayList<>(List.of(1, 1)));

        for (int cnt = 1; cnt < n; cnt = cnt + 1) {
            ArrayList<Integer> prevLine = pascal.get(cnt);
            ArrayList<Integer> nextLine = new ArrayList<>();
            nextLine.add(1);
            int prevValue = 1;
            for (int col = 1; col < prevLine.size(); col = col + 1) {
                int sum = prevValue + prevLine.get(col);
                nextLine.add(sum);
                prevValue = prevLine.get(col);
            }
            nextLine.add(1);
            pascal.add(nextLine);
        }

        for (int cntLine = 0; cntLine < pascal.size(); cntLine = cntLine + 1) {
            ArrayList<Integer> line = pascal.get(cntLine);
            for (int cntCol = 0; cntCol < line.size(); cntCol = cntCol + 1) {
                int value = line.get(cntCol);
                System.out.print(value);
                if (cntCol < (line.size() - 1)) {
                    System.out.print(",");
                }
            }
            System.out.println();
        }
    }

    /**
     * Fes una funció que sumi els valors d'un ArrayList<double>
     * 
     * @param llista de valors
     * @return resultat de la suma
     */
    private static double addList(ArrayList<Double> list) {
        Double sumaTotal = 0.0;

        for (int i = 0; i < list.size(); i++) {
            sumaTotal = sumaTotal + list.get(i);
        }
        return sumaTotal;
    }

    /** 
     * Fes una funció que dibuixi els valors d'una matriu
     * int[][] entrada = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
     * 
     * @param int[][] matriu a dibuixar
     */
    public static void printMatrix(int[][] matrix) {
        for (int cntFila = 0; cntFila < matrix.length; cntFila++){
            for (int cntColumna = 0; cntColumna < matrix[cntFila].length; cntColumna++){

                System.out.print(matrix[cntFila][cntColumna]);

                if (cntColumna != (matrix[cntFila].length)-1){
                    System.out.print(",");
                }
                
            }
            System.out.println();
        }
    }

    /**
     * Fes una funció que retorni la trasposada d'una matriu
     * 
     * int[][] entrada = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
     * int[][] sortida = { {1, 4, 7}, {2, 5, 8}, {3, 6, 9} };
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
     */
    public static int[][] transpose(int[][] matrix) {
        int fils = matrix.length;
        int cols = matrix[0].length;
        int[][] transposedMatrix = new int[cols][fils];

        for (int i = 0; i < fils; i++) {
            for (int j = 0; j < cols; j++) {
            transposedMatrix[j][i] = matrix[i][j];
            }
        }

        return transposedMatrix;
    }

    /**
     * Fes una funció que troba el primer caràcter que
     * no es repeteix dins d'una cadena de text
     * 
     * Exemple:
     * 
     * Entrada: "swiss"
     * Sortida: 'w'
     * 
     * Entrada: "redivider"
     * Sortida: 'v'
     * 
     * Pseudocodi de l'algorisme:
     * 
     * 1. Inicialitzar una taula de freqüències (mapa) per comptar les ocurrències de cada caràcter.
     * 2. Iterar sobre cada caràcter de la cadena de text:
     *    a. Si el caràcter ja existeix en la taula de freqüències, incrementar el seu compte.
     *    b. Si el caràcter no existeix, afegir-lo a la taula amb un compte de 1.
     * 3. Iterar de nou sobre cada caràcter de la cadena de text en l'ordre original:
     *    a. Comprovar el compte del caràcter en la taula de freqüències.
     *    b. Si el compte és igual a 1, retornar aquest caràcter com el primer que no es repeteix.
     * 4. Si cap caràcter compleix la condició, retornar un valor que indiqui que no n'hi ha cap (per exemple, '_' o llançar una excepció).
     * 
     * @param String cadena de text
     * @return char primer caràcter que no es repeteix
     */
    public static char firstNonRepeated(String str) {
        for (int chrCnt = 0; chrCnt < str.length(); chrCnt = chrCnt + 1) {
            char lletra = str.charAt(chrCnt);
            String resta = str.substring(chrCnt+1);
            if (resta.indexOf(lletra) == -1) {
                return lletra;
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
     */
    public static int inverInt(int num) {
        String reves = "";
        String numString = Integer.toString(num);
        for (int i = numString.length()-1; i >= 0; i--){
            reves = reves + numString.substring(i, i+1);
        }
        int nombre = Integer.parseInt(reves);
        return nombre;
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
     */
    public static ArrayList<Integer> minMaxAdd(ArrayList<Integer> nums) {
        int petit = 0;
        int gran = 0;
        nums.sort((a,b) -> a.compareTo(b));

        for (int i = 0; i < nums.size() - 1; i++) {
            petit = petit + nums.get(i); 
        }

        nums.sort((a,b) -> b.compareTo(a));

        for (int i = 0; i < nums.size() - 1; i++) {
            gran = gran + nums.get(i);
        }

        return new ArrayList<>(Arrays.asList(petit, gran));
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
     */
    public static int sumaSenseSumar(int a, int b) {
        return a - (-b);
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
     * Pseudocodi de l'algorisme:
     * 
     * 1. Crear una llista per emmagatzemar les distàncies mínimes.
     * 2. Iterar de l'esquerra a la dreta:
     *    a. Mantenir l'índex de l'última aparició del caràcter objectiu.
     *    b. Calcular la distància actual com la diferència entre l'índex actual i l'última aparició.
     *    c. Emmagatzemar la distància calculada en la llista.
     * 3. Iterar de la dreta a l'esquerra:
     *    a. Mantenir l'índex de la pròxima aparició del caràcter objectiu.
     *    b. Calcular la distància actual com la diferència entre l'índex actual i la pròxima aparició.
     *    c. Actualitzar la distància en la llista si la nova distància és menor que la actual.
     * 4. Retornar la llista de distàncies mínimes.
     * 
     * @param String text Cadena de text d'entrada
     * @param char target Caràcter objectiu
     * @return ArrayList<Integer> Llista de distàncies mínimes de cada lletra fins al caràcter objectiu
     */
    public ArrayList<Integer> minDistances(String text, char target) {
        ArrayList<Integer> distances = new ArrayList<>(text.length());
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
     * Pseudocodi de l'algorisme:
     * 
     * 1. Crear un mapa (HashMap) per emmagatzemar les freqüències de cada número.
     * 2. Iterar sobre cada número en la llista:
     *    a. Si el número ja existeix al mapa, incrementar el seu compte.
     *    b. Si el número no existeix, afegir-lo al mapa amb un compte de 1.
     * 3. Iterar sobre les entrades del mapa:
     *    a. Si una entrada té un compte de 1, retornar aquest número com el que no es repeteix.
     * 4. Si cap número compleix la condició, retornar un valor indicatiu (per exemple, null o llançar una excepció).
     * 
     * @param ArrayList<Double> nums Llista de números d'entrada
     * @return Double Número que no es repeteix
     */
    public Double findUniqueNumber(ArrayList<Double> nums) {
        return null; // Implementació de la funció
    }

}
