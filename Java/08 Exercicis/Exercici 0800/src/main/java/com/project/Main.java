package com.project;

import java.util.List;
import java.util.Map;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        AppData db = AppData.getInstance();

        // Crear taules
        crearTaulaEditorials();
        crearTaulaLlibres();

        // Afegir editorials
        afegirEditorial("Editorial Alpha");
        afegirEditorial("Beta Publishers");
        afegirEditorial("Gamma Books");
        afegirEditorial("Delta Literature");

        // Afegir llibres
        afegirLlibre("El primer llibre", "Autor A", 2020, 1);
        afegirLlibre("Segona obra", "Autor B", 2018, 2);
        afegirLlibre("Tercer volum", "Autor C", 2019, 3);
        afegirLlibre("Quart text", "Autor D", 2021, 4);
        afegirLlibre("Cinquè manuscrit", "Autor E", 2022, 1);
        afegirLlibre("Sisè document", "Autor F", 2023, 2);

        System.out.println("\nEditorials:");
        llistarTaulaEditorials();

        System.out.println("\nLlibres:");
        llistarTaulaLlibres();

        int idLlibre = 5;
        System.out.println("\nInformació del Llibre: " + idLlibre);
        llistarInfoLlibre(idLlibre);

        // Tancar la connexió amb la base de dades (del singleton)
        db.close();
    }
}
