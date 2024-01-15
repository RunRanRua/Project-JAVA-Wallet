package com.isep.projectjavawallet.controllers.login;

import com.isep.projectjavawallet.bean.Home;
import com.isep.projectjavawallet.bean.currency.ExchangeRate;
import com.isep.projectjavawallet.bean.market.Market;
import com.isep.projectjavawallet.bean.setting.Account;
import com.isep.projectjavawallet.bean.setting.Profile;
import com.isep.projectjavawallet.dao.AccountDao;
import com.isep.projectjavawallet.util.SceneManager;
import com.isep.projectjavawallet.util.UserManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class AuthenticationController {

    @FXML
    private TextField login;
    @FXML
    private PasswordField password;


    @FXML
    private void EnterPressed(KeyEvent e) throws IOException, SQLException {
        if (e.getCode() == KeyCode.ENTER){
            signInButtonClick();
        }
    }



    @FXML
    private void signInButtonClick() throws IOException, SQLException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);

        // account given by user
        String username = login.getText();
        String pwd = password.getText();


        // verify input account  (format + isEmpty)
        boolean isGoodFormat = !username.isEmpty() &&
                                !pwd.isEmpty()   &&
                                Pattern.matches("^.{1,15}$", username) &&
                                Pattern.matches("^.{6,15}$", pwd);
        if (!isGoodFormat){
            alert.setContentText("Error : Invalid username or password");
            alert.show();
            return;
        }

        // verify account's validity (search in dataBase)
        Account account = new AccountDao().findAccount(username);
        if (account == null || !account.getPassword().equals(pwd)){
            alert.setContentText("Error : username not found or wrong password");
            alert.show();
            return;
        }

        // if there is no problem
        loginSuccessful(account);
    }

    @FXML
    private void signUpButtonClick(){
        SceneManager.changeScene("/com/isep/projectjavawallet/loginViews/SignUp.fxml","Sign up");
    }

    private void loginSuccessful(Account account){
        /*
            - retrieve user data
            - create home
            - complete all info
         */

        Home home = new Home(new Profile(account),new Market(), new ArrayList<>(), new ExchangeRate());
        UserManager.setHome(home);
        SceneManager.changeScene("/com/isep/projectjavawallet/home-view.fxml","Home");
    }

}
