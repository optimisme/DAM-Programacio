package com.project;

public class Mamifer extends Animal {
    private String tipusPelatge;

    public Mamifer(String nom, int edat, String tipusPelatge) {
        super(nom, edat);
        this.tipusPelatge = tipusPelatge;
    }

    @Override
    public String toString() {
        return super.toString() + ", tipusPelatge='" + tipusPelatge + '\'';
    }
}
