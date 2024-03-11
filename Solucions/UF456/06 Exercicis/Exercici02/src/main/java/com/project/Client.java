package com.project;

class Client extends Persona {
    private String numeroVol;

    public Client(String nom, String dni, String numeroVol) {
        super(nom, dni);
        this.numeroVol = numeroVol;
    }

    @Override
    public String toString() {
        return super.toString() + ", vol='" + numeroVol + '\'';
    }

    @Override
    public void checkIn() {
        System.out.println("Facturació de client completada. Preparat per embarcar al vol " + numeroVol + ". Benvingut a bord!");
    }
}

