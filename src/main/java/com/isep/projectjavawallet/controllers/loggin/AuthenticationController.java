package com.isep.projectjavawallet.controllers.loggin;

import com.isep.projectjavawallet.util.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.util.regex.Pattern;

public class AuthenticationController {

    @FXML
    private TextField login;
    @FXML
    private TextField password;


    @FXML
    private void EnterPressed(KeyEvent e) throws IOException {
        if (e.getCode() == KeyCode.ENTER){
            signInButtonClick();
        }
    }



    @FXML
    private void signInButtonClick() throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);

        // account given by user
        String username = login.getText();
        String pwd = password.getText();


        // verify input account  (format + isEmpty)
        boolean isGoodFormat = !username.isEmpty() && !pwd.isEmpty()   &&  Pattern.matches("^.{6,15}$", username) && Pattern.matches("^.{6,15}$", pwd);
        if (!isGoodFormat){
            alert.setContentText("Error : Invalid mail or your password is wrong (>_<)!");
            alert.show();
            return;
        }

        // verify account's validity (search in dataBase)
        /*

            - access to database
            - search corresponding username + pwd

            // if not matched / doesn't exist
        alert.setContentText("Your mail or your password is wrong. ");
        alert.show();

         */


        // if there is no problem
        loginSuccessful();
    }

    @FXML
    private void signUpButtonClick(){
        SceneManager.changeScene("/com/isep/projectjavawallet/loginViews/SignUp.fxml","Sign up");
    }

    private void loginSuccessful(){
        /*
            - retrieve user data
            - create home
            - complete all info
         */
        SceneManager.changeScene("/com/isep/projectjavawallet/home-view.fxml","Sign up");
    }

}
