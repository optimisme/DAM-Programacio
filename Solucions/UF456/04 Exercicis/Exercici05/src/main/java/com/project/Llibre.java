package com.project;

public class Llibre {
    private String titol;
    private Autor autor;
    private int anyPublicacio;

    // Constructor
    public Llibre(String titol, Autor autor, int anyPublicacio) {
        this.titol = titol;
        this.autor = autor;
        this.anyPublicacio = anyPublicacio;
    }

    // Setters i getters
    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public int getAnyPublicacio() {
        return anyPublicacio;
    }

    public void setAnyPublicacio(int anyPublicacio) {
        this.anyPublicacio = anyPublicacio;
    }
}
