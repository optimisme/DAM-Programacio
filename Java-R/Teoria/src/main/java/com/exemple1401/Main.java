package com.exemple1401;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe principal que mostra exemples d'ús de la base de dades MySQL.
 * Utilitza el patró Singleton per obtenir una instància d'AppData i executar consultes.
 */
public class Main {
    /**
     * Mètode principal que inicia l'execució del programa.
     * ./run.sh com.exemple1401.Main
     *
     * @param args arguments de la línia de comandes.
     */
    public static void main(String[] args) {

        // Crear el singleton (això es connecta a la base de dades)
        AppData db = AppData.getInstance();
        db.connect("//localhost:3308/world?useSSL=false&allowPublicKeyRetrieval=true", "root", "pwd");

        System.out.println("\nLlistar totes les taules:");
        llistarTaules();

        System.out.println("\nLes 10 últimes ciutats de la taula 'city':");
        llistarUltimesCiutats();

        // Tancar la connexió amb la base de dades (del singleton)
        db.close();

        // Forçar la sortida del programa per no esperar a tancar la connexió amb MySQL.
        // Assegura't que en aquest punt totes les dades s'han guardat correctament.
        if (!"test".equals(System.getProperty("environment"))) {
            System.exit(0);
        }
    }

    /**
     * Llista totes les taules de la base de dades.
     * Executa la consulta "SHOW TABLES;" i imprimeix el nom de cada taula.
     */
    public static void llistarTaules() {
        // Obtenir un apuntador al singleton de la base de dades
        AppData db = AppData.getInstance();

        // Llistar totes les taules utilitzant ArrayList i HashMap
        ArrayList<HashMap<String, Object>> taules = db.query("SHOW TABLES;");

        for (HashMap<String, Object> taula : taules) {
            // La clau del mapa depèn del nom de la base de dades, per tant, utilitzem el primer valor del mapa.
            System.out.println(taula.values().toArray()[0]);
        }
    }

    /**
     * Llista les 10 últimes ciutats de la taula 'city'.
     * Executa la consulta "SELECT * FROM city ORDER BY ID DESC LIMIT 10;" i imprimeix
     * els detalls de cada ciutat.
     */
    public static void llistarUltimesCiutats() {
        // Obtenir un apuntador al singleton de la base de dades
        AppData db = AppData.getInstance();

        // Llistar les 10 últimes ciutats utilitzant ArrayList i HashMap
        ArrayList<HashMap<String, Object>> ciutats = db.query("SELECT * FROM city ORDER BY ID DESC LIMIT 10;");

        System.out.println("Dades de les ciutats:");
        for (HashMap<String, Object> ciutat : ciutats) {
            System.out.println(ciutat.get("Name") + ", " + ciutat.get("CountryCode") + ", " 
                    + ciutat.get("District") + ", " + ciutat.get("Population"));
        }
    }
}
