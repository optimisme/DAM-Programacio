package com.project;

class Empleat {
    private String nom;
    private String cognom;
    private double salariAnual;
    
    public Empleat(String nom, String cognom, double salariAnual) {
        this.nom = nom;
        this.cognom = cognom;
        this.salariAnual = salariAnual;
    }
    
    public String getNomComplet() {
        return nom + " " + cognom;
    }
    
    public void incrementarSalari(double percentatge) {
        salariAnual += salariAnual * percentatge / 100;
    }
    
    public double getSalariAnual() {
        return salariAnual;
    }
}
