package com.project;

import java.util.Scanner;

public class Main {

    public static double calcula_tarifa(int minuts, int sms) {
        double costFix = 15.0;
        int minutsGratuits = 200;
        int smsGratuits = 50;
        double costPerMinut = 0.10;
        double costPerSms = 0.05;

        double costTotal = costFix;

        if (minuts > minutsGratuits) {
            costTotal += (minuts - minutsGratuits) * costPerMinut;
        }

        if (sms > smsGratuits) {
            costTotal += (sms - smsGratuits) * costPerSms;
        }

        return costTotal;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introdueix el nombre de minuts parlats: ");
        int minuts = scanner.nextInt();

        System.out.print("Introdueix el nombre de SMS enviats: ");
        int sms = scanner.nextInt();

        double tarifa = calcula_tarifa(minuts, sms);
        System.out.printf("El cost mensual de la factura és %.2f€\n", tarifa);
    }
}
