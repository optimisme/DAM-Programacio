package com.exemple1200;

public class Persona {
    
    // Atributs (informació de l'objecte)
    private String nom; // Nom de la persona
    private int edat; // Edat de la persona

    // Constructor (crea un objecte de la classe "Persona")
    public Persona(String nom, int edat) {
        this.nom = nom;
        this.edat = edat;
    }

    // Funció aniversari (suma un 1 a l'edat)
    public void aniversari() {
        edat++;
    }

    // Funció toString (override per imprimir el nom i edat de l'objecte)
    @Override
    public String toString() {
        return "Nom: " + this.nom + ", Edat: " + this.edat;
    }
}