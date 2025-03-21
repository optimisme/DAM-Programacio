package com.exemple1602;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.json.JSONArray;
import org.json.JSONObject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private Button buttonLoadJSON, buttonSaveJSON, buttonLoadImage;

    @FXML
    private TextArea txt;

    @FXML
    private ImageView img;

    @FXML
    private void actionLoadJSON() {
        Stage stage = (Stage) buttonLoadJSON.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Arxius JSON", "*.json"));
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            try {
                String content = new String(Files.readAllBytes(selectedFile.toPath()));
                txt.setText(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void actionSaveJSON() {
        Stage stage = (Stage) buttonSaveJSON.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Arxius JSON", "*.json"));
        File selectedFile = fileChooser.showSaveDialog(stage);
        if (selectedFile != null) {
            try {
                String jsonData = txt.getText();
                System.out.println(jsonData);
                System.out.println();
                if (jsonData.substring(0, 1).equalsIgnoreCase("[")) {
                    JSONArray json = new JSONArray(jsonData);
                    Files.write(selectedFile.toPath(), json.toString(4).getBytes());
                } else {
                    JSONObject json = new JSONObject(jsonData);
                    Files.write(selectedFile.toPath(), json.toString(4).getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void actionLoadImage() {
        Stage stage = (Stage) buttonLoadImage.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imatges", "*.png", "*.jpg", "*.jpeg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            try {
                Image image = new Image(selectedFile.toURI().toString());
                img.setImage(image);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
