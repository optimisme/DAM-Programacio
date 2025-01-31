package com.exercici0306;

import java.util.ArrayList;

public class Port {
    private String nom;
    private ArrayList<Vaixell> vaixells;

    public Port(String nom) {
        this.nom = nom;
        this.vaixells = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void afegirVaixell(Vaixell v) {
        vaixells.add(v);
    }

    public ArrayList<Vaixell> getVaixells() {
        return vaixells;
    }

    public void printVaixells() {
        for (int i = 0; i < vaixells.size(); i++) {
            System.out.println(vaixells.get(i));
        }
    }

    public ArrayList<String> validarNormatives() {
        ArrayList<String> resultats = new ArrayList<>();
        for (Vaixell v : vaixells) {
            if (v instanceof Reglamentari) {
                resultats.add(v.nom + " (" + v.getClass().getSimpleName() + "): " +
                        (((Reglamentari) v).compleixNormativa() ? "Normatiu" : "NO normatiu"));
            }
        }
        return resultats;
    }

    public void printNormatives() {
        ArrayList<String> normatives = validarNormatives();
        for (int i = 0; i < normatives.size(); i++) {
            System.out.println(normatives.get(i));
        }
    }    

    @Override
    public String toString() {
        return "Port[nom=" + nom + ", vaixells=" + vaixells.size() + "]";
    }
}
