package com.isep.projectjavawallet.bean.wallet.fiatWallet;

import com.isep.projectjavawallet.bean.wallet.fiatWallet.assets.Stock;

import java.util.ArrayList;



/* completed */
public class History {
    private final ArrayList<Stock> stockHistory;
    private final ArrayList<Transaction> transactionHistory;

    public History(){
        stockHistory = new ArrayList<Stock>();
        transactionHistory = new ArrayList<Transaction>();
    }

    // methods
    public void addActionHistory(Stock stock){
        stockHistory.add(stock);
    }
    public void addTransactionHistory(Transaction transaction){
        transactionHistory.add(transaction);
    }



    // constructors
    public History(ArrayList<Stock> stockHistory, ArrayList<Transaction> transactionHistory) {
        this.stockHistory = stockHistory;
        this.transactionHistory = transactionHistory;
    }


    // getters
    public ArrayList<Stock> getActionHistory() {
        return stockHistory;
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
}
