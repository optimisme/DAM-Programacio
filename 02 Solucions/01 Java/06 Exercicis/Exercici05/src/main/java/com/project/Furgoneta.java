package com.project;

public class Furgoneta extends Vehicle implements Carregable {
    private int volumCarrega;

    public Furgoneta(String marca, String model, int volumCarrega) {
        super(marca, model);
        this.volumCarrega = volumCarrega;
    }

    @Override
    public String descripcioVehicle() {
        return "Furgoneta{marca='" + marca + "', model='" + model + "', volumCarrega=" + volumCarrega + "m³}";
    }

    @Override
    public void iniciarVehicle() {
        System.out.println("La furgoneta " + marca + " " + model + " s'està iniciant.");
    }

    @Override
    public void aturarVehicle() {
        System.out.println("La furgoneta " + marca + " " + model + " s'ha aturat.");
    }

    @Override
    public void carregar(int quilograms) {
        System.out.println("Carregant " + quilograms + "kg a la furgoneta.");
    }

    @Override
    public String toString() {
        return super.toString() + ", volumCarrega=" + volumCarrega + "m³";
    }
}

