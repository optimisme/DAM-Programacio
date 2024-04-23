package com.project;

import java.util.Locale;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        
        AppData db = AppData.getInstance();
        
        // Create tables
        createTables();

        // Add restaurants
        addRestaurant("The Gourmet Kitchen", "Italian", 10, "High");
        addRestaurant("Casual Diner", "American", 5, "Medium");
        addRestaurant("Seafood Paradise", "Seafood", 8, "High");
        addRestaurant("Veggie Delight", "Vegetarian", 12, "Medium");
        addRestaurant("Sushi Corner", "Japanese", 15, "High");

        // Add clients
        addClient("John Doe", "1985-02-15", true);
        addClient("Jane Smith", "1990-07-23", false);
        addClient("Alice Johnson", "1975-11-30", false);
        addClient("Bob Lee", "1988-06-15", true);
        addClient("Charlie Brown", "1993-03-12", false);
        addClient("Emma Wilson", "1981-09-25", true);
        addClient("Noah Miller", "1994-04-14", false);
        addClient("Olivia Davis", "1979-12-05", true);

        // Add services
        addService(1, 1, "2023-04-01", 120.50);
        addService(2, 2, "2023-04-02", 45.0);
        addService(3, 3, "2023-05-10", 200.0);
        addService(4, 4, "2023-05-11", 150.0);
        addService(5, 5, "2023-05-12", 200.0);
        addService(5, 5, "2023-05-14", 250.0);
        addService(5, 5, "2023-05-16", 350.0);
        addService(5, 5, "2023-05-18", 300.0);
        addService(1, 6, "2023-05-15", 220.0);
        addService(2, 7, "2023-05-16", 50.0);
        addService(1, 8, "2023-05-17", 180.0);
        addService(1, 1, "2023-06-01", 135.0); 
        addService(1, 2, "2023-06-02", 95.0);
        addService(2, 1, "2023-06-03", 78.0);
        addService(2, 3, "2023-06-04", 120.0);
        addService(1, 4, "2023-06-05", 200.0); 
        addService(2, 2, "2023-07-01", 60.0);
        addService(3, 2, "2023-07-02", 130.0);
        addService(5, 2, "2023-07-03", 140.0);
        addService(5, 2, "2023-07-05", 100.0);
        addService(1, 4, "2023-07-04", 160.0);
        addService(4, 4, "2023-07-05", 70.0);
        addService(4, 4, "2023-07-06", 50.0);
        addService(2, 4, "2023-07-06", 40.0);
        addService(1, 6, "2023-07-07", 100.0);
        addService(5, 6, "2023-07-08", 360.0);
        addService(5, 6, "2023-07-09", 280.0);
        addService(4, 6, "2023-07-09", 60.0);
        addService(4, 6, "2023-07-10", 80.0);

        // List entries
        System.out.println("\nRestaurants:");
        listRestaurants();

        System.out.println("\nClients:");
        listClients();

        System.out.println("\nServices:");
        listServices();

        System.out.println("\nClient 1 services:");
        listClientServices(1);

        System.out.println("\nClient 4 services:");
        listClientServices(4);

        System.out.println("\nClient 6 services:");
        listClientServices(6);

        System.out.println("\nRestaurant 1 clients:");
        listRestaurantClients(1);

        System.out.println("\nRestaurant 4 clients:");
        listRestaurantClients(4);

        System.out.println("\nRestaurant 5 clients:");
        listRestaurantClients(5);

        // Close the database connection
        db.close();
    }

    public static void createTables() {
        AppData db = AppData.getInstance();

        String sql = "CREATE TABLE IF NOT EXISTS restaurants (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                     "name TEXT NOT NULL, " +
                     "kind TEXT NOT NULL, " +
                     "tables INTEGER NOT NULL, " +
                     "pricing TEXT NOT NULL)";
        db.update("DROP TABLE IF EXISTS restaurants");
        db.update(sql);

        sql = "CREATE TABLE IF NOT EXISTS clients (" +
              "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
              "name TEXT NOT NULL, " +
              "birth DATE NOT NULL, " +
              "isVIP BOOLEAN NOT NULL)";
        db.update("DROP TABLE IF EXISTS clients");
        db.update(sql);

        sql = "CREATE TABLE IF NOT EXISTS services (" +
              "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
              "id_restaurant INTEGER NOT NULL, " +
              "id_client INTEGER NOT NULL, " +
              "date DATE NOT NULL, " +
              "expenditure REAL NOT NULL, " +
              "FOREIGN KEY(id_restaurant) REFERENCES restaurants(id), " +
              "FOREIGN KEY(id_client) REFERENCES clients(id))";
        db.update("DROP TABLE IF EXISTS services");
        db.update(sql);
    }

    public static void addRestaurant(String name, String kind, int tables, String pricing) {
        String sql = "INSERT INTO restaurants (name, kind, tables, pricing) VALUES ('" + 
                     name + "', '" + kind + "', " + tables + ", '" + pricing + "')";
        AppData.getInstance().update(sql);
    }

    public static void addClient(String name, String birth, boolean isVIP) {
        String sql = "INSERT INTO clients (name, birth, isVIP) VALUES ('" + 
                     name + "', '" + birth + "', " + (isVIP ? "1" : "0") + ")";
        AppData.getInstance().update(sql);
    }

    public static void addService(int idRestaurant, int idClient, String date, double expenditure) {
        String sql = "INSERT INTO services (id_restaurant, id_client, date, expenditure) VALUES (" + 
                     idRestaurant + ", " + idClient + ", '" + date + "', " + expenditure + ")";
        AppData.getInstance().update(sql);
    }

    public static void listRestaurants() {
        String sql = "SELECT * FROM restaurants";
        List<Map<String, Object>> restaurants = AppData.getInstance().query(sql);
        for (Map<String, Object> restaurant : restaurants) {
            System.out.println("ID: " + restaurant.get("id") + ", Name: " + restaurant.get("name") + 
                               ", Kind: " + restaurant.get("kind") + ", Tables: " + restaurant.get("tables") +
                               ", Pricing: " + restaurant.get("pricing"));
        }
    }

    public static void listClients() {
        String sql = "SELECT * FROM clients";
        List<Map<String, Object>> clients = AppData.getInstance().query(sql);
        for (Map<String, Object> client : clients) {
            System.out.println("ID: " + client.get("id") + ", Name: " + client.get("name") + 
                               ", Birth: " + client.get("birth") + ", VIP: " + (((int)client.get("isVIP")) == 1 ? "Yes" : "No"));
        }
    }

    public static void listServices() {
        String sql = "SELECT * FROM services";
        List<Map<String, Object>> services = AppData.getInstance().query(sql);
        for (Map<String, Object> service : services) {
            System.out.println("Service ID: " + service.get("id") + ", Restaurant ID: " + service.get("id_restaurant") + 
                               ", Client ID: " + service.get("id_client") + ", Date: " + service.get("date") + 
                               ", Expenditure: " + service.get("expenditure"));
        }
    }

    public static void listClientServices(int clientId) {
        AppData db = AppData.getInstance();
        
        String sql = "SELECT c.id AS clientId, c.name AS clientName, s.date, s.expenditure, " +
                     "r.name AS restaurantName, r.kind AS restaurantKind, r.pricing AS pricing " +
                     "FROM services s " +
                     "JOIN clients c ON s.id_client = c.id " +
                     "JOIN restaurants r ON s.id_restaurant = r.id " +
                     "WHERE c.id = " + clientId;

        List<Map<String, Object>> results = db.query(sql);
        for (Map<String, Object> row : results) {
            double expenditure = Double.parseDouble(row.get("expenditure").toString());
            String pricing = row.get("pricing").toString();
            String priceComparison = comparePrice(expenditure, pricing);

            System.out.println("Client ID: " + row.get("clientId") +
                               ", Client Name: " + row.get("clientName") +
                               ", Date: " + row.get("date") +
                               ", Expenditure: " + expenditure +
                               ", Restaurant Name: " + row.get("restaurantName") +
                               ", Restaurant Kind: " + row.get("restaurantKind") +
                               ", " + priceComparison + " PKT average price");
        }
    }

    public static String comparePrice(double expenditure, String pricing) {
        // Dummy function for price comparison based on pricing level, customize as needed
        double averagePrice;
        switch (pricing) {
            case "High":
                averagePrice = 150; // Assume average high pricing
                break;
            case "Medium":
                averagePrice = 75; // Assume average medium pricing
                break;
            case "Low":
                averagePrice = 30; // Assume average low pricing
                break;
            default:
                averagePrice = 50; // Default average pricing
                break;
        }
        return expenditure >= averagePrice ? "above" : "below";
    }

    public static void listRestaurantClients(int restaurantId) {
        AppData db = AppData.getInstance();
        
        String sql = "SELECT c.id AS clientId, c.name AS clientName, AVG(s.expenditure) AS averageExpenditure " +
                     "FROM services s " +
                     "JOIN clients c ON s.id_client = c.id " +
                     "WHERE s.id_restaurant = " + restaurantId + " " +
                     "GROUP BY c.id, c.name";
    
        List<Map<String, Object>> results = db.query(sql);
        for (Map<String, Object> row : results) {
            int clientId = Integer.parseInt(row.get("clientId").toString());
            String clientName = row.get("clientName").toString();
            double averageExpenditure = Double.parseDouble(row.get("averageExpenditure").toString());
            
            System.out.println("Client ID: " + clientId +
                               ", Client Name: " + clientName +
                               ", Average expenditure: " + String.valueOf(averageExpenditure));
        }
    }
}
