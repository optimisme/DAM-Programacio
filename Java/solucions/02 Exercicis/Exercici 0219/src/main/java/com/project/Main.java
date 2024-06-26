package com.project;

public class Main {

    public static String esParell(int numero) {
        if (numero % 2 == 0) {
            return numero + " és parell";
        }
        return numero + " és imparell";
    }

    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int numero : numeros) {
            String resultat = esParell(numero);
            System.out.println(resultat);
        }
    }
}
