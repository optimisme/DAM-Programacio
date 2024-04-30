package com.project;

public class Cotxe extends Vehicle {
    @Override
    public void accelerar() {
        System.out.println("El cotxe accelera.");
    }

    @Override
    public void frenar() {
        System.out.println("El cotxe frena.");
    }

    // Opcional: sobreescriure mètodes no abstractes
    @Override
    public void encendre() {
        System.out.println("El cotxe s'ha encès amb una clau.");
    }
}

