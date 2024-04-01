package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.Date;
import java.io.File;
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

        // Comprova que la sortida conté el text esperat
        String expectedOutput = "\nDirectors:" + 
            "\nID: 1, Nom: Director A, Nacionalitat: País X" + 
            "\nID: 2, Nom: Director B, Nacionalitat: País Y" + 
            "\n\nPelis:" + 
            "\nID: 1, Títol: Film A, Any d'Estrena: 2020, Durada: 120 minuts, Director: Director A" + 
            "\nID: 2, Títol: Film B, Any d'Estrena: 2018, Durada: 110 minuts, Director: Director B" + 
            "\n\nSales:" + 
            "\nID: 1, Sala: Sala 1, Capacitat: 150 persones, Peli: Film A" + 
            "\nID: 2, Sala: Sala 2, Capacitat: 200 persones, Peli: Film B" + 
            "\n\nInformació de la Peli: 1" + 
            "\nID: 1, Títol: Film A, Any d'Estrena: 2020, Durada: 120 minuts, Director: Director A, Sala de Projecció: Sala 1";
        assertTrue(text.contains(expectedOutput), 
            ">>>>>>>>>> >>>>>>>>>>\n" +
            "El missatge de sortida no coincideix amb l'esperat. \n" +
            "Esperat: \n" + expectedOutput + "\n" + 
            "Obtingut: \n" + text + 

            "<<<<<<<<<<< <<<<<<<<<<\n");
    }

    @Test
    public void testMainTables() throws SQLException {

        System.setProperty("enviroment", "test");

        // Comprova l'existència de l'arxiu dades.sqlite
        String url = "jdbc:sqlite:dades.sqlite";
    
        File dbFile = new File("dades.sqlite");
        assertTrue(dbFile.exists(), "L'arxiu dades.sqlite no existeix.");
    
        try (Connection conn = DriverManager.getConnection(url)) {
            DatabaseMetaData dbMetaData = conn.getMetaData();
            
            // Comprova l'existència de la taula Directors
            try (ResultSet rs = dbMetaData.getTables(null, null, "directors", null)) {
                assertTrue(rs.next(), "La taula Directors no existeix.");
            }
    
            // Comprova l'existència de la taula Pelis
            try (ResultSet rs = dbMetaData.getTables(null, null, "pelis", null)) {
                assertTrue(rs.next(), "La taula Pelis no existeix.");
            }
    
            // Comprova l'existència de la taula Sales
            try (ResultSet rs = dbMetaData.getTables(null, null, "sales", null)) {
                assertTrue(rs.next(), "La taula Sales no existeix.");
            }
    
            // Comprova les columnes de la taula Directors
            try (ResultSet rs = dbMetaData.getColumns(null, null, "directors", null)) {
                assertTrue(rs.next(), "La taula Directors no té columnes.");
                assertEquals("id_director", rs.getString("COLUMN_NAME"));
                assertEquals("INTEGER", rs.getString("TYPE_NAME"));
    
                assertTrue(rs.next(), "Esperava més columnes en Directors.");
                assertEquals("nom", rs.getString("COLUMN_NAME"));
                assertEquals("TEXT", rs.getString("TYPE_NAME"));
    
                assertTrue(rs.next(), "Esperava més columnes en Directors.");
                assertEquals("nacionalitat", rs.getString("COLUMN_NAME"));
                assertEquals("TEXT", rs.getString("TYPE_NAME"));
            }
    
            // Comprova les columnes de la taula Pelis
            try (ResultSet rs = dbMetaData.getColumns(null, null, "pelis", null)) {
                assertTrue(rs.next(), "La taula Pelis no té columnes.");
                assertEquals("id_peli", rs.getString("COLUMN_NAME"), "La primera columna hauria de ser 'id_peli'.");
                assertEquals("INTEGER", rs.getString("TYPE_NAME"), "El tipus de 'id_peli' hauria de ser INTEGER.");
            
                assertTrue(rs.next(), "Esperava més columnes en Pelis.");
                assertEquals("titol", rs.getString("COLUMN_NAME"), "La segona columna hauria de ser 'titol'.");
                assertEquals("TEXT", rs.getString("TYPE_NAME"), "El tipus de 'titol' hauria de ser TEXT.");
            
                assertTrue(rs.next(), "Esperava més columnes en Pelis.");
                assertEquals("any_estrena", rs.getString("COLUMN_NAME"), "La tercera columna hauria de ser 'any_estrena'.");
                assertEquals("INTEGER", rs.getString("TYPE_NAME"), "El tipus de 'any_estrena' hauria de ser INTEGER.");
            
                assertTrue(rs.next(), "Esperava més columnes en Pelis.");
                assertEquals("durada", rs.getString("COLUMN_NAME"), "La quarta columna hauria de ser 'durada'.");
                assertEquals("INTEGER", rs.getString("TYPE_NAME"), "El tipus de 'durada' hauria de ser INTEGER.");
            
                assertTrue(rs.next(), "Esperava més columnes en Pelis.");
                assertEquals("id_director", rs.getString("COLUMN_NAME"), "La cinquena columna hauria de ser 'id_director'.");
                assertEquals("INTEGER", rs.getString("TYPE_NAME"), "El tipus de 'id_director' hauria de ser INTEGER.");
            }
    
            // Comprova la relació (clau forana) entre pelis i directors
            try (ResultSet rs = dbMetaData.getImportedKeys(null, null, "pelis")) {
                assertTrue(rs.next(), "La taula Pelis no té claus foranes definides cap a Directors.");
                assertEquals("directors", rs.getString("PKTABLE_NAME"), "La taula de clau primària esperada és 'directors'.");
                assertEquals("id_director", rs.getString("PKCOLUMN_NAME"), "La columna de clau primària esperada és 'id_director'.");
            }
    
            // Comprova la clau forana de la taula Pelis cap a Directors
            try (ResultSet rs = dbMetaData.getImportedKeys(null, null, "pelis")) {
                boolean foundDirectorFK = false;
                while (rs.next()) {
                    if ("directors".equals(rs.getString("PKTABLE_NAME")) && "id_director".equals(rs.getString("PKCOLUMN_NAME"))) {
                        foundDirectorFK = true;
                        break;
                    }
                }
                assertTrue(foundDirectorFK, "La taula Pelis no té la clau forana correcta cap a Directors.");
            }

            // Comprova la clau forana de la taula Sales cap a Pelis
            try (ResultSet rs = dbMetaData.getImportedKeys(null, null, "sales")) {
                boolean foundPeliFK = false;
                while (rs.next()) {
                    if ("pelis".equals(rs.getString("PKTABLE_NAME")) && "id_peli".equals(rs.getString("PKCOLUMN_NAME"))) {
                        foundPeliFK = true;
                        break;
                    }
                }
                assertTrue(foundPeliFK, "La taula Sales no té la clau forana correcta cap a Pelis.");
            }
        }
    }

    @Test
    public void testMainCalls() throws Exception {
        Class<Main> clazz = Main.class;

        assertMethod(clazz, "crearTaulaDirectors", true, true, "Error amb la definició de la funció crearTaulaDirectors.");
        assertMethod(clazz, "crearTaulaPelis", true, true, "Error amb la definició de la funció crearTaulaPelis.");
        assertMethod(clazz, "crearTaulaSales", true, true, "Error amb la definició de la funció crearTaulaSales.");
        assertMethod(clazz, "afegirDirector", true, true, "Error amb la definició de la funció afegirDirector.", String.class, String.class);
        assertMethod(clazz, "afegirPeli", true, true, "Error amb la definició de la funció afegirPeli.", String.class, int.class, int.class, int.class);
        assertMethod(clazz, "afegirSala", true, true, "Error amb la definició de la funció afegirSala.", String.class, int.class, int.class);
        assertMethod(clazz, "llistarTaulaDirectors", true, true, "Error amb la definició de la funció llistarTaulaDirectors.");
        assertMethod(clazz, "llistarTaulaPelis", true, true, "Error amb la definició de la funció llistarTaulaPelis.");
        assertMethod(clazz, "llistarTaulaSales", true, true, "Error amb la definició de la funció llistarTaulaSales.");
        assertMethod(clazz, "llistarInfoPeli", true, true, "Error amb la definició de la funció llistarInfoPeli.", int.class);
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
