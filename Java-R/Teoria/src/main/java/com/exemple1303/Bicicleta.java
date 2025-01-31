package com.exemple1303;

public class Bicicleta extends Vehicle {

    public Bicicleta(String marca) {
        super(marca);
    }

    @Override
    public void accelerar() {
        System.out.println("La bicicleta accelera pedalant.");
    }

    @Override
    public void frenar() {
        System.out.println("La bicicleta frena amb els frens de mà.");
    }

    // Aquesta classe utilitza l'implementació predeterminada de encendre()
}

