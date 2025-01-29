package com.project;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Locale;

public class Main {

    private static String URL = "jdbc:mysql://localhost:3308/videogame_park?useSSL=false&allowPublicKeyRetrieval=true";
    private static String USER = "root";
    private static String PASSWORD = "pwd";

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

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
        if (!"test".equals(System.getProperty("environment"))) {
            System.exit(0);
        }
    }
}
