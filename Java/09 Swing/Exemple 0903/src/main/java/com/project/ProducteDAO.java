package com.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
        String sql = String.format(Locale.US,
            "INSERT INTO productes (nom, descripcio, preu, categoriaId) VALUES ('%s', '%s', %.2f, %d)",
            product.getNom(), product.getDescripcio(), product.getPreu(), product.getCategoriaId()
        );
        AppData db = AppData.getInstance();
        db.update(sql);
    }

    public static void updateItem(ProducteModel product) {
        String sql = String.format(Locale.US,
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

    public static ArrayList<ProducteModel> getAll() {
        // Retorna una llista amb tots els productes
        String sql = "SELECT id, nom, descripcio, preu, categoriaId FROM productes";
        AppData db = AppData.getInstance();
        ArrayList<ProducteModel> list = new ArrayList<>();
        List<Map<String, Object>> results = db.query(sql);
        
        for (Map<String, Object> row : results) {
            int id = (Integer) row.get("id");
            String nom = (String) row.get("nom");
            String descripcio = (String) row.get("descripcio");
            double preu = (Double) row.get("preu");
            int categoryId = (Integer) row.get("categoriaId");
            list.add(new ProducteModel(id, nom, descripcio, preu, categoryId));
        }
        return list;
    }
}
