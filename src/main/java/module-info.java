module com.isep.projectjavawallet {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.isep.projectjavawallet to javafx.fxml;
    exports com.isep.projectjavawallet;
}