// Main.java
package com.project;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        String[] partsDelDia = {"Matí", "Tarda", "Vespre", "Nit"};
        String[] diesDeLaSetmana = {"Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres", "Dissabte", "Diumenge"};
        String[] mesosDeLAny = {"Gener", "Febrer", "Març", "Abril", "Maig", "Juny", "Juliol", "Agost", "Setembre", "Octubre", "Novembre", "Desembre"};

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
    public static void escriuLlista(String[] llista) {

    }
}
