package com.project;

class Pilot extends Persona {
    private String llicencia;

    public Pilot(String nom, String dni, String llicencia) {
        super(nom, dni);
        this.llicencia = llicencia;
    }

    @Override
    public String toString() {
        return super.toString() + ", llicència='" + llicencia + '\'';
    }

    @Override
    public void checkIn() {
        System.out.println("Pilot " + nom + " amb llicència " + llicencia + " ha realitzat el check-in. Preparat per al vol.");
    }
}
