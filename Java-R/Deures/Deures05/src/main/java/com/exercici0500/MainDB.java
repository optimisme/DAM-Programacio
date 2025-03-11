package com.exercici0500;

public class MainDB {

    // Fes anar aquest programa amb:
    // ./run.sh com.exercici0500.MainDB
    
    public static void main(String[] args) {
        AppData db = AppData.getInstance();
        db.connect("./data/cinema.sqlite");

        // Crear taules
        Cinema.crearTaulaDirectors();
        Cinema.crearTaulaPelis();
        Cinema.crearTaulaSales();

        // Afegir directors
        int id0 = Cinema.afegirDirector("Director A", "País X");
        System.out.println("S'ha afegit un nou director amb id: " + id0);
        int id1 = Cinema.afegirDirector("Director B", "País Y");
        System.out.println("S'ha afegit un nou director amb id: " + id1);

        // Afegir pel·lícules
        Cinema.afegirPeli("Film A", 2020, 120, 1);
        Cinema.afegirPeli("Film B", 2018, 110, 2);

        // Afegir sales
        Cinema.afegirSala("Sala 1", 150, 1);
        Cinema.afegirSala("Sala 2", 200, 2);

        System.out.println("\nDirectors:");
        Cinema.llistarTaulaDirectors();

        System.out.println("\nPelis:");
        Cinema.llistarTaulaPelis();

        System.out.println("\nSales:");
        Cinema.llistarTaulaSales();

        int idPeli = 1;
        System.out.println("\nInformació de la Peli: " + idPeli);
        Cinema.llistarInfoPeli(idPeli);

        // Tancar la connexió amb la base de dades (del singleton)
        db.close();
    }
}