package com.project;

import java.io.*;
import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
   public static void main(String[] args) {

        // Els arxius de la carpeta './src/main/resources/assets' s'empaqueten amb el projecte
        // String arxiu = "/assets/cursos.json"; 

        // Els arxius de la carpeta './data' són arxius normals del sistema que no s'empaqueten
        String arxiuOriginal = "./data/cursos.json"; 
        String arxiuModificat = "./data/cursos-modificat.json"; // Ruta per al nou fitxer JSON modificat
   
        try {
            // Llegir el contingut del fitxer original
            String content = new String(Files.readAllBytes(Paths.get(arxiuOriginal)));
            JSONArray cursos = new JSONArray(content);

            // Modificar cada objecte dins del JSONArray
            for (int i = 0; i < cursos.length(); i++) {
                JSONObject curs = cursos.getJSONObject(i);
                int idOriginal = curs.getInt("id");
                curs.put("id", idOriginal + 1000); // Sumar 1000 a l'id actual
            }

            // Guardar el JSONArray modificat en un nou fitxer
            try (FileWriter file = new FileWriter(arxiuModificat)) {
                file.write(cursos.toString(4)); // Escriure el JSON amb indentació per millorar la llegibilitat
                System.out.println("Arxiu JSON modificat guardat a: " + arxiuModificat);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}