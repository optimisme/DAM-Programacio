package com.exemple0610;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        
        ArrayList<Integer> numeros = new ArrayList<>(Arrays.asList(7, 8, 9, 10, 11));
        
        // Filtrar només els números parells
        ArrayList<Integer> parells = new ArrayList<>(numeros.stream()
            .filter((num) -> {
                // El mòdul de 2 separa els parells
                return (num % 2 == 0);
            })
            .collect(Collectors.toList()));
        
        System.out.println("Números parells: " + parells);
    }
}