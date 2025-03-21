package com.exemple1603;

import com.utils.UtilsViews;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

// Fes anar aquest exemple amb
// ./run.sh com.exemple1603.Main

public class Main extends Application {

    final int WIDOW_WIDTH = 800;
    final int WINDOW_HEIGHT = 600;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        UtilsViews.parentContainer.setStyle("-fx-font: 14 arial;");
        UtilsViews.addView(getClass(), "View0", "/assets/exemple1603View0.fxml");
        UtilsViews.addView(getClass(), "View1", "/assets/exemple1603View1.fxml");
        UtilsViews.addView(getClass(), "View2", "/assets/exemple1603View2.fxml");

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