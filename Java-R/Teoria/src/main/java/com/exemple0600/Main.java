package com.exemple0600;

public class Main {

    public static void main(String[] args) {
        // Declaració i inicialització d'un array
        int[] numeros = {10, 20, 30, 40, 50};

        // Accés a elements
        System.out.println("Element a l'índex [0]: " + numeros[0]);
        System.out.println("Element a l'índex [1]: " + numeros[1]);

        numeros[1] = 25;
        System.out.println("Modificar [1] a 25 ... ");
        System.out.println("Element a l'índex [1]: " + numeros[1]);

        // Obtenir la posició de l'últim element
        int ultimaPosicio = numeros.length - 1;
        System.out.println("Últim element: " + numeros[ultimaPosicio]);
    }
}