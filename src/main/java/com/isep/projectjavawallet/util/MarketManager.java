package com.isep.projectjavawallet.util;


import com.isep.projectjavawallet.bean.market.ExchangeRate;
import com.isep.projectjavawallet.bean.market.Stock;
import com.isep.projectjavawallet.dao.CurrencyDao;
import com.isep.projectjavawallet.dao.StockMarketDao;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.sql.SQLException;
import java.util.Scanner;

public class MarketManager {

    // General
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

    // Stock use
    private static Stock getStockData(String symbol){
        String API_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=SEARCH_SYMBOL&interval=5min&apikey=CVDHSKRTFVK2QTX2";
        String API_URL_withKey = API_URL.replace("SEARCH_SYMBOL", symbol);
        String price = "";
        String quantity = "";

        try {
            JSONObject stockData = getData(API_URL_withKey);
            System.out.println(stockData);

            // condition
            price = stockData.getJSONObject("Time Series (5min)")  // group
                    .getJSONObject(stockData.getJSONObject("Meta Data").getString("3. Last Refreshed")) // condition
                    .getString("4. close"); // data we want

            quantity = stockData.getJSONObject("Time Series (5min)")  // group
                    .getJSONObject(stockData.getJSONObject("Meta Data").getString("3. Last Refreshed")) // condition
                    .getString("5. volume"); // data we want
        } catch (IOException e){
            e.printStackTrace();;
        }

        if(price.isEmpty() || quantity.isEmpty()){
            System.out.println("failed to get stock data from API");
            return null;
        }
        return new Stock(symbol, (int) Double.parseDouble(price),Integer.parseInt(quantity),DateManager.getDate());
    }
    public static void updateStockMarket() throws SQLException {
        String[] symbols = {"IBM","AMZN","GOOP","MSFT"};
        for (String symbol : symbols) {
            Stock newStock = getStockData(symbol);
            assert newStock != null;
            new StockMarketDao().insertStock(newStock);
        }
    }


    // Currency use
    private static ExchangeRate getCurrencyData(String fromCurrency, String toCurrency){
        String API_URL = "https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=BTC&to_currency=CNY&apikey=CVDHSKRTFVK2QTX2";
        String API_URL_withKey = API_URL.replace("BTC", fromCurrency).replace("CNY", toCurrency);

        String rate = "";
        try {
            JSONObject currencyData = getData(API_URL_withKey);
            System.out.println(currencyData);

            // data
            rate = currencyData.getJSONObject("Realtime Currency Exchange Rate").getString("5. Exchange Rate");

        } catch (IOException e){
            e.printStackTrace();;
        }

        return new ExchangeRate(fromCurrency, toCurrency, Double.parseDouble(rate), DateManager.getDate());
    }

    public static void updateCurrencyRate() throws SQLException {
        String[] syms = {"USD","EUR","CNY"} ;
        ExchangeRate USD2EUR = getCurrencyData("USD","EUR");
        ExchangeRate USD2CNY = getCurrencyData("USD","CNY");
        ExchangeRate EUR2CNY = getCurrencyData("EUR","CNY");

        ExchangeRate[] rates = {USD2EUR,USD2CNY,EUR2CNY};
        for (ExchangeRate rate : rates) {
            boolean a = new CurrencyDao().insertRate(rate);
        }

    }



    public static void main(String[] args) {
        //System.out.println(getStockData("IBM"));
        //System.out.println(getCurrencyData("EUR","CNY"));
    }

}
