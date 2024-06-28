package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestMain {

    @Test
    public void testMainOutputA() throws Exception {
        System.setProperty("environment", "test");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));

        try {
            // Executa el main per a provar la seva sortida
            String[] args = {}; // Passa els arguments necessaris si n'hi ha
            MainA.main(args);
        } finally {
            System.setOut(originalOut);
        }
        
        String text = baos.toString().replace("\r\n", "\n");

        // Obté la data actual en el format necessari
        LocalDate currentDate = LocalDate.now();
        String formattedDate = currentDate.format(DateTimeFormatter.ISO_LOCAL_DATE);

        // Comprova que la sortida conté el text esperat amb la data actual
        String expectedOutput = String.format("""
            Inserted UOR268 with ID: 1
            Inserted UOR268 with ID: 2
            Inserted ZHE524 with ID: 1
            Inserted ZHE524 with ID: 2
            Deleted UOR268: true
            Deleted ZHE524: true
            UOR206{UOR201=1, UOR202='123', UOR203=1}
            ZHE304{ZHE301=1, ZHE302='abc', ZHE303='%s', ZHE304='def'}
            """, formattedDate, formattedDate).replace("\r\n", "\n").replace("            ","");

        String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
        assertTrue(diff.compareTo("identical") == 0, 
            "\n>>>>>>>>>> >>>>>>>>>>\n" +
            diff +
            "<<<<<<<<<< <<<<<<<<<<\n");
    }

    @Test
    public void testMainOutputB() throws Exception {
        System.setProperty("environment", "test");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));

        try {
            // Executa el main per a provar la seva sortida
            String[] args = {}; // Passa els arguments necessaris si n'hi ha
            MainB.main(args);
        } finally {
            System.setOut(originalOut);
        }
        
        String text = baos.toString().replace("\r\n", "\n");

        // Obté la data actual en el format necessari
        LocalDate currentDate = LocalDate.now();
        String formattedDate = currentDate.format(DateTimeFormatter.ISO_LOCAL_DATE);

        // Comprova que la sortida conté el text esperat amb la data actual
        String expectedOutput = String.format("""
            Inserted UOR268 with ID: 1
            Inserted UOR268 with ID: 2
            Inserted ZHE524 with ID: 1
            Inserted ZHE524 with ID: 2
            Updated UOR268: true
            Deleted UOR268: true
            Updated ZHE524: true
            Deleted ZHE524: true
            UOR206{UOR201=1, UOR202='HOLA', UOR203=1}
            ZHE304{ZHE301=1, ZHE302='BLUEY', ZHE303='%s', ZHE304='def'}
            """, formattedDate, formattedDate).replace("\r\n", "\n").replace("            ","");

        String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
        assertTrue(diff.compareTo("identical") == 0, 
            "\n>>>>>>>>>> >>>>>>>>>>\n" +
            diff +
            "<<<<<<<<<< <<<<<<<<<<\n");
    }

    @Test
    public void testMainTablesA() throws SQLException {
        // Adjust this URL with your MySQL connection details
        String url = "jdbc:sqlite:dades.sqlite";
        Connection conn = DriverManager.getConnection(url);
        try {
            conn = DriverManager.getConnection(url);
            conn.setAutoCommit(false); 
            
            DatabaseMetaData dbMetaData = conn.getMetaData();

            // Check the existence and columns of each table
            checkTableExistsAndColumns(dbMetaData, "UOR268", new String[]{"UOR201", "UOR202", "UOR203"});
            checkTableExistsAndColumns(dbMetaData, "ZHE524", new String[]{"ZHE301", "ZHE302", "ZHE303", "ZHE304"});

            // Check foreign key relationship
            checkForeignKey(dbMetaData, "UOR268", "ZHE524", "UOR203");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void checkTableExists(DatabaseMetaData dbMetaData, String tableName) throws SQLException {
        try (ResultSet rs = dbMetaData.getTables(null, null, tableName, null)) {
            assertTrue(rs.next(), "La taula " + tableName + " no existeix.");
        }
    }
    
    private void checkTableExistsAndColumns(DatabaseMetaData dbMetaData, String tableName, String[] columnNames) throws SQLException {
        checkTableExists(dbMetaData, tableName);
        try (ResultSet rs = dbMetaData.getColumns(null, null, tableName, null)) {
            for (String columnName : columnNames) {
                assertTrue(rs.next(), "Esperava més columnes a " + tableName + ".");
                assertEquals(columnName, rs.getString("COLUMN_NAME"), "Nom de columna no coincideix en " + tableName + ".");
            }
        }
    }
    
    private void checkForeignKey(DatabaseMetaData dbMetaData, String tableName, String pkTableName, String fkColumnName) throws SQLException {
        try (ResultSet rs = dbMetaData.getImportedKeys(null, null, tableName)) {
            boolean found = false;
            while (rs.next()) {
                if (rs.getString("PKTABLE_NAME").equals(pkTableName) && rs.getString("FKCOLUMN_NAME").equals(fkColumnName)) {
                    found = true;
                    break;
                }
            }
            assertTrue(found, "No s'ha trobat la clau forana esperada de " + tableName + " a " + pkTableName + " sobre " + fkColumnName + ".");
        }
    }

    @Test
    public void testMainCallsA() throws Exception {
        Class<MainA> clazz = MainA.class;
    
        // Check if the expected methods exist and have the correct modifiers
        assertMethod(clazz, "createTables", false, false, "Error with the definition of the createTables function.");
        assertMethod(clazz, "insertUOR268", false, false, "Error with the definition of the insertUOR268 function.", UOR268.class);
        assertMethod(clazz, "insertZHE524", false, false, "Error with the definition of the insertZHE524 function.", ZHE524.class); 
        assertMethod(clazz, "deleteUOR268", false, false, "Error with the definition of the deleteUOR268 function.", int.class); 
        assertMethod(clazz, "deleteZHE524", false, false, "Error with the definition of the deleteZHE524 function.", int.class); 
        assertMethod(clazz, "getAllUOR268", false, false, "Error with the definition of the getAllUOR268 function.");
        assertMethod(clazz, "getAllZHE524", false, false, "Error with the definition of the getAllZHE524 function.");
    }

    @Test
    public void testMainCallsB() throws Exception {
        Class<MainB> clazz = MainB.class;
    
        // Check if the expected methods exist and have the correct modifiers
        assertMethod(clazz, "updateUOR268", false, false, "Error with the definition of the updateUOR268 function.", UOR268.class);
        assertMethod(clazz, "updateZHE524", false, false, "Error with the definition of the updateZHE524 function.", ZHE524.class);
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
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));

        try {
            Locale.setDefault(Locale.US);
            Date date = new Date(System.currentTimeMillis());
            
            MainA app = new MainA();
            app.connect();

            // Create tables
            app.createTables();

            date = new Date(0);

            List<UOR268> listUOR268 = new ArrayList<>();
            listUOR268.add(new UOR268(-1, "toto", 44));
            listUOR268.add(new UOR268(-1, "tete", 66));
            listUOR268.add(new UOR268(-1, "titi", 88));

            List<ZHE524> listZHE524 = new ArrayList<>();
            listZHE524.add(new ZHE524(-1, "koko", date, "raku"));
            listZHE524.add(new ZHE524(-1, "jojo", date, "raju"));
            listZHE524.add(new ZHE524(-1, "soso", date, "rasu"));

            // Inserir dades a la base de dades
            for (UOR268 elm : listUOR268) {
                int id = app.insertUOR268(elm);
                elm.setUOR201(id);
                System.out.println("Inserted UOR268 with ID: " + id);
            }

            for (ZHE524 elm : listZHE524) {
                int id = app.insertZHE524(elm);
                elm.setZHE301(id);
                System.out.println("Inserted ZHE524 with ID: " + id);
            }

            // Eliminar un element
            int idToDelete = listUOR268.get(2).getUOR201();
            boolean deleted = app.deleteUOR268(idToDelete);
            System.out.println("Deleted UOR268: " + deleted);
            app.commit();

            // Eliminar un element
            idToDelete = listZHE524.get(2).getZHE301();
            deleted = app.deleteZHE524(idToDelete);
            System.out.println("Deleted ZHE524: " + deleted);
            app.commit();

            List<UOR268> listA = app.getAllUOR268();
            app.printList(listA);

            List<ZHE524> listB = app.getAllZHE524();
            app.printList(listB);

            // Tanca la base de dades
            app.close();
        } finally {
            System.setOut(originalOut);
        }

        String text = baos.toString().replace("\r\n", "\n");

        String expectedOutput = """
            Inserted UOR268 with ID: 1
            Inserted UOR268 with ID: 2
            Inserted UOR268 with ID: 3
            Inserted ZHE524 with ID: 1
            Inserted ZHE524 with ID: 2
            Inserted ZHE524 with ID: 3
            Deleted UOR268: true
            Deleted ZHE524: true
            UOR206{UOR201=1, UOR202='toto', UOR203=44}
            UOR206{UOR201=2, UOR202='tete', UOR203=66}
            ZHE304{ZHE301=1, ZHE302='koko', ZHE303='1970-01-01', ZHE304='raku'}
            ZHE304{ZHE301=2, ZHE302='jojo', ZHE303='1970-01-01', ZHE304='raju'}
            """.replace("\r\n", "\n").replace("            ","");

        String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
        assertTrue(diff.compareTo("identical") == 0, 
            ">>>>>>>>>> >>>>>>>>>>\n" +
            diff +
            "<<<<<<<<<< <<<<<<<<<<\n");
    }

    @Test
    public void testMainExtraB() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));

        try {
            Locale.setDefault(Locale.US);
            Date date = new Date(System.currentTimeMillis());
            
            MainB app = new MainB();
            app.connect();

            // Create tables
            app.createTables();

            date = new Date(0);

            List<UOR268> listUOR268 = new ArrayList<>();
            listUOR268.add(new UOR268(-1, "toto", 44));
            listUOR268.add(new UOR268(-1, "tete", 66));
            listUOR268.add(new UOR268(-1, "titi", 88));

            List<ZHE524> listZHE524 = new ArrayList<>();
            listZHE524.add(new ZHE524(-1, "koko", date, "raku"));
            listZHE524.add(new ZHE524(-1, "jojo", date, "raju"));
            listZHE524.add(new ZHE524(-1, "soso", date, "rasu"));

            // Inserir dades a la base de dades
            for (UOR268 elm : listUOR268) {
                int id = app.insertUOR268(elm);
                elm.setUOR201(id);
                System.out.println("Inserted UOR268 with ID: " + id);
            }

            for (ZHE524 elm : listZHE524) {
                int id = app.insertZHE524(elm);
                elm.setZHE301(id);
                System.out.println("Inserted ZHE524 with ID: " + id);
            }

            // Actualitzar un element
            UOR268 elmUOR = listUOR268.get(0);
            elmUOR.setUOR202("HELLO");
            boolean updated = app.updateUOR268(elmUOR);
            System.out.println("Updated UOR268: " + updated);
            app.commit();

            // Eliminar un element
            int idToDelete = listUOR268.get(2).getUOR201();
            boolean deleted = app.deleteUOR268(idToDelete);
            System.out.println("Deleted UOR268: " + deleted);
            app.commit();

            // Actualitzar un element
            ZHE524 elmZHE = listZHE524.get(0); 
            elmZHE.setZHE302("SQUAREPANTS");
            updated = app.updateZHE524(elmZHE);
            System.out.println("Updated ZHE524: " + updated);
            app.commit();

            // Eliminar un element
            idToDelete = listZHE524.get(2).getZHE301();
            deleted = app.deleteZHE524(idToDelete);
            System.out.println("Deleted ZHE524: " + deleted);
            app.commit();

            List<UOR268> listA = app.getAllUOR268();
            app.printList(listA);

            List<ZHE524> listB = app.getAllZHE524();
            app.printList(listB);

            // Tanca la base de dades
            app.close();
        } finally {
            System.setOut(originalOut);
        }

        String text = baos.toString().replace("\r\n", "\n");

        String expectedOutput = """
            Inserted UOR268 with ID: 1
            Inserted UOR268 with ID: 2
            Inserted UOR268 with ID: 3
            Inserted ZHE524 with ID: 1
            Inserted ZHE524 with ID: 2
            Inserted ZHE524 with ID: 3
            Updated UOR268: true
            Deleted UOR268: true
            Updated ZHE524: true
            Deleted ZHE524: true
            UOR206{UOR201=1, UOR202='HELLO', UOR203=44}
            UOR206{UOR201=2, UOR202='tete', UOR203=66}
            ZHE304{ZHE301=1, ZHE302='SQUAREPANTS', ZHE303='1970-01-01', ZHE304='raku'}
            ZHE304{ZHE301=2, ZHE302='jojo', ZHE303='1970-01-01', ZHE304='raju'}
            """.replace("\r\n", "\n").replace("            ","");

        String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
        assertTrue(diff.compareTo("identical") == 0, 
            ">>>>>>>>>> >>>>>>>>>>\n" +
            diff +
            "<<<<<<<<<< <<<<<<<<<<\n");
    }
}
