package com.project;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainB {

    private Connection conn;

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        
        Date date = new Date(System.currentTimeMillis());
        
        MainB app = new MainB();
        app.connect();

        // Create tables
        app.createTables();

        List<UOR268> listUOR268 = new ArrayList<>();
        listUOR268.add(new UOR268(-1, "123", 1));
        listUOR268.add(new UOR268(-1, "345", 2));

        List<ZHE524> listZHE524 = new ArrayList<>();
        listZHE524.add(new ZHE524(-1, "abc", date, "def"));
        listZHE524.add(new ZHE524(-1, "efg", date, "ijk"));

        // Inserir dades a la base de dades
        for (UOR268 elm : listUOR268) {
            int id = app.insertUOR268(elm);
            elm.setUOR201(id);
            System.out.println("Inserted UOR268 with ID: " + id);
        }

        for (ZHE524 elm : listZHE524) {
            int id = app.insertZHE524(elm);
            elm.setZHE301(id);
            System.out.println("Inserted ZHE524 with ID: " + id);
        }

        // Actualitzar un element
        UOR268 elmUOR = listUOR268.get(0);
        elmUOR.setUOR202("HOLA");
        boolean updated = app.updateUOR268(elmUOR);
        System.out.println("Updated UOR268: " + updated);
        app.commit();

        // Eliminar un element
        int idToDelete = listUOR268.get(1).getUOR201();
        boolean deleted = app.deleteUOR268(idToDelete);
        System.out.println("Deleted UOR268: " + deleted);
        app.commit();

        // Actualitzar un element
        ZHE524 elmZHE = listZHE524.get(0); 
        elmZHE.setZHE302("BLUEY");
        updated = app.updateZHE524(elmZHE);
        System.out.println("Updated ZHE524: " + updated);
        app.commit();

        // Eliminar un element
        idToDelete = listZHE524.get(1).getZHE301();
        deleted = app.deleteZHE524(idToDelete);
        System.out.println("Deleted ZHE524: " + deleted);
        app.commit();

        List<UOR268> listA = app.getAllUOR268();
        app.printList(listA);

        List<ZHE524> listB = app.getAllZHE524();
        app.printList(listB);

        // Tanca la base de dades
        app.close();
    }

    public void connect() {
        String url = "jdbc:sqlite:dades.sqlite";
        try {
            conn = DriverManager.getConnection(url);
            conn.setAutoCommit(false); 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void commit() {
        try {
            conn.commit();
        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    public void createTables() {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("DROP TABLE IF EXISTS UOR268;");
            stmt.execute("DROP TABLE IF EXISTS ZHE524;");
            stmt.execute("CREATE TABLE IF NOT EXISTS UOR268 (UOR201 INTEGER PRIMARY KEY AUTOINCREMENT, UOR202 VARCHAR(255) NOT NULL, UOR203 INT NOT NULL, FOREIGN KEY (UOR203) REFERENCES ZHE524(ZHE301));");
            stmt.execute("CREATE TABLE IF NOT EXISTS ZHE524 (ZHE301 INTEGER PRIMARY KEY AUTOINCREMENT, ZHE302 VARCHAR(255) NOT NULL, ZHE303 DATE NOT NULL, ZHE304 VARCHAR(255) NOT NULL)");
            conn.commit();
        } catch (SQLException e) {
            System.out.println("Error creating tables: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public int insertUOR268(UOR268 uor268) {
        String sql = "INSERT INTO UOR268 (UOR202, UOR203) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, uor268.getUOR202());
            stmt.setInt(2, uor268.getUOR203());
            stmt.executeUpdate();
            conn.commit();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return -1;
    }
    
    public int insertZHE524(ZHE524 qhe524) {
        String sql = "INSERT INTO ZHE524 (ZHE302, ZHE303, ZHE304) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, qhe524.getZHE302());
            stmt.setDate(2, new java.sql.Date(qhe524.getZHE303().getTime()));
            stmt.setString(3, qhe524.getZHE304());
            stmt.executeUpdate();
            conn.commit();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1); // Retorna l'ID generat
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return -1;
    }

    public boolean updateUOR268(UOR268 uor268) {
        String sql = "UPDATE UOR268 SET UOR202 = ?, UOR203 = ? WHERE UOR201 = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, uor268.getUOR202());
            stmt.setInt(2, uor268.getUOR203());
            stmt.setInt(3, uor268.getUOR201());
            
            int affectedRows = stmt.executeUpdate();
            conn.commit();
            return affectedRows > 0;
        } catch (SQLException e) {
            handleSQLException(e);
            return false;
        }
    }

    public boolean updateZHE524(ZHE524 zhe524) {
        String sql = "UPDATE ZHE524 SET ZHE302 = ?, ZHE303 = ?, ZHE304 = ? WHERE ZHE301 = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, zhe524.getZHE302());
            stmt.setDate(2, new java.sql.Date(zhe524.getZHE303().getTime()));
            stmt.setString(3, zhe524.getZHE304());
            stmt.setInt(4, zhe524.getZHE301());
    
            int affectedRows = stmt.executeUpdate();
            conn.commit();
            return affectedRows > 0;
        } catch (SQLException e) {
            handleSQLException(e);
            return false;
        }
    }

    public boolean deleteUOR268(int id) {
        String sql = "DELETE FROM UOR268 WHERE UOR201 = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int affectedRows = stmt.executeUpdate();
            conn.commit();
            return affectedRows > 0;
        } catch (SQLException e) {
            handleSQLException(e);
            return false;
        }
    }
    
    public boolean deleteZHE524(int id) {
        String sql = "DELETE FROM ZHE524 WHERE ZHE301 = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
    
            int affectedRows = stmt.executeUpdate();
            conn.commit();
            return affectedRows > 0;
        } catch (SQLException e) {
            handleSQLException(e);
            return false;
        }
    }

    public List<UOR268> getAllUOR268() {
        List<UOR268> resultList = new ArrayList<>();
        String sql = "SELECT * FROM UOR268";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:dades.sqlite");
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("UOR201");
                String uor202 = rs.getString("UOR202");
                int UOR203 = rs.getInt("UOR203");
                resultList.add(new UOR268(id, uor202, UOR203));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultList;
    }

    public List<ZHE524> getAllZHE524() {
        List<ZHE524> resultList = new ArrayList<>();
        String sql = "SELECT * FROM ZHE524";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:dades.sqlite");
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("ZHE301");
                String zhe302 = rs.getString("ZHE302");
                Date ZHE303 = rs.getDate("ZHE303");
                String ZHE304 = rs.getString("ZHE304");
                resultList.add(new ZHE524(id, zhe302, ZHE303, ZHE304));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultList;
    }

    private void handleSQLException(SQLException e) {
        System.out.println("SQL Error Code: " + e.getErrorCode());
        System.out.println("SQL State: " + e.getSQLState());
        System.out.println("Error Message: " + e.getMessage());
        e.printStackTrace();
        try {
            conn.rollback();
            System.out.println("Transaction rolled back.");
        } catch (SQLException ex) {
            System.out.println("Error rolling back transaction.");
            ex.printStackTrace();
        }
    }
    
    public <T> void printList(List<T> list) {
        for (T item : list) {
            System.out.println(item.toString());
        }
    }
}