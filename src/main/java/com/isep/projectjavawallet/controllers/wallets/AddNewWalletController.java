package com.isep.projectjavawallet.controllers.wallets;

import com.isep.projectjavawallet.bean.wallet.CryptoWallet;
import com.isep.projectjavawallet.bean.wallet.Wallet;
import com.isep.projectjavawallet.bean.wallet.fiatWallet.FiatWallet;
import com.isep.projectjavawallet.bean.wallet.fiatWallet.History;
import com.isep.projectjavawallet.dao.WalletListDao;
import com.isep.projectjavawallet.util.UserManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class AddNewWalletController {
    @FXML
    private TextField name;
    @FXML
    private TextArea description;



    @FXML
    public void confirmButtonClick() throws SQLException {
        String Wname = name.getText();
        String Wdescription = description.getText();
        Wallet wallet = new Wallet(Wname,Wdescription,new FiatWallet(), new CryptoWallet(), new History());
        String username = UserManager.getHome().getProfil().getAccount().getUsername();
        // Add contents into SQL
        boolean isSuccessful = new WalletListDao().insertWallet(username,wallet);
        if (isSuccessful){
            UserManager.getHome().getWallets().add(wallet); // back-end list (Wallet)
            UserManager.getWalletPanes().getLast().update_ADD(Wname, Wdescription); // back-end list (Wallet Pane)
            UserManager.getWalletsListController().addwalletPane(); // front-end (wallet Pane)

            // Close the window
            Stage currentWindow = (Stage) name.getScene().getWindow();
            currentWindow.close();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Failed to add in our data base, it could be a bug.");
            alert.show();
        }

    }


    @FXML
    public void cancelButtonClick(){
        // Close the window
        Stage currentWindow = (Stage) name.getScene().getWindow();
        currentWindow.close();
    }



}
