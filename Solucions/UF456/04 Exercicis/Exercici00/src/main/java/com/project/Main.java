package com.project;

public class Main {
    public static void main(String[] args) {
        Cotxe seat = new Cotxe("Verd", "SEAT", "127", 1438, 1972);
        Cotxe citroen = new Cotxe("Gris", "CITROEN", "DS", 2175, 1959);

        System.out.println(seat);
        System.out.println(citroen);
    }
}