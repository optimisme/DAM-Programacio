package com.exercici1300;

public class Empleat {

    private String nom;
    private String cognom;
    private double salariAnual;

    public Empleat(String nom, String cognom, double salariAnual) {
        this.nom = nom;
        this.cognom = cognom;
        this.salariAnual = salariAnual;
    }
    
    public String getNomComplet() {
        return this.nom + " " + this.cognom;
    }

    public void incrementarSalari(double percentatge) {
        this.salariAnual += this.salariAnual * (percentatge / 100);
    }

    public double getSalariAnual() {
        return this.salariAnual;
    }
}
