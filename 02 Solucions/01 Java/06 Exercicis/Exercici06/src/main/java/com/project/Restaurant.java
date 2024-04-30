package com.project;

public class Restaurant {
    private String nom;
    private String tipusCuina;
    private int capacitat;

    public Restaurant(String nom, String tipusCuina, int capacitat) {
        this.nom = nom;
        this.tipusCuina = tipusCuina;
        this.capacitat = capacitat;
    }

    // Getters
    public String getNom() { return nom; }
    public String getTipusCuina() { return tipusCuina; }
    public int getCapacitat() { return capacitat; }

    @Override
    public String toString() {
        return "Restaurant[nom=" + nom + ", tipusCuina=" + tipusCuina + ", capacitat=" + capacitat + "]";
    }
}
