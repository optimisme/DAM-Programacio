package com.project;

// Subclasse: Nevera
class Nevera extends Electrodomestic {
    // Atribut específic de la subclasse
    private int capacitat; // Capacitat en litres

    // Constructor
    public Nevera(String marca, int consumEnergetic, int capacitat) {
        super(marca, consumEnergetic); // Crida al constructor de la classe base
        this.capacitat = capacitat;
    }

    public int getCapacitat() {
        return capacitat;
    }

    // Sobreescriure mètode per mostrar informació específica de Nevera
    @Override
    public String toString() {
        return super.toString() + "\nAquesta nevera té una capacitat de " + capacitat + " litres.";
    }
}