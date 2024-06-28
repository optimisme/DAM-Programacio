package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
        String expectedOutput = "id Canada: 2:2 > true" +
        "\nid Desert: 2:2 > true" +
        "\nid Baobab: 4:4 > true" +
        "\nid Panda: 2:2 > true" +
        "\nLlista de Paisos:" +
        "\nPais { Id: 1, Nom: \"Espanya\" }" +
        "\nPais { Id: 2, Nom: \"Canadà\" }" +
        "\nPais { Id: 3, Nom: \"Brasil\" }" +
        "\nPais { Id: 4, Nom: \"Austràlia\" }" +
        "\nPais { Id: 5, Nom: \"Sud-àfrica\" }" +
        "\nPais { Id: 6, Nom: \"Xina\" }" +
        "\nPais { Id: 7, Nom: \"Estats Units\" }" +
        "\nPais { Id: 8, Nom: \"Antàrtida\" }" +
        "\nLlista de Paisos de la base de dades:" +
        "\nPais { Id: 1, Nom: \"Espanya\" }" +
        "\nPais { Id: 2, Nom: \"Canadà\" }" +
        "\nPais { Id: 3, Nom: \"Brasil\" }" +
        "\nPais { Id: 4, Nom: \"Austràlia\" }" +
        "\nPais { Id: 5, Nom: \"Sud-àfrica\" }" +
        "\nPais { Id: 6, Nom: \"Xina\" }" +
        "\nPais { Id: 7, Nom: \"Estats Units\" }" +
        "\nPais { Id: 8, Nom: \"Antàrtida\" }" +
        "\nLlista d'Ecosistemes:" +
        "\nEcosistema { Id: 1, Nom: \"Selva\", Id Pais: 3 }" +
        "\nEcosistema { Id: 2, Nom: \"Desert\", Id Pais: 4 }" +
        "\nEcosistema { Id: 3, Nom: \"Bosc\", Id Pais: 2 }" +
        "\nEcosistema { Id: 4, Nom: \"Oceà Antàrtic\", Id Pais: 8 }" +
        "\nLlista d'Ecosistemes de la base de dades:" +
        "\nEcosistema { Id: 1, Nom: \"Selva\", Id Pais: 3 }" +
        "\nEcosistema { Id: 2, Nom: \"Desert\", Id Pais: 4 }" +
        "\nEcosistema { Id: 3, Nom: \"Bosc\", Id Pais: 2 }" +
        "\nEcosistema { Id: 4, Nom: \"Oceà Antàrtic\", Id Pais: 8 }" +
        "\nLlista de Flora:" +
        "\nFlora { Id: 1, Nom Comú: \"Dàlia\", Nom Científic: \"Dahlia pinnata\", Pais: 7, Habitat: \"Jardins i zones cultivades\" }" +
        "\nFlora { Id: 2, Nom Comú: \"Eucaliptus\", Nom Científic: \"Eucalyptus globulus\", Pais: 4, Habitat: \"Boscos oberts i zones costaneres\" }" +
        "\nFlora { Id: 3, Nom Comú: \"Orquídia\", Nom Científic: \"Orchidaceae\", Pais: 1, Habitat: \"Selva tropical, terres baixes humides i muntanyes\" }" +
        "\nFlora { Id: 4, Nom Comú: \"Baobab\", Nom Científic: \"Adansonia\", Pais: 5, Habitat: \"Savanes àrides i terres semiàrides\" }" +
        "\nFlora { Id: 5, Nom Comú: \"Sequoia\", Nom Científic: \"Sequoiadendron giganteum\", Pais: 7, Habitat: \"Boscos humits temperats\" }" +
        "\nFlora { Id: 6, Nom Comú: \"Lavanda\", Nom Científic: \"Lavandula\", Pais: 2, Habitat: \"Terrenys assolellats, secs i calcaris\" }" +
        "\nFlora { Id: 7, Nom Comú: \"Safrà\", Nom Científic: \"Crocus sativus\", Pais: 6, Habitat: \"Terres semiàrides cultivades\" }" +
        "\nFlora { Id: 8, Nom Comú: \"Maple\", Nom Científic: \"Acer\", Pais: 2, Habitat: \"Zones humides i planes\" }" +
        "\nLlista de Flora de la base de dades:" +
        "\nFlora { Id: 1, Nom Comú: \"Dàlia\", Nom Científic: \"Dahlia pinnata\", Pais: 7, Habitat: \"Jardins i zones cultivades\" }" +
        "\nFlora { Id: 2, Nom Comú: \"Eucaliptus\", Nom Científic: \"Eucalyptus globulus\", Pais: 4, Habitat: \"Boscos oberts i zones costaneres\" }" +
        "\nFlora { Id: 3, Nom Comú: \"Orquídia\", Nom Científic: \"Orchidaceae\", Pais: 1, Habitat: \"Selva tropical, terres baixes humides i muntanyes\" }" +
        "\nFlora { Id: 4, Nom Comú: \"Baobab\", Nom Científic: \"Adansonia\", Pais: 5, Habitat: \"Savanes àrides i terres semiàrides\" }" +
        "\nFlora { Id: 5, Nom Comú: \"Sequoia\", Nom Científic: \"Sequoiadendron giganteum\", Pais: 7, Habitat: \"Boscos humits temperats\" }" +
        "\nFlora { Id: 6, Nom Comú: \"Lavanda\", Nom Científic: \"Lavandula\", Pais: 2, Habitat: \"Terrenys assolellats, secs i calcaris\" }" +
        "\nFlora { Id: 7, Nom Comú: \"Safrà\", Nom Científic: \"Crocus sativus\", Pais: 6, Habitat: \"Terres semiàrides cultivades\" }" +
        "\nFlora { Id: 8, Nom Comú: \"Maple\", Nom Científic: \"Acer\", Pais: 2, Habitat: \"Zones humides i planes\" }" +
        "\nLlista de Fauna:" +
        "\nFauna { Id: 1, Nom Comú: \"Koala\", Nom Científic: \"Phascolarctos cinereus\", Pais: 4, Habitat: \"Boscos d'eucaliptus\" }" +
        "\nFauna { Id: 2, Nom Comú: \"Panda\", Nom Científic: \"Ailuropoda melanoleuca\", Pais: 6, Habitat: \"Boscos de muntanya rics en bambú\" }" +
        "\nFauna { Id: 3, Nom Comú: \"Àguila calva\", Nom Científic: \"Haliaeetus leucocephalus\", Pais: 7, Habitat: \"Zones amb llacs i rius\" }" +
        "\nFauna { Id: 4, Nom Comú: \"Lleopard de les neus\", Nom Científic: \"Panthera uncia\", Pais: 6, Habitat: \"Terreny rocos muntanyenc\" }" +
        "\nFauna { Id: 5, Nom Comú: \"Tucà\", Nom Científic: \"Ramphastos\", Pais: 3, Habitat: \"Selves tropicals i boscos humits\" }" +
        "\nFauna { Id: 6, Nom Comú: \"Pingüí emperador\", Nom Científic: \"Aptenodytes forsteri\", Pais: 8, Habitat: \"Zones d'aigües fredes\" }" +
        "\nLlista de Fauna de la base de dades:" +
        "\nFauna { Id: 1, Nom Comú: \"Koala\", Nom Científic: \"Phascolarctos cinereus\", Pais: 4, Habitat: \"Boscos d'eucaliptus\" }" +
        "\nFauna { Id: 2, Nom Comú: \"Panda\", Nom Científic: \"Ailuropoda melanoleuca\", Pais: 6, Habitat: \"Boscos de muntanya rics en bambú\" }" +
        "\nFauna { Id: 3, Nom Comú: \"Àguila calva\", Nom Científic: \"Haliaeetus leucocephalus\", Pais: 7, Habitat: \"Zones amb llacs i rius\" }" +
        "\nFauna { Id: 4, Nom Comú: \"Lleopard de les neus\", Nom Científic: \"Panthera uncia\", Pais: 6, Habitat: \"Terreny rocos muntanyenc\" }" +
        "\nFauna { Id: 5, Nom Comú: \"Tucà\", Nom Científic: \"Ramphastos\", Pais: 3, Habitat: \"Selves tropicals i boscos humits\" }" +
        "\nFauna { Id: 6, Nom Comú: \"Pingüí emperador\", Nom Científic: \"Aptenodytes forsteri\", Pais: 8, Habitat: \"Zones d'aigües fredes\" }" +
        "\nLlista de Flora de l'Ecosistema 1:" +
        "\nFlora { Id: 3, Nom Comú: \"Orquídia\", Nom Científic: \"Orchidaceae\", Pais: 1, Habitat: \"Selva tropical, terres baixes humides i muntanyes\" }" +
        "\nLlista de Fauna de l'Ecosistema 3:" +
        "\nFauna { Id: 1, Nom Comú: \"Koala\", Nom Científic: \"Phascolarctos cinereus\", Pais: 4, Habitat: \"Boscos d'eucaliptus\" }" +
        "\nFauna { Id: 2, Nom Comú: \"Panda\", Nom Científic: \"Ailuropoda melanoleuca\", Pais: 6, Habitat: \"Boscos de muntanya rics en bambú\" }" +
        "\nFauna { Id: 3, Nom Comú: \"Àguila calva\", Nom Científic: \"Haliaeetus leucocephalus\", Pais: 7, Habitat: \"Zones amb llacs i rius\" }" +
        "\n";
        String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
        assertTrue(diff.compareTo("identical") == 0, 
            "\n>>>>>>>>>> >>>>>>>>>>\n" +
            diff +
            "<<<<<<<<<< <<<<<<<<<<\n");
    }

    @Test
    public void testMainPrivateAttributes() {
        // Obtenim tots els camps de la classe Cotxe
        Field[] fields = Ecosistema.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " (Ecosistema) hauria de ser privat");
        }

        fields = Fauna.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " (Fauna) hauria de ser privat");
        }

        fields = Flora.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " (Flora) hauria de ser privat");
        }

        fields = Pais.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " (Pais) hauria de ser privat");
        }
    }

    @Test
    public void testMainTables() throws SQLException {
        // Ajusta aquesta URL amb els teus detalls de connexió a MySQL
        String url = "jdbc:mysql://localhost:3308/natura?user=root&password=pwd";
        try (Connection conn = DriverManager.getConnection(url)) {
            DatabaseMetaData dbMetaData = conn.getMetaData();
    
            // Comprova les relacions (claus foranes)
            checkForeignKey(dbMetaData, "alumne_assignatura", "alumnes", "id_alumne");
            checkForeignKey(dbMetaData, "alumne_assignatura", "assignatures", "id_assignatura");
            checkForeignKey(dbMetaData, "assignatures", "professors", "id_professor");
    
            // Comprova les taules relacionades amb la natura
            checkTableExistsAndColumns(dbMetaData, "paisos", new String[]{"id", "nom"});
            checkTableExistsAndColumns(dbMetaData, "flora", new String[]{"id", "nom_comu", "nom_cientific", "id_pais", "descripcio", "habitat"});
            checkTableExistsAndColumns(dbMetaData, "fauna", new String[]{"id", "nom_comu", "nom_cientific", "id_pais", "descripcio", "habitat"});
            checkTableExistsAndColumns(dbMetaData, "ecosistemes", new String[]{"id", "nom", "caracteristiques", "id_pais"});
            checkTableExistsAndColumns(dbMetaData, "floraEcosistema", new String[]{"id_flora", "id_ecosistema"});
            checkTableExistsAndColumns(dbMetaData, "faunaEcosistema", new String[]{"id_fauna", "id_ecosistema"});
    
            // Comprova les relacions (claus foranes) entre les taules relacionades amb la natura
            checkForeignKey(dbMetaData, "flora", "paisos", "id_pais");
            checkForeignKey(dbMetaData, "fauna", "paisos", "id_pais");
            checkForeignKey(dbMetaData, "ecosistemes", "paisos", "id_pais");
            checkForeignKey(dbMetaData, "floraEcosistema", "flora", "id_flora");
            checkForeignKey(dbMetaData, "floraEcosistema", "ecosistemes", "id_ecosistema");
            checkForeignKey(dbMetaData, "faunaEcosistema", "fauna", "id_fauna");
            checkForeignKey(dbMetaData, "faunaEcosistema", "ecosistemes", "id_ecosistema");
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
    
        assertMethod(clazz, "afegirPais", true, true, "Error amb la definició de la funció afegirPais.", String.class);
        assertMethod(clazz, "afegirFlora", true, true, "Error amb la definició de la funció afegirFlora.", String.class, String.class, int.class, String.class, String.class, int.class);
        assertMethod(clazz, "afegirFauna", true, true, "Error amb la definició de la funció afegirFauna.", String.class, String.class, int.class, String.class, String.class, int.class);
        assertMethod(clazz, "afegirEcosistema", true, true, "Error amb la definició de la funció afegirEcosistema.", String.class, int.class, String.class);
        assertMethod(clazz, "associarFloraAEcosistema", true, true, "Error amb la definició de la funció associarFloraAEcosistema.", int.class, int.class);
        assertMethod(clazz, "associarFaunaAEcosistema", true, true, "Error amb la definició de la funció associarFaunaAEcosistema.", int.class, int.class);
        assertMethod(clazz, "obtenirIdPaisPerNom", true, false, "Error amb la definició de la funció obtenirIdPaisPerNom.", String.class);
        assertMethod(clazz, "obtenirIdFloraPerNomComu", true, false, "Error amb la definició de la funció obtenirIdFloraPerNomComu.", String.class);
        assertMethod(clazz, "obtenirIdFaunaPerNomComu", true, false, "Error amb la definició de la funció obtenirIdFaunaPerNomComu.", String.class);
        assertMethod(clazz, "obtenirIdEcosistemaPerNom", true, false, "Error amb la definició de la funció obtenirIdEcosistemaPerNom.", String.class);
        assertMethod(clazz, "llistarPaisos", true, true, "Error amb la definició de la funció llistarPaisos.");
        assertMethod(clazz, "llistarFlora", true, true, "Error amb la definició de la funció llistarFlora.");
        assertMethod(clazz, "llistarFauna", true, true, "Error amb la definició de la funció llistarFauna.");
        assertMethod(clazz, "llistarEcosistemes", true, true, "Error amb la definició de la funció llistarEcosistemes.");
        assertMethod(clazz, "llistarFloraEcosistema", true, true, "Error amb la definició de la funció llistarFloraEcosistema.", int.class);
        assertMethod(clazz, "llistarFaunaEcosistema", true, true, "Error amb la definició de la funció llistarFaunaEcosistema.", int.class);
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
