package com.project;

import org.junit.jupiter.api.Test;

import com.project.Main;
import com.project.TestStringUtils;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.*;

import java.util.Locale;
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
        String expectedOutput = """
            
            Citizens:
            Citizen ID: 1, Name: John Doe, Address: 123 Main St, Capital City, Birth: 1980-01-01, National ID: A12345678, Employment: Employed, Political Affiliation: Party A
            Citizen ID: 2, Name: Jane Smith, Address: 456 Elm St, Capital City, Birth: 1985-02-02, National ID: B87654321, Employment: Unemployed, Political Affiliation: Party B
            Citizen ID: 3, Name: Alice Johnson, Address: 789 Pine St, Northern Town, Birth: 1975-03-15, National ID: C23456789, Employment: Self-employed, Political Affiliation: Party C
            Citizen ID: 4, Name: Bob Lee, Address: 321 Oak St, Southern City, Birth: 1992-11-08, National ID: D34567890, Employment: Student, Political Affiliation: Party A
            Citizen ID: 5, Name: Charlie Brown, Address: 654 Maple St, Eastern City, Birth: 1988-06-21, National ID: E45678901, Employment: Unemployed, Political Affiliation: Party B
            Citizen ID: 6, Name: Emma Wilson, Address: 987 Cedar St, Western Town, Birth: 1990-09-10, National ID: F56789012, Employment: Freelancer, Political Affiliation: Party C
            
            Surveillance Logs:
            Surveillance ID: 1, Location: Downtown Square, Date/Time: 2024-04-14T14:00, Duration: 30, Citizen ID: 1, Observation Type: Public Movement
            Surveillance ID: 2, Location: Online, Date/Time: 2024-04-15T20:00, Duration: 120, Citizen ID: 2, Observation Type: Online Activity
            Surveillance ID: 3, Location: Central Park, Date/Time: 2024-04-16T09:30, Duration: 45, Citizen ID: 3, Observation Type: Public Movement
            Surveillance ID: 4, Location: Online, Date/Time: 2024-04-17T22:00, Duration: 90, Citizen ID: 4, Observation Type: Online Activity
            Surveillance ID: 5, Location: Marketplace, Date/Time: 2024-04-18T12:00, Duration: 60, Citizen ID: 5, Observation Type: Public Movement
            Surveillance ID: 6, Location: Online, Date/Time: 2024-04-19T23:30, Duration: 80, Citizen ID: 6, Observation Type: Online Activity
            
            Censored Materials:
            Material ID: 1, Type: Book, Title: 1984, Author: George Orwell, Date of Censorship: 2024-04-01, Reason: Subversive Content
            Material ID: 2, Type: Article, Title: Freedom in Modern Society, Author: Alex Reid, Date of Censorship: 2024-04-05, Reason: Politically Sensitive
            Material ID: 3, Type: Video, Title: History of Democracies, Author: Chris Turner, Date of Censorship: 2024-04-06, Reason: Inappropriate Content
            Material ID: 4, Type: Book, Title: New World Order, Author: Samantha Green, Date of Censorship: 2024-04-07, Reason: Subversive Content
            Material ID: 5, Type: Podcast, Title: Voices of Tomorrow, Author: Emily Nguyen, Date of Censorship: 2024-04-12, Reason: Unauthorized Political Content
            Material ID: 6, Type: Article, Title: Economic Freedoms and Growth, Author: Michael Roberts, Date of Censorship: 2024-04-13, Reason: Economic Misinformation
            Material ID: 7, Type: Video, Title: The Rise of Technology in Society, Author: Sarah Johnson, Date of Censorship: 2024-04-14, Reason: Innappropiate Content
            Material ID: 8, Type: Book, Title: The Great Leaders, Author: John Abrams, Date of Censorship: 2024-04-15, Reason: Politically Sensitive
            Material ID: 9, Type: Social Media Post, Title: March for Rights, Author: Various, Date of Censorship: 2024-04-16, Reason: Subversive Content
            
            Detention Records:
            Detention ID: 1, Citizen ID: 1, Date of Detention: 2024-04-02, Location: Capital Detention Center, Duration: 10, Charges: Subversion
            Detention ID: 2, Citizen ID: 3, Date of Detention: 2024-04-08, Location: Northern Detention Facility, Duration: 15, Charges: Protest Participation
            Detention ID: 3, Citizen ID: 4, Date of Detention: 2024-04-09, Location: Southern Detention Center, Duration: 30, Charges: Illegal Activities
            Detention ID: 4, Citizen ID: 5, Date of Detention: 2024-04-10, Location: Eastern Detention Center, Duration: 20, Charges: Subversion
            Detention ID: 5, Citizen ID: 1, Date of Detention: 2024-04-11, Location: Western Detention Facility, Duration: 25, Charges: Public Disturbance
            Detention ID: 6, Citizen ID: 2, Date of Detention: 2024-04-17, Location: Central Detention Facility, Duration: 5, Charges: Minor Public Misdemeanor
            Detention ID: 7, Citizen ID: 2, Date of Detention: 2024-04-18, Location: Capital Detention Center, Duration: 40, Charges: Major Public Unrest
            Detention ID: 8, Citizen ID: 1, Date of Detention: 2024-04-19, Location: Eastern Detention Center, Duration: 10, Charges: Unauthorized Public Assembly
            Detention ID: 9, Citizen ID: 3, Date of Detention: 2024-04-20, Location: Western Detention Facility, Duration: 60, Charges: Espionage
            Detention ID: 10, Citizen ID: 4, Date of Detention: 2024-04-21, Location: Remote Detention Camp, Duration: 90, Charges: Conspiracy Against the State
            
            Average Detention Duration by Location 'Capital Detention Center':
            {AverageDuration=25.00, LocationOfDetention=Capital Detention Center}
            
            Count of Censored Materials by Reason 'Subversive Content':
            {TotalCount=3, ReasonForCensorship=Subversive Content}
            
            Detention by charges with 'Subvers':
            {DetentionID=1, CitizenID=1, DateOfDetention=2024-04-02, Duration=10, Charges=Subversion, LocationOfDetention=Capital Detention Center}
            {DetentionID=4, CitizenID=5, DateOfDetention=2024-04-10, Duration=20, Charges=Subversion, LocationOfDetention=Eastern Detention Center}
            
            Detention by charges with 'Public':
            {DetentionID=5, CitizenID=1, DateOfDetention=2024-04-11, Duration=25, Charges=Public Disturbance, LocationOfDetention=Western Detention Facility}
            {DetentionID=6, CitizenID=2, DateOfDetention=2024-04-17, Duration=5, Charges=Minor Public Misdemeanor, LocationOfDetention=Central Detention Facility}
            {DetentionID=7, CitizenID=2, DateOfDetention=2024-04-18, Duration=40, Charges=Major Public Unrest, LocationOfDetention=Capital Detention Center}
            {DetentionID=8, CitizenID=1, DateOfDetention=2024-04-19, Duration=10, Charges=Unauthorized Public Assembly, LocationOfDetention=Eastern Detention Center}
            
            Detentions from date '2024-04-11':
            Citizen Name: John Doe, Detention ID: 5, Date of Detention: 2024-04-11, Location of Detention: Western Detention Facility, Duration: 25, Charges: Public Disturbance
            Citizen Name: Jane Smith, Detention ID: 6, Date of Detention: 2024-04-17, Location of Detention: Central Detention Facility, Duration: 5, Charges: Minor Public Misdemeanor
            Citizen Name: Jane Smith, Detention ID: 7, Date of Detention: 2024-04-18, Location of Detention: Capital Detention Center, Duration: 40, Charges: Major Public Unrest
            Citizen Name: John Doe, Detention ID: 8, Date of Detention: 2024-04-19, Location of Detention: Eastern Detention Center, Duration: 10, Charges: Unauthorized Public Assembly
            Citizen Name: Alice Johnson, Detention ID: 9, Date of Detention: 2024-04-20, Location of Detention: Western Detention Facility, Duration: 60, Charges: Espionage
            Citizen Name: Bob Lee, Detention ID: 10, Date of Detention: 2024-04-21, Location of Detention: Remote Detention Camp, Duration: 90, Charges: Conspiracy Against the State
            
            List Surveillance: '2024-04-12', '2024-04-14':
            No surveillance entries found between 2024-04-12 and 2024-04-14.
            
            List Surveillance: '2024-04-14', '2024-04-16':
            Surveillance ID: 1, Location: Downtown Square, Date/Time: 2024-04-14T14:00, Duration: 30, Citizen ID: 1, Observation Type: Public Movement
            Surveillance ID: 2, Location: Online, Date/Time: 2024-04-15T20:00, Duration: 120, Citizen ID: 2, Observation Type: Online Activity
            
            List Surveillance: '2024-04-19', '2024-04-20':
            Surveillance ID: 6, Location: Online, Date/Time: 2024-04-19T23:30, Duration: 80, Citizen ID: 6, Observation Type: Online Activity
            """.replace("\r\n", "\n").replace("            ","");
        String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
        assertTrue(diff.compareTo("identical") == 0, 
            "\n>>>>>>>>>> >>>>>>>>>>\n" +
            diff +
            "<<<<<<<<<< <<<<<<<<<<\n");
    }

    @Test
    public void testMainTables() throws SQLException {
        // Adjust this URL with your MySQL connection details
        String url = "jdbc:mysql://localhost:3308/school?user=root&password=pwd";
        try (Connection conn = DriverManager.getConnection(url)) {
            DatabaseMetaData dbMetaData = conn.getMetaData();

            // Check the existence and columns of each table
            checkTableExistsAndColumns(dbMetaData, "Citizens", new String[]{"CitizenID", "FullName", "Address", "DateOfBirth", "NationalID", "EmploymentStatus", "PoliticalAffiliation"});
            checkTableExistsAndColumns(dbMetaData, "Surveillance", new String[]{"SurveillanceID", "Location", "DateTime", "Duration", "CitizenID", "TypeOfObservation"});
            checkTableExistsAndColumns(dbMetaData, "CensoredMaterials", new String[]{"MaterialID", "Type", "Title", "Author", "DateOfCensorship", "ReasonForCensorship"});
            checkTableExistsAndColumns(dbMetaData, "Detentions", new String[]{"DetentionID", "CitizenID", "DateOfDetention", "LocationOfDetention", "Duration", "Charges"});

            checkForeignKey(dbMetaData, "Surveillance", "Citizens", "CitizenID");
            checkForeignKey(dbMetaData, "Detentions", "Citizens", "CitizenID");
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
        assertMethod(clazz, "createTables", true, false, "Error with the definition of the createTables function.");
    
        assertMethod(clazz, "addCitizen", true, false, "Error with the definition of the addCitizen function.", String.class, String.class, String.class, String.class, String.class, String.class);
        assertMethod(clazz, "addSurveillance", true, false, "Error with the definition of the addSurveillance function.", String.class, String.class, int.class, int.class, String.class);
        assertMethod(clazz, "addCensoredMaterial", true, false, "Error with the definition of the addCensoredMaterial function.", String.class, String.class, String.class, String.class, String.class);
        assertMethod(clazz, "addDetention", true, false, "Error with the definition of the addDetention function.", int.class, String.class, String.class, int.class, String.class);
    
        assertMethod(clazz, "listCitizens", true, false, "Error with the definition of the listCitizens function.");
        assertMethod(clazz, "listSurveillance", true, false, "Error with the definition of the listSurveillance function.");
        assertMethod(clazz, "listCensoredMaterials", true, false, "Error with the definition of the listCensoredMaterials function.");
        assertMethod(clazz, "listDetentions", true, false, "Error with the definition of the listDetentions function.");
    
        assertMethod(clazz, "showAverageDetentionDurationByLocation", true, false, "Error with the definition of the showAverageDetentionDurationByLocation function.", String.class);
        assertMethod(clazz, "countCensoredMaterialsByReason", true, false, "Error with the definition of the countCensoredMaterialsByReason function.", String.class);
        assertMethod(clazz, "listDetentionsByCharges", true, false, "Error with the definition of the listDetentionsByCharges function.", String.class);
        assertMethod(clazz, "listDetentionsFromDate", true, false, "Error with the definition of the listDetentionsFromDate function.", String.class);
        assertMethod(clazz, "listSurveillanceEntries", true, false, "Error with the definition of the listSurveillanceEntries function.", String.class, String.class);
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
    public void testMainExtra() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));

        try {
            Locale.setDefault(Locale.US);

            AppData db = AppData.getInstance();

            // Create tables
            Main.createTables();

            Main.addCitizen("A", "B", "1970-01-01", "C", "D", "E");
            Main.addCitizen("B", "C", "1970-02-01", "D", "E", "F");
            Main.addCitizen("C", "D", "1970-03-01", "E", "F", "G");
            Main.addSurveillance("AB", "2024-01-14 11:00", 20, 4, "CC");
            Main.addSurveillance("AC", "2024-01-15 11:01", 40, 5, "DC");
            Main.addSurveillance("AB", "2024-01-16 11:02", 60, 6, "EC");
            Main.addSurveillance("AE", "2024-01-17 11:03", 80, 7, "FC");
            Main.addCensoredMaterial("BC", "ZZ", "CD", "2024-04-14", "DE");
            Main.addCensoredMaterial("BD", "ZX", "CD", "2024-04-15", "EE");
            Main.addCensoredMaterial("BE", "ZY", "CD", "2024-04-16", "FE");
            Main.addCensoredMaterial("BF", "XZ", "CD", "2024-04-17", "DE");
            Main.addCensoredMaterial("BG", "XX", "CD", "2024-04-18", "HE");
            Main.addCensoredMaterial("BH", "XY", "CD", "2024-04-19", "IE");
            Main.addDetention(1, "2024-04-01", "A", 10, "DA");
            Main.addDetention(2, "2024-05-02", "B", 15, "DA");
            Main.addDetention(3, "2024-06-03", "C", 30, "FC");
            Main.addDetention(1, "2024-07-03", "D", 10, "GD");
            Main.addDetention(2, "2024-08-02", "E", 15, "HE");
            Main.addDetention(3, "2024-09-01", "F", 30, "HE");
            Main.listCitizens();
            Main.listSurveillance();
            Main.listCensoredMaterials();
            Main.listDetentions();
            Main.showAverageDetentionDurationByLocation("AB");
            Main.countCensoredMaterialsByReason("DE");
            Main.listDetentionsByCharges("DA");
            Main.listDetentionsByCharges("HE");
            Main.listDetentionsFromDate("2024-06-03");
            Main.listSurveillanceEntries("2024-01-15", "2024-01-17");

            // Close the database connection
            db.close();
        } finally {
            System.setOut(originalOut);
        }

        String text = baos.toString().replace("\r\n", "\n");

        String expectedOutput = """
            Citizen ID: 1, Name: A, Address: B, Birth: 1970-01-01, National ID: C, Employment: D, Political Affiliation: E
            Citizen ID: 2, Name: B, Address: C, Birth: 1970-02-01, National ID: D, Employment: E, Political Affiliation: F
            Citizen ID: 3, Name: C, Address: D, Birth: 1970-03-01, National ID: E, Employment: F, Political Affiliation: G
            Surveillance ID: 1, Location: AB, Date/Time: 2024-01-14T11:00, Duration: 20, Citizen ID: 4, Observation Type: CC
            Surveillance ID: 2, Location: AC, Date/Time: 2024-01-15T11:01, Duration: 40, Citizen ID: 5, Observation Type: DC
            Surveillance ID: 3, Location: AB, Date/Time: 2024-01-16T11:02, Duration: 60, Citizen ID: 6, Observation Type: EC
            Surveillance ID: 4, Location: AE, Date/Time: 2024-01-17T11:03, Duration: 80, Citizen ID: 7, Observation Type: FC
            Material ID: 1, Type: BC, Title: ZZ, Author: CD, Date of Censorship: 2024-04-14, Reason: DE
            Material ID: 2, Type: BD, Title: ZX, Author: CD, Date of Censorship: 2024-04-15, Reason: EE
            Material ID: 3, Type: BE, Title: ZY, Author: CD, Date of Censorship: 2024-04-16, Reason: FE
            Material ID: 4, Type: BF, Title: XZ, Author: CD, Date of Censorship: 2024-04-17, Reason: DE
            Material ID: 5, Type: BG, Title: XX, Author: CD, Date of Censorship: 2024-04-18, Reason: HE
            Material ID: 6, Type: BH, Title: XY, Author: CD, Date of Censorship: 2024-04-19, Reason: IE
            Detention ID: 1, Citizen ID: 1, Date of Detention: 2024-04-01, Location: A, Duration: 10, Charges: DA
            Detention ID: 2, Citizen ID: 2, Date of Detention: 2024-05-02, Location: B, Duration: 15, Charges: DA
            Detention ID: 3, Citizen ID: 3, Date of Detention: 2024-06-03, Location: C, Duration: 30, Charges: FC
            Detention ID: 4, Citizen ID: 1, Date of Detention: 2024-07-03, Location: D, Duration: 10, Charges: GD
            Detention ID: 5, Citizen ID: 2, Date of Detention: 2024-08-02, Location: E, Duration: 15, Charges: HE
            Detention ID: 6, Citizen ID: 3, Date of Detention: 2024-09-01, Location: F, Duration: 30, Charges: HE
            No records found.
            {TotalCount=2, ReasonForCensorship=DE}
            {DetentionID=1, CitizenID=1, DateOfDetention=2024-04-01, Duration=10, Charges=DA, LocationOfDetention=A}
            {DetentionID=2, CitizenID=2, DateOfDetention=2024-05-02, Duration=15, Charges=DA, LocationOfDetention=B}
            {DetentionID=5, CitizenID=2, DateOfDetention=2024-08-02, Duration=15, Charges=HE, LocationOfDetention=E}
            {DetentionID=6, CitizenID=3, DateOfDetention=2024-09-01, Duration=30, Charges=HE, LocationOfDetention=F}
            Citizen Name: C, Detention ID: 3, Date of Detention: 2024-06-03, Location of Detention: C, Duration: 30, Charges: FC
            Citizen Name: A, Detention ID: 4, Date of Detention: 2024-07-03, Location of Detention: D, Duration: 10, Charges: GD
            Citizen Name: B, Detention ID: 5, Date of Detention: 2024-08-02, Location of Detention: E, Duration: 15, Charges: HE
            Citizen Name: C, Detention ID: 6, Date of Detention: 2024-09-01, Location of Detention: F, Duration: 30, Charges: HE
            Surveillance ID: 2, Location: AC, Date/Time: 2024-01-15T11:01, Duration: 40, Citizen ID: 5, Observation Type: DC
            Surveillance ID: 3, Location: AB, Date/Time: 2024-01-16T11:02, Duration: 60, Citizen ID: 6, Observation Type: EC
            """.replace("\r\n", "\n").replace("            ","");

        String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
        assertTrue(diff.compareTo("identical") == 0, 
            ">>>>>>>>>> >>>>>>>>>>\n" +
            diff +
            "<<<<<<<<<< <<<<<<<<<<\n");
    }
}
