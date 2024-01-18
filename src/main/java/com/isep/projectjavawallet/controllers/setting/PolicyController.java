package com.isep.projectjavawallet.controllers.setting;

import com.isep.projectjavawallet.util.UserManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class PolicyController implements Initializable {

    @FXML
    private Label personalInfo;
    @FXML
    private Label security;
    @FXML
    private Label accountDeletion;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        personalInfo.setText(UserManager.getHome().getProfile().getPolicy().getPersonalInformation());
        security.setText(UserManager.getHome().getProfile().getPolicy().getSecurity());
        accountDeletion.setText(UserManager.getHome().getProfile().getPolicy().getAccountDeletion());
    }
}
