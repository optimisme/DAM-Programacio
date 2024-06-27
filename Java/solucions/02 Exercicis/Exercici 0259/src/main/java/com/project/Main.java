// Main.java
package com.project;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            mostrarMenu();
            System.out.print("Opció: ");
            int opcio = scanner.nextInt();
            if (opcio == 0) {
                break;
            }
            switch (opcio) {
                case 1:
                    operar(scanner, "Sumar");
                    break;
                case 2:
                    operar(scanner, "Restar");
                    break;
                case 3:
                    operar(scanner, "Multiplicar");
                    break;
                case 4:
                    operar(scanner, "Dividir");
                    break;
                default:
                    System.out.println("Opció incorrecta");
            }
        }
        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("    CALCULADORA");
        System.out.println("    Menú Principal");
        System.out.println("    1 - Sumar");
        System.out.println("    2 - Restar");
        System.out.println("    3 - Multiplicar");
        System.out.println("    4 - Dividir");
        System.out.println("    0 - Sortir");
    }

    public static void operar(Scanner scanner, String operacio) {
        double[] nums = obtenirNumeros(scanner);
        double num1 = nums[0];
        double num2 = nums[1];
        double resultat = 0;
        
        switch (operacio) {
            case "Sumar":
                resultat = num1 + num2;
                break;
            case "Restar":
                resultat = num1 - num2;
                break;
            case "Multiplicar":
                resultat = num1 * num2;
                break;
            case "Dividir":
                if (num2 == 0) {
                    System.out.println("Error: No es pot dividir per zero.");
                    return;
                } else {
                    resultat = num1 / num2;
                }
                break;
        }
        
        System.out.printf("El resultat de %s %f i %f és: %f\n", operacio, num1, num2, resultat);
    }

    public static double[] obtenirNumeros(Scanner scanner) {
        System.out.print("Introdueix el primer número: ");
        double num1 = scanner.nextDouble();
        System.out.print("Introdueix el segon número: ");
        double num2 = scanner.nextDouble();
        return new double[]{num1, num2};
    }
}
