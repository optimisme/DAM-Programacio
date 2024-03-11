package com.project;

public class Main {
    public static void main(String[] args) {
        // Creació d'un pilot
        Pilot pilot = new Pilot("Maria García", "12345678P", "LIC1234");
        
        // Creació de dos clients
        Client client1 = new Client("Joan Martí", "87654321J", "VOL001");
        Client client2 = new Client("Anna Lopez", "23456789A", "VOL002");
        
        // Mostra la informació i realitza el check-in del pilot
        System.out.println(pilot);
        pilot.checkIn();
        
        // Espai per millorar la legibilitat en la sortida
        System.out.println();

        // Mostra la informació i realitza el check-in dels clients
        System.out.println(client1);
        client1.checkIn();
        
        System.out.println();
        
        System.out.println(client2);
        client2.checkIn();
    }
}