module com.isep.projectjavawallet {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.isep.projectjavawallet.controllers to javafx.fxml;
    exports com.isep.projectjavawallet.controllers;

    exports com.isep.projectjavawallet.controllers.setting;
    opens com.isep.projectjavawallet.controllers.setting to javafx.fxml;
    exports com.isep.projectjavawallet.controllers.wallets;
    opens com.isep.projectjavawallet.controllers.wallets to javafx.fxml;
    exports com.isep.projectjavawallet.controllers.loggin;
    opens com.isep.projectjavawallet.controllers.loggin to javafx.fxml;
    exports com.isep.projectjavawallet.tests;
    opens com.isep.projectjavawallet.tests to javafx.fxml;
}