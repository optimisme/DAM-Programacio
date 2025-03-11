package com.exercici0500;

import java.util.ArrayList;
import java.util.HashMap;

public class Cinema {

    /**
     * Crea la taula "directors", si ja existeix primer l'esborra
     */
    public static void crearTaulaDirectors() {
        AppData db = AppData.getInstance();
        db.update("DROP TABLE IF EXISTS directors");
        String sqlCreate = """
            CREATE TABLE directors (
                id_directory INTEGER PRIMARY KEY AUTOINCREMENT,
                nom TEXT NOT NULL,
                nacionalitat TEXT NOT NULL)
                """;
        db.update(sqlCreate);
    }

    public static void crearTaulaPelis() {
        AppData db = AppData.getInstance();
        db.update("DROP TABLE IF EXISTS pelis");
        db.update("""
                CREATE TABLE IF NOT EXISTS pelis(
                id_peli INT AUTO_INCREMENT PRIMARY KEY,
                titol TEXT NOT NULL,
                any_estrena INTEGER,
                durada INTEGER,
                id_director INTEGER,
                FOREIGN KEY(id_director) REFERENCES directors(id_director))
                """);
    }

    public static void crearTaulaSales() {
        AppData db = AppData.getInstance();
        db.update("DROP TABLE IF EXISTS sales");
        String sql = """
            CREATE TABLE IF NOT EXISTS sales (
                id_sala INTEGER PRIMARY KEY AUTOINCREMENT,
                nom_sala TEXT NOT NULL,
                capacitat INTEGER NOT NULL,
                id_peli INTEGER,
                FOREIGN KEY(id_peli) REFERENCES pelis(id_peli)
            );
        """;
        db.update(sql);
    }

    /**
     * Afegeix un nou director
     * @param nomDirector
     * @param nacionalitat
     * @return l'identificador del director afegit
     */
    public static int afegirDirector(String nomDirector, String nacionalitat) {
        AppData db = AppData.getInstance();
        String sql = String.format("INSERT INTO directors (nom, nacionalitat) VALUES ('%s','%s')",nomDirector,nacionalitat);
        return db.insertAndGetId(sql);
    }

    public static int afegirPeli(String titol, int any, int duracio, int idDirector) {
        AppData db = AppData.getInstance();
        String sql = String.format("INSERT INTO pelis (titol, any_estrena, durada, id_director) VALUES ('%s','%d','%d','%d')",titol, any, duracio ,idDirector);
        return db.insertAndGetId(sql);
    }

    public static int afegirSala(String nomSala, int capacitat, int idPeli) {
        AppData db = AppData.getInstance();
        String sql = String.format("INSERT INTO sales (nom_sala, capacitat, id_peli) VALUES ('%s', %d, %d)", nomSala, capacitat, idPeli);
        return db.insertAndGetId(sql);
    } 

    /**
     * Mostra una taula amb informació dels directors:
     * ┌───────────┬─────────────┐
     * │Nom        │Nacionalitat │
     * ├───────────┼─────────────┤
     * │Director A │País X       │
     * │Director B │País Y       │
     * └───────────┴─────────────┘
     */
    public static void llistarTaulaDirectors() {
    }

    public static void llistarTaulaPelis() {
    }

    public static void llistarTaulaSales() {
    }

    /**
     * Mostra una fitxa amb informació de les pelis:
     * 
     * ┌───────────────────────┐
     * │Film A                 │
     * ├─────────┬─────────────┤
     * │Id       │1            │
     * │Direcció │Director A   │
     * │Any      │2020         │
     * │Duració  │120 minuts   │
     * └─────────┴─────────────┘
     */
    public static void llistarInfoPeli(int idLlibre) {
    }

    /**
     * Guarda la informacio de les películes en un arxiu ".json"
     */
    public static void pelisToJSON(String path) {
    }
}
