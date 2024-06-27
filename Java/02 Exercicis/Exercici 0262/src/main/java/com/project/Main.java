// Main.java
package com.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        ArrayList<String> partsDelDia = new ArrayList<>(Arrays.asList("Matí", "Tarda", "Vespre", "Nit"));
        ArrayList<String> diesDeLaSetmana = new ArrayList<>(Arrays.asList("Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres", "Dissabte", "Diumenge"));
        ArrayList<String> mesosDeLAny = new ArrayList<>(Arrays.asList("Gener", "Febrer", "Març", "Abril", "Maig", "Juny", "Juliol", "Agost", "Setembre", "Octubre", "Novembre", "Desembre"));

        System.out.println("Parts del dia:");
        escriuLlista(partsDelDia);
        System.out.println("\nDies de la setmana:");
        escriuLlista(diesDeLaSetmana);
        System.out.println("\nMesos de l'any:");
        escriuLlista(mesosDeLAny);
    }

    /**
     * Escriu una llista d'elements, indicant la posició i el valor.
     * @param llista La llista d'elements a escriure.
     */
    public static void escriuLlista(ArrayList<String> llista) {

    }
}
