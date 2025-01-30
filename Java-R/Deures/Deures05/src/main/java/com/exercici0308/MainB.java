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
    }

    public static void addLanguage(Language language) {
    }

    public static Language createLanguageFromMap(Map<String, Object> map) {
    }

    public static void listLanguages() {
    }

    public static double averageComplexity() {
    }

    // Quants idiomes hi ha a la base de dades
    public static int countLanguages() {
    }
    
    // Quantes entrades (idiomes) hi ha a la teva base de dades
    public static int countTelepathicLanguages() {
    }
 
    // Determinar la complexitat màxima i mínima entre els idiomes
    public static void minMaxComplexity() {
    }
    
    // Percentatge d'idiomes amb gestos
    public static double percentageUsingGestures() {
    }

    // Mètode auxiliar per escapar cometes simples que podrien rompre la cadena SQL
    public static String escapeSQL(String input) {
        return input.replace("'", "''");
    }   
}
