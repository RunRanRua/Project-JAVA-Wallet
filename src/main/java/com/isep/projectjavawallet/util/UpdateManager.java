package com.isep.projectjavawallet.util;

import com.isep.projectjavawallet.bean.currency.ExchangeRate;
import com.isep.projectjavawallet.bean.wallet.fiatWallet.assets.Stock;
import com.isep.projectjavawallet.controllers.setting.ProfileController;
import com.isep.projectjavawallet.dao.MarketDao;
import com.isep.projectjavawallet.dao.CurrencyDao;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateManager {
    private static ProfileController profileController;



    // walletData use
    public static void updateWalletData(){
        double amount = UserManager.getCurrentWallet().getAmount();
        UserManager.getWalletDataController().updateAmount( String.valueOf(amount) );
    }

    // Profile use
    public static void updateMail(String mail){
        profileController.getMail().setText(mail);
    }






    // Stock use
    public static void updateMarket() throws SQLException {
        boolean isUpdated = new MarketDao().isStockUpdated("IBM");
        if (!isUpdated){
            String[] symbols = {"IBM","A","AMZN","GOOP","MSFT"};
            for (String symbol : symbols) {
                Stock newStock = getStockData(symbol);
                boolean isSuccessful = new MarketDao().insertStock(newStock);
            }
        }
    }
    private static Stock getStockData(String symbol){
        String API_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=SEARCH_SYMBOL&interval=5min&apikey=CVDHSKRTFVK2QTX2";
        String API_URL_withKey = API_URL.replace("SEARCH_SYMBOL", symbol);
        Stock stock = new Stock();

        try {
            JSONObject stockData = getData(API_URL_withKey);
            System.out.println(stockData);

            // condition
            String price = stockData.getJSONObject("Time Series (5min)")  // group
                    .getJSONObject(stockData.getJSONObject("Meta Data").getString("3. Last Refreshed")) // condition
                    .getString("4. close"); // data we want

            String volume = stockData.getJSONObject("Time Series (5min)")  // group
                    .getJSONObject(stockData.getJSONObject("Meta Data").getString("3. Last Refreshed")) // condition
                    .getString("5. volume"); // data we want


            stock.setSymbol(symbol);
            stock.setPrice(Integer.parseInt(price));
            stock.setVolume(Integer.parseInt(volume));
            stock.setDate(DateManager.getDate());
        } catch (IOException e){
            e.printStackTrace();;
        }

        return stock;
    }
    private static JSONObject getData(String apiUrl) throws IOException {
        URL url = URI.create(apiUrl).toURL();
        HttpURLConnection connection = (HttpURLConnection)
                url.openConnection();

        try (Scanner scanner = new Scanner(new InputStreamReader(connection.getInputStream()))) {
            scanner.useDelimiter("\\A");
            String response = scanner.hasNext() ? scanner.next() : "";
            return new JSONObject(response);
        } finally {
            connection.disconnect();
        }
    }

    // Currency use
    public static void updateCurrency() throws SQLException {
        boolean isUpdated = new CurrencyDao().isRateUpdated("USD","EUR");

        if (!isUpdated){
            String[] syms = {"USD","EUR","CNY"} ;
            ExchangeRate USD2EUR = getCurrencyData("USD","EUR");
            ExchangeRate USD2CNY = getCurrencyData("USD","CNY");
            ExchangeRate EUR2CNY = getCurrencyData("EUR","CNY");

            ExchangeRate[] rates = {USD2EUR,USD2CNY,EUR2CNY};
            for (ExchangeRate rate : rates) {
                boolean a = new CurrencyDao().insertRate(rate);
            }
        }



    }
    private static ExchangeRate getCurrencyData(String fromCurrency, String toCurrency){
        String API_URL = "https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=BTC&to_currency=CNY&apikey=CVDHSKRTFVK2QTX2";
        String API_URL_withKey = API_URL.replace("BTC", fromCurrency).replace("CNY", toCurrency);

        ExchangeRate exchangeRate = new ExchangeRate();

        try {
            JSONObject currencyData = getData(API_URL_withKey);
            System.out.println(currencyData);

            // data
            String rate = currencyData.getJSONObject("Realtime Currency Exchange Rate").getString("5. Exchange Rate");

            exchangeRate.setFromCurrency(fromCurrency);
            exchangeRate.setToCurrency(toCurrency);
            exchangeRate.setRate(Double.parseDouble(rate));

        } catch (IOException e){
            e.printStackTrace();;
        }

        return exchangeRate;
    }


    public static void setProfileController(ProfileController profileController) {
        UpdateManager.profileController = profileController;
    }


    public static void main(String[] args) {
        System.out.println(getCurrencyData("EUR","CNY"));
    }

}
