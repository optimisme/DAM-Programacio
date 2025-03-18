package com.exercici0501;

import java.io.IOException;
import java.security.InvalidParameterException;

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


        try {
            Restaurants.llistarTaulaRestautants();
            Restaurants.llisarTaulaClients();
            Restaurants.llistarTaulaServeis(-1);
            Restaurants.llistarTaulaServeis(2);
          } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidParameterException e) {
            e.printStackTrace();
        }

        Restaurants.llistarMitjanes();

        db.close();
    }
}
