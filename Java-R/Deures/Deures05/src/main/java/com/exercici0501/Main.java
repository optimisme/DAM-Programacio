package com.exercici0501;

public class Main {

    // Fes anar aquest programa amb:
    // ./run.sh com.exercici0501.MainDB
    
    public static void main(String[] args) {
        AppData db = AppData.getInstance();
        db.connect("./data/cinema.sqlite");
/* 
        Restaurants.crearTaules()   
        int res0 = Restaurants.addRestaurant(String name, String kind, int tables, String pricing)
        int cli0 = Restaurants.addClient(String name, String birth, boolean isVIP)
        int srv0 = Restaurants.addService(int idRestaurant, int idClient, String date, double expenditure)

        // Llista els restaurants de la base de dades amb format:
        // ID: 1, Name: The Gourmet Kitchen, Kind: Italian, Tables: 10, Pricing: High
        void listRestaurants()

        // Llista els clients de la base de dades amb format:
        // ID: 1, Name: John Doe, Birth: 1985-02-15, VIP: No
        void listClients()

        // Llista els serveis de la base de dades amb format:
        // Service ID: 1, Restaurant ID: 1, Client ID: 1, Date: 2023-04-01, Expenditure: 120.5
        void listServices()

        // Llista els serveis d'un client amb id 'clientId' amb format:
        // Client ID: 1, Client Name: John Doe, Date: 2023-04-01, Expenditure: 120.5, Restaurant Name: The Gourmet Kitchen, Restaurant Kind: Italian, below PKT average price
        listClientServices(int clientId)

        // Llista els clients d'un restaurant amb id 'restaurantId' amb format:
        // Client ID: 1, Client Name: John Doe, Average expenditure: 127,75
        // Mostra la mitjana de gasto que ha fet cada client en aquell restaurant a 'Average expenditure'
        void listRestaurantClients(int restaurantId)

        // Retorna 'above' o 'below' segons si un preu està per sobre del PKT pricing segons la següent taula:
        // (High - 150, Medium - 75, Low - 30, Default - 50)
        // | Pricing Level | Average Price | 
        // | ------------- | ------------- | 
        // | High          | 150           | 
        // | Medium        | 75            | 
        // | Low           | 30            | 
        // | Default       | 50            | 
        comparePrice(double expenditure, String pricing)
*/
        db.close();
    }
}
