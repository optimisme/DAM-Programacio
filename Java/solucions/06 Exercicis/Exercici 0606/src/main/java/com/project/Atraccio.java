package com.project;

public class Atraccio {
    private String nom;
    private String tipus;
    private int alturaMinima;

    public Atraccio(String nom, String tipus, int alturaMinima) {
        this.nom = nom;
        this.tipus = tipus;
        this.alturaMinima = alturaMinima;
    }

    // Getters
    public String getNom() { return nom; }
    public String getTipus() { return tipus; }
    public int getAlturaMinima() { return alturaMinima; }

    @Override
    public String toString() {
        return "Atraccio[nom=" + nom + ", tipus=" + tipus + ", alturaMinima=" + alturaMinima + "]";
    }
}