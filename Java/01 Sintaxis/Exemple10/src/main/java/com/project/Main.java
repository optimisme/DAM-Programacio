package com.project;

public class Main {
    public static void main(String[] args) {
        try {
            // Intenta executar aquest codi que pot generar una excepció
            int resultat = divideix(10, 0); // Això generarà una ArithmeticException
            System.out.println("Resultat: " + resultat);
        } catch (ArithmeticException e) {
            // Aquest bloc captura només ArithmeticException
            System.out.println("S'ha capturat una ArithmeticException: " + e.getMessage());
        } catch (Exception e) {
            // Aquest bloc captura qualsevol altra Exception
            System.out.println("S'ha capturat una excepció genèrica: " + e.getMessage());
        } finally {
            // Aquest bloc s'executa sempre
            System.out.println("Bloc finally s'executa sempre, independentment de si es captura una excepció o no.");
        }
    }

    public static int divideix(int numerador, int denominador) {
        return numerador / denominador; // Aquesta línia pot generar una ArithmeticException si denominador és 0
    }
}
