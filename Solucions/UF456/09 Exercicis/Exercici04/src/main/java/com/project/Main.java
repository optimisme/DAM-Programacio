package com.project;

import java.math.BigDecimal;
import java.sql.*;

public class Main {

    private static String URL = "jdbc:mysql://localhost:3308/videogame_park?useSSL=false&allowPublicKeyRetrieval=true";
    private static String USER = "root";
    private static String PASSWORD = "pwd";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            conn.setAutoCommit(false); // Important per controlar manualment les transaccions

            crearTaules(conn);
            afegirArea(conn, "Zona Arcade", "Arcade", 100);
            afegirArea(conn, "Zona VR", "Realitat Virtual", 50);
            afegirTarifa(conn, "Passi Bàsic", new BigDecimal("19.99"), 1);
            afegirTarifa(conn, "Passi Premium", new BigDecimal("39.99"), 3);

            int idZonaArcade = obtenirIdAreaPerNom(conn, "Zona Arcade");
            int idZonaVR = obtenirIdAreaPerNom(conn, "Zona VR");
            int idPassiBasic = obtenirIdTarifaPerNom(conn, "Passi Bàsic");
            int idPassiPremium = obtenirIdTarifaPerNom(conn, "Passi Premium");

            definirAccesAreaTarifa(conn, idZonaArcade, idPassiBasic);
            definirAccesAreaTarifa(conn, idZonaArcade, idPassiPremium);
            definirAccesAreaTarifa(conn, idZonaVR, idPassiPremium);

            conn.commit(); // Confirmar totes les operacions al final

            llistarArees(conn);
            llistarTarifes(conn);
            llistarTarifesPerAccesArea(conn, idZonaArcade);
            llistarAreesAccesiblesPerTarifa(conn, idPassiBasic);
            llistarAreesAccesiblesPerTarifa(conn, idPassiPremium);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Forçar la sortida del programa per no esperar a tancar la connexió amb 'MySQL'
        // Assegura't que en aquest punt totes les dades s'han guardat correctament
        if (!"test".equals(System.getProperty("enviroment"))) {
            System.exit(0);
        }
    }

    private static void crearTaules(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("SET FOREIGN_KEY_CHECKS=0;");
            stmt.execute("DROP TABLE IF EXISTS acces_area_tarifa");
            stmt.execute("DROP TABLE IF EXISTS tarifes");
            stmt.execute("DROP TABLE IF EXISTS arees");
            stmt.execute("CREATE TABLE arees (" +
                            "id_area INTEGER AUTO_INCREMENT," +
                            "nom TEXT," +
                            "tematica TEXT," +
                            "capacitat_maxima INTEGER," +
                            "PRIMARY KEY (id_area))");
            stmt.execute("CREATE TABLE tarifes (" +
                            "id_tarifa INTEGER AUTO_INCREMENT," +
                            "nom TEXT," +
                            "preu DECIMAL(10,2)," +
                            "durada INTEGER," +
                            "PRIMARY KEY (id_tarifa))");
            stmt.execute("CREATE TABLE acces_area_tarifa (" +
                            "id_area INTEGER," +
                            "id_tarifa INTEGER," +
                            "FOREIGN KEY (id_area) REFERENCES arees(id_area)," +
                            "FOREIGN KEY (id_tarifa) REFERENCES tarifes(id_tarifa))");
        }
    }
    
    private static void afegirArea(Connection conn, String nom, String tematica, int capacitatMaxima) throws SQLException {
        String sql = "INSERT INTO arees (nom, tematica, capacitat_maxima) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nom);
            pstmt.setString(2, tematica);
            pstmt.setInt(3, capacitatMaxima);
            pstmt.executeUpdate();
        }
    }

    private static void afegirTarifa(Connection conn, String nom, BigDecimal preu, int durada) throws SQLException {
        String sql = "INSERT INTO tarifes (nom, preu, durada) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nom);
            pstmt.setBigDecimal(2, preu);
            pstmt.setInt(3, durada);
            pstmt.executeUpdate();
        }
    }

    private static void definirAccesAreaTarifa(Connection conn, int idArea, int idTarifa) throws SQLException {
        String sql = "INSERT INTO acces_area_tarifa (id_area, id_tarifa) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idArea);
            pstmt.setInt(2, idTarifa);
            pstmt.executeUpdate();
        }
    }

    private static void llistarArees(Connection conn) throws SQLException {
        String sql = "SELECT * FROM arees";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_area") + ", Nom: " + rs.getString("nom") + ", Temàtica: " + rs.getString("tematica") + ", Capacitat Màxima: " + rs.getInt("capacitat_maxima"));
            }
        }
    }

    private static void llistarTarifes(Connection conn) throws SQLException {
        String sql = "SELECT * FROM tarifes";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_tarifa") + ", Nom: " + rs.getString("nom") + ", Preu: " + rs.getBigDecimal("preu") + ", Durada: " + rs.getInt("durada") + " dies");
            }
        }
    }

    private static void llistarAreesAccesiblesPerTarifa(Connection conn, int idTarifa) throws SQLException {
        String sql = "SELECT a.nom FROM arees a JOIN acces_area_tarifa aat ON a.id_area = aat.id_area WHERE aat.id_tarifa = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idTarifa);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    System.out.println("Àrea: " + rs.getString("nom"));
                }
            }
        }
    }

    private static void llistarTarifesPerAccesArea(Connection conn, int idArea) throws SQLException {
        String sql = "SELECT t.nom FROM tarifes t JOIN acces_area_tarifa aat ON t.id_tarifa = aat.id_tarifa WHERE aat.id_area = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idArea);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    System.out.println("Tarifa: " + rs.getString("nom"));
                }
            }
        }
    }

    private static int obtenirIdAreaPerNom(Connection conn, String nomArea) throws SQLException {
        String sql = "SELECT id_area FROM arees WHERE nom = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nomArea);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id_area");
                }
            }
        }
        return -1; // Si no es troba l'àrea
    }

    private static int obtenirIdTarifaPerNom(Connection conn, String nomTarifa) throws SQLException {
        String sql = "SELECT id_tarifa FROM tarifes WHERE nom = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nomTarifa);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id_tarifa");
                }
            }
        }
        return -1; // Si no es troba la tarifa
    }
}
