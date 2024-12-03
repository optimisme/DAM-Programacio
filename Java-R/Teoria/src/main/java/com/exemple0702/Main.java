// Paquet al que pertany aquest codi
package com.exemple0702;

import java.util.List;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        List<String> noms = Arrays.asList("Anna", "Joan", "Maria", "Pere");
        
        for (String nom : noms) {
            System.out.println("Nom: " + nom);
        }
    }
}