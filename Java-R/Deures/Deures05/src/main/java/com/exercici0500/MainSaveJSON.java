package com.exercici0500;

public class MainSaveJSON {

    // Fes anar aquest programa amb:
    // ./run.sh com.exercici0500.MainSaveJSON

    public static void main(String[] args) {
        
        AppData db = AppData.getInstance();
        db.connect("./data/cinema.sqlite");

        Cinema.pelisToJSON("./data/pelis.json");

        db.close();
    }
}
