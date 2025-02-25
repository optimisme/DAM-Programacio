package com.exercicis;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONArray;

public class Exercici0203 {

    public static Scanner scanner;
    public static Locale defaultLocale;
    
    // Fes anar el 'main' de l'exercici amb:
    // ./run.sh com.exercicis.Exercici0203
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        defaultLocale = Locale.getDefault();
        Locale.setDefault(Locale.US);

        String url0 = "http://example.com";
        validarURL(url0); 

        String url1 = "https://google";
        validarURL(url1); 
        
        try {
            ArrayList<HashMap<String, Object>> patrimoni = loadMonuments("./data/patrimoni.json");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Filtrar ArrayList per camp i condicio

        // Mostrar ArrayList en forma de taula

        // Generar baralla cartes en un HashMap

        // Guardar baralla cartes en arxiu JSON

        Locale.setDefault(defaultLocale);
        scanner.close();
    }

    /** 
     * Valida una URL a partir d'una cadena de text. 
     * 
     * Cal que:
     * 
     * - No pot ser null ni una cadena de text buida
     * - No pot contenir espais
     * - Ha de començar amb 'http://' o 'https://'
     * - El domini ha de contenir almenys un punt 
     * - El domini no pot començar ni acabar amb un punt
     * 
     * URLs vàlides: ["http://example.com", "https://www.google.com", "https://sub.domini.cat/pagina", "http://localhost:8080", "http://www.ieti.cat:8080/horaris"]
     * URLs no vàlides: ["", "ftp://example.com", "http:/example", "http:/example.com", "https:// google.com", "https://.example.com", "https://example.", "example.com"]
     * 
     * @param url URL a validar
     * @return 'true' si la URL és vàlida, 'false' si no ho és
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0203#testValidarURL
     */
    public static boolean validarURL(String url) {

        if (url == null || url.isEmpty()) return false;

        // No ha de contenir espais
        if (url.contains(" ")) {
            return false;
        }

        // Ha de començar amb http:// o https://
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            return false;
        }

        // Eliminar el protocol per validar el domini
        String senseProtocol = url.substring(url.indexOf("://") + 3);
        
        // Comprovar si té almenys un "/"
        String domini = senseProtocol.contains("/") ? senseProtocol.split("/", 2)[0] : senseProtocol;
        
        // El domini ha de tenir almenys un punt i no començar/acabar en punt
        if (!domini.contains(".") || domini.startsWith(".") || domini.endsWith(".")) {
            return false;
        }

        return true;
    }

    /**
     * Llegeix l'arxiu de 'filePath', retorna un ArrayList amb les dades 
     * dels monuments que són patrimoni de la humanitat.
     * 
     * Ha de generar 'HashMap' amb les dades de cada monument
     * L'atribut que no coincideix, ha d'estar en un 'HashMap' propi anomenat 'altres'
     * que té dues claus:
     * - 'clau': nom de l'atribut
     * - 'valor': valor de l'atribut
     * 
     * @param filePath Ruta de l'arxiu JSON
     * @return ArrayList amb les dades dels monuments
     * 
     * @throws IOException Si hi ha algun problema amb l'escriptura de l'arxiu forçant un 'try/catch'
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0203#testLoadMonuments
     */
    public static ArrayList<HashMap<String, Object>> loadMonuments(String filePath) throws IOException {
        ArrayList<HashMap<String, Object>> rst = new ArrayList<>();

        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject jsonObject = new JSONObject(content);
            JSONArray monumentsArray = jsonObject.getJSONArray("monuments");

            for (int i = 0; i < monumentsArray.length(); i++) {
                JSONObject monumentJSON = monumentsArray.getJSONObject(i);
                HashMap<String, Object> monumentMap = new HashMap<>();
                HashMap<String, Object> altres = new HashMap<>();

                // Atributs principals
                String[] clausPrincipals = {"nom", "pais", "categoria"};

                for (String clau : clausPrincipals) {
                    if (monumentJSON.has(clau)) {
                        monumentMap.put(clau, monumentJSON.getString(clau));
                    }
                }

                // Processar 'detalls'
                if (monumentJSON.has("detalls")) {
                    JSONObject detallsJSON = monumentJSON.getJSONObject("detalls");
                    HashMap<String, Object> detallsMap = new HashMap<>();

                    for (String clau : detallsJSON.keySet()) {
                        Object valor = detallsJSON.get(clau);
                        detallsMap.put(clau, valor);
                    }

                    monumentMap.put("detalls", detallsMap);
                }

                // Afegir la resta d'atributs a 'altres'
                for (String clau : monumentJSON.keySet()) {
                    if (!monumentMap.containsKey(clau) && !clau.equals("detalls")) {
                        Object valor = monumentJSON.get(clau);
                        altres.put("clau", clau);
                        altres.put("valor", valor);
                        break;
                    }
                }

                if (!altres.isEmpty()) {
                    monumentMap.put("altres", altres);
                }

                rst.add(monumentMap);
            }
        } catch (IOException e) {
            throw new IOException("Error llegint el fitxer JSON: " + filePath, e);
        }

        return rst;
    }

    /**
     * Obté el valor pel qual s'ha d'ordenar un monument segons el camp especificat.
     * 
     * - Si el camp és "nom", retorna el valor directament de la clau "nom".
     * - Si el camp és "any", accedeix al valor de "any_declaracio" dins de "detalls".
     * - Si el camp és "latitud" o "longitud", accedeix al valor corresponent dins de "coordenades",
     *   que es troba dins de "detalls".
     * - Si el valor no existeix o la jerarquia de dades no està present, retorna null.
     * 
     * @param monument HashMap amb les dades del monument.
     * @param sortKey Clau pel qual es vol ordenar (pot ser "nom", "any", "latitud" o "longitud").
     * @return Un 'Object' amb el valor corresponent si existeix, en cas contrari retorna null.
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0203#getSortValue
     */
    private static Object getSortValue(HashMap<String, Object> monument, String sortKey) {
        if (sortKey.equals("nom")) {
            return monument.get("nom");
        } else if (sortKey.equals("any")) {
            HashMap<String, Object> detalls = (HashMap<String, Object>) monument.get("detalls");
            return detalls != null ? detalls.get("any_declaracio") : null;
        } else if (sortKey.equals("latitud") || sortKey.equals("longitud")) {
            HashMap<String, Object> detalls = (HashMap<String, Object>) monument.get("detalls");
            if (detalls != null) {
                HashMap<String, Object> coordenades = (HashMap<String, Object>) detalls.get("coordenades");
                return coordenades != null ? coordenades.get(sortKey) : null;
            }
        }
        return null;
    }

    /**
     * Ordena un ArrayList de monuments per un camp concret.
     * Els camps vàlids són: 'nom', 'any', 'latitud', 'longitud'
     * 
     * Ha de fer servir la funció 'loadMonuments'
     * 
     * @param filePath Ruta de l'arxiu JSON
     * @param sortKey camp per ordenar
     * @return ArrayList amb les dades dels monuments
     * 
     * @throws IllegalArgumentException si el paràmetre de columna és invàlid (no força un 'try/catch')
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0203#ordenaMonuments
     */
    public static ArrayList<HashMap<String, Object>> ordenaMonuments(String filePath, String sortKey) throws IOException {
        // Camps vàlids per ordenar
        String[] validKeys = {"nom", "any", "latitud", "longitud"};
        boolean valid = false;

        for (String key : validKeys) {
            if (key.equals(sortKey)) {
                valid = true;
                break;
            }
        }

        if (!valid) {
            throw new IllegalArgumentException("Invalid sort key: " + sortKey);
        }

        ArrayList<HashMap<String, Object>> monuments = MonumentLoader.loadMonuments(filePath);

        Collections.sort(monuments, new Comparator<HashMap<String, Object>>() {
            @Override
            public int compare(HashMap<String, Object> m1, HashMap<String, Object> m2) {
                Object val1 = getSortValue(m1, sortKey);
                Object val2 = getSortValue(m2, sortKey);

                if (val1 == null || val2 == null) return 0; // Si falta el valor, no canvia l'ordre

                if (val1 instanceof String && val2 instanceof String) {
                    return ((String) val1).compareTo((String) val2);
                } else if (val1 instanceof Number && val2 instanceof Number) {
                    return Double.compare(((Number) val1).doubleValue(), ((Number) val2).doubleValue());
                }

                return 0;
            }
        });

        return monuments;
    }


}