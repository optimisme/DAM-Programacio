package com.exercici0306;

public class VaixellMercaderies extends Vaixell implements Reglamentari {

    public VaixellMercaderies(String nom, double capacitat, String paisRegistre) {
        super(nom, capacitat);
    }

    public String getPaisRegistre() {
        return "";
    }

    public void setPaisRegistre(String value) {
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
