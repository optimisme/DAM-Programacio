package com.exercici0500;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;

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

    /**
     * Afegeix un nou director
     * @param nomDirector
     * @param nacionalitat
     * @return l'identificador del director afegit
     */
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
     * Genera una cadena de text vàlida per formar el marc d'una taula:
     * 
     * Exemple: {2, 5, 3} i { '┌', '┬', '┐' } genera "┌──┬─────┬───┐"
     * Exemple: {4, 3, 6} i { '├', '┼', '┤' } genera "├────┼───┼──────┤"
     * Exemple: {2, 4} i { '└', '┴', '┘' } genera "└──┴────┘"
     * 
     * @param columnWidths array amb els caràcters que ocupa cada columna
     * @param separators array amb els separadors inicial,central i final
     * @return String amb la cadena de text
     */
    public static String generaMarcTaula(int[] columnWidths, char[] separators) {
        StringBuilder rst = new StringBuilder();

        rst.append(separators[0]);
        for (int i = 0; i < columnWidths.length; i++) {
            rst.append(("─").repeat(columnWidths[i]));
            if (i < columnWidths.length - 1) {
                rst.append(separators[1]);
            }
        }
        rst.append(separators[2]);

        return rst.toString();
    }

    /**
     * Formata una fila de la taula amb els valors de cada columna, ajustant l'amplada segons 
     * els valors especificats i afegint marges i separadors.
     *
     * Cada cel·la s'alinea a l'esquerra i es complementa amb espais en blanc si cal 
     * per ajustar-se a l'amplada de la columna.
     *
     * Exemples:
     * formatRow(new String[]{"Nom", "País", "Any"}, new int[]{10, 6, 4});
     * Retorna: "│Nom       │País  │Any │"
     *
     * formatRow(new String[]{"Machu Picchu", "Perú", "1983"}, new int[]{10, 6, 4});
     * Retorna: "│Machu Picc│Perú  │1983│"
     *
     * @param values Array amb els valors de cada columna.
     * @param columnWidths Array amb l'amplada de cada columna.
     * @return Una cadena de text formatejada representant una fila de la taula.
     */
    public static String formatRow(String[] values, int[] columnWidths) {
        String rst = "";
        for (int i = 0; i < values.length; i = i + 1) { 
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

    /**
     * Mostra una taula amb informació dels directors:
     * ┌───────────┬─────────────┐
     * │Nom        │Nacionalitat │
     * ├───────────┼─────────────┤
     * │Director A │País X       │
     * │Director B │País Y       │
     * └───────────┴─────────────┘
     */
    public static void llistarTaulaDirectors() {

    }

    /**
     * Mostra una taula amb informació de les Pelis:
     * ┌─────┬──────────┬──────────────┬──────────┬──────────────┬──────────────┐
     * │ID pe│Titol     │Any Estrena   │Durada    │ID director   │Nom director  │
     * ├─────┼──────────┼──────────────┼──────────┼──────────────┼──────────────┤
     * │1    │Film A    │2020          │120       │1             │Director A    │
     * │2    │Film B    │2018          │110       │2             │Director B    │
     * └─────┴──────────┴──────────────┴──────────┴──────────────┴──────────────┘
     */
    public static void llistarTaulaPelis() {

    } 

    /**
     * Mostra una taula amb informació de les Salies:
     * ┌──────────────┬────────────────┬────────────────────┬──────────────┬────────────────┐
     * │Id Sala       │Nom             │Capacitat           │Id Peli       │Titol           │
     * ├──────────────┼────────────────┼────────────────────┼──────────────┼────────────────┤
     * │1             │Sala 1          │150                 │1             │Film A          │
     * │2             │Sala 2          │200                 │2             │Film B          │
     * └──────────────┴────────────────┴────────────────────┴──────────────┴────────────────┘
     */
    public static void llistarTaulaSales() {
        
    }

    /**
     * Mostra una fitxa amb informació de les pelis:
     * 
     * ┌───────────────────────┐
     * │Film A                 │
     * ├─────────┬─────────────┤
     * │Id       │1            │
     * │Direcció │Director A   │
     * │Any      │2020         │
     * │Duració  │120 minuts   │
     * └─────────┴─────────────┘
     */
    public static void llistarInfoPeli(int idPeli) {
        
    }

    /**
     * Guarda la informacio de les películes en un arxiu ".json"
     * ./run.sh com.exercici0500.MainSaveJSON
     */
    public static void pelisToJSON(String path) {

    }
}
