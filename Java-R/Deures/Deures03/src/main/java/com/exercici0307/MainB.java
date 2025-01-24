package com.project;

import java.util.List;
import java.util.Locale;
import java.util.Map;

public class MainB {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        AppData db = AppData.getInstance();

        // Create extraterrestrial-themed tables
        createTables();

        // Adding initial species and list them
        System.out.println("Adding initial species...");
        MainB.addSpecies("Zorglon", "Alpha Centauri", 4, true);
        MainB.addSpecies("Glarblex", "Sirius B", 6, false);
        MainB.addSpecies("Vulcor", "Orion Belt", 8, true);
        MainB.listSpecies();

        // Add spaceships and list them
        System.out.println("\nAdding spaceships...");
        MainB.addSpaceship("SS Voyager", "Exploration", 1000);
        MainB.addSpaceship("SS Predator", "War", 2000);
        MainB.addSpaceship("SS Merchant", "Trade", 500);
        MainB.listSpaceships();

        // Add missions and list them
        System.out.println("\nAdding missions...");
        MainB.addMission(1, 3, "2024-05-10", 100.5, "Explore the unknown regions of Andromeda");
        MainB.addMission(2, 2, "2024-06-15", 300.0, "Defend the Galactic Frontier");
        MainB.addMission(3, 1, "2024-07-20", 50.0, "Trade mission to Betelgeuse");
        MainB.listMissions();

        // Update species and list
        System.out.println("\nUpdating species 'Zorglon' to 'Zorglon Revised'...");
        MainB.updateSpecies(1, "Zorglon Revised", "Beta Centauri", 5, true);
        MainB.listSpecies();

        // Delete a spaceship and list
        System.out.println("\nDeleting spaceship 'SS Voyager'...");
        MainB.deleteSpaceship(1);
        MainB.listSpaceships();

        // Add another species, update a mission, and list both
        System.out.println("\nAdding another species and updating a mission...");
        MainB.addSpecies("Quibitron", "Zeta Reticuli", 8, true);
        MainB.updateMission(2, "Defend the Outer Rim territories");
        MainB.listSpecies();
        MainB.listMissions();

        // Finally, delete a species and list
        System.out.println("\nDeleting species 'Glarblex'...");
        MainB.deleteSpecies(2);
        MainB.listSpecies();

        // Checking deletion effect on missions
        System.out.println("\nListing missions after deletion of a species...");
        MainB.listMissions();
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
        
    public static void updateSpecies(int id, String newName, String newOrigin, int newLimbs, boolean newTelepathic) {
    }

    public static void updateMission(int missionId, String newObjective) {
    }

    public static void deleteSpaceship(int id) {
    }

    public static void deleteSpecies(int id) {
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
