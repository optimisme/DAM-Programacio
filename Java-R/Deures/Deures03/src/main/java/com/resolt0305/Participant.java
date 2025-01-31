package com.resolt0305;

public class Participant {
    protected String nom;
    protected int edat;

    public Participant(String nom, int edat) {
        this.nom = nom;
        this.edat = edat;
    }

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

    @Override
    public String toString() {
        return "Participant[nom=" + nom + ", edat=" + edat + "]";
    }
}
