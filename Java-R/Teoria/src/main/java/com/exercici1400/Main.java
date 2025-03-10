package com.exercici1400;

public class Main {
    public static void main(String[] args) {
        AppData db = AppData.getInstance("./data/exercici1400.sqlite");

        // Crear taules
        Biblioteca.crearTaulaEditorials();
        Biblioteca.crearTaulaLlibres();

        // Afegir editorials
        Biblioteca.afegirEditorial("Editorial Alpha");
        Biblioteca.afegirEditorial("Beta Publishers");
        Biblioteca.afegirEditorial("Gamma Books");
        Biblioteca.afegirEditorial("Delta Literature");

        // Afegir llibres
        Biblioteca.afegirLlibre("El primer llibre", "Autor A", 2020, 1);
        Biblioteca.afegirLlibre("Segona obra", "Autor B", 2018, 2);
        Biblioteca.afegirLlibre("Tercer volum", "Autor C", 2019, 3);
        Biblioteca.afegirLlibre("Quart text", "Autor D", 2021, 4);
        Biblioteca.afegirLlibre("Cinquè manuscrit", "Autor E", 2022, 1);
        Biblioteca.afegirLlibre("Sisè document", "Autor F", 2023, 2);

        System.out.println("\nEditorials:");
        Biblioteca.llistarTaulaEditorials();

        System.out.println("\nLlibres:");
        Biblioteca.llistarTaulaLlibres();

        int idLlibre = 5;
        System.out.println("\nInformació del Llibre: " + idLlibre);
        Biblioteca.llistarInfoLlibre(idLlibre);

        // Tancar la connexió amb la base de dades (del singleton)
        db.close();
    }
}
