package com.project;

public class Cotxe extends Vehicle implements Carregable {
    private int capacitatCarrega;

    public Cotxe(String marca, String model, int capacitatCarrega) {
        super(marca, model);
        this.capacitatCarrega = capacitatCarrega;
    }

    @Override
    public String descripcioVehicle() {
        return "Cotxe{marca='" + marca + "', model='" + model + "', capacitatCarrega=" + capacitatCarrega + '}';
    }

    @Override
    public void carregar(int quilograms) {
        System.out.println("Carregant " + quilograms + "kg en el cotxe.");
    }

    @Override
    public void iniciarVehicle() {
        System.out.println("El cotxe " + marca + " " + model + " s'està iniciant.");
    }

    @Override
    public void aturarVehicle() {
        System.out.println("El cotxe " + marca + " " + model + " s'ha aturat.");
    }
}

