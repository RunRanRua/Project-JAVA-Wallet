package com.isep.projectjavawallet.bean.market;




import com.isep.projectjavawallet.dao.CurrencyDao;
import com.isep.projectjavawallet.dao.StockMarketDao;
import com.isep.projectjavawallet.util.MarketManager;

import java.sql.SQLException;
import java.util.ArrayList;

public class Market {
    private ArrayList<Stock> stocksInSale;
    private ArrayList<ExchangeRate> currencyRates;

    public void loadStocksData() throws SQLException {
        boolean isUpdated = new StockMarketDao().isStockUpdated("IBM");

        if(!isUpdated){
            MarketManager.updateStockMarket();
        }

        String[] symbols = {"IBM","AMZN","GOOP","MSFT"};
        for (String symbol : symbols){
            Stock stock = new StockMarketDao().findStock(symbol);
            stocksInSale.add(stock);
        }
    }

    public void loadRateData() throws SQLException {
        boolean isUpdatedd = new CurrencyDao().isRateUpdated("USD","EUR");

        if(!isUpdatedd){
            MarketManager.updateCurrencyRate();
        }


        ExchangeRate USD2EUR = new CurrencyDao().findCurrency("USD","EUR");
        ExchangeRate USD2CNY = new CurrencyDao().findCurrency("USD","CNY");
        ExchangeRate EUR2CNY = new CurrencyDao().findCurrency("EUR","CNY");

        currencyRates.add(USD2EUR);
        currencyRates.add(USD2CNY);
        currencyRates.add(EUR2CNY);
    }





    public Market(){}
    public Market(ArrayList<Stock> stocksInSale, ArrayList<ExchangeRate> currencyRates) {
        this.stocksInSale = stocksInSale;
        this.currencyRates = currencyRates;
    }

    // getters
    public ArrayList<Stock> getStocksInSale() {return stocksInSale;}
    public ArrayList<ExchangeRate> getCurrencyRates() {return currencyRates;}
}
