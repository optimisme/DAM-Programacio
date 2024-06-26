package com.project;

public class Main {

    public static double calcula_cost_habitacio(String tipusHabitacio, int nits) {
        return 0.0;
    }

    public static double calcula_cost_esmorzar(int nombrePersones, int nombreDies) {
        return 0.0;
    }

    public static double calcula_reserva(int nombreNits, String tipusHabitacio, int nombrePersonesEsmorzar) {
        return 0.0;
    }

    public static void main(String[] args) {
        // Exemples
        System.out.printf("Habitació estàndard, 4 nits, 2 persones amb esmorzar: %.2f€\n", calcula_reserva(4, "estàndard", 2));
        System.out.printf("Suite amb jacuzzi, 5 nits, 2 persones amb esmorzar: %.2f€\n", calcula_reserva(5, "suite", 2));
        System.out.printf("Habitació amb vistes, 6 nits, 1 persona sense esmorzar: %.2f€\n", calcula_reserva(6, "amb vistes", 0));
    }
}
