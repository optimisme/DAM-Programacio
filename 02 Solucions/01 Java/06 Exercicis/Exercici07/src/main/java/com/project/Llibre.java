package com.project;

public class Llibre extends Publicacio {
    private String autor;

    public Llibre(String titol, int anyPublicacio, String autor) {
        super(titol, anyPublicacio);
        this.autor = autor;
    }

    @Override
    public String descripcioDetallada() {
        return "Llibre{titol='" + titol + "', autor='" + autor + "', anyPublicacio=" + anyPublicacio + "}";
    }

    public String getAutor() { return autor; }
}

