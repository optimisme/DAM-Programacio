package com.project;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random();
        int numeroSecret = rand.nextInt(10);
        Scanner scanner = new Scanner(System.in);
        int intents = 0;
        int numUsuari;

        do {
            System.out.print("Escriu un número entre 0 i 9: ");
            numUsuari = scanner.nextInt();
            intents++;

            if (numUsuari == numeroSecret) {
                System.out.printf("Felicitats, has encertat amb %d intents\n", intents);
            } else if (numUsuari > numeroSecret) {
                System.out.printf("Has escrit %d, el número secret és més petit\n", numUsuari);
            } else {
                System.out.printf("Has escrit %d, el número secret és més gran\n", numUsuari);
            }
        } while (numUsuari != numeroSecret);
    }
}
