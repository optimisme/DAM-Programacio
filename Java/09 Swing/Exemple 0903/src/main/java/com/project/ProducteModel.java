package com.project;

public class ProducteModel {
    private int id;
    private String nom;
    private String descripcio;
    private double preu;
    private int categoriaId;

    // Constructor complet
    public ProducteModel(int id, String nom, String descripcio, double preu, int categoriaId) {
        this.id = id;
        this.nom = nom;
        this.descripcio = descripcio;
        this.preu = preu;
        this.categoriaId = categoriaId;
    }

    // Constructor sense ID per a nous productes que encara no tenen un ID assignat
    public ProducteModel(String nom, String descripcio, double preu, int categoryId) {
        this.nom = nom;
        this.descripcio = descripcio;
        this.preu = preu;
        this.categoriaId = categoryId;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public double getPreu() {
        return preu;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String name) {
        this.nom = name;
    }

    public void setDescripcio(String description) {
        this.descripcio = description;
    }

    public void setPreu(double price) {
        this.preu = price;
    }

    public void setCategoriaId(int categoryId) {
        this.categoriaId = categoryId;
    }
}


