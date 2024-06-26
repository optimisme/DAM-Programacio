package com.project;

public class ControlTemperatura {
    private static double temperaturaTotal = 0;
    private static int comptadorZones = 0;

    // Atributs d'instància per a cada zona
    private String nomZona;
    private double temperatura;

    public ControlTemperatura(String nomZona, double temperatura) {
        this.nomZona = nomZona;
        this.temperatura = temperatura;

        // Actualitzem els valors estàtics
        temperaturaTotal += temperatura;
        comptadorZones++;
    }

    public String getNomZona() {
        return nomZona;
    }

    public double getTemperatura() {
        return temperatura;
    }

    // Ajusta la temperatura de la zona i actualitza la temperatura total
    public void ajustaTemperatura(double novaTemperatura) {
        temperaturaTotal -= this.temperatura; // Treiem la temperatura antiga
        temperaturaTotal += novaTemperatura; // Afegim la nova temperatura
        this.temperatura = novaTemperatura; // Actualitzem la temperatura d'aquesta zona
    }

    // Mètodes estàtics per a interactuar amb els atributs estàtics
    public static double getTemperaturaMitjana() {
        if (comptadorZones > 0) {
            return temperaturaTotal / comptadorZones;
        } else {
            return 0;
        }
    }
}
