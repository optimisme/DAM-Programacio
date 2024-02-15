package com.project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
    
        // Demanar a l'usuari la seva edat
        System.out.println("Introdueix la teva edat:");
        int edat = scanner.nextInt();

        // Comprovar si la persona pot conduir basant-se en la seva edat
        if (edat >= 18 && edat <= 80) {
            System.out.println("Pots conduir.");
        } else if (edat > 80) {
            System.out.println("No pots conduir per raons de seguretat.");
        } else {
            System.out.println("No pots conduir perquè no tens l'edat suficient.");
        }

        // Tancar el scanner
        scanner.close();
    }
}
