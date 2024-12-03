package com.exemple0800;

public class Main {

    public static void main(String[] args) {
        try {
            int result = 10 / 0; // Llança ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Error: Divisió per zero");
        } finally {
            System.out.println("Bloc finally executat.");
        }
    }
}