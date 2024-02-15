package com.project;

import java.io.*;

import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Main {
   public static void main(String[] args) {

        // Els arxius de la carpeta './src/main/resources/assets' s'empaqueten amb el projecte
        // String arxiu = "/assets/cursos.json"; 

        // Els arxius de la carpate './data' són arxius normals del sistema que no s'empaqueten
        String arxiu = "./data/cursos.json"; 
   
        try {

            // Preparar l'stream de lectura
            InputStream is;
            if (arxiu.startsWith("/assets")) {
                is = Main.class.getResourceAsStream(arxiu);
                if (is == null) {
                    throw new FileNotFoundException("El fitxer no s'ha trobat dins del JAR: " + arxiu);
                }
            } else {
                File file = new File(arxiu);
                if (!file.exists()) {
                    throw new FileNotFoundException("El fitxer no s'ha trobat en el sistema de fitxers: " + file.getAbsolutePath());
                }
                is = new FileInputStream(file);
            }
            Reader reader = new InputStreamReader(is);

            // Llegir el contingut del fitxer com a String
            StringBuilder contentBuilder = new StringBuilder();
            try (BufferedReader bufferedReader = new BufferedReader(reader)) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    contentBuilder.append(line).append("\n"); // Afegeix un salt de línia per mantenir el format
                }
            } catch (IOException e) {
                e.printStackTrace();
                // Maneja l'error com consideris necessari
            }
            String content = contentBuilder.toString();

            // Crear un JSONArray a partir del contingut del fitxer
            JSONArray cursos = new JSONArray(content);

            // Iterar sobre els elements de l'JSONArray
            for (int i = 0; i < cursos.length(); i++) {
                JSONObject curs = cursos.getJSONObject(i);
                System.out.println("ID: " + curs.getInt("id") + ", Nom: " + curs.getString("nom"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
