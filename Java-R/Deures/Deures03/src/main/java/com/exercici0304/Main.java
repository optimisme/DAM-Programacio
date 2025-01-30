package com.exercici0304;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale defaultLocale = Locale.getDefault();
        Locale.setDefault(Locale.US);

        try {
            NumComplex num1 = new NumComplex(3, 4);
            NumComplex num2 = new NumComplex(1, -2);

            System.out.println("Número complex 1: " + num1);
            System.out.println("Número complex 2: " + num2);

            System.out.println("\nMòdul de num1: " + num1.modul());
            System.out.println("Conjugat de num1: " + num1.conjugat());

            NumComplex suma = NumComplex.suma(num1, num2);
            System.out.println("\nSuma: " + suma);

            NumComplex resta = NumComplex.resta(num1, num2);
            System.out.println("Resta: " + resta);

            NumComplex multiplica = NumComplex.multiplica(num1, num2);
            System.out.println("Multiplicació: " + multiplica);

            try {
                NumComplex divideix = NumComplex.divideix(num1, num2);
                System.out.println("Divisió: " + divideix);
            } catch (ArithmeticException e) {
                System.out.println("Error en la divisió: " + e.getMessage());
            }
        } finally {
            Locale.setDefault(defaultLocale);
        }
    }
}
