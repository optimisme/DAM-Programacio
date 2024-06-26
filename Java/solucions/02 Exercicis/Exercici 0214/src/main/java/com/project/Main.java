package com.project;

import java.util.Scanner;

public class Main {

    public static double transformar_km_a_milles(double kilometres) {
        return kilometres * 0.62;
    }

    public static double transformar_milles_a_km(double milles) {
        return milles / 0.62;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entra una distància en kilòmetres: ");
        double kilometres = scanner.nextDouble();

        double milles = transformar_km_a_milles(kilometres);
        System.out.printf("La distància de %.3f kilòmetres en milles és %.3f\n", kilometres, milles);

        double km_recalculats = transformar_milles_a_km(milles);
        System.out.printf("El resultat de tornar a calcular els kilòmetres és: %.3f\n", km_recalculats);
    }
}
