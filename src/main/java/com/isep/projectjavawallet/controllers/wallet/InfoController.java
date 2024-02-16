package com.isep.projectjavawallet.controllers.wallet;

import com.isep.projectjavawallet.bean.wallet.Wallet;
import com.isep.projectjavawallet.util.SceneManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class InfoController implements Initializable {
    @FXML
    Label wName;
    @FXML
    Label IBAN;
    @FXML
    Label description;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Wallet wallet = SceneManager.getTargetWallet();
        wName.setText(wallet.getWalletName());
        IBAN.setText(wallet.getIBAN());
        description.setText(wallet.getDescription());
    }
}
