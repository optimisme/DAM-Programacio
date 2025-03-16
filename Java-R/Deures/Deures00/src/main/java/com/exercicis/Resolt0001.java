package com.exercicis;

import java.util.Locale;
import java.util.Scanner;

public class Resolt0001 {
    /**
     * Fes anar l'exercici amb:
     * ./run.sh com.exercicis.Exercici0001
     * 
     * Passa el test de l'exercici amb:
     * ./runTest.sh com.exercicis.TestExercici0001
     * 
     * Fes anar la solució amb:
     * ./run.sh com.exercicis.Resolt0001
     * 
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale localeUS = Locale.US;

        System.out.print("Escriu el pes (kg): ");
        double pes = scanner.nextDouble();

        System.out.print("Escriu l'alçada (cm): ");
        double alturaCm = scanner.nextDouble();

        double alturaMetres = alturaCm / 100;
        double imc = pes / (alturaMetres * alturaMetres);

        System.out.printf(localeUS, "imc = %.2f%n", imc);

        scanner.close();
    }
}
