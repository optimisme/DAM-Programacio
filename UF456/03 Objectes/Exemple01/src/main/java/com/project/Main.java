package com.project;

public class Main {
    public static void main(String[] args) {
        Persona joan = new Persona("Joan", 25);
        
        joan.setNom("Juanito");
        joan.setEdat(40);

        
        System.out.println(joan.toString()); // Imprimeix "Nom: Joanito, Edat: 40"
        System.out.println(joan.getNom()); // Imprimeix "Juanito"
    }
}
