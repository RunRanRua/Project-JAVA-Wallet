module com.isep.projectjavawallet {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires alphavantage.java;
    requires org.json;

    opens com.isep.projectjavawallet.controllers to javafx.fxml;
    exports com.isep.projectjavawallet.controllers;

    exports com.isep.projectjavawallet.controllers.loggin;
    opens com.isep.projectjavawallet.controllers.loggin to javafx.fxml;

    exports com.isep.projectjavawallet.controllers.profile;
    opens com.isep.projectjavawallet.controllers.profile to javafx.fxml;

    exports com.isep.projectjavawallet.controllers.market;
    opens com.isep.projectjavawallet.controllers.market to javafx.fxml;

    exports com.isep.projectjavawallet.controllers.wallet;
    opens com.isep.projectjavawallet.controllers.wallet to javafx.fxml;
    exports com.isep.projectjavawallet to javafx.graphics;


}