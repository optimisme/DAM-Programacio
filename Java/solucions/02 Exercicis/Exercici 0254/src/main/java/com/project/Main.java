// Main.java
package com.project;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Introdueix una frase:");
        String frase = scanner.nextLine();
        
        double preu = calculaPreuFrase(frase);
        System.out.printf("El preu de la frase '%s' és: %.2f\n", frase, preu);
        
        scanner.close();
    }

    /**
     * Calcula el preu d'una frase segons les regles especificades.
     * @param frase La frase a calcular.
     * @return El preu de la frase.
     */
    public static double calculaPreuFrase(String frase) {
        double preu = 0.0;
        for (char c : frase.toCharArray()) {
            if (Character.isLetter(c)) {
                preu += 0.05;
                if (c == 'a' || c == 'A') {
                    preu += 0.05;
                } else if ("bfhlptv".indexOf(c) != -1) {
                    preu += 0.15;
                } else if ("GJKLMNQZ".indexOf(c) != -1) {
                    preu += 0.30;
                }
            } else if (Character.isDigit(c)) {
                preu += 0.10;
            }
        }
        return preu;
    }
}
