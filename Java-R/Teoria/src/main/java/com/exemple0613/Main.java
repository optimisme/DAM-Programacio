package com.exemple0613;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<>(Arrays.asList("gat", "gos", "dinosaure", "formiga"));
        Collections.shuffle(animals); // Barreja aleatòriament la llista
        System.out.println(animals);
    }
}