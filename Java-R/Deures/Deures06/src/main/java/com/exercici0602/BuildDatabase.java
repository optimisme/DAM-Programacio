package com.exercici0602;

import com.utils.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;

// Construeix la base de dades amb
// ./run.sh com.exercici0602.BuildDatabase

public class BuildDatabase {

    public static void main(String[] args) {

        AppData db = AppData.getInstance();
        db.connect("./data/pokemons.sqlite");

        System.out.println("\nIniciar les dades de la base de dades:");
        initData();

        db.close();
    }

    public static void initData() {

        AppData db = AppData.getInstance();

        db.update("DROP TABLE IF EXISTS pokemons");

        db.update("""
            CREATE TABLE IF NOT EXISTS pokemons (
            number INTEGER PRIMARY KEY,
            name TEXT NOT NULL,
            type TEXT,
            ability TEXT,
            height TEXT,
            weight TEXT,
            category TEXT,
            image TEXT)
            """);

        try {
            String content = new String(Files.readAllBytes(Paths.get("data/pokemons.json")));
            JSONArray pokemons = new JSONArray(content);
            for (int i = 0; i < pokemons.length(); i++) {
                JSONObject p = pokemons.getJSONObject(i);
                String updateSQL = String.format(
                    "INSERT INTO pokemons (number, name, type, ability, height, weight, category, image) VALUES (%d, '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                    p.getInt("number"),
                    p.getString("name"),
                    p.optString("type", ""),
                    p.optString("ability", ""),
                    p.optString("height", ""),
                    p.optString("weight", ""),
                    p.optString("category", ""),
                    p.optString("image", "")
                );
                db.update(updateSQL);
                System.out.println("Afegir pokémon: " + p.getString("name"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
