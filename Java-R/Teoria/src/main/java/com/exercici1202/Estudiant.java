package com.exercici1202;

public class Estudiant {
    private String nom;
    private int edat;
    private Double notaMitjana;
    private Double contTotal;
    int contNotas = 0;

    public Estudiant(String nom, int edat) {
        this.nom = nom;
        this.edat = edat;
        this.notaMitjana = 0.0;
        this.contTotal = 0.0;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public Double getNotaMitjana() {
        return notaMitjana;
    }

    public void actualitzaNotaMitjana(Double novaNota){

        this.notaMitjana = calculaNotaMitjana(novaNota);
    }    

    private double calculaNotaMitjana(double novaNota){
        this.contTotal = this.contTotal + novaNota;
        this.contNotas = contNotas + 1;
        return this.contTotal/this.contNotas;
    }
}