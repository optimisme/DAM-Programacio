package com.exercicis;

import java.util.*;

public class Resolt0013 {
    
    public static int generateId(ArrayList<HashMap<String, Object>> cities) {
        Random random = new Random();
        int newId;
        do {
            newId = 1000 + random.nextInt(9000);
        } while (idExists(cities, newId));
        
        return newId;
    }
    
    public static boolean idExists(ArrayList<HashMap<String, Object>> cities, int id) {
        for (HashMap<String, Object> city : cities) {
            if ((int)city.get("id") == id) {
                return true;
            }
        }
        return false;
    }

    public static int getIdByName(ArrayList<HashMap<String, Object>> cities, String name) {
        for (HashMap<String, Object> city : cities) {
            if (city.get("name").equals(name)) {
                return (int)city.get("id");
            }
        }
        return -1;
    }
    
    public static void addCity(ArrayList<HashMap<String, Object>> cities, 
            String name, int population, int height, boolean sealand) {
        HashMap<String, Object> city = new HashMap<>();
        city.put("id", generateId(cities));
        city.put("name", name);
        city.put("population", population);
        city.put("height", height);
        city.put("sealand", sealand);
        cities.add(city);
    }
    
    public static void removeCity(ArrayList<HashMap<String, Object>> cities, int id) {
        cities.removeIf((city) -> {
            return (int) city.get("id") == id;
        });
    }
    
    public static void updateData(ArrayList<HashMap<String, Object>> cities, 
            int id, String field, Object value) {
        for (HashMap<String, Object> city : cities) {
            if ((int)city.get("id") == id) {
                city.put(field, value);
                break;
            }
        }
    }
    
    public static void showInformation(ArrayList<HashMap<String, Object>> cities) {
        int idWidth = 5;
        int nameWidth = 10;
        int popWidth = 10;
        int heightWidth = 7;
        int sealandWidth = 8;
        int totalWidth = idWidth + nameWidth + popWidth + heightWidth + sealandWidth + 6;
        String columns = "|%-" + idWidth + "s|%-" + nameWidth + "s|%" + popWidth + "s|%" + heightWidth + "s|%" + sealandWidth + "s|\n";
        
        System.out.println("-".repeat(totalWidth));
        System.out.printf(columns, "ID", "Name", "Population", "Height", "Sealand");
        System.out.println("-".repeat(totalWidth));
        
        for (HashMap<String, Object> city : cities) {
            System.out.printf(columns, city.get("id"), city.get("name"), 
                city.get("population"), city.get("height"), city.get("sealand"));
        }
        
        System.out.println("-".repeat(totalWidth));
    }

    public static void main(String[] args) {
        ArrayList<HashMap<String, Object>> cities = new ArrayList<>();
        
        // Afegir les ciutats inicials
        addCity(cities, "Barcelona", 1620343, 12, true);
        addCity(cities, "Madrid", 3207247, 667, false);
        addCity(cities, "València", 791413, 15, true);
        addCity(cities, "Màlaga", 569130, 11, true);
        addCity(cities, "Sevilla", 688711, 7, false);
        addCity(cities, "Alicante", 330525, 12, true);
        addCity(cities, "Zaragoza", 664938, 220, false);
        addCity(cities, "Gijón", 275735, 3, true);
        addCity(cities, "Palma de M", 22610, 14, true);
        addCity(cities, "Bilbao", 345821, 30, false);
        
        // Eliminar Sevilla
        int sevillaId = getIdByName(cities, "Sevilla");
        if (sevillaId != -1) {
            removeCity(cities, sevillaId);
        }
        
        // Actualitzar diverses dades
        int barcelonaId = getIdByName(cities, "Barcelona");
        updateData(cities, barcelonaId, "population", 1621000);

        int valenciaId = getIdByName(cities, "València");
        updateData(cities, valenciaId, "height", 16);

        int palmaId = getIdByName(cities, "Palma de M");
        updateData(cities, palmaId, "name", "Palma");

        int zaragozaId = getIdByName(cities, "Zaragoza");
        updateData(cities, zaragozaId, "sealand", false);
        
        // Afegir una nova ciutat
        addCity(cities, "Tarragona", 132299, 70, true);
        
        // Mostrar la informació final
        showInformation(cities);
    }
}