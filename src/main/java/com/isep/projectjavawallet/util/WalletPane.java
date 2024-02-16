package com.isep.projectjavawallet.util;

import com.isep.projectjavawallet.bean.wallet.Wallet;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

import java.sql.SQLException;
import java.util.Objects;

public class WalletPane extends Pane {
    Wallet wallet;
    private final Label walletName;

    public WalletPane(){
        walletName = new Label();

        Image walletIcon = new Image(getClass().getResourceAsStream("/com/isep/projectjavawallet/imgs/walletIcon.png"));
        ImageView walletView = new ImageView(walletIcon);


        // walletIcon
        walletView.setFitHeight(70);
        walletView.setFitWidth(75);
        walletView.setLayoutX(40);
        walletView.setLayoutY(5);

        // walletName
        walletName.setLayoutX(150);
        walletName.setLayoutY(22);
        walletName.prefHeight(45);
        walletName.prefWidth(90);
        walletName.setText("walletName");
        walletName.setFont(new Font("System Bold",36));

        this.getChildren().addAll(walletName, walletView);
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Label getWalletName() {
        return walletName;
    }
}
