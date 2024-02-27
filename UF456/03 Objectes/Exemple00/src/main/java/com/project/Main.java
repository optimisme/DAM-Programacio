package com.project;

public class Main {
    public static void main(String[] args) {
        Persona joan = new Persona("Joan", 25);
        Persona eva = new Persona("Eva", 28);
        
        System.out.println(joan.toString()); // Imprimeix "Nom: Joan, Edat: 25"
        System.out.println(eva.toString()); // Imprimeix "Nom: Eva, Edat: 28"
        
        joan.aniversari(); // Suma un 1 a l'edat de "joan"
        eva.aniversari(); // Suma un 1 a l'edat de "eva"
        
        System.out.println(joan.toString()); // Imprimeix "Nom: Joan, Edat: 26"
        System.out.println(eva.toString()); // Imprimeix "Nom: Eva, Edat: 29"
    }
}
