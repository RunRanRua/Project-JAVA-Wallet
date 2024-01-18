package com.isep.projectjavawallet.controllers.market;

import com.crazzyghost.alphavantage.AlphaVantage;
import com.crazzyghost.alphavantage.AlphaVantageException;
import com.crazzyghost.alphavantage.Config;
import com.crazzyghost.alphavantage.parameters.Interval;
import com.crazzyghost.alphavantage.parameters.OutputSize;
import com.crazzyghost.alphavantage.timeseries.response.TimeSeriesResponse;
import com.isep.projectjavawallet.bean.setting.Account;
import com.isep.projectjavawallet.bean.wallet.fiatWallet.assets.Stock;
import com.isep.projectjavawallet.dao.MarketDao;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class MarketController implements Initializable {
     @FXML
     private ListView<String> listView;
     private ObservableList<String> observableList = FXCollections.observableArrayList();


     @Override
     public void initialize(URL url, ResourceBundle resourceBundle) {
          listView.setItems(observableList);
          listView.setFixedCellSize(50);

         String[] symbols = {"IBM","A","AMZN","GOOP","MSFT"};
         Stock stock;
         for (String symbol : symbols){
             try {
                 stock = new MarketDao().findStock(symbol);
             } catch (SQLException e) {
                 throw new RuntimeException(e);
             }

             observableList.add(stock.toString());
         }
     }
}
