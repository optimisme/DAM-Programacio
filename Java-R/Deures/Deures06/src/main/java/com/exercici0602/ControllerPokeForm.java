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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ControllerPokeForm implements Initializable {

    public static final String STATUS_ADD = "add";
    public static final String STATUS_EDIT = "edit";
    private String status = "";
    private int number = -1;

    @FXML
    private TextField fieldName = new TextField();

    @FXML
    private TextField fieldAbility = new TextField();
  
    @FXML
    private TextField fieldCategory = new TextField();
    
    @FXML
    private TextField fieldType = new TextField();
  
    @FXML
    private TextField fieldHeight = new TextField();
  
    @FXML
    private TextField fieldWeight = new TextField();
  
    @FXML
    private ImageView imgBackArrow;

    @FXML
    private ImageView imgPokemon;

    @FXML
    private Button buttonAdd = new Button();

    @FXML
    private Button buttonUpdate = new Button();

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

    public void setStatus(String value, int number) {
        this.status = value;
        this.number = number;
        if (this.status.equalsIgnoreCase(STATUS_ADD)) {
            buttonAdd.setVisible(true);
            buttonUpdate.setVisible(false);

            fieldName.clear();
            fieldAbility.clear();
            fieldCategory.clear();
            fieldType.clear();
            fieldHeight.clear();
            fieldWeight.clear();
            imgPokemon.setImage(null);
        }
        if (this.status.equalsIgnoreCase(STATUS_EDIT)) {
            buttonAdd.setVisible(false);
            buttonUpdate.setVisible(true);

            AppData db = AppData.getInstance();
            String sql = String.format("SELECT * FROM pokemons WHERE number = '%d';", this.number);
            ArrayList<HashMap<String, Object>> llista = db.query(sql);
            if (llista.size() == 1) {
                HashMap<String, Object> pokemon = llista.get(0);

                fieldName.setText((String) pokemon.get("name"));
                fieldAbility.setText((String) pokemon.get("ability"));
                fieldCategory.setText((String) pokemon.get("category"));
                fieldType.setText((String) pokemon.get("type"));
                fieldHeight.setText((String) pokemon.get("height"));
                fieldWeight.setText((String) pokemon.get("weight"));

                String imagePath = (String) pokemon.get("image");
                try {
                    File file = new File(imagePath);
                    Image image = new Image(file.toURI().toString());
                    this.imgPokemon.setImage(image);
                } catch (NullPointerException e) {
                    System.err.println("Error loading image asset: " + imagePath);
                    e.printStackTrace();
                }
            }
        }
    }

    @FXML
    public void goBack(MouseEvent event) {
        if (this.status.equalsIgnoreCase(STATUS_ADD)) {
            UtilsViews.setViewAnimating("ViewList");
        }
        if (this.status.equalsIgnoreCase(STATUS_EDIT)) {
            UtilsViews.setViewAnimating("ViewCard");
        }
    }

    @FXML
    public void selectFile(ActionEvent event) {

    }

    @FXML
    public void add(ActionEvent event) {
        
    }

    @FXML
    public void update(ActionEvent event) {
        
    }
}