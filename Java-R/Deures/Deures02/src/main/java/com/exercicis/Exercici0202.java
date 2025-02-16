package com.exercicis;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;


public class Exercici0202 {

    public static Scanner scanner;
    public static Locale defaultLocale;
    
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        defaultLocale = Locale.getDefault();
        Locale.setDefault(Locale.US);



        Locale.setDefault(defaultLocale);
        scanner.close();
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
     * @test ./runTest.sh com.exercicis.TestExercici0200#testAddImaginariesSimple
     * @test ./runTest.sh com.exercicis.TestExercici0200#testAddImaginariesNegative
     * @test ./runTest.sh com.exercicis.TestExercici0200#testAddImaginariesZero
     * @test ./runTest.sh com.exercicis.TestExercici0200#testAddImaginariesWithZeroRealPart
     * @test ./runTest.sh com.exercicis.TestExercici0200#testAddImaginariesWithZeroImaginaryPart
     * @test ./runTest.sh com.exercicis.TestExercici0200#testAddImaginariesLargeNumbers
     */
    public static String addImaginaries(String num0, String num1) {
        return "";
    }
}