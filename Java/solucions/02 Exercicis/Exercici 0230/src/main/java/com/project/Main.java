package com.project;

import java.util.Scanner;

public class Main {

    public static double calcula_irpf(double ingressos) {
        double irpf = 0;

        if (ingressos <= 12450) {
            irpf = ingressos * 0.19;
        } else if (ingressos <= 20200) {
            irpf = 12450 * 0.19 + (ingressos - 12450) * 0.24;
        } else if (ingressos <= 35200) {
            irpf = 12450 * 0.19 + (20200 - 12450) * 0.24 + (ingressos - 20200) * 0.30;
        } else if (ingressos <= 60000) {
            irpf = 12450 * 0.19 + (20200 - 12450) * 0.24 + (35200 - 20200) * 0.30 + (ingressos - 35200) * 0.37;
        } else if (ingressos <= 300000) {
            irpf = 12450 * 0.19 + (20200 - 12450) * 0.24 + (35200 - 20200) * 0.30 + (60000 - 35200) * 0.37 + (ingressos - 60000) * 0.45;
        } else {
            irpf = 12450 * 0.19 + (20200 - 12450) * 0.24 + (35200 - 20200) * 0.30 + (60000 - 35200) * 0.37 + (300000 - 60000) * 0.45 + (ingressos - 300000) * 0.47;
        }

        return irpf;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introdueix els ingressos bruts: ");
        double ingressos = scanner.nextDouble();

        double irpf = calcula_irpf(ingressos);
        System.out.printf("L'IRPF a pagar per uns ingressos de %.2f€ és %.2f€\n", ingressos, irpf);
    }
}
