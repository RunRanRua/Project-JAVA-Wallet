package com.isep.projectjavawallet.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {
    private static Stage currentStage;
    private static String currentRightPart_walletsView;


    public static void anotherScene(String fxmlFileName, String title) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SceneManager.class.getResource(fxmlFileName));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(scene);


            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void anotherScene_walletPane(String fxmlFileName, String title, int walletPaneID) {
        UserManager.setWalletPaneID(walletPaneID);
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SceneManager.class.getResource(fxmlFileName));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(scene);


            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void changeScene(String fxmlFileName,String title) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SceneManager.class.getResource(fxmlFileName));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(scene);
            stage.setResizable(false);

            currentStage.close();
            currentStage = stage;
            currentStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void changeSceneRightPart(String fxmlPath){
        try {
            AnchorPane pane2 = FXMLLoader.load(SceneManager.class.getResource(fxmlPath));
            UserManager.getHomeController().getRightPartPane().getChildren().clear();
            UserManager.getHomeController().getRightPartPane().getChildren().setAll(pane2);

            currentRightPart_walletsView = fxmlPath;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    // getters & setters
    public static Stage getCurrentStage() {
        return currentStage;
    }

    public static void setCurrentStage(Stage currentStage) {
        SceneManager.currentStage = currentStage;
    }

    public static String getCurrentRightPart_walletsView() {
        return currentRightPart_walletsView;
    }

    public static void setCurrentRightPart_walletsView(String currentRightPart_walletsView) {
        SceneManager.currentRightPart_walletsView = currentRightPart_walletsView;
    }
}
