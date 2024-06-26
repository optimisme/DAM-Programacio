package com.project;

public class Main {

    public static double calcula_entrada(int numAdults, int numNens, int numGentGran, String dia) {
        return 0.0;
    }

    public static void main(String[] args) {
        // Exemples
        System.out.printf("Adult un dilluns: %.2f€\n", calcula_entrada(1, 0, 0, "dilluns"));
        System.out.printf("Nen un dimarts: %.2f€\n", calcula_entrada(0, 1, 0, "dimarts"));
        System.out.printf("Gent gran un dijous: %.2f€\n", calcula_entrada(0, 0, 1, "dijous"));
        System.out.printf("Adult i nen un dijous: %.2f€\n", calcula_entrada(1, 1, 0, "dijous"));
        System.out.printf("Adult i tres nens un dijous: %.2f€\n", calcula_entrada(1, 3, 0, "dijous"));
    }
}
