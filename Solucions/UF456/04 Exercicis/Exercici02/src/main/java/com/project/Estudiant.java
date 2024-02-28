package com.project;

public class Estudiant {
    private String nom;
    private String id;

    private static int comptadorEstudiants = 0;
    private static final int CAPACITAT_MAXIMA = 5;

    public Estudiant(String nom, String id) {
        if (hiHaCapacitat()) {
            this.nom = nom;
            this.id = id;
            comptadorEstudiants++;
        } else {
            System.out.println("No es pot registrar l'estudiant. La capacitat màxima ha estat assolida.");
            // Aquí es podria llançar una excepció o manejar d'alguna altra manera segons el disseny del sistema.
        }
    }

    // Getters i Setters per 'nom' i 'id'
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

    // Mètodes Estàtics
    public static int getComptadorEstudiants() {
        return comptadorEstudiants;
    }

    public static boolean hiHaCapacitat() {
        return comptadorEstudiants < CAPACITAT_MAXIMA;
    }
}

