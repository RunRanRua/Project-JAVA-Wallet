package com.isep.projectjavawallet.controllers.wallets;

import com.isep.projectjavawallet.util.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddNewWalletController {
    @FXML
    private TextField name;
    @FXML
    private TextArea description;
    @FXML
    private Button confirmButton;
    @FXML
    private  Button cancelButton;


    @FXML
    public void confirmButtonClick(){
        // Add contents into SQL

        // Transfer contents to WalletPane


        // Close the window
        Stage currentWindow = (Stage) confirmButton.getScene().getWindow();
        currentWindow.close();
    }


    @FXML
    public void cancelButtonClick(){
        // Close the window
        Stage currentWindow = (Stage) confirmButton.getScene().getWindow();
        currentWindow.close();
    }



}
