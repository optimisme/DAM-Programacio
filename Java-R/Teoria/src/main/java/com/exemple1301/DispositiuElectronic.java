package com.exemple1301;

class DispositiuElectronic {
    String nom;

    DispositiuElectronic(String nom) {
        this.nom = nom;
        System.out.println("Creant DispositiuElectronic: " + this.nom);
    }

    void encendre() {
        System.out.println(this.nom + " s'ha encès.");
    }
}

