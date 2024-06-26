package com.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CategoriaDAO {

    public static CategoriaModel getItem(int id) {
        String sql = "SELECT id, nom FROM categories WHERE id = " + id;
        AppData db = AppData.getInstance();
        List<Map<String, Object>> results = db.query(sql);
        
        if (!results.isEmpty()) {
            Map<String, Object> row = results.get(0);
            return new CategoriaModel((int)row.get("id"), (String)row.get("nom"));
        }
        return null;
    }

    public static void addItem(CategoriaModel category) {
        String sql = "INSERT INTO categories (nom) VALUES ('" + category.getNom() + "')";
        AppData db = AppData.getInstance();
        db.update(sql);
    }

    public static void updateItem(CategoriaModel category) {
        String sql = "UPDATE categories SET nom = '" + category.getNom() + "' WHERE id = " + category.getId();
        AppData db = AppData.getInstance();
        db.update(sql);
    }

    public static void deleteItem(int id) {
        String sql = "DELETE FROM categories WHERE id = " + id;
        AppData db = AppData.getInstance();
        db.update(sql);
    }

    public static ArrayList<CategoriaModel> getAll() {
        // Retorna una llista amb totes les categories
        String sql = "SELECT id, nom FROM categories";
        AppData db = AppData.getInstance();
        ArrayList<CategoriaModel> list = new ArrayList<>();
        List<Map<String, Object>> results = db.query(sql);
        
        for (Map<String, Object> row : results) {
            int id = (Integer) row.get("id");
            String nom = (String) row.get("nom");
            list.add(new CategoriaModel(id, nom));
        }
        return list;
    }
}
