package com.isep.projectjavawallet.controllers.profile;

import com.isep.projectjavawallet.bean.setting.About;
import com.isep.projectjavawallet.bean.setting.Policy;
import com.isep.projectjavawallet.util.SceneManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class PolicyController implements Initializable {
    @FXML
    Label personalInfo;
    @FXML
    Label security;
    @FXML
    Label accountDeletion;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        personalInfo.setText(Policy.personalInformation);
        security.setText(Policy.security);
        accountDeletion.setText(Policy.accountDeletion);
    }

    @FXML
    public void backButtonClick(){
        SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/profilePart/profile-view.fxml");
    }
}
