package com.isep.projectjavawallet.controllers.loggin;

import com.isep.projectjavawallet.bean.setting.Account;
import com.isep.projectjavawallet.dao.AccountDao;
import com.isep.projectjavawallet.util.AccountVerification;
import com.isep.projectjavawallet.util.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.sql.SQLException;

public class SignUpController {

    @FXML
    private TextField name;

    @FXML
    private TextField username;
    @FXML
    private TextField mail;
    @FXML
    private TextField pwd;
    @FXML
    private TextField verify_pwd;

    @FXML
    private void clearButtonOnClick(){
        name.setText(null);
        username.setText(null);
        mail.setText(null);
        pwd.setText(null);
        verify_pwd.setText(null);
    }

    @FXML
    private void createButtonOnClick() throws SQLException {
        String name_str = name.getText();
        String username_str = username.getText();
        String mail_str = mail.getText();
        String pwd_str = pwd.getText();
        String verify_pwd_str = verify_pwd.getText();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);


        boolean isAllValid = AccountVerification.isValidName(name_str) &&
                             AccountVerification.isValidMail(mail_str) &&
                             AccountVerification.isValidPWD(pwd_str) &&
                             AccountVerification.isValidUsername(username_str) &&
                             AccountVerification.isSamePWD(pwd_str,verify_pwd_str);

        if (!isAllValid){
            alert.setContentText("Please, check your data.");
            alert.show();
            return;
        }

        Account account = new Account(username_str,pwd_str,name_str,mail_str);
        boolean isSuccessful = new AccountDao().insertAccount(account);
        if (!isSuccessful){
            alert.setContentText("Sorry, the username already exists, please change a new username.");
            alert.show();
        }else{
            SceneManager.changeScene("/com/isep/projectjavawallet/loginPart/authentication.fxml","Authentification");
        }

    }

    @FXML
    private void BackonButtonClick(){
        SceneManager.changeScene("/com/isep/projectjavawallet/loginPart/authentication.fxml","Authentification");
    }

    @FXML
    private void EnterPressed(KeyEvent e) throws SQLException {
        if (e.getCode() == KeyCode.ENTER){
            createButtonOnClick();
        }
    }
}
