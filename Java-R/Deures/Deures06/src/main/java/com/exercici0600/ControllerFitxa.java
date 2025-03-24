package com.exercici0600;

import com.utils.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class ControllerFitxa {

    @FXML
    private void animateToViewFitxa(ActionEvent event) {
        UtilsViews.setViewAnimating("ViewFitxa");
    }

    @FXML
    private void animateToViewFormulari(ActionEvent event) {
        UtilsViews.setViewAnimating("ViewFormulari");
    }
}