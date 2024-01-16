package com.isep.projectjavawallet.controllers.wallets;

import com.isep.projectjavawallet.bean.wallet.Wallet;
import com.isep.projectjavawallet.util.UserManager;
import com.isep.projectjavawallet.util.WalletPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class WalletsListController implements Initializable {
    private int count;  // this variable count number of panes

    @FXML
    private ListView<WalletPane> listView;
    private final ObservableList<WalletPane> observableList = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView.setItems(observableList);
        listView.setFixedCellSize(100);
        UserManager.setWalletsListController(this);

        for (Wallet wallet : UserManager.getHome().getWallets()){
            // create a walletPane
            WalletPane walletPane = new WalletPane(count);
            count++;

            // add in list
            observableList.add(walletPane);     // in Front-end list
            UserManager.getWalletPanes().add(walletPane);   // in Back-end list

            // update walletPane (by loading)
            walletPane.update_LOAD(wallet);
        }

        // a new wallet after all existed walletPane
        WalletPane newPane = new WalletPane(count);
        count++;

        // add in lists
        observableList.add(newPane);       // in Front-end list
        UserManager.getWalletPanes().add(newPane);  // in Back-end list
    }


    public void addwalletPane(){
        observableList.add(new WalletPane(count));
        count++;
    }
    public void removeWalletPane(WalletPane walletPane){
        observableList.remove(walletPane);
    }


    public ListView<WalletPane> getListView() {
        return listView;
    }
}
