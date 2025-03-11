package com.exercici0500;

import java.util.ArrayList;
import java.util.HashMap;

public class Cinema {

    /**
     * Crea la taula "directors", si ja existeix primer l'esborra
     */
    public static void crearTaulaDirectors() {
    }

    public static void crearTaulaPelis() {
    }

    public static void crearTaulaSales() {
    }

    public static int afegirDirector(String nomDirector, String nacionalitat) {
        return 0;
    }

    public static int afegirPeli(String titol, int any, int duracio, int idDirector) {
        return 0;
    }

    public static int afegirSala(String nomSala, int capacitat, int idPeli) {
        return 0;
    }

    /**
     * Mostra una taula amb informació dels directors:
     * ┌────────────┬──────────────┐
     * │ Nom        │ Nacionalitat │
     * ├────────────┼──────────────┤
     * │ Director A │ País X       │
     * │ Director B │ País Y       │
     * └────────────┴──────────────┘
     */
    public static void llistarTaulaDirectors() {
    }

    public static void llistarTaulaPelis() {
    }

    public static void llistarTaulaSales() {
    }

    /**
     * Mostra una fitxa amb informació de les pelis:
     * 
     * ┌─────────────────────────┐
     * │ Film A                  │
     * ├──────────┬──────────────┤
     * │ Direcció │ Director A   │
     * │ Any      │ 2020         │
     * │ Duració  │ 120 minuts   │
     * └──────────┴──────────────┘
     */
    public static void llistarInfoPeli(int idLlibre) {
    }

    /**
     * Guarda la informacio de les películes en un arxiu ".json"
     */
    public static void pelisToJSON(String path) {
    }
}
