package com.isep.projectjavawallet.bean.market;

public class Stock {
    private final String symbol;
    private final int price;
    private final int quantity;
    private final String date;


    public Stock(String symbol, int price, int quantity, String date) {
        this.symbol = symbol;
        this.price = price;
        this.quantity = quantity;
        this.date = date;
    }

    @Override
    public String toString() {
        return symbol + "\t\t"
                + date + "\t\t"
                + " price: " + price + " USD\t\t"
                + " quantity: " + quantity;
    }
    public String toString_own(){
        return symbol + "\t\t"
                + "quantity: " + quantity;
    }



    // getters
    public String getSymbol() {
        return symbol;
    }
    public int getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }

    public String getDate() {
        return date;
    }

}
