package com.project;

public class Main {
    public static void main(String[] args) {

        // Generació de nombres aleatoris
        double aleatori = Math.random(); // Genera un número aleatori entre 0.0 i 1.0
        
        // Genera un número aleatori entre 0 i 100 tots dos inclosos
        int aleatoriEntre0i100 = (int) (Math.random() * 101); // Cal transformar-lo a enter amb (int)
        
        // Imprimir resultats
        System.out.println("Número aleatori entre 0.0 i 1.0: " + aleatori);
        System.out.println("Número aleatori entre 0 i 100: " + aleatoriEntre0i100);
    }
}
