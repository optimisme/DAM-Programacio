package com.project;

public class Main {
    public static void main(String[] args) {
        Electrodomestic nevera = new Nevera("Samsung", 120, 350);
        Electrodomestic rentadora = new Rentadora("LG", 200, 8);

        System.out.println(nevera); // Mostra informació de la nevera
        System.out.println(rentadora); // Mostra informació de la rentadora
    }
}