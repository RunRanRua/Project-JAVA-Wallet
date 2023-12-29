package com.isep.projectjavawallet.bean.wallet;

import com.isep.projectjavawallet.bean.wallet.fiatWallet.History;
import com.isep.projectjavawallet.bean.currency.FiatCurrency;
import com.isep.projectjavawallet.bean.wallet.fiatWallet.FiatWallet;


/* completed */
public class Wallet {
    private String walletName;
    private String description;
    private String IBAN;
    private double amount;
    private FiatCurrency referenceCurrency = FiatCurrency.EUR;

    private FiatWallet fiatWallet;
    private CryptoWallet cryptoWallet;

    private History history;





    // Constructors
    public Wallet() {
    }
    public Wallet(String walletName, String description, String IBAN, double amount, FiatCurrency referenceCurrency, FiatWallet fiatWallet, CryptoWallet cryptoWallet, History history) {
        this.walletName = walletName;
        this.description = description;
        this.IBAN = IBAN;
        this.amount = amount;
        this.referenceCurrency = referenceCurrency;
        this.fiatWallet = fiatWallet;
        this.cryptoWallet = cryptoWallet;
        this.history = history;
    }

    // Setters
    public void setWalletName(String walletName) {
        this.walletName = walletName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setReferenceCurrency(FiatCurrency referenceCurrency) {
        this.referenceCurrency = referenceCurrency;
    }

    // Getters

    public String getWalletName() {
        return walletName;
    }

    public String getDescription() {
        return description;
    }

    public String getIBAN() {
        return IBAN;
    }

    public double getAmount() {
        return amount;
    }

    public FiatCurrency getReferenceCurrency() {
        return referenceCurrency;
    }

    public FiatWallet getFiatWallet() {
        return fiatWallet;
    }

    public CryptoWallet getCryptoWallet() {
        return cryptoWallet;
    }

    public History getHistory() {
        return history;
    }
}
