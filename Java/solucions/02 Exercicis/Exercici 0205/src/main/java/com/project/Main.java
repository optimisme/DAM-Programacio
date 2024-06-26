package com.project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quin és el teu pes en kg? ");
        double pes = scanner.nextDouble();

        System.out.print("Quina és la teva altura en metres? ");
        double altura = scanner.nextDouble();

        double imc = pes / (altura * altura);

        System.out.printf("El teu índex de massa corporal (IMC) és %.2f\n", imc);
    }
}
