package com.project;

public class Desenvolupador extends Empleat {
    private String llenguatge;

    public Desenvolupador(String nom, String identificador, String llenguatge) {
        super(nom, identificador);
        this.llenguatge = llenguatge;
    }

    @Override
    public String toString() {
        return super.toString() + ", llenguatge='" + llenguatge + "'";
    }
}

