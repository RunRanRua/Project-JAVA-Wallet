package com.isep.projectjavawallet.bean.wallet.fiaWallet;

import com.isep.projectjavawallet.bean.wallet.fiaWallet.transaction.Transaction;
import javafx.util.Pair;

import java.util.*;

public class History {
    private ArrayList<Transaction> transactions;





    // methods
    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }
    public ArrayList<Pair<String, Double>> visualazation(){
        Map<String,Double> map = new HashMap<>();
        for (Transaction transaction : transactions){
            String date = transaction.getDate();
            double amount = transaction.getRemainingBalance();
            map.put(date, amount);
        }

        ArrayList<String> dates = new ArrayList<>();
        for (String key : map.keySet()){
            dates.add(key);
        }
        Collections.sort(dates);

        ArrayList<Pair<String,Double>> data = new ArrayList<>();
        for (String date : dates){
            Pair<String,Double> pair = new Pair<>(date,map.get(date));
            data.add(pair);
        }
        return data;
    }


    public History(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }


    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }
}
