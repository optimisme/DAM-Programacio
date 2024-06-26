package com.project;

public class Main {

    public static double calcula_cost_lloc(String tipusLloc) {
        return 0.0;
    }

    public static double calcula_cost_menjar(String tipusMenjar, int numConvidats) {
        return 0.0;
    }

    public static double calcula_cost_entreteniment(String tipusEntreteniment) {
        return 0.0;
    }

    public static double calcula_festa(String tipusLloc, int numConvidats, String tipusMenjar, String... tipusEntreteniment) {
        return 0.0;
    }

    private static boolean contains(String[] array, String value) {
        return 0.0;
    }

    public static void main(String[] args) {
        // Exemples
        System.out.printf("Jardí amb piscina, 40 convidats, menú bàsic, música en directe: %.2f€\n", calcula_festa("jardí amb piscina", 40, "menú bàsic", "música en directe"));
        System.out.printf("Saló gran amb escenari, 70 convidats, menú premium, música en directe: %.2f€\n", calcula_festa("saló gran amb escenari", 70, "menú premium", "música en directe"));
        System.out.printf("Sala estàndard, 15 convidats, menú premium, màgia: %.2f€\n", calcula_festa("sala estàndard", 15, "menú premium", "màgia"));
    }
}
