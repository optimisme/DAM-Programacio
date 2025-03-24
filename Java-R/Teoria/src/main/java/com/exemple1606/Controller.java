package com.exemple1606;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.json.JSONArray;
import org.json.JSONObject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class Controller implements Initializable {

    @FXML
    private Button buttonSeasons, buttonBrands, buttonFXML;
    @FXML
    private AnchorPane container;
    @FXML
    private VBox yPane = new VBox();

    private String seasons[] = { "Summer", "Autumn", "Winter", "Spring" };
    private String brands[] = { "Audi", "BMW", "Citroen", "Fiat", "Ford", "Honda", "Hyundai", "Kia", "Mazda", "Mercedes",
            "Nissan", "Opel", "Peugeot", "Renault", "Seat", "Skoda", "Suzuki", "Toyota", "Volkswagen", "Volvo" };

    private JSONArray jsonInfo;

    // Called when the FXML file is loaded
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            URL jsonFileURL = getClass().getResource("/assets/exemple1606Animals.json");
            Path path = Paths.get(jsonFileURL.toURI());
            String content = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
            jsonInfo = new JSONArray(content);

            // Actualitza la UI amb els valors inicials de les estacions
            setSeasons(null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void setSeasons(ActionEvent event) {
        ArrayList<String> list = new ArrayList<>();
        for (String name : seasons) {
            list.add(name);
        }

        yPane.getChildren().clear();
        for (String s : list) {
            Label label = new Label(s);
            label.setStyle("-fx-border-color: red;");
            yPane.getChildren().add(label);
        }

    }

    @FXML
    private void setBrands(ActionEvent event) {
        yPane.getChildren().clear();
        for (String s : brands) {
            Label label = new Label(s);
            label.setStyle("-fx-border-color: black;");
            yPane.getChildren().add(label);
        }
    }

    @FXML
    private void setAnimals(ActionEvent event) throws Exception {

        // Obtenir el recurs del template .fxml
        URL resource = this.getClass().getResource("/assets/exemple1606Item.fxml");

        // Netejar el contingut existent
        yPane.getChildren().clear();

        // Iterar sobre els elements del JSONArray 'jsonInfo' (ja carregat a initialize)
        for (int i = 0; i < jsonInfo.length(); i++) {
            // Obtenir l'objecte JSON individual (season)
            JSONObject season = jsonInfo.getJSONObject(i);

            // Extreure la informació necessària del JSON
            String category = season.getString("category");
            String name = season.getString("animal");
            String color = season.getString("color");

            // Carregar el template de 'exemple1606Item.fxml'
            FXMLLoader loader = new FXMLLoader(resource);
            Parent itemTemplate = loader.load();
            ControllerItem itemController = loader.getController();

            // Assignar els valors als controls del template
            itemController.setTitle(name);
            itemController.setSubtitle(category);
            itemController.setImatge("/assets/images/" + name.toLowerCase() + ".png");
            itemController.setCircleColor(color);

            // Afegir el nou element a 'yPane'
            yPane.getChildren().add(itemTemplate);
        }
    }

}