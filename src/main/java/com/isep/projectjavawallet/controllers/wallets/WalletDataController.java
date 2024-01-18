package com.isep.projectjavawallet.controllers.wallets;

import com.isep.projectjavawallet.util.SceneManager;
import com.isep.projectjavawallet.util.UserManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class WalletDataController implements Initializable {

    @FXML
    private Label amount;

    @FXML
    private Label currency;





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UserManager.setWalletDataController(this);
        amount.setText(String.valueOf(UserManager.getCurrentWallet().getAmount()));
        currency.setText(UserManager.getCurrentWallet().getReferenceCurrency());
    }




    public void updateAmount(String amount){
        this.amount.setText(amount);
    }


    @FXML
    public void depositButtonClick(){
        SceneManager.anotherScene("/com/isep/projectjavawallet/WalletsViews/Depositview.fxml","Deposit");
    }
    @FXML
    public void buyStockButtonClick(){
        SceneManager.anotherScene("/com/isep/projectjavawallet/WalletsViews/buyStock-view.fxml","buy stocks");
    }
    @FXML
    public void transferButtonClick(){
        SceneManager.anotherScene("/com/isep/projectjavawallet/WalletsViews/transfer-view.fxml","Transfer");
    }
    @FXML
    public void assetsButtonClick(){
        SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/WalletsViews/myAsset-view.fxml");
    }
    @FXML
    public void historyButtonClick(){
        SceneManager.changeScene("","");
    }

    public void backButtonClick() {
        SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/WalletsViews/walletsList-view.fxml");
    }







    public Label getAmount() {
        return amount;
    }

    public Label getCurrency() {
        return currency;
    }


}
