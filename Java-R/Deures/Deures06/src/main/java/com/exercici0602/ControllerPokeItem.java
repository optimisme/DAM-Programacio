package com.exercici0602;

import java.io.File;
import java.nio.file.Path;
import java.util.Objects;

import com.utils.UtilsViews;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControllerPokeItem {

    private int number;

    @FXML
    private Label title, subtitle;

    @FXML
    private ImageView img;

    public void setNumber(int value) {
        this.number = value;
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setSubtitle(String subtitle) {
        this.subtitle.setText(subtitle);
    }

    public void setImatge(String imagePath) {
        try {
            File file = new File(imagePath);
            Image image = new Image(file.toURI().toString());
            this.img.setImage(image);
        } catch (NullPointerException e) {
            System.err.println("Error loading image asset: " + imagePath);
            e.printStackTrace();
        }
    }

    @FXML
    public void toViewCard(MouseEvent event) {
        System.out.println("hola:" + this.number);
        ControllerPokeCard ctrl = (ControllerPokeCard) UtilsViews.getController("ViewCard");
        ctrl.loadPokemon(this.number);
        UtilsViews.setViewAnimating("ViewCard");
    }
}