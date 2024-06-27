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
        if (columnes.length != alineacions.length || columnes.length != amplades.length) {
            return "Error: Les llistes han de tenir la mateixa longitud.";
        }

        String taula = "";
        int numFiles = dades.length;

        // Crea línia horitzontal
        String separador = "";
        for (int amplada : amplades) {
            separador = separador + "-".repeat(amplada + 2) + "-";
        }
        separador = separador + "-\n";
        taula = taula + separador;

        // Afegeix capçalera
        taula = taula + "|";
        for (int i = 0; i < columnes.length; i++) {
            taula = taula + formatCell(columnes[i], alineacions[i], amplades[i]) + "|";
        }
        taula = taula + "\n" + separador;

        // Afegeix dades
        for (int i = 0; i < numFiles; i++) {
            taula = taula + "|";
            for (int j = 0; j < columnes.length; j++) {
                taula = taula + formatCell(dades[i][j].toString(), alineacions[j], amplades[j]) + "|";
            }
            taula = taula + "\n";
        }
        taula = taula + separador;
        taula = taula.substring(0, taula.length() - 1);

        return taula;
    }

    public static String formatCell(String text, String alineacio, int amplada) {
        if (text.length() > amplada) {
            text = text.substring(0, amplada);
        }

        String rst;
        switch (alineacio) {
            case "<":
                rst = String.format(" %-" + amplada + "s ", text);
                break;
            case ">":
                rst = String.format(" %" + amplada + "s ", text);
                break;
            case "^":
                rst = String.format(" %" + amplada + "s ", text);
                break;
            default:
                rst = text;
                break;
        }
        return rst;
    }
}
