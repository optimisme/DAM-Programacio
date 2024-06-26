package com.project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcio = 0;

        System.out.println("        ********Menú Principal********");
        System.out.println("        1.                Veure perfil");
        System.out.println("        2.         Canviar contrasenya");
        System.out.println("        3.                      Sortir");

        while (opcio != 3) {
            System.out.print("Escull una opció: ");
            opcio = scanner.nextInt();

            switch (opcio) {
                case 1:
                    System.out.println("Veure perfil (1)");
                    break;
                case 2:
                    System.out.println("Canviar contrasenya (2)");
                    break;
                case 3:
                    System.out.println("Sortir (3)");
                    break;
                default:
                    System.out.println("Opció no vàlida");
            }

            if (opcio != 3) {
                System.out.print("Escull una opció: ");
            }

        };
    }
}
