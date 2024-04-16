package com.project;

import java.util.ArrayList;
import java.util.List;

public class ReceptaModel {
    private int id;
    private String nom;
    private String temps;
    private String procediment;
    private boolean esFavorita;
    private List<IngredientModel> ingredients;

    public ReceptaModel(int id, String nom, String temps, String procediment, boolean esFavorita) {
        this.id = id;
        this.nom = nom;
        this.temps = temps;
        this.procediment = procediment;
        this.esFavorita = esFavorita;
        this.ingredients = new ArrayList<>();
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

    public String getTemps() {
        return temps;
    }

    public void setTemps(String temps) {
        this.temps = temps;
    }

    public String getProcediment() {
        return procediment;
    }

    public void setProcediment(String procediment) {
        this.procediment = procediment;
    }

    public boolean getEsFavorita() {
        return esFavorita;
    }

    public void setEsFavorita(boolean esFavorita) {
        this.esFavorita = esFavorita;
    }

    public List<IngredientModel> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientModel> ingredients) {
        this.ingredients = ingredients;
    }

    // Mètode per afegir ingredients a la llista
    public void addIngredient(IngredientModel ingredient) {
        this.ingredients.add(ingredient);
    }

    @Override
    public String toString() {
        String text = id + ": " + (nom.length() > 30 ? nom.substring(0, 25) + "..." : nom);
        if (esFavorita) text = text + " ♥";
        return text;
    }
}
