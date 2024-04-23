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

    private static void crearTaulaEditorials() {

        String sql = "CREATE TABLE IF NOT EXISTS editorials (" +
                     "id_editorial INTEGER PRIMARY KEY," +
                     "nom TEXT NOT NULL)";

        AppData db = AppData.getInstance();
        db.update("DROP TABLE IF EXISTS editorials");
        db.update(sql);
    }

    private static void crearTaulaLlibres() {

        String sql = "CREATE TABLE IF NOT EXISTS llibres (" +
                     "id_llibre INTEGER PRIMARY KEY," +
                     "titol TEXT NOT NULL," +
                     "autor TEXT NOT NULL," +
                     "any_publicacio INTEGER," +
                     "id_editorial INTEGER," +
                     "FOREIGN KEY(id_editorial) REFERENCES editorials(id_editorial))";

        AppData db = AppData.getInstance();
        db.update("DROP TABLE IF EXISTS llibres");
        db.update(sql);
    }

    private static void afegirEditorial(String nom) {

        AppData db = AppData.getInstance();

        String sql = "INSERT INTO editorials(nom) VALUES('" + nom + "')";
        db.update(sql);
    }

    private static void afegirLlibre(String titol, String autor, int anyPublicacio, int idEditorial) {

        AppData db = AppData.getInstance();

        String sql = "INSERT INTO llibres(titol, autor, any_publicacio, id_editorial) VALUES('" +
                     titol + "', '" + autor + "', " + anyPublicacio + ", " + idEditorial + ")";
        db.update(sql);
    }

    private static void llistarTaulaEditorials() {

        AppData db = AppData.getInstance();

        String sql = "SELECT * FROM editorials";
        List<Map<String, Object>> editorials = db.query(sql);

        for (Map<String, Object> editorial : editorials) {
            System.out.println("ID: " + editorial.get("id_editorial") + ", Nom: " + editorial.get("nom"));
        }
    }

    private static void llistarTaulaLlibres() {

        AppData db = AppData.getInstance();

        String sql = "SELECT l.id_llibre, l.titol, l.autor, l.any_publicacio, e.nom AS editorial " +
                     "FROM llibres l " +
                     "JOIN editorials e ON l.id_editorial = e.id_editorial";
        List<Map<String, Object>> llibres = db.query(sql);

        for (Map<String, Object> llibre : llibres) {
            System.out.println("ID: " + llibre.get("id_llibre") + ", Títol: " + llibre.get("titol") + 
                               ", Autor: " + llibre.get("autor") + ", Any: " + llibre.get("any_publicacio") +
                               ", Editorial: " + llibre.get("editorial"));
        }
    }

    private static void llistarInfoLlibre(int idLlibre) {

        AppData db = AppData.getInstance();

        String sql = "SELECT l.id_llibre, l.titol, l.autor, l.any_publicacio, e.nom AS editorial " +
                     "FROM llibres l " +
                     "JOIN editorials e ON l.id_editorial = e.id_editorial " +
                     "WHERE l.id_llibre = " + idLlibre;
        List<Map<String, Object>> resultats = db.query(sql);

        if (resultats.isEmpty()) {
            System.out.println("No s'ha trobat cap llibre amb l'ID: " + idLlibre);
            return;
        }

        Map<String, Object> llibre = resultats.get(0); // Suposem que l'ID és únic, per tant només hi haurà un resultat
        System.out.println("ID: " + llibre.get("id_llibre") + ", Títol: " + llibre.get("titol") +
                           ", Autor: " + llibre.get("autor") + ", Any de Publicació: " + llibre.get("any_publicacio") +
                           ", Editorial: " + llibre.get("editorial"));
    }
}
