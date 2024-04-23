package com.project;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        AppData db = AppData.getInstance();

        // Create tables
        createTables();

        // Add citizens
        addCitizen("John Doe", "123 Main St, Capital City", "1980-01-01", "A12345678", "Employed", "Party A");
        addCitizen("Jane Smith", "456 Elm St, Capital City", "1985-02-02", "B87654321", "Unemployed", "Party B");
        addCitizen("Alice Johnson", "789 Pine St, Northern Town", "1975-03-15", "C23456789", "Self-employed", "Party C");
        addCitizen("Bob Lee", "321 Oak St, Southern City", "1992-11-08", "D34567890", "Student", "Party A");
        addCitizen("Charlie Brown", "654 Maple St, Eastern City", "1988-06-21", "E45678901", "Unemployed", "Party B");
        addCitizen("Emma Wilson", "987 Cedar St, Western Town", "1990-09-10", "F56789012", "Freelancer", "Party C");

        // Add surveillance logs
        addSurveillance("Downtown Square", "2024-04-14 14:00", 30, 1, "Public Movement");
        addSurveillance("Online", "2024-04-15 20:00", 120, 2, "Online Activity");
        addSurveillance("Central Park", "2024-04-16 09:30", 45, 3, "Public Movement");
        addSurveillance("Online", "2024-04-17 22:00", 90, 4, "Online Activity");
        addSurveillance("Marketplace", "2024-04-18 12:00", 60, 5, "Public Movement");
        addSurveillance("Online", "2024-04-19 23:30", 80, 6, "Online Activity");

        // Add censorship entries
        addCensoredMaterial("Book", "1984", "George Orwell", "2024-04-01", "Subversive Content");
        addCensoredMaterial("Article", "Freedom in Modern Society", "Alex Reid", "2024-04-05", "Politically Sensitive");
        addCensoredMaterial("Video", "History of Democracies", "Chris Turner", "2024-04-06", "Inappropriate Content");
        addCensoredMaterial("Book", "New World Order", "Samantha Green", "2024-04-07", "Subversive Content");
        addCensoredMaterial("Podcast", "Voices of Tomorrow", "Emily Nguyen", "2024-04-12", "Unauthorized Political Content");
        addCensoredMaterial("Article", "Economic Freedoms and Growth", "Michael Roberts", "2024-04-13", "Economic Misinformation");
        addCensoredMaterial("Video", "The Rise of Technology in Society", "Sarah Johnson", "2024-04-14", "Innappropiate Content");
        addCensoredMaterial("Book", "The Great Leaders", "John Abrams", "2024-04-15", "Politically Sensitive");
        addCensoredMaterial("Social Media Post", "March for Rights", "Various", "2024-04-16", "Subversive Content");

        // Add detention records
        addDetention(1, "2024-04-02", "Capital Detention Center", 10, "Subversion");
        addDetention(3, "2024-04-08", "Northern Detention Facility", 15, "Protest Participation");
        addDetention(4, "2024-04-09", "Southern Detention Center", 30, "Illegal Activities");
        addDetention(5, "2024-04-10", "Eastern Detention Center", 20, "Subversion");
        addDetention(1, "2024-04-11", "Western Detention Facility", 25, "Public Disturbance");
        addDetention(2, "2024-04-17", "Central Detention Facility", 5, "Minor Public Misdemeanor");
        addDetention(2, "2024-04-18", "Capital Detention Center", 40, "Major Public Unrest");
        addDetention(1, "2024-04-19", "Eastern Detention Center", 10, "Unauthorized Public Assembly");
        addDetention(3, "2024-04-20", "Western Detention Facility", 60, "Espionage");
        addDetention(4, "2024-04-21", "Remote Detention Camp", 90, "Conspiracy Against the State");

        // List entries
        System.out.println("\nCitizens:");
        listCitizens();

        System.out.println("\nSurveillance Logs:");
        listSurveillance();

        System.out.println("\nCensored Materials:");
        listCensoredMaterials();

        System.out.println("\nDetention Records:");
        listDetentions();

        System.out.println("\nAverage Detention Duration by Location 'Capital Detention Center':");
        showAverageDetentionDurationByLocation("Capital Detention Center");

        System.out.println("\nCount of Censored Materials by Reason 'Subversive Content':");
        countCensoredMaterialsByReason("Subversive Content");

        System.out.println("\nDetention by charges with 'Subvers':");
        listDetentionsByCharges("Subvers");

        System.out.println("\nDetention by charges with 'Public':");
        listDetentionsByCharges("Public");

        System.out.println("\nDetentions from date '2024-04-11':");
        listDetentionsFromDate("2024-04-11");

        System.out.println("\nList Surveillance: '2024-04-12', '2024-04-14':");
        listSurveillanceEntries("2024-04-12", "2024-04-14");

        System.out.println("\nList Surveillance: '2024-04-14', '2024-04-16':");
        listSurveillanceEntries("2024-04-14", "2024-04-16");

        System.out.println("\nList Surveillance: '2024-04-19', '2024-04-20':");
        listSurveillanceEntries("2024-04-19", "2024-04-20");

        // Close the database connection
        db.close();

        // Forçar la sortida del programa per no esperar a tancar la connexió amb 'MySQL'
        // Assegura't que en aquest punt totes les dades s'han guardat correctament
        if (!"test".equals(System.getProperty("environment"))) {
            System.exit(0);
        }
    }

    public static void createTables() {
        AppData db = AppData.getInstance();
        db.update("SET FOREIGN_KEY_CHECKS=0;");

        String sql = "CREATE TABLE IF NOT EXISTS Citizens (" +
                     "CitizenID INTEGER PRIMARY KEY AUTO_INCREMENT, " +
                     "FullName TEXT NOT NULL, " +
                     "Address TEXT NOT NULL, " +
                     "DateOfBirth DATE NOT NULL, " +
                     "NationalID TEXT NOT NULL, " +
                     "EmploymentStatus TEXT NOT NULL, " +
                     "PoliticalAffiliation TEXT NOT NULL)";
        db.update("DROP TABLE IF EXISTS Citizens");
        db.update(sql);

        sql = "CREATE TABLE IF NOT EXISTS Surveillance (" +
              "SurveillanceID INTEGER PRIMARY KEY AUTO_INCREMENT, " +
              "Location TEXT NOT NULL, " +
              "DateTime DATETIME NOT NULL, " +
              "Duration INTEGER NOT NULL, " +
              "CitizenID INTEGER NOT NULL, " +
              "TypeOfObservation TEXT NOT NULL, " +
              "FOREIGN KEY(CitizenID) REFERENCES Citizens(CitizenID))";
        db.update("DROP TABLE IF EXISTS Surveillance");
        db.update(sql);

        sql = "CREATE TABLE IF NOT EXISTS CensoredMaterials (" +
              "MaterialID INTEGER PRIMARY KEY AUTO_INCREMENT, " +
              "Type TEXT NOT NULL, " +
              "Title TEXT NOT NULL, " +
              "Author TEXT NOT NULL, " +
              "DateOfCensorship DATE NOT NULL, " +
              "ReasonForCensorship TEXT NOT NULL)";
        db.update("DROP TABLE IF EXISTS CensoredMaterials");
        db.update(sql);

        sql = "CREATE TABLE IF NOT EXISTS Detentions (" +
              "DetentionID INTEGER PRIMARY KEY AUTO_INCREMENT, " +
              "CitizenID INTEGER NOT NULL, " +
              "DateOfDetention DATE NOT NULL, " +
              "LocationOfDetention TEXT NOT NULL, " +
              "Duration INTEGER NOT NULL, " +
              "Charges TEXT NOT NULL, " +
              "FOREIGN KEY(CitizenID) REFERENCES Citizens(CitizenID))";
        db.update("DROP TABLE IF EXISTS Detentions");
        db.update(sql);
    }

    public static void addCitizen(String name, String address, String birth, String nationalId, String employment, String political) {
        String sql = "INSERT INTO Citizens (FullName, Address, DateOfBirth, NationalID, EmploymentStatus, PoliticalAffiliation) VALUES ('" + 
                     name + "', '" + address + "', '" + birth + "', '" + nationalId + "', '" + employment + "', '" + political + "')";
        AppData.getInstance().update(sql);
    }

    public static void addSurveillance(String location, String dateTime, int duration, int citizenId, String type) {
        String sql = "INSERT INTO Surveillance (Location, DateTime, Duration, CitizenID, TypeOfObservation) VALUES ('" + 
                     location + "', '" + dateTime + "', " + duration + ", " + citizenId + ", '" + type + "')";
        AppData.getInstance().update(sql);
    }

    public static void addCensoredMaterial(String type, String title, String author, String date, String reason) {
        String sql = "INSERT INTO CensoredMaterials (Type, Title, Author, DateOfCensorship, ReasonForCensorship) VALUES ('" + 
                     type + "', '" + title + "', '" + author + "', '" + date + "', '" + reason + "')";
        AppData.getInstance().update(sql);
    }

    public static void addDetention(int citizenId, String date, String location, int duration, String charges) {
        String sql = "INSERT INTO Detentions (CitizenID, DateOfDetention, LocationOfDetention, Duration, Charges) VALUES (" + 
                     citizenId + ", '" + date + "', '" + location + "', " + duration + ", '" + charges + "')";
        AppData.getInstance().update(sql);
    }

    public static void listCitizens() {
        String sql = "SELECT * FROM Citizens";
        List<Map<String, Object>> citizens = AppData.getInstance().query(sql);
        for (Map<String, Object> citizen : citizens) {
            System.out.println("Citizen ID: " + citizen.get("CitizenID") + ", Name: " + citizen.get("FullName") +
                               ", Address: " + citizen.get("Address") + ", Birth: " + citizen.get("DateOfBirth") +
                               ", National ID: " + citizen.get("NationalID") + ", Employment: " + citizen.get("EmploymentStatus") +
                               ", Political Affiliation: " + citizen.get("PoliticalAffiliation"));
        }
    }

    public static void listSurveillance() {
        String sql = "SELECT * FROM Surveillance";
        List<Map<String, Object>> logs = AppData.getInstance().query(sql);
        for (Map<String, Object> log : logs) {
            System.out.println("Surveillance ID: " + log.get("SurveillanceID") + ", Location: " + log.get("Location") +
                               ", Date/Time: " + log.get("DateTime") + ", Duration: " + log.get("Duration") +
                               ", Citizen ID: " + log.get("CitizenID") + ", Observation Type: " + log.get("TypeOfObservation"));
        }
    }

    public static void listCensoredMaterials() {
        String sql = "SELECT * FROM CensoredMaterials";
        List<Map<String, Object>> materials = AppData.getInstance().query(sql);
        for (Map<String, Object> material : materials) {
            System.out.println("Material ID: " + material.get("MaterialID") + ", Type: " + material.get("Type") +
                               ", Title: " + material.get("Title") + ", Author: " + material.get("Author") +
                               ", Date of Censorship: " + material.get("DateOfCensorship") + ", Reason: " + material.get("ReasonForCensorship"));
        }
    }

    public static void listDetentions() {
        String sql = "SELECT * FROM Detentions";
        List<Map<String, Object>> detentions = AppData.getInstance().query(sql);
        for (Map<String, Object> detention : detentions) {
            System.out.println("Detention ID: " + detention.get("DetentionID") + ", Citizen ID: " + detention.get("CitizenID") +
                               ", Date of Detention: " + detention.get("DateOfDetention") + ", Location: " + detention.get("LocationOfDetention") +
                               ", Duration: " + detention.get("Duration") + ", Charges: " + detention.get("Charges"));
        }
    }
   
    public static void showAverageDetentionDurationByLocation(String location) {
        location = location.replace("'", "''");
    
        String sql = "SELECT LocationOfDetention, AVG(Duration) AS AverageDuration " +
                     "FROM Detentions " +
                     "WHERE LocationOfDetention = '" + location + "' " +
                     "GROUP BY LocationOfDetention";
    
        List<Map<String, Object>> result = AppData.getInstance().query(sql);
        if (!result.isEmpty()) {
            Map<String, Object> record = result.get(0);
            double averageDuration = ((BigDecimal) record.get("AverageDuration")).doubleValue();
            String formattedAverage = String.format("%.2f", averageDuration);
            String locationOfDetention = (String) record.get("LocationOfDetention");
    
            System.out.println("{AverageDuration=" + formattedAverage + ", LocationOfDetention=" + locationOfDetention + "}");
        } else {
            System.out.println("No records found.");
        }
    }
       
    public static void countCensoredMaterialsByReason(String reason) {
        // Ensuring the parameter is safely handled
        reason = reason.replace("'", "''");
    
        String sql = "SELECT ReasonForCensorship, COUNT(*) AS TotalCount " +
                     "FROM CensoredMaterials " +
                     "WHERE ReasonForCensorship = '" + reason + "' " +
                     "GROUP BY ReasonForCensorship";

        List<Map<String, Object>>  result = AppData.getInstance().query(sql);
        if (!result.isEmpty()) {
            System.out.println(result.get(0));
        } else {
            System.out.println("No records found.");
        }
    }
    
    public static void listDetentionsByCharges(String charges) {
        String sql = "SELECT * FROM Detentions WHERE Charges LIKE '%" + charges + "%'";
        List<Map<String, Object>> results = AppData.getInstance().query(sql);
        for (Map<String, Object> count : results) {
            System.out.println(count);
        }
    }

    public static void listDetentionsFromDate(String date) {
        String sql = "SELECT Citizens.FullName, Detentions.* FROM Detentions INNER JOIN Citizens ON Detentions.CitizenID = Citizens.CitizenID WHERE DateOfDetention >= '" + date + "'";
        List<Map<String, Object>> detentions = AppData.getInstance().query(sql);
        for (Map<String, Object> detention : detentions) {
            System.out.println("Citizen Name: " + detention.get("FullName") + ", Detention ID: " + detention.get("DetentionID") +
                                   ", Date of Detention: " + detention.get("DateOfDetention") + ", Location of Detention: " + detention.get("LocationOfDetention") +
                                   ", Duration: " + detention.get("Duration") + ", Charges: " + detention.get("Charges"));
        }
    }

    public static void listSurveillanceEntries(String startDate, String endDate) {
        // SQL query to fetch all surveillance entries within the specified date range
        String sql = "SELECT * FROM Surveillance " +
                     "WHERE DateTime >= '" + startDate + "' AND DateTime <= '" + endDate + "'";
    
        // Execute the query and retrieve the list of surveillance entries
        List<Map<String, Object>> surveillanceEntries = AppData.getInstance().query(sql);
    
        // Check if the result is empty
        if (surveillanceEntries.isEmpty()) {
            System.out.println("No surveillance entries found between " + startDate + " and " + endDate + ".");
        } else {
            // Loop through each surveillance entry in the result
            for (Map<String, Object> entry : surveillanceEntries) {
                System.out.println("Surveillance ID: " + entry.get("SurveillanceID") +
                                   ", Location: " + entry.get("Location") +
                                   ", Date/Time: " + entry.get("DateTime") +
                                   ", Duration: " + entry.get("Duration") +
                                   ", Citizen ID: " + entry.get("CitizenID") +
                                   ", Observation Type: " + entry.get("TypeOfObservation"));
            }
        }
    }
}
