package com.isep.projectjavawallet.controllers.setting;

import com.isep.projectjavawallet.util.UserManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class aboutUsController implements Initializable {
    @FXML
    private Label aboutApp;
    @FXML
    private Label aboutTeam;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        aboutApp.setText(UserManager.getHome().getProfile().getAbout().getAboutApp());
        aboutTeam.setText(UserManager.getHome().getProfile().getAbout().getAboutTeam());
    }
}
