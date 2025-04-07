package com.exercici0602;

import com.utils.*;

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

    @FXML
    private Button buttonPrevious = new Button();

    @FXML
    private Button buttonNext = new Button();

    private int number;
    private int previousNumber = -1;
    private int nextNumber = -1;

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
            try {
                String imagePath = (String) pokemon.get("image");
                Image image = new Image("file:" + imagePath);
                imgPokemon.setImage(image);
            } catch (Exception e) {
                System.err.println("Error loading image asset: " + (String) pokemon.get("image"));
                e.printStackTrace();
            }
        }

        llistaPokemons = db.query(String.format("SELECT * FROM pokemons WHERE number < '%d' ORDER BY number DESC LIMIT 1;", this.number));
        if (llistaPokemons.size() == 1) {
            HashMap<String, Object> pokemon = llistaPokemons.get(0); 
            this.previousNumber = (int) pokemon.get("number");
            this.buttonPrevious.setDisable(false);
        } else {
            this.previousNumber = -1;
            this.buttonPrevious.setDisable(true);
        }

        llistaPokemons = db.query(String.format("SELECT * FROM pokemons WHERE number > '%d' ORDER BY number ASC LIMIT 1;", this.number));
        if (llistaPokemons.size() == 1) {
            HashMap<String, Object> pokemonNext = llistaPokemons.get(0); 
            this.nextNumber = (int) pokemonNext.get("number");
            this.buttonNext.setDisable(false);
        }
        else {
            this.nextNumber = -1;
            this.buttonNext.setDisable(true);
        }
    }

    @FXML
    public void goBack(MouseEvent event) {
        UtilsViews.setViewAnimating("ViewList");
    }

    @FXML
    public void editPokemon(ActionEvent event) {
        ControllerPokeForm ctrl = (ControllerPokeForm) UtilsViews.getController("ViewForm");
        ctrl.setStatus(ControllerPokeForm.STATUS_EDIT, this.number);
        UtilsViews.setViewAnimating("ViewForm");
    }

    @FXML
    public void previous(ActionEvent event) {
        if (this.previousNumber != -1) {
            loadPokemon(this.previousNumber);
        }
    }

    @FXML
    public void next(ActionEvent event) {
        if (this.nextNumber != -1) {
            loadPokemon(this.nextNumber);
        }
    }
}