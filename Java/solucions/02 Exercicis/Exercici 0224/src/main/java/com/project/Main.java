package com.project;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introdueix una xifra entre 0 i 100.000: ");
        int importInicial = scanner.nextInt();

        double impostos;
        double total;
        int percentatge;

        if (importInicial < 10000) {
            percentatge = 10;
        } else if (importInicial <= 50000) {
            percentatge = 20;
        } else {
            percentatge = 30;
        }

        impostos = importInicial * percentatge / 100.0;
        total = importInicial + impostos;

        System.out.printf("Per un import de %d, els impostos que has de pagar són un %d%% i el total és %.2f\n", 
                          importInicial, percentatge, total);
    }
}
