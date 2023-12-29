package com.isep.projectjavawallet.bean.wallet.fiatWallet;

import com.isep.projectjavawallet.bean.currency.FiatCurrency;
import com.isep.projectjavawallet.bean.wallet.fiatWallet.assets.Asset;

import java.util.HashMap;



/* uncompleted:
* 3 Methods
* */
public class FiatWallet {
    private HashMap<FiatCurrency,Double> balances;
    private Asset myAsset;




    // methods
    public void deposit(double amount, FiatCurrency currency){

    }
    public void transfer(double amount, FiatCurrency currency, String IBAN){

    }
    public void exchange(double amount, FiatCurrency currency, FiatCurrency newCurrency){

    }


    // constructors
    public FiatWallet() {
    }
    public FiatWallet(HashMap<FiatCurrency, Double> balances, Asset myAsset) {
        this.balances = balances;
        this.myAsset = myAsset;
    }


    // getters & setters
    public HashMap<FiatCurrency, Double> getBalances() {
        return balances;
    }

    public void setBalances(HashMap<FiatCurrency, Double> balances) {
        this.balances = balances;
    }

    public Asset getMyAsset() {
        return myAsset;
    }

    public void setMyAsset(Asset myAsset) {
        this.myAsset = myAsset;
    }
}
