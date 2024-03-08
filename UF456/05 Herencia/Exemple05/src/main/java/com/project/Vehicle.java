package com.project;

// Definició de la classe Vehicle utilitzant composició
class Vehicle {
    private Motor motor;

    Vehicle() {
        motor = new Motor(); // Composició aquí
    }

    void encendreMotor() {
        motor.encendre();
    }
}