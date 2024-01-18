package com.isep.projectjavawallet.bean.wallet.fiatWallet.assets;

import java.util.ArrayList;



public class Asset {
    private ArrayList<Stock> stocks;







    public Asset(){}
    public Asset(ArrayList<Stock> stocks) {
        this.stocks = stocks;
    }

    public ArrayList<Stock> getStocks() {
        return stocks;
    }

    public void setActions(ArrayList<Stock> stocks) {
        this.stocks = stocks;
    }
}
