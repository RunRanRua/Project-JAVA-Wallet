package com.isep.projectjavawallet.controllers.market;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class StockController {
    private static String API_URL =
            "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=SEARCH_SYMBOL&interval=1min&apikey=SMJ44JXNNQM94SUDI" ;
    @FXML
    private TextField symbol;
    @FXML
    private Label stockText;
    public void getStockInfo() {
        String stockSymbol = symbol.getText();
        String apiUrlWithKey = API_URL.replace("SEARCH_SYMBOL", stockSymbol);
        try {
// Make API request and parse JSON response
            String stockData = getStockData(apiUrlWithKey);
            //String latestPrice = stockData.getJSONObject("Time Series (1min)").getJSONObject(stockData.getJSONObject("Meta Data").getString("3. Last Refreshed")).getString("4. close");

            stockText.setText("Latest Stock Price for "+stockSymbol+" is : $" + stockData);
        } catch (IOException e) {
            e.printStackTrace();
            stockText.setText("Error fetching stock information");

        }
    }
//
        private String getStockData(String apiUrl) throws IOException {
            URL url = URI.create(apiUrl).toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            try (Scanner scanner = new Scanner(new InputStreamReader(connection.getInputStream()))) {
                scanner.useDelimiter("\\A");
                String response = scanner.hasNext() ? scanner.next() : "";
                return response;
            } finally {
                connection.disconnect();
            }
        }
    }

