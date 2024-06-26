package com.project;

public class Main {

    public static double[] operacions_aritmetiques(double a, double b) {
        double suma = a + b;
        double resta = a - b;
        double multiplicacio = a * b;
        double divisio = a / b;
        return new double[]{suma, resta, multiplicacio, divisio};
    }

    public static void mostrar_resultats(double a, double b, double suma, double resta, double multiplicacio, double divisio) {
        System.out.printf("%.0f + %.0f = %.0f, %.0f - %.0f = %.0f, %.0f * %.0f = %.0f, %.0f / %.0f = %.0f\n", 
            a, b, suma, a, b, resta, a, b, multiplicacio, a, b, divisio);
    }

    public static void main(String[] args) {
        double a = 2;
        double b = 4;
        
        double[] resultats = operacions_aritmetiques(a, b);
        mostrar_resultats(a, b, resultats[0], resultats[1], resultats[2], resultats[3]);
    }
}
