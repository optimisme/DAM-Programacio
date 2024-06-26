package com.project;

public class Main {
    public static void main(String[] args) {
        // Cridar la funció que utilitza un bucle while
        int limit = 4;
        System.out.println("Comptar fins a " + limit + " amb un bucle while:");
        comptarAmbWhile(limit);
        
        // Cridar la funció que utilitza un bucle for
        int inici = 2;
        int fi = 6;
        System.out.println("Imprimir números parells entre " + inici + " i " + fi + " amb un bucle for:");
        imprimirParellsAmbFor(inici, fi);
    }

    // Funció que utilitza un bucle while per comptar fins a un número donat
    public static void comptarAmbWhile(int limit) {
        int i = 1; // Començar a comptar des de 1
        while (i <= limit) {
            System.out.println(i);
            i++; // Incrementar el contador
        }
    }

    // Funció que utilitza un bucle for per imprimir tots els números parells dins d'un rang específic
    public static void imprimirParellsAmbFor(int inici, int fi) {
        for (int i = inici; i <= fi; i++) {
            if (i % 2 == 0) { // Comprovar si el número és parell
                System.out.println(i);
            }
        }
    }
}
