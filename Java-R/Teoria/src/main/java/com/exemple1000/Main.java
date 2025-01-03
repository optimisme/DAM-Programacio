package com.exemple1000;

import org.json.JSONObject;
import org.json.JSONArray;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        try {
            // Establir el local per defecte a Locale.US
            Locale.setDefault(Locale.US);

            // Ruta de l'arxiu JSON
            String filePath = "./data/list.json";
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            // Convertir el contingut a un JSONArray
            JSONArray jsonArray = new JSONArray(content);

            // Afegir la data actual com a "ultima_modificacio"
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
            String formattedDate = now.format(formatter);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject user = jsonArray.getJSONObject(i);
                user.put("ultima_modificacio", formattedDate);
            }

            // Iterar pels usuaris del JSONArray
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject user = jsonArray.getJSONObject(i);

                // Obtenir les dades de l'usuari
                String nom = user.getString("nom");
                int edat = user.getInt("edat");
                JSONArray estudis = user.getJSONArray("estudis");
                boolean treballa = user.getBoolean("treballa");
                JSONObject adreça = user.getJSONObject("adreça");
                String ultimaModificacio = user.getString("ultima_modificacio");

                // Mostrar les dades de l'usuari
                if (i > 0) {
                    System.out.println("----------------------------------------------");
                }
                System.out.println("Usuari " + (i + 1) + ":");
                System.out.println("  Nom: " + nom);
                System.out.println("  Edat: " + edat);
                System.out.println("  Estudis:");
                for (int j = 0; j < estudis.length(); j++) {
                    System.out.println("    " + estudis.getString(j));
                }
                System.out.println("  Treballa: " + treballa);
                System.out.println("  Adreça:");
                System.out.println("    Carrer: " + adreça.getString("carrer"));
                System.out.println("    Ciutat: " + adreça.getString("ciutat"));
                System.out.println("  Última Modificació: " + ultimaModificacio);
                if (i == (jsonArray.length() - 1)) {
                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
