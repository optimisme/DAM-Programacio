// Main.java
package com.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        ArrayList<String> numeros = new ArrayList<>();
        numeros.add("4");
        numeros.add("5");
        numeros.add("6");
        numeros.add("7");

        List<Integer> numerosList = convertirLlista(numeros);
        System.out.println("Convertit des de llista: " + numerosList);
    }

    /**
     * Converteix una llista de cadenes de text en una llista de números.
     * @param numeros La llista de cadenes de text.
     * @return La llista de números.
     */
    public static List<Integer> convertirLlista(ArrayList<String> numeros) {
        return numeros.stream()
                      .map(Integer::parseInt)
                      .collect(Collectors.toList());
    }
}
