package com.exercici0602;

import com.utils.*;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ControllerPokeCard implements Initializable {

    @FXML
    private Label labelAbility = new Label();

    @FXML
    private Label labelName = new Label();

    @FXML
    private Label labelType = new Label();

    @FXML
    private Label labelWeigth = new Label();

    @FXML
    private Label labelCategory = new Label();

    @FXML
    private Label labelHeight = new Label();

    @FXML
    private ImageView imgBackArrow;

    @FXML
    private ImageView imgPokemon;

    private int number;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Path imagePath = null;
        try {
            URL imageURL = getClass().getResource("/assets/images0602/arrow-back.png");
            Image image = new Image(imageURL.toExternalForm());
            imgBackArrow.setImage(image);
        } catch (Exception e) {
            System.err.println("Error loading image asset: " + imagePath);
            e.printStackTrace();
        }
    }

    public void loadPokemon(int number) {
        this.number = number;

        AppData db = AppData.getInstance();

        ArrayList<HashMap<String, Object>> llistaPokemons = db.query(String.format("SELECT * FROM pokemons WHERE number = '%d';", this.number));
        if (llistaPokemons.size() == 1) {
            HashMap<String, Object> pokemon = llistaPokemons.get(0); 
            labelAbility.setText((String) pokemon.get("ability"));
            String numName = String.valueOf(this.number) + " " + (String) pokemon.get("name");
            labelName.setText(numName);
            labelType.setText((String) pokemon.get("type"));
            labelCategory.setText((String) pokemon.get("category"));
            labelHeight.setText((String) pokemon.get("height"));
            labelWeigth.setText((String) pokemon.get("weight"));

        }
        System.out.println("hola");
    }

    @FXML
    public void goBack(MouseEvent event) {
        UtilsViews.setViewAnimating("ViewList");
    }

    @FXML
    public void editPokemon(ActionEvent event) {
        System.out.println("To view edit pokemon");
    }

    @FXML
    public void previous(ActionEvent event) {
        System.out.println("To previous pokemon");
    }

    @FXML
    public void next(ActionEvent event) {
        System.out.println("To next pokemon");
    }
}