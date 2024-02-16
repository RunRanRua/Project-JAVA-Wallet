package com.isep.projectjavawallet.controllers.wallet;

import com.isep.projectjavawallet.bean.wallet.Wallet;
import com.isep.projectjavawallet.bean.wallet.fiaWallet.transaction.TransactionType;
import com.isep.projectjavawallet.dao.HistoryDao;
import com.isep.projectjavawallet.dao.WalletDao;
import com.isep.projectjavawallet.util.SceneManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class DepositController implements Initializable {
    @FXML
    Label currency;
    @FXML
    TextField depositAmount;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        currency.setText(SceneManager.getTargetWallet().getFiatWallet().getReferenceCurrency().toString());
    }

    @FXML
    public void cancelButtonClick(){
        SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/waletPart/wallet-view.fxml");
    }
    @FXML
    public void depositButtonClick() throws SQLException {
        String amount_TXT = depositAmount.getText();
        if (amount_TXT.isEmpty() || !Pattern.matches("^\\d*\\.?\\d+$",amount_TXT)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid number.");
            alert.show();
            return;
        }

        Wallet wallet = SceneManager.getTargetWallet();
        double amount = Double.parseDouble(amount_TXT);

        // update class
        wallet.getFiatWallet().deposit(amount);
        // update wallet db
        new WalletDao().depositWallet(wallet.getIBAN(),amount);
        // update history db
        new HistoryDao().insertHistoryData(wallet, TransactionType.DEPOSIT);

        SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/waletPart/wallet-view.fxml");
    }
}
