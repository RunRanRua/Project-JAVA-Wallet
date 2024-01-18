package com.isep.projectjavawallet.bean;

import com.isep.projectjavawallet.bean.currency.ExchangeRate;
import com.isep.projectjavawallet.bean.market.Market;
import com.isep.projectjavawallet.bean.wallet.Wallet;
import com.isep.projectjavawallet.bean.setting.Profile;

import java.util.ArrayList;

public class Home {
    private Profile profile;
    private Market market;
    private ArrayList<Wallet> wallets;
    private ArrayList<ExchangeRate> exchangeRates;




    public void addWallet(Wallet wallet){
        wallets.add(wallet);
    }
    public void removeWallet(Wallet wallet){
        wallets.remove(wallet);
    }

    // constructors

    public Home(){}
    public Home(Profile profile, Market market, ArrayList<Wallet> wallets, ArrayList<ExchangeRate> exchangeRates) {
        this.profile = profile;
        this.market = market;
        this.wallets = wallets;
        this.exchangeRates = exchangeRates;
    }

    // getters
    public Profile getProfile() {
        return profile;
    }

    public Market getMarket() {
        return market;
    }

    public ArrayList<Wallet> getWallets() {
        return wallets;
    }

    public ArrayList<ExchangeRate> getExchangeRates() {
        return exchangeRates;
    }
}
