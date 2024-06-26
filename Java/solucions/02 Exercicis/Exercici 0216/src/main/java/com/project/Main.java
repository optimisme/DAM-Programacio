package com.project;

import java.util.Scanner;

public class Main {

    public static String[] demana_info(Scanner scanner) {
        System.out.print("Introdueix el títol de la pel·lícula: ");
        String titol = scanner.nextLine();

        System.out.print("Introdueix el director de la pel·lícula: ");
        String director = scanner.nextLine();

        System.out.print("Introdueix l'any de la pel·lícula: ");
        int any = scanner.nextInt();
        scanner.nextLine();  // Consumeix la línia nova que queda després de nextInt()

        return new String[]{titol, director, String.valueOf(any)};
    }

    public static void informacio_peli(String titol, String director, String any) {
        System.out.printf("Títol: %s, Director: %s, Any: %s\n", titol, director, any);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] peli1 = demana_info(scanner);
        String[] peli2 = demana_info(scanner);

        informacio_peli(peli1[0], peli1[1], peli1[2]);
        informacio_peli(peli2[0], peli2[1], peli2[2]);
    }
}
