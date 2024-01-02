package com.isep.projectjavawallet.controllers.loggin;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class LoginController_no_need {
    @FXML
    private Button No_Account;
    @FXML
    private Button No_PW;
    @FXML
    public void handleMouseEnterBouton(MouseEvent event) {
        Object source = event.getSource();
        if (source instanceof Button) {
            ((Button) source).setStyle(((Button) source).getStyle() + "-fx-underline: true;");
        }
    }
    @FXML
    public void handleMouseExitBouton(MouseEvent event) {
        Object source = event.getSource();
        if (source instanceof Button) {
            ((Button) source).setStyle(((Button) source).getStyle() + "-fx-underline: false;");
        }
    }
}