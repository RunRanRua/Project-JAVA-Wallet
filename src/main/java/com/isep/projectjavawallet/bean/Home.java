package com.isep.projectjavawallet.bean;

import com.isep.projectjavawallet.bean.nofinished.Market;
import com.isep.projectjavawallet.bean.nofinished.ExchangeRate;
import com.isep.projectjavawallet.bean.nofinished.Wallet;
import com.isep.projectjavawallet.bean.setting.Profil;

import java.util.ArrayList;

public class Home {
    private Profil profil;
    private Market market;
    private ArrayList<Wallet> wallets;
    private ExchangeRate exchangeRate;



    public void addWallet(Wallet wallet){
        wallets.add(wallet);
    }
    public void removeWallet(Wallet wallet){
        wallets.remove(wallet);
    }



    // getters
    public Profil getProfil() {
        return profil;
    }

    public Market getMarket() {
        return market;
    }

    public ArrayList<Wallet> getWallets() {
        return wallets;
    }

    public ExchangeRate getExchangeRate() {
        return exchangeRate;
    }
}
