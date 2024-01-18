package com.isep.projectjavawallet.tests;

import com.isep.projectjavawallet.util.SceneManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(homeTest.class.getResource("/com/isep/projectjavawallet/loginViews/authentication.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Authentification");
        stage.setScene(scene);
        stage.setResizable(false);
        SceneManager.setCurrentStage(stage);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
