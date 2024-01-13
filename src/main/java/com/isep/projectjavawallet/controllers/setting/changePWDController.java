package com.isep.projectjavawallet.controllers.setting;

import com.isep.projectjavawallet.dao.AccountDao;
import com.isep.projectjavawallet.util.UpdateManager;
import com.isep.projectjavawallet.util.UserManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class changePWDController {

    @FXML
    private PasswordField verifyPWD;


    @FXML
    private PasswordField newPWD;
    @FXML
    private PasswordField verifyNewPWD;

    public void confirmButtonClick() throws SQLException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);


        String verifyPWD_str = verifyPWD.getText();
        String newPWD_str = newPWD.getText();
        String verifyNewPWD_str = verifyNewPWD.getText();
        String currentPWD = UserManager.getHome().getProfil().getAccount().getPassword();

        boolean isSamePWD = currentPWD.equals(verifyPWD_str);
        boolean isSameNewPWD = newPWD_str.equals(verifyNewPWD_str);
        boolean isValidPWD = Pattern.matches("^.{6,15}$", newPWD_str);

        if( verifyPWD_str.isEmpty() || newPWD_str.isEmpty() || verifyNewPWD_str.isEmpty() || currentPWD.isEmpty()){
            alert.setContentText("Please fill in all password field !");
            alert.show();
            return;
        }
        if (!isSamePWD || !isSameNewPWD || !isValidPWD){
            alert.setContentText("Please check you passwords !");
            alert.show();
            return;
        }


        // modify in DB
        boolean isSuccessful = new AccountDao().modifyPassword(UserManager.getHome().getProfil().getAccount(), newPWD_str);
        if (!isSuccessful){
            alert.setContentText("Failed, please contact the team...");
            alert.show();
            return;
        }

        // modify in class
        UserManager.getHome().getProfil().getAccount().setPassword(newPWD_str);



        // Close the window
        Stage currentWindow = (Stage) verifyPWD.getScene().getWindow();
        currentWindow.close();
    }


    public void cancelButtonClick() {
        // Close the window
        Stage currentWindow = (Stage) verifyPWD.getScene().getWindow();
        currentWindow.close();
    }


}
