package com.exercici0501;

import java.security.InvalidParameterException;

public class Restaurants {
 
    /**
     * Crea les taules de l'enunciat, 
     * si ja existeixen primer les esborra
     */
    public static void crearTaules() {

    }

    /**
     * Afegeix un restaurant a la base de dades
     */
    public static void addRestaurant(int idRestaurant, String name, String kind, int tables, String pricing) {
    }

    public static int addClient(String name, String birth, boolean isVIP) {
        return 0;
    }

    public static int addService(int idRestaurant, int idClient, String date, double expenditure) {
        return 0;
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
    public static void loadData(String filePath) {

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
