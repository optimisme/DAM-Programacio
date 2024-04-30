package com.project;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Crear un HashMap
        Map<String, String> diccionari = new HashMap<>();
        diccionari.put("clau1", "valor1");
        diccionari.put("clau2", "valor2");

        // Modificar el valor d'una clau
        diccionari.put("clau1", "valorModificat");

        // Obtenir el valor d'una clau
        String valor = diccionari.get("clau1");
        System.out.println("Valor de 'clau1': " + valor);

        // Afegir i treure elements d'un diccionari
        diccionari.put("clau3", "valor3"); // Afegir
        diccionari.remove("clau2"); // Treure

        // Un diccionari que conté altres elements tipus diccionari
        Map<String, Map<String, String>> diccionariNinot = new HashMap<>();
        diccionariNinot.put("subDiccionari", diccionari);

        // Copiar completament diccionaris a una nova variable
        Map<String, String> diccionariCopia = new HashMap<>(diccionari);

        // Mirar el nombre d'elements d'un diccionari
        System.out.println("Nombre d'elements: " + diccionari.size());

        // Obtenir una llista amb les claus
        Set<String> claus = diccionari.keySet();
        System.out.println("Claus: " + claus);

        // Obtenir una llista amb els valors
        List<String> valors = new ArrayList<>(diccionari.values());
        System.out.println("Valors: " + valors);

        // Buscar una clau a partir d'un valor
        String clauBuscada = diccionari.entrySet().stream()
            .filter(entry -> "valorModificat".equals(entry.getValue()))
            .map(Map.Entry::getKey)
            .findFirst()
            .orElse(null);
        System.out.println("Clau que té com a valor 'valorModificat': " + clauBuscada);

        // Obtenir una llista amb totes les claus que compleixen una condició
        List<String> clausAmbValor3 = diccionari.entrySet().stream()
            .filter(entry -> entry.getValue().contains("3"))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
        System.out.println("Claus amb valors que contenen '3': " + clausAmbValor3);
    }
}
