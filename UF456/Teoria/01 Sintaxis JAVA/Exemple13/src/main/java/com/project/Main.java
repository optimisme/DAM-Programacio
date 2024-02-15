package com.project;

import java.util.function.Consumer;
import java.util.concurrent.CompletableFuture;
import java.io.InputStream;
import java.io.Reader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main {

    public static JSONArray dadesCursos = null;

    public static void main(String[] args) {
        CompletableFuture<Void> future = loadData("/assets/cursos.json", (receivedData) -> {
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
            try {
                InputStream is = Main.class.getResourceAsStream(dataFile);
                if (is == null) {
                    throw new IllegalArgumentException("El fitxer no s'ha trobat");
                }
                Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8);
                StringBuilder content = new StringBuilder();
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
            return null; // Perquè compleixi amb el tipus de retorn CompletableFuture<Void>
        });
    }
}
