package com.isep.projectjavawallet.tests;

import com.isep.projectjavawallet.util.SceneManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AuthentificationTest extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(homeTest.class.getResource("loginViews/authentication.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        SceneManager.setCurrentStage(stage);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
