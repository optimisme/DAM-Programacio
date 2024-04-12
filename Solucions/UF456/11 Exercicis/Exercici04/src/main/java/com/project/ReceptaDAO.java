package com.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReceptaDAO {

    // Obtenir una recepta per ID, incloent els seus ingredients
    public static ReceptaModel getItem(int id) {
        String sqlRecepta = "SELECT id, nom, temps, procediment, esFavorita FROM receptes WHERE id = " + id;
        AppData db = AppData.getInstance();
        List<Map<String, Object>> resultsRecepta = db.query(sqlRecepta);

        if (!resultsRecepta.isEmpty()) {
            Map<String, Object> rowRecepta = resultsRecepta.get(0);
            ReceptaModel recepta = new ReceptaModel(
                (int)rowRecepta.get("id"), 
                (String)rowRecepta.get("nom"), 
                (String)rowRecepta.get("temps"), 
                (String)rowRecepta.get("procediment"),
                (boolean)rowRecepta.get("esFavorita")
            );

            // Obtenir els ingredients per a la recepta
            String sqlIngredients = "SELECT id, nom, quantitat FROM ingredients WHERE receptaId = " + id;
            List<Map<String, Object>> resultsIngredients = db.query(sqlIngredients);
            for (Map<String, Object> rowIngredient : resultsIngredients) {
                IngredientModel ingredient = new IngredientModel(
                    (int)rowIngredient.get("id"),
                    (String)rowIngredient.get("nom"),
                    (String)rowIngredient.get("quantitat"),
                    id // ID de la recepta
                );
                recepta.addIngredient(ingredient);
            }
            return recepta;
        }
        return null;
    }

    // Afegir una nova recepta amb els seus ingredients
    public static void addItem(ReceptaModel recepta) {
        String sqlRecepta = "INSERT INTO receptes (nom, temps, procediment, esFavorita) VALUES ('" 
                            + recepta.getNom() + "', '" 
                            + recepta.getTemps() + "', '" 
                            + recepta.getProcediment() + "', " 
                            + (recepta.getEsFavorita() ? 1 : 0) + ")";
        AppData db = AppData.getInstance();
        int receptaId = db.insertAndGetId(sqlRecepta);

        for (IngredientModel ingredient : recepta.getIngredients()) {
            String sqlIngredient = "INSERT INTO ingredients (nom, quantitat, receptaId) VALUES ('" 
                                + ingredient.getNom() + "', '" 
                                + ingredient.getQuantitat() + "', " 
                                + receptaId + ")";
            db.update(sqlIngredient); // Suposant que `update` és adequat per a operacions que no necessiten retornar ID
        }
    }

    // Actualitzar una recepta i els seus ingredients
    public static void updateItem(ReceptaModel recepta) {
        String sqlRecepta = "UPDATE receptes SET nom = '" + recepta.getNom() 
                            + "', temps = '" + recepta.getTemps() 
                            + "', procediment = '" + recepta.getProcediment() 
                            + "', esFavorita = " + (recepta.getEsFavorita() ? 1 : 0) 
                            + " WHERE id = " + recepta.getId();
        AppData db = AppData.getInstance();
        db.update(sqlRecepta);

        // Per simplicitat, podríem eliminar tots els ingredients i reinserir-los
        // Aquesta estratègia es pot millorar per ser més eficient
        String sqlDeleteIngredients = "DELETE FROM ingredients WHERE receptaId = " + recepta.getId();
        db.update(sqlDeleteIngredients);

        for (IngredientModel ingredient : recepta.getIngredients()) {
            String sqlIngredient = "INSERT INTO ingredients (nom, quantitat, receptaId) VALUES ('" 
                                   + ingredient.getNom() + "', '" 
                                   + ingredient.getQuantitat() + "', " 
                                   + recepta.getId() + ")";
            db.update(sqlIngredient);
        }
    }

    // Esborrar una recepta i els seus ingredients associats
    public static void deleteItem(int id) {
        AppData db = AppData.getInstance();
        db.update("DELETE FROM ingredients WHERE receptaId = " + id);
        db.update("DELETE FROM receptes WHERE id = " + id);
    }

    // Llistar totes les receptes disponibles, incloent els seus ingredients
    public static ArrayList<ReceptaModel> getAll() {
        String sql = "SELECT id, nom, temps, procediment, esFavorita FROM receptes";
        AppData db = AppData.getInstance();
        ArrayList<ReceptaModel> list = new ArrayList<>();
        List<Map<String, Object>> results = db.query(sql);
        
        for (Map<String, Object> row : results) {
            int receptaId = (int) row.get("id");
            ReceptaModel recepta = new ReceptaModel(
                receptaId,
                (String) row.get("nom"),
                (String) row.get("temps"),
                (String) row.get("procediment"),
                (boolean) row.get("esFavorita").equals(1) // Aquí podria haver un error, es revisarà després
            );

            // Crida a una funció per recuperar i afegir els ingredients a la recepta
            addIngredientsToRecepta(receptaId, recepta, db);

            list.add(recepta);
        }
        return list;
    }

    // Funció auxiliar per afegir ingredients a una recepta
    private static void addIngredientsToRecepta(int receptaId, ReceptaModel recepta, AppData db) {
        String sqlIngredients = "SELECT id, nom, quantitat FROM ingredients WHERE receptaId = " + receptaId;
        List<Map<String, Object>> resultsIngredients = db.query(sqlIngredients);
        for (Map<String, Object> rowIngredient : resultsIngredients) {
            IngredientModel ingredient = new IngredientModel(
                (int) rowIngredient.get("id"),
                (String) rowIngredient.get("nom"),
                (String) rowIngredient.get("quantitat"),
                receptaId
            );
            recepta.addIngredient(ingredient);
        }
    }
}
