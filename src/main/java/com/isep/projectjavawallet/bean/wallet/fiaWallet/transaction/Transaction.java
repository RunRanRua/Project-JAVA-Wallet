package com.isep.projectjavawallet.bean.wallet.fiaWallet.transaction;

public class Transaction {
    private TransactionType type;
    private String date;
    private double remainingBalance;


    // convert String to TransactionType
    public TransactionType toTransactionType(String type){
        switch (type){
            case "DEPOSIT":
                return TransactionType.DEPOSIT;
            case "TRANSFER":
                return TransactionType.TRANSFER;
            case "STOCK":
                return  TransactionType.STOCK;
            default:
                return null;
        }
    }


    @Override
    public String toString() {
        return "Transaction type : " + type + "\t\t" +
                "Remaining Balance : " + remainingBalance + "\t\t" +
                "Date : " + date;
    }


    public Transaction(){}
    public Transaction(TransactionType type, String date, double remainingBalance) {
        this.type = type;
        this.date = date;
        this.remainingBalance = remainingBalance;
    }

    // getter & setter
    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getRemainingBalance() {
        return remainingBalance;
    }

    public void setRemainingBalance(double remainingBalance) {
        this.remainingBalance = remainingBalance;
    }
}
