package com.resolt0306;

public class Carrega {
    protected String descripcio;
    protected double pes;

    public Carrega(String descripcio, double pes) {
        this.descripcio = descripcio;
        this.pes = pes;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public double getPes() {
        return pes;
    }

    public void setPes(double pes) {
        this.pes = pes;
    }

    @Override
    public String toString() {
        return "Carrega[descripcio=" + descripcio + ", pes=" + pes + "]";
    }
}
