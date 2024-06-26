package com.project;

public class Main {

    public static double calcula_interessos(double capital, double interes, int mesos) {
        return capital * interes * mesos / 100.0;
    }

    public static void main(String[] args) {
        double[][] casosDeProva = {
            {1000, 5, 10},
            {2500, 3, 12},
            {7464, 4, 14},
            {10000, 2, 24}
        };

        for (double[] cas : casosDeProva) {
            double capital = cas[0];
            double interes = cas[1];
            int mesos = (int) cas[2];
            double resultat = calcula_interessos(capital, interes, mesos);
            System.out.printf("Per un capital de %.2f€, un interès del %.2f%% i %d mesos, els interessos són %.2f€\n",
                              capital, interes, mesos, resultat);
        }
    }
}
