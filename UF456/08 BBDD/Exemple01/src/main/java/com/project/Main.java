package com.project;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // Crear el singleton (això es connecta a la base de dades)
        AppData db = AppData.getInstance();

        System.out.println("\nLlistar totes les taules:");
        llistarTaules();

        System.out.println("\nLes 10 últimes ciutats de la taula 'city':");
        llistarUltimesCiutats();

        // Tancar la connexió amb la base de dades (del singleton)
        db.close();

        // Forçar la sortida del programa per no esperar a tancar la connexió amb 'MySQL'
        // Assegura't que en aquest punt totes les dades s'han guardat correctament
        if (!"test".equals(System.getProperty("enviroment"))) {
            System.exit(0);
        }
    }

    public static void llistarTaules() {
        // Obtenir un apuntador al singleton de la base de dades
        AppData db = AppData.getInstance();

        // Llistar totes les taules
        List<Map<String, Object>> taules = db.query("SHOW TABLES;");

        for (Map<String, Object> taula : taules) {
            // La clau del mapa depèn del nom de la base de dades, per tant, utilitzem el primer valor del mapa.
            System.out.println(taula.values().toArray()[0]);
        }
    }

    public static void llistarUltimesCiutats() {
        // Obtenir un apuntador al singleton de la base de dades
        AppData db = AppData.getInstance();

        // Llistar les 10 últimes ciutats de la taula 'city'
        List<Map<String, Object>> ciutats = db.query("SELECT * FROM city ORDER BY ID DESC LIMIT 10;");

        System.out.println("Dades de les ciutats:");
        for (Map<String, Object> ciutat : ciutats) {
            System.out.println(ciutat.get("Name") + ", " + ciutat.get("CountryCode") + ", " + ciutat.get("District") + ", " + ciutat.get("Population"));
        }
    }
}
