package com.project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double suma = 0.0;
        System.out.println("Introdueix un número (decimals amb .) o escriu 'sortir' per acabar:");

        while (true) {
            System.out.print("La suma actual és " + suma + "\nIntrodueix un número o 'sortir': ");
            String input = scanner.nextLine();

            if ("sortir".equalsIgnoreCase(input)) {
                System.out.println("Finalitzant l'aplicació. La suma final és " + suma);
                break;
            }

            try {
                double numero = Double.parseDouble(input);
                suma += numero;
                // Aquesta línia que neteja el terminal no funcionarà a Java de manera estàndard
                // i s'ha omès de l'exemple.
            } catch (NumberFormatException e) {
                System.out.println("Escriu un número o 'sortir'");
            }
        }

        scanner.close();
    }
}