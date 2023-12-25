package com.isep.projectjavawallet.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    // Buttons
    @FXML
    private ToggleButton profilButton;
    @FXML
    private ToggleButton marketButton;
    @FXML
    private ToggleButton walletsButton;
    @FXML
    private ToggleButton currencyButton;
    @FXML
    private ToggleButton otherButton;


    @FXML
    private AnchorPane rightPartPane;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // profilButtonClick setting
        ToggleGroup toggleGroup = new ToggleGroup();
        profilButton.setToggleGroup(toggleGroup);
        marketButton.setToggleGroup(toggleGroup);
        walletsButton.setToggleGroup(toggleGroup);
        currencyButton.setToggleGroup(toggleGroup);
        otherButton.setToggleGroup(toggleGroup);
    }


    @FXML
    public void profilButtonClick(){
        try {
            // load sub-window's FXML
            AnchorPane pane2 = FXMLLoader.load(getClass().getResource("/com/isep/projectjavawallet/settingViews/profil-view.fxml"));
            rightPartPane.getChildren().clear();
            rightPartPane.getChildren().setAll(pane2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void walletsButtonClick(){
        try {
            // load sub-window's FXML
            AnchorPane pane2 = FXMLLoader.load(getClass().getResource("/com/isep/projectjavawallet/WalletsViews/walletsList-view.fxml"));
            rightPartPane.getChildren().clear();
            rightPartPane.getChildren().setAll(pane2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    


    
}
