package com.isep.projectjavawallet.bean.wallet.fiatWallet;


import com.isep.projectjavawallet.bean.currency.FiatCurrency;

/* completed */
public class Transaction {
    private final double tradedBalance;
    private final FiatCurrency balanceCurrency;
    private final TransactionType transactionType;

    private final String receiverIBAN;
    private final FiatCurrency newCurrency;




    // constructors
    public Transaction(double tradedBalance, FiatCurrency balanceCurrency, TransactionType transactionType, String receiverIBAN, FiatCurrency newCurrency) {
        this.tradedBalance = tradedBalance;
        this.balanceCurrency = balanceCurrency;
        this.transactionType = transactionType;
        this.receiverIBAN = receiverIBAN;
        this.newCurrency = newCurrency;
    }



    // getters
    public double getTradedBalance() {
        return tradedBalance;
    }

    public FiatCurrency getBalanceCurrency() {
        return balanceCurrency;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public String getReceiverIBAN() {
        return receiverIBAN;
    }

    public FiatCurrency getNewCurrency() {
        return newCurrency;
    }
}
