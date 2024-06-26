package com.project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Longitud de la primera base: ");
        double base1 = scanner.nextDouble();

        System.out.print("Longitud de la segona base: ");
        double base2 = scanner.nextDouble();

        System.out.print("Altura: ");
        double altura = scanner.nextDouble();

        double area = (base1 + base2) * altura / 2;
        System.out.printf("L'àrea del trapèzi és: %.2f\n", area);

        // Intercanvi de les bases utilitzant una variable temporal
        double temp = base1;
        base1 = base2;
        base2 = temp;

        double areaIntercanviada = (base1 + base2) * altura / 2;
        System.out.printf("L'àrea del trapèzi amb les bases intercanviades és: %.2f\n", areaIntercanviada);
    }
}
