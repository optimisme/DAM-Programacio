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
}
