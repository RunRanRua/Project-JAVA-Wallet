package com.isep.projectjavawallet.util;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

import java.util.Objects;

public class WalletPane extends Pane {
    private Button addButton;
    private Button removeButton;
    private Button infoButton;
    private Button enterButton;
    private Label walletName;
    private Label walletDescription;



    public WalletPane(){
        addButton = new Button();
        removeButton = new Button();
        infoButton = new Button();
        enterButton = new Button();
        walletName = new Label();
        walletDescription = new Label();

        Image walletIcon = new Image(getClass().getResourceAsStream("/com/isep/projectjavawallet/imgs/walletIcon.png"));
        ImageView walletView = new ImageView(walletIcon);

        // nodes' position

        // walletIcon
        walletView.setFitHeight(70);
        walletView.setFitWidth(75);
        walletView.setLayoutX(0);
        walletView.setLayoutY(5);

        // addButton
        addButton.setLayoutX(415);
        addButton.setLayoutY(15);
        Image addIcon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/isep/projectjavawallet/imgs/addIcon.png")));
        ImageView addView = new ImageView(addIcon);
        addView.setFitHeight(50);
        addView.setFitWidth(50);
        addButton.setGraphic(addView);

        // removeButton
        removeButton.setLayoutX(415);
        removeButton.setLayoutY(15);
        Image removeIcon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/isep/projectjavawallet/imgs/delIcon.png")));
        ImageView removeView = new ImageView(removeIcon);
        removeView.setFitHeight(50);
        removeView.setFitWidth(50);
        removeButton.setGraphic(removeView);
        removeButton.setVisible(false);

        // infoButton
        infoButton.setLayoutX(350);
        infoButton.setLayoutY(15);
        Image infoIcon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/isep/projectjavawallet/imgs/infoIcon.png")));
        ImageView infoView = new ImageView(infoIcon);
        infoView.setFitHeight(50);
        infoView.setFitWidth(50);
        infoButton.setGraphic(infoView);
        infoButton.setVisible(false);

        // enterButton
        enterButton.setLayoutX(285);
        enterButton.setLayoutY(15);
        Image enterIcon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/isep/projectjavawallet/imgs/enterIcon.png")));
        ImageView enterView = new ImageView(enterIcon);
        enterView.setFitHeight(50);
        enterView.setFitWidth(50);
        enterButton.setGraphic(enterView);
        enterButton.setVisible(false);

        // walletName
        walletName.setLayoutX(100);
        walletName.setLayoutY(25);
        walletName.prefHeight(45);
        walletName.prefWidth(90);
        walletName.setText("walletName");       // MAX 10 letters
        walletName.setFont(new Font("System Bold",28));

        this.getChildren().addAll(addButton,removeButton,infoButton,enterButton,walletName, walletView);

        // Buttons' action
        addButton.setOnAction(e ->
        {
            addButtonAction();
        });


        removeButton.setOnAction(e ->
        {
            removeButtonAction();
        });


        infoButton.setOnAction(e ->
        {
            infoButtonAction();
        });

        enterButton.setOnAction(e ->
        {
            enterButtonAction();
        });


    }



    // Not finished yet
    private void addButtonAction(){
        try {
            // show new_wallet window
            SceneManager.anotherScene("/com/isep/projectjavawallet/WalletsViews/addNewWallet-view.fxml","New wallet");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private void removeButtonAction() {
    }
    private void infoButtonAction() {
    }
    private void enterButtonAction() {

    }

    public void updateADD(){

    }
}
