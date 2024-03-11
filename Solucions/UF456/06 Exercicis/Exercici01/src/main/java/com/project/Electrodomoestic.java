package com.project;

class Electrodomestic {
    // Atributs de la classe base
    protected String marca;
    protected int consumEnergetic; // Consum energètic en watts

    // Constructor
    public Electrodomestic(String marca, int consumEnergetic) {
        this.marca = marca;
        this.consumEnergetic = consumEnergetic;
    }

    // Mètode per mostrar informació bàsica
    public String toString() {
        return "Electrodomèstic de la marca " + marca + " amb un consum energètic de " + consumEnergetic + " watts.";
    }
}
