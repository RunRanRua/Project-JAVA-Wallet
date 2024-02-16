package com.isep.projectjavawallet.controllers.profile;

import com.isep.projectjavawallet.bean.setting.Account;
import com.isep.projectjavawallet.util.SceneManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {

    @FXML
    Label name;
    @FXML
    Label username;
    @FXML
    Label mail;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

            Account acc = SceneManager.getHome().getProfile().getAccount();
            // load data
            name.setText(acc.getName());
            username.setText(acc.getUsername());
            mail.setText(acc.getMail());
    }



    @FXML
    public void resetMailButtonClick(){
        SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/profilePart/changeMail-view.fxml");
    }
    @FXML
    public void resetPWDButtonClick(){
        SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/profilePart/changePWD-view.fxml");
    }
    @FXML
    public void policyButtonClick(){
        SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/profilePart/policy-view.fxml");
    }
    @FXML
    public void helpButtonClick(){
        SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/profilePart/help-view.fxml");
    }
    @FXML
    public void aboutButtonClick(){
        SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/profilePart/about-view.fxml");
    }
}
