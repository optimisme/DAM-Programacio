package com.project;

public class Main {

    public static double calculaOperacio(double num1, double num2, String operacio) {
        switch (operacio.toLowerCase()) {
            case "suma":
                return num1 + num2;
            case "resta":
                return num1 - num2;
            case "multiplicació":
                return num1 * num2;
            case "divisió":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    throw new IllegalArgumentException("No es pot dividir per zero.");
                }
            default:
                throw new IllegalArgumentException("Operació no vàlida: " + operacio);
        }
    }

    public static void main(String[] args) {
        double[] num1 = {2, 3, 5, 10};
        double[] num2 = {3, 4, 2, 2};
        String[] operacions = {"suma", "multiplicació", "resta", "divisió"};

        for (int i = 0; i < operacions.length; i++) {
            double resultat = calculaOperacio(num1[i], num2[i], operacions[i]);
            System.out.printf("El resultat de %s entre %.2f i %.2f és %.2f\n", operacions[i], num1[i], num2[i], resultat);
        }
    }
}
