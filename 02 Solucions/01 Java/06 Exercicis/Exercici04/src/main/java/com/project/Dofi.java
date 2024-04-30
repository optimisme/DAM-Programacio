package com.project;

public class Dofi extends Mamifer implements Nedador {
    public Dofi(String nom, int edat, String tipusPelatge) {
        super(nom, edat, tipusPelatge);
    }

    @Override
    public void nedar() {
        System.out.println(nom + " està nedant!");
    }
}
