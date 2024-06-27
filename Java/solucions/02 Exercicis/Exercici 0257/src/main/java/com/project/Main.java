// Main.java
package com.project;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        // Exemple per a prova
        taulesSumar(3, 4);
        taulesSumar(5, 7);
    }

    /**
     * Escriu les taules de sumar des de la taula inicial fins a la taula final, per valors entre 0 i 4.
     * @param taulaInicial La taula inicial.
     * @param taulaFinal La taula final.
     */
    public static void taulesSumar(int taulaInicial, int taulaFinal) {
        for (int i = taulaInicial; i <= taulaFinal; i++) {
            for (int j = 0; j <= 4; j++) {
                System.out.printf("%d + %d = %d\n", i, j, i + j);
            }
            System.out.println("-----");
        }
    }
}
