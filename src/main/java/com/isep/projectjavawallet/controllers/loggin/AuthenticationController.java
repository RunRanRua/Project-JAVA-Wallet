package com.isep.projectjavawallet.controllers.loggin;

import com.isep.projectjavawallet.bean.Home;
import com.isep.projectjavawallet.bean.market.ExchangeRate;
import com.isep.projectjavawallet.bean.market.Market;
import com.isep.projectjavawallet.bean.market.Stock;
import com.isep.projectjavawallet.bean.setting.Account;
import com.isep.projectjavawallet.bean.setting.Profile;
import com.isep.projectjavawallet.bean.wallet.Wallet;
import com.isep.projectjavawallet.dao.AccountDao;
import com.isep.projectjavawallet.util.AccountVerification;
import com.isep.projectjavawallet.util.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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


        // is input value valid (no empty + good format)
        if (!AccountVerification.isValidUsername(username) || !AccountVerification.isValidPWD(pwd)){
            alert.setContentText("Error : Invalid username or password");
            alert.show();
            return;
        }

        // does the account exist + correct pwd
        Account account = new AccountDao().findAccount(username);
        if (account == null || !account.getPassword().equals(pwd)){
            alert.setContentText("Error : username not found or wrong password");
            alert.show();
            return;
        }

        // connect successful
        Home home = new Home(new Profile(account),
                             new Market(new ArrayList<Stock>(), new ArrayList<ExchangeRate>()),
                             new ArrayList<Wallet>() );
        SceneManager.setHome(home);

            // load market data
        home.getMarket().loadStocksData();
        home.getMarket().loadRateData();

        SceneManager.changeScene("/com/isep/projectjavawallet/home-view.fxml","Home");
    }

    @FXML
    private void signUpButtonClick(){
        SceneManager.changeScene("/com/isep/projectjavawallet/loginPart/SignUp.fxml","Sign up");
    }

}
