package com.project;

public class Revista extends Publicacio {
    private int numeroEdicio;

    public Revista(String titol, int anyPublicacio, int numeroEdicio) {
        super(titol, anyPublicacio);
        this.numeroEdicio = numeroEdicio;
    }

    @Override
    public String descripcioDetallada() {
        return "Revista{titol='" + titol + "', numeroEdicio=" + numeroEdicio + ", anyPublicacio=" + anyPublicacio + "}";
    }

    public int getNumeroEdicio() { return numeroEdicio; }
}
