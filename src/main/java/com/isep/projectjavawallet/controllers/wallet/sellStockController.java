package com.isep.projectjavawallet.controllers.wallet;

import com.isep.projectjavawallet.bean.market.Market;
import com.isep.projectjavawallet.bean.market.Stock;
import com.isep.projectjavawallet.bean.wallet.Wallet;
import com.isep.projectjavawallet.bean.wallet.fiaWallet.Asset;
import com.isep.projectjavawallet.bean.wallet.fiaWallet.transaction.TransactionType;
import com.isep.projectjavawallet.dao.AssetDao;
import com.isep.projectjavawallet.dao.HistoryDao;
import com.isep.projectjavawallet.dao.StockMarketDao;
import com.isep.projectjavawallet.dao.WalletDao;
import com.isep.projectjavawallet.util.NumberConversion;
import com.isep.projectjavawallet.util.SceneManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class sellStockController implements Initializable {
    @FXML
    Label price;
    @FXML
    TextField symbol;
    @FXML
    TextField quantity;
    @FXML
    Button sellButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        symbol.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals(oldValue)) {
                sellButton.setDisable(false);
            } else {
                sellButton.setDisable(true);
            }
        });

        quantity.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals(oldValue)) {
                sellButton.setDisable(false);
            } else {
                sellButton.setDisable(true);
            }
        });

    }


    @FXML
    public void backButtonClick(){
        SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/waletPart/myAsset-view.fxml");
    }
    @FXML
    public void sellButtonClick() throws SQLException {
        Wallet wallet = SceneManager.getTargetWallet();
        double amount = Double.parseDouble(price.getText());
        String sym = symbol.getText();
        String quantity_TXT = quantity.getText();
        int quantity_int = Integer.parseInt(quantity_TXT);

        // gain money
        wallet.getFiatWallet().deposit(amount);
        new WalletDao().depositWallet(wallet.getIBAN(),amount);
        // update stock quantity
        new AssetDao().updateStockQuantity(wallet.getIBAN(),sym,-quantity_int);
        new AssetDao().remove0QuantityStock(); // remove stock (if quantity = 0)
        Asset asset = wallet.getFiatWallet().getMyAsset();
        asset.setStocks(new AssetDao().loadStocks(wallet.getIBAN()));
        // record in History
        new HistoryDao().insertHistoryData(wallet, TransactionType.STOCK);

        SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/waletPart/myAsset-view.fxml");
    }
    @FXML
    public void getPriceButtonClick() {
        String sym = symbol.getText();
        String quantity_TXT = quantity.getText();

        if ( !isValidSymbol(sym) || !isQuantityGoodFormat(quantity_TXT)){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("Invalid quantity or symbol");
            alert.show();
            return;
        }

        int quantity_int = Integer.parseInt(quantity_TXT);
        if (!isValidQuantity(sym,quantity_int)){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("No enough quantity in you asset");
            alert.show();
            return;
        }

        // get total amount
        double amount = getPrice(sym,quantity_int);

        price.setText(String.valueOf(amount));
        sellButton.setDisable(false);
    }

    private boolean isValidSymbol(String symbol) {
        if (symbol.isEmpty()){
            return false;
        }

        Wallet wallet = SceneManager.getTargetWallet();
        for (Stock stock: wallet.getFiatWallet().getMyAsset().getStocks()){
            String havingSymbol = stock.getSymbol();
            if (havingSymbol.equals(symbol)){
                return true;
            }
        }
        return false;
    }
    private boolean isQuantityGoodFormat(String quantity){
        return !quantity.isEmpty() && Pattern.matches("\\d+",quantity);
    }
    private boolean isValidQuantity(String symbol, int quantity){
        Wallet wallet = SceneManager.getTargetWallet();

        for (Stock stock : wallet.getFiatWallet().getMyAsset().getStocks()){
            if (stock.getSymbol().equals(symbol) && stock.getQuantity() >= quantity){
                return true;
            }
        }
        return false;
    }
    private double getPrice(String symbol, int quantity){
        Market market = SceneManager.getHome().getMarket();
        // obtain rate
        double rate = SceneManager.getHome().getMarket().getCurrencyRates().getFirst().getRate();

        // obtain price
        double price = 0;
        for (Stock stockInSale : market.getStocksInSale()){
            if (stockInSale.getSymbol().equals(symbol)){
                price = stockInSale.getPrice();
                break;
            }
        }

        double p =  price * rate * quantity;
        return NumberConversion.conversion(p,2);
    }
}
