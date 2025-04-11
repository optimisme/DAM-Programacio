package com.exercici0602;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

// ./run.sh com.exercici0602.BuildJSON

public class BuildJSON {
    
    public static void main(String[] args) {

        AppData db = AppData.getInstance();
        db.connect("./data/pokemons.sqlite");

        initData(db);

        db.close();
    }

    public static void initData(AppData db) {

        ArrayList<HashMap<String, Object>> llista = db.query(String.format("SELECT * FROM pokemons"));
        JSONArray jsonArray = new JSONArray();

        for (HashMap<String,Object> row : llista) {
            JSONObject jsonObject = new JSONObject(row);
            jsonArray.put(jsonObject);
        }

        try (FileWriter file = new FileWriter("./data/pokemons2.json")) {
            file.write(jsonArray.toString(4));
            System.out.println("Datos exportados a pokemons2.json correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo JSON: " + e.getMessage());
        }

        db.close();
    }
}