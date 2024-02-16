package com.isep.projectjavawallet.controllers;

import com.isep.projectjavawallet.util.SceneManager;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    // Buttons
    @FXML
    private ToggleButton profileButton;
    @FXML
    private ToggleButton marketButton;
    @FXML
    private ToggleButton walletsButton;
    @FXML
    public Button logOutButton;

    @FXML
    private AnchorPane rightPartPane;

    @FXML
    ImageView profileIcon;
    @FXML
    ImageView walletsIcon;
    @FXML
    ImageView marketIcon;
    @FXML
    ImageView logOutIcon;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SceneManager.setHomeController(this);
        ToggleGroup toggleGroup = new ToggleGroup();
        profileButton.setToggleGroup(toggleGroup);
        marketButton.setToggleGroup(toggleGroup);
        walletsButton.setToggleGroup(toggleGroup);
        walletsButton.setSelected(true);
        walletsButtonClick();

        profileIcon.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                profileButton.fire();
            }
        });
        walletsIcon.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                walletsButton.fire();
            }
        });
        marketIcon.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                marketButton.fire();
            }
        });
        logOutIcon.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                logOutButton.fire();
            }
        });

    }


    @FXML
    public void profileButtonClick(){
        try {
            // load sub-window's FXML
            AnchorPane pane2 = FXMLLoader.load(getClass().getResource("/com/isep/projectjavawallet/profilePart/profile-view.fxml"));
            rightPartPane.getChildren().clear();
            rightPartPane.getChildren().setAll(pane2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private boolean ini = true;
    @FXML
    public void walletsButtonClick(){
        try {
            SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/waletPart/walletList-view.fxml");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void marketButtonClick() {
        try {
            // load sub-window's FXML
            AnchorPane pane2 = FXMLLoader.load(getClass().getResource("/com/isep/projectjavawallet/marketPart/market-view.fxml"));
            rightPartPane.getChildren().clear();
            rightPartPane.getChildren().setAll(pane2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void logoutButtonClick(){
        SceneManager.changeScene("/com/isep/projectjavawallet/loginPart/authentication.fxml","Authentification");
    }




    public AnchorPane getRightPartPane() {
        return rightPartPane;
    }

    public void setRightPartPane(AnchorPane rightPartPane) {
        this.rightPartPane = rightPartPane;
    }
}
