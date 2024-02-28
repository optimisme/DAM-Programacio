package com.project;

public class Main {
    public static void main(String[] args) {
        
        SingletonDades instanciaHola = SingletonDades.getInstance("Hola");
        SingletonDades instanciaVale = SingletonDades.getInstance("Vale");
        SingletonDades instanciaAdeu = SingletonDades.getInstance("Adeu");

        System.out.println(instanciaHola.toString()); // Escriu: Valor: Hola
        System.out.println(instanciaVale.toString()); // Escriu: Valor: Hola
        System.out.println(instanciaAdeu.toString()); // Escriu: Valor: Hola
    }
}
