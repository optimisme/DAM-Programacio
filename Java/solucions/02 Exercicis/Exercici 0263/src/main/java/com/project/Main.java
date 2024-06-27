// Main.java
package com.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        String[] numerosArray = {"4", "5", "6", "7"};
        List<Integer> numerosList = convertirArray(numerosArray);
        System.out.println("Convertit des d'array: " + numerosList);

        ArrayList<String> numerosArrayList = new ArrayList<>(Arrays.asList("4", "5", "6", "7"));
        List<Integer> numerosList2 = convertirLlista(numerosArrayList);
        System.out.println("Convertit des de llista: " + numerosList2);
    }

    /**
     * Converteix un array de cadenes de text en una llista de números.
     * @param numeros L'array de cadenes de text.
     * @return La llista de números.
     */
    public static List<Integer> convertirArray(String[] numeros) {
        return Arrays.stream(numeros)
                     .map(Integer::parseInt)
                     .collect(Collectors.toList());
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
