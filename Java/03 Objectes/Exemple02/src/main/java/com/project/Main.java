package com.project;

public class Main {
    public static void main(String[] args) {
        
        Calculadora calc0 = new Calculadora(2, 3);
        Calculadora calc1 = new Calculadora(20, 30);

        System.out.println(calc0); // Escriu: Compartit:0; a = 2; b = 3
        System.out.println(calc1); // Escriu: Compartit:0; a = 20; b = 30

        Calculadora.valorCompartit = 2;

        System.out.println(calc0); // Escriu: Compartit:2; a = 2; b = 3
        System.out.println(calc1); // Escriu: Compartit:2; a = 20; b = 30

        System.out.println("Suma calc0: " + calc0.sumaValorsInstancia()); // Escriu: Suma calc0: 5
        System.out.println("Suma calc1: " + calc1.sumaValorsInstancia()); // Escriu: Suma calc1: 50
        System.out.println("Calculadora.sumaValors(5,5): " + Calculadora.sumaValors(5,5)); 
        // Escriu: Calculadora.sumaValors(5,5): 10
    }
}
