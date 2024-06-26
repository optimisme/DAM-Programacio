package com.project;

import java.util.Scanner;

public class Main {

    public static boolean valida_contrasenya(String contrasenya) {
        if (contrasenya.length() < 5 || contrasenya.length() > 10) {
            return false;
        }

        int majuscules = 0;
        int minuscules = 0;
        int numeros = 0;

        for (char c : contrasenya.toCharArray()) {
            if (Character.isUpperCase(c)) {
                majuscules++;
            } else if (Character.isLowerCase(c)) {
                minuscules++;
            } else if (Character.isDigit(c)) {
                numeros++;
            }
        }

        return majuscules >= 2 && minuscules >= 3 && numeros >= 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introdueix una contrasenya: ");
        String contrasenya = scanner.nextLine();

        if (valida_contrasenya(contrasenya)) {
            System.out.println("Contrasenya vàlida");
        } else {
            System.out.println("Contrasenya no vàlida");
        }
    }
}
