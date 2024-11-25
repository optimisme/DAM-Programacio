package com.exemple014;

public class Main {

    public static void main(String[] args) {
        // Exemples de transformació des d'un String:
        String textNumero = "123";
        int numeroInt = Integer.parseInt(textNumero); // String a int
        float numeroFloat = Float.parseFloat(textNumero); // String a float
        System.out.println("String a Int: " + numeroInt);
        System.out.println("String a Float: " + numeroFloat);

        // Exemples de transformació des d'un Int:
        int numero = 45;
        float numeroFloat2 = numero; // Int a float (promoció automàtica)
        String numeroString = Integer.toString(numero); // Int a String
        System.out.println("Int a Float: " + numeroFloat2);
        System.out.println("Int a String: " + numeroString);

        // Exemples de transformació des d'un Float:
        float preu = 32.5f;
        int preuInt = (int) preu; // Float a Int (càsting explícit, truncament)
        String preuString = Float.toString(preu); // Float a String
        System.out.println("Float a Int: " + preuInt);
        System.out.println("Float a String: " + preuString);

        // Exemples de transformació des d'un Char:
        char caracter = '7';
        int caracterInt = Character.getNumericValue(caracter); // Char a Int (si és un dígit)
        String caracterString = Character.toString(caracter); // Char a String
        System.out.println("Char a Int: " + caracterInt);
        System.out.println("Char a String: " + caracterString);
    }
}
