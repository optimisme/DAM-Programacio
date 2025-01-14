package com.exemple1303;

public abstract class Vehicle {
    // Aquest mètode abstracte ha de ser implementat per totes les subclasses
    public abstract void accelerar();
    
    // Aquest mètode abstracte també ha de ser implementat per totes les subclasses
    public abstract void frenar();

    // Un mètode no abstracte: pot ser utilitzat o sobreescriu per les subclasses
    public void encendre() {
        System.out.println("El vehicle s'ha encès.");
    }
}
