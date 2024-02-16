package com.isep.projectjavawallet.controllers.profile;

import com.isep.projectjavawallet.bean.setting.Account;
import com.isep.projectjavawallet.dao.AccountDao;
import com.isep.projectjavawallet.util.AccountVerification;
import com.isep.projectjavawallet.util.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;

import java.sql.SQLException;

public class ResetPWDController {
    @FXML
    PasswordField pwd;
    @FXML
    PasswordField newPWD;
    @FXML
    PasswordField confirmPWD;


    @FXML
    public void backButtonClick(){
        SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/profilePart/profile-view.fxml");
    }
    @FXML
    public void confirmButtonClick() throws SQLException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);

        String pwd_str = pwd.getText();
        String newPWD_str = newPWD.getText();
        String confirmPWD_str = confirmPWD.getText();

        Account acc = SceneManager.getHome().getProfile().getAccount();
        if(!pwd_str.equals(acc.getPassword()) || !AccountVerification.isValidPWD(newPWD_str) || !newPWD_str.equals(confirmPWD_str)){
            alert.setContentText("Error : Invalid pwd");
            alert.show();
            return;
        }

        new AccountDao().modifyPassword(acc,newPWD_str);

        SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/profilePart/profile-view.fxml");
    }
}
