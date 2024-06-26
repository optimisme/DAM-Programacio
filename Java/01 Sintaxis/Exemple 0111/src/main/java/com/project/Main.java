package com.project;

public class Main {
    public static void main(String[] args) {
        try {
            // Comprova alguna condició i llança una excepció si es compleix
            int edat = -1; // Suposem que aquest valor s'ha obtingut d'algun lloc
            if (edat < 0) {
                throw new IllegalArgumentException("L'edat no pot ser negativa");
            }
        } catch (IllegalArgumentException e) {
            // Captura l'excepció específica llançada anteriorment
            System.out.println("S'ha capturat una excepció: " + e.getMessage());
        }
    }
}
