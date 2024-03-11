package com.project;

public class Main {
    public static void main(String[] args) {
        Cotxe cotxe = new Cotxe("Toyota", "Corolla", 500);
        System.out.println(cotxe.descripcioVehicle());
        cotxe.iniciarVehicle();
        cotxe.carregar(300);
        cotxe.aturarVehicle();
        System.out.println(cotxe);

        Furgoneta furgoneta = new Furgoneta("Ford", "Transit", 15); // 15m³ de volum de càrrega
        System.out.println(furgoneta.descripcioVehicle());
        furgoneta.iniciarVehicle();
        furgoneta.carregar(1000); 
        furgoneta.aturarVehicle();
        System.out.println(furgoneta);

        Bicicleta bicicleta = new Bicicleta("BH", "Speedrom");
        System.out.println(bicicleta.descripcioVehicle());
        bicicleta.iniciarVehicle();
        bicicleta.aturarVehicle();
        System.out.println(bicicleta);
    }
}