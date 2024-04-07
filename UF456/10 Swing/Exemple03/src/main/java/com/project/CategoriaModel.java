package com.project;

public class CategoriaModel {
    private int id;
    private String nom;

    // Constructor
    public CategoriaModel(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    // Constructor sense ID per a noves categories que encara no tenen un ID assignat
    public CategoriaModel(String nom) {
        this.nom = nom;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
