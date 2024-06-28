package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Date;
import java.sql.*;

public class TestMain {

    @Test
    public void testMainOutput() throws Exception {

        System.setProperty("environment", "test");

        // Capturem la sortida del sistema
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);

        try {
            // Executa el main per a provar la seva sortida
            String[] args = {}; // Passa els arguments necessaris si n'hi ha
            Main.main(args);
        } finally {
            // Restableix la sortida del sistema
            System.setOut(originalOut);
        }

        String text = outputStream.toString();
        text = text.replace("\r\n", "\n");

        // Comprova que la sortida conté el text esperat
        String expectedOutput = """
            Professors:
            ID: 1, Nom: Maria Garcia, Especialitat: Matemàtiques
            ID: 2, Nom: Jordi Pozo, Especialitat: Literatura
            ID: 3, Nom: Anna Molina, Especialitat: Ciències
            
            Assignatures:
            ID: 1, Nom: Algebra, Hores Setmanals: 4, Professor: Maria Garcia
            ID: 2, Nom: Literatura Catalana, Hores Setmanals: 3, Professor: Jordi Pozo
            ID: 3, Nom: Biologia, Hores Setmanals: 5, Professor: Anna Molina
            
            Aules:
            ID: 1, Nom: A101, Capacitat: 30
            ID: 2, Nom: A102, Capacitat: 25
            ID: 3, Nom: B201, Capacitat: 20
            
            Assignatures:
            Assignatures per l'alumne ID 1:
            - Algebra
            Assignatures per l'alumne ID 3:
            - Algebra
            - Literatura Catalana
            - Biologia
            
            Alumnes per assignatura:
            Alumnes inscrits a l'assignatura ID 1:
            - Marc Soler
            - Iván Coll
            Alumnes inscrits a l'assignatura ID 2:
            - Laura Vidal
            - Iván Coll
            Alumnes inscrits a l'assignatura ID 3:
            - Iván Coll
            """.replace("\r\n", "\n").replace("            ","");      
        String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
        assertTrue(diff.compareTo("identical") == 0, 
            "\n>>>>>>>>>> >>>>>>>>>>\n" +
            diff +
            "<<<<<<<<<< <<<<<<<<<<\n");
    }

    @Test
    public void testMainTables() throws SQLException {
        // Ajusta aquesta URL amb els teus detalls de connexió a MySQL
        String url = "jdbc:mysql://localhost:3308/school?user=root&password=pwd";
        try (Connection conn = DriverManager.getConnection(url)) {
            DatabaseMetaData dbMetaData = conn.getMetaData();
    
            // Comprova l'existència i columnes de cada taula
            checkTableExistsAndColumns(dbMetaData, "alumnes", new String[]{"id_alumne", "nom", "cognoms", "data_naixement"});
            checkTableExistsAndColumns(dbMetaData, "professors", new String[]{"id_professor", "nom", "especialitat"});
            checkTableExistsAndColumns(dbMetaData, "assignatures", new String[]{"id_assignatura", "nom", "hores_setmanals", "id_professor"});
            checkTableExistsAndColumns(dbMetaData, "aules", new String[]{"id_aula", "nom", "capacitat"});
            // Aquesta taula no té columnes pròpies a comprovar a part de les claus foranes
            checkTableExists(dbMetaData, "alumne_assignatura");
    
            // Comprova les relacions (claus foranes)
            checkForeignKey(dbMetaData, "alumne_assignatura", "alumnes", "id_alumne");
            checkForeignKey(dbMetaData, "alumne_assignatura", "assignatures", "id_assignatura");
            checkForeignKey(dbMetaData, "assignatures", "professors", "id_professor");
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
                assertTrue(rs.next(), "Esperava més columnes en " + tableName + ".");
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
    public void testMainCalls() throws Exception {
        Class<Main> clazz = Main.class;

        // Comprova que els mètodes esperats existeixen i tenen els modificadors correctes
        assertMethod(clazz, "crearTaules", true, true, "Error amb la definició de la funció crearTaules.");

        assertMethod(clazz, "afegirAlumne", true, true, "Error amb la definició de la funció afegirAlumne.", String.class, String.class, Date.class);
        assertMethod(clazz, "afegirProfessor", true, true, "Error amb la definició de la funció afegirProfessor.", String.class, String.class);
        assertMethod(clazz, "afegirAssignatura", true, true, "Error amb la definició de la funció afegirAssignatura.", String.class, int.class, int.class);
        assertMethod(clazz, "afegirAula", true, true, "Error amb la definició de la funció afegirAula.", String.class, int.class);
        assertMethod(clazz, "inscriureAlumneAssignatura", true, true, "El mètode inscriureAlumneAssignatura.", int.class, int.class);

        assertMethod(clazz, "llistarAlumnes", true, true, "Error amb la definició de la funció llistarAlumnes.");
        assertMethod(clazz, "llistarProfessors", true, true, "Error amb la definició de la funció llistarProfessors.");
        assertMethod(clazz, "llistarAssignatures", true, true, "Error amb la definició de la funció llistarAssignatures.");
        assertMethod(clazz, "llistarAules", true, true, "Error amb la definició de la funció llistarAules.");
        assertMethod(clazz, "llistarAssignaturesAlumne", true, true, "Error amb la definició de la funció llistarAssignaturesAlumne.", int.class);
        assertMethod(clazz, "llistarAlumnesAssignatura", true, true, "Error amb la definició de la funció llistarAlumnesAssignatura.", int.class);

        assertMethod(clazz, "obtenirIdAlumnePerNom", true, true, "Error amb la definició de la funció obtenirIdAlumnePerNom.", String.class, String.class);
        assertMethod(clazz, "obtenirIdAssignaturaPerNom", true, true, "Error amb la definició de la funció obtenirIdAssignaturaPerNom.", String.class);
        assertMethod(clazz, "obtenirIdProfessorPerNom", true, true, "Error amb la definició de la funció obtenirIdProfessorPerNom.", String.class);
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
}
