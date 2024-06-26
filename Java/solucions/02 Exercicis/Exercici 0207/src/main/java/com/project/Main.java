package com.project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introdueix la primera nota: ");
        double nota1 = scanner.nextDouble();

        System.out.print("Introdueix la segona nota: ");
        double nota2 = scanner.nextDouble();

        System.out.print("Introdueix la tercera nota: ");
        double nota3 = scanner.nextDouble();

        double mitjana = (nota1 + nota2 + nota3) / 3;

        System.out.printf("La nota mitjana entre %.2f, %.2f, %.2f és %.2f\n", nota1, nota2, nota3, mitjana);
    }
}
