package com.exemple1401;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe que gestiona la connexió a la base de dades MySQL utilitzant el patró Singleton.
 * Proporciona mètodes per connectar, tancar la connexió, executar actualitzacions, inserir registres
 * i realitzar consultes transformant el ResultSet en un ArrayList de HashMap.
 */
public class AppData {
    private static AppData instance;
    private Connection conn;

    /**
     * Constructor privat que estableix la connexió a la base de dades.
     */
    private AppData() {  }

    /**
     * Retorna la instància única d'AppData.
     *
     * @return la instància de AppData.
     */
    public static AppData getInstance() {
        if (instance == null) {
            instance = new AppData();
        }
        return instance;
    }

    /**
     * Estableix la connexió amb la base de dades MySQL.
     * Utilitza la URL, l'usuari i la contrasenya especificats.
     * Desactiva l'autocommit per permetre el control manual de les transaccions.
     */
    public void connect(String path, String user, String password) {
        String url = "jdbc:mysql:" + path;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false); // Desactiva l'autocommit per control manual de transaccions
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error connectant a la base de dades MySQL.");
            e.printStackTrace();
        }
    }

    /**
     * Tanca la connexió amb la base de dades.
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
     * Executa una actualització (INSERT, UPDATE, DELETE, etc.) a la base de dades.
     * Realitza un commit dels canvis. En cas d'error, es fa rollback.
     *
     * @param sql la sentència SQL d'actualització a executar.
     */
    public void update(String sql) {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            conn.commit(); // Confirma els canvis
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                conn.rollback(); // Reverteix els canvis en cas d'error
            } catch (SQLException ex) {
                System.out.println("Error en fer rollback.");
                ex.printStackTrace();
            }
        }
    }

    /**
     * Executa una inserció a la base de dades i retorna l'identificador generat.
     * En cas d'error, es fa rollback i es retorna -1.
     *
     * @param sql la sentència SQL d'inserció a executar.
     * @return l'identificador generat o -1 si hi ha hagut un error.
     */
    public int insertAndGetId(String sql) {
        int generatedId = -1;
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                generatedId = rs.getInt(1); // Obtenir el primer camp com a ID generat
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                conn.rollback();
            } catch (SQLException ex) {
                System.out.println("Error en fer rollback.");
                ex.printStackTrace();
            }
        }
        return generatedId;
    }

    /**
     * Realitza una consulta a la base de dades i transforma el ResultSet en un ArrayList de HashMap.
     * Cada HashMap representa una fila, on les claus són els noms de les columnes i els valors són els
     * objectes corresponents.
     *
     * @param sql la sentència SQL de consulta.
     * @return un ArrayList de HashMap amb les files resultants de la consulta.
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
