package com.exercicis;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONArray;

public class Resolt0202 {

    public static Scanner scanner;
    public static Locale defaultLocale;
    
    // ./run.sh com.exercicis.Exercici0202
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        defaultLocale = Locale.getDefault();
        Locale.setDefault(Locale.US);

        //showJSONAstronautes("./data/astronautes.json");

        // showEsportistesOrdenatsPerMedalla("./data/esportistes.json", "or");
        // showEsportistesOrdenatsPerMedalla("./data/esportistes.json", "plata");

        //mostrarPlanetesOrdenats("./data/planetes.json", "nom");
        //mostrarPlanetesOrdenats("./data/planetes.json", "radi");
        //mostrarPlanetesOrdenats("./data/planetes.json", "massa");
        //mostrarPlanetesOrdenats("./data/planetes.json", "distància");


        ArrayList<HashMap<String, Object>> dades = new ArrayList<>();

        ArrayList<String> caracteristiquesPacific = new ArrayList<>();
        caracteristiquesPacific.add("És l'oceà més gran del món");
        caracteristiquesPacific.add("Conté la fossa de les Marianes, la més profunda del món");
        caracteristiquesPacific.add("Conté una illa de plàstics contaminants.");

        ArrayList<String> caracteristiquesAtlantic = new ArrayList<>();
        caracteristiquesAtlantic.add("Separa Amèrica d'Europa i Àfrica");
        caracteristiquesAtlantic.add("Conté el famós Triangle de les Bermudes");

        ArrayList<String> caracteristiquesMediterrani = new ArrayList<>();
        caracteristiquesMediterrani.add("És un mar gairebé tancat");
        caracteristiquesMediterrani.add("Connecta amb l'oceà Atlàntic a través de l'estret de Gibraltar");

        dades.add(crearMassaAigua("Oceà Pacífic", "oceà", 168723000, 10924, caracteristiquesPacific));
        dades.add(crearMassaAigua("Oceà Atlàntic", "oceà", 85133000, 8486, caracteristiquesAtlantic));
        dades.add(crearMassaAigua("Oceà Índic", "oceà", 70560000, 7450, new ArrayList<>()));
        dades.add(crearMassaAigua("Oceà Àrtic", "oceà", 15558000, 5450, new ArrayList<>()));
        dades.add(crearMassaAigua("Mar Mediterrani", "mar", 2500000, 5121, caracteristiquesMediterrani));
        dades.add(crearMassaAigua("Mar Carib", "mar", 2754000, 7686, new ArrayList<>()));
        dades.add(crearMassaAigua("Mar de la Xina Meridional", "mar", 3500000, 5560, new ArrayList<>()));

        try {
            generarJSON(dades, "./data/aigua.json");
        } catch (IOException e) {
            e.printStackTrace();
        }


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
     * Si el tipus no és "or", "plata" o "bronze" llança una excepció IllegalArgumentException. Amb el text:
     * "Tipus de medalla invàlid: {tipusMedalla}. Tipus vàlids: 'or', 'plata' o 'bronze'."
     * 
     * @param filePath Ruta de l'arxiu JSON amb les dades dels esportistes.
     * @param tipusMedalla Tipus de medalla per ordenar: "or", "plata" o "bronze".
     * @return Llista ordenada d'esportistes segons el nombre de medalles especificat.
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0202#testOrdenarEsportistesPerMedalla
     */
    public static ArrayList<HashMap<String, Object>> ordenarEsportistesPerMedalla(String filePath, String tipusMedalla) throws IllegalArgumentException {
        // Obtenir la llista d'esportistes des del fitxer JSON
        ArrayList<HashMap<String, Object>> esportistes = JSONEsportistesToArrayList(filePath);

        if (!tipusMedalla.equals("or") && !tipusMedalla.equals("plata") && !tipusMedalla.equals("bronze")) {
            throw new IllegalArgumentException("Tipus de medalla invàlid: " + tipusMedalla + ". Tipus vàlids: 'or', 'plata' o 'bronze'.");
        }

        // Ordenem la llista en ordre descendent segons el tipus de medalla
        esportistes.sort((esportista0, esportista1) -> {
            // Fer HashMap<?, ?> enlloc de HashMap<String, Integer> evita warnings de tipus
            HashMap<?, ?> medalles0 = (HashMap<?, ?>) esportista0.get("medalles");
            HashMap<?, ?> medalles1 = (HashMap<?, ?>) esportista1.get("medalles");

            // Com que hem fet servir HashMap<?, ?>, cal definir el tipus (Integer)
            Integer a = (Integer) medalles0.get(tipusMedalla);
            Integer b = (Integer) medalles1.get(tipusMedalla);

            // Ordenar en ordre descendent
            return b.compareTo(a);
        });

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
     * @test ./runTest.sh com.exercicis.TestExercici0202#testShowEsportistesOrdenatsPerOr
     * @test ./runTest.sh com.exercicis.TestExercici0202#testShowEsportistesOrdenatsPerPlata
     * @test ./runTest.sh com.exercicis.TestExercici0202#testShowEsportistesOrdenatsPerBronze
     */
    public static void showEsportistesOrdenatsPerMedalla(String filePath, String tipusMedalla) {
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

    /**
     * Llegeix l'arxiu JSON i converteix la informació dels planetes en una llista d'objectes HashMap.
     * 
     * Cada planeta es representa com un HashMap amb les claus:
     * - "nom" -> String amb el nom del planeta.
     * - "dades_fisiques" -> HashMap amb:
     *     - "radi_km" -> Double amb el radi en quilòmetres.
     *     - "massa_kg" -> Double amb la massa en kilograms.
     * - "orbita" -> HashMap amb:
     *     - "distancia_mitjana_km" -> Double amb la distància mitjana al Sol en quilòmetres.
     *     - "periode_orbital_dies" -> Double amb el període orbital en dies.
     * 
     * @param filePath Ruta de l'arxiu JSON amb les dades dels planetes.
     * @return Una ArrayList de HashMap amb la informació dels planetes.
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0202#testJSONPlanetesToArrayList
     */
    public static ArrayList<HashMap<String, Object>> JSONPlanetesToArrayList(String filePath) {
        ArrayList<HashMap<String, Object>> planetesList = new ArrayList<>();

        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject jsonObject = new JSONObject(content);
            JSONArray planetes = jsonObject.getJSONArray("planetes");

            for (int i = 0; i < planetes.length(); i++) {
                JSONObject planeta = planetes.getJSONObject(i);
                HashMap<String, Object> planetaMap = new HashMap<>();

                planetaMap.put("nom", planeta.getString("nom"));
                
                JSONObject dadesFisiques = planeta.getJSONObject("dades_fisiques");
                HashMap<String, Number> dadesFisiquesMap = new HashMap<>();
                dadesFisiquesMap.put("radi_km", dadesFisiques.getDouble("radi_km"));
                dadesFisiquesMap.put("massa_kg", dadesFisiques.getDouble("massa_kg"));

                planetaMap.put("dades_fisiques", dadesFisiquesMap);

                JSONObject orbita = planeta.getJSONObject("orbita");
                HashMap<String, Number> orbitaMap = new HashMap<>();
                orbitaMap.put("distancia_mitjana_km", orbita.getDouble("distancia_mitjana_km"));
                orbitaMap.put("periode_orbital_dies", orbita.getDouble("periode_orbital_dies"));

                planetaMap.put("orbita", orbitaMap);

                planetesList.add(planetaMap);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return planetesList;
    }

    /**
     * Mostra una taula amb els planetes ordenats segons una columna especificada.
     * 
     * Els valors vàlids per a la columna d'ordenació són:
     * - "nom" -> Ordena alfabèticament pel nom del planeta.
     * - "radi" -> Ordena numèricament pel radi del planeta.
     * - "massa" -> Ordena numèricament per la massa del planeta.
     * - "distància" -> Ordena numèricament per la distància mitjana al Sol.
     * 
     * El format de la taula ha de fer servir els caràcters: "┌", "┬", "┐", "├", "┼", "┤", "└", "┴" i "┘".
     * 
     * Ex.:
     * ┌──────────────┬────────────┬──────────────┬────────────────┐
     * │ Nom          │ Radi (km)  │ Massa (kg)   │ Distància (km) │
     * ├──────────────┼────────────┼──────────────┼────────────────┤
     * │ Mercuri      │ 2439.7     │ 3.3011e23    │ 57910000       │
     * │ Venus        │ 6051.8     │ 4.8675e24    │ 108200000      │
     * └──────────────┴────────────┴──────────────┴────────────────┘
     * 
     * @param filePath Ruta de l'arxiu JSON amb les dades dels planetes.
     * @param columnaOrdenacio La columna per la qual es vol ordenar ("nom", "radi", "massa", "distància").
     * 
     * @throws IllegalArgumentException si el paràmetre de columna és invàlid.
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0202#testMostrarPlanetesOrdenatsNom
     * @test ./runTest.sh com.exercicis.TestExercici0202#testMostrarPlanetesOrdenatsRadi
     * @test ./runTest.sh com.exercicis.TestExercici0202#testMostrarPlanetesOrdenatsMassa
     * @test ./runTest.sh com.exercicis.TestExercici0202#testMostrarPlanetesOrdenatsDistancia
     */
    public static void mostrarPlanetesOrdenats(String filePath, String columnaOrdenacio) throws IllegalArgumentException {
        ArrayList<HashMap<String, Object>> planetes = JSONPlanetesToArrayList(filePath);

        planetes.sort((p1, p2) -> {
            switch (columnaOrdenacio) {
                case "nom":
                    return ((String) p1.get("nom")).compareTo((String) p2.get("nom"));
                case "radi":
                    return Double.compare(
                        ((HashMap<String, Number>) p1.get("dades_fisiques")).get("radi_km").doubleValue(),
                        ((HashMap<String, Number>) p2.get("dades_fisiques")).get("radi_km").doubleValue()
                    );
                case "massa":
                    return Double.compare(
                        ((HashMap<String, Number>) p1.get("dades_fisiques")).get("massa_kg").doubleValue(),
                        ((HashMap<String, Number>) p2.get("dades_fisiques")).get("massa_kg").doubleValue()
                    );
                case "distància":
                    return Double.compare(
                        ((HashMap<String, Number>) p1.get("orbita")).get("distancia_mitjana_km").doubleValue(),
                        ((HashMap<String, Number>) p2.get("orbita")).get("distancia_mitjana_km").doubleValue()
                    );
                default:
                    throw new IllegalArgumentException("Columna d'ordenació invàlida: " + columnaOrdenacio +
                            ". Valors vàlids: 'nom', 'radi', 'massa', 'distància'.");
            }
        });

        System.out.println("┌──────────────┬────────────┬──────────────┬────────────────┐");
        System.out.println("│ Nom          │ Radi (km)  │ Massa (kg)   │ Distància (km) │");
        System.out.println("├──────────────┼────────────┼──────────────┼────────────────┤");

        for (HashMap<String, Object> planeta : planetes) {
            String nom = (String) planeta.get("nom");
            double radi = ((HashMap<String, Number>) planeta.get("dades_fisiques")).get("radi_km").doubleValue();
            double massa = ((HashMap<String, Number>) planeta.get("dades_fisiques")).get("massa_kg").doubleValue();
            double distancia = ((HashMap<String, Number>) planeta.get("orbita")).get("distancia_mitjana_km").doubleValue();

            System.out.printf("│ %-12s │ %-10.1f │ %-12.3e │ %-14.0f │%n", nom, radi, massa, distancia);
        }

        System.out.println("└──────────────┴────────────┴──────────────┴────────────────┘");
    }
    

    /**
     * Crea un HashMap que representa una massa d'aigua amb característiques addicionals.
     * 
     * @param nom Nom del mar o oceà.
     * @param tipus Tipus (mar o oceà).
     * @param superficie_km2 Superfície en km².
     * @param profunditat_max_m Profunditat màxima en metres.
     * @param caracteristiques Llista d'informació addicional sobre el mar o oceà.
     * @return Un HashMap amb les dades del mar o oceà.
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0202#testCrearMassaAigua
     */
    public static HashMap<String, Object> crearMassaAigua(String nom, String tipus, double superficie_km2, double profunditat_max_m, ArrayList<String> caracteristiques) {
        HashMap<String, Object> massaAigua = new HashMap<>();
        massaAigua.put("nom", nom);
        massaAigua.put("tipus", tipus);
        massaAigua.put("superficie_km2", superficie_km2);
        massaAigua.put("profunditat_max_m", profunditat_max_m);
        massaAigua.put("caracteristiques", caracteristiques); // Afegim la llista d'informació addicional
        return massaAigua;
    }

    /**
     * Genera un arxiu JSON amb la informació de mars i oceans. Identat amb "4 espais":
     * [
     *     {
     *         "nom": "Oceà Pacífic",
     *          "tipus": "oceà",
     *          "profunditat_max_m": 10924,
     *          "superficie_km2": 1.68723E8,
     *          "caracteristiques": [
     *              "És l'oceà més gran del món",
     *              "Conté la fossa de les Marianes, la més profunda del món",
     *              "Conté una illa de plàstics contaminants."
     *         ]
     *      },
     *      {
     *          "nom": "Oceà Atlàntic",
     *          "tipus": "oceà", ...
     * 
     * @param filePath Ruta de l'arxiu JSON a crear.
     * @throws IOException Si hi ha algun problema amb l'escriptura de l'arxiu.
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0202#testValidarFormatJSON
     */
    public static void generarJSON(ArrayList<HashMap<String, Object>> dades, String filePath) throws IOException {

        // Convertim el HashMap a JSONObject
        JSONArray json = new JSONArray(dades);

        // Escrivim el JSON a un fitxer
        try (FileWriter file = new FileWriter(filePath)) {
            file.write(json.toString(4)); // JSON amb indentació de 4 espais
        }

        System.out.println("Arxiu JSON generat correctament a: " + filePath);
    }
}