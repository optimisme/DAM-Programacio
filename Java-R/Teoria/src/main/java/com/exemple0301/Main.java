package com.exemple0301;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Demanar el número del dia a l'usuari
        System.out.print("Escriu un número del 1 al 7 per representar un dia de la setmana: ");
        int dia = scanner.nextInt();

        // Determinar el dia de la setmana amb un switch
        switch (dia) {
            case 1:
                System.out.println("Dilluns");
                break;
            case 2:
                System.out.println("Dimarts");
                break;
            case 3:
                System.out.println("Dimecres");
                break;
            case 4:
                System.out.println("Dijous");
                break;
            case 5:
                System.out.println("Divendres");
                break;
            case 6:
            case 7:
                System.out.println("Cap de setmana");
                break;
            default:
                System.out.println("Número no vàlid. Has d'escriure un valor entre 1 i 7.");
                break;
        }

        scanner.close();
    }
}
