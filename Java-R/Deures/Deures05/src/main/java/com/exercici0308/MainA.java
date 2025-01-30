package com.project;

import java.util.List;
import java.util.Locale;
import java.util.Map;

public class MainA {

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

        // Llistar tots els llenguatges
        System.out.printf("\nKnown languages:\n");
        listLanguages();

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

    // Mètode auxiliar per escapar cometes simples que podrien rompre la cadena SQL
    public static String escapeSQL(String input) {
        return input.replace("'", "''");
    }   
}
