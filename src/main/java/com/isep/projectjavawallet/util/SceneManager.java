package com.isep.projectjavawallet.util;

import com.isep.projectjavawallet.bean.Home;
import com.isep.projectjavawallet.bean.wallet.Wallet;
import com.isep.projectjavawallet.controllers.HomeController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class SceneManager {
    private static Stage currentStage;






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




    // getters & setters
    public static Stage getCurrentStage() {
        return currentStage;
    }

    public static void setCurrentStage(Stage currentStage) {
        SceneManager.currentStage = currentStage;
    }
}
