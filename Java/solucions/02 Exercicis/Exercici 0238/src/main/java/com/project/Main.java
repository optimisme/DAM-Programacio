package com.project;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int opcio;

        do {
            System.out.println("Menú:");
            System.out.println("1. Saluda");
            System.out.println("2. Parla");
            System.out.println("3. Sortir");
            System.out.print("Escull una opció: ");
            opcio = scanner.nextInt();

            switch (opcio) {
                case 1:
                    System.out.println("Hola!");
                    break;
                case 2:
                    String[] frases = {
                        "Tinc un gos que es diu Pelut",
                        "M'agrada menjar xocolata",
                        "Vull vitajar al Japó"
                    };
                    int index = random.nextInt(frases.length);
                    System.out.println(frases[index]);
                    break;
                case 3:
                    System.out.println("Sortint...");
                    break;
                default:
                    System.out.println("Opció no vàlida, si us plau, tria una altra.");
                    break;
            }
        } while (opcio != 3);
    }
}
