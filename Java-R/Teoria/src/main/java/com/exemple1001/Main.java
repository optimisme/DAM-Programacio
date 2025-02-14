package com.exemple1001;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        try {
            // Llista de noms
            List<String> nomsHomes = List.of("Joan", "Pere", "Marc", "Jordi", "Toni");
            List<String> nomsDones = List.of("Maria", "Anna", "Laia", "Sofia", "Clara");
            Random random = new Random();

            // Ruta de l'arxiu JSON
            String filePath = "./data/list.json";
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            // Convertir el contingut a JSONArray
            JSONArray jsonArray = new JSONArray(content);

            // Actualitzar noms i afegir la data de modificació
            LocalDateTime now = LocalDateTime.now();
            String formattedDate = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject user = jsonArray.getJSONObject(i);

                // Canviar el nom aleatòriament
                String nouNom = i % 2 == 0
                        ? nomsHomes.get(random.nextInt(nomsHomes.size()))
                        : nomsDones.get(random.nextInt(nomsDones.size()));
                user.put("nom", nouNom);

                random.nextDouble(25, 100);

                // Actualitzar la data de modificació
                user.put("ultima_modificacio", formattedDate);
            }

            // Escriure les dades actualitzades a l'arxiu original
            Files.write(Paths.get(filePath), jsonArray.toString(4).getBytes());

            System.out.println("Arxiu JSON actualitzat correctament: " + filePath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
