package com.exercici0501;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidParameterException;

import org.json.JSONArray;
import org.json.JSONObject;

public class Restaurants {
 
    /**
     * Crea les taules de l'enunciat, 
     * si ja existeixen primer les esborra
     */
    public static void crearTaules() {
        AppData db = AppData.getInstance();
        db.update("DROP TABLE IF EXISTS restaurants");
        String sql = """
            CREATE TABLE IF NOT EXISTS restaurants (
                id_restaurant INTEGER PRIMARY KEY UNIQUE,
                name TEXT NOT NULL,
                kind TEXT NOT NULL,
                tables INTEGER NOT NULL,
                pricing TEXT NOT NULL
            );
        """;
        db.update(sql);
        db.update("DROP TABLE IF EXISTS clients");
        String sql1 = """
            CREATE TABLE IF NOT EXISTS directors (
                id_client INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                birth DATE NOT NULL,
                isVIP BOOLEAN NOT NULL
            );
        """;
        db.update(sql1);
        db.update("DROP TABLE IF EXISTS services");
        String sql2 = """
            CREATE TABLE IF NOT EXISTS services (
                id_servei INTEGER PRIMARY KEY AUTOINCREMENT,
                id_restaurant INTEGER NOT NULL,
                id_client INTEGER NOT NULL,
                date DATE NOT NULL,
                expenditure REAL NOT NULL,
                FOREIGN KEY (id_restaurant) REFERENCES restaurants(id_restaurant),
                FOREIGN KEY (id_client) REFERENCES clients(id_client)
            );
        """;
        db.update(sql2);
    }

    /**
     * Afegeix un restaurant a la base de dades
     */
    public static void addRestaurant(int idRestaurant, String name, String kind, int tables, String pricing) {
        AppData db = AppData.getInstance();
        String sql = String.format("INSERT INTO restaurants (id_restaurant, name, kind, tables, pricing ) VALUES ('%d', '%s','%s','%d','%s')",idRestaurant,name,kind,tables,pricing);
        db.update(sql);
    }

    public static int addClient(String name, String birth, boolean isVIP) {
        AppData db = AppData.getInstance();
        String sql = String.format("INSERT INTO clients (name, birth, isVIP) VALUES ('%s', '%s', '%b')", name, birth, isVIP);
        return db.insertAndGetId(sql);
    }

    public static int addService(int idRestaurant, int idClient, String date, double expenditure) {
        AppData db = AppData.getInstance();
        String sql = String.format("INSERT INTO services (id_restaurant, id_client, date, expenditure) VALUES ('%d','%d','%s','%f')", idRestaurant,idClient,date,expenditure);
        return db.insertAndGetId(sql);
    }

    private static String fixString(String str) {
        String rst =  str.replaceAll("'", "''");
        return rst;
    }

    /** 
     * Carrega la base de dades amb les dades
     * de l'arxiu ".json" del path
     * fa servir les funcions 'addRestaurant', 'addClient' i 'addService'
     * 
     * Cada vegada que afegeix dades a la base de dades,
     * mostra una frase de l'estil:
     * 
     * - S'ha afegit un nou 'restaurant' amb 'id': 2
     * - S'ha afegit un nou 'client' amb 'id': 1
     * - S'ha afegit un nou 'servei' amb 'id': 5
     */
    public static void loadData(String filePath) throws IOException {
        String content = Files.readString(Paths.get(filePath));
        JSONObject jsonObject = new JSONObject(content);

        JSONArray restaurants = jsonObject.getJSONArray("restaurants");
        for (int i = 0; i < restaurants.length(); i++) {
            JSONObject restaurant = restaurants.getJSONObject(i);
            addRestaurant(
                restaurant.getInt("id_restaurant"), 
                fixString(restaurant.getString("name")), 
                fixString(restaurant.getString("kind")), 
                restaurant.getInt("tables"), 
                restaurant.getString("pricing"));
            System.out.println("S'ha afegit un nou 'restaurant' amb 'id': " + restaurant.getInt("id_restaurant"));

        }

        JSONArray clients = jsonObject.getJSONArray("clients");
        for (int i = 0; i < clients.length(); i++) {
            JSONObject client = clients.getJSONObject(i);
            int id = addClient(client.getString("name"), client.getString("birth"), client.getBoolean("isVIP"));
            System.out.println("S'ha afegit un nou 'client' amb 'id': " + id);
        }

        JSONArray services = jsonObject.getJSONArray("services");
        for (int i = 0; i < services.length(); i++) {
            JSONObject service = services.getJSONObject(i);
            int id = addService(service.getInt("id_restaurant"), service.getInt("id_client"), service.getString("date"), service.getDouble("expenditure"));
            System.out.println("S'ha afegit un nou 'servei' amb 'id': " + id);
        }

        System.out.println("Dades carregades correctament");
    }

    /**
     * Mostra una taula amb informació dels restaurants:
     * ┌────────────┬─────────────────┬────────┬──────┐
     * │ Nom        │ Tipus           │ Taules │ Preu │
     * ├────────────┼─────────────────┼────────┼──────┤
     * │ Quimeta    │ Cuina casolana  │ 8      │ 30   │
     * │ Cal Pepet  │ Bar             │ 5      │ 15   │
     * │ DongFang   │ Xinès           │ 15     │ 12   │
     * └────────────┴─────────────────┴────────┴──────┘
     */
    public static void llistarTaulaRestautants() {

    }

    public static void llisarTaulaClients() {

    }

    /**
     * Mostra la taula amb la informació dels serveis
     * - Si "idClient" és -1 mostra tota la taula
     * - Si "idClient" és un identificador conegut mostra els serveis d'aquell client
     * - Si "idClient" és un identificador desconegut llança InvalidParameterException
     * @param idClient
     */
    public static void llistarTaulaServeis(int idClient) throws InvalidParameterException {

    }

    /** Mostra dues llistes, 
     * amb els noms de restaurants que tenen 
     * el preu per sobre o sota de la mitjana
     * 
     * Preu mitjà: ??.??€
     * Restautants barats:
     * - ??
     * - ??
     * Restaurants cars:
     * - ??
     * - ??
     */
    public static void llistarMitjanes() {

    }
}
