package com.project;

public abstract class Empleat {
    protected String nom;
    protected String identificador;

    public Empleat(String nom, String identificador) {
        this.nom = nom;
        this.identificador = identificador;
    }

    @Override
    public String toString() {
        return "Empleat{nom='" + nom + "', identificador='" + identificador + "'}";
    }
}

