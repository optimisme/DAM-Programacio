package com.exercici1400;

import java.util.ArrayList;
import java.util.HashMap;

public class Biblioteca {

    public static void crearTaulaEditorials() {
        AppData db = AppData.getInstance();
        db.update("DROP TABLE IF EXISTS Editorials");
        String sql = """
            CREATE TABLE IF NOT EXISTS Editorials (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nom TEXT NOT NULL
            );
        """;
        db.update(sql);
    }

    public static void crearTaulaLlibres() {
        AppData db = AppData.getInstance();
        db.update("DROP TABLE IF EXISTS Llibres");

        String sql = "CREATE TABLE IF NOT EXISTS Llibres (" +
            " id_llibre INTEGER PRIMARY KEY AUTOINCREMENT," +
            " titol TEXT NOT NULL," +
            " autor TEXT," +
            " any_publicacio INTEGER," +
            " id_editorial INTEGER," +
            " FOREIGN KEY(id_editorial) REFERENCES Editorials(id_editorial))";
        AppData.getInstance().update(sql);
    }

    public static void afegirEditorial(String nom) {
        AppData db = AppData.getInstance();
        String sql = String.format("INSERT INTO Editorials (nom) VALUES ('%s')", nom);
        db.update(sql);
    }

    public static void afegirLlibre(String titol, String autor, int anyPublicacio, int idEditorial) {
        String sql = String.format("INSERT INTO Llibres (titol, autor, any_publicacio, id_editorial) VALUES ('%s', '%s', %d, %d)", titol, autor, anyPublicacio, idEditorial);
        AppData.getInstance().update(sql);
    }

    /**
     * Mostra informació de la llista d'editorals en format taula
     */
    public static void llistarTaulaEditorials() {
        AppData db = AppData.getInstance();
        String sql = "SELECT * FROM Editorials";
        ArrayList<HashMap<String, Object>> result = db.query(sql); 
        for (HashMap<String, Object> row : result) {
            System.out.println("ID: " + row.get("id") + " Nom: " + row.get("nom")); 
        }
    }

    /**
     * Mostra informació de la llista de llibres en format taula
     */
    public static void llistarTaulaLlibres() {
        // TODO 
    }

    /** 
     * Mostra informació d'un llibre en format etiqueta
     */
    public static void llistarInfoLlibre(int idLlibre) {
        // TODO 
    }
}
