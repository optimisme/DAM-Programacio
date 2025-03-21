package com.exercici1603;

import com.utils.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Controller1 {

    @FXML
    private void animateToView0(ActionEvent event) {
        UtilsViews.setViewAnimating("View0");
    }

    @FXML
    private void animateToView1(ActionEvent event) {
        UtilsViews.setViewAnimating("View1");
    }
}