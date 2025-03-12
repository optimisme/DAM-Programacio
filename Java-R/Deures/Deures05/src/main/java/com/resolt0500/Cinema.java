package com.resolt0500;

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
        AppData db = AppData.getInstance();
        db.update("DROP TABLE IF EXISTS directors");
        String sqlCreate = """
            CREATE TABLE directors (
                id_director INTEGER PRIMARY KEY AUTOINCREMENT,
                nom TEXT NOT NULL,
                nacionalitat TEXT NOT NULL)
                """;
        db.update(sqlCreate);
    }

    public static void crearTaulaPelis() {
        AppData db = AppData.getInstance();
        db.update("DROP TABLE IF EXISTS pelis");
        db.update("""
                CREATE TABLE IF NOT EXISTS pelis(
                id_peli INTEGER PRIMARY KEY AUTOINCREMENT,
                titol TEXT NOT NULL,
                any_estrena INTEGER,
                durada INTEGER,
                id_director INTEGER,
                FOREIGN KEY(id_director) REFERENCES directors(id_director))
                """);
    }

    public static void crearTaulaSales() {
        AppData db = AppData.getInstance();
        db.update("DROP TABLE IF EXISTS sales");
        String sql = """
            CREATE TABLE IF NOT EXISTS sales (
                id_sala INTEGER PRIMARY KEY AUTOINCREMENT,
                nom_sala TEXT NOT NULL,
                capacitat INTEGER NOT NULL,
                id_peli INTEGER,
                FOREIGN KEY(id_peli) REFERENCES pelis(id_peli)
            );
        """;
        db.update(sql);
    }

    /**
     * Afegeix un nou director
     * @param nomDirector
     * @param nacionalitat
     * @return l'identificador del director afegit
     */
    public static int afegirDirector(String nomDirector, String nacionalitat) {
        AppData db = AppData.getInstance();
        String sql = String.format("INSERT INTO directors (nom, nacionalitat) VALUES ('%s','%s')",nomDirector,nacionalitat);
        return db.insertAndGetId(sql);
    }

    public static int afegirPeli(String titol, int any, int duracio, int idDirector) {
        AppData db = AppData.getInstance();
        String sql = String.format("INSERT INTO pelis (titol, any_estrena, durada, id_director) VALUES ('%s','%d','%d','%d')",titol, any, duracio ,idDirector);
        return db.insertAndGetId(sql);

    }

    public static int afegirSala(String nomSala, int capacitat, int idPeli) {
        AppData db = AppData.getInstance();
        String sql = String.format("INSERT INTO sales (nom_sala, capacitat, id_peli) VALUES ('%s', %d, %d)", nomSala, capacitat, idPeli);
        return db.insertAndGetId(sql);
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
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0203#testGeneraMarcTaula
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
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0203#testFormatRow
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

        AppData db = AppData.getInstance();
        String sql = "SELECT * FROM directors";
        ArrayList<HashMap<String, Object>> table = db.query(sql);

        int[] columnWidths = {14, 16};
        char[] separators1 =  {'┌', '┬', '┐'};
        System.out.println(generaMarcTaula(columnWidths, separators1));

        String[] values = {"Nom", "Nacionalitat"};
        System.out.println(formatRow(values, columnWidths));

        char[] separators2 = {'├', '┼', '┤'};
        System.out.println(generaMarcTaula(columnWidths, separators2));

        for (HashMap<String, Object> row : table) {
            String[] valorsFila = {(String) row.get("nom"), (String) row.get("nacionalitat")};
            String info = formatRow(valorsFila, columnWidths);
            System.out.println(info);
        }

        char[] separators3 = {'└', '┴', '┘'};
        System.out.println(generaMarcTaula(columnWidths, separators3));
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

        AppData db = AppData.getInstance();
        String sql = "SELECT * FROM pelis p join directors d on p.id_director = d.id_director";
        ArrayList<HashMap<String, Object>> table = db.query(sql);
        
        int[] columnWidths = {5, 10, 14, 10, 14, 14};
        char[] separators =  {'┌', '┬', '┐'};
        System.out.println(generaMarcTaula(columnWidths, separators));

        String[] values = {"ID peli", "Titol", "Any Estrena", "Durada", "ID director", "Nom director"};
        System.out.println(formatRow(values, columnWidths));
                
        char[] separators2 = {'├', '┼', '┤'};
        System.out.println(generaMarcTaula(columnWidths, separators2));

        String[] rowValues = new String[6];
        for (HashMap<String, Object> row : table) {
            rowValues[0] = String.valueOf(row.get("id_peli"));
            rowValues[1] = String.valueOf(row.get("titol"));
            rowValues[2] = String.valueOf(row.get("any_estrena")); 
            rowValues[3] = String.valueOf(row.get("durada")); 
            rowValues[4] = String.valueOf(row.get("id_director"));
            rowValues[5] = String.valueOf(row.get("nom"));  
        
            String info = formatRow(rowValues, columnWidths);
            System.out.println(info);
        }

        char[] separators3 = {'└', '┴', '┘'};
        System.out.println(generaMarcTaula(columnWidths, separators3));
    } 

    /**
     * Mostra una taula amb informació de les Sales:
     * ┌──────────────┬────────────────┬────────────────────┬──────────────┬────────────────┐
     * │Id Sala       │Nom             │Capacitat           │Id Peli       │Titol           │
     * ├──────────────┼────────────────┼────────────────────┼──────────────┼────────────────┤
     * │1             │Sala 1          │150                 │1             │Film A          │
     * │2             │Sala 2          │200                 │2             │Film B          │
     * └──────────────┴────────────────┴────────────────────┴──────────────┴────────────────┘
     */
    public static void llistarTaulaSales() {
        AppData db = AppData.getInstance();
        String sql = "SELECT * FROM sales s join pelis p on s.id_peli=p.id_peli";
        ArrayList<HashMap<String, Object>> table = db.query(sql);
        
        int[] columnWidths = {14, 16,20,14,16};
        char[] separators =  {'┌', '┬', '┐'};
        char[] separators2 = {'├', '┼', '┤'};
        char[] separators3 = {'└', '┴', '┘'};
        
        System.out.println(generaMarcTaula(columnWidths, separators));

        String[] values = {"Id Sala", "Nom", "Capacitat", "Id Peli", "Titol"};

        System.out.println(formatRow(values, columnWidths));
        
        System.out.println(generaMarcTaula(columnWidths, separators2));

        String[] rowValues = new String[5];

        for (HashMap<String, Object> row : table) {
            
            rowValues[0] = String.valueOf(row.get("id_sala")); 
            rowValues[1] = (String) row.get("nom_sala");  
            rowValues[2] = String.valueOf(row.get("capacitat"));
            rowValues[3] = String.valueOf(row.get("id_peli"));
            rowValues[4] = String.valueOf(row.get("titol"));
            String info = formatRow(rowValues, columnWidths);
            System.out.println(info);
        }
        
        System.out.println(generaMarcTaula(columnWidths, separators3));
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
        AppData db = AppData.getInstance();
        String sql = String.format("SELECT * FROM pelis WHERE id_peli = %d", idPeli);
        ArrayList<HashMap<String, Object>> table = db.query(sql);

        if (table.isEmpty()) {
            System.out.println("No s'ha trobat cap pel·lícula amb aquest ID.");
            return;
        }

        HashMap<String, Object> peli = table.get(0);

        String titol = (String) peli.get("titol");
        int anyEstrena = (int) peli.get("any_estrena");
        int durada = (int) peli.get("durada");
        int idDirector = (int) peli.get("id_director");

        String sqlDirector = String.format("SELECT nom FROM directors WHERE id_director = %d", idDirector);
        ArrayList<HashMap<String, Object>> directorTable = db.query(sqlDirector);
        String nomDirector = directorTable.isEmpty() ? "Desconegut" : (String) directorTable.get(0).get("nom");

        int[] columnWidths = {10, 14};
        char[] separators = {'┌', '─', '┐'};
        char[] separators2 = {'├', '┬', '┤'};
        char[] separators3 = {'└', '┴', '┘'};

        System.out.println(generaMarcTaula(columnWidths, separators));
        System.out.println("│ " + titol + " ".repeat(24 - titol.length()) + "│");
        System.out.println(generaMarcTaula(columnWidths, separators2));

        String[] values = {"Id", String.valueOf(idPeli)};
        System.out.println(formatRow(values, columnWidths));

        values = new String[]{"Direcció", nomDirector};
        System.out.println(formatRow(values, columnWidths));

        values = new String[]{"Any", String.valueOf(anyEstrena)};
        System.out.println(formatRow(values, columnWidths));

        values = new String[]{"Duració", String.valueOf(durada) + " minuts"};
        System.out.println(formatRow(values, columnWidths));

        System.out.println(generaMarcTaula(columnWidths, separators3));
    }

    /**
     * Guarda la informacio de les películes en un arxiu ".json"
     * ./run.sh com.exercici0500.MainSaveJSON
     */
    public static void pelisToJSON(String path) {
        try{
            AppData db = AppData.getInstance();
            String sql = "SELECT * FROM pelis";
            ArrayList<HashMap<String, Object>> table = db.query(sql);

            JSONArray jsonArray  = new JSONArray(table);
            Files.write(Paths.get(path), jsonArray.toString(4).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
