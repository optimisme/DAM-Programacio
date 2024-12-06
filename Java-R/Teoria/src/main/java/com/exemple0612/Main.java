package com.exemple0612;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        
        ArrayList<Integer> numeros = new ArrayList<>(Arrays.asList(7, 8, 9, 10, 11));
        
        // Obtenir una llista amb cada valor dividit per 2
        ArrayList<Double> senarsDuplicats = new ArrayList<>(numeros.stream()
            .filter((num) -> {
                // El mòdul de 2 diferent de 0 escull els imparells
                return (num % 2 != 0);
            })
            .map((num) -> {
                // Duplica el valor
                Double rst = num * 2.0;
                return rst;
            })
            .collect(Collectors.toList()));
        
        System.out.println("Imparells duplicats: " + senarsDuplicats);
    }
}