package com.exercici0602;

import com.utils.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;

public class ControllerPokeList {

    @FXML
    private VBox list = new VBox();

    public void loadList() {
        AppData db = AppData.getInstance();
        db.connect("./data/pokemons.sqlite");

        // Llistar les 10 últimes ciutats utilitzant ArrayList i HashMap
        ArrayList<HashMap<String, Object>> llistaPokemons = db.query("SELECT * FROM pokemons;");
        try {
            setList(llistaPokemons);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void setList(ArrayList<HashMap<String, Object>> llistaPokemons) throws IOException {

        URL resource = this.getClass().getResource("/assets/viewPokeItem.fxml");

        // Netejar el contingut existent
        list.getChildren().clear();

        // Iterar sobre els elements del JSONArray 'jsonInfo' (ja carregat a initialize)
        for (int i = 0; i < llistaPokemons.size(); i++) {
            // Obtenir l'objecte JSON individual (animal)
            HashMap<String, Object> pokemon = llistaPokemons.get(i);

            // Extreure la informació necessària del JSON
            int number = (int) pokemon.get("number");
            String name = (String) pokemon.get("name");
            String type = (String) pokemon.get("type");
            String imagePath = (String) pokemon.get("image");
            System.out.println(name);

            // Carregar el template
            FXMLLoader loader = new FXMLLoader(resource);
            Parent itemTemplate = loader.load();
            ControllerPokeItem itemController = loader.getController();

            // Assignar els valors als controls del template
            itemController.setNumber(number);
            itemController.setTitle(name);
            itemController.setSubtitle(type);
            itemController.setImatge(imagePath);

            // Afegir el nou element a 'yPane'
            list.getChildren().add(itemTemplate);
        }
    }

    @FXML
    public void addPokemon(ActionEvent event) {
        //TODO
    }
}