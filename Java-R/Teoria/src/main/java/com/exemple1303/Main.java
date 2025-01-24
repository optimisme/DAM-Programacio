package com.exemple1303;

public class Main {
    public static void main(String[] args) {
        Vehicle cotxe = new Cotxe();
        cotxe.encendre();
        cotxe.accelerar();
        cotxe.frenar();
        
        System.out.println(); // Espai entre vehicles
        
        Vehicle bicicleta = new Bicicleta();
        bicicleta.encendre();
        bicicleta.accelerar();
        bicicleta.frenar();
    }
}

