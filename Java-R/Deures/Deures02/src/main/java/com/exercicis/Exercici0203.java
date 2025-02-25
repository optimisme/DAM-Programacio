package com.exercicis;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

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
            ArrayList<HashMap<String, Object>> monuments = loadMonuments("./data/patrimoni.json");
            ArrayList<HashMap<String, Object>> monumentsOrdenats = ordenaMonuments(monuments, "nom");
            ArrayList<HashMap<String, Object>> monumentsFiltrats = filtraMonuments(monuments, "categoria", "cultural");



        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


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
     * Obté el valor d'un monument segons el camp especificat.
     * Es pot utilitzar tant per a ordenació com per a filtratge.
     * 
     * - Si el camp és "nom", retorna el valor directament de la clau "nom".
     * - Si el camp és "pais", retorna el valor directament de la clau "pais".
     * - Si el camp és "categoria", retorna el valor directament de la clau "categoria".
     * - Si el camp és "any", accedeix al valor de "any_declaracio" dins de "detalls".
     * - Si el camp és "latitud" o "longitud", accedeix al valor corresponent dins de "coordenades",
     *   que es troba dins de "detalls".
     * - Si el valor no existeix o la jerarquia de dades no està present, retorna null.
     * 
     * @param monument HashMap amb les dades del monument.
     * @param key Clau pel qual es vol obtenir el valor (pot ser "nom", "any", "latitud" o "longitud").
     * @return Un 'Object' amb el valor corresponent si existeix, en cas contrari retorna null.
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0203#testGetMonumentValue
     */
    private static Object getMonumentValue(HashMap<String, Object> monument, String key) {
        if (monument == null) return null;
    
        if (key.equals("nom") || key.equals("pais") || key.equals("categoria")) {
            return monument.get(key);
        } else if (key.equals("any")) {
            HashMap<?, ?> detalls = (HashMap<?, ?>) monument.get("detalls");
            if (detalls != null) {
                Object any = detalls.get("any_declaracio");
                return any instanceof Number ? ((Number) any).intValue() : null;
            }
        } else if (key.equals("latitud") || key.equals("longitud")) {
            HashMap<?, ?> detalls = (HashMap<?, ?>) monument.get("detalls");
            if (detalls != null) {
                HashMap<?, ?> coordenades = (HashMap<?, ?>) detalls.get("coordenades");
                if (coordenades != null) {
                    Object valor = coordenades.get(key);
                    return valor instanceof Number ? ((Number) valor).doubleValue() : null;
                }
            }
        }
        return null;
    }
    

    /**
     * Comprova si un valor es troba dins d'una llista de valors vàlids.
     * 
     * @param value Valor a comprovar.
     * @param validValues Llista de valors permesos.
     * @return True si el valor és dins de la llista, false en cas contrari.
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0203#testIsValidValue
     */
    private static boolean isValid(String value, String[] validValues) {
        for (String valid : validValues) {
            if (valid.equals(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Ordena un ArrayList de monuments per un camp concret.
     * Els camps vàlids són: 'nom', 'any', 'latitud', 'longitud'
     *      * 
     * @param monuments llista dels monuments
     * @param sortKey camp per ordenar
     * @return ArrayList amb les dades dels monuments
     * 
     * @throws IllegalArgumentException si el paràmetre de columna és invàlid forçant un 'try/catch'
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0203#testOrdenaMonuments
     */
    public static ArrayList<HashMap<String, Object>> ordenaMonuments(ArrayList<HashMap<String, Object>> monuments, String sortKey) throws IllegalArgumentException {
        // Validació dels camps
        String[] validKeys = {"nom", "any", "latitud", "longitud"};
        if (!isValid(sortKey, validKeys)) {
            throw new IllegalArgumentException("Invalid sort key: " + sortKey);
        }
    
        ArrayList<HashMap<String, Object>> rst = new ArrayList<>(monuments);
        rst.sort((m1, m2) -> {
            Object val1 = getMonumentValue(m1, sortKey);
            Object val2 = getMonumentValue(m2, sortKey);
    
            if (val1 == null) return 1;
            if (val2 == null) return -1;
    
            if (val1 instanceof String && val2 instanceof String) {
                return ((String) val1).compareToIgnoreCase((String) val2);
            } else if (val1 instanceof Number && val2 instanceof Number) {
                return Double.compare(((Number) val1).doubleValue(), ((Number) val2).doubleValue());
            }
    
            return 0;
        });
    
        return rst;
    }

    /**
     * Filtra un ArrayList de monuments per un camp i un valor
     * Els camps vàlids són: 'nom', 'pais', 'categoria'
     *      * 
     * @param monuments llista dels monuments
     * @param filterKey camp per filtrar
     * @param filterValue valor a filtrar
     * @return ArrayList amb les dades dels monuments
     * 
     * @throws IllegalArgumentException si el paràmetre de columna és invàlid (no força un 'try/catch')
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0203#testOrdenaMonuments
     */
    public static ArrayList<HashMap<String, Object>> filtraMonuments(ArrayList<HashMap<String, Object>> monuments, String filterKey, String filterValue) throws IllegalArgumentException {
        if (!isValid(filterKey, new String[]{"nom", "pais", "categoria"})) {
            throw new IllegalArgumentException("Invalid filter key: " + filterKey);
        }
    
        List<HashMap<String, Object>> filteredMonuments = monuments.stream()
            .filter(monument -> {
                Object value = getMonumentValue(monument, filterKey);
                return value instanceof String && ((String) value).equalsIgnoreCase(filterValue);
            })
            .collect(Collectors.toList());
    
        return new ArrayList<>(filteredMonuments);
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
        StringBuilder result = new StringBuilder();
        result.append(separators[0]); 
    
        for (int i = 0; i < columnWidths.length; i++) {
            result.append("─".repeat(columnWidths[i])); 
            if (i < columnWidths.length - 1) {
                result.append(separators[1]); 
            }
        }
    
        result.append(separators[2]); 
    
        return result.toString();
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
     * Retorna: "│ Nom       │ País  │ Any  │"
     *
     * formatRow(new String[]{"Machu Picchu", "Perú", "1983"}, new int[]{10, 6, 4});
     * Retorna: "│ Machu Picchu │ Perú  │ 1983 │"
     *
     * @param values Array amb els valors de cada columna.
     * @param columnWidths Array amb l'amplada de cada columna.
     * @return Una cadena de text formatejada representant una fila de la taula.
     */
    private static String formatRow(String[] values, int[] columnWidths) {
        StringBuilder row = new StringBuilder("│");
        for (int i = 0; i < values.length; i++) {
            row.append(String.format(" %-" + columnWidths[i] + "s │", values[i]));
        }
        return row.toString();
    }

    /**
     * Obté una representació en format text de les coordenades d'un monument.
     *
     * La funció busca dins de la clau "detalls" del monument i accedeix a 
     * "coordenades", d'on obté la "latitud" i "longitud". 
     * Si algun d'aquests valors no és present, retorna una cadena buida.
     *
     * Exemple de monument:
     * {
     *   "detalls": {
     *     "coordenades": {
     *       "latitud": "40.4",
     *       "longitud": "116.5"
     *     }
     *   }
     * }
     * 
     * Crida a getCoordsString(monument) → Retorna "40.4,116.5"
     *
     * @param monument HashMap que representa un monument.
     * @return Una cadena de text amb les coordenades en format "latitud,longitud",
     *         o una cadena buida si no es troben les dades.
     */
    private static String getCoordsString(HashMap<String, Object> monument) {
        if (monument.containsKey("detalls")) {
            HashMap<?, ?> detalls = (HashMap<?, ?>) monument.get("detalls");
            if (detalls.containsKey("coordenades")) {
                HashMap<?, ?> coords = (HashMap<?, ?>) detalls.get("coordenades");
                return coords.get("latitud") + "," + coords.get("longitud");
            }
        }
        return "";
    }

    /**
     * Mostra una taula amb la informació d'una llista de monuments.
     * 
     * El format de la taula ha de fer servir els caràcters: "┌", "┬", "┐", "├", "┼", "┤", "└", "┴" i "┘".
     * 
     * Ex.:
     * ┌────────────────┬────────────┬──────┬────────────────┐
     * │ Nom            │ Pais       │ Any  │ Coords         │
     * ├────────────────┼────────────┼──────┼────────────────┤
     * │ Gran Muralla C.│ Xina       │ 1987 │ 40.4,116.5     │
     * │ Machu Picchu   │ Perú       │ 1983 │ -13.1,-72.5    │
     * └────────────────┴────────────┴──────┴────────────────┘
     * 
     * @param monuments llista dels monuments     
     * @param columnaOrdenacio La columna per la qual es vol ordenar ("nom", "radi", "massa", "distància").
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0203#testTaulaMonuments
     */
    public static void taulaMonuments(ArrayList<HashMap<String, Object>> monuments) {
        // Definició de les columnes
        String[] columnTitles = {"Nom", "Pais", "Any", "Coords"};
        int numColumns = columnTitles.length;

        // Determinar l'amplada de cada columna
        int[] columnWidths = new int[numColumns];
        for (int i = 0; i < numColumns; i++) {
            columnWidths[i] = columnTitles[i].length(); // Mida mínima = nom de la columna
        }

        for (HashMap<String, Object> monument : monuments) {
            columnWidths[0] = Math.max(columnWidths[0], monument.get("nom").toString().length());
            columnWidths[1] = Math.max(columnWidths[1], monument.get("pais").toString().length());
            columnWidths[2] = Math.max(columnWidths[2], monument.get("detalls") != null ? monument.get("detalls").toString().length() : 0);
            columnWidths[3] = Math.max(columnWidths[3], getCoordsString(monument).length());
        }

        // Crear i mostrar la taula
        System.out.println(generaMarcTaula(columnWidths, new char[]{'┌', '┬', '┐'}));
        System.out.println(formatRow(columnTitles, columnWidths));
        System.out.println(generaMarcTaula(columnWidths, new char[]{'├', '┼', '┤'}));

        for (HashMap<String, Object> monument : monuments) {
            String[] row = {
                monument.get("nom").toString(),
                monument.get("pais").toString(),
                monument.get("detalls") != null ? monument.get("detalls").toString() : "",
                getCoordsString(monument)
            };
            System.out.println(formatRow(row, columnWidths));
        }

        System.out.println(generaMarcTaula(columnWidths, new char[]{'└', '┴', '┘'}));
    }

    /**
     * Genera una baralla de cartes espanyola i la retorna en un ArrayList ordenat aleatòriament.
     * 
     * La baralla consta de 40 cartes, amb quatre pals: "oros", "copes", "espases" i "bastos".
     * Cada pal té cartes numerades de l'1 al 12.
     * 
     * Cada carta es representa com un HashMap amb dues claus:
     * - "pal" (String): indica el pal de la carta (ex: "oros").
     * - "numero" (Integer): el número de la carta (ex: 7).
     * 
     * Exemple de sortida d'una carta:
     * { "pal": "copes", "número": 10 }
     * 
     * @return Un ArrayList que conté les 40 cartes de la baralla en ordre aleatori.
     */
    public static ArrayList<HashMap<String, Object>> generaBarallaEspanyola() {
        String[] pals = {"oros", "copes", "espases", "bastos"};
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}; 

        ArrayList<HashMap<String, Object>> baralla = new ArrayList<>();

        for (String pal : pals) {
            for (int numero : numeros) {
                HashMap<String, Object> carta = new HashMap<>();
                carta.put("pal", pal);
                carta.put("número", numero);
                baralla.add(carta);
            }
        }

        Collections.shuffle(baralla); // Barreja les cartes aleatòriament

        return baralla;
    }

    
}