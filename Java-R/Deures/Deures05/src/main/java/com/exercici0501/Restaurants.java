package com.exercici0501;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;

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
            CREATE TABLE IF NOT EXISTS clients (
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

    /**
     * Canvia els caràcters ' d'una cadena de text, per ''
     * per escapar-los en format SQLite 
     * @param str
     * @return
     */
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

    public static String formatRow(String[] values, int[] columnWidths) {
        String rst = "";
        for (int i = 0; i < values.length; i++) { 
            rst += "│";
            String value = values[i];
            if (value.length() > columnWidths[i]) {
                value = value.substring(0, columnWidths[i]);
            }
            rst += value;
            int spaceCount = columnWidths[i] - value.length();
            if (spaceCount > 0) {
                rst += " ".repeat(spaceCount);
            }
            
        }
        rst += "│";
        return rst;
    }

    public static String generaMarcTaula(int[] columnWidths, char[] separators) {
        String rst = "";
        rst += separators[0];
        for (int i = 0; i < columnWidths.length; i++) {
            for (int j = 0; j < columnWidths[i]; j++) {
                rst += '─';
            }
            if (i < columnWidths.length - 1) {
                rst += separators[1];
            }
        }
        rst += separators[2];
        return rst;
    }

    /**
     * Mostra una taula amb informació dels restaurants:
     * ┌────────────────────┬────────────────────┬────────┬─────┐
     * │Nom                 │Tipus               │Taules  │Preu │
     * ├────────────────────┼────────────────────┼────────┼─────┤
     * │Quimeta             │Cuina casolana      │8       │30   │
     * │Cal Pepet           │Bar                 │5       │15   │
     * │DongFang            │Xinès               │15      │12   │
     * └────────────────────┴────────────────────┴────────┴─────┘
     */
    public static void llistarTaulaRestautants() throws IOException {
        AppData db = AppData.getInstance();
        ArrayList<HashMap<String, Object>> restaurants = db.query("SELECT * FROM restaurants");

        String[] titol = {"Nom", "Tipus", "Taules", "Preu"};
        int[] columnWidths = {20, 20, 8, 5};
        char[] separadorsTop = {'┌', '┬', '┐'};
        char[] separadorsMid = {'├', '┼', '┤'};
        char[] separadorsBot = {'└', '┴', '┘'};

        System.out.println(generaMarcTaula(columnWidths, separadorsTop));
        System.out.println(formatRow(titol, columnWidths));
        System.out.println(generaMarcTaula(columnWidths, separadorsMid));

        for (int i = 0; i < restaurants.size(); i++) {
            HashMap<String, Object> restaurant = new HashMap<>(restaurants.get(i));
            String[] row = {
                (String) restaurant.get("name"),
                (String) restaurant.get("kind"),
                String.valueOf(restaurant.get("tables")),
                (String) restaurant.get("pricing")
            };
            System.out.println(formatRow(row, columnWidths));
        }

        System.out.println(generaMarcTaula(columnWidths, separadorsBot));
    }

    public static void llisarTaulaClients() {

        AppData db = AppData.getInstance();
        ArrayList<HashMap<String, Object>> clients = db.query("SELECT * FROM clients");

        String[] titol = {"ID", "Nom", "Data de naixement", "VIP"};
        int[] columnWidths = {10, 20, 20, 5};
        char[] separadorsTop = {'┌', '┬', '┐'};
        char[] separadorsMid = {'├', '┼', '┤'};
        char[] separadorsBot = {'└', '┴', '┘'};

        System.out.println(generaMarcTaula(columnWidths, separadorsTop));
        System.out.println(formatRow(titol, columnWidths));
        System.out.println(generaMarcTaula(columnWidths, separadorsMid));

        for (int i = 0; i < clients.size(); i++) {
            HashMap<String, Object> client = new HashMap<>(clients.get(i));
            String[] row = {
                String.valueOf(client.get("id_client")),
                (String) client.get("name"),
                (String) client.get("birth"),
                (String) client.get("isVIP")
            };
            System.out.println(formatRow(row, columnWidths));
        }
        System.out.println(generaMarcTaula(columnWidths, separadorsBot));
    }

    /**
     * Mostra la taula amb la informació dels serveis
     * - Si "idClient" és -1 mostra tota la taula
     * - Si "idClient" és un identificador conegut mostra els serveis d'aquell client
     * - Si "idClient" és un identificador desconegut llança InvalidParameterException
     * @param idClient
     */
    public static void llistarTaulaServeis(int idClient) throws InvalidParameterException {
        AppData db = AppData.getInstance();
        ArrayList<HashMap<String, Object>> services;
        
        if (idClient == -1) {
            services = db.query("SELECT * FROM services");
        } else {
            services = db.query(String.format("SELECT * FROM services WHERE id_client = %d", idClient));
            if (services.isEmpty()) {
                throw new InvalidParameterException("Invalid client ID: " + idClient);
            }
        }

        String[] titol = {"ID Servei", "ID Restaurant", "ID Client", "Data", "Despesa"};
        int[] columnWidths = {10, 15, 10, 15, 10};
        char[] separadorsTop = {'┌', '┬', '┐'};
        char[] separadorsMid = {'├', '┼', '┤'};
        char[] separadorsBot = {'└', '┴', '┘'};

        System.out.println(generaMarcTaula(columnWidths, separadorsTop));
        System.out.println(formatRow(titol, columnWidths));
        System.out.println(generaMarcTaula(columnWidths, separadorsMid));

        for (HashMap<String, Object> service : services) {
            String[] row = {
                String.valueOf(service.get("id_servei")),
                String.valueOf(service.get("id_restaurant")),
                String.valueOf(service.get("id_client")),
                (String) service.get("date"),
                String.valueOf(service.get("expenditure"))
            };
            System.out.println(formatRow(row, columnWidths));
        }

        System.out.println(generaMarcTaula(columnWidths, separadorsBot));
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
        AppData db = AppData.getInstance();
        ArrayList<HashMap<String, Object>> restaurants = db.query("SELECT * FROM restaurants");
        double mitjana  = 0;
        for (HashMap<String, Object> restaurant : restaurants) {
            mitjana += Double.parseDouble((String) restaurant.get("pricing"));
        }
        mitjana = mitjana / restaurants.size();

        System.out.println("Preu mitjà: " + String.format("%.2f", mitjana) + "€");
        System.out.println("Restautants barats:");

        for (HashMap<String, Object> restaurant : restaurants) {
            if (Double.parseDouble((String) restaurant.get("pricing")) < mitjana) {
                System.out.println("- " + (String) restaurant.get("name"));
            }
        }
        System.out.println("Restaurants cars:");

        for (HashMap<String, Object> restaurant : restaurants) {
            if (Double.parseDouble((String) restaurant.get("pricing")) > mitjana) {
                System.out.println("- " + (String) restaurant.get("name"));
            }
        }
    }
}
