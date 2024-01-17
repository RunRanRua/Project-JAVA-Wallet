package com.isep.projectjavawallet.bean.wallet.fiatWallet.assets;

import com.isep.projectjavawallet.bean.currency.FiatCurrency;

import java.util.ArrayList;




/*  Completed */
public class Action {
    private final String actionName;
    private final int actionQuantity;
    private final double purchasePrice;
    private final FiatCurrency actionCurrency;
    private final double totalPrice;
    private final String purchaseDate;
    private final ArrayList<ActionEvolution> actionEvolution;



    // methods
    public void addActionEvolution(ActionEvolution actionEvolution){
        this.actionEvolution.add(actionEvolution);
    }


    // constructors
    public Action(String actionName, int actionQuantity, double purchasePrice, FiatCurrency actionCurrency, double totalPrice, String purchaseDate, ArrayList<ActionEvolution> actionEvolution) {
        this.actionName = actionName;
        this.actionQuantity = actionQuantity;
        this.purchasePrice = purchasePrice;
        this.actionCurrency = actionCurrency;
        this.totalPrice = totalPrice;
        this.purchaseDate = purchaseDate;
        this.actionEvolution = actionEvolution;
    }

    // getters
    public String getActionName() {
        return actionName;
    }

    public int getActionQuantity() {
        return actionQuantity;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public FiatCurrency getActionCurrency() {
        return actionCurrency;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public ArrayList<ActionEvolution> getActionEvolution() {
        return actionEvolution;
    }
}
