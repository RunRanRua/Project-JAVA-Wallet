package com.isep.projectjavawallet.controllers.wallet;

import com.isep.projectjavawallet.bean.market.Stock;
import com.isep.projectjavawallet.bean.wallet.Wallet;
import com.isep.projectjavawallet.dao.AssetDao;
import com.isep.projectjavawallet.util.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.sql.SQLException;
import java.util.*;

public class AssetController implements Initializable {
    @FXML
    ListView<String> listView;
    ObservableList<String> observableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView.setItems(observableList);
        listView.setFixedCellSize(50);

        Wallet wallet = SceneManager.getTargetWallet();

        try {
            wallet.getFiatWallet().getMyAsset().setStocks(new AssetDao().loadStocks(wallet.getIBAN()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for (Stock stock : wallet.getFiatWallet().getMyAsset().getStocks()){
            observableList.add(stock.toString_own());
        }
    }


    @FXML
    public void backButtonClick(){
        SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/waletPart/wallet-view.fxml");
    }
    @FXML
    public void purchaseButtonClick(){
        SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/waletPart/buyStock-view.fxml");
    }
    @FXML
    public void sellButtonClick(){
        SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/waletPart/sellStock-view.fxml");
    }
}
