package com.exercici1201;

public class Llibre {
    // Atributos Privados de los libros
    private String titol;
    private String autor;
    private int anyPublicacio;
    private boolean prestec;

    // Constructor de Libros
    public Llibre(String titol, String autor, int anyPublicacio) {
        this.titol = titol;
        this.autor = autor;
        this.anyPublicacio = anyPublicacio;
        this.prestec = false;
    }
    // Get titol
    public String getTitol() {
        return this.titol;
    }
    // Set titol
    public void setTitol(String titol) {
        this.titol = titol;
    }
    // Get autor
    public String getAutor() {
        return this.autor;
    }
    // Set autor
    public void setAutor(String autor) {
        this.autor = autor;
    }
    // Get anyPublicacio
    public int getAnyPublicacio() {
        return this.anyPublicacio;
    }
    // Set anyPublicacio
    public void setAnyPublicacio(int anyPublicacio) {
        this.anyPublicacio = anyPublicacio;
    }
    // Get estaPrestat
    public boolean getEstaPrestat() {
        return this.prestec;
    }
    // Set estaPrestat
    public void setEstaPrestat(boolean prestec) {
        this.prestec = prestec;
    }

    public void prestar() {
        prestec = true;
    }
    public void retornar() {
        prestec = false;
    }

    @Override
    public String toString() {
        if (prestec){
            return titol+","+autor+";"+anyPublicacio+" - "+"En prestec";
        } else {
            return titol+","+autor+";"+anyPublicacio+" - "+"Disponible";
        }
        
    }

}
