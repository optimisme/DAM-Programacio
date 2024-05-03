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
    }

    public int insertUOR268(UOR268 uor268) {
        return -1;
    }
    
    public int insertZHE524(ZHE524 qhe524) {
        return -1;
    }

    public boolean updateUOR268(UOR268 uor268) {
        return false;
    }

    public boolean updateZHE524(ZHE524 zhe524) {
        return false;
    }

    public boolean deleteUOR268(int id) {
        return false;
    }
    
    public boolean deleteZHE524(int id) {
    }

    public List<UOR268> getAllUOR268() {
        List<UOR268> resultList = new ArrayList<>();
        return resultList;
    }

    public List<ZHE524> getAllZHE524() {
        List<ZHE524> resultList = new ArrayList<>();
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