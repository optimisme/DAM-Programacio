package com.exercici0306;

public class VaixellMercaderies extends Vaixell implements Reglamentari {
    private String paisRegistre;

    public VaixellMercaderies(String nom, double capacitat, String paisRegistre) {
        super(nom, capacitat);
        this.paisRegistre = paisRegistre;
    }

    public String getPaisRegistre() {
        return paisRegistre;
    }

    public void setPaisRegistre(String paisRegistre) {
        this.paisRegistre = paisRegistre;
    }

    @Override
    public boolean compleixNormativa() {
        return getPesTotal() <= capacitat;
    }

    @Override
    public String toString() {
        return "VaixellMercaderies[nom=" + nom + ", capacitat=" + capacitat + ", paisRegistre=" + paisRegistre + "]";
    }
}
