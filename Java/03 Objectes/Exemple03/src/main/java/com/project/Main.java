package com.project;

public class Main {
    public static void main(String[] args) {
        
        SingletonDades instanciaHola = SingletonDades.getInstance("Hola");
        SingletonDades instanciaVale = SingletonDades.getInstance("Vale");
        SingletonDades instanciaAdeu = SingletonDades.getInstance("Adeu");

        System.out.println(instanciaHola); // Escriu: Valor: Hola
        System.out.println(instanciaVale); // Escriu: Valor: Hola
        System.out.println(instanciaAdeu); // Escriu: Valor: Hola
    }
}
