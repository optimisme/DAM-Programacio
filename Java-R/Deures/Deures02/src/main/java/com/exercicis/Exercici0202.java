package com.exercicis;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Scanner;

import org.json.JSONObject;
import org.json.JSONArray;

public class Exercici0202 {

    public static Scanner scanner;
    public static Locale defaultLocale;
    
    // ./run.sh com.exercicis.Exercici0202
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        defaultLocale = Locale.getDefault();
        Locale.setDefault(Locale.US);

        showJSONAstronautes("./data/astronautes.json");

        Locale.setDefault(defaultLocale);
        scanner.close();
    }

    /**
     * Llegeix l'arxiu de 'filePath' i mostra per consola les dades dels astronautes.
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0202#testShowJSONAstronautes
     */
    public static void showJSONAstronautes(String filePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            JSONObject jsonObject = new JSONObject(content);
            JSONArray jsonArray = jsonObject.getJSONArray("astronautes");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject atronauta = jsonArray.getJSONObject(i);

                String nom = atronauta.getString("nom");
                int anyNeix = atronauta.getInt("any_naixement");

                System.out.println("> Astronauta " + i + ":");
                System.out.println("  Nom: " + nom);
                System.out.println("  Naixement: " + anyNeix);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}