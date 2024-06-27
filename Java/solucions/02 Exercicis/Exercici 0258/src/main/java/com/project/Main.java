// Main.java
package com.project;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        mostrarTaula();
    }

    /**
     * Mostra una taula de coordenades (x, y) utilitzant dos bucles anidats.
     */
    public static void mostrarTaula() {
        StringBuilder rst = new StringBuilder();
        for (int y = 0; y <= 5; y++) {
            for (int x = 0; x <= 5; x++) {
                rst.append(x).append(",").append(y).append(" ");
            }
            rst.setLength(rst.length() - 1); // Eliminar l'últim espai
            if (y != 5) { // Afegir un salt de línia si no és l'última línia
                rst.append("\n");
            }
        }
        System.out.print(rst.toString());
    }
}
