package com.isep.projectjavawallet.bean.market;

import com.isep.projectjavawallet.bean.wallet.fiatWallet.assets.Stock;

import java.util.ArrayList;

public class Market {
    private ArrayList<Stock> stocks;



    public Market(){

    }
    public Market(ArrayList<Stock> stocks) {
        this.stocks = stocks;
    }

    public ArrayList<Stock> getStocks() {
        return stocks;
    }

    public void setActions(ArrayList<Stock> stocks) {
        this.stocks = stocks;
    }
}
