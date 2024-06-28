package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.File;
import java.sql.*;
import java.util.Locale;

public class TestMain {

    @Test
    public void testMainOutputA() throws Exception {
        System.setProperty("environment", "test");

        // Captura la sortida del sistema
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));

        try {
            // Executa el main per a provar la seva sortida
            String[] args = {}; // Passa els arguments necessaris si n'hi ha
            MainA.main(args);
        } finally {
            // Restaura la sortida original del sistema
            System.setOut(originalOut);
        }

        String text = baos.toString().replace("\r\n", "\n");

        // Comprova que la sortida conté el text esperat
        String expectedOutput = """
            Adding initial species...
            ID: 1, Name: Zorglon, Origin: Alpha Centauri, Limbs: 4, Telepathic: Yes
            ID: 2, Name: Glarblex, Origin: Sirius B, Limbs: 6, Telepathic: No

            Adding spaceships...
            ID: 1, Name: SS Voyager, Type: Exploration, Capacity: 1000
            ID: 2, Name: SS Predator, Type: War, Capacity: 2000

            Adding missions...
            ID: 1, Species ID: 1, Spaceship Name: SS Voyager, Date: 2024-05-10, Duration: 100.5, Objective: Explore the unknown regions of Andromeda
            ID: 2, Species ID: 1, Spaceship Name: SS Predator, Date: 2024-06-15, Duration: 300.0, Objective: Defend the Galactic Frontier
            """.replace("\r\n", "\n").replace("            ","");

        String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
        assertTrue(diff.compareTo("identical") == 0,
            "\n>>>>>>>>>> >>>>>>>>>>\n" +
            diff +
            "<<<<<<<<<< <<<<<<<<<<\n");
    }

    @Test
    public void testMainOutputB() throws Exception {
        System.setProperty("environment", "test");

        // Captura la sortida del sistema
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));

        try {
            // Executa el main per a provar la seva sortida
            String[] args = {}; // Passa els arguments necessaris si n'hi ha
            MainB.main(args);
        } finally {
            // Restaura la sortida original del sistema
            System.setOut(originalOut);
        }

        String text = baos.toString().replace("\r\n", "\n");

        // Comprova que la sortida conté el text esperat
        String expectedOutput = """
            Adding initial species...
            ID: 1, Name: Zorglon, Origin: Alpha Centauri, Limbs: 4, Telepathic: Yes
            ID: 2, Name: Glarblex, Origin: Sirius B, Limbs: 6, Telepathic: No
            ID: 3, Name: Vulcor, Origin: Orion Belt, Limbs: 8, Telepathic: Yes

            Adding spaceships...
            ID: 1, Name: SS Voyager, Type: Exploration, Capacity: 1000
            ID: 2, Name: SS Predator, Type: War, Capacity: 2000
            ID: 3, Name: SS Merchant, Type: Trade, Capacity: 500

            Adding missions...
            ID: 1, Species ID: 1, Spaceship Name: SS Merchant, Date: 2024-05-10, Duration: 100.5, Objective: Explore the unknown regions of Andromeda
            ID: 2, Species ID: 2, Spaceship Name: SS Predator, Date: 2024-06-15, Duration: 300.0, Objective: Defend the Galactic Frontier
            ID: 3, Species ID: 3, Spaceship Name: SS Voyager, Date: 2024-07-20, Duration: 50.0, Objective: Trade mission to Betelgeuse

            Updating species 'Zorglon' to 'Zorglon Revised'...
            ID: 1, Name: Zorglon Revised, Origin: Beta Centauri, Limbs: 5, Telepathic: Yes
            ID: 2, Name: Glarblex, Origin: Sirius B, Limbs: 6, Telepathic: No
            ID: 3, Name: Vulcor, Origin: Orion Belt, Limbs: 8, Telepathic: Yes

            Deleting spaceship 'SS Voyager'...
            ID: 2, Name: SS Predator, Type: War, Capacity: 2000
            ID: 3, Name: SS Merchant, Type: Trade, Capacity: 500

            Adding another species and updating a mission...
            ID: 1, Name: Zorglon Revised, Origin: Beta Centauri, Limbs: 5, Telepathic: Yes
            ID: 2, Name: Glarblex, Origin: Sirius B, Limbs: 6, Telepathic: No
            ID: 3, Name: Vulcor, Origin: Orion Belt, Limbs: 8, Telepathic: Yes
            ID: 4, Name: Quibitron, Origin: Zeta Reticuli, Limbs: 8, Telepathic: Yes
            ID: 1, Species ID: 1, Spaceship Name: SS Merchant, Date: 2024-05-10, Duration: 100.5, Objective: Explore the unknown regions of Andromeda
            ID: 2, Species ID: 2, Spaceship Name: SS Predator, Date: 2024-06-15, Duration: 300.0, Objective: Defend the Outer Rim territories

            Deleting species 'Glarblex'...
            ID: 1, Name: Zorglon Revised, Origin: Beta Centauri, Limbs: 5, Telepathic: Yes
            ID: 3, Name: Vulcor, Origin: Orion Belt, Limbs: 8, Telepathic: Yes
            ID: 4, Name: Quibitron, Origin: Zeta Reticuli, Limbs: 8, Telepathic: Yes

            Listing missions after deletion of a species...
            ID: 1, Species ID: 1, Spaceship Name: SS Merchant, Date: 2024-05-10, Duration: 100.5, Objective: Explore the unknown regions of Andromeda
            ID: 2, Species ID: 2, Spaceship Name: SS Predator, Date: 2024-06-15, Duration: 300.0, Objective: Defend the Outer Rim territories
            """.replace("\r\n", "\n").replace("            ","");

        String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
        assertTrue(diff.compareTo("identical") == 0,
            "\n>>>>>>>>>> >>>>>>>>>>\n" +
            diff +
            "<<<<<<<<<< <<<<<<<<<<\n");
    }

    @Test
    public void testMainTablesA() throws SQLException {
        System.setProperty("environment", "test");
        String url = "jdbc:sqlite:dades.sqlite";

        File dbFile = new File("dades.sqlite");
        assertTrue(dbFile.exists(), "The database file does not exist.");

        try (Connection conn = DriverManager.getConnection(url)) {
            DatabaseMetaData dbMetaData = conn.getMetaData();

            // Check for existence of species table
            checkTableExists(dbMetaData, "species", "id", "name", "origin", "limbs", "telepathic");

            // Check for existence of spaceships table
            checkTableExists(dbMetaData, "spaceships", "id", "name", "type", "capacity");

            // Check for existence of missions table
            checkTableExists(dbMetaData, "missions", "id", "species_id", "spaceship_id", "date", "duration", "objective");

            // Check foreign keys for missions table
            checkForeignKey(dbMetaData, "missions", "species", "species_id");
            checkForeignKey(dbMetaData, "missions", "spaceships", "spaceship_id");
        }
    }

    private void checkTableExists(DatabaseMetaData metaData, String tableName, String... columnNames) throws SQLException {
        try (ResultSet rs = metaData.getTables(null, null, tableName, null)) {
            assertTrue(rs.next(), "Table " + tableName + " does not exist.");
        }

        for (String columnName : columnNames) {
            try (ResultSet rs = metaData.getColumns(null, null, tableName, columnName)) {
                assertTrue(rs.next(), "Column " + columnName + " does not exist in table " + tableName);
            }
        }
    }

    private void checkForeignKey(DatabaseMetaData metaData, String tableName, String pkTableName, String fkColumnName) throws SQLException {
        try (ResultSet rs = metaData.getImportedKeys(null, null, tableName)) {
            boolean foundFK = false;
            while (rs.next()) {
                if (pkTableName.equals(rs.getString("PKTABLE_NAME")) && fkColumnName.equals(rs.getString("FKCOLUMN_NAME"))) {
                    foundFK = true;
                    break;
                }
            }
            assertTrue(foundFK, "The table " + tableName + " does not have the correct foreign key relation with " + pkTableName);
        }
    }


    @Test
    public void testMainCallsA() throws Exception {
        Class<MainA> clazz = MainA.class;

        // Check for methods related to creating, adding, and listing entries
        assertMethod(clazz, "createTables", true, false, "The createTables method should be defined correctly.");
        assertMethod(clazz, "addSpecies", true, false, "The addSpecies method should be defined correctly.", String.class, String.class, int.class, boolean.class);
        assertMethod(clazz, "addSpaceship", true, false, "The addSpaceship method should be defined correctly.", String.class, String.class, int.class);
        assertMethod(clazz, "addMission", true, false, "The addMission method should be defined correctly.", int.class, int.class, String.class, double.class, String.class);
        assertMethod(clazz, "listSpecies", true, false, "The listSpecies method should be defined correctly.");
        assertMethod(clazz, "listSpaceships", true, false, "The listSpaceships method should be defined correctly.");
        assertMethod(clazz, "listMissions", true, false, "The listMissions method should be defined correctly.");
    }

    @Test
    public void testMainCallsB() throws Exception {
        Class<MainB> clazz = MainB.class;

        // Check for methods related to creating, adding, and listing entries
        assertMethod(clazz, "updateSpecies", true, false, "The updateSpecies method should be defined correctly.", int.class, String.class, String.class, int.class, boolean.class);
        assertMethod(clazz, "updateMission", true, false, "The updateMission method should be defined correctly.", int.class, String.class);
        assertMethod(clazz, "deleteSpaceship", true, false, "The deleteSpaceship method should be defined correctly.", int.class);
        assertMethod(clazz, "deleteSpecies", true, false, "The deleteSpecies method should be defined correctly.", int.class);
    }

    private void assertMethod(Class<?> clazz, String methodName, boolean shouldBeStatic, boolean shouldBePrivate, String message, Class<?>... parameterTypes) throws NoSuchMethodException {
        // Utilitza getDeclaredMethod per accedir a mètodes privats
        Method method = clazz.getDeclaredMethod(methodName, parameterTypes);
    
        // Comprova si el mètode és estàtic
        boolean isStatic = Modifier.isStatic(method.getModifiers());
        assertEquals(shouldBeStatic, isStatic, message + " El mètode hauria de ser " + (shouldBeStatic ? "static" : "no static") + ".");
    
        // Comprova si el mètode és privat
        boolean isPrivate = Modifier.isPrivate(method.getModifiers());
        assertEquals(shouldBePrivate, isPrivate, message + " El mètode hauria de ser " + (shouldBePrivate ? "privat" : "no privat") + ".");
    }

    @Test
    public void testMainExtraA() throws Exception {
        // Captura la sortida del sistema
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));

        try {
            Locale.setDefault(Locale.US);

            AppData db = AppData.getInstance();

            // Create tables
            MainA.createTables();

            // Adding initial species and list them
            System.out.println("Adding initial species...");
            MainA.addSpecies("Zorglon", "Alpha Centauri", 4, true);
            MainA.addSpecies("Glarblex", "Sirius B", 6, false);
            MainA.addSpecies("Vulcor", "Orion Belt", 8, true);
            MainA.listSpecies();

            // Add spaceships and list them
            System.out.println("\nAdding spaceships...");
            MainA.addSpaceship("SS Voyager", "Exploration", 1000);
            MainA.addSpaceship("SS Predator", "War", 2000);
            MainA.addSpaceship("SS Merchant", "Trade", 500);
            MainA.listSpaceships();

            // Add missions and list them
            System.out.println("\nAdding missions...");
            MainA.addMission(1, 3, "2024-05-10", 100.5, "Explore the unknown regions of Andromeda");
            MainA.addMission(2, 2, "2024-06-15", 300.0, "Defend the Galactic Frontier");
            MainA.addMission(3, 1, "2024-07-20", 50.0, "Trade mission to Betelgeuse");
            MainA.listMissions();

            // Close the database connection
            db.close();
        } finally {
            // Restaura la sortida original del sistema
            System.setOut(originalOut);
        }

        String text = baos.toString().replace("\r\n", "\n");

        // Comprova que la sortida conté el text esperat
        String expectedOutput = """
            Adding initial species...
            ID: 1, Name: Zorglon, Origin: Alpha Centauri, Limbs: 4, Telepathic: Yes
            ID: 2, Name: Glarblex, Origin: Sirius B, Limbs: 6, Telepathic: No
            ID: 3, Name: Vulcor, Origin: Orion Belt, Limbs: 8, Telepathic: Yes
            
            Adding spaceships...
            ID: 1, Name: SS Voyager, Type: Exploration, Capacity: 1000
            ID: 2, Name: SS Predator, Type: War, Capacity: 2000
            ID: 3, Name: SS Merchant, Type: Trade, Capacity: 500
            
            Adding missions...
            ID: 1, Species ID: 1, Spaceship Name: SS Merchant, Date: 2024-05-10, Duration: 100.5, Objective: Explore the unknown regions of Andromeda
            ID: 2, Species ID: 2, Spaceship Name: SS Predator, Date: 2024-06-15, Duration: 300.0, Objective: Defend the Galactic Frontier
            ID: 3, Species ID: 3, Spaceship Name: SS Voyager, Date: 2024-07-20, Duration: 50.0, Objective: Trade mission to Betelgeuse
            """.replace("\r\n", "\n").replace("            ","");

        String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
        assertTrue(diff.compareTo("identical") == 0, 
            "\n>>>>>>>>>> >>>>>>>>>>\n" +
            diff +
            "<<<<<<<<<< <<<<<<<<<<\n");
    }

    @Test
    public void testMainExtraB() throws Exception {
        // Captura la sortida del sistema
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));

        try {
            Locale.setDefault(Locale.US);

            AppData db = AppData.getInstance();

            // Create tables
            MainB.createTables();

            // Adding initial species and list them
            System.out.println("Adding initial species...");
            MainB.addSpecies("abc", "def", 41, true);
            MainB.addSpecies("ghi", "jkl", 61, false);
            MainB.addSpecies("mno", "pqr", 81, true);
            MainB.listSpecies();

            // Add spaceships and list them
            System.out.println("\nAdding spaceships...");
            MainB.addSpaceship("arr", "brr", 1001);
            MainB.addSpaceship("crr", "drr", 2001);
            MainB.addSpaceship("err", "frr", 501);
            MainB.listSpaceships();

            // Add missions and list them
            System.out.println("\nAdding missions...");
            MainB.addMission(1, 3, "2024-05-11", 100.5, "add");
            MainB.addMission(2, 2, "2024-06-11", 300.0, "bdd");
            MainB.addMission(3, 1, "2024-07-21", 50.0, "edd");
            MainB.listMissions();

            // Update species and list
            System.out.println("\nUpdating species 'ghi' to 'ihg'...");
            MainB.updateSpecies(1, "ghi", "igh", 51, true);
            MainB.listSpecies();

            // Delete a spaceship and list
            System.out.println("\nDeleting spaceship 'abc'...");
            MainB.deleteSpaceship(1);
            MainB.listSpaceships();

            // Add another species, update a mission, and list both
            System.out.println("\nAdding another species and updating a mission...");
            MainB.addSpecies("frr", "ftt", 8, true);
            MainB.updateMission(2, "fee");
            MainB.listSpecies();
            MainB.listMissions();

            // Finally, delete a species and list
            System.out.println("\nDeleting species ...");
            MainB.deleteSpecies(2);
            MainB.listSpecies();

            // Checking deletion effect on missions
            System.out.println("\nListing missions after deletion of a species...");
            MainB.listMissions();

            // Close the database connection
            db.close();
        } finally {
            // Restaura la sortida original del sistema
            System.setOut(originalOut);
        }

        String text = baos.toString().replace("\r\n", "\n");

        String expectedOutput = """
            Adding initial species...
            ID: 1, Name: abc, Origin: def, Limbs: 41, Telepathic: Yes
            ID: 2, Name: ghi, Origin: jkl, Limbs: 61, Telepathic: No
            ID: 3, Name: mno, Origin: pqr, Limbs: 81, Telepathic: Yes

            Adding spaceships...
            ID: 1, Name: arr, Type: brr, Capacity: 1001
            ID: 2, Name: crr, Type: drr, Capacity: 2001
            ID: 3, Name: err, Type: frr, Capacity: 501

            Adding missions...
            ID: 1, Species ID: 1, Spaceship Name: err, Date: 2024-05-11, Duration: 100.5, Objective: add
            ID: 2, Species ID: 2, Spaceship Name: crr, Date: 2024-06-11, Duration: 300.0, Objective: bdd
            ID: 3, Species ID: 3, Spaceship Name: arr, Date: 2024-07-21, Duration: 50.0, Objective: edd

            Updating species 'ghi' to 'ihg'...
            ID: 1, Name: ghi, Origin: igh, Limbs: 51, Telepathic: Yes
            ID: 2, Name: ghi, Origin: jkl, Limbs: 61, Telepathic: No
            ID: 3, Name: mno, Origin: pqr, Limbs: 81, Telepathic: Yes

            Deleting spaceship 'abc'...
            ID: 2, Name: crr, Type: drr, Capacity: 2001
            ID: 3, Name: err, Type: frr, Capacity: 501

            Adding another species and updating a mission...
            ID: 1, Name: ghi, Origin: igh, Limbs: 51, Telepathic: Yes
            ID: 2, Name: ghi, Origin: jkl, Limbs: 61, Telepathic: No
            ID: 3, Name: mno, Origin: pqr, Limbs: 81, Telepathic: Yes
            ID: 4, Name: frr, Origin: ftt, Limbs: 8, Telepathic: Yes
            ID: 1, Species ID: 1, Spaceship Name: err, Date: 2024-05-11, Duration: 100.5, Objective: add
            ID: 2, Species ID: 2, Spaceship Name: crr, Date: 2024-06-11, Duration: 300.0, Objective: fee

            Deleting species ...
            ID: 1, Name: ghi, Origin: igh, Limbs: 51, Telepathic: Yes
            ID: 3, Name: mno, Origin: pqr, Limbs: 81, Telepathic: Yes
            ID: 4, Name: frr, Origin: ftt, Limbs: 8, Telepathic: Yes

            Listing missions after deletion of a species...
            ID: 1, Species ID: 1, Spaceship Name: err, Date: 2024-05-11, Duration: 100.5, Objective: add
            ID: 2, Species ID: 2, Spaceship Name: crr, Date: 2024-06-11, Duration: 300.0, Objective: fee
            """.replace("\r\n", "\n").replace("            ","");

        String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
        assertTrue(diff.compareTo("identical") == 0, 
            "\n>>>>>>>>>> >>>>>>>>>>\n" +
            diff +
            "<<<<<<<<<< <<<<<<<<<<\n");
    }
}
