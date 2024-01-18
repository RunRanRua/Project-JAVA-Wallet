package com.isep.projectjavawallet.controllers.wallets;

import com.isep.projectjavawallet.bean.currency.ExchangeRate;
import com.isep.projectjavawallet.bean.wallet.fiatWallet.assets.Stock;
import com.isep.projectjavawallet.dao.MarketDao;
import com.isep.projectjavawallet.dao.StockDao;
import com.isep.projectjavawallet.dao.WalletDataDao;
import com.isep.projectjavawallet.dao.WalletListDao;
import com.isep.projectjavawallet.util.UpdateManager;
import com.isep.projectjavawallet.util.UserManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class buyStockConfirmController implements Initializable {

    @FXML
    private Label symbol;
    @FXML
    private Label quantity;
    @FXML
    private Label requiredAmount;
    @FXML
    public Label convertedAmount;
    @FXML
    private Label havingAmount;

    private boolean canPay;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int quantity = UserManager.getStockQuantity();
        int requiredAmount = quantity * UserManager.getStock().getPrice();
        String currency = UserManager.getCurrentWallet().getReferenceCurrency();
        int havingAmount = (int) UserManager.getCurrentWallet().getAmount();

        // obtain convertedAmount
        double exchangeRate = 0;
        ArrayList<ExchangeRate> rates = UserManager.getHome().getExchangeRates();
        for (ExchangeRate rate : rates){
            if (rate.getFromCurrency().equals("USD") && rate.getToCurrency().equals(currency)){
                exchangeRate = rate.getRate();
            }
        }
        int convertedAmount = (int) (exchangeRate * requiredAmount);

        // set boolean canPay()
        canPay = (havingAmount - convertedAmount >= 0);


        // set texts
        symbol.setText( UserManager.getStock().getSymbol() );
        this.quantity.setText( String.valueOf(quantity) );
        this.requiredAmount.setText( requiredAmount + " USD");
        this.convertedAmount.setText( convertedAmount + " " + currency);
        this.havingAmount.setText( havingAmount + " " + currency );
    }




    @FXML
    private void yesButtonClick() throws SQLException {
        if (!canPay){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("you do not have enough money!");
            Stage currentWindow = (Stage) symbol.getScene().getWindow();
            currentWindow.close();
            alert.show();
            return;
        }
        // update stock (back-end)
        Stock stock = new Stock(UserManager.getStock().getSymbol(),UserManager.getStock().getPrice(), UserManager.getStockQuantity(), UserManager.getStock().getDate());
        UserManager.getStock().setVolume(UserManager.getStock().getVolume() - UserManager.getStockQuantity() ); // remove quantity in that stock

        // update myAsset (back-end)
        UserManager.getCurrentWallet().getFiatWallet().getMyAsset().getStocks().add(stock); // add into the wallet asset

        // update amount (back-end + front-end)
        String convertedAmount = this.convertedAmount.getText();
        String[] str = convertedAmount.split(" ");
        double amountToPay = Double.parseDouble(str[0]);
        UserManager.getCurrentWallet().setAmount( UserManager.getCurrentWallet().getAmount() - amountToPay);
        UpdateManager.updateWalletData();

        // updadte history (back-end)
        UserManager.getCurrentWallet().getHistory().getStockHistory().add(stock);


        // update DB (SQL)
        String IBAN = UserManager.getCurrentWallet().getIBAN();
        String username = UserManager.getHome().getProfile().getAccount().getUsername();
        String currency = UserManager.getCurrentWallet().getReferenceCurrency();
        boolean isSuccessful = new StockDao().insertBoughtStocks(stock,IBAN,username,currency); // add stock

        // update DB_wallet Amount (SQL)
        boolean isSuccessful_update = new WalletDataDao().removeAmount(UserManager.getCurrentWallet(),amountToPay);
        // update DB_market quantity (SQL)
        new MarketDao().removeStock(UserManager.getStock().getSymbol(), UserManager.getStockQuantity());


        Stage currentWindow = (Stage) symbol.getScene().getWindow();
        currentWindow.close();
    }
    @FXML
    private void noButtonClick(){
        Stage currentWindow = (Stage) symbol.getScene().getWindow();
        currentWindow.close();
    }
}
