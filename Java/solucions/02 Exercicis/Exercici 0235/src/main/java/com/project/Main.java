package com.project;

public class Main {

    public static double calcula_cost_lloc(String tipusLloc) {
        switch (tipusLloc.toLowerCase()) {
            case "sala estàndard":
                return 100;
            case "jardí amb piscina":
                return 200;
            case "saló gran amb escenari":
                return 500;
            default:
                throw new IllegalArgumentException("Tipus de lloc desconegut: " + tipusLloc);
        }
    }

    public static double calcula_cost_menjar(String tipusMenjar, int numConvidats) {
        double costPerConvidat = 0;
        switch (tipusMenjar.toLowerCase()) {
            case "menú bàsic":
                costPerConvidat = 15;
                break;
            case "menú premium":
                costPerConvidat = 30;
                break;
            default:
                throw new IllegalArgumentException("Tipus de menjar desconegut: " + tipusMenjar);
        }

        double costTotal = costPerConvidat * numConvidats;

        if (numConvidats > 50) {
            costTotal *= 0.95; // Descompte del 5% per més de 50 persones
        }

        return costTotal;
    }

    public static double calcula_cost_entreteniment(String tipusEntreteniment) {
        switch (tipusEntreteniment.toLowerCase()) {
            case "màgia":
                return 250;
            case "música en directe":
                return 500;
            default:
                throw new IllegalArgumentException("Tipus d'entreteniment desconegut: " + tipusEntreteniment);
        }
    }

    public static double calcula_festa(String tipusLloc, int numConvidats, String tipusMenjar, String... tipusEntreteniment) {
        double costLloc = calcula_cost_lloc(tipusLloc);
        double costMenjar = calcula_cost_menjar(tipusMenjar, numConvidats);

        double costEntreteniment = 0;
        for (String entreteniment : tipusEntreteniment) {
            costEntreteniment += calcula_cost_entreteniment(entreteniment);
        }

        if (tipusLloc.equalsIgnoreCase("saló gran amb escenari") && contains(tipusEntreteniment, "música en directe")) {
            costEntreteniment -= 100; // Descompte de 100€ en l'entreteniment
        }

        return costLloc + costMenjar + costEntreteniment;
    }

    private static boolean contains(String[] array, String value) {
        for (String element : array) {
            if (element.equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Exemples
        System.out.printf("Jardí amb piscina, 40 convidats, menú bàsic, música en directe: %.2f€\n", calcula_festa("jardí amb piscina", 40, "menú bàsic", "música en directe"));
        System.out.printf("Saló gran amb escenari, 70 convidats, menú premium, música en directe: %.2f€\n", calcula_festa("saló gran amb escenari", 70, "menú premium", "música en directe"));
        System.out.printf("Sala estàndard, 15 convidats, menú premium, màgia: %.2f€\n", calcula_festa("sala estàndard", 15, "menú premium", "màgia"));
    }
}
