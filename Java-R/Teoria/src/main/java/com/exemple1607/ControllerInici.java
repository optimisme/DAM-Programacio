package com.exemple1607;

import com.utils.*;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ControllerInici {

    @FXML
    private Button buttonSelectFile;

    @FXML
    public void selectFile(ActionEvent event) {
        Stage stage = (Stage) buttonSelectFile.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Arxius .sqlite", "*.sqlite"));
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            AppData db = AppData.getInstance();
            db.connect(selectedFile.toPath().toString());
            ControllerTaula ctrlTaula = (ControllerTaula) UtilsViews.getController("ViewTaula");
            ctrlTaula.loadTables("", -1);
            UtilsViews.setViewAnimating("ViewTaula");
        }
    }
}