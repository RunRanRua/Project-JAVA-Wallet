package com.isep.projectjavawallet.controllers.wallet;

import com.isep.projectjavawallet.bean.wallet.Wallet;
import com.isep.projectjavawallet.bean.wallet.fiaWallet.Asset;
import com.isep.projectjavawallet.bean.wallet.fiaWallet.FiatWallet;
import com.isep.projectjavawallet.bean.wallet.fiaWallet.History;
import com.isep.projectjavawallet.bean.wallet.fiaWallet.transaction.Transaction;
import com.isep.projectjavawallet.dao.WalletDao;
import com.isep.projectjavawallet.util.IBANgeneration;
import com.isep.projectjavawallet.util.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class AddController {
     @FXML
    TextField wName;
     @FXML
    TextArea description;



     @FXML
    public void backButtonClick(){
         SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/waletPart/walletList-view.fxml");
     }
    @FXML
    public void createButtonClick() throws SQLException {
         String wnameTXT = wName.getText();
         String descriptionTXT = description.getText();

         if (wnameTXT.isEmpty() || descriptionTXT.isEmpty() || !Pattern.matches("^.{1,20}$",wnameTXT) || !Pattern.matches("^.{1,100}$",descriptionTXT)){
             Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setHeaderText(null);
             alert.setContentText("invalid name or description");
             alert.show();
             return;
         }

         Wallet wallet = new Wallet(wnameTXT,descriptionTXT, IBANgeneration.generateIBAN(), new FiatWallet(0,new Asset(),new History(new ArrayList<Transaction>())));
         new WalletDao().insertWallet(SceneManager.getHome().getProfile().getAccount().getUsername(), wallet);

         SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/waletPart/walletList-view.fxml");
    }



}
