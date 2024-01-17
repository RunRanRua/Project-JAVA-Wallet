package com.isep.projectjavawallet.controllers.setting;

import com.isep.projectjavawallet.dao.AccountDao;
import com.isep.projectjavawallet.util.SceneManager;
import com.isep.projectjavawallet.util.UpdateManager;
import com.isep.projectjavawallet.util.UserManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class changeMailController implements Initializable {
    @FXML
    private Label currentMail;

    @FXML
    private TextField newMail;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        currentMail.setText(UserManager.getHome().getProfil().getAccount().getMail());
    }
    public void confirmButtonClick() throws SQLException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);


        String mail = newMail.getText();

        boolean isValidMail = (Pattern.matches("^[a-zA-Z0-9_]+@[a-z]+.[a-z]+$",mail));
        if(mail.isEmpty() || !isValidMail){
            alert.setContentText("Invalid mail !");
            alert.show();
            return;
        }

        // modify in DB
        boolean isSuccessful = new AccountDao().modifyMail(UserManager.getHome().getProfil().getAccount(), mail);
        if (!isSuccessful){
            alert.setContentText("Failed, please contact the team...");
            alert.show();
            return;
        }

        // modify in class
        UserManager.getHome().getProfil().getAccount().setMail(mail);
        // update
        UpdateManager.updateMail(mail);



        // Close the window
        Stage currentWindow = (Stage) currentMail.getScene().getWindow();
        currentWindow.close();
    }


    public void cancelButtonClick() {
        // Close the window
        Stage currentWindow = (Stage) currentMail.getScene().getWindow();
        currentWindow.close();
    }
}
