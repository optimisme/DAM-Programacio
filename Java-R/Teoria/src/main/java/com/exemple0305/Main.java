package com.exemple0305;

public class Main {
    public static void main(String[] args) {

        System.out.println("0123456789");

        String alineaDreta = "%8s".formatted("Hola");
        System.out.println(alineaDreta + "|");

        String alineaEsquerra = "%-8s".formatted("Hola");
        System.out.println(alineaEsquerra + "|");
    }
}
