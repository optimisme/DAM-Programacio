package com.exemple0604;

public class Main {

    public static record Persona(String nom, int edat) {}

    public static void main(String[] args) {

        Persona persona = new Persona("Anna", 25);

        System.out.println("Nom: " + persona.nom());
        System.out.println("Edat: " + persona.edat());

        System.out.println("Crear una nova instància, per modificar l'edat:");

        persona = new Persona(persona.nom(), 28);

        System.out.println("Nom: " + persona.nom());
        System.out.println("Edat: " + persona.edat());
    }
}