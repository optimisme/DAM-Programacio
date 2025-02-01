package com.exercici0306;

public class VaixellPassatgers extends Vaixell implements Reglamentari {

    public VaixellPassatgers(String nom, double capacitat, int maxPassatgers) {
        super(nom, capacitat);
    }

    public int getNumPassatgers() {
        return 0;
    }

    public void setNumPassatgers(int value) {
    }

    public int getMaxPassatgers() {
        return 0;
    }

    public void setMaxPassatgers(int value) {
    }

    public void afegirPassatger() {
    }

    @Override
    public boolean compleixNormativa() {
        return false;
    }

    @Override
    public String toString() {
        return "";
    }
}
