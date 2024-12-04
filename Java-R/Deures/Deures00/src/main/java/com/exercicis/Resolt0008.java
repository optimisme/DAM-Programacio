package com.exercicis;

import java.util.ArrayList;
import java.util.Scanner;

public class Resolt0008 {

    public static ArrayList<Integer> generaImparells(int numero) {
        ArrayList<Integer> imparells = new ArrayList<>();
        
        for (int i = 3; i <= numero; i += 2) {
            imparells.add(i);
        }
        
        return imparells;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introdueix un número: ");
        int numero = scanner.nextInt();

        if (numero <= 2) {
            System.out.println("No hi ha nombres imparells entre 2 i " + numero);
        } else {
            ArrayList<Integer> imparells = generaImparells(numero);
            System.out.println("Nombres imparells entre 2 i " + numero + ": " + imparells);
        }

        scanner.close();
    }
}
