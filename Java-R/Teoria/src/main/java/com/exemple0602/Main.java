package com.exemple0602;

import java.util.HashMap;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        // Crear un HashMap
        HashMap<String, Integer> puntuacions = new HashMap<>();

        // Afegir parelles clau-valor
        puntuacions.put("Anna", 85);
        puntuacions.put("Joan", 92);
        puntuacions.put("Maria", 78);

        // Accedir a un valor
        System.out.println("Puntuació de Joan: " + puntuacions.get("Joan"));

        // Obtenir totes les claus
        Set<String> claus = puntuacions.keySet();
        System.out.println("Totes les claus: " + claus);

        // Eliminar un element
        puntuacions.remove("Maria");
        System.out.println("Després d'eliminar Maria: " + puntuacions);

        // Obtenir les claus després d'eliminar
        claus = puntuacions.keySet();
        System.out.println("Claus després de l'eliminació: " + claus);
    }
}