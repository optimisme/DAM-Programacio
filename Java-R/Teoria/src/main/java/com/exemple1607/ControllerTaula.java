package com.exemple1607;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

public class ControllerTaula implements Initializable {

    @FXML
    private ChoiceBox<String> choiceBox;

    // Called when the FXML file is loaded
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /* 
        choiceBox.getItems().addAll(weekdays);
        choiceBox.setValue(weekdays[0]);
         */
        choiceBox.setOnAction((event) -> {
            String tableName = choiceBox.getSelectionModel().getSelectedItem();
            setTable(tableName);
        });
       
    }

    public String loadTables() {
        AppData db = AppData.getInstance();
        String sql = "LIST TABLES;";

        ArrayList<HashMap<String, Object>> rows = db.query(sql);

        // Llistar el nom i tipus de dades de cada columna (de la fila 0)
        for (HashMap<String, Object> row : rows) {
            for (String key : row.keySet()) {
                Object value = row.get(key);
                String className = value.getClass().getName();
                System.out.println(className);
            }
        }
        return "";
    }

    @FXML
    private void setTable(String tableName) {
/* 
        String value = "Monday";

        choiceBox.getItems().clear();
        choiceBox.getItems().addAll(weekdays);
        choiceBox.setValue(value);

        choiceLabel.setText(value);
        */
    }

    @FXML
    public void reload(ActionEvent event) {
    }

    @FXML
    public void save(ActionEvent event) {
    }
}