package com.project;

public class Main {

    public static double calcula_cost_habitacio(String tipusHabitacio, int nits) {
        double costPerNit = 0;
        switch (tipusHabitacio.toLowerCase()) {
            case "estàndard":
                costPerNit = 50;
                break;
            case "amb vistes":
                costPerNit = 70;
                break;
            case "suite":
                costPerNit = 120;
                break;
            default:
                throw new IllegalArgumentException("Tipus d'habitació desconegut: " + tipusHabitacio);
        }
        return costPerNit * nits;
    }

    public static double calcula_cost_esmorzar(int nombrePersones, int nombreDies) {
        double costPerEsmorzar = 10;
        return costPerEsmorzar * nombrePersones * nombreDies;
    }

    public static double calcula_reserva(int nombreNits, String tipusHabitacio, int nombrePersonesEsmorzar) {
        double costHabitacio = calcula_cost_habitacio(tipusHabitacio, nombreNits);
        double costEsmorzar = calcula_cost_esmorzar(nombrePersonesEsmorzar, nombreNits);

        if (tipusHabitacio.equalsIgnoreCase("suite") && nombreNits > 3) {
            costEsmorzar = 0; // Esmorzar gratuït per suite més de 3 nits
        }

        if (nombreNits > 5) {
            costHabitacio *= 0.9; // Descompte del 10% per més de 5 nits
        }

        return costHabitacio + costEsmorzar;
    }

    public static void main(String[] args) {
        // Exemples
        System.out.printf("Habitació estàndard, 4 nits, 2 persones amb esmorzar: %.2f€\n", calcula_reserva(4, "estàndard", 2));
        System.out.printf("Suite amb jacuzzi, 5 nits, 2 persones amb esmorzar: %.2f€\n", calcula_reserva(5, "suite", 2));
        System.out.printf("Habitació amb vistes, 6 nits, 1 persona sense esmorzar: %.2f€\n", calcula_reserva(6, "amb vistes", 0));
    }
}
