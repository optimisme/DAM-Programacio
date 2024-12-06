package com.exemple0611;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        
        ArrayList<Integer> numeros = new ArrayList<>(Arrays.asList(7, 8, 9, 10, 11));
        
        // Obtenir una llista amb cada valor dividit per 2
        ArrayList<Double> meitats = new ArrayList<>(numeros.stream()
            .map((num) -> {
                Double rst = num / 2.0;
                return rst;
            })
            .collect(Collectors.toList()));
        
        System.out.println("Números parells: " + meitats);
    }
}