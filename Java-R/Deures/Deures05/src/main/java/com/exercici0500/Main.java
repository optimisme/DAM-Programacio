package com.exercici0500;

public class Main {

    // Fes anar aquest programa amb:
    // ./run.sh com.exercici0500.Main
    
    public static void main(String[] args) {
        AppData db = AppData.getInstance();
        db.connect("./data/dbCinema.sqlite");

        // Crear taules
        Cinema.crearTaulaDirectors();
        Cinema.crearTaulaPelis();
        Cinema.crearTaulaSales();

        // Afegir directors
        int dir0 = Cinema.afegirDirector("Director A", "País X");
        System.out.println("S'ha afegit un nou director amb id: " + dir0);
        int dir1 = Cinema.afegirDirector("Director B", "País Y");
        System.out.println("S'ha afegit un nou director amb id: " + dir1);

        // Afegir pel·lícules
        int pel0 = Cinema.afegirPeli("Film A", 2020, 120, 1);
        System.out.println("S'ha afegit una nova peli amb id: " + pel0);
        int pel1 = Cinema.afegirPeli("Film B", 2018, 110, 2);
        System.out.println("S'ha afegit una nova peli amb id: " + pel1);

        // Afegir sales
        int salY = Cinema.afegirSala("Sala 1", 150, 1);
        System.out.println("S'ha afegit una nova sala amb id: " + salY);
        int salZ = Cinema.afegirSala("Sala 2", 200, 2);
        System.out.println("S'ha afegit una nova sala amb id: " + salZ);

        System.out.println("\nDirectors:");
        Cinema.llistarTaulaDirectors();

        System.out.println("\nPelis:");
        Cinema.llistarTaulaPelis();

        System.out.println("\nSales:");
        Cinema.llistarTaulaSales();

        int idPeli = 1;
        System.out.println("\nInformació de la Peli: " + idPeli);
        Cinema.llistarInfoPeli(idPeli);

        // Guardar informació de les pelis en un ".json"
        Cinema.pelisToJSON("./data/pelis.json");

        // Tancar la connexió amb la base de dades (del singleton)
        db.close();
    }
}