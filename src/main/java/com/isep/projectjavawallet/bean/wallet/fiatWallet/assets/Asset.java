package com.isep.projectjavawallet.bean.wallet.fiatWallet.assets;

import java.util.ArrayList;


/* Uncompleted
*       - 3 methods
*/
public class Asset {
    private ArrayList<Bond> bonds;
    private ArrayList<Action>actions;



    // methods
    public void bondMaturated(Bond bond){
    }
    public void sellBond(Bond bond){
    }
    public void sellAction(Action action){

    }




    // constructors
    public Asset() {
    }

    public Asset(ArrayList<Bond> bonds, ArrayList<Action> actions) {
        this.bonds = bonds;
        this.actions = actions;
    }


    // getters
    public ArrayList<Bond> getBonds() { return bonds;}

    public ArrayList<Action> getActions() {return actions;}
}
