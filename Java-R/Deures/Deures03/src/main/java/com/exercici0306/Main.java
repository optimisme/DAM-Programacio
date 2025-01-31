package com.exercici0306;

public class Main {
    public static void main(String[] args) {
        Port port = new Port("Barcelona");

        VaixellMercaderies v1 = new VaixellMercaderies("Mercaderies1", 10000, "Espanya");
        VaixellPassatgers v2 = new VaixellPassatgers("Passatgers1", 5000, 300);

        v1.afegirCarrega(new Carrega("Menjar", 2000));
        v1.afegirCarrega(new CarregaPerillosa("Químics", 500, 3));

        v2.afegirPassatger();
        v2.afegirPassatger();

        port.afegirVaixell(v1);
        port.afegirVaixell(v2);

        port.printVaixells();
        port.printNormatives();
    }
}
