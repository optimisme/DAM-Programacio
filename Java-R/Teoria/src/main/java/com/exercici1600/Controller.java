package com.exercici1600;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;

public class Controller {

    @FXML
    private Button buttonAdd;

    @FXML
    private TextField valueA;

    @FXML
    private TextField valueB;

    @FXML
    private Text textCounter;

    private int counter = 0;

    @FXML
    private void actionAdd(ActionEvent event) {
        int intA = Integer.parseInt(valueA.getText());
        int intB = Integer.parseInt(valueB.getText());
        
        textCounter.setText(String.valueOf(intA + intB));
    }
}
