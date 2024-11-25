package com.exemple011;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Iniciar la capacitat de 
        // llegir informació del teclat
        Scanner scanner = new Scanner(System.in);

        // Llegir informació del teclat
        // i guardar-la en una variable 'nom'
        System.out.print("Escriu el teu nom: ");
        String nom = scanner.nextLine();

        System.out.println("Hola, " + nom + "!");
        
        // Tancar la lectura del teclat
        scanner.close();
    }
}
