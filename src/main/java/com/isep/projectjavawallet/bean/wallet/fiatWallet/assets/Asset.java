package com.isep.projectjavawallet.bean.wallet.fiatWallet.assets;

import java.util.ArrayList;


/* Uncompleted
*       - 3 methods
*/
public class Asset {
    private ArrayList<Stock> stocks;







    public Asset(){}
    public Asset(ArrayList<Stock> stocks) {
        this.stocks = stocks;
    }

    public ArrayList<Stock> getActions() {
        return stocks;
    }

    public void setActions(ArrayList<Stock> stocks) {
        this.stocks = stocks;
    }
}
