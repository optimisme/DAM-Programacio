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
        text = text.replace("\r\n", "\n");

        // Comprova que la sortida conté el text esperat
        String expectedOutput = "\nEditorials:" +
            "\nID: 1, Nom: Editorial Alpha" +
            "\nID: 2, Nom: Beta Publishers" +
            "\nID: 3, Nom: Gamma Books" +
            "\nID: 4, Nom: Delta Literature" +
            "\n\nLlibres:" +
            "\nID: 1, Títol: El primer llibre, Autor: Autor A, Any: 2020, Editorial: Editorial Alpha" +
            "\nID: 2, Títol: Segona obra, Autor: Autor B, Any: 2018, Editorial: Beta Publishers" +
            "\nID: 3, Títol: Tercer volum, Autor: Autor C, Any: 2019, Editorial: Gamma Books" +
            "\nID: 4, Títol: Quart text, Autor: Autor D, Any: 2021, Editorial: Delta Literature" +
            "\nID: 5, Títol: Cinquè manuscrit, Autor: Autor E, Any: 2022, Editorial: Editorial Alpha" +
            "\nID: 6, Títol: Sisè document, Autor: Autor F, Any: 2023, Editorial: Beta Publishers" +
            "\n\nInformació del Llibre: 5" + 
            "\nID: 5, Títol: Cinquè manuscrit, Autor: Autor E, Any de Publicació: 2022, Editorial: Editorial Alpha" +
            "\n";
        String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
        assertTrue(diff.compareTo("identical") == 0, 
            "\n>>>>>>>>>> >>>>>>>>>>\n" +
            diff +
            "<<<<<<<<<< <<<<<<<<<<\n");
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
            
            // Comprova l'existència de la taula Editorials
            try (ResultSet rs = dbMetaData.getTables(null, null, "editorials", null)) {
                assertTrue(rs.next(), "La taula Editorials no existeix.");
            }

            // Comprova l'existència de la taula Llibres i la relació esperada
            try (ResultSet rs = dbMetaData.getTables(null, null, "llibres", null)) {
                assertTrue(rs.next(), "La taula Llibres no existeix.");
            }

            // Comprova les columnes de la taula Editorials
            try (ResultSet rs = dbMetaData.getColumns(null, null, "editorials", null)) {
                assertTrue(rs.next(), "La taula Editorials no té columnes.");
                assertEquals("id_editorial", rs.getString("COLUMN_NAME"));
                assertEquals("INTEGER", rs.getString("TYPE_NAME"));

                assertTrue(rs.next(), "Esperava més columnes en Editorials.");
                assertEquals("nom", rs.getString("COLUMN_NAME"));
                assertEquals("TEXT", rs.getString("TYPE_NAME"));
            }

            // Comprova les columnes de la taula Llibres
            try (ResultSet rs = dbMetaData.getColumns(null, null, "llibres", null)) {
                assertTrue(rs.next(), "La taula Llibres no té columnes.");
                assertEquals("id_llibre", rs.getString("COLUMN_NAME"));
                assertEquals("INTEGER", rs.getString("TYPE_NAME"));

                assertTrue(rs.next(), "La taula Llibres hauria de tenir més columnes.");
                assertEquals("titol", rs.getString("COLUMN_NAME"));
                assertEquals("TEXT", rs.getString("TYPE_NAME"));

                assertTrue(rs.next(), "La taula Llibres hauria de tenir més columnes.");
                assertEquals("autor", rs.getString("COLUMN_NAME"));
                assertEquals("TEXT", rs.getString("TYPE_NAME"));

                assertTrue(rs.next(), "La taula Llibres hauria de tenir més columnes.");
                assertEquals("any_publicacio", rs.getString("COLUMN_NAME"));
                assertEquals("INTEGER", rs.getString("TYPE_NAME"));

                assertTrue(rs.next(), "La taula Llibres hauria de tenir més columnes.");
                assertEquals("id_editorial", rs.getString("COLUMN_NAME"));
                assertEquals("INTEGER", rs.getString("TYPE_NAME"));
            }

            // Comprova la relació (clau forana) entre llibres i editorials
            try (ResultSet rs = dbMetaData.getImportedKeys(null, null, "llibres")) {
                assertTrue(rs.next(), "La taula Llibres no té claus foranes definides.");
                assertEquals("editorials", rs.getString("PKTABLE_NAME"), "La taula de clau primària esperada és 'editorials'.");
                assertEquals("id_editorial", rs.getString("PKCOLUMN_NAME"), "La columna de clau primària esperada és 'id_editorial'.");
            }
        }
    }

    @Test
    public void testMainCalls() throws Exception {
        Class<Main> clazz = Main.class;

        assertMethod(clazz, "crearTaulaEditorials", true, true, "Error amb la definició de la funció crearTaulaEditorials.");
        assertMethod(clazz, "crearTaulaLlibres", true, true, "Error amb la definició de la funció crearTaulaLlibres.");
        assertMethod(clazz, "afegirEditorial", true, true, "Error amb la definició de la funció afegirEditorial.", String.class);
        assertMethod(clazz, "afegirLlibre", true, true, "Error amb la definició de la funció afegirLlibre.", String.class, String.class, int.class, int.class);
        assertMethod(clazz, "llistarTaulaEditorials", true, true, "Error amb la definició de la funció llistarTaulaEditorials.");
        assertMethod(clazz, "llistarTaulaLlibres", true, true, "Error amb la definició de la funció llistarTaulaLlibres.");
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
