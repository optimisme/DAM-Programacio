package com.exemple0200;

public class Main {
    public static void main(String[] args) {

        float iva = 20;
        float preu = 200;
        float preuVenda = preu + (preu * iva / 100);

        System.out.println("El preu del producte és " + preu + "€, i amb l'IVA es pot comprar per: " + preuVenda);
    }
}
