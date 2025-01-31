package com.resolt0305;

public class Arbitre extends Participant implements Competidor {
    private String nivell;

    public Arbitre(String nom, int edat, String nivell) {
        super(nom, edat);
        this.nivell = nivell;
    }

    public String getNivell() {
        return nivell;
    }

    public void setNivell(String nivell) {
        this.nivell = nivell;
    }

    @Override
    public void competir() {
        System.out.println("Supervisant competició");
    }

    @Override
    public String toString() {
        return "Arbitre[nom=" + nom + ", edat=" + edat + ", nivell=" + nivell + "]";
    }
}
