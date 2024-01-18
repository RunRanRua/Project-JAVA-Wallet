package com.isep.projectjavawallet.bean.wallet.fiatWallet;


import com.isep.projectjavawallet.bean.currency.FiatCurrency;

/* completed */
public class Transaction {

    private final TransactionType transactionType;

    private final String receiverIBAN;
    private final FiatCurrency newCurrency;




    // constructors
    public Transaction(TransactionType transactionType, String receiverIBAN, FiatCurrency newCurrency) {
        this.transactionType = transactionType;
        this.receiverIBAN = receiverIBAN;
        this.newCurrency = newCurrency;
    }

    // getters

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
