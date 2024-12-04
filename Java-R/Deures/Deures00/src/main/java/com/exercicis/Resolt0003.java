package com.exercicis;

import java.util.Locale;
import java.util.Scanner;

public class Resolt0003 {
    
    public static double calcularPreuFinal(double preuBase, double iva, double descompte) {
        double preuAmbIva = preuBase + (preuBase * iva / 100);
        return preuAmbIva - (preuAmbIva * descompte / 100);
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Locale localeUS = Locale.US;

        System.out.print("Introdueix el preu base: ");
        double preuBase = scanner.nextDouble();

        System.out.print("Introdueix l'IVA (%): ");
        double iva = scanner.nextDouble();

        System.out.print("Introdueix el descompte (%): ");
        double descompte = scanner.nextDouble();

        double preuFinal = calcularPreuFinal(preuBase, iva, descompte);

        System.out.printf(localeUS, "El preu final és: %.2f\n", preuFinal);

        scanner.close();
    }
}
