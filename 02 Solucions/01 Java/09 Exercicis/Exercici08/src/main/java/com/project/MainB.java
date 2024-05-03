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
        AppData db = AppData.getInstance();
        db.update("DROP TABLE IF EXISTS species");
        db.update("DROP TABLE IF EXISTS spaceships");
        db.update("DROP TABLE IF EXISTS missions");
        db.update("CREATE TABLE IF NOT EXISTS species (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, origin TEXT NOT NULL, limbs INTEGER NOT NULL, telepathic BOOLEAN NOT NULL)");
        db.update("CREATE TABLE IF NOT EXISTS spaceships (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, type TEXT NOT NULL, capacity INTEGER NOT NULL)");
        db.update("CREATE TABLE IF NOT EXISTS missions (id INTEGER PRIMARY KEY AUTOINCREMENT, species_id INTEGER NOT NULL, spaceship_id INTEGER NOT NULL, date DATE NOT NULL, duration REAL NOT NULL, objective TEXT NOT NULL, FOREIGN KEY(species_id) REFERENCES species(id), FOREIGN KEY(spaceship_id) REFERENCES spaceships(id))");
    }
    
    public static void addSpecies(String name, String origin, int limbs, boolean telepathic) {
        String sql = "INSERT INTO species (name, origin, limbs, telepathic) VALUES ('" + name + "', '" + origin + "', " + limbs + ", '" + (telepathic ? "1" : "0") + "')";
        AppData.getInstance().update(sql);
    }

    public static void addSpaceship(String name, String type, int capacity) {
        // Asegurem-nos que la cadena SQL està correctament formatada
        String sql = "INSERT INTO spaceships (name, type, capacity) VALUES ('" + escapeSQL(name) + "', '" + escapeSQL(type) + "', " + capacity + ")";
        AppData.getInstance().update(sql);
    }
    
    public static void addMission(int speciesId, int spaceshipId, String date, double duration, String objective) {
        String sql = "INSERT INTO missions (species_id, spaceship_id, date, duration, objective) VALUES (" + speciesId + ", " + spaceshipId + ", '" + date + "', " + duration + ", '" + objective + "')";
        AppData.getInstance().update(sql);
    }
        
    public static void updateSpecies(int id, String newName, String newOrigin, int newLimbs, boolean newTelepathic) {
        String sql = "UPDATE species SET name = '" + newName + "', origin = '" + newOrigin + "', limbs = " + newLimbs + ", telepathic = '" + (newTelepathic ? "1" : "0") + "' WHERE id = " + id;
        AppData.getInstance().update(sql);
    }

    public static void updateMission(int missionId, String newObjective) {
        String sql = "UPDATE missions SET objective = '" + newObjective + "' WHERE id = " + missionId;
        AppData.getInstance().update(sql);
    }

    public static void deleteSpaceship(int id) {
        String sql = "DELETE FROM spaceships WHERE id = " + id;
        AppData.getInstance().update(sql);
    }

    public static void deleteSpecies(int id) {
        String sql = "DELETE FROM species WHERE id = " + id;
        AppData.getInstance().update(sql);
    }

    public static void listSpecies() {
        String sql = "SELECT * FROM species";
        List<Map<String, Object>> species = AppData.getInstance().query(sql);
        for (Map<String, Object> s : species) {
            System.out.println("ID: " + s.get("id") + ", Name: " + s.get("name") + ", Origin: " + s.get("origin") + ", Limbs: " + s.get("limbs") + ", Telepathic: " + (Integer.parseInt(s.get("telepathic").toString()) == 1 ? "Yes" : "No"));
        }
    }

    public static void listSpaceships() {
        String sql = "SELECT * FROM spaceships";
        List<Map<String, Object>> spaceships = AppData.getInstance().query(sql);
        for (Map<String, Object> ship : spaceships) {
            System.out.println("ID: " + ship.get("id") + ", Name: " + ship.get("name") + ", Type: " + ship.get("type") + ", Capacity: " + ship.get("capacity"));
        }
    }

    public static void listMissions() {
        String sql = "SELECT missions.id, missions.species_id, missions.spaceship_id, missions.date, missions.duration, missions.objective, spaceships.name AS spaceship_name " +
                     "FROM missions " +
                     "JOIN spaceships ON missions.spaceship_id = spaceships.id";
        List<Map<String, Object>> missions = AppData.getInstance().query(sql);
        for (Map<String, Object> mission : missions) {
            System.out.println("ID: " + mission.get("id") + ", Species ID: " + mission.get("species_id") + ", Spaceship Name: " + mission.get("spaceship_name") + ", Date: " + mission.get("date") + ", Duration: " + mission.get("duration") + ", Objective: " + mission.get("objective"));
        }
    }

    // Mètode auxiliar per escapar cometes simples que podrien rompre la cadena SQL
    private static String escapeSQL(String input) {
        return input.replace("'", "''");
    }   
}
