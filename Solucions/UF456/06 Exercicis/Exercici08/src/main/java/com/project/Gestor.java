package com.project;

public class Gestor extends Empleat {
    private String departament;

    public Gestor(String nom, String identificador, String departament) {
        super(nom, identificador);
        this.departament = departament;
    }

    @Override
    public String toString() {
        return super.toString() + ", departament='" + departament + "'";
    }
}

