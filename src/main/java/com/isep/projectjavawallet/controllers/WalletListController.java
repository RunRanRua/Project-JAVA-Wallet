package com.isep.projectjavawallet.controllers;

import com.isep.projectjavawallet.bean.wallet.Wallet;
import com.isep.projectjavawallet.util.SceneManager;
import com.isep.projectjavawallet.util.WalletPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class WalletListController implements Initializable {
    @FXML
    private ListView<WalletPane> listView;
    private final ObservableList<WalletPane> observableList = FXCollections.observableArrayList();

    private int selectedIndex = -1;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView.setItems(observableList);
        listView.setFixedCellSize(100);

        // load wallets
        try {
            SceneManager.getHome().loadWalletsData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for(Wallet wallet : SceneManager.getHome().getWallets()){
            WalletPane walletPane = new WalletPane();
            walletPane.setWallet(wallet);
            walletPane.getWalletName().setText(wallet.getWalletName());
            observableList.add(walletPane);
        }


        // get selected wallet
        MultipleSelectionModel<WalletPane> selectionModel = listView.getSelectionModel();
        selectionModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedIndex = selectionModel.getSelectedIndex();
        });

    }



    @FXML
    public void addButtonClick(){
        SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/waletPart/add-view.fxml");

    }
    @FXML
    public void removeButtonClick(){
        if (selectedIndex == -1){
            return;
        }

        Wallet targetWallet = SceneManager.getHome().getWallets().get(selectedIndex);
        SceneManager.setTargetWallet(targetWallet);
        SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/waletPart/delete-view.fxml");
    }
    @FXML
    public void infoButtonClick(){
        if (selectedIndex == -1){
            return;
        }

        Wallet targetWallet = SceneManager.getHome().getWallets().get(selectedIndex);
        SceneManager.setTargetWallet(targetWallet);
        SceneManager.anotherScene("/com/isep/projectjavawallet/waletPart/info-view.fxml","wallet info");
    }
    @FXML
    public void enterButtonClick(){
        if (selectedIndex == -1){
            return;
        }

        Wallet targetWallet = SceneManager.getHome().getWallets().get(selectedIndex);
        SceneManager.setTargetWallet(targetWallet);
        SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/waletPart/wallet-view.fxml");
    }
}
