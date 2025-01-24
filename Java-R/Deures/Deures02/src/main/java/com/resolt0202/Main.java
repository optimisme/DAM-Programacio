package com.resolt0202;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Creació d'autors
        Autor autor1 = new Autor("Gabriel García Márquez", "Colombiana");
        Autor autor2 = new Autor("J.K. Rowling", "Britànica");

        // Creació de llibres
        Llibre llibre1 = new Llibre("Cien años de soledad", autor1, 1967);
        Llibre llibre2 = new Llibre("Harry Potter y la piedra filosofal", autor2, 1997);

        // Creació de Prestecs
        Prestec prestec1 = new Prestec(llibre1, "01/01/2024", "31/01/2024");
        Prestec prestec2 = new Prestec(llibre2, "15/01/2024", "15/02/2024");

        // Llista de Prestecs per gestionar
        List<Prestec> prestecs = new ArrayList<>();
        prestecs.add(prestec1);
        prestecs.add(prestec2);

        // Mostrar informació dels Prestecs i validar si estan en termini
        for (Prestec prestec : prestecs) {
            Llibre llibre = prestec.getLlibre();
            Autor autor = llibre.getAutor();
            System.out.println("Llibre: " + llibre.getTitol() + " - Autor: " + autor.getNom() + " (" + autor.getNacionalitat() + ")");
            System.out.println("Data de Prestec: " + prestec.getDataPrestec() + " - Data de retorn: " + prestec.getDataRetorn());
            System.out.println("Està en termini? " + prestec.estaEnTermini());
            System.out.println("-----");
        }
    }
}