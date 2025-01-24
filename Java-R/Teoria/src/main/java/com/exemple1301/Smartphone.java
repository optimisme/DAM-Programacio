package com.exemple1301;

class Smartphone extends DispositiuElectronic {
    Smartphone(String nom) {
        super(nom); // Crida al constructor de la classe pare amb el nom del dispositiu
        System.out.println("Creant Smartphone: " + this.nom);
    }

    @Override
    void encendre() {
        super.encendre(); // Crida al mètode encendre() de la classe pare
        System.out.println(this.nom + " està llest per ser utilitzat com a smartphone.");
    }
}

