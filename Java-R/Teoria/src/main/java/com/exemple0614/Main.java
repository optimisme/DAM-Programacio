package com.exemple0614;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        // Convertir l'array a una llista per poder fer shuffle
        ArrayList<Integer> numberList = new ArrayList<>(Arrays.stream(numbers)
                                         .boxed() // Converteix int a Integer
                                         .collect(Collectors.toList()));

        Collections.shuffle(numberList); // Barreja aleatòriament

        // Convertir la llista de nou a int[]
        int[] shuffledNumbers = numberList.stream()
                                          .mapToInt(Integer::intValue)
                                          .toArray();

        // Mostrar arrays
        System.out.println("Original: " + Arrays.toString(numbers));
        System.out.println("Barrejat: " + Arrays.toString(shuffledNumbers));
    }
}