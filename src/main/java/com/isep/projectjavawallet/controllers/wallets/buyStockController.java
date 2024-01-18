package com.isep.projectjavawallet.controllers.wallets;

import com.isep.projectjavawallet.bean.wallet.fiatWallet.assets.Stock;
import com.isep.projectjavawallet.util.SceneManager;
import com.isep.projectjavawallet.util.UserManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class buyStockController {

    @FXML
    private TextField symbol;
    @FXML
    private TextField quantity;



    @FXML
    private void buyButtonClick(){
        String sym = symbol.getText();
        if ( sym.isEmpty() || !isValidSymbol(sym)){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("Invalid stock!");
            alert.show();
            return;
        }

        String quantity_str = quantity.getText();
        if (quantity_str.isEmpty() || !isValidQuantity(quantity_str,sym)){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("Invalid quantity!");
            alert.show();
            return;
        }

        Stage currentWindow = (Stage) symbol.getScene().getWindow();
        currentWindow.close();
        SceneManager.anotherScene("/com/isep/projectjavawallet/WalletsViews/buyStock-confirmation-view.fxml","confirmation");

    }

    @FXML
    private void EnterPressed(KeyEvent e) throws FileNotFoundException, SQLException {
        if (e.getCode() == KeyCode.ENTER){
            buyButtonClick();
        }
    }

    @FXML
    private void cancelButtonClick(){
        Stage currentWindow = (Stage) symbol.getScene().getWindow();
        currentWindow.close();
    }


    private boolean isValidSymbol(String sym){
        for (String stockSymbol : new String[]{"IBM","A","AMZN","GOOP","MSFT"}){
            if (sym.equals(stockSymbol)){
                return true;
            }
        }
        return false;
    }
    private boolean isValidQuantity(String quantity,String sym){
        if (Pattern.matches("[0-9]+",quantity)){
            int val = Integer.parseInt(quantity);

            if (val == 0){
                return false;
            }

            ArrayList<Stock> stocks = UserManager.getHome().getMarket().getStocks();
            for (Stock stock : stocks){
                if (stock.getSymbol().equals(sym) && val <= stock.getVolume()){
                    UserManager.setStock(stock);
                    UserManager.setStockQuantity(val);
                    return true;
                }
            }
        }
        return false;
    }




}
