package com.isep.projectjavawallet.bean.wallet.fiatWallet;

import com.isep.projectjavawallet.bean.wallet.fiatWallet.assets.Action;
import com.isep.projectjavawallet.bean.wallet.fiatWallet.assets.Bond;

import java.util.ArrayList;



/* completed */
public class History {
    private final ArrayList<Bond> bondHistory; 
    private final ArrayList<Action> actionHistory; 
    private final ArrayList<Transaction> transactionHistory;

    public History(){
        bondHistory = new ArrayList<Bond>();
        actionHistory = new ArrayList<Action>();
        transactionHistory = new ArrayList<Transaction>();
    }

    // methods
    public void addBondHistory(Bond bond){
        bondHistory.add(bond);
    }
    public void addActionHistory(Action action){
        actionHistory.add(action);
    }
    public void addTransactionHistory(Transaction transaction){
        transactionHistory.add(transaction);
    }



    // constructors
    public History(ArrayList<Bond> bondHistory, ArrayList<Action> actionHistory, ArrayList<Transaction> transactionHistory) {
        this.bondHistory = bondHistory;
        this.actionHistory = actionHistory;
        this.transactionHistory = transactionHistory;
    }


    // getters
    public ArrayList<Bond> getBondHistory() {
        return bondHistory;
    }

    public ArrayList<Action> getActionHistory() {
        return actionHistory;
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
}
