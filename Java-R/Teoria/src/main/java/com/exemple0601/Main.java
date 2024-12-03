package com.exemple0601;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Crear una llista d'enters
        ArrayList<Integer> numeros = new ArrayList<>();

        // Afegir elements
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);

        // Mostrar elements
        System.out.println("Elements: " + numeros);

        // Eliminar un element
        numeros.remove(1); // Elimina el segon element (índex 1)
        System.out.println("Després d'eliminar: " + numeros);

        // Modificar un element
        numeros.set(0, 15);
        System.out.println("Després de modificar: " + numeros);

        // Mostrar elements per separat
        System.out.println("Element a l'índex [0]: " + numeros.get(0));
        System.out.println("Element a l'índex [1]: " + numeros.get(1));
    }
}