package com.isep.projectjavawallet.controllers.wallets;

import com.isep.projectjavawallet.bean.wallet.Wallet;
import com.isep.projectjavawallet.util.UserManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class WalletInfoController implements Initializable {

    @FXML
    Label name;
    @FXML
    Label description;
    @FXML
    Label IBAN;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int id = UserManager.getWalletPaneID();
        name.setText(UserManager.getHome().getWallets().get(id).getWalletName());
        description.setText(UserManager.getHome().getWallets().get(id).getDescription());
        IBAN.setText(UserManager.getHome().getWallets().get(id).getIBAN());
    }

    @FXML
    public void backButtonClick(){
        // Close the window
        Stage currentWindow = (Stage) name.getScene().getWindow();
        currentWindow.close();
    }
}


