package com.exemple1400;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    // Fes anar l'exemple amb:
    // ./run.sh com.exemple1400.Main

    public static void main(String[] args) {

        // Crear el singleton (això es connecta a la base de dades)
        AppData db = AppData.getInstance();
        db.connect("./data/exemple1400.sqlite");

        System.out.println("\nIniciar les dades de la base de dades:");
        initData();

        System.out.println("\nAnimals de l'espècie 'Gos':");
        llistarFiles("SELECT * FROM animals WHERE especie = 'Gos'");

        System.out.println("\nAnimals de quatre potes:");
        llistarFiles("SELECT * FROM animals WHERE numeropotes = 4");

        // Tancar la connexió amb la base de dades (del singleton)
        db.close();
    }

    public static void initData() {

        // Obtenir un apuntador al singleton de la base de dades
        AppData db = AppData.getInstance();

        // Esborrar la taula 'animals' si existeix
        db.update("DROP TABLE IF EXISTS animals");

        // Crear la taula 'animals'
        db.update("""
            CREATE TABLE IF NOT EXISTS animals (
                especie TEXT NOT NULL,
                longevitat INTEGER,
                numeropotes INTEGER)
                """);

        // Inserir dades a la taula 'animals'
        db.update("INSERT INTO animals (especie, longevitat, numeropotes) VALUES ('Gos', 14, 4)");
        db.update("INSERT INTO animals (especie, longevitat, numeropotes) VALUES ('Gat', 15, 4)");
        db.update("INSERT INTO animals (especie, longevitat, numeropotes) VALUES ('Elefant', 70, 4)");
        db.update("INSERT INTO animals (especie, longevitat, numeropotes) VALUES ('Tortuga', 100, 4)");
        db.update("INSERT INTO animals (especie, longevitat, numeropotes) VALUES ('Colom', 6, 2)");
    }

    public static void llistarFiles(String sql) {

        // Obtenir un apuntador al singleton de la base de dades
        AppData db = AppData.getInstance();

        ArrayList<HashMap<String, Object>> files = db.query(sql);

        // Llistar el nom i tipus de dades de cada columna (de la fila 0)
        String txt = "Columnes: ";
        HashMap<String, Object> fila0 = files.get(0);
        for (String key : fila0.keySet()) {
            Object value = fila0.get(key);
            txt += key + " (" + (value != null ? value.getClass().getSimpleName() : "null") + "), ";
        }
        if (files.size() > 0) {
            txt = txt.substring(0, txt.length() - 2);
        }
        System.out.println(txt);

        // Llistar les files de la query
        System.out.println("Dades:");
        for (HashMap<String, Object> fila : files) {
            System.out.println(fila.get("especie") + ", " + fila.get("longevitat") + " anys, " + fila.get("numeropotes") + " potes");
        }
    }
}
