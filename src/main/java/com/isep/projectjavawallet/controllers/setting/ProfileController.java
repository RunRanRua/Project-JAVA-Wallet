package com.isep.projectjavawallet.controllers.setting;

import com.isep.projectjavawallet.bean.setting.Profile;
import com.isep.projectjavawallet.util.SceneManager;
import com.isep.projectjavawallet.util.UpdateManager;
import com.isep.projectjavawallet.util.UserManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {
    private Profile profile;

    @FXML
    private Label name;
    @FXML
    private Label username;
    @FXML
    private Label mail;

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
        // Initialize profile
        profile = UserManager.getHome().getProfil();
        name.setText(profile.getAccount().getName());
        username.setText(profile.getAccount().getUsername());
        mail.setText(profile.getAccount().getMail());

        UpdateManager.setProfileController(this);

    }


    @FXML
    public void policyButtonClick(){
        SceneManager.anotherScene("/com/isep/projectjavawallet/settingViews/policy-view.fxml","Policy");
    }
    @FXML
    public void aboutUsButtonClick(){
        SceneManager.anotherScene("/com/isep/projectjavawallet/settingViews/aboutUs-view.fxml","About us");
    }
    @FXML
    public void helpsButtonClick(){
        SceneManager.anotherScene("/com/isep/projectjavawallet/settingViews/FAQ-view.fxml","FAQ");
    }

    @FXML
    public void changeMailButtonClick(){
        SceneManager.anotherScene("/com/isep/projectjavawallet/settingViews/changeMail-view.fxml","modify mail");
    }
    @FXML
    public void changePWDButtonClick(){
        SceneManager.anotherScene("/com/isep/projectjavawallet/settingViews/changePWD-view.fxml","Reset password");
    }



    // getters

    public Label getMail() {
        return mail;
    }
}
