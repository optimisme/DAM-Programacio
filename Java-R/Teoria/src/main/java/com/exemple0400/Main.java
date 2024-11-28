package com.exemple0400;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Demanar tres números a l'usuari
        System.out.print("Escriu el primer número: ");
        int num1 = scanner.nextInt();

        System.out.print("Escriu el segon número: ");
        int num2 = scanner.nextInt();

        System.out.print("Escriu el tercer número: ");
        int num3 = scanner.nextInt();

        // Determinar el més gran amb operadors ternaris
        int max = (num1 > num2) ? 
                     ((num1 > num3) ? num1 : num3) : 
                     ((num2 > num3) ? num2 : num3);

        // Mostrar el resultat
        System.out.println("El número més gran és: " + max);

        scanner.close();
    }
}

