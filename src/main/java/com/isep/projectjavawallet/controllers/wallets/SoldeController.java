package com.isep.projectjavawallet.controllers.wallets;

import com.isep.projectjavawallet.util.SceneManager;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SoldeController implements Initializable {
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

    }
    @FXML
    public void DepositButtonClick(){
        SceneManager.changeScene("","");
    }
    @FXML
    public void CurrencyButtonClick(){
        SceneManager.changeScene("","");
    }
    @FXML
    public void TransferButtonClick(){
        SceneManager.changeScene("","");
    }
    @FXML
    public void AssetsButtonClick(){
        SceneManager.changeScene("","");
    }
    @FXML
    public void HistoryButtonClick(){
        SceneManager.changeScene("","");
    }

}
