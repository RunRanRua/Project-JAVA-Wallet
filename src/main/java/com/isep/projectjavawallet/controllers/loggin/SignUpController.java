package com.isep.projectjavawallet.controllers.loggin;

import com.isep.projectjavawallet.util.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.FileNotFoundException;
import java.util.regex.Pattern;

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
    private void createButtonOnClick() throws FileNotFoundException {
        String name_str = name.getText();
        String username_str = username.getText();
        String mail_str = mail.getText();
        String pwd_str = pwd.getText();
        String verify_pwd_str = verify_pwd.getText();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);

        boolean isEmpty = name_str.isEmpty() || username_str.isEmpty() || mail_str.isEmpty() || pwd_str.isEmpty() || verify_pwd_str.isEmpty();
        if (isEmpty){
            alert.setContentText("Please, complete all information ! (╬▔皿▔)╯");
            alert.show();
            return;
        }

        boolean isValidName = Pattern.matches("[a-zA-z]+( )?[a-zA-z]+", name_str);
        if (! isValidName){
            alert.setContentText("Invalid name ! 0_0");
            alert.show();
            return;
        }

        boolean isValidUsername = Pattern.matches("^.{6,15}$", username_str);
        if (!isValidUsername){
            alert.setContentText("the length of username should be between 6 and 15");
            alert.show();
            return;
        }

        boolean isValidMail = (Pattern.matches("^[a-zA-Z0-9_]+@[a-z]+.[a-z]+$",mail_str));
        if (!isValidMail){
            alert.setContentText("Invalid mail ! (〃＞目＜)");
            alert.show();
            return;
        }
        boolean isValidPWD = Pattern.matches("^.{6,15}$", pwd_str);
        if (! isValidPWD){
            alert.setContentText("the length of password should be between 6 and 15");
            alert.show();
            return;
        }
        boolean isPWDSame = pwd_str.equals(verify_pwd_str);
        if(!isPWDSame){
            alert.setContentText("Check your password ! (ノ｀Д)ノ");
            alert.show();
            return;
        }



        // if username already exists
        /*
            - Retrieve data
            - compare them with username
            - if-else with boolean
         */

        // if it is available
        /*
            - upload in database
            - show alert
        */
        back2AuthenticationWindow();
    }

    @FXML
    private void BackonButtonClick(){
        back2AuthenticationWindow();
    }

    @FXML
    private void EnterPressed(KeyEvent e) throws FileNotFoundException {
        if (e.getCode() == KeyCode.ENTER){
            createButtonOnClick();
        }
    }




    private void back2AuthenticationWindow(){
        SceneManager.changeScene("/com/isep/projectjavawallet/loginViews/authentication.fxml","Authentification");
    }
}
