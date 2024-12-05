package com.exemple0607;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(25);
        numeros.add(5);
        numeros.add(15);
        numeros.add(10);

        System.out.println("Abans d'ordenar: " + numeros);

        // Ordenar de menor a major
        numeros.sort((a, b) -> a.compareTo(b));
        System.out.println("De menor a major: " + numeros);

        // Ordenar de major a menor
        numeros.sort((a, b) -> b.compareTo(a));
        System.out.println("De major a menor: " + numeros);
    }
}