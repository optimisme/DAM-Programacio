package com.exercicis;

import java.util.Scanner;

public class Resolt0004 {

    public static int contaMajuscules(String contrasenya) {
        int count = 0;
        for (char c : contrasenya.toCharArray()) {
            if (Character.isUpperCase(c)) {
                count++;
            }
        }
        return count;
    }

    public static int contaMinuscules(String contrasenya) {
        int count = 0;
        for (char c : contrasenya.toCharArray()) {
            if (Character.isLowerCase(c)) {
                count++;
            }
        }
        return count;
    }

    public static String validaContrasenya(String contrasenya) {
        if (contrasenya.length() >= 8 &&
            contaMajuscules(contrasenya) >= 2 &&
            contaMinuscules(contrasenya) >= 2) {
            return "La contrasenya és vàlida";
        } else {
            return "La contrasenya NO és vàlida";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Escriu una contrasenya: ");
        String contrasenya = scanner.nextLine();

        String resultat = validaContrasenya(contrasenya);

        System.out.printf("La contrasenya '%s': %s\n", contrasenya, resultat);

        scanner.close();
    }
}
