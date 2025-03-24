package com.exercici0600;

import com.utils.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ControllerFormulari {

    @FXML
    private void animateToViewFitxa(ActionEvent event) {
        UtilsViews.setViewAnimating("ViewFitxa");
    }

    @FXML
    private void animateToViewFormulari(ActionEvent event) {
        UtilsViews.setViewAnimating("ViewFormulari");
    }
}