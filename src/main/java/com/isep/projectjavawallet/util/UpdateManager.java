package com.isep.projectjavawallet.util;

import com.isep.projectjavawallet.bean.wallet.fiatWallet.assets.Stock;
import com.isep.projectjavawallet.controllers.setting.ProfileController;
import com.isep.projectjavawallet.dao.MarketDao;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateManager {
    private static String API_URL =
            "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=SEARCH_SYMBOL&interval=5min&apikey=CVDHSKRTFVK2QTX2";
    private static ProfileController profileController;



    public static void updateMail(String mail){
        profileController.getMail().setText(mail);
    }





    // Stock user
    public static void updateMarket() throws SQLException {
        Stock stock = new MarketDao().findStock("IBM");
        if (!stock.getDate().equals(DateManager.printDate())){
            String[] symbols = {"IBM","A","AMZN","GOOP","MSFT"};
            for (String symbol : symbols) {
                Stock newStock = getNecessaryData(symbol);
                boolean isSuccessful = new MarketDao().insertStock(newStock);
            }
        }
    }
    private static Stock getNecessaryData(String symbol){
        String API_URL_withKey = API_URL.replace("SEARCH_SYMBOL", symbol);
        Stock stock = new Stock();

        try {
            JSONObject stockData = getStockData(API_URL_withKey);
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
            stock.setDate(DateManager.printDate());
        } catch (IOException e){
            e.printStackTrace();;
        }

        return stock;
    }
    private static JSONObject getStockData(String apiUrl) throws IOException {
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



    public static void setProfileController(ProfileController profileController) {
        UpdateManager.profileController = profileController;
    }


}
