package com.isep.projectjavawallet.controllers.profile;

import com.isep.projectjavawallet.bean.setting.Help;
import com.isep.projectjavawallet.util.SceneManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HelpController implements Initializable {
    @FXML
    Label walletTXT;
    @FXML
    Label marketTXT;
    @FXML
    Label connectionTXT;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        walletTXT.setText(Help.helpForWallet);
        marketTXT.setText(Help.helpForMarket);
        connectionTXT.setText(Help.helpForConnection);
    }


    @FXML
    public void backButtonClick(){
        SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/profilePart/profile-view.fxml");
    }
}
