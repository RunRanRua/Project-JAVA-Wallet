package com.isep.projectjavawallet.controllers.profile;

import com.isep.projectjavawallet.bean.setting.Account;
import com.isep.projectjavawallet.dao.AccountDao;
import com.isep.projectjavawallet.util.AccountVerification;
import com.isep.projectjavawallet.util.SceneManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ResetMailController implements Initializable {

    @FXML
    Label mail;
    @FXML
    TextField newMail;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Account acc = SceneManager.getHome().getProfile().getAccount();
        // load data
        mail.setText(acc.getMail());

    }

    @FXML
    public void backButtonClick(){
        SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/profilePart/profile-view.fxml");
    }
    @FXML
    public void confirmButtonClick() throws SQLException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);

        String mail_str = newMail.getText();

        if(!AccountVerification.isValidMail(mail_str)){
            System.out.println(mail_str);
            System.out.println(AccountVerification.isValidMail(mail_str));
            alert.setContentText("Error : Invalid mail");
            alert.show();
            return;
        }

        // modify in class
        Account acc = SceneManager.getHome().getProfile().getAccount();
        acc.setMail(mail_str);

        // Modify in DB
        new AccountDao().modifyMail(acc,mail_str);

        SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/profilePart/profile-view.fxml");
    }
}
