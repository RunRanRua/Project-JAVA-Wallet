package com.isep.projectjavawallet.bean.wallet.fiaWallet;

public class FiatWallet {
    private double balance;
    private final FiatCurrency referenceCurrency = FiatCurrency.EUR;
    private Asset myAsset;
    private History history;

    // methods
    public void deposit(double amount){
        balance += amount;
    }
    public void transfer(double amount){
        balance -= amount;
    }


    public FiatWallet(){}
    public FiatWallet(double balance, Asset myAsset, History history) {
        this.balance = balance;
        this.myAsset = myAsset;
        this.history = history;
    }

    // getters & setters
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public FiatCurrency getReferenceCurrency() {
        return referenceCurrency;
    }

    public Asset getMyAsset() {
        return myAsset;
    }

    public void setMyAsset(Asset myAsset) {
        this.myAsset = myAsset;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }
}
