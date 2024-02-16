package com.isep.projectjavawallet.controllers.wallet;

import com.isep.projectjavawallet.bean.wallet.Wallet;
import com.isep.projectjavawallet.bean.wallet.fiaWallet.History;
import com.isep.projectjavawallet.bean.wallet.fiaWallet.transaction.Transaction;
import com.isep.projectjavawallet.dao.HistoryDao;
import com.isep.projectjavawallet.util.SceneManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.util.Pair;

import java.net.URL;
import java.sql.SQLException;
import java.util.*;

public class WalletController implements Initializable {
    @FXML
    Label balance;
    @FXML
    Label currency;
    @FXML
    LineChart<String,Number> chart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Wallet wallet = SceneManager.getTargetWallet();
        balance.setText(String.valueOf( wallet.getFiatWallet().getBalance() ));
        currency.setText(wallet.getFiatWallet().getReferenceCurrency().toString());

        History history = wallet.getFiatWallet().getHistory();

        try {
            history.setTransactions(new HistoryDao().loadHistoryData(wallet.getIBAN()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // for chart
        XYChart.Series<String, Number> series = new XYChart.Series<>();


        ArrayList<Pair<String,Double>> data = history.visualazation();
        int length = data.size();
        if (length <=5){
            for (Pair<String,Double> pair : data){
                String date = pair.getKey();
                double amount = pair.getValue();
                series.getData().add(new XYChart.Data<>(date,amount));
            }
        }else{
            for (int i = length-5; i<length;i++){
                Pair<String,Double> pair = data.get(i);
                String date = pair.getKey();
                double amount = pair.getValue();
                series.getData().add(new XYChart.Data<>(date,amount));
            }
        }
        chart.getData().add(series);



    }


    @FXML
    public void historyButtonClick(){
        SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/waletPart/history-view.fxml");
    }
    @FXML
    public void depositButtonClick(){
        SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/waletPart/deposit-view.fxml");
    }
    @FXML
    public void transferButtonClick(){
        SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/waletPart/transfer-view.fxml");
    }
    @FXML
    public void assetButtonClick(){
        SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/waletPart/myAsset-view.fxml");
    }
    @FXML
    public void infoButtonClick(){
        SceneManager.anotherScene("/com/isep/projectjavawallet/waletPart/info-view.fxml","wallet info");
    }
    @FXML
    public void backButtonClick(){
        SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/waletPart/walletList-view.fxml");
    }
}
