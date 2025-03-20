package com.exemple1602;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class Controller0 {

    @FXML
    private Button button00, button01, button02;
    @FXML
    private AnchorPane container;

    @FXML
    private VBox itemBox;

    @FXML
    private void setDades0(ActionEvent event) {
        setDades("Cat");
    }

    @FXML
    private void setDades1(ActionEvent event) {
        setDades("Horse");
    }

    @FXML
    private void setDades2(ActionEvent event) {
        setDades("Turtle");
    }

    private void setDades(String animal) {

        try {
            // Obtenir el recurs del template .fxml
            URL resource = this.getClass().getResource("/assets/exemple1602Item.fxml");
            FXMLLoader loader = new FXMLLoader(resource);
            Parent itemPane = loader.load();
            ControllerItem itemController = loader.getController();

            // Netejar el contingut existent
            itemBox.getChildren().clear();

            switch (animal) {
                case "Cat":
                    itemController.setTitle("Cat");
                    itemController.setSubtitle("This is 0");
                    itemController.setImatge("/assets/images/cat.png");
                    itemController.setCircleColor("red");
                    break;
                case "Horse":
                    itemController.setTitle("Horse");
                    itemController.setSubtitle("This is 1");
                    itemController.setImatge("/assets/images/horse.png");
                    itemController.setCircleColor("green");
                    break;
                default:
                    itemController.setTitle("Turtle");
                    itemController.setSubtitle("This is 2");
                    itemController.setImatge("/assets/images/turtle.png");
                    itemController.setCircleColor("blue");
                    break;
            }

            // Assignar els valors als controls del template


            // Afegir el nou element a 'yPane'
            itemBox.getChildren().add(itemPane);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}