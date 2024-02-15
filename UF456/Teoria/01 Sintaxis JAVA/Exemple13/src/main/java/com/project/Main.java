package com.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.function.Consumer;
import java.util.concurrent.CompletableFuture;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main {

    public static JSONArray dadesCursos = null;

    public static void main(String[] args) {

        // String arxiu = "/assets/cursos.json"; // Els arxius de la carpeta './src/main/resources/assets' s'empaqueten amb el projecte

        String arxiu = "./data/cursos.json"; // Els arxius de la carpate './data' són arxius normals del sistema que no s'empaqueten

        CompletableFuture<Void> future = loadData(arxiu, (receivedData) -> {
            if (receivedData == null) {
                System.out.println("Error al carregar les dades");
                return;
            } else {
                dadesCursos = new JSONArray(receivedData);
                // Processar i mostrar les dades aquí si és necessari
            }
        });
    
        // Espera que les dades estiguin carregades
        future.join(); // (Bloqueja el procés)
    
        // Ara podem accedir a dadesCursos de manera segura
        if (dadesCursos != null) {
            for (int i = 0; i < dadesCursos.length(); i++) {
                JSONObject curs = dadesCursos.getJSONObject(i);
                System.out.println("ID: " + curs.getInt("id") + ", Nom: " + curs.getString("nom"));
            }
        }
    }
    
    public static CompletableFuture<Void> loadData(String dataFile, Consumer<String> callBack) {
        return CompletableFuture.supplyAsync(() -> {
            StringBuilder content = new StringBuilder();
            try {
                InputStream is;
                if (dataFile.startsWith("/assets")) {
                    // Càrrega d'un recurs empaquetat dins del JAR
                    is = Main.class.getResourceAsStream(dataFile);
                    if (is == null) {
                        throw new FileNotFoundException("El fitxer no s'ha trobat dins del JAR: " + dataFile);
                    }
                } else {
                    // Càrrega d'un fitxer del sistema de fitxers
                    File file = new File(dataFile);
                    if (!file.exists()) {
                        throw new FileNotFoundException("El fitxer no s'ha trobat en el sistema de fitxers: " + file.getAbsolutePath());
                    }
                    is = new FileInputStream(file);
                }
                Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8);
                char[] buffer = new char[1024];
                int bytesRead;
                while ((bytesRead = reader.read(buffer)) != -1) {
                    content.append(buffer, 0, bytesRead);
                }
                return content.toString();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }).thenApply(content -> {
            callBack.accept(content);
            return null;
        });
    }
}
