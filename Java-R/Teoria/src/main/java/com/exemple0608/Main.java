package com.exemple0608;

import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {
        ArrayList<String> noms = new ArrayList<>();
        noms.add("Mario");
        noms.add("Luigi");
        noms.add("Peach");
        noms.add("Bowser");

        System.out.println("Abans d'ordenar: " + noms);

        // Ordenar alfabèticament (ascendent)
        noms.sort((a, b) -> a.compareTo(b));
        System.out.println("De menor a major (alfabètic): " + noms);

        // Ordenar alfabèticament (descendent)
        noms.sort((a, b) -> b.compareTo(a));
        System.out.println("De major a menor (alfabètic): " + noms);
    }
}