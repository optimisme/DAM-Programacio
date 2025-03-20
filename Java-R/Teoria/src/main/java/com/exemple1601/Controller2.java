package com.exemple1601;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class Controller2 {

    @FXML
    private Button button0, button1, button2;
    @FXML
    private AnchorPane container;

    @FXML
    private void toView0(ActionEvent event) {
        UtilsViews.setView("View0");
    }

    @FXML
    private void toView1(ActionEvent event) {
        UtilsViews.setView("View1");
    }

    @FXML
    private void toView2(ActionEvent event) {
        UtilsViews.setView("View2");
    }

    @FXML
    private void animateToView0(ActionEvent event) {
        UtilsViews.setViewAnimating("View0");
    }

    @FXML
    private void animateToView1(ActionEvent event) {
        UtilsViews.setViewAnimating("View1");
    }

    @FXML
    private void animateToView2(ActionEvent event) {
        UtilsViews.setViewAnimating("View2");
    }
}