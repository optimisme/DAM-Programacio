package com.project;

public abstract class Animal {
    protected String nom;
    protected int edat;

    public Animal(String nom, int edat) {
        this.nom = nom;
        this.edat = edat;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{nom='" + nom + '\'' + ", edat=" + edat + '}';
    }
}
