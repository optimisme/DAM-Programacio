package com.resolt0305;

public class Jugador extends Participant implements Esportista, Competidor {
    private String equip;

    public Jugador(String nom, int edat, String equip) {
        super(nom, edat);
        this.equip = equip;
    }

    public String getEquip() {
        return equip;
    }

    public void setEquip(String equip) {
        this.equip = equip;
    }

    @Override
    public void entrenar() {
        System.out.println("Entrenant com a jugador");
    }

    @Override
    public void competir() {
        System.out.println("Competint com a jugador");
    }

    @Override
    public String toString() {
        return "Jugador[nom=" + nom + ", edat=" + edat + ", equip=" + equip + "]";
    }
}
