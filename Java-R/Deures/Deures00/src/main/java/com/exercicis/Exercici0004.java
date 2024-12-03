package com.exercicis;

import java.util.Scanner;

public class Exercici0004 {

    public static int contaMajuscules(String contrasenya) {
        /*
            TODO: Resol aquí la funció
        */
        return 0;
    }

    public static int contaMinuscules(String contrasenya) {
        /*
            TODO: Resol aquí la funció
        */
        return 0;
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

        /*
            TODO: Resol aquí l'exercici
        */
        scanner.close();
    }
}
