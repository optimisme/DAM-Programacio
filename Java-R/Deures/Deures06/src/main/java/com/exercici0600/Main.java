package com.exercici0600;

import com.utils.UtilsViews;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

// Fes anar aquest exemple amb
// ./run.sh com.exercici0600.Main

public class Main extends Application {

    final int WIDOW_WIDTH = 800;
    final int WINDOW_HEIGHT = 600;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        UtilsViews.parentContainer.setStyle("-fx-font: 14 arial;");
        UtilsViews.addView(getClass(), "ViewFitxa", "/assets/viewPersonatgeFitxa.fxml");
        UtilsViews.addView(getClass(), "ViewFormulari", "/assets/viewPersonatgeFormulari.fxml");

        Scene scene = new Scene(UtilsViews.parentContainer);

        stage.setScene(scene);
        stage.setTitle("Animació entre vistes");
        stage.setMinWidth(WIDOW_WIDTH);
        stage.setMinHeight(WINDOW_HEIGHT);
        stage.show();

        // Add icon only if not Mac
        if (!System.getProperty("os.name").contains("Mac")) {
            Image icon = new Image("file:/icons/icon.png");
            stage.getIcons().add(icon);
        }
    }
}