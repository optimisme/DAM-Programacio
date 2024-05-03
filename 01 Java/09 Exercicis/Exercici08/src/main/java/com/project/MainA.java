package com.project;

import java.util.List;
import java.util.Locale;
import java.util.Map;

public class MainA {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        AppData db = AppData.getInstance();

        // Create extraterrestrial-themed tables
        createTables();

        // Initially add species and list
        System.out.println("Adding initial species...");
        addSpecies("Zorglon", "Alpha Centauri", 4, true);
        addSpecies("Glarblex", "Sirius B", 6, false);
        listSpecies();

        // Add spaceships and list
        System.out.println("\nAdding spaceships...");
        addSpaceship("SS Voyager", "Exploration", 1000);
        addSpaceship("SS Predator", "War", 2000);
        listSpaceships();

        // Add missions and list
        System.out.println("\nAdding missions...");
        addMission(1, 1, "2024-05-10", 100.5, "Explore the unknown regions of Andromeda");
        addMission(1, 2, "2024-06-15", 300.0, "Defend the Galactic Frontier");
        listMissions();

        // Close the database connection
        db.close();
    }

    public static void createTables() {
    }
    
    public static void addSpecies(String name, String origin, int limbs, boolean telepathic) {
    }

    public static void addSpaceship(String name, String type, int capacity) {
    }
    
    public static void addMission(int speciesId, int spaceshipId, String date, double duration, String objective) {
    }

    public static void listSpecies() {
    }

    public static void listSpaceships() {
    }

    public static void listMissions() {
    }
   
    // Mètode auxiliar per escapar cometes simples que podrien rompre la cadena SQL
    private static String escapeSQL(String input) {
        return input.replace("'", "''");
    }   
}
