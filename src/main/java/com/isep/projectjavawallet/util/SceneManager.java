package com.isep.projectjavawallet.util;

import com.isep.projectjavawallet.bean.Home;
import com.isep.projectjavawallet.bean.wallet.Wallet;
import com.isep.projectjavawallet.controllers.HomeController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SceneManager {
    private static Stage currentStage;
    private static String currentRightPart_home;
    private static HomeController homeController;
    private static Home home;
    private static Wallet targetWallet;


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
            homeController.getRightPartPane().getChildren().clear();
            homeController.getRightPartPane().getChildren().setAll(pane2);

            currentRightPart_home = fxmlPath;

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

    public static String getCurrentRightPart_home() {
        return currentRightPart_home;
    }

    public static void setCurrentRightPart_home(String currentRightPart_home) {
        SceneManager.currentRightPart_home = currentRightPart_home;
    }

    public static HomeController getHomeController() {
        return homeController;
    }

    public static void setHomeController(HomeController homeController) {
        SceneManager.homeController = homeController;
    }

    public static Home getHome() {
        return home;
    }

    public static void setHome(Home home) {
        SceneManager.home = home;
    }

    public static Wallet getTargetWallet() {
        return targetWallet;
    }

    public static void setTargetWallet(Wallet targetWallet) {
        SceneManager.targetWallet = targetWallet;
    }
}
