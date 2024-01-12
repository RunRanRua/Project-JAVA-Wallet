package com.isep.projectjavawallet.util;

import com.isep.projectjavawallet.bean.Home;
import com.isep.projectjavawallet.controllers.HomeController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class SceneManager {

    static HomeController homeController;
    static Home home;

    private static Stage currentStage;
    static ArrayList<WalletPane> panes;







    // Not finished yet
    public static void anotherScene(String fxmlFileName, String title) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SceneManager.class.getResource(fxmlFileName));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(scene);

            currentStage = stage;   // ?

            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void anotherScene_walletPane(String fxmlFileName, String title, WalletPane pane) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SceneManager.class.getResource(fxmlFileName));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(scene);
            panes.add(pane);

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

            currentStage.close();
            currentStage = stage;
            currentStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    // getters & setters


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

    public static Stage getCurrentStage() {
        return currentStage;
    }

    public static void setCurrentStage(Stage currentStage) {
        SceneManager.currentStage = currentStage;
    }
}
