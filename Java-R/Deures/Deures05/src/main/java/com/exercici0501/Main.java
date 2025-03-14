package com.exercici0501;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    // Fes anar aquest programa amb:
    // ./run.sh com.exercici0501.Main
    
    public static void main(String[] args) {
        AppData db = AppData.getInstance();
        db.connect("./data/dbRestaurants.sqlite");

        Restaurants.crearTaules();
        try {
            Restaurants.loadData("./data/restaurants.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Restaurants.llistarTaulaRestautants();
        Restaurants.llisarTaulaClients();
        try {
            Restaurants.llistarTaulaServeis(-1);
            Restaurants.llistarTaulaServeis(2);
        } catch (InvalidParameterException e) {
            e.printStackTrace();
        }

        db.close();
    }
}
