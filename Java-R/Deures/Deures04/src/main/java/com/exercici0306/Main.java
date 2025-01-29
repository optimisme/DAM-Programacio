package com.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {

    private static String URL = "jdbc:mysql://localhost:3308/astronomy?useSSL=false&allowPublicKeyRetrieval=true";
    private static String USER = "root";
    private static String PASSWORD = "pwd";

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            conn.setAutoCommit(false);

            createTables(conn);

            addTelescope(conn, "Hubble", "Low Earth Orbit", "Optic", 2.4);
            addTelescope(conn, "James Webb", "Lagrange Point L2", "Infrared", 6.5);
            addTelescope(conn, "Very Large Telescope", "Atacama Desert", "Optic", 8.2);
            addTelescope(conn, "Keck", "Mauna Kea, Hawaii", "Optic", 10.0);
            addTelescope(conn, "ALMA", "Atacama Desert", "Radio", 12.0);
            addTelescope(conn, "Chandra", "High Earth Orbit", "X-Ray", 1.2);

            addCelestialBody(conn, "Earth", "Planet", 5.97e24, 1); 
            addCelestialBody(conn, "Jupiter", "Planet", 1.898e27, 5.2);
            addCelestialBody(conn, "Sirius", "Star", 2.063e30, 8.6); 
            addCelestialBody(conn, "Andromeda", "Galaxy", 4.230e42, 2.537e6);
            addCelestialBody(conn, "Halley", "Comet", 2.2e14, 35);
            addCelestialBody(conn, "Enceladus", "Moon", 1.08e20, 1.27);
            addCelestialBody(conn, "Neptune", "Planet", 1.024e26, 30.1); 
            addCelestialBody(conn, "Proxima Centauri", "Star", 1.23e29, 4.24); 
            addCelestialBody(conn, "Orion Nebula", "Nebula", 0, 1345); 
            addCelestialBody(conn, "Europa", "Moon", 4.8e22, 5.2); 
            addCelestialBody(conn, "Barnard's Star", "Star", 1.5e29, 5.96); 
            addCelestialBody(conn, "Sedna", "Trans-Neptunian Object", 1e21, 936); 
            addCelestialBody(conn, "Betelgeuse", "Star", 2.5e31, 642.5);
            addCelestialBody(conn, "Eris", "Dwarf Planet", 1.66e22, 96.4);
            addCelestialBody(conn, "Vega", "Star", 4.10e30, 25);
            addCelestialBody(conn, "Ceres", "Dwarf Planet", 9.4e20, 2.77); 

            addObservation(conn, 1, 1, Timestamp.valueOf("2024-04-12 23:45:00"), "Detailed observation of Earth");
            addObservation(conn, 2, 2, Timestamp.valueOf("2024-03-15 20:30:00"), "Night observation of Jupiter with great detail");
            addObservation(conn, 3, 3, Timestamp.valueOf("2024-06-01 22:00:00"), "Visualization of the Andromeda galaxy");
            addObservation(conn, 4, 5, Timestamp.valueOf("2024-07-04 01:45:00"), "Study of Halley's comet in its approach");
            addObservation(conn, 1, 4, Timestamp.valueOf("2024-09-10 23:15:00"), "Monitoring of the moon Enceladus and geothermal activity");
            addObservation(conn, 5, 6, Timestamp.valueOf("2024-10-20 19:45:00"), "Spectral measurement of the galactic center");
            addObservation(conn, 1, 1, Timestamp.valueOf("2024-04-12 23:45:00"), "Detailed observation of the Earth");
            addObservation(conn, 2, 2, Timestamp.valueOf("2024-03-15 20:30:00"), "Detailed night observation of Jupiter");
            addObservation(conn, 3, 3, Timestamp.valueOf("2024-06-01 22:00:00"), "Visualization of the Andromeda galaxy");
            addObservation(conn, 4, 5, Timestamp.valueOf("2024-07-04 01:45:00"), "Study of Halley's comet during its approach");
            addObservation(conn, 1, 4, Timestamp.valueOf("2024-09-10 23:15:00"), "Tracking of the moon Enceladus and geothermal activity");
            addObservation(conn, 5, 6, Timestamp.valueOf("2024-10-20 19:45:00"), "Measurement of X-ray spectrum from the galactic center");
            addObservation(conn, 2, 1, Timestamp.valueOf("2024-04-25 04:15:00"), "Study of Saturn's rings using advanced filtering");
            addObservation(conn, 3, 6, Timestamp.valueOf("2024-05-18 03:30:00"), "Detection of supernovae in the Andromeda galaxy");
            addObservation(conn, 4, 7, Timestamp.valueOf("2024-07-22 21:00:00"), "Monitoring of Betelgeuse's stellar variability");
            addObservation(conn, 1, 8, Timestamp.valueOf("2024-08-13 23:00:00"), "Capture of high-resolution images of Mars' surface");
            addObservation(conn, 5, 9, Timestamp.valueOf("2024-11-05 20:45:00"), "Study of the asteroid belt and identification of possible threats");
            addObservation(conn, 2, 10, Timestamp.valueOf("2024-12-05 02:30:00"), "Observation of Neptune and its rings in high definition");
            addObservation(conn, 3, 11, Timestamp.valueOf("2024-12-15 22:00:00"), "Spectroscopic analysis of Proxima Centauri to detect exoplanets");
            addObservation(conn, 4, 12, Timestamp.valueOf("2024-12-28 21:15:00"), "Study of star formation within the Orion Nebula");
            addObservation(conn, 1, 13, Timestamp.valueOf("2025-01-10 19:45:00"), "Reconnaissance missions of Europa's icy surface");
            addObservation(conn, 5, 14, Timestamp.valueOf("2025-01-22 23:30:00"), "Monitoring of Barnard's Star radial velocity");
            addObservation(conn, 2, 15, Timestamp.valueOf("2025-02-05 20:20:00"), "Tracking of the trajectory of the trans-Neptunian object Sedna");
            addObservation(conn, 3, 16, Timestamp.valueOf("2025-02-15 01:40:00"), "Measurement of Betelgeuse's luminous magnitude");
            addObservation(conn, 4, 17, Timestamp.valueOf("2025-03-01 22:15:00"), "Detailed study of the surface features of Eris");
            addObservation(conn, 1, 10, Timestamp.valueOf("2025-03-15 03:50:00"), "Observation of Neptune's smaller moons");
            addObservation(conn, 5, 11, Timestamp.valueOf("2025-03-25 23:45:00"), "Investigation of the variability of Proxima Centauri's radio wave emission");
            addObservation(conn, 2, 18, Timestamp.valueOf("2025-04-10 21:30:00"), "Measurement of Vega's brightness changes");
            addObservation(conn, 3, 18, Timestamp.valueOf("2025-05-20 20:15:00"), "Analysis of Vega's spectroscopic properties");
            addObservation(conn, 4, 19, Timestamp.valueOf("2025-06-15 23:00:00"), "Images of Ceres during its closest approach to Earth");
            addObservation(conn, 1, 19, Timestamp.valueOf("2025-07-05 22:45:00"), "Study of Ceres' surface composition using spectroscopy");
            addObservation(conn, 5, 19, Timestamp.valueOf("2025-08-10 00:30:00"), "Observation of geological activity on Ceres");

            updateCelestialBodyMass(conn, 4, 1.230e42);

            conn.commit(); // Confirm all operations at the end

            listTelescopes(conn);

            listCelestialBodies(conn);

            listObservations(conn);

            System.out.println("Observation Frequency:");
            analyzeObservationFrequency(conn);

            String criteria = "dateTime BETWEEN '2024-01-01' AND '2024-04-15'";
            System.out.println("Observations meeting the criteria: (" + criteria + ")");
            filterObservationsByCriteria(conn, criteria);

            int desiredTelescopeId = 3;
            criteria = "telescopeId = " + desiredTelescopeId;
            System.out.println("Observations meeting the criteria: (" + criteria + ")");
            filterObservationsByCriteria(conn, criteria);

            criteria = "description LIKE '%study%'";           
            System.out.println("Observations meeting the criteria: (" + criteria + ")");
            filterObservationsByCriteria(conn, criteria);

            System.out.println("Total observations for 'Moon': " + getTotalObservationsByBodyType(conn, "Moon"));
            System.out.println("Total observations for 'Planet': " + getTotalObservationsByBodyType(conn, "Planet"));
            
            printHeaviestCelestialBody(conn);

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (!"test".equals(System.getProperty("environment"))) {
            System.exit(0);
        }
    }
}