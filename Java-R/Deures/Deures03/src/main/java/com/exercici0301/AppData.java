package com.project;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AppData {
    private static AppData instance;
    private Connection conn;

    private AppData() {
        // Connecta al crear la primera instància
        connect();
    }

    // Singleton
    public static AppData getInstance() {
        if (instance == null) {
            instance = new AppData();
        }
        return instance;
    }

    private void connect() {
        String url = "jdbc:sqlite:dades.sqlite"; // Nom de l'arxiu amb les dades 'dades.sqlite'
        try {
            conn = DriverManager.getConnection(url);
            conn.setAutoCommit(false); // Desactiva l'autocommit per permetre control manual de transaccions
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void close() {
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

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

    public int insertAndGetId(String sql) {
        int generatedId = -1;
        try (Statement stmt = conn.createStatement()) {
            // Execute the update
            stmt.executeUpdate(sql);
            conn.commit();  // Make sure to commit the transaction if auto-commit is disabled
    
            // Query the last inserted row ID
            try (ResultSet rs = stmt.executeQuery("SELECT last_insert_rowid()")) {
                if (rs.next()) {
                    generatedId = rs.getInt(1); // Retrieve the last inserted ID
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                conn.rollback(); // Rollback the transaction in case of error
            } catch (SQLException ex) {
                System.out.println("Error during rollback.");
                ex.printStackTrace();
            }
        }
        return generatedId;
    }
    
    // Aquesta funció transforma el ResultSet en un Map<String, Object>
    // per fer l'accés a la informació més genèric
    public List<Map<String, Object>> query(String sql) {
        List<Map<String, Object>> resultList = new ArrayList<>();

        // try-with-resources tancarà el ResultSet quan acabi el bloc
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
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
