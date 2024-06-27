// Main.java
package com.project;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Escriu el teu nom: ");
        String nom = scanner.nextLine();
        escriuNomVertical(nom);
        scanner.close();
    }

    /**
     * Escriu cada lletra del nom en una línia diferent.
     * @param nom El nom de l'usuari.
     */
    public static void escriuNomVertical(String nom) {
        for (int i = 0; i < nom.length(); i++) {
            System.out.println(nom.charAt(i));
        }
    }
}
