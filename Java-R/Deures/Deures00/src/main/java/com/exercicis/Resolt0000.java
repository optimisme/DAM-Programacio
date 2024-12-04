package com.exercicis;

import java.util.Scanner;

public class Resolt0000 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Escriu el primer número: ");
        int x = scanner.nextInt();

        System.out.print("Escriu el segon número: ");
        int y = scanner.nextInt();

        int z = x - y;

        System.out.println("El resultat de calcular " + x + " - " + y + " és " + z);

        scanner.close();
    }
}
