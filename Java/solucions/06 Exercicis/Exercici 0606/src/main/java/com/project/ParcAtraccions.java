package com.project;

import java.util.ArrayList;
import java.util.List;

public class ParcAtraccions {
    private List<Atraccio> atraccions = new ArrayList<>();
    private List<Restaurant> restaurants = new ArrayList<>();
    private List<Botiga> botigues = new ArrayList<>();

    // Mètodes per afegir components
    public void afegirAtraccio(Atraccio atraccio) {
        atraccions.add(atraccio);
    }

    public void afegirRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public void afegirBotiga(Botiga botiga) {
        botigues.add(botiga);
    }

    // Mètodes per obtenir llistes de components
    public List<Atraccio> getAtraccions() {
        return atraccions;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public List<Botiga> getBotigues() {
        return botigues;
    }
}

