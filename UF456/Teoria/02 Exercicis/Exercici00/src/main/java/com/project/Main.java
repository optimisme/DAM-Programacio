package com.project;

public class Main {
    public static void main(String[] args) {
        int x = 1345;
        int y = 64;
        double resultat = (double) x / y; // Convertim a double per obtenir un resultat decimal

        System.out.println("El resultat de la divisió és " + resultat);

        // Utilitzem String.format per arrodonir a 2 decimals
        String resultatArrodonit = String.format("%.2f", resultat);
        System.out.println("El resultat arrodonit de la divisió és " + resultatArrodonit);
    }
}