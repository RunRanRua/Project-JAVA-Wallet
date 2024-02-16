package com.isep.projectjavawallet.controllers.market;

import com.isep.projectjavawallet.bean.market.ExchangeRate;
import com.isep.projectjavawallet.bean.market.Stock;
import com.isep.projectjavawallet.dao.StockMarketDao;
import com.isep.projectjavawallet.util.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class MarketController implements Initializable {
    @FXML
    private ListView<String> listView_stock;
    private final ObservableList<String> observableList_stock = FXCollections.observableArrayList();
    @FXML
    private ListView<String> listView_currency;
    private final ObservableList<String> observableList_currency = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        // load stocks data
        listView_stock.setItems(observableList_stock);
        listView_stock.setFixedCellSize(50);

        for (Stock stock : SceneManager.getHome().getMarket().getStocksInSale()){
            observableList_stock.add(stock.toString());
        }

        // load currency rate data
        listView_currency.setItems(observableList_currency);
        listView_currency.setFixedCellSize(50);

        for (ExchangeRate rate : SceneManager.getHome().getMarket().getCurrencyRates()){
            observableList_currency.add(rate.toString());
        }
    }
}
