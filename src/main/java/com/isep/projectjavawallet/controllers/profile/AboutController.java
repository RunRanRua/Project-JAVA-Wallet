package com.isep.projectjavawallet.controllers.profile;

import com.isep.projectjavawallet.bean.setting.About;
import com.isep.projectjavawallet.bean.setting.Help;
import com.isep.projectjavawallet.util.SceneManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class AboutController implements Initializable {
    @FXML
    Label appTXT;
    @FXML
    Label teamTXT;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        appTXT.setText(About.aboutApp);
        teamTXT.setText(About.aboutTeam);
    }

    @FXML
    public void backButtonClick(){
        SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/profilePart/profile-view.fxml");
    }

}
