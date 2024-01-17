package com.isep.projectjavawallet.controllers.wallets;

import com.isep.projectjavawallet.dao.WalletDataDao;
import com.isep.projectjavawallet.util.UserManager;
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

public class DepositController implements Initializable {
    @FXML
    private TextField depositAmount;

    @FXML
    private Label currency;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        currency.setText(UserManager.getCurrentWallet().getReferenceCurrency());
    }

    @FXML
    private void depositButtonClick() throws SQLException {
        String depositAmount_str = depositAmount.getText();

        if(!isValidAmount(depositAmount_str)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid number.");
            alert.show();
            return;
        }

        double amount = Double.parseDouble(depositAmount_str);
        boolean isSuccessful = new WalletDataDao().depositAmount(UserManager.getCurrentWallet(),amount);
        if (isSuccessful){
            double newAmount = UserManager.getCurrentWallet().getAmount() + amount;

            // update in wallet (back-end)
            UserManager.getCurrentWallet().setAmount(newAmount);
            // update in wallet (front-end)
            UserManager.getWalletDataController().getAmount().setText(String.valueOf(newAmount));

            // Close the window
            Stage currentWindow = (Stage) currency.getScene().getWindow();
            currentWindow.close();
        }
    }
    @FXML
    private void cancelButtonClick(){
        // Close the window
        Stage currentWindow = (Stage) currency.getScene().getWindow();
        currentWindow.close();
    }



    private boolean isValidAmount(String amount){
        return (amount.isEmpty() || !Pattern.matches("^\\d*\\.?\\d+$", amount)) ? false : true;
    }
}
