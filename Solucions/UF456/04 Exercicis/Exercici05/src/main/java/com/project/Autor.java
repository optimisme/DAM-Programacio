package com.project;

public class Autor {
    private String nom;
    private String nacionalitat;

    public Autor(String nom, String nacionalitat) {
        this.nom = nom;
        this.nacionalitat = nacionalitat;
    }

    // Setters i Getters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNacionalitat() {
        return nacionalitat;
    }

    public void setNacionalitat(String nacionalitat) {
        this.nacionalitat = nacionalitat;
    }
}

