// Main.java
package com.project;

import java.util.Locale;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        long numero = generaNumeroAleatori();
        int[] resultat = calculaNums(numero);
        
        System.out.printf("El número: %d\n", numero);
        System.out.printf("El nombre de números parells: %d\n", resultat[0]);
        System.out.printf("El nombre de números senars: %d\n", resultat[1]);
    }

    /**
     * Genera un número llarg aleatori.
     * @return Un número llarg aleatori.
     */
    public static long generaNumeroAleatori() {
        Random random = new Random();
        return Math.abs(random.nextLong());
    }

    /**
     * Compta el nombre de números parells i senars en un número llarg.
     * @param numero El número llarg a analitzar.
     * @return Un array d'int on el primer element és el nombre de números parells i el segon és el nombre de números senars.
     */
    public static int[] calculaNums(long numero) {
        String numStr = Long.toString(numero);
        int parells = 0;
        int senars = 0;

        for (char c : numStr.toCharArray()) {
            int digit = Character.getNumericValue(c);
            if (digit % 2 == 0) {
                parells++;
            } else {
                senars++;
            }
        }
        
        return new int[]{parells, senars};
    }
}
