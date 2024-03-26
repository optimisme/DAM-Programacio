package com.project;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3308/persones";
        String user = "root"; // El teu usuari de MySQL
        String password = "pwd"; // La teva contrasenya de MySQL

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            // Important per a poder fer insercions i actualitzacions
            conn.setAutoCommit(false); 

            // Inicialitza les dades
            initData(conn); 

            System.out.println("\nDades inicials de la taula 'persones':");
            showData(conn);

            // Actualitza les dades
            updateData(conn);

            System.out.println("\nDades modificades de la taula 'persones':");
            showData(conn);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        // Forçar la sortida del programa per no esperar a tancar la connexió amb 'MySQL'
        // Assegura't que en aquest punt totes les dades s'han guardat correctament
        System.exit(0);
    }

    public static void initData(Connection conn) {
        try (Statement stmt = conn.createStatement()) {
            // Esborrar la taula 'persones' si existeix
            stmt.execute("DROP TABLE IF EXISTS persones");
    
            // Crear la taula 'persones'
            stmt.execute("CREATE TABLE IF NOT EXISTS persones (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "nom TEXT NOT NULL," +
                "edat INTEGER)");
    
            // Inserir dades a la taula 'persones'
            stmt.execute("INSERT INTO persones (nom, edat) VALUES ('Anna', 25)");
            stmt.execute("INSERT INTO persones (nom, edat) VALUES ('Marc', 30)");
            stmt.execute("INSERT INTO persones (nom, edat) VALUES ('Jordi', 45)");
            stmt.execute("INSERT INTO persones (nom, edat) VALUES ('Clara', 22)");
            stmt.execute("INSERT INTO persones (nom, edat) VALUES ('Pau', 35)");
    
            conn.commit(); // Confirma els canvis
            System.out.println("La base de dades ha estat inicialitzada amb èxit.");
        } catch (SQLException e) {
            try {
                conn.rollback(); // Reverteix els canvis
                System.out.println("Rollback realitzat degut a un error.");
            } catch (SQLException ex) {
                System.out.println("Error en intentar fer rollback.");
                ex.printStackTrace();
            }
            System.out.println(e.getMessage());
        }
    }

    public static void updateData(Connection conn) {
        try (Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
    
            ResultSet rs = stmt.executeQuery("SELECT * FROM persones");
    
            // Inserir una nova fila amb 'insertRow'
            rs.moveToInsertRow();
            rs.updateString("nom", "Joan");
            rs.updateInt("edat", 30);
            rs.insertRow();
    
            // Actualitzar la fila de 'Marc' a 'Marc Garcia' amb 'updateRow'
            rs.beforeFirst(); // Torna al principi del ResultSet
            while (rs.next()) {
                if (rs.getString("nom").equals("Marc")) {
                    rs.updateString("nom", "Markus");
                    rs.updateRow();
                }
            }
    
            conn.commit(); // Confirma els canvis
            System.out.println("Les dades han estat actualitzades amb èxit.");
            rs.close();
        } catch (SQLException e) {
            try {
                conn.rollback(); // Reverteix els canvis
                System.out.println("Rollback realitzat degut a un error.");
            } catch (SQLException ex) {
                System.out.println("Error en intentar fer rollback.");
                ex.printStackTrace();
            }
            System.out.println(e.getMessage());
        }
    }
  
    public static void showData(Connection conn) {
        String query = "SELECT * FROM persones";
    
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
     
            // Obtenir metadades del ResultSet per saber el nombre de columnes
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
    
            // Mostrar noms de columnes
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rsmd.getColumnName(i) + "\t");
            }
            System.out.println();
    
            // Recorrer i mostrar les files
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String value = rs.getString(i);
                    System.out.print(value + "\t");
                }
                System.out.println(); // Salta a la següent línia després de cada fila
            }

            conn.commit(); // Confirma els canvis
            rs.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
