package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.*;
import java.util.List;
import java.util.Locale;

public class TestMain {

    private static String DB = "astronomy";
    private static String USER = "root";
    private static String PWD = "pwd";
    private static String PORT = "3308";
    private static String URL = "jdbc:mysql://localhost:" + PORT + "/"+ DB +"?useSSL=false&allowPublicKeyRetrieval=true";

    @Test
    public void testMainOutput() throws Exception {

        System.setProperty("environment", "test");

        String text = SystemLambda.tapSystemOut(() -> {
            // Executa el main per a provar la seva sortida
            String[] args = {}; // Passa els arguments necessaris si n'hi ha
            Main.main(args);
        });
        text = text.replace("\r\n", "\n");

        // Comprova que la sortida conté el text esperat
        String expectedOutput = """
            Telescope [telescopeId=1, name='Hubble', location='Low Earth Orbit', type='Optic', diameter=2.4]
            Telescope [telescopeId=2, name='James Webb', location='Lagrange Point L2', type='Infrared', diameter=6.5]
            Telescope [telescopeId=3, name='Very Large Telescope', location='Atacama Desert', type='Optic', diameter=8.2]
            Telescope [telescopeId=4, name='Keck', location='Mauna Kea, Hawaii', type='Optic', diameter=10.0]
            Telescope [telescopeId=5, name='ALMA', location='Atacama Desert', type='Radio', diameter=12.0]
            Telescope [telescopeId=6, name='Chandra', location='High Earth Orbit', type='X-Ray', diameter=1.2]
            CelestialBody [bodyId=1, name=Earth, type=Planet, mass=5.97E24, distance=1.0]
            CelestialBody [bodyId=2, name=Jupiter, type=Planet, mass=1.898E27, distance=5.2]
            CelestialBody [bodyId=3, name=Sirius, type=Star, mass=2.063E30, distance=8.6]
            CelestialBody [bodyId=4, name=Andromeda, type=Galaxy, mass=1.23E42, distance=2537000.0]
            CelestialBody [bodyId=5, name=Halley, type=Comet, mass=2.2E14, distance=35.0]
            CelestialBody [bodyId=6, name=Enceladus, type=Moon, mass=1.08E20, distance=1.3]
            CelestialBody [bodyId=7, name=Neptune, type=Planet, mass=1.024E26, distance=30.1]
            CelestialBody [bodyId=8, name=Proxima Centauri, type=Star, mass=1.23E29, distance=4.2]
            CelestialBody [bodyId=9, name=Orion Nebula, type=Nebula, mass=0.0, distance=1345.0]
            CelestialBody [bodyId=10, name=Europa, type=Moon, mass=4.8E22, distance=5.2]
            CelestialBody [bodyId=11, name=Barnard's Star, type=Star, mass=1.5E29, distance=6.0]
            CelestialBody [bodyId=12, name=Sedna, type=Trans-Neptunian Object, mass=1.0E21, distance=936.0]
            CelestialBody [bodyId=13, name=Betelgeuse, type=Star, mass=2.5E31, distance=642.5]
            CelestialBody [bodyId=14, name=Eris, type=Dwarf Planet, mass=1.66E22, distance=96.4]
            CelestialBody [bodyId=15, name=Vega, type=Star, mass=4.1E30, distance=25.0]
            CelestialBody [bodyId=16, name=Ceres, type=Dwarf Planet, mass=9.4E20, distance=2.8]
            Observation [observationId=1, telescopeId=1, bodyId=1, dateTime=2024-04-12 23:45:00.0, description=Detailed observation of Earth]
            Observation [observationId=2, telescopeId=2, bodyId=2, dateTime=2024-03-15 20:30:00.0, description=Night observation of Jupiter with great detail]
            Observation [observationId=3, telescopeId=3, bodyId=3, dateTime=2024-06-01 22:00:00.0, description=Visualization of the Andromeda galaxy]
            Observation [observationId=4, telescopeId=4, bodyId=5, dateTime=2024-07-04 01:45:00.0, description=Study of Halley's comet in its approach]
            Observation [observationId=5, telescopeId=1, bodyId=4, dateTime=2024-09-10 23:15:00.0, description=Monitoring of the moon Enceladus and geothermal activity]
            Observation [observationId=6, telescopeId=5, bodyId=6, dateTime=2024-10-20 19:45:00.0, description=Spectral measurement of the galactic center]
            Observation [observationId=7, telescopeId=1, bodyId=1, dateTime=2024-04-12 23:45:00.0, description=Detailed observation of the Earth]
            Observation [observationId=8, telescopeId=2, bodyId=2, dateTime=2024-03-15 20:30:00.0, description=Detailed night observation of Jupiter]
            Observation [observationId=9, telescopeId=3, bodyId=3, dateTime=2024-06-01 22:00:00.0, description=Visualization of the Andromeda galaxy]
            Observation [observationId=10, telescopeId=4, bodyId=5, dateTime=2024-07-04 01:45:00.0, description=Study of Halley's comet during its approach]
            Observation [observationId=11, telescopeId=1, bodyId=4, dateTime=2024-09-10 23:15:00.0, description=Tracking of the moon Enceladus and geothermal activity]
            Observation [observationId=12, telescopeId=5, bodyId=6, dateTime=2024-10-20 19:45:00.0, description=Measurement of X-ray spectrum from the galactic center]
            Observation [observationId=13, telescopeId=2, bodyId=1, dateTime=2024-04-25 04:15:00.0, description=Study of Saturn's rings using advanced filtering]
            Observation [observationId=14, telescopeId=3, bodyId=6, dateTime=2024-05-18 03:30:00.0, description=Detection of supernovae in the Andromeda galaxy]
            Observation [observationId=15, telescopeId=4, bodyId=7, dateTime=2024-07-22 21:00:00.0, description=Monitoring of Betelgeuse's stellar variability]
            Observation [observationId=16, telescopeId=1, bodyId=8, dateTime=2024-08-13 23:00:00.0, description=Capture of high-resolution images of Mars' surface]
            Observation [observationId=17, telescopeId=5, bodyId=9, dateTime=2024-11-05 20:45:00.0, description=Study of the asteroid belt and identification of possible threats]
            Observation [observationId=18, telescopeId=2, bodyId=10, dateTime=2024-12-05 02:30:00.0, description=Observation of Neptune and its rings in high definition]
            Observation [observationId=19, telescopeId=3, bodyId=11, dateTime=2024-12-15 22:00:00.0, description=Spectroscopic analysis of Proxima Centauri to detect exoplanets]
            Observation [observationId=20, telescopeId=4, bodyId=12, dateTime=2024-12-28 21:15:00.0, description=Study of star formation within the Orion Nebula]
            Observation [observationId=21, telescopeId=1, bodyId=13, dateTime=2025-01-10 19:45:00.0, description=Reconnaissance missions of Europa's icy surface]
            Observation [observationId=22, telescopeId=5, bodyId=14, dateTime=2025-01-22 23:30:00.0, description=Monitoring of Barnard's Star radial velocity]
            Observation [observationId=23, telescopeId=2, bodyId=15, dateTime=2025-02-05 20:20:00.0, description=Tracking of the trajectory of the trans-Neptunian object Sedna]
            Observation [observationId=24, telescopeId=3, bodyId=16, dateTime=2025-02-15 01:40:00.0, description=Measurement of Betelgeuse's luminous magnitude]
            Observation [observationId=25, telescopeId=4, bodyId=17, dateTime=2025-03-01 22:15:00.0, description=Detailed study of the surface features of Eris]
            Observation [observationId=26, telescopeId=1, bodyId=10, dateTime=2025-03-15 03:50:00.0, description=Observation of Neptune's smaller moons]
            Observation [observationId=27, telescopeId=5, bodyId=11, dateTime=2025-03-25 23:45:00.0, description=Investigation of the variability of Proxima Centauri's radio wave emission]
            Observation [observationId=28, telescopeId=2, bodyId=18, dateTime=2025-04-10 21:30:00.0, description=Measurement of Vega's brightness changes]
            Observation [observationId=29, telescopeId=3, bodyId=18, dateTime=2025-05-20 20:15:00.0, description=Analysis of Vega's spectroscopic properties]
            Observation [observationId=30, telescopeId=4, bodyId=19, dateTime=2025-06-15 23:00:00.0, description=Images of Ceres during its closest approach to Earth]
            Observation [observationId=31, telescopeId=1, bodyId=19, dateTime=2025-07-05 22:45:00.0, description=Study of Ceres' surface composition using spectroscopy]
            Observation [observationId=32, telescopeId=5, bodyId=19, dateTime=2025-08-10 00:30:00.0, description=Observation of geological activity on Ceres]
            Observation Frequency:
              Body ID: 1, Observation Count: 3
              Body ID: 2, Observation Count: 2
              Body ID: 3, Observation Count: 2
              Body ID: 4, Observation Count: 2
              Body ID: 5, Observation Count: 2
              Body ID: 6, Observation Count: 3
              Body ID: 7, Observation Count: 1
              Body ID: 8, Observation Count: 1
              Body ID: 9, Observation Count: 1
              Body ID: 10, Observation Count: 2
              Body ID: 11, Observation Count: 2
              Body ID: 12, Observation Count: 1
              Body ID: 13, Observation Count: 1
              Body ID: 14, Observation Count: 1
              Body ID: 15, Observation Count: 1
              Body ID: 16, Observation Count: 1
              Body ID: 17, Observation Count: 1
              Body ID: 18, Observation Count: 2
              Body ID: 19, Observation Count: 3
            Observations meeting the criteria: (dateTime BETWEEN '2024-01-01' AND '2024-04-15')
            Observation [observationId=1, telescopeId=1, bodyId=1, dateTime=2024-04-12 23:45:00.0, description=Detailed observation of Earth]
            Observation [observationId=2, telescopeId=2, bodyId=2, dateTime=2024-03-15 20:30:00.0, description=Night observation of Jupiter with great detail]
            Observation [observationId=7, telescopeId=1, bodyId=1, dateTime=2024-04-12 23:45:00.0, description=Detailed observation of the Earth]
            Observation [observationId=8, telescopeId=2, bodyId=2, dateTime=2024-03-15 20:30:00.0, description=Detailed night observation of Jupiter]
            Observations meeting the criteria: (telescopeId = 3)
            Observation [observationId=3, telescopeId=3, bodyId=3, dateTime=2024-06-01 22:00:00.0, description=Visualization of the Andromeda galaxy]
            Observation [observationId=9, telescopeId=3, bodyId=3, dateTime=2024-06-01 22:00:00.0, description=Visualization of the Andromeda galaxy]
            Observation [observationId=14, telescopeId=3, bodyId=6, dateTime=2024-05-18 03:30:00.0, description=Detection of supernovae in the Andromeda galaxy]
            Observation [observationId=19, telescopeId=3, bodyId=11, dateTime=2024-12-15 22:00:00.0, description=Spectroscopic analysis of Proxima Centauri to detect exoplanets]
            Observation [observationId=24, telescopeId=3, bodyId=16, dateTime=2025-02-15 01:40:00.0, description=Measurement of Betelgeuse's luminous magnitude]
            Observation [observationId=29, telescopeId=3, bodyId=18, dateTime=2025-05-20 20:15:00.0, description=Analysis of Vega's spectroscopic properties]
            Observations meeting the criteria: (description LIKE '%study%')
            Observation [observationId=4, telescopeId=4, bodyId=5, dateTime=2024-07-04 01:45:00.0, description=Study of Halley's comet in its approach]
            Observation [observationId=10, telescopeId=4, bodyId=5, dateTime=2024-07-04 01:45:00.0, description=Study of Halley's comet during its approach]
            Observation [observationId=13, telescopeId=2, bodyId=1, dateTime=2024-04-25 04:15:00.0, description=Study of Saturn's rings using advanced filtering]
            Observation [observationId=17, telescopeId=5, bodyId=9, dateTime=2024-11-05 20:45:00.0, description=Study of the asteroid belt and identification of possible threats]
            Observation [observationId=20, telescopeId=4, bodyId=12, dateTime=2024-12-28 21:15:00.0, description=Study of star formation within the Orion Nebula]
            Observation [observationId=25, telescopeId=4, bodyId=17, dateTime=2025-03-01 22:15:00.0, description=Detailed study of the surface features of Eris]
            Observation [observationId=31, telescopeId=1, bodyId=19, dateTime=2025-07-05 22:45:00.0, description=Study of Ceres' surface composition using spectroscopy]
            Total observations for 'Moon': 5
            Total observations for 'Planet': 6
            Heaviest Celestial Body: Andromeda
            """.replace("\r\n", "\n").replace("            ","");
        String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
        assertTrue(diff.compareTo("identical") == 0, 
            "\n>>>>>>>>>> >>>>>>>>>>\n" +
            diff +
            "<<<<<<<<<< <<<<<<<<<<\n");
    }

    @Test
    public void testMainTables() throws SQLException {
        String url = "jdbc:mysql://localhost:" + PORT + "/"+ DB +"?user=" + USER + "&password=" + PWD;
        try (Connection conn = DriverManager.getConnection(url)) {
            DatabaseMetaData dbMetaData = conn.getMetaData();

            checkTableExistsAndColumns(dbMetaData, "telescopes", new String[]{"telescopeId", "name", "location", "type", "diameter"});
            checkTableExistsAndColumns(dbMetaData, "celestialBodies", new String[]{"bodyId", "name", "type", "mass", "distance"});
            checkTableExistsAndColumns(dbMetaData, "observations", new String[]{"observationId", "telescopeId", "bodyId", "dateTime", "description"});

            checkForeignKey(dbMetaData, "observations", "telescopes", "telescopeId");
            checkForeignKey(dbMetaData, "observations", "celestialBodies", "bodyId");
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

        // Check if the expected methods exist and have the correct modifiers
        assertMethod(clazz, "createTables", true, false, "Error with the definition of the createTables function.", Connection.class);
        assertMethod(clazz, "addTelescope", true, false, "Error with the definition of the addTelescope function.", Connection.class, String.class, String.class, String.class, double.class);
        assertMethod(clazz, "addCelestialBody", true, false, "Error with the definition of the addCelestialBody function.", Connection.class, String.class, String.class, double.class, double.class);
        assertMethod(clazz, "addObservation", true, false, "Error with the definition of the addObservation function.", Connection.class, int.class, int.class, Timestamp.class, String.class);
        assertMethod(clazz, "updateCelestialBodyMass", true, false, "Error with the definition of the updateCelestialBodyMass function.", Connection.class, int.class, double.class);
        assertMethod(clazz, "listTelescopes", true, false, "Error with the definition of the listTelescopes function.", Connection.class);
        assertMethod(clazz, "listCelestialBodies", true, false, "Error with the definition of the listCelestialBodies function.", Connection.class);
        assertMethod(clazz, "listObservations", true, false, "Error with the definition of the listObservations function.", Connection.class);
        assertMethod(clazz, "analyzeObservationFrequency", true, false, "Error with the definition of the analyzeObservationFrequency function.", Connection.class);
        assertMethod(clazz, "filterObservationsByCriteria", true, false, "Error with the definition of the filterObservationsByCriteria function.", Connection.class, String.class);
        assertMethod(clazz, "getTotalObservationsByBodyType", true, false, "Error with the definition of the getTotalObservationsByBodyType function.", Connection.class, String.class);
        assertMethod(clazz, "printHeaviestCelestialBody", true, false, "Error with the definition of the printHeaviestCelestialBody function.", Connection.class);
        assertMethod(clazz, "findHeaviest", true, false, "Error with the definition of the findHeaviest function.", List.class);
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
    public void testMainPrivateAttributes() {
        // Check all fields in the CelestialBody class
        Field[] celestialBodyFields = CelestialBody.class.getDeclaredFields();
        for (Field field : celestialBodyFields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "The field " + field.getName() + " in CelestialBody should be private");
        }

        // Check all fields in the Observation class
        Field[] observationFields = Observation.class.getDeclaredFields();
        for (Field field : observationFields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "The field " + field.getName() + " in Observation should be private");
        }

        // Check all fields in the Telescope class
        Field[] telescopeFields = Telescope.class.getDeclaredFields();
        for (Field field : telescopeFields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "The field " + field.getName() + " in Telescope should be private");
        }
    }

    @Test
    public void testMainExtra() throws Exception {
        
        Locale.setDefault(Locale.US);

        Connection conn = DriverManager.getConnection(URL, USER, PWD);
        conn.setAutoCommit(false);

        String text = SystemLambda.tapSystemOut(() -> {
            Main.createTables(conn);

            Main.addTelescope(conn, "ABC", "1", "2", 2);
            Main.addTelescope(conn, "DEF", "2", "3", 4);

            Main.addCelestialBody(conn, "GHI", "A", 3, 4); 
            Main.addCelestialBody(conn, "JKL", "A", 4, 5);
            Main.addCelestialBody(conn, "MNO", "B", 5, 6); 
            Main.addCelestialBody(conn, "PQR", "B", 6, 7);

            Main.addObservation(conn, 1, 1, Timestamp.valueOf("2024-01-01 00:00:00"), "X0");
            Main.addObservation(conn, 1, 2, Timestamp.valueOf("2024-01-01 00:00:01"), "X1");
            Main.addObservation(conn, 2, 1, Timestamp.valueOf("2024-01-01 00:00:02"), "X2");
            Main.addObservation(conn, 3, 2, Timestamp.valueOf("2024-01-01 00:00:03"), "X3");
            Main.addObservation(conn, 4, 1, Timestamp.valueOf("2024-01-01 00:00:04"), "X4");

            Main.updateCelestialBodyMass(conn, 2, 55);

            conn.commit(); // Confirm all operations at the end

            Main.listTelescopes(conn);

            Main.listCelestialBodies(conn);

            Main.listObservations(conn);

            System.out.println("Observation Frequency:");
            Main.analyzeObservationFrequency(conn);

            String criteria = "dateTime BETWEEN '2024-01-01' AND '2024-04-15'";
            System.out.println("Observations meeting the criteria: (" + criteria + ")");
            Main.filterObservationsByCriteria(conn, criteria);

            int desiredTelescopeId = 3;
            criteria = "telescopeId = " + desiredTelescopeId;
            System.out.println("Observations meeting the criteria: (" + criteria + ")");
            Main.filterObservationsByCriteria(conn, criteria);

            criteria = "description LIKE '%X1%'";           
            System.out.println("Observations meeting the criteria: (" + criteria + ")");
            Main.filterObservationsByCriteria(conn, criteria);

            criteria = "description LIKE '%X9%'";           
            System.out.println("Observations meeting the criteria: (" + criteria + ")");
            Main.filterObservationsByCriteria(conn, criteria);

            System.out.println("Total observations for 'A': " + Main.getTotalObservationsByBodyType(conn, "A"));
            System.out.println("Total observations for 'B': " + Main.getTotalObservationsByBodyType(conn, "B"));
            
            Main.printHeaviestCelestialBody(conn);
            
            conn.close();
        });
        text = text.replace("\r\n", "\n");

        String expectedOutput = """
            Telescope [telescopeId=1, name='ABC', location='1', type='2', diameter=2.0]
            Telescope [telescopeId=2, name='DEF', location='2', type='3', diameter=4.0]
            CelestialBody [bodyId=1, name=GHI, type=A, mass=3.0, distance=4.0]
            CelestialBody [bodyId=2, name=JKL, type=A, mass=55.0, distance=5.0]
            CelestialBody [bodyId=3, name=MNO, type=B, mass=5.0, distance=6.0]
            CelestialBody [bodyId=4, name=PQR, type=B, mass=6.0, distance=7.0]
            Observation [observationId=1, telescopeId=1, bodyId=1, dateTime=2024-01-01 00:00:00.0, description=X0]
            Observation [observationId=2, telescopeId=1, bodyId=2, dateTime=2024-01-01 00:00:01.0, description=X1]
            Observation [observationId=3, telescopeId=2, bodyId=1, dateTime=2024-01-01 00:00:02.0, description=X2]
            Observation [observationId=4, telescopeId=3, bodyId=2, dateTime=2024-01-01 00:00:03.0, description=X3]
            Observation [observationId=5, telescopeId=4, bodyId=1, dateTime=2024-01-01 00:00:04.0, description=X4]
            Observation Frequency:
              Body ID: 1, Observation Count: 3
              Body ID: 2, Observation Count: 2
            Observations meeting the criteria: (dateTime BETWEEN '2024-01-01' AND '2024-04-15')
            Observation [observationId=1, telescopeId=1, bodyId=1, dateTime=2024-01-01 00:00:00.0, description=X0]
            Observation [observationId=2, telescopeId=1, bodyId=2, dateTime=2024-01-01 00:00:01.0, description=X1]
            Observation [observationId=3, telescopeId=2, bodyId=1, dateTime=2024-01-01 00:00:02.0, description=X2]
            Observation [observationId=4, telescopeId=3, bodyId=2, dateTime=2024-01-01 00:00:03.0, description=X3]
            Observation [observationId=5, telescopeId=4, bodyId=1, dateTime=2024-01-01 00:00:04.0, description=X4]
            Observations meeting the criteria: (telescopeId = 3)
            Observation [observationId=4, telescopeId=3, bodyId=2, dateTime=2024-01-01 00:00:03.0, description=X3]
            Observations meeting the criteria: (description LIKE '%X1%')
            Observation [observationId=2, telescopeId=1, bodyId=2, dateTime=2024-01-01 00:00:01.0, description=X1]
            Observations meeting the criteria: (description LIKE '%X9%')
            No observations found meeting the criteria.
            Total observations for 'A': 5
            Total observations for 'B': 0
            Heaviest Celestial Body: JKL
            """.replace("\r\n", "\n").replace("            ","");

        String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0, 
                ">>>>>>>>>> >>>>>>>>>>\n" +
                diff +
                "<<<<<<<<<< <<<<<<<<<<\n");
    }
}
