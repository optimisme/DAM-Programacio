package com.project;

public class Main {
    
    public static void main(String[] args) {
        // Cridar la funció que imprimeix "Hello, World!"
        imprimirSalutacio();

        // Cridar la funció que realitza una suma i imprimir el resultat
        int suma = sumar(5, 7);
        System.out.println("La suma de 5 i 7 és: " + suma);
    }

    // Funció sense paràmetres que imprimeix "Hello, World!" i no retorna res (void)
    public static void imprimirSalutacio() {
        System.out.println("Hello, World!");
    }

    // Funció amb paràmetres que realitza una suma i retorna un 'int' com a resultat
    public static int sumar(int num1, int num2) {
        return num1 + num2;
    }
}
