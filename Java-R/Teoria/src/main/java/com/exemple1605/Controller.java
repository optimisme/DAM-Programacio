package com.exemple1605;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class Controller implements Initializable {

    @FXML
    private Button button0, button1, button2, buttonWeekdays, buttonMonths;
    @FXML
    private Label choiceLabel;
    @FXML
    private AnchorPane container;
    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private VBox yPane = new VBox();

    String weekdays[] = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" };
    String months[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December" };

    // Called when the FXML file is loaded
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        choiceBox.getItems().addAll(weekdays);
        choiceBox.setValue(weekdays[0]);
        choiceBox.setOnAction((event) -> {
            // Posar el text al label, de la opció que ha escollit l'usuari al choicebox
            choiceLabel.setText(choiceBox.getSelectionModel().getSelectedItem());
        });
    }

    @FXML
    private void setWeekdays(ActionEvent event) {

        String value = "Monday";

        choiceBox.getItems().clear();
        choiceBox.getItems().addAll(weekdays);
        choiceBox.setValue(value);

        choiceLabel.setText(value);
    }

    @FXML
    private void setMonths(ActionEvent event) {

        String value = "January";

        choiceBox.getItems().clear();
        choiceBox.getItems().addAll(months);
        choiceBox.setValue(value);

        choiceLabel.setText(value);
    }
}