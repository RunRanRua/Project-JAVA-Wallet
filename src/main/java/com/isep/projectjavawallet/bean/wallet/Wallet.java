package com.isep.projectjavawallet.bean.wallet;

import com.isep.projectjavawallet.bean.wallet.fiatWallet.History;
import com.isep.projectjavawallet.bean.currency.FiatCurrency;
import com.isep.projectjavawallet.bean.wallet.fiatWallet.FiatWallet;
import com.isep.projectjavawallet.util.IBANgeneration;

import java.sql.SQLException;


/* completed */
public class Wallet {
    private String walletName;
    private String description;
    private String IBAN;
    private double amount =0;
    private String referenceCurrency = FiatCurrency.EUR.toString();

    private FiatWallet fiatWallet;
    private CryptoWallet cryptoWallet;

    private History history;





    // Constructors
    public Wallet() {
    }

    // when creating
    public Wallet(String walletName, String description, FiatWallet fiatWallet, CryptoWallet cryptoWallet, History history) throws SQLException {
        this.walletName = walletName;
        this.description = description;
        this.IBAN = IBANgeneration.generateIBAN();
        this.fiatWallet = fiatWallet;
        this.cryptoWallet = cryptoWallet;
        this.history = history;
    }


    // when loading
    public Wallet(String walletName, String description, String IBAN, double amount, String referenceCurrency, FiatWallet fiatWallet, CryptoWallet cryptoWallet, History history) {
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

    public void setReferenceCurrency(String referenceCurrency) {
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

    public String getReferenceCurrency() {
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

    // To String

    @Override
    public String toString() {
        return "Wallet{" +
                "walletName='" + walletName + '\'' +
                ", description='" + description + '\'' +
                ", IBAN='" + IBAN + '\'' +
                ", amount=" + amount +
                ", referenceCurrency=" + referenceCurrency +
                ", fiatWallet=" + fiatWallet +
                ", cryptoWallet=" + cryptoWallet +
                ", history=" + history +
                '}';
    }
}
