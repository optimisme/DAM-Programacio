package com.project;

public class Prestec {
    private Llibre llibre;
    private String dataPrestec;
    private String dataRetorn;

    // Constructor
    public Prestec(Llibre llibre, String dataPrestec, String dataRetorn) {
        this.llibre = llibre;
        this.dataPrestec = dataPrestec;
        this.dataRetorn = dataRetorn;
    }

    // Setters i getters
    public Llibre getLlibre() {
        return llibre;
    }

    public void setLlibre(Llibre llibre) {
        this.llibre = llibre;
    }

    public String getDataPrestec() {
        return dataPrestec;
    }

    public void setDataPrestec(String dataPrestec) {
        this.dataPrestec = dataPrestec;
    }

    public String getDataRetorn() {
        return dataRetorn;
    }

    public void setDataRetorn(String dataRetorn) {
        this.dataRetorn = dataRetorn;
    }

    // Mètode per comprovar si el préstec està en termini
    public boolean estaEnTermini() {
        // Aquesta implementació és simplificada i depèn de la lògica específica de com es compara les dates.
        // Per aquest exemple, simplement retornarem true per simular que sempre està en termini.
        return true;
    }
}

