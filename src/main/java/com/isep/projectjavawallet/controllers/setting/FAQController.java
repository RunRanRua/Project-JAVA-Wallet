package com.isep.projectjavawallet.controllers.setting;

import com.isep.projectjavawallet.util.UserManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class FAQController implements Initializable {
    @FXML
    private Label forWallet;
    @FXML
    private Label forMarket;
    @FXML
    private Label forConnection;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        forWallet.setText(UserManager.getHome().getProfile().getHelp().getHelpForWallet());
        forMarket.setText(UserManager.getHome().getProfile().getHelp().getHelpForMarket());
        forConnection.setText(UserManager.getHome().getProfile().getHelp().getHelpForConnection());
    }
}
