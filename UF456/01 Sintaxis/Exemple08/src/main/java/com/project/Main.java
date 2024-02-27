package com.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        // EXEMPLE AMB ARRAYS

        // Array numèric
        Integer[] arrayNumeric = new Integer[]{5, 10, 15, 20, 25, 30, 35, 40};

        // Modificar un element d'un array
        arrayNumeric[2] = 100; // Canvia el valor de l'element a la posició 2 per 100
        System.out.println("Array amb element modificat: " + Arrays.toString(arrayNumeric));

        // Longitud de l'array
        System.out.println("Longitud de l'array numèric: " + arrayNumeric.length);

        // Obtenir subarray (això no es pot fer directament com amb subList, cal copiar)
        Integer[] subArrayNumeric = Arrays.copyOfRange(arrayNumeric, 2, 5);
        System.out.println("Subarray numèric: " + Arrays.toString(subArrayNumeric));

        // No es pot "eliminar" elements d'un array directament. Cal crear un nou array sense els elements desitjats.
        // Per aquest exemple, simplificarem el procés i no eliminarem elements per aquest mètode.

        // Dividir en dos
        Integer[] primeraMeitatX = Arrays.copyOfRange(arrayNumeric, 0, arrayNumeric.length / 2);
        Integer[] segonaMeitatX = Arrays.copyOfRange(arrayNumeric, arrayNumeric.length / 2, arrayNumeric.length);
        System.out.println("Primera meitat: " + Arrays.toString(primeraMeitatX));
        System.out.println("Segona meitat: " + Arrays.toString(segonaMeitatX));

        // Afegir elements a un array requereix crear un nou array i copiar els elements existents.
        // Per simplificar, no demostrarem aquesta part aquí.

        // Buscar el màxim número en un array
        Integer maxim = Arrays.stream(arrayNumeric).max(Integer::compare).orElse(null);
        System.out.println("Màxim número: " + maxim);

        // Ordenar l'array
        Arrays.sort(arrayNumeric);
        System.out.println("Array ordenat: " + Arrays.toString(arrayNumeric));

        // Buscar un element en un array
        boolean existeix = Arrays.asList(arrayNumeric).contains(15);
        System.out.println("L'array conté el número 15? " + existeix);

        // Agafar elements de manera aleatòria
        Random rand = new Random();
        Integer elementAleatori = arrayNumeric[rand.nextInt(arrayNumeric.length)];
        System.out.println("Element aleatori de l'array numèric: " + elementAleatori);

        // Array de text
        String[] arrayText = new String[]{"Poma", "Plàtan", "Taronja", "Pinya"};

        // Afegir i treure elements d'un array de text no és directe com amb ArrayList.
        // Ordenar l'array de text
        Arrays.sort(arrayText);
        String fruitaAleatoria = arrayText[rand.nextInt(arrayText.length)]; // Aleatori
        System.out.println("Array de text ordenat: " + Arrays.toString(arrayText));
        System.out.println("Fruita aleatòria de l'array de text: " + fruitaAleatoria);

        // EXEMPLE AMB LLISTES

        // Llista numèrica
        List<Integer> llistaNumericaX = new ArrayList<>(Arrays.asList(5, 10, 15, 20, 25, 30, 35, 40));

        // Modificar un element d'una llista
        llistaNumericaX.set(2, 100); // Canvia el valor de l'element a la posició 2 per 100
        System.out.println("Llista amb element modificat: " + llistaNumericaX);

        // Longitud de la llista
        System.out.println("Longitud de la llista numèrica: " + llistaNumericaX.size());

        // Obtenir subllista
        List<Integer> subllistaNumerica = llistaNumericaX.subList(2, 5);
        System.out.println("Subllista numèrica: " + subllistaNumerica);

        // Escurçar la llista (eliminar elements)
        llistaNumericaX.removeIf(n -> (n > 20)); // Elimina tots els elements majors que 20
        System.out.println("Llista escurçada: " + llistaNumericaX);

        // Dividir en dos (exemple simplificat)
        List<Integer> primeraMeitat = new ArrayList<>(llistaNumericaX.subList(0, llistaNumericaX.size()/2));
        List<Integer> segonaMeitat = new ArrayList<>(llistaNumericaX.subList(llistaNumericaX.size()/2, llistaNumericaX.size()));
        System.out.println("Primera meitat: " + primeraMeitat);
        System.out.println("Segona meitat: " + segonaMeitat);

        // Ajuntar múltiples llistes
        List<Integer> novaLlista = new ArrayList<>(primeraMeitat);
        novaLlista.addAll(segonaMeitat);
        System.out.println("Llista ajuntada: " + novaLlista);

        // Buscar el màxim número en una llista
        Integer maximX = Collections.max(llistaNumericaX);
        System.out.println("Màxim número: " + maximX);

        // Ordenar la llista
        Collections.sort(llistaNumericaX);
        System.out.println("Llista ordenada: " + llistaNumericaX);

        // Afegir i treure elements d'una llista
        llistaNumericaX.add(50); // Afegir al final
        llistaNumericaX.remove(Integer.valueOf(10)); // Treure un element específic
        System.out.println("Llista modificada: " + llistaNumericaX);

        // Buscar un element en una llista
        boolean existeixX = llistaNumericaX.contains(15);
        System.out.println("La llista conté el número 15? " + existeixX);

        // Agafar elements de manera aleatòria
        Integer elementAleatoriX = llistaNumericaX.get(rand.nextInt(llistaNumericaX.size()));
        System.out.println("Element aleatori de la llista numèrica: " + elementAleatoriX);

        // Llista de text
        List<String> llistaTextX = new ArrayList<>(Arrays.asList("Cotxe", "Moto", "Carretó", "Avió"));

        // Operacions similars amb llista de text
        llistaTextX.add("Vaixell"); // Afegir
        llistaTextX.remove("Carretó"); // Treure
        Collections.sort(llistaTextX); // Ordenar
        String fruitaAleatoriaX = llistaTextX.get(rand.nextInt(llistaTextX.size())); // Aleatori
        System.out.println("Llista de text ordenada i modificada: " + llistaTextX);
        System.out.println("Fruita aleatòria de la llista de text: " + fruitaAleatoriaX);
    }
}
