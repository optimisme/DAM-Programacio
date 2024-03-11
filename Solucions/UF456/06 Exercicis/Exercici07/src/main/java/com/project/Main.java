package com.project;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.afegirPublicacio(new Llibre("El Senyor dels Anells", 1954, "J.R.R. Tolkien"));
        biblioteca.afegirPublicacio(new Revista("National Geographic", 2020, 1024));
        biblioteca.afegirPublicacio(new Llibre("Dune", 1965, "Frank Herbert"));

        System.out.println("Totes les publicacions:");
        for (Publicacio publicacio : biblioteca.getPublicacions()) {
            System.out.println(publicacio);
        }

        System.out.println("\nLlibres:");
        for (Llibre llibre : biblioteca.getLlibres()) {
            System.out.println(llibre);
        }

        System.out.println("\nRevistes:");
        for (Revista revista : biblioteca.getRevistes()) {
            System.out.println(revista);
        }
    }
}
