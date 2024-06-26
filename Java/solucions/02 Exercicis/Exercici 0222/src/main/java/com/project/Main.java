package com.project;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int numero = random.nextInt(101); // Genera un número aleatori entre 0 i 100

        System.out.println("El número escollit és: " + numero);

        if (numero <= 25) {
            System.out.println("El número és petit");
        } else if (numero <= 74) {
            System.out.println("El número és mitjà");
        } else {
            System.out.println("El número és gran");
        }
    }
}
