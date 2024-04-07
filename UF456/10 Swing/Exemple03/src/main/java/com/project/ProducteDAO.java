package com.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProducteDAO {

    public static ProducteModel getItem(int id) {
        String sql = "SELECT id, nom, descripcio, preu, categoriaId FROM productes WHERE id = " + id;
        AppData db = AppData.getInstance();
        List<Map<String, Object>> results = db.query(sql);
        
        if (!results.isEmpty()) {
            Map<String, Object> row = results.get(0);
            return new ProducteModel(
                (int)row.get("id"), 
                (String)row.get("nom"), 
                (String)row.get("descripcio"), 
                (Double)row.get("preu"), 
                (int)row.get("categoriaId")
            );
        }
        return null;
    }

    public static void addItem(ProducteModel product) {
        String sql = String.format(
            "INSERT INTO productes (nom, descripcio, preu, categoriaId) VALUES ('%s', '%s', %f, %d)",
            product.getNom(), product.getDescripcio(), product.getPreu(), product.getCategoriaId()
        );
        AppData db = AppData.getInstance();
        db.update(sql);
    }

    public static void updateItem(ProducteModel product) {
        String sql = String.format(
            "UPDATE productes SET nom = '%s', descripcio = '%s', preu = %f, categoriaId = %d WHERE id = %d",
            product.getNom(), product.getDescripcio(), product.getPreu(), product.getCategoriaId(), product.getId()
        );
        AppData db = AppData.getInstance();
        db.update(sql);
    }

    public static void deleteItem(int id) {
        String sql = "DELETE FROM productes WHERE id = " + id;
        AppData db = AppData.getInstance();
        db.update(sql);
    }

    public static ArrayList<String> getAllStrings() {
        // Retorna una llista amb tots els noms de producte amb format 'id-nom'
        String sql = "SELECT id, nom FROM productes";
        AppData db = AppData.getInstance();
        ArrayList<String> productes = new ArrayList<>();
        List<Map<String, Object>> results = db.query(sql);
        
        for (Map<String, Object> row : results) {
            String categoryEntry = row.get("id") + "-" + row.get("nom");
            productes.add(categoryEntry);
        }
        return productes;
    }
}
