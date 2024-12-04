package com.exercicis;

import java.util.Locale;

public class Resolt0007 {

    public static double calculaCostLloc(String tipusLloc) {
        return switch (tipusLloc.toLowerCase()) {
            case "sala estàndard" -> 100.0;
            case "jardí amb piscina" -> 200.0;
            case "saló gran amb escenari" -> 500.0;
            default -> throw new IllegalArgumentException("Tipus de lloc desconegut: " + tipusLloc);
        };
    }

    public static double calculaCostMenjar(String tipusMenjar, int numConvidats) {
        double preuPerConvidat = switch (tipusMenjar.toLowerCase()) {
            case "menú bàsic" -> 15.0;
            case "menú premium" -> 30.0;
            default -> throw new IllegalArgumentException("Tipus de menú desconegut: " + tipusMenjar);
        };

        double totalMenjar = preuPerConvidat * numConvidats;

        if (numConvidats > 50) {
            totalMenjar *= 0.95; // Aplicar un 5% de descompte
        }

        return totalMenjar;
    }

    public static double calculaCostEntreteniment(String tipusEntreteniment) {
        return switch (tipusEntreteniment.toLowerCase()) {
            case "màgia" -> 250.0;
            case "música en directe" -> 500.0;
            case "cap" -> 0.0; // Sense entreteniment
            default -> throw new IllegalArgumentException("Tipus d'entreteniment desconegut: " + tipusEntreteniment);
        };
    }

    public static double calculaFesta(String tipusLloc, String tipusMenjar, String tipusEntreteniment, int numConvidats) {
        double costLloc = calculaCostLloc(tipusLloc);
        double costMenjar = calculaCostMenjar(tipusMenjar, numConvidats);
        double costEntreteniment = calculaCostEntreteniment(tipusEntreteniment);

        // Aplicar promoció si el lloc és "saló gran amb escenari" i l'entreteniment és "música en directe"
        if (tipusLloc.equalsIgnoreCase("saló gran amb escenari") && tipusEntreteniment.equalsIgnoreCase("música en directe")) {
            costEntreteniment -= 100.0; // Descompte de 100€
        }

        return costLloc + costMenjar + costEntreteniment;
    }

    public static void main(String[] args) {

        String template = "%-75s%.2f€";

        // Validar amb exemples
        System.out.println(String.format(Locale.US, template, "Cas 1 (\"sala estàndard\", \"menú bàsic\", \"cap\", 20):", calculaFesta("sala estàndard", "menú bàsic", "cap", 20)));
        System.out.println(String.format(Locale.US, template, "Cas 2 (\"jardí amb piscina\", \"menú premium\", \"màgia\", 60):", calculaFesta("jardí amb piscina", "menú premium", "màgia", 60)));
        System.out.println(String.format(Locale.US, template, "Cas 3 (\"jardí amb piscina\", \"menú bàsic\", \"música en directe\", 40):", calculaFesta("jardí amb piscina", "menú bàsic", "música en directe", 40)));
        System.out.println(String.format(Locale.US, template, "Cas 4 (\"saló gran amb escenari\", \"menú premium\", \"música en directe\", 70):", calculaFesta("saló gran amb escenari", "menú premium", "música en directe", 70)));
        System.out.println(String.format(Locale.US, template, "Cas 5 (\"sala estàndard\", \"menú premium\", \"màgia\", 15):", calculaFesta("sala estàndard", "menú premium", "màgia", 15)));
    }
}
