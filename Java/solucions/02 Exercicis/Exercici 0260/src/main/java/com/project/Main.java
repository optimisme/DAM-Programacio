// Main.java
package com.project;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        mostrarMultiplesDe7();
    }

    /**
     * Mostra i compta els múltiples de 7 entre 1 i 1000.
     */
    public static void mostrarMultiplesDe7() {
        int count = 0;
        StringBuilder multiples = new StringBuilder();
        for (int i = 1; i <= 1000; i++) {
            if (i % 7 == 0) {
                multiples.append(i).append(", ");
                count++;
            }
        }
        // Eliminar l'última coma i espai
        if (multiples.length() > 0) {
            multiples.setLength(multiples.length() - 2);
        }
        System.out.println("Multiples de 7 entre 1 i 1000:");
        System.out.println(multiples.toString());
        System.out.println("Total: " + count);
    }
}
