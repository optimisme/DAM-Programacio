package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.*;

import static org.mockito.Mockito.*;

public class TestMain {

    @Test
    public void testMainOutput() throws Exception {

        System.setProperty("environment", "test");

        // Captura la sortida del sistema
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // Executa el main per a provar la seva sortida
            String[] args = {}; // Passa els arguments necessaris si n'hi ha
            Main.main(args);
        } finally {
            // Restaura la sortida del sistema
            System.setOut(originalOut);
        }

        String text = outputStream.toString().replace("\r\n", "\n");

        // Comprova que la sortida conté el text esperat
        String expectedOutput = "ID: 1, Nom: Zona Arcade, Temàtica: Arcade, Capacitat Màxima: 100" +
            "\nID: 2, Nom: Zona VR, Temàtica: Realitat Virtual, Capacitat Màxima: 50" +
            "\nID: 1, Nom: Passi Bàsic, Preu: 19.99, Durada: 1 dies" +
            "\nID: 2, Nom: Passi Premium, Preu: 39.99, Durada: 3 dies" +
            "\nTarifa: Passi Bàsic" +
            "\nTarifa: Passi Premium" +
            "\nÀrea: Zona Arcade" +
            "\nÀrea: Zona Arcade" +
            "\nÀrea: Zona VR" +
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
        String url = "jdbc:mysql://localhost:3308/videogame_park?user=root&password=pwd";
        try (Connection conn = DriverManager.getConnection(url)) {
            DatabaseMetaData dbMetaData = conn.getMetaData();

            // Comprova l'existència i columnes de cada taula del parc temàtic de videojocs
            checkTableExistsAndColumns(dbMetaData, "arees", new String[]{"id_area", "nom", "tematica", "capacitat_maxima"});
            checkTableExistsAndColumns(dbMetaData, "tarifes", new String[]{"id_tarifa", "nom", "preu", "durada"});
            // La taula acces_area_tarifa enllaça arees i tarifes, per tant comprovarem l'existència de claus foranes després
            checkTableExistsAndColumns(dbMetaData, "acces_area_tarifa", new String[]{"id_area", "id_tarifa"});

            // Comprova les relacions (claus foranes)
            checkForeignKey(dbMetaData, "acces_area_tarifa", "arees", "id_area");
            checkForeignKey(dbMetaData, "acces_area_tarifa", "tarifes", "id_tarifa");
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
        assertMethod(clazz, "crearTaules", true, true, "Error amb la definició de la funció crearTaules.", Connection.class);

        assertMethod(clazz, "afegirArea", true, true, "Error amb la definició de la funció afegirArea.", Connection.class, String.class, String.class, int.class);
        assertMethod(clazz, "afegirTarifa", true, true, "Error amb la definició de la funció afegirTarifa.", Connection.class, String.class, BigDecimal.class, int.class);
        assertMethod(clazz, "definirAccesAreaTarifa", true, true, "Error amb la definició de la funció definirAccesAreaTarifa.", Connection.class, int.class, int.class);

        assertMethod(clazz, "llistarArees", true, true, "Error amb la definició de la funció llistarArees.", Connection.class);
        assertMethod(clazz, "llistarTarifes", true, true, "Error amb la definició de la funció llistarTarifes.", Connection.class);
        assertMethod(clazz, "llistarAreesAccesiblesPerTarifa", true, true, "Error amb la definició de la funció llistarAreesAccesiblesPerTarifa.", Connection.class, int.class);
        assertMethod(clazz, "llistarTarifesPerAccesArea", true, true, "Error amb la definició de la funció llistarTarifesPerAccesArea.", Connection.class, int.class);

        assertMethod(clazz, "obtenirIdAreaPerNom", true, true, "Error amb la definició de la funció obtenirIdAreaPerNom.", Connection.class, String.class);
        assertMethod(clazz, "obtenirIdTarifaPerNom", true, true, "Error amb la definició de la funció obtenirIdTarifaPerNom.", Connection.class, String.class);
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
    void testMainResultSet() throws Exception {
        // Crear mocks
        Connection conn = mock(Connection.class);
        Statement stmt = mock(Statement.class);
        PreparedStatement pstmt = mock(PreparedStatement.class);
        ResultSet rs = mock(ResultSet.class);

        // Configurar el comportament del mock
        when(conn.createStatement()).thenReturn(stmt);
        when(stmt.executeQuery(anyString())).thenReturn(rs);
        when(rs.next()).thenReturn(true, false); // Simula una fila a ResultSet, després fi
        when(rs.getString("nom")).thenReturn("Exemple Area");
        when(rs.getString("tematica")).thenReturn("Arcade");
        when(rs.getInt("capacitat_maxima")).thenReturn(100);

        // Accés al mètode privat via reflexió
        Method method = Main.class.getDeclaredMethod("llistarArees", Connection.class);
        method.setAccessible(true); // Fa el mètode accessible

        // Crida al mètode privat
        method.invoke(null, conn); // Passa 'null' com el primer argument perquè el mètode és estàtic

        // Verifica que s'han cridat els mètodes esperats sobre ResultSet
        verify(rs, atLeastOnce()).getString("nom");
        verify(rs, atLeastOnce()).getString("tematica");
        verify(rs, atLeastOnce()).getInt("capacitat_maxima");

        // Configurar el comportament del mock
        when(conn.createStatement()).thenReturn(stmt);
        when(stmt.executeQuery(anyString())).thenReturn(rs);
        when(rs.next()).thenReturn(true, false); // Simula una fila a ResultSet, després fi
        when(rs.getString("nom")).thenReturn("Tarifa Bàsica");
        when(rs.getBigDecimal("preu")).thenReturn(new java.math.BigDecimal("20.00"));
        when(rs.getInt("durada")).thenReturn(30);

        // Accés al mètode privat via reflexió
        method = Main.class.getDeclaredMethod("llistarTarifes", Connection.class);
        method.setAccessible(true); // Fa el mètode accessible

        // Crida al mètode privat
        method.invoke(null, conn); // Passa 'null' com el primer argument perquè el mètode és estàtic

        // Verifica que s'han cridat els mètodes esperats sobre ResultSet
        verify(rs, atLeastOnce()).getString("nom");
        verify(rs, atLeastOnce()).getBigDecimal("preu");
        verify(rs, atLeastOnce()).getInt("durada");

        // Simula la ID de la tarifa per la qual vols provar
        int idTarifa = 1;

        // Configurar el comportament del mock
        when(conn.prepareStatement(anyString())).thenReturn(pstmt);
        when(pstmt.executeQuery()).thenReturn(rs);
        when(rs.next()).thenReturn(true, true, false); // Simula dues files a ResultSet, després fi
        when(rs.getString("nom")).thenReturn("Àrea 1", "Àrea 2");
        // Afegeix altres dades que esperaries que el teu mètode llegís del ResultSet

        // Crida al mètode a provar
        // Aquí utilitzem reflexió perquè l'exemple original tracta amb mètodes privats
        method = Main.class.getDeclaredMethod("llistarAreesAccesiblesPerTarifa", Connection.class, int.class);
        method.setAccessible(true); // Fa el mètode accessible

        // Crida al mètode privat passant els paràmetres necessaris
        method.invoke(null, conn, idTarifa);

        // Verifica que s'han cridat els mètodes esperats sobre ResultSet
        verify(rs, atLeastOnce()).getString("nom");
    }
}
