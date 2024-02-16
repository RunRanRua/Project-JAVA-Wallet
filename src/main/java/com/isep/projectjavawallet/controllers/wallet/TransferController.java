package com.isep.projectjavawallet.controllers.wallet;

import com.isep.projectjavawallet.bean.wallet.Wallet;
import com.isep.projectjavawallet.bean.wallet.fiaWallet.transaction.TransactionType;
import com.isep.projectjavawallet.dao.HistoryDao;
import com.isep.projectjavawallet.dao.WalletDao;
import com.isep.projectjavawallet.util.AccountVerification;
import com.isep.projectjavawallet.util.IBANgeneration;
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

public class TransferController implements Initializable {
    @FXML
    TextField toIBAN;
    @FXML
    TextField transferAmount;
    @FXML
    Label currency;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        currency.setText(SceneManager.getTargetWallet().getFiatWallet().getReferenceCurrency().toString());
    }

    @FXML
    public void cancelButtonClick(){
        SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/waletPart/wallet-view.fxml");
    }
    @FXML
    public void transferButtonClick() throws SQLException {
        Wallet wallet = SceneManager.getTargetWallet();
        String IBAN = toIBAN.getText();
        String amount_TXT = transferAmount.getText();


        if ( !isValidIBAN(IBAN) || !isValidTransferAmount(amount_TXT)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Invalid IBAN or amount.");
            alert.show();
            return;
        }

        double amount = Double.parseDouble(amount_TXT);

        // update class
        wallet.getFiatWallet().transfer(amount);

        // update wallet db : fromIBAN
        new WalletDao().depositWallet(wallet.getIBAN(),-amount);
        // update wallet db : toIBAN
        new WalletDao().depositWallet(IBAN,amount);

        // update history db : fromIBAN
        new HistoryDao().insertHistoryData(wallet, TransactionType.TRANSFER);
        // update history db : toIBAN
        Wallet toWallet = new WalletDao().findWallet(IBAN);
        new HistoryDao().insertHistoryData(toWallet,TransactionType.TRANSFER);



        SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/waletPart/wallet-view.fxml");
    }



    private boolean isValidIBAN(String IBAN) throws SQLException {
        Wallet wallet = SceneManager.getTargetWallet();
        return !IBAN.isEmpty() && !IBAN.equals(wallet.getIBAN()) && IBANgeneration.isIBANExisted(IBAN);
    }
    private boolean isValidTransferAmount(String amount){
        Wallet wallet = SceneManager.getTargetWallet();
        double balance = wallet.getFiatWallet().getBalance();
        return !amount.isEmpty() && Pattern.matches("^\\d*\\.?\\d+$",amount) && Double.parseDouble(amount) <= balance;
    }

}
