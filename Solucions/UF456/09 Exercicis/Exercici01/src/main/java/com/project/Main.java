package com.project;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

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

    private static void crearTaulaDirectors() {
        String sql = "CREATE TABLE IF NOT EXISTS directors (" +
                     "id_director INTEGER PRIMARY KEY," +
                     "nom TEXT NOT NULL," +
                     "nacionalitat TEXT NOT NULL)";

        AppData db = AppData.getInstance();
        db.update("DROP TABLE IF EXISTS directors");
        db.update(sql);
    }

    private static void crearTaulaPelis() {
        String sql = "CREATE TABLE IF NOT EXISTS pelis (" +
                     "id_peli INTEGER PRIMARY KEY," +
                     "titol TEXT NOT NULL," +
                     "any_estrena INTEGER NOT NULL," +
                     "durada INTEGER NOT NULL," +
                     "id_director INTEGER," +
                     "FOREIGN KEY(id_director) REFERENCES directors(id_director))";

        AppData db = AppData.getInstance();
        db.update("DROP TABLE IF EXISTS pelis");
        db.update(sql);
    }

    private static void crearTaulaSales() {
        String sql = "CREATE TABLE IF NOT EXISTS sales (" +
                     "id_sala INTEGER PRIMARY KEY," +
                     "nom_sala TEXT NOT NULL," +
                     "capacitat INTEGER NOT NULL," +
                     "id_peli INTEGER," +
                     "FOREIGN KEY(id_peli) REFERENCES pelis(id_peli))";

        AppData db = AppData.getInstance();
        db.update("DROP TABLE IF EXISTS sales");
        db.update(sql);
    }

    private static void afegirDirector(String nom, String nacionalitat) {
        String sql = "INSERT INTO directors (nom, nacionalitat) VALUES ('" + nom + "', '" + nacionalitat + "')";
        AppData.getInstance().update(sql);
    }

    private static void afegirPeli(String titol, int anyEstrena, int durada, int idDirector) {
        String sql = "INSERT INTO pelis (titol, any_estrena, durada, id_director) " +
                     "VALUES ('" + titol + "', " + anyEstrena + ", " + durada + ", " + idDirector + ")";
        AppData.getInstance().update(sql);
    }

    private static void afegirSala(String nomSala, int capacitat, int idPeli) {
        String sql = "INSERT INTO sales (nom_sala, capacitat, id_peli) VALUES ('" + nomSala + "', " + capacitat + ", " + idPeli + ")";
        AppData.getInstance().update(sql);
    }

    private static void llistarTaulaDirectors() {
        String sql = "SELECT * FROM directors";
        List<Map<String, Object>> directors = AppData.getInstance().query(sql);
        for (Map<String, Object> director : directors) {
            System.out.println("ID: " + director.get("id_director") + ", Nom: " + director.get("nom") + ", Nacionalitat: " + director.get("nacionalitat"));
        }
    }

    private static void llistarTaulaPelis() {
        String sql = "SELECT p.id_peli, p.titol, p.any_estrena, p.durada, d.nom AS director " +
                     "FROM pelis p " +
                     "JOIN directors d ON p.id_director = d.id_director";
        List<Map<String, Object>> pelis = AppData.getInstance().query(sql);
        for (Map<String, Object> peli : pelis) {
            System.out.println("ID: " + peli.get("id_peli") + 
                               ", Títol: " + peli.get("titol") + 
                               ", Any d'Estrena: " + peli.get("any_estrena") + 
                               ", Durada: " + peli.get("durada") + " minuts" + 
                               ", Director: " + peli.get("director"));
        }
    }
    
    private static void llistarTaulaSales() {
        String sql = "SELECT s.id_sala, s.nom_sala, s.capacitat, p.titol AS peli " +
                     "FROM sales s " +
                     "LEFT JOIN pelis p ON s.id_peli = p.id_peli";
        List<Map<String, Object>> sales = AppData.getInstance().query(sql);
        for (Map<String, Object> sala : sales) {
            System.out.println("ID: " + sala.get("id_sala") + 
                               ", Sala: " + sala.get("nom_sala") + 
                               ", Capacitat: " + sala.get("capacitat") + " persones" +
                               (sala.get("peli") != null ? ", Peli: " + sala.get("peli") : ", Peli: No assignada"));
        }
    }

    private static void llistarInfoPeli(int idPeli) {
        String sql = "SELECT p.id_peli, p.titol, p.any_estrena, p.durada, d.nom AS director, s.nom_sala AS sala " +
                     "FROM pelis p " +
                     "LEFT JOIN directors d ON p.id_director = d.id_director " +
                     "LEFT JOIN sales s ON p.id_peli = s.id_peli " +
                     "WHERE p.id_peli = " + idPeli;
        List<Map<String, Object>> infoPelis = AppData.getInstance().query(sql);
        
        if (!infoPelis.isEmpty()) {
            Map<String, Object> peli = infoPelis.get(0);
            System.out.println("ID: " + peli.get("id_peli") + 
                               ", Títol: " + peli.get("titol") + 
                               ", Any d'Estrena: " + peli.get("any_estrena") + 
                               ", Durada: " + peli.get("durada") + " minuts" + 
                               ", Director: " + peli.get("director") + 
                               ", Sala de Projecció: " + (peli.get("sala") != null ? peli.get("sala") : "No assignada"));
        } else {
            System.out.println("No s'ha trobat informació per a la pel·lícula amb ID: " + idPeli);
        }
    }
}
