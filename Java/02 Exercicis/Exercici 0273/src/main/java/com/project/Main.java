package com.project;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Object[][] ciutats = {
            {0, "Barcelona", 1620343, 12, true},
            {1, "Madrid", 3207247, 667, false},
            {2, "València", 791413, 15, true},
            {3, "Màlaga", 569130, 11, true},
            {4, "Sevilla", 688711, 7, false},
            {5, "Alicante", 330525, 12, true},
            {6, "Zaragoza", 664938, 220, false},
            {7, "Gijón", 275735, 3, true},
            {8, "Palma de Mallorca", 22610, 14, true},
            {9, "Bilbao", 345821, 30, false}
        };

        String[] columnes = {"id", "ciutat", "poblacio", "altitud", "costera"};
        String[] alineacions = {"<", "<", "^", "^", ">"};
        int[] amplades = {3, 10, 10, 8, 6};

        String resultat = escriuTaula(ciutats, columnes, alineacions, amplades);
        System.out.println(resultat);
    }

    public static String escriuTaula(Object[][] dades, String[] columnes, String[] alineacions, int[] amplades) {
        return "";
    }

    public static String formatCell(String text, String alineacio, int amplada) {
        return "";
    }
}
