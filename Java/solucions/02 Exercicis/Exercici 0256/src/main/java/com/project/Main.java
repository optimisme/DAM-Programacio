// Main.java
package com.project;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        // Exemple per a prova
        porcioTaula(2, 4, 7);
        porcioTaula(5, 3, 5);
    }

    /**
     * Escriu la porció de la taula de multiplicar entre 'inici' i 'final'.
     * @param numero El número per a la taula de multiplicar.
     * @param inici El valor inicial.
     * @param fi El valor final.
     */
    public static void porcioTaula(int numero, int inici, int fi) {
        for (int i = inici; i <= fi; i++) {
            System.out.printf("%d x %d = %d\n", i, numero, i * numero);
        }
    }
}
