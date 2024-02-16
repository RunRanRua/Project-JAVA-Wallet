package com.isep.projectjavawallet.controllers.wallet;

import com.isep.projectjavawallet.bean.wallet.Wallet;
import com.isep.projectjavawallet.dao.WalletDao;
import com.isep.projectjavawallet.util.SceneManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DeleteController implements Initializable {
    @FXML
    Label wName;
    @FXML
    Label description;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Wallet wallet = SceneManager.getTargetWallet();
        wName.setText(wallet.getWalletName());
        description.setText(wallet.getDescription());
    }


    @FXML
    public void backButtonClick(){
        SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/waletPart/walletList-view.fxml");
    }

    @FXML
    public void confirmButtonClick() throws SQLException {
        Wallet wallet = SceneManager.getTargetWallet();
        new WalletDao().removeWallet(wallet.getIBAN());

        SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/waletPart/walletList-view.fxml");
    }
}
