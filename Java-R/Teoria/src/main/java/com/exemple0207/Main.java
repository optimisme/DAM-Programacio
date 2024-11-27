package com.exemple0207;

public class Main {
    public static void main(String[] args) {

        String plantilla = """
            Nom: %s
            Edat: %d
            Salari: %.2f€""";

        String resultat = plantilla.formatted("Toni", 30, 1900.5);
        System.out.println(resultat);
    }
}
