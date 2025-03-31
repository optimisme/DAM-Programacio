package com.exercici0602;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe que gestiona la connexió a la base de dades utilitzant el patró Singleton.
 * Proporciona mètodes per connectar, tancar la connexió, actualitzar dades, inserir registres
 * i realitzar consultes transformant el ResultSet en una llista de HashMap.
 */
public class AppData {
    private static AppData instance;
    private Connection conn;

    /**
     * Constructor privat que crea la connexió a la base de dades.
     */
    private AppData() { }

    /**
     * Obté la instància única de AppData (Singleton).
     *
     * @return la instància d'AppData.
     */
    public static AppData getInstance() {
        if (instance == null) {
            instance = new AppData();
        }
        return instance;
    }

    /**
     * Estableix la connexió amb la base de dades SQLite.
     * L'arxiu de la base de dades és "./data/exercici1400.sqlite".
     * Es desactiva l'autocommit per permetre el control manual de transaccions.
     */
    public void connect(String filePath) {
        String url = "jdbc:sqlite:" + filePath;
        try {
            conn = DriverManager.getConnection(url);
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Tanca la connexió a la base de dades.
     */
    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Executa una actualització a la base de dades (INSERT, UPDATE, DELETE, etc.).
     * Es realitza un commit dels canvis i, en cas d'error, es fa rollback.
     *
     * @param sql la sentència SQL d'actualització a executar.
     */
    public void update(String sql) {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            conn.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                conn.rollback();
            } catch (SQLException ex) {
                System.out.println("Error en fer rollback.");
                ex.printStackTrace();
            }
        }
    }

    /**
     * Executa una inserció a la base de dades i retorna l'identificador generat.
     * Es realitza el commit de la transacció i, en cas d'error, es fa rollback.
     *
     * @param sql la sentència SQL d'inserció a executar.
     * @return l'identificador generat per la fila inserida, o -1 en cas d'error.
     */
    public int insertAndGetId(String sql) {
        int generatedId = -1;
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            conn.commit();
            try (ResultSet rs = stmt.executeQuery("SELECT last_insert_rowid()")) {
                if (rs.next()) {
                    generatedId = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                conn.rollback();
            } catch (SQLException ex) {
                System.out.println("Error during rollback.");
                ex.printStackTrace();
            }
        }
        return generatedId;
    }

    /**
     * Realitza una consulta a la base de dades i transforma el ResultSet en una ArrayList de HashMap.
     * Cada HashMap representa una fila amb claus que corresponen als noms de columna.
     *
     * @param sql la sentència SQL de consulta.
     * @return una ArrayList de HashMap amb els resultats de la consulta.
     */
    public ArrayList<HashMap<String, Object>> query(String sql) {
        ArrayList<HashMap<String, Object>> resultList = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (rs.next()) {
                HashMap<String, Object> row = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.put(metaData.getColumnLabel(i), rs.getObject(i));
                }
                resultList.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultList;
    }
}
