package com.project;

import java.util.Scanner;

public class Main {

    public static double calcula_consum(int litres) {
        double costFix = 10.0;
        int litresGratuits = 1000;
        double costTotal = costFix;

        if (litres > litresGratuits) {
            litres -= litresGratuits;

            if (litres <= 4000) {
                costTotal += litres * 0.02;
            } else {
                costTotal += 4000 * 0.02;
                litres -= 4000;

                if (litres <= 5000) {
                    costTotal += litres * 0.03;
                } else {
                    costTotal += 5000 * 0.03;
                    litres -= 5000;
                    costTotal += litres * 0.05;
                }
            }
        }

        return costTotal;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introdueix el nombre de litres consumits: ");
        int litres = scanner.nextInt();

        double cost = calcula_consum(litres);
        System.out.printf("La factura d'aigua per %d litres és %.2f€\n", litres, cost);
    }
}
