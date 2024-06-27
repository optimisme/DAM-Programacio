// Main.java
package com.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introdueix una frase:");
        String input = scanner.nextLine();
        List<String> paraules = Arrays.asList(input.split(" "));

        List<String> ordenadesAscendent = ordenaParaulesPerLongitud(paraules, true);
        List<String> ordenadesDescendent = ordenaParaulesPerLongitud(paraules, false);

        System.out.println("Paraules ordenades de menys a més lletres: " + ordenadesAscendent);
        System.out.println("Paraules ordenades de més a menys lletres: " + ordenadesDescendent);
    }

    /**
     * Ordena una llista de paraules per longitud.
     * @param paraules La llista de paraules.
     * @param ascendent Si és true, ordena de menys a més lletres, si és false, ordena de més a menys lletres.
     * @return La llista de paraules ordenades.
     */
    public static List<String> ordenaParaulesPerLongitud(List<String> paraules, boolean ascendent) {
        return null;
    }
}
