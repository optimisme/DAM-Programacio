package com.project;

public class Ocell extends Animal {
    private String colorPlomatge;

    public Ocell(String nom, int edat, String colorPlomatge) {
        super(nom, edat);
        this.colorPlomatge = colorPlomatge;
    }

    @Override
    public String toString() {
        return super.toString() + ", colorPlomatge='" + colorPlomatge + '\'';
    }
}
