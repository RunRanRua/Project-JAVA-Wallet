package com.isep.projectjavawallet.controllers.wallet;

import com.isep.projectjavawallet.bean.market.Market;
import com.isep.projectjavawallet.bean.market.Stock;
import com.isep.projectjavawallet.bean.wallet.Wallet;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class BuyStockController implements Initializable {
    @FXML
    TextField symbol;
    @FXML
    TextField quantity;
    @FXML
    Label currentBalance;
    @FXML
    Label totalPrice;
    @FXML
    Button buyButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Wallet wallet = SceneManager.getTargetWallet();
        double balance = wallet.getFiatWallet().getBalance();
        currentBalance.setText(String.valueOf(balance));

        symbol.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals(oldValue)) {
                buyButton.setDisable(false);
            } else {
                buyButton.setDisable(true);
            }
        });

        quantity.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals(oldValue)) {
                buyButton.setDisable(false);
            } else {
                buyButton.setDisable(true);
            }
        });
    }


    @FXML
    public void cancelButtonClick(){
        SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/waletPart/myAsset-view.fxml");
    }
    @FXML
    public void buyButtonClick() throws SQLException {
        Wallet wallet = SceneManager.getTargetWallet();
        String sym = symbol.getText();

        String quantity_TXT = quantity.getText();
        int quantity_int = Integer.parseInt(quantity_TXT);

        String totalPrice_txt = totalPrice.getText();
        double finalPrice = Double.parseDouble(totalPrice_txt);

        // pay money
        wallet.getFiatWallet().deposit(-finalPrice);
        new WalletDao().depositWallet(wallet.getIBAN(),-finalPrice);
        // Obtain stock
        if ( new AssetDao().isStockExist(wallet.getIBAN(),sym) ){
            new AssetDao().updateStockQuantity(wallet.getIBAN(), sym, quantity_int);
        }else{
            new AssetDao().insertStock(wallet.getIBAN(), sym, quantity_int);
        }

        // record in History
        new HistoryDao().insertHistoryData(wallet, TransactionType.STOCK);

        // modify quantity in market
        Market market = SceneManager.getHome().getMarket();
        market.getStocksInSale().clear();
        market.loadStocksData();
        new StockMarketDao().removeStock(sym,quantity_int);


        SceneManager.changeSceneRightPart("/com/isep/projectjavawallet/waletPart/myAsset-view.fxml");
    }

    @FXML
    public void getPriceButtonClick() throws SQLException {
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
            alert.setContentText("No enough quantity in the market");
            alert.show();
            return;
        }


        // get total price
        double price = getPrice(sym,quantity_int);
        totalPrice.setText(String.valueOf(price));


        // verify if enough money
        String currentBalance_str = currentBalance.getText();
        double balance = Double.parseDouble(currentBalance_str);
        if (balance >= price){
            buyButton.setDisable(false);
        }
    }


    private boolean isValidSymbol(String symbol) throws SQLException {
        return !symbol.isEmpty() && new StockMarketDao().isSymbolExist(symbol);
    }

    private boolean isQuantityGoodFormat(String quantity){
        return !quantity.isEmpty() && Pattern.matches("\\d+",quantity);
    }
    private boolean isValidQuantity(String symbol, int quantity){
        Market market = SceneManager.getHome().getMarket();
        for (Stock stockInSale : market.getStocksInSale()){
            if (stockInSale.getSymbol().equals(symbol) && stockInSale.getQuantity() >= quantity){
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

    @FXML
    private void EnterPressed(KeyEvent e) throws SQLException {
        if (e.getCode() == KeyCode.ENTER){
            buyButtonClick();
        }
    }
}
