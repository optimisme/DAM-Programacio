package com.exercici0305;

public class Jugador extends Participant implements Esportista, Competidor {

    public Jugador(String nom, int edat, String equip) {
        super(nom, edat);
    }

    public String getEquip() {
        return "";
    }

    public void setEquip(String value) {
    }

    public void entrenar() {
    }

    public void competir() {
    }

    @Override
    public String toString() {
        return "";
    }
}
