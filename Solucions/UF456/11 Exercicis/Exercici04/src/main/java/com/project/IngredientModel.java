package com.project;

public class IngredientModel {
    private int id;
    private String nom;
    private String quantitat;
    private int receptaId; // Referència a la recepta a la qual pertany l'ingredient

    public IngredientModel(int id, String nom, String quantitat, int receptaId) {
        this.id = id;
        this.nom = nom;
        this.quantitat = quantitat;
        this.receptaId = receptaId;
    }

    // Mètodes getters i setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getQuantitat() {
        return quantitat;
    }

    public void setQuantitat(String quantitat) {
        this.quantitat = quantitat;
    }

    public int getReceptaId() {
        return receptaId;
    }

    public void setReceptaId(int receptaId) {
        this.receptaId = receptaId;
    }
}
