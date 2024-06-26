package com.project;

import java.util.Arrays;

public class Main {

    public static boolean son_anagrama(String paraula1, String paraula2) {
        // Treu tots els espais en blanc de les paraules i passa-les a minúscules
        String processedParaula1 = paraula1.replace(" ", "").toLowerCase();
        String processedParaula2 = paraula2.replace(" ", "").toLowerCase();

        // Ordena les lletres de les paraules
        char[] lletresParaula1 = processedParaula1.toCharArray();
        char[] lletresParaula2 = processedParaula2.toCharArray();
        Arrays.sort(lletresParaula1);
        Arrays.sort(lletresParaula2);

        // Compara si els dos resultats anteriors són iguals
        return Arrays.equals(lletresParaula1, lletresParaula2);
    }

    public static void main(String[] args) {
        String[][] paraules = {
            {"Mare", "Rema"},
            {"Porta", "Tropa"},
            {"Triangle", "Integral"},
            {"Sopa", "Posa"},
            {"Casa", "Sopa"},
            {"Gat", "Perro"}
        };

        for (String[] parell : paraules) {
            boolean resultat = son_anagrama(parell[0], parell[1]);
            System.out.printf("Són les paraules '%s' i '%s' anagrames? %b\n", parell[0], parell[1], resultat);
        }
    }
}
