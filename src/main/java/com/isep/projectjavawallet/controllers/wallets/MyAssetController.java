package com.isep.projectjavawallet.controllers.wallets;

import com.isep.projectjavawallet.bean.wallet.fiatWallet.assets.Stock;
import com.isep.projectjavawallet.util.SceneManager;
import com.isep.projectjavawallet.util.UserManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MyAssetController implements Initializable {

    @FXML
    private ListView<String> listView;
    private ObservableList<String> observableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView.setItems(observableList);
        listView.setFixedCellSize(50);

        ArrayList<Stock> stocks = UserManager.getCurrentWallet().getFiatWallet().getMyAsset().getStocks();
        String currency = UserManager.getCurrentWallet().getReferenceCurrency();
        for (Stock stock: stocks){
            observableList.add(stock.toString().replace("USD",currency));
        }
    }


    public void backButtonClick() {
        SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/WalletsViews/walletData.fxml");
    }
}
