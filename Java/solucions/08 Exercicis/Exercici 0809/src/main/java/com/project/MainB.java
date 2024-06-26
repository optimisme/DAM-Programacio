package com.project;

import java.util.List;
import java.util.Locale;
import java.util.Map;

public class MainB {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        AppData db = AppData.getInstance();

        createTables();

        // Afegir llenguatges verbals
        Language verbal1 = new LanguageVerbal("Zyblorg Speech", "Zyblor", 5, false, true);
        Language verbal2 = new LanguageVerbal("Xenotalk", "Xeno", 7, true, true);
        Language verbal3 = new LanguageVerbal("Krillian", "Krill", 4, false, false);

        // Afegir llenguatges de signes
        Language sign1 = new LanguageSign("Glaxan Signs", "Glaxus", 3, true, true);
        Language sign2 = new LanguageSign("Felp Signals", "Felpar", 6, true, false);
        Language sign3 = new LanguageSign("Signarly", "Sigmar", 2, false, true);

        // Inserció a la base de dades
        System.out.println("Add languages:");
        addLanguage(verbal1);
        addLanguage(verbal2);
        addLanguage(verbal3);
        addLanguage(sign1);
        addLanguage(sign2);
        addLanguage(sign3);

        System.out.printf("\nStatistics:");

        // Mostrar la mitjana de complexitat
        double averageComplexity = averageComplexity();
        System.out.printf("\n- Average Complexity: %.2f", averageComplexity);

        // Número d'idiomes
        int countLanguages = countLanguages();
        System.out.printf("\n- Count languages: %d", countLanguages);
        
        // Número d'idiomes telepàtics
        int countTelepathic = countTelepathicLanguages();
        System.out.printf("\n- Count thelepatic languages: %d", countTelepathic);

        // Complexitats
        minMaxComplexity();

        // Percentage d'idiomes que utilitzen gestos
        double percentageGestures = percentageUsingGestures();
        System.out.printf("- Percentage of languages using gestures: %.2f%%\n", percentageGestures);

        db.close();
    }

    public static void createTables() {
        AppData db = AppData.getInstance();
        db.update("DROP TABLE IF EXISTS languages");
        db.update("CREATE TABLE IF NOT EXISTS languages (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, planet_origin TEXT NOT NULL, complexity INTEGER NOT NULL, telepathic BOOLEAN NOT NULL, has_syntax BOOLEAN, uses_gestures BOOLEAN, type TEXT NOT NULL)");
    }

    public static void addLanguage(Language language) {
        int id = AppData.getInstance().insertAndGetId(language.getInsertSQL());
        System.out.printf("- Added language with id %d\n", id);
    }

    public static Language createLanguageFromMap(Map<String, Object> map) {
        Integer id = (Integer) map.get("id");
        String type = (String) map.get("type");
        String name = (String) map.get("name");
        String planetOrigin = (String) map.get("planet_origin");
        Integer complexity = (Integer) map.get("complexity");
        Boolean telepathic = ((Integer) map.get("telepathic")).intValue() == 1; // Convertir Integer a Boolean
    
        if ("Verbal".equals(type)) {
            Boolean hasSyntax = ((Integer) map.get("has_syntax")).intValue() == 1; // Convertir Integer a Boolean
            return new LanguageVerbal(id, name, planetOrigin, complexity, telepathic, hasSyntax);
        } else if ("Sign".equals(type)) {
            Boolean usesGestures = ((Integer) map.get("uses_gestures")).intValue() == 1; // Convertir Integer a Boolean
            return new LanguageSign(id, name, planetOrigin, complexity, telepathic, usesGestures);
        }
        return null; // or throw an exception if the type is not recognized
    }

    public static void listLanguages() {
        String sql = "SELECT * FROM languages";
        List<Map<String, Object>> languages = AppData.getInstance().query(sql);
        for (Map<String, Object> map : languages) {
            Language language = createLanguageFromMap(map);
            if (language != null) {
                System.out.println(language);
            }
        }
    }

    public static double averageComplexity() {
        String sql = "SELECT AVG(complexity) AS average_complexity FROM languages";
        List<Map<String, Object>> results = AppData.getInstance().query(sql);
        if (!results.isEmpty()) {
            return (double) results.get(0).get("average_complexity");
        }
        return 0;
    }

    // Quants idiomes hi ha a la base de dades
    public static int countLanguages() {
        String sql = "SELECT COUNT(*) AS total_languages FROM languages";
        List<Map<String, Object>> results = AppData.getInstance().query(sql);
        if (!results.isEmpty()) {
            return (int) results.get(0).get("total_languages");
        }
        return 0;
    }
    
    // Quantes entrades (idiomes) hi ha a la teva base de dades
    public static int countTelepathicLanguages() {
        String sql = "SELECT COUNT(*) AS count FROM languages WHERE telepathic = '1'";
        List<Map<String, Object>> results = AppData.getInstance().query(sql);
        if (!results.isEmpty()) {
            return (int) results.get(0).get("count");
        }
        return 0;
    }
 
    // Determinar la complexitat màxima i mínima entre els idiomes
    public static void minMaxComplexity() {
        String sql = "SELECT MIN(complexity) AS min_complexity, MAX(complexity) AS max_complexity FROM languages";
        List<Map<String, Object>> results = AppData.getInstance().query(sql);
        if (!results.isEmpty()) {
            System.out.println("\n- Minimum Complexity: " + results.get(0).get("min_complexity"));
            System.out.println("- Maximum Complexity: " + results.get(0).get("max_complexity"));
        }
    }
    
    // Percentatge d'idiomes amb gestos
    public static double percentageUsingGestures() {
        double result = 0.0;
        String sqlTotal = "SELECT COUNT(*) AS total FROM languages";
        String sqlGestures = "SELECT COUNT(*) AS count FROM languages WHERE uses_gestures = '1'";
        List<Map<String, Object>> totalResults = AppData.getInstance().query(sqlTotal);
        List<Map<String, Object>> gestureResults = AppData.getInstance().query(sqlGestures);
        if (!totalResults.isEmpty() && !gestureResults.isEmpty()) {
            int total = (int) totalResults.get(0).get("total");
            int gestures = (int) gestureResults.get(0).get("count");
            result = (double) gestures / total * 100;
        }
        return result;
    }

    // Mètode auxiliar per escapar cometes simples que podrien rompre la cadena SQL
    public static String escapeSQL(String input) {
        return input.replace("'", "''");
    }   
}
