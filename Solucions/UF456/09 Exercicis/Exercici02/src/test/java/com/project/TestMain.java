package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.io.File;
import java.sql.*;
import java.util.Locale;

public class TestMain {

    @Test
    public void testMainOutput() throws Exception {

        System.setProperty("environment", "test");

        String text = SystemLambda.tapSystemOut(() -> {
            // Executa el main per a provar la seva sortida
            String[] args = {}; // Passa els arguments necessaris si n'hi ha
            Main.main(args);
        });
        text = text.replace("\r\n", "\n");

        // Comprova que la sortida conté el text esperat
        String expectedOutput = """
            
            Restaurants:
            ID: 1, Name: The Gourmet Kitchen, Kind: Italian, Tables: 10, Pricing: High
            ID: 2, Name: Casual Diner, Kind: American, Tables: 5, Pricing: Medium
            ID: 3, Name: Seafood Paradise, Kind: Seafood, Tables: 8, Pricing: High
            ID: 4, Name: Veggie Delight, Kind: Vegetarian, Tables: 12, Pricing: Medium
            ID: 5, Name: Sushi Corner, Kind: Japanese, Tables: 15, Pricing: High
            
            Clients:
            ID: 1, Name: John Doe, Birth: 1985-02-15, VIP: Yes
            ID: 2, Name: Jane Smith, Birth: 1990-07-23, VIP: No
            ID: 3, Name: Alice Johnson, Birth: 1975-11-30, VIP: No
            ID: 4, Name: Bob Lee, Birth: 1988-06-15, VIP: Yes
            ID: 5, Name: Charlie Brown, Birth: 1993-03-12, VIP: No
            ID: 6, Name: Emma Wilson, Birth: 1981-09-25, VIP: Yes
            ID: 7, Name: Noah Miller, Birth: 1994-04-14, VIP: No
            ID: 8, Name: Olivia Davis, Birth: 1979-12-05, VIP: Yes
            
            Services:
            Service ID: 1, Restaurant ID: 1, Client ID: 1, Date: 2023-04-01, Expenditure: 120.5
            Service ID: 2, Restaurant ID: 2, Client ID: 2, Date: 2023-04-02, Expenditure: 45.0
            Service ID: 3, Restaurant ID: 3, Client ID: 3, Date: 2023-05-10, Expenditure: 200.0
            Service ID: 4, Restaurant ID: 4, Client ID: 4, Date: 2023-05-11, Expenditure: 150.0
            Service ID: 5, Restaurant ID: 5, Client ID: 5, Date: 2023-05-12, Expenditure: 200.0
            Service ID: 6, Restaurant ID: 5, Client ID: 5, Date: 2023-05-14, Expenditure: 250.0
            Service ID: 7, Restaurant ID: 5, Client ID: 5, Date: 2023-05-16, Expenditure: 350.0
            Service ID: 8, Restaurant ID: 5, Client ID: 5, Date: 2023-05-18, Expenditure: 300.0
            Service ID: 9, Restaurant ID: 1, Client ID: 6, Date: 2023-05-15, Expenditure: 220.0
            Service ID: 10, Restaurant ID: 2, Client ID: 7, Date: 2023-05-16, Expenditure: 50.0
            Service ID: 11, Restaurant ID: 1, Client ID: 8, Date: 2023-05-17, Expenditure: 180.0
            Service ID: 12, Restaurant ID: 1, Client ID: 1, Date: 2023-06-01, Expenditure: 135.0
            Service ID: 13, Restaurant ID: 1, Client ID: 2, Date: 2023-06-02, Expenditure: 95.0
            Service ID: 14, Restaurant ID: 2, Client ID: 1, Date: 2023-06-03, Expenditure: 78.0
            Service ID: 15, Restaurant ID: 2, Client ID: 3, Date: 2023-06-04, Expenditure: 120.0
            Service ID: 16, Restaurant ID: 1, Client ID: 4, Date: 2023-06-05, Expenditure: 200.0
            Service ID: 17, Restaurant ID: 2, Client ID: 2, Date: 2023-07-01, Expenditure: 60.0
            Service ID: 18, Restaurant ID: 3, Client ID: 2, Date: 2023-07-02, Expenditure: 130.0
            Service ID: 19, Restaurant ID: 5, Client ID: 2, Date: 2023-07-03, Expenditure: 140.0
            Service ID: 20, Restaurant ID: 5, Client ID: 2, Date: 2023-07-05, Expenditure: 100.0
            Service ID: 21, Restaurant ID: 1, Client ID: 4, Date: 2023-07-04, Expenditure: 160.0
            Service ID: 22, Restaurant ID: 4, Client ID: 4, Date: 2023-07-05, Expenditure: 70.0
            Service ID: 23, Restaurant ID: 4, Client ID: 4, Date: 2023-07-06, Expenditure: 50.0
            Service ID: 24, Restaurant ID: 2, Client ID: 4, Date: 2023-07-06, Expenditure: 40.0
            Service ID: 25, Restaurant ID: 1, Client ID: 6, Date: 2023-07-07, Expenditure: 100.0
            Service ID: 26, Restaurant ID: 5, Client ID: 6, Date: 2023-07-08, Expenditure: 360.0
            Service ID: 27, Restaurant ID: 5, Client ID: 6, Date: 2023-07-09, Expenditure: 280.0
            Service ID: 28, Restaurant ID: 4, Client ID: 6, Date: 2023-07-09, Expenditure: 60.0
            Service ID: 29, Restaurant ID: 4, Client ID: 6, Date: 2023-07-10, Expenditure: 80.0
            
            Client 1 services:
            Client ID: 1, Client Name: John Doe, Date: 2023-04-01, Expenditure: 120.5, Restaurant Name: The Gourmet Kitchen, Restaurant Kind: Italian, below PKT average price
            Client ID: 1, Client Name: John Doe, Date: 2023-06-01, Expenditure: 135.0, Restaurant Name: The Gourmet Kitchen, Restaurant Kind: Italian, below PKT average price
            Client ID: 1, Client Name: John Doe, Date: 2023-06-03, Expenditure: 78.0, Restaurant Name: Casual Diner, Restaurant Kind: American, above PKT average price
            
            Client 4 services:
            Client ID: 4, Client Name: Bob Lee, Date: 2023-05-11, Expenditure: 150.0, Restaurant Name: Veggie Delight, Restaurant Kind: Vegetarian, above PKT average price
            Client ID: 4, Client Name: Bob Lee, Date: 2023-06-05, Expenditure: 200.0, Restaurant Name: The Gourmet Kitchen, Restaurant Kind: Italian, above PKT average price
            Client ID: 4, Client Name: Bob Lee, Date: 2023-07-04, Expenditure: 160.0, Restaurant Name: The Gourmet Kitchen, Restaurant Kind: Italian, above PKT average price
            Client ID: 4, Client Name: Bob Lee, Date: 2023-07-05, Expenditure: 70.0, Restaurant Name: Veggie Delight, Restaurant Kind: Vegetarian, below PKT average price
            Client ID: 4, Client Name: Bob Lee, Date: 2023-07-06, Expenditure: 50.0, Restaurant Name: Veggie Delight, Restaurant Kind: Vegetarian, below PKT average price
            Client ID: 4, Client Name: Bob Lee, Date: 2023-07-06, Expenditure: 40.0, Restaurant Name: Casual Diner, Restaurant Kind: American, below PKT average price
            
            Client 6 services:
            Client ID: 6, Client Name: Emma Wilson, Date: 2023-05-15, Expenditure: 220.0, Restaurant Name: The Gourmet Kitchen, Restaurant Kind: Italian, above PKT average price
            Client ID: 6, Client Name: Emma Wilson, Date: 2023-07-07, Expenditure: 100.0, Restaurant Name: The Gourmet Kitchen, Restaurant Kind: Italian, below PKT average price
            Client ID: 6, Client Name: Emma Wilson, Date: 2023-07-08, Expenditure: 360.0, Restaurant Name: Sushi Corner, Restaurant Kind: Japanese, above PKT average price
            Client ID: 6, Client Name: Emma Wilson, Date: 2023-07-09, Expenditure: 280.0, Restaurant Name: Sushi Corner, Restaurant Kind: Japanese, above PKT average price
            Client ID: 6, Client Name: Emma Wilson, Date: 2023-07-09, Expenditure: 60.0, Restaurant Name: Veggie Delight, Restaurant Kind: Vegetarian, below PKT average price
            Client ID: 6, Client Name: Emma Wilson, Date: 2023-07-10, Expenditure: 80.0, Restaurant Name: Veggie Delight, Restaurant Kind: Vegetarian, above PKT average price
            
            Restaurant 1 clients:
            Client ID: 1, Client Name: John Doe, Average expenditure: 127.75
            Client ID: 2, Client Name: Jane Smith, Average expenditure: 95.0
            Client ID: 4, Client Name: Bob Lee, Average expenditure: 180.0
            Client ID: 6, Client Name: Emma Wilson, Average expenditure: 160.0
            Client ID: 8, Client Name: Olivia Davis, Average expenditure: 180.0
            
            Restaurant 4 clients:
            Client ID: 4, Client Name: Bob Lee, Average expenditure: 90.0
            Client ID: 6, Client Name: Emma Wilson, Average expenditure: 70.0
            
            Restaurant 5 clients:
            Client ID: 2, Client Name: Jane Smith, Average expenditure: 120.0
            Client ID: 5, Client Name: Charlie Brown, Average expenditure: 275.0
            Client ID: 6, Client Name: Emma Wilson, Average expenditure: 320.0
            """.replace("\r\n", "\n").replace("            ","");
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0, 
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                diff +
                "<<<<<<<<<< <<<<<<<<<<\n");
    }

    @Test
    public void testMainTables() throws SQLException {
        System.setProperty("environment", "test");
        String url = "jdbc:sqlite:dades.sqlite";

        File dbFile = new File("dades.sqlite");
        assertTrue(dbFile.exists(), "The database file does not exist.");

        try (Connection conn = DriverManager.getConnection(url)) {
            DatabaseMetaData dbMetaData = conn.getMetaData();

            // Check for existence of restaurants table
            checkTableExists(dbMetaData, "restaurants", "name", "kind", "tables", "pricing");

            // Check for existence of clients table
            checkTableExists(dbMetaData, "clients", "name", "birth", "isVIP");

            // Check for existence of services table
            checkTableExists(dbMetaData, "services", "id_restaurant", "id_client", "date", "expenditure");

            // Check foreign keys for services table
            checkForeignKey(dbMetaData, "services", "restaurants", "id_restaurant");
            checkForeignKey(dbMetaData, "services", "clients", "id_client");
        }
    }

    private void checkTableExists(DatabaseMetaData metaData, String tableName, String... columnNames) throws SQLException {
        try (ResultSet rs = metaData.getTables(null, null, tableName, null)) {
            assertTrue(rs.next(), "Table " + tableName + " does not exist.");
        }

        for (String columnName : columnNames) {
            try (ResultSet rs = metaData.getColumns(null, null, tableName, columnName)) {
                assertTrue(rs.next(), "Column " + columnName + " does not exist in table " + tableName);
            }
        }
    }

    private void checkForeignKey(DatabaseMetaData metaData, String tableName, String pkTableName, String fkColumnName) throws SQLException {
        try (ResultSet rs = metaData.getImportedKeys(null, null, tableName)) {
            boolean foundFK = false;
            while (rs.next()) {
                if (pkTableName.equals(rs.getString("PKTABLE_NAME")) && fkColumnName.equals(rs.getString("FKCOLUMN_NAME"))) {
                    foundFK = true;
                    break;
                }
            }
            assertTrue(foundFK, "The table " + tableName + " does not have the correct foreign key relation with " + pkTableName);
        }
    }


    @Test
    public void testMainCalls() throws Exception {

        Locale.setDefault(Locale.US);
        Class<Main> clazz = Main.class;

        // Check for methods related to creating, adding, and listing entries
        assertMethod(clazz, "createTables", true, false, "The createTables method should be defined correctly.");
        assertMethod(clazz, "addRestaurant", true, false, "The addRestaurant method should be defined correctly.", String.class, String.class, int.class, String.class);
        assertMethod(clazz, "addClient", true, false, "The addClient method should be defined correctly.", String.class, String.class, boolean.class);
        assertMethod(clazz, "addService", true, false, "The addService method should be defined correctly.", int.class, int.class, String.class, double.class);
        assertMethod(clazz, "listRestaurants", true, false, "The listRestaurants method should be defined correctly.");
        assertMethod(clazz, "listClients", true, false, "The listClients method should be defined correctly.");
        assertMethod(clazz, "listServices", true, false, "The listServices method should be defined correctly.");
        assertMethod(clazz, "listClientServices", true, false, "The listClientServices method should be defined correctly.", int.class);
        assertMethod(clazz, "comparePrice", true, false, "The comparePrice method should be defined correctly.", double.class, String.class);
        assertMethod(clazz, "listRestaurantClients", true, false, "The listRestaurantClients method should be defined correctly.", int.class);
    }

    private void assertMethod(Class<?> clazz, String methodName, boolean shouldBeStatic, boolean shouldBePrivate, String message, Class<?>... parameterTypes) throws NoSuchMethodException {
        // Utilitza getDeclaredMethod per accedir a mètodes privats
        Method method = clazz.getDeclaredMethod(methodName, parameterTypes);
    
        // Comprova si el mètode és estàtic
        boolean isStatic = Modifier.isStatic(method.getModifiers());
        assertEquals(shouldBeStatic, isStatic, message + " El mètode hauria de ser " + (shouldBeStatic ? "static" : "no static") + ".");
    
        // Comprova si el mètode és privat
        boolean isPrivate = Modifier.isPrivate(method.getModifiers());
        assertEquals(shouldBePrivate, isPrivate, message + " El mètode hauria de ser " + (shouldBePrivate ? "privat" : "no privat") + ".");
    }

    @Test
    public void testMainExtra() throws Exception {
        String text = SystemLambda.tapSystemOut(() -> {
            AppData db = AppData.getInstance();

            // Create tables
            Main.createTables();

            Main.addRestaurant("A", "B", 10, "C");
            Main.addRestaurant("D", "E", 40, "F");
            Main.addRestaurant("G", "H", 60, "I");
            Main.addRestaurant("J", "K", 90, "L");
            Main.addRestaurant("M", "N", 500, "O");

            Main.addClient("AA", "1985-01-01", true);
            Main.addClient("AB", "1990-07-02", true);
            Main.addClient("AC", "1975-11-10", false);

            Main.addService(1, 1, "2023-04-01", 11);
            Main.addService(1, 2, "2023-04-02", 41);
            Main.addService(1, 3, "2023-04-03", 61);
            Main.addService(1, 4, "2023-04-04", 91);
            Main.addService(2, 2, "2023-04-01", 21);
            Main.addService(2, 3, "2023-04-02", 61);
            Main.addService(2, 4, "2023-04-03", 91);
            Main.addService(2, 5, "2023-04-04", 401);
            Main.addService(3, 1, "2023-04-01", 11);
            Main.addService(3, 5, "2023-04-02", 41);

            // List entries
            System.out.println("\nRestaurants:");
            Main.listRestaurants();

            System.out.println("\nClients:");
            Main.listClients();

            System.out.println("\nServices:");
            Main.listServices();

            System.out.println("\nClient 1 services:");
            Main.listClientServices(1);

            System.out.println("\nClient 4 services:");
            Main.listClientServices(4);

            System.out.println("\nClient 6 services:");
            Main.listClientServices(6);

            System.out.println("\nRestaurant 1 clients:");
            Main.listRestaurantClients(1);

            System.out.println("\nRestaurant 2 clients:");
            Main.listRestaurantClients(2);

            System.out.println("\nRestaurant 4 clients:");
            Main.listRestaurantClients(4);

            // Close the database connection
            db.close();
        });

        text = text.replace("\r\n", "\n");

        String expectedOutput = """
            
            Restaurants:
            ID: 1, Name: A, Kind: B, Tables: 10, Pricing: C
            ID: 2, Name: D, Kind: E, Tables: 40, Pricing: F
            ID: 3, Name: G, Kind: H, Tables: 60, Pricing: I
            ID: 4, Name: J, Kind: K, Tables: 90, Pricing: L
            ID: 5, Name: M, Kind: N, Tables: 500, Pricing: O

            Clients:
            ID: 1, Name: AA, Birth: 1985-01-01, VIP: Yes
            ID: 2, Name: AB, Birth: 1990-07-02, VIP: Yes
            ID: 3, Name: AC, Birth: 1975-11-10, VIP: No

            Services:
            Service ID: 1, Restaurant ID: 1, Client ID: 1, Date: 2023-04-01, Expenditure: 11.0
            Service ID: 2, Restaurant ID: 1, Client ID: 2, Date: 2023-04-02, Expenditure: 41.0
            Service ID: 3, Restaurant ID: 1, Client ID: 3, Date: 2023-04-03, Expenditure: 61.0
            Service ID: 4, Restaurant ID: 1, Client ID: 4, Date: 2023-04-04, Expenditure: 91.0
            Service ID: 5, Restaurant ID: 2, Client ID: 2, Date: 2023-04-01, Expenditure: 21.0
            Service ID: 6, Restaurant ID: 2, Client ID: 3, Date: 2023-04-02, Expenditure: 61.0
            Service ID: 7, Restaurant ID: 2, Client ID: 4, Date: 2023-04-03, Expenditure: 91.0
            Service ID: 8, Restaurant ID: 2, Client ID: 5, Date: 2023-04-04, Expenditure: 401.0
            Service ID: 9, Restaurant ID: 3, Client ID: 1, Date: 2023-04-01, Expenditure: 11.0
            Service ID: 10, Restaurant ID: 3, Client ID: 5, Date: 2023-04-02, Expenditure: 41.0

            Client 1 services:
            Client ID: 1, Client Name: AA, Date: 2023-04-01, Expenditure: 11.0, Restaurant Name: A, Restaurant Kind: B, below PKT average price
            Client ID: 1, Client Name: AA, Date: 2023-04-01, Expenditure: 11.0, Restaurant Name: G, Restaurant Kind: H, below PKT average price

            Client 4 services:

            Client 6 services:

            Restaurant 1 clients:
            Client ID: 1, Client Name: AA, Average expenditure: 11.0
            Client ID: 2, Client Name: AB, Average expenditure: 41.0
            Client ID: 3, Client Name: AC, Average expenditure: 61.0

            Restaurant 2 clients:
            Client ID: 2, Client Name: AB, Average expenditure: 21.0
            Client ID: 3, Client Name: AC, Average expenditure: 61.0

            Restaurant 4 clients:
            """.replace("\r\n", "\n").replace("            ","");

        String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0, 
                ">>>>>>>>>> >>>>>>>>>>\n" +
                diff +
                "<<<<<<<<<< <<<<<<<<<<\n");
    }
}
