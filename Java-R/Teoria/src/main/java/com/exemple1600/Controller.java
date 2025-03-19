package com.exemple1600;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;

public class Controller {

    @FXML
    private Button buttonAdd;

    @FXML
    private Text textCounter;

    private int counter = 0;

    @FXML
    private void actionAdd(ActionEvent event) {
        counter++;
        textCounter.setText(String.valueOf(counter));
    }
}
