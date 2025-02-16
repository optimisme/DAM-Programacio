package com.exercicis;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONArray;

public class Exercici0202 {

    public static Scanner scanner;
    public static Locale defaultLocale;
    
    // ./run.sh com.exercicis.Exercici0202
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        defaultLocale = Locale.getDefault();
        Locale.setDefault(Locale.US);

        showJSONAstronautes("./data/astronautes.json");

        mostrarEsportistesOrdenatsPerMedalla("./data/esportistes.json", "or");
        mostrarEsportistesOrdenatsPerMedalla("./data/esportistes.json", "plata");

        Locale.setDefault(defaultLocale);
        scanner.close();
    }

    /**
     * Llegeix l'arxiu de 'filePath' i mostra per consola les dades dels astronautes.
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0202#testShowJSONAstronautes
     */
    public static void showJSONAstronautes(String filePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            JSONObject jsonObject = new JSONObject(content);
            JSONArray jsonArray = jsonObject.getJSONArray("astronautes");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject atronauta = jsonArray.getJSONObject(i);

                String nom = atronauta.getString("nom");
                int anyNeix = atronauta.getInt("any_naixement");

                System.out.println("> Astronauta " + i + ":");
                System.out.println("  Nom: " + nom);
                System.out.println("  Naixement: " + anyNeix);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Llegeix l'arxiu de 'filePath', retorna un ArrayList amb les dades dels astronautes
     * Les dades han d'estar en un HashMap amb les claus "nom" i "any_naixement"
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0202#testJSONAstronautesToArrayList
     */
    public static ArrayList<HashMap<String, Object>> JSONAstronautesToArrayList(String filePath) {
        ArrayList<HashMap<String, Object>> rst = new ArrayList<>();

        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            JSONObject jsonObject = new JSONObject(content);
            JSONArray jsonArray = jsonObject.getJSONArray("astronautes");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject atronauta = jsonArray.getJSONObject(i);

                HashMap<String, Object> map = new HashMap<>();
                map.put("nom", atronauta.getString("nom"));
                map.put("any_naixement", atronauta.getInt("any_naixement"));

                rst.add(map);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rst;
    }

    /**
     * Llegeix l'arxiu de 'filePath', retorna un ArrayList amb les dades dels esportistes
     * Les dades han d'estar en un HashMap amb: nom, any_naixement, pais i medalles
     * Les medalles de la clau 'medalles' han d'estar en un HashMap amb les claus "or", "plata" i "bronze"
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0202#JSONEsportistesToArrayList
     */
     public static ArrayList<HashMap<String, Object>> JSONEsportistesToArrayList(String filePath) {
        ArrayList<HashMap<String, Object>> rst = new ArrayList<>();

        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            // Directament la llista d'esportistes
            JSONArray jsonArray = new JSONArray(content);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject esportista = jsonArray.getJSONObject(i);

                HashMap<String, Object> map = new HashMap<>();
                map.put("nom", esportista.getString("nom"));
                map.put("any_naixement", esportista.getInt("any_naixement"));
                map.put("pais", esportista.getString("pais"));

                // Convertir l'objecte de medalles a un HashMap
                JSONObject medallesJson = esportista.getJSONObject("medalles_olimpiques");
                HashMap<String, Integer> medalles = new HashMap<>();
                medalles.put("or", medallesJson.getInt("or"));
                medalles.put("plata", medallesJson.getInt("plata"));
                medalles.put("bronze", medallesJson.getInt("bronze"));

                map.put("medalles", medalles);

                rst.add(map);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rst;
    }

    /**
     * Llegeix l'arxiu JSON i retorna una llista d'esportistes ordenada per una medalla específica (or, plata o bronze).
     *
     * @param filePath Ruta de l'arxiu JSON amb les dades dels esportistes.
     * @param tipusMedalla Tipus de medalla per ordenar: "or", "plata" o "bronze".
     * @return Llista ordenada d'esportistes segons el nombre de medalles especificat.
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0202#testOrdenarEsportistesPerMedalla
     */
    public static ArrayList<HashMap<String, Object>> ordenarEsportistesPerMedalla(String filePath, String tipusMedalla) {
        // Obtenir la llista d'esportistes des del fitxer JSON
        ArrayList<HashMap<String, Object>> esportistes = JSONEsportistesToArrayList(filePath);

        // Validem que el tipus de medalla sigui correcte
        if (!tipusMedalla.equals("or") && !tipusMedalla.equals("plata") && !tipusMedalla.equals("bronze")) {
            throw new IllegalArgumentException("Tipus de medalla invàlid: " + tipusMedalla + ". Usa 'or', 'plata' o 'bronze'.");
        }

        // Ordenem la llista en ordre descendent segons el tipus de medalla
        esportistes.sort(Comparator.comparing((HashMap<String, Object> esportista) -> {
            @SuppressWarnings("unchecked")
            HashMap<String, Integer> medalles = (HashMap<String, Integer>) esportista.get("medalles");
            return medalles.get(tipusMedalla);
        }).reversed()); // Fem .reversed() per obtenir primer els que tenen més medalles

        return esportistes;
    }

    /**
     * Mostra una taula amb els esportistes ordenats per una medalla específica (or, plata o bronze).
     *
     * Les paraules "or", "plata" i "bronze" han de ser mostrades amb la 
     * primera lletra en majúscules i la resta en minúscules.
     * 
     * El format de la taula ha de fer servir els caràcters: "┌", "┬", "┐", "├", "┼", "┤", "└", "┴" i "┘".
     * 
     * Un exemple simplificat de la taula seria:
     * ┌──────────────────────┬─────────────────┬────────────┬────────┐
     * │ Nom                  │ País            │ Naixement  │ Plata  │
     * ├──────────────────────┼─────────────────┼────────────┼────────┤
     * │ Larisa Latynina      │ Unió Soviètica  │ 1934       │ 5      │
     * │ Michael Phelps       │ Estats Units    │ 1985       │ 3      │
     * └──────────────────────┴─────────────────┴────────────┴────────┘
     * 
     * @param filePath Ruta de l'arxiu JSON amb les dades dels esportistes.
     * @param tipusMedalla Tipus de medalla per ordenar: "or", "plata" o "bronze".
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0202#testMostrarEsportistesOrdenatsPerOr
     * @test ./runTest.sh com.exercicis.TestExercici0202#testMostrarEsportistesOrdenatsPerPlata
     * @test ./runTest.sh com.exercicis.TestExercici0202#testMostrarEsportistesOrdenatsPerBronze
     */
    public static void mostrarEsportistesOrdenatsPerMedalla(String filePath, String tipusMedalla) {
        // Obtenir la llista ordenada d'esportistes
        ArrayList<HashMap<String, Object>> esportistes = ordenarEsportistesPerMedalla(filePath, tipusMedalla);

        // Imprimir la capçalera de la taula
        String tipusFixed = tipusMedalla.substring(0, 1).toUpperCase() + tipusMedalla.substring(1).toLowerCase();

        System.out.println("┌──────────────────────┬─────────────────┬────────────┬────────┐");
        System.out.printf("│ %-20s │ %-15s │ %-10s │ %-6s │\n", "Nom", "País", "Naixement", tipusFixed);
        System.out.println("├──────────────────────┼─────────────────┼────────────┼────────┤");

        // Imprimir cada esportista a la taula
        for (HashMap<String, Object> esportista : esportistes) {
            String nom = (String) esportista.get("nom");
            String pais = (String) esportista.get("pais");
            int anyNaixement = (int) esportista.get("any_naixement");

            @SuppressWarnings("unchecked")
            HashMap<String, Integer> medalles = (HashMap<String, Integer>) esportista.get("medalles");
            int numMedalles = medalles.get(tipusMedalla);

            System.out.printf("│ %-20s │ %-15s │ %-10d │ %-6d │\n", nom, pais, anyNaixement, numMedalles);
        }

        // Tancament de la taula
        System.out.println("└──────────────────────┴─────────────────┴────────────┴────────┘");
    }
}