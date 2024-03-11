package com.project;

class Persona {
    protected String nom;
    protected String dni;

    public Persona(String nom, String dni) {
        this.nom = nom;
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Persona{" + "nom='" + nom + '\'' + ", dni='" + dni + '\'' + '}';
    }

    public void checkIn() {
        System.out.println("Facturació completada. Benvingut a bord!");
    }
}

