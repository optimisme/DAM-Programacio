package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Constructor;
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
        // Captura la sortida del sistema
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));

        try {
            System.setProperty("environment", "test");

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
            Add languages:
            - Added language with id 1
            - Added language with id 2
            - Added language with id 3
            - Added language with id 4
            - Added language with id 5
            - Added language with id 6

            Known languages:
            - ID: 1, Name: Zyblorg Speech, Planet Origin: Zyblor, Complexity: 5, Telepathic: No, Uses gestures: Yes
            - ID: 2, Name: Xenotalk, Planet Origin: Xeno, Complexity: 7, Telepathic: Yes, Uses gestures: Yes
            - ID: 3, Name: Krillian, Planet Origin: Krill, Complexity: 4, Telepathic: No, Uses gestures: No
            - ID: 4, Name: Glaxan Signs, Planet Origin: Glaxus, Complexity: 3, Telepathic: Yes, Uses gestures: Yes
            - ID: 5, Name: Felp Signals, Planet Origin: Felpar, Complexity: 6, Telepathic: Yes, Uses gestures: No
            - ID: 6, Name: Signarly, Planet Origin: Sigmar, Complexity: 2, Telepathic: No, Uses gestures: Yes
            """.replace("\r\n", "\n").replace("            ","");
        String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
        assertTrue(diff.compareTo("identical") == 0, 
            "\n>>>>>>>>>> >>>>>>>>>>\n" +
            diff +
            "<<<<<<<<<< <<<<<<<<<<\n");
    }

    @Test
    public void testMainOutputB() throws Exception {
        // Captura la sortida del sistema
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));

        try {
            System.setProperty("environment", "test");

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
            Add languages:
            - Added language with id 1
            - Added language with id 2
            - Added language with id 3
            - Added language with id 4
            - Added language with id 5
            - Added language with id 6

            Statistics:
            - Average Complexity: 4.50
            - Count languages: 6
            - Count thelepatic languages: 3
            - Minimum Complexity: 2
            - Maximum Complexity: 7
            - Percentage of languages using gestures: 33.33%
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

            // Check for existence of languages table
            checkTableExists(dbMetaData, "languages", "id", "name", "planet_origin", "complexity", "telepathic", "has_syntax", "uses_gestures", "type");
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

    @Test
    public void testMainCallsA() throws Exception {
        Class<MainA> clazz = MainA.class;

        // Check for methods related to creating, adding, and listing entries
        assertMethod(clazz, "createTables", true, false, "The createTables method should be defined correctly.");
        assertMethod(clazz, "addLanguage", true, false, "The addLanguage method should be defined correctly.", Language.class);
        assertMethod(clazz, "listLanguages", true, false, "The listLanguages method should be defined correctly.");

        Class<Language> clazzL = Language.class;

        // Test language constructors
        Constructor<?>[] constructors = clazzL.getDeclaredConstructors();
        assertTrue(constructors.length >= 2, "There should be at least two constructors.");

        // Test language existence of abstract method getInsertSQL
        Method getInsertSQL = clazzL.getDeclaredMethod("getInsertSQL");
        assertTrue(Modifier.isAbstract(getInsertSQL.getModifiers()), "The getInsertSQL method should be abstract.");

        // Test language getters
        assertMethod(clazzL, "getId", false, false, "The getId method should be defined correctly at Language class.");
        assertMethod(clazzL, "getName", false, false, "The getName method should be defined correctly at Language class.");
        assertMethod(clazzL, "getPlanetOrigin", false, false, "The getPlanetOrigin method should be defined correctly at Language class.");
        assertMethod(clazzL, "getComplexity", false, false, "The getComplexity method should be defined correctly at Language class.");
        assertMethod(clazzL, "isTelepathic", false, false, "The isTelepathic method should be defined correctly at Language class.");

        // Test language setters
        assertMethod(clazzL, "setId", false, false, "The setId method should be defined correctly at Language class.", int.class);
        assertMethod(clazzL, "setName", false, false, "The setName method should be defined correctly at Language class.", String.class);
        assertMethod(clazzL, "setPlanetOrigin", false, false, "The setPlanetOrigin method should be defined correctly at Language class.", String.class);
        assertMethod(clazzL, "setComplexity", false, false, "The setComplexity method should be defined correctly at Language class.", int.class);
        assertMethod(clazzL, "setTelepathic", false, false, "The setTelepathic method should be defined correctly at Language class.", boolean.class);

        Class<LanguageSign> clazzLS = LanguageSign.class;

        assertMethod(clazzLS, "getInsertSQL", false, false, "The getId method should be defined correctly at LanguageSign class.");
        assertMethod(clazzLS, "toString", false, false, "The getId method should be defined correctly at LanguageSign class.");

        Class<LanguageVerbal> clazzLV = LanguageVerbal.class;

        assertMethod(clazzLV, "getInsertSQL", false, false, "The getId method should be defined correctly at LanguageVerbal class.");
        assertMethod(clazzLV, "toString", false, false, "The getId method should be defined correctly at LanguageVerbal class.");

        // Test inheritance
        assertTrue(Language.class.isAssignableFrom(LanguageSign.class), "LanguageSign should be a subclass of Language");
        assertTrue(Language.class.isAssignableFrom(LanguageVerbal.class), "LanguageVerbal should be a subclass of Language");
    }

    @Test
    public void testMainCallsB() throws Exception {
        Class<MainB> clazz = MainB.class;

        // Check for methods related to creating, adding, and listing entries
        assertMethod(clazz, "averageComplexity", true, false, "The averageComplexity method should be defined correctly.");
        assertMethod(clazz, "countLanguages", true, false, "The countLanguages method should be defined correctly.");
        assertMethod(clazz, "countTelepathicLanguages", true, false, "The countTelepathicLanguages method should be defined correctly.");
        assertMethod(clazz, "minMaxComplexity", true, false, "The minMaxComplexity method should be defined correctly.");
        assertMethod(clazz, "percentageUsingGestures", true, false, "The percentageUsingGestures method should be defined correctly.");
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

            // Afegir llenguatges verbals
            Language verbal1 = new LanguageVerbal("abc", "def", 51, false, true);
            Language verbal2 = new LanguageVerbal("jkl", "mno", 71, true, true);
            Language verbal3 = new LanguageVerbal("pqr", "stu", 41, false, false);
    
            // Afegir llenguatges de signes
            Language sign1 = new LanguageSign("aaa", "bbb", 32, true, true);
            Language sign2 = new LanguageSign("ccc", "ddd", 62, true, false);
            Language sign3 = new LanguageSign("eee", "fff", 22, false, true);
    
            // Inserció a la base de dades
            System.out.println("Add languages:");
            MainA.addLanguage(verbal1);
            MainA.addLanguage(verbal2);
            MainA.addLanguage(verbal3);
            MainA.addLanguage(sign1);
            MainA.addLanguage(sign2);
            MainA.addLanguage(sign3);
    
            // Llistar tots els llenguatges
            System.out.printf("\nKnown languages:\n");
            MainA.listLanguages();

            // Close the database connection
            db.close();
        } finally {
            // Restaura la sortida original del sistema
            System.setOut(originalOut);
        }

        String text = baos.toString().replace("\r\n", "\n");

        String expectedOutput = """
            Add languages:
            - Added language with id 1
            - Added language with id 2
            - Added language with id 3
            - Added language with id 4
            - Added language with id 5
            - Added language with id 6

            Known languages:
            - ID: 1, Name: abc, Planet Origin: def, Complexity: 51, Telepathic: No, Uses gestures: Yes
            - ID: 2, Name: jkl, Planet Origin: mno, Complexity: 71, Telepathic: Yes, Uses gestures: Yes
            - ID: 3, Name: pqr, Planet Origin: stu, Complexity: 41, Telepathic: No, Uses gestures: No
            - ID: 4, Name: aaa, Planet Origin: bbb, Complexity: 32, Telepathic: Yes, Uses gestures: Yes
            - ID: 5, Name: ccc, Planet Origin: ddd, Complexity: 62, Telepathic: Yes, Uses gestures: No
            - ID: 6, Name: eee, Planet Origin: fff, Complexity: 22, Telepathic: No, Uses gestures: Yes
            """.replace("\r\n", "\n").replace("            ","");

        String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
        assertTrue(diff.compareTo("identical") == 0, 
            ">>>>>>>>>> >>>>>>>>>>\n" +
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

            // Afegir llenguatges verbals
            Language verbal1 = new LanguageVerbal("uiui", "uaua", 25, false, true);
            Language verbal2 = new LanguageVerbal("rere", "rara", 27, true, true);
            Language verbal3 = new LanguageVerbal("wowo", "wawa", 24, false, false);
    
            // Afegir llenguatges de signes
            Language sign1 = new LanguageSign("asd", "fgh", 43, true, true);
            Language sign2 = new LanguageSign("jkl", "xcv", 46, true, false);
            Language sign3 = new LanguageSign("qwe", "iop", 42, false, true);
    
            // Inserció a la base de dades
            System.out.println("Add languages:");
            MainB.addLanguage(verbal1);
            MainB.addLanguage(verbal2);
            MainB.addLanguage(verbal3);
            MainB.addLanguage(sign1);
            MainB.addLanguage(sign2);
            MainB.addLanguage(sign3);
    
            System.out.printf("\nStatistics:");
    
            // Mostrar la mitjana de complexitat
            double averageComplexity = MainB.averageComplexity();
            System.out.printf("\n- Average Complexity: %.2f", averageComplexity);
    
            // Número d'idiomes
            int countLanguages = MainB.countLanguages();
            System.out.printf("\n- Count languages: %d", countLanguages);
            
            // Número d'idiomes telepàtics
            int countTelepathic = MainB.countTelepathicLanguages();
            System.out.printf("\n- Count thelepatic languages: %d", countTelepathic);
    
            // Complexitats
            MainB.minMaxComplexity();
    
            // Percentage d'idiomes que utilitzen gestos
            double percentageGestures = MainB.percentageUsingGestures();
            System.out.printf("- Percentage of languages using gestures: %.2f%%\n", percentageGestures);
            // Close the database connection
            db.close();
        } finally {
            // Restaura la sortida original del sistema
            System.setOut(originalOut);
        }

        String text = baos.toString().replace("\r\n", "\n");

        String expectedOutput = """
            Add languages:
            - Added language with id 1
            - Added language with id 2
            - Added language with id 3
            - Added language with id 4
            - Added language with id 5
            - Added language with id 6

            Statistics:
            - Average Complexity: 34.50
            - Count languages: 6
            - Count thelepatic languages: 3
            - Minimum Complexity: 24
            - Maximum Complexity: 46
            - Percentage of languages using gestures: 33.33%
            """.replace("\r\n", "\n").replace("            ","");

        String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
        assertTrue(diff.compareTo("identical") == 0, 
            ">>>>>>>>>> >>>>>>>>>>\n" +
            diff +
            "<<<<<<<<<< <<<<<<<<<<\n");
    }
}
