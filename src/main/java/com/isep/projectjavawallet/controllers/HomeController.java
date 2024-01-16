package com.isep.projectjavawallet.controllers;

import com.isep.projectjavawallet.util.SceneManager;
import com.isep.projectjavawallet.util.UserManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
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
    private ToggleButton currencyButton;
    @FXML
    public Button LogoutButton;


    @FXML
    private AnchorPane rightPartPane;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UserManager.setHomeController(this);
        ToggleGroup toggleGroup = new ToggleGroup();
        profileButton.setToggleGroup(toggleGroup);
        marketButton.setToggleGroup(toggleGroup);
        walletsButton.setToggleGroup(toggleGroup);
        currencyButton.setToggleGroup(toggleGroup);
        walletsButton.setSelected(true);
        walletsButtonClick();
    }


    @FXML
    public void profileButtonClick(){
        try {
            // load sub-window's FXML
            AnchorPane pane2 = FXMLLoader.load(getClass().getResource("/com/isep/projectjavawallet/settingViews/profile-view.fxml"));
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

            if(ini){
                SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/WalletsViews/walletsList-view.fxml");
                ini = false;
            }else{
                SceneManager.changeSceneRightPart( SceneManager.getCurrentRightPart_walletsView() );
            }
            // load sub-window's FXML



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void LogoutButtonClick(){
        SceneManager.changeScene("/com/isep/projectjavawallet/loginViews/authentication.fxml","Authentification");
    }


    public AnchorPane getRightPartPane() {
        return rightPartPane;
    }

    public void setRightPartPane(AnchorPane rightPartPane) {
        this.rightPartPane = rightPartPane;
    }
}
