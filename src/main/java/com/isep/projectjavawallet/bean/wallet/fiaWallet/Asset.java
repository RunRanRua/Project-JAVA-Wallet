package com.isep.projectjavawallet.bean.wallet.fiaWallet;

import com.isep.projectjavawallet.bean.market.Stock;

import java.util.ArrayList;

public class Asset {
    private ArrayList<Stock> stocks;

    // methods
    public void addStock(Stock stock){
        stocks.add(stock);
    }
    public void removeStock(Stock stock){
        stocks.remove(stock);
    }




    public Asset(){}
    public Asset(ArrayList<Stock> stocks) {
        this.stocks = stocks;
    }

    public ArrayList<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(ArrayList<Stock> stocks) {
        this.stocks = stocks;
    }
}
