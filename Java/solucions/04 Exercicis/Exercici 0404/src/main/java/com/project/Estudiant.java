package com.project;

public class Estudiant {
    private String nom;
    private int edat;
    private double notaMitjana;

    // Constructor
    public Estudiant(String nom, int edat) {
        this.nom = nom;
        this.edat = edat;
        this.notaMitjana = 0.0; // Inicialitzar amb 0 per defecte
    }

    // Setters i Getters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public double getNotaMitjana() {
        return notaMitjana;
    }

    // Actualitza la nota mitjana de l'estudiant
    public void actualitzaNotaMitjana(double novaNota) {
        this.notaMitjana = calculaNotaMitjana(novaNota);
    }

    // Funció privada per calcular la nova nota mitjana
    private double calculaNotaMitjana(double novaNota) {
        // Aquesta és una implementació simple per exemple.
        // Es podria modificar per calcular la mitjana de manera més complexa.
        return (this.notaMitjana + novaNota) / 2;
    }
}

