package com.project;

public class Llibre {
    private String titol;
    private String autor;
    private int anyPublicacio;
    private boolean prestec;

    public Llibre(String titol, String autor, int anyPublicacio) {
        this.titol = titol;
        this.autor = autor;
        this.anyPublicacio = anyPublicacio;
        this.prestec = false; // El llibre comença no prestat per defecte
    }

    public String getTitol() {
        return titol;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnyPublicacio() {
        return anyPublicacio;
    }

    public boolean estaPrestat() {
        return prestec;
    }

    public void prestar() {
        this.prestec = true;
    }

    public void retornar() {
        this.prestec = false;
    }

    @Override
    public String toString() {
        String estat = prestec ? "En préstec" : "Disponible";
        return titol + ", " + autor + "; " + anyPublicacio + " - " + estat;
    }
}
