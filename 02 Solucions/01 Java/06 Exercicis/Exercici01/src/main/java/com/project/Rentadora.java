package com.project;

// Subclasse: Rentadora
class Rentadora extends Electrodomestic {
    // Atribut específic de la subclasse
    private int capacitatCarrega; // Capacitat de càrrega en quilograms

    // Constructor
    public Rentadora(String marca, int consumEnergetic, int capacitatCàrrega) {
        super(marca, consumEnergetic); // Crida al constructor de la classe base
        this.capacitatCarrega = capacitatCàrrega;
    }

    public int getCapacitat() {
        return capacitatCarrega;
    }

    // Sobreescriure mètode per mostrar informació específica de Rentadora
    @Override
    public String toString() {
        super.toString(); // Crida al mètode de la classe base
        return super.toString() + "\nAquesta rentadora té una capacitat de càrrega de " + capacitatCarrega + " kg.";
    }
}
