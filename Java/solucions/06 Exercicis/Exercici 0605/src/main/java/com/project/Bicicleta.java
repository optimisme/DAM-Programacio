package com.project;

public class Bicicleta extends Vehicle {

    public Bicicleta(String marca, String model) {
        super(marca, model);
    }

    @Override
    public String descripcioVehicle() {
        return "Bicicleta{marca='" + marca + "', model='" + model + "'}";
    }

    @Override
    public void iniciarVehicle() {
        System.out.println("La bicicleta " + marca + " " + model + " està preparada per a ser utilitzada.");
    }

    @Override
    public void aturarVehicle() {
        System.out.println("La bicicleta " + marca + " " + model + " s'ha aturat.");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

