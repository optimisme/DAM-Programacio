package com.project;

public abstract class Vehicle {
    protected String marca;
    protected String model;

    public Vehicle(String marca, String model) {
        this.marca = marca;
        this.model = model;
    }

    public abstract String descripcioVehicle();

    public void iniciarVehicle() {
        System.out.println("El vehicle s'està iniciant.");
    }

    public void aturarVehicle() {
        System.out.println("El vehicle s'ha aturat.");
    }

    @Override
    public String toString() {
        return "Vehicle{marca='" + marca + '\'' + ", model='" + model + '\'' + '}';
    }
}
