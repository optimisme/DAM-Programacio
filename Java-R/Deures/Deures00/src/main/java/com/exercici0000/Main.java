package com.exercici0000;

import java.util.Scanner;

public class Main {

    public static double calcularPreuFinal(double preuBase, double iva, double descompte) {
        double preuAmbIva = preuBase + (preuBase * iva / 100);
        return preuAmbIva - (preuAmbIva * descompte / 100);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introdueix el preu base: ");
        double preuBase = scanner.nextDouble();

        System.out.print("Introdueix l'IVA (%): ");
        double iva = scanner.nextDouble();

        System.out.print("Introdueix el descompte (%): ");
        double descompte = scanner.nextDouble();

        double preuFinal = calcularPreuFinal(preuBase, iva, descompte);

        System.out.printf("El preu final és: %.2f\n", preuFinal);

        scanner.close();
    }
}
