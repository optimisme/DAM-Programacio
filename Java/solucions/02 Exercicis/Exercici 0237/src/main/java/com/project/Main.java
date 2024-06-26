package com.project;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numUsuari;

        do {
            System.out.print("Escriu un número entre 0 i 10: ");
            numUsuari = scanner.nextInt();
        } while (numUsuari < 0 || numUsuari > 10);

        System.out.printf("Has introduït un número vàlid: %d\n", numUsuari);
    }
}
