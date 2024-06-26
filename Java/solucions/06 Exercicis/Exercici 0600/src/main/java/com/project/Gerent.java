package com.project;

class Gerent extends Empleat {
    private String departament;
    
    public Gerent(String nom, String cognom, double salariAnual, String departament) {
        super(nom, cognom, salariAnual);
        this.departament = departament;
    }
    
    @Override
    public String getNomComplet() {
        return super.getNomComplet() + " [" + departament + "]";
    }
}
