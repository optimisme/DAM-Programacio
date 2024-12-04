package com.exercicis;

import java.util.Locale;

public class Resolt0006 {

    public static double calculaEntrada(int numeroAdults, int numNens, int numGrans, String dia) {
        // Preus base
        double preuAdult = 10.0;
        double preuNen = 5.0;
        double preuGran = 6.0;

        // Calcula el preu estàndard
        double total = (numeroAdults * preuAdult) + (numNens * preuNen) + (numGrans * preuGran);

        // Aplicar descompte del 20% dimarts (Dia del client)
        if (dia.equalsIgnoreCase("dimarts")) {
            total *= 0.8; // Reduir el preu total un 20%
        }

        // Aplicar tarifes especials per dijous (Dia familiar)
        else if (dia.equalsIgnoreCase("dijous") && numNens > 0 && numeroAdults > 0) {
            total -= preuNen * 0.5; // 50% de descompte per al primer nen
            total -= preuNen * (numNens - 1); // Els altres nens no paguen
        }

        return total;
    }

    public static void main(String[] args) {

        String template = "%-35s%.2f€";

        System.out.println(String.format(Locale.US, template, "Cas 1 (2 adults, 2 nens, 1 gran):", calculaEntrada(2, 2, 1, "dimarts")));
        System.out.println(String.format(Locale.US, template, "Cas 2 (1 adult,  2 nens, 0 grans):", calculaEntrada(1, 2, 0, "dijous")));
        System.out.println(String.format(Locale.US, template, "Cas 3 (0 adults, 0 nens, 2 grans):", calculaEntrada(0, 0, 2, "dissabte")));
        System.out.println(String.format(Locale.US, template, "Cas 4 (1 adult,  0 nens, 0 grans):", calculaEntrada(1, 0, 0, "diumenge")));
        System.out.println(String.format(Locale.US, template, "Cas 5 (1 adult,  3 nens, 4 grans):", calculaEntrada(1, 3, 4, "dijous")));
        System.out.println(String.format(Locale.US, template, "Cas 6 (2 adults, 2 nens, 1 gran):", calculaEntrada(2, 2, 1, "diumenge")));
    }
}
