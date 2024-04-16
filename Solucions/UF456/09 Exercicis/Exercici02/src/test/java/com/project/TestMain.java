package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.Date;
import java.sql.*;

public class TestMain {

    @Test
    public void testMainOutput() throws Exception {

        System.setProperty("enviroment", "test");

        String text = SystemLambda.tapSystemOut(() -> {
            // Executa el main per a provar la seva sortida
            String[] args = {}; // Passa els arguments necessaris si n'hi ha
            Main.main(args);
        });
        text = text.replace("\r\n", "\n");

        // Comprova que la sortida conté el text esperat
        String expectedOutput = "Professors:" + 
        "\nID: 1, Nom: Maria Garcia, Especialitat: Matemàtiques" + 
        "\nID: 2, Nom: Jordi Pozo, Especialitat: Literatura" + 
        "\nID: 3, Nom: Anna Molina, Especialitat: Ciències" + 
        "\n\nAssignatures:" + 
        "\nID: 1, Nom: Maria Garcia, Hores Setmanals: 4, Professor: null" + 
        "\nID: 2, Nom: Jordi Pozo, Hores Setmanals: 3, Professor: null" + 
        "\nID: 3, Nom: Anna Molina, Hores Setmanals: 5, Professor: null" + 
        "\n\nAules:" + 
        "\nID: 1, Nom: A101, Capacitat: 30" + 
        "\nID: 2, Nom: A102, Capacitat: 25" + 
        "\nID: 3, Nom: B201, Capacitat: 20" + 
        "\n\nAssignatures:" + 
        "\nAssignatures per l'alumne ID 1:" + 
        "\n- Algebra" + 
        "\nAssignatures per l'alumne ID 3:" + 
        "\n- Algebra" + 
        "\n- Literatura Catalana" + 
        "\n- Biologia" + 
        "\n\nAlumnes per assignatura:" + 
        "\nAlumnes inscrits a l'assignatura ID 1:" + 
        "\n- Marc Soler" + 
        "\n- Iván Coll" + 
        "\nAlumnes inscrits a l'assignatura ID 2:" + 
        "\n- Laura Vidal" + 
        "\n- Iván Coll" + 
        "\nAlumnes inscrits a l'assignatura ID 3:" + 
        "\n- Iván Coll" +
        "\n";
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
