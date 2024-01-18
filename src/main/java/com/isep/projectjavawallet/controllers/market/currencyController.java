package com.isep.projectjavawallet.controllers.market;

import com.isep.projectjavawallet.bean.currency.ExchangeRate;
import com.isep.projectjavawallet.bean.wallet.fiatWallet.assets.Stock;
import com.isep.projectjavawallet.util.UserManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class currencyController implements Initializable {
    @FXML
    private ListView<String> listView;
    private ObservableList<String> observableList = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView.setItems(observableList);
        listView.setFixedCellSize(50);

        for (ExchangeRate exchangeRate : UserManager.getHome().getExchangeRates()){
            observableList.add(exchangeRate.toString());
        }
    }
}
