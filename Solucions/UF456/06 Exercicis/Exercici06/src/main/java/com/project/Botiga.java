package com.project;

public class Botiga {
    private String nom;
    private String tipusProducte;

    public Botiga(String nom, String tipusProducte) {
        this.nom = nom;
        this.tipusProducte = tipusProducte;
    }

    // Getters
    public String getNom() { return nom; }
    public String getTipusProducte() { return tipusProducte; }

    @Override
    public String toString() {
        return "Botiga[nom=" + nom + ", tipusProducte=" + tipusProducte + "]";
    }
}
