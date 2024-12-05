package com.exercicis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Resolt0011 {

    public static ArrayList<String> escullNomsAleatoris(ArrayList<String> noms, int quantitat) {
        
        if (quantitat > noms.size()) {
            throw new IllegalArgumentException("La quantitat no pot ser més gran que " + noms.size() + ".");
        }
    
        ArrayList<String> seleccionats = new ArrayList<>();
        Random random = new Random();

        ArrayList<String> copiaNoms = new ArrayList<>(noms); // Evitar duplicats
        for (int i = 0; i < quantitat; i++) {
            if (copiaNoms.isEmpty()) break;
            int index = random.nextInt(copiaNoms.size());
            seleccionats.add(copiaNoms.remove(index));
        }
    
        return seleccionats;
    }
   
    public static ArrayList<String> nomsAcabenVocal(ArrayList<String> noms) {
        ArrayList<String> resultat = new ArrayList<>();
        for (String nom : noms) {
            char ultimaLletra = nom.toLowerCase().charAt(nom.length() - 1);
            if ("aeiou".indexOf(ultimaLletra) >= 0) {
                resultat.add(nom);
            }
        }
        return resultat;
    }

    public static ArrayList<String> nomsCompostos(ArrayList<String> noms) {
        ArrayList<String> resultat = new ArrayList<>();
        for (String nom : noms) {
            if (nom.contains(" ")) {
                resultat.add(nom);
            }
        }
        return resultat;
    }

    public static void main(String[] args) {

        ArrayList<String> noms = new ArrayList<>(Arrays.asList(
            "Mario", "Princess Peach", "Wario", "Luigi", "Iggy Koopa", "Toad", "Yoshi", "Donkey Kong", "Birdo"
        ));

        // N'escull 5 a l'atzar
        ArrayList<String> nomsAleatoris = escullNomsAleatoris(noms, 5);
        System.out.println("Noms escollits a l'atzar: " + nomsAleatoris);

        // Cas incorrecte
        try {
            ArrayList<String> seleccionatsError = escullNomsAleatoris(noms, 25);
            System.out.println("Noms escollits: " + seleccionatsError);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Noms que acaben amb vocal
        ArrayList<String> nomsVocal = nomsAcabenVocal(noms);
        System.out.println("Noms que acaben amb vocal: " + nomsVocal);

        // Noms compostos
        ArrayList<String> nomsCompostos = nomsCompostos(noms);
        System.out.println("Noms compostos: " + nomsCompostos);
    }
}
