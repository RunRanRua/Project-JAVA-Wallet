package com.isep.projectjavawallet.controllers.wallets;

import com.isep.projectjavawallet.bean.wallet.Wallet;
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


    @FXML
    private Button DepositButton;
    @FXML
    private Button TransferButton;
    @FXML
    private Button CurrencyButton;
    @FXML
    private Button MyAssetsButton;
    @FXML
    private Button HistoryButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UserManager.setWalletDataController(this);
        amount.setText(String.valueOf(UserManager.getCurrentWallet().getAmount()));
        currency.setText(UserManager.getCurrentWallet().getReferenceCurrency());
    }
    @FXML
    public void DepositButtonClick(){
        SceneManager.anotherScene("/com/isep/projectjavawallet/WalletsViews/Depositview.fxml","Deposit");
    }
    @FXML
    public void CurrencyButtonClick(){
        SceneManager.changeScene("","");
    }
    @FXML
    public void TransferButtonClick(){
        SceneManager.anotherScene("/com/isep/projectjavawallet/WalletsViews/transfer-view.fxml","Transfer");
    }
    @FXML
    public void AssetsButtonClick(){
        SceneManager.changeScene("","");
    }
    @FXML
    public void HistoryButtonClick(){
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
