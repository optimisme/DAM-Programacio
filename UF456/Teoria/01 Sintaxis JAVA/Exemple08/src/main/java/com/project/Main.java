package com.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Llista numèrica
        List<Integer> llistaNumerica = new ArrayList<>(Arrays.asList(5, 10, 15, 20, 25, 30, 35, 40));

        // Modificar un element d'una llista
        llistaNumerica.set(2, 100); // Canvia el valor de l'element a la posició 2 per 100
        System.out.println("Llista amb element modificat: " + llistaNumerica);

        // Longitud de la llista
        System.out.println("Longitud de la llista numèrica: " + llistaNumerica.size());

        // Obtenir subllista
        List<Integer> subllistaNumerica = llistaNumerica.subList(2, 5);
        System.out.println("Subllista numèrica: " + subllistaNumerica);

        // Escurçar la llista (eliminar elements)
        llistaNumerica.removeIf(n -> (n > 20)); // Elimina tots els elements majors que 20
        System.out.println("Llista escurçada: " + llistaNumerica);

        // Dividir en dos (exemple simplificat)
        List<Integer> primeraMeitat = new ArrayList<>(llistaNumerica.subList(0, llistaNumerica.size()/2));
        List<Integer> segonaMeitat = new ArrayList<>(llistaNumerica.subList(llistaNumerica.size()/2, llistaNumerica.size()));
        System.out.println("Primera meitat: " + primeraMeitat);
        System.out.println("Segona meitat: " + segonaMeitat);

        // Ajuntar múltiples llistes
        List<Integer> novaLlista = new ArrayList<>(primeraMeitat);
        novaLlista.addAll(segonaMeitat);
        System.out.println("Llista ajuntada: " + novaLlista);

        // Buscar el màxim número en una llista
        Integer maxim = Collections.max(llistaNumerica);
        System.out.println("Màxim número: " + maxim);

        // Ordenar la llista
        Collections.sort(llistaNumerica);
        System.out.println("Llista ordenada: " + llistaNumerica);

        // Afegir i treure elements d'una llista
        llistaNumerica.add(50); // Afegir al final
        llistaNumerica.remove(Integer.valueOf(10)); // Treure un element específic
        System.out.println("Llista modificada: " + llistaNumerica);

        // Buscar un element en una llista
        boolean existeix = llistaNumerica.contains(15);
        System.out.println("La llista conté el número 15? " + existeix);

        // Agafar elements de manera aleatòria
        Random rand = new Random();
        Integer elementAleatori = llistaNumerica.get(rand.nextInt(llistaNumerica.size()));
        System.out.println("Element aleatori de la llista numèrica: " + elementAleatori);

        // Llista de text
        List<String> llistaText = new ArrayList<>(Arrays.asList("Poma", "Plàtan", "Taronja", "Pinya"));

        // Operacions similars amb llista de text
        llistaText.add("Mango"); // Afegir
        llistaText.remove("Plàtan"); // Treure
        Collections.sort(llistaText); // Ordenar
        String fruitaAleatoria = llistaText.get(rand.nextInt(llistaText.size())); // Aleatori
        System.out.println("Llista de text ordenada i modificada: " + llistaText);
        System.out.println("Fruita aleatòria de la llista de text: " + fruitaAleatoria);
    }
}
