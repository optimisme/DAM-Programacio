package com.exercici1300;

public class Main {    
    public static void main(String[] args) {

        Empleat empleat = new Empleat("Maria", "Lopez", 30000);
        Gerent gerent = new Gerent("Carlos", "Garcia", 50000, "TI");
        
        System.out.println(empleat.getNomComplet() + " - Salari Anual: " + empleat.getSalariAnual());
        empleat.incrementarSalari(10);
        System.out.println("Després de l'increment: " + empleat.getSalariAnual());
        
        System.out.println(gerent.getNomComplet() + " - Salari Anual: " + gerent.getSalariAnual());
        gerent.incrementarSalari(10);
        System.out.println("Després de l'increment: " + gerent.getSalariAnual());
    }
}
