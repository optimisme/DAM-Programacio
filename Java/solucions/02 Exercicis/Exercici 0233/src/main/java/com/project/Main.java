package com.project;

public class Main {

    public static double calcula_entrada(int numAdults, int numNens, int numGentGran, String dia) {
        double preuEstandar = 10.0;
        double preuNen = 5.0;
        double preuGentGran = 6.0;
        double descompteDimarts = 0.20;
        double descompteNenDijous = 0.50;

        double total = 0.0;

        if (dia.equalsIgnoreCase("dimarts")) {
            total += numAdults * preuEstandar * (1 - descompteDimarts);
            total += numNens * preuNen * (1 - descompteDimarts);
            total += numGentGran * preuGentGran * (1 - descompteDimarts);
        } else if (dia.equalsIgnoreCase("dijous")) {
            total += numAdults * preuEstandar;
            if (numNens > 0) {
                total += preuNen * descompteNenDijous; // primer nen 50% de descompte
                total += (numNens - 1) * 0; // altres nens no paguen
            }
            total += numGentGran * preuGentGran;
        } else {
            total += numAdults * preuEstandar;
            total += numNens * preuNen;
            total += numGentGran * preuGentGran;
        }

        return total;
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
