package com.exemple0802;

public class Main {

    public static void verificarEdat(int edat) throws IllegalArgumentException {
        if (edat < 18) {
            throw new IllegalArgumentException("Edat no vàlida: Cal ser major de 18 anys.");
        }
    }

    public static void main(String[] args) {

        try {
            // Exemple d'una edat no vàlida
            Main.verificarEdat(16);

            // No es mostra perquè falla al '16'
            System.out.println("Edat vàlida."); 
        } catch (IllegalArgumentException e) {

            // Gestiona l'excepció
            System.out.println("Error: " + e.getMessage()); 
        } finally {

            // S'executa sempre
            System.out.println("Verificació completada."); 
        }
    }
}