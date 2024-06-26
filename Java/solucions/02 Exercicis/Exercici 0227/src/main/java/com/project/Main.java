package com.project;

import java.time.Year;
import java.util.Scanner;

public class Main {

    public static String valida_targeta(int any) {
        int anyActual = Year.now().getValue();
        if (any >= anyActual) {
            return "La targeta és vigent.";
        } else {
            return "La targeta ha caducat.";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introdueix l'any de vigència de la targeta: ");
        int any = scanner.nextInt();

        String resultat = valida_targeta(any);
        System.out.println(resultat);
    }
}
