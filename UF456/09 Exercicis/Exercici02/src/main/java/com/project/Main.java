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
}
