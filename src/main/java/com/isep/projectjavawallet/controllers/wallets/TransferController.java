package com.isep.projectjavawallet.controllers.wallets;

import com.isep.projectjavawallet.bean.wallet.Wallet;
import com.isep.projectjavawallet.dao.WalletDataDao;
import com.isep.projectjavawallet.util.UserManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class TransferController implements Initializable {

    @FXML
    private TextField IBANToTransfer;
    @FXML
    private TextField transferAmount;
    @FXML
    private Label currency;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        currency.setText(UserManager.getCurrentWallet().getReferenceCurrency());
    }

    public void transferButtonClick() throws SQLException {
        String IBANToTransfer_str = IBANToTransfer.getText();
        String transferAmount_str = transferAmount.getText();
        
        if(!isValidAmount(transferAmount_str)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid number.");
            alert.show();
            return;
        }
        if (!isValidIBAN(IBANToTransfer_str)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid IBAN.");
            alert.show();
            return;
        }
        // enough amount ?
        double amount = Double.parseDouble(transferAmount_str);
        if (UserManager.getCurrentWallet().getAmount() - amount <0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Invalid transfer: you have not such amount!");
            alert.show();
            return;
        }
        // IBAN exists?
        if ( !(new WalletDataDao().isIBANExist(IBANToTransfer_str)) ){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Invalid transfer: this IBAN is not saved in our data base!");
            alert.show();
            return;
        }


        boolean isSuccessful1 = new WalletDataDao().removeAmount(UserManager.getCurrentWallet(), amount);
        boolean isSuccessful2 = new WalletDataDao().addAmount(IBANToTransfer_str, amount);
        if (isSuccessful1 && isSuccessful2){

            double amountAfterRemove = UserManager.getCurrentWallet().getAmount() - amount;

            // update in wallet (front-end)
            UserManager.getWalletDataController().getAmount().setText(String.valueOf(amountAfterRemove));

            // update in wallet (back-end)
            UserManager.getCurrentWallet().setAmount(amountAfterRemove);

            // if corresponding IBAN is in the same account
            for(Wallet wallet : UserManager.getHome().getWallets()){
                if (wallet.getIBAN().equals(IBANToTransfer_str)){
                    wallet.setAmount(wallet.getAmount() + amount);
                    break;
                }
            }

            // Close the window
            Stage currentWindow = (Stage) currency.getScene().getWindow();
            currentWindow.close();
        }



    }

    public void cancelButtonClick() {
        Stage currentWindow = (Stage) currency.getScene().getWindow();
        currentWindow.close();
    }


    private boolean isValidIBAN(String IBAN){
        return (IBAN.isEmpty() || !Pattern.matches("[A-Z0-9]{28}",IBAN));
    }
    private boolean isValidAmount(String amount){
        return !amount.isEmpty() && Pattern.matches("^\\d*\\.?\\d+$", amount);
    }
}
