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
        connect();
    }

    public static AppData getInstance() {
        if (instance == null) {
            instance = new AppData();
        }
        return instance;
    }

    private void connect() {
        // Canvia aquestes variables per les teves credencials reals
        String url = "jdbc:mysql://localhost:3308/world?useSSL=false"; // Utilitza el port 3308 i la base de dades 'world'
        String user = "root"; // El teu usuari de MySQL
        String password = "pwd"; // La teva contrasenya de MySQL

        try {
            // Assegura't que el controlador JDBC de MySQL estigui carregat
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("No es pot trobar el controlador JDBC de MySQL.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error connectant a la base de dades MySQL.");
            e.printStackTrace();
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
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Map<String, Object>> query(String sql) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.put(metaData.getColumnName(i), rs.getObject(i));
                }
                resultList.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultList;
    }
}
