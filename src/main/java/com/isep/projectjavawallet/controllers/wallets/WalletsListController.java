package com.isep.projectjavawallet.controllers.wallets;

import com.isep.projectjavawallet.util.WalletPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class WalletsListController implements Initializable {

    @FXML
    private ListView<WalletPane> listView;
    private final ObservableList<WalletPane> observableList = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView.setItems(observableList);
        listView.setFixedCellSize(100);
        WalletPane walletPane = new WalletPane();
        observableList.add(walletPane);
    }
}
