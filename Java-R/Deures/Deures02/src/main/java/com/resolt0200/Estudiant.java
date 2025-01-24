package com.resolt0200;

public class Estudiant {
    // Atributs privats d'instància
    private String nom;
    private String id;

    // Atributs privats estàtics
    private static int comptadorEstudiants = 0;
    private static final int CAPACITAT_MAXIMA = 5;

    // Constructor
    public Estudiant(String nom, String id) {
        if (comptadorEstudiants < CAPACITAT_MAXIMA) {
            this.nom = nom;
            this.id = id;
            comptadorEstudiants++;
        } else {
            System.out.println("Error: No es poden registrar més estudiants. Capacitat màxima assolida.");
        }
    }

    // Getters i Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Mètodes públics estàtics
    public static int getComptadorEstudiants() {
        return comptadorEstudiants;
    }

    public static boolean hiHaCapacitat() {
        return comptadorEstudiants < CAPACITAT_MAXIMA;
    }
}
