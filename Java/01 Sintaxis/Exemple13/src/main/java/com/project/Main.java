package com.project;

import java.io.*;

import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Main {
   public static void main(String[] args) {

        // Els arxius de la carpate './data' són arxius normals del sistema que no s'empaqueten
        String arxiu = "./data/cursos.json"; 
   
        try {
            String content = new String(Files.readAllBytes(Paths.get(arxiu)));

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
