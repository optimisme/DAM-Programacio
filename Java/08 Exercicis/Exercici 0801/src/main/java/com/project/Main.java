package com.project;

import java.util.List;
import java.util.Map;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        AppData db = AppData.getInstance();

        // Crear taules
        crearTaulaDirectors();
        crearTaulaPelis();
        crearTaulaSales();

        // Afegir directors
        afegirDirector("Director A", "País X");
        afegirDirector("Director B", "País Y");

        // Afegir pel·lícules
        afegirPeli("Film A", 2020, 120, 1);
        afegirPeli("Film B", 2018, 110, 2);

        // Afegir sales
        afegirSala("Sala 1", 150, 1);
        afegirSala("Sala 2", 200, 2);

        System.out.println("\nDirectors:");
        llistarTaulaDirectors();

        System.out.println("\nPelis:");
        llistarTaulaPelis();

        System.out.println("\nSales:");
        llistarTaulaSales();

        int idPeli = 1;
        System.out.println("\nInformació de la Peli: " + idPeli);
        llistarInfoPeli(idPeli);

        // Tancar la connexió amb la base de dades (del singleton)
        db.close();
    }
}
