package com.project;

// Definició de la subclasse VehicleAmbMotor utilitzant herència
class VehicleAmbMotor extends Vehicle {
    @Override
    void moure() {
        super.moure(); // Utilitza la implementació de moure de la classe Vehicle
        System.out.println("El vehicle amb motor s'ha encès i es mou.");
    }
}
