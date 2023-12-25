package com.isep.projectjavawallet.controllers.setting;

import com.isep.projectjavawallet.bean.setting.Profil;
import com.isep.projectjavawallet.util.SceneManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfilController implements Initializable {
    private Profil profil;
    @FXML
    private Button changeMailButton;
    @FXML
    private Button changePWDButton;
    @FXML
    private Button policyButton;
    @FXML
    private Button aboutUsButton;
    @FXML
    private Button helpsButton;
    @FXML
    private Button logOutButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize profil
        profil = new Profil();

        // Initialize other variables

    }


    @FXML
    public void policyButtonClick(){
        SceneManager.anotherScene("/com/isep/projectjavawallet/settingViews/policy-view.fxml","Policy");
    }
    @FXML
    public void aboutUsButtonClick(){
        SceneManager.anotherScene("/com/isep/projectjavawallet/settingViews/aboutUs-view.fxml","Policy");
    }
    @FXML
    public void helpsButtonClick(){
        SceneManager.anotherScene("/com/isep/projectjavawallet/settingViews/helps-view.fxml","Policy");
    }

    @FXML
    public void changeMailButtonClick(){
        SceneManager.anotherScene("/com/isep/projectjavawallet/settingViews/changeMail-view.fxml","Policy");
    }
    @FXML
    public void changePWDButtonClick(){
        SceneManager.anotherScene("/com/isep/projectjavawallet/settingViews/changePWD-view.fxml","Policy");
    }





    // To be continued (wait SceneManger.changeScene()  )
    @FXML
    public void logOutButtonClick(){

    }




}
