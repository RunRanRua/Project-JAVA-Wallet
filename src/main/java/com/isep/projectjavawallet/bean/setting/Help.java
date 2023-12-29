package com.isep.projectjavawallet.bean.setting;



/* uncompleted
        - contents
*/
public class Help {
    private static String helpForWallet;
    private static String helpForMarket;
    private static String helpForConnection;




    // constructor
    public Help(){
        helpForWallet = "There is no help for wallet yet.";
        helpForMarket = "There is no help for market yet.";
        helpForConnection = "There is no help for connection yet.";
    }


    // Getters
    public String getHelpForWallet() {
        return helpForWallet;
    }

    public String getHelpForMarket() {
        return helpForMarket;
    }

    public String getHelpForConnection() {
        return helpForConnection;
    }
}
