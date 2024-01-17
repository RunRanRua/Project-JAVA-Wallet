package com.isep.projectjavawallet.tests;

import com.isep.projectjavawallet.bean.currency.FiatCurrency;
import com.isep.projectjavawallet.bean.setting.Account;
import com.isep.projectjavawallet.bean.wallet.CryptoWallet;
import com.isep.projectjavawallet.bean.wallet.Wallet;
import com.isep.projectjavawallet.bean.wallet.fiatWallet.FiatWallet;
import com.isep.projectjavawallet.bean.wallet.fiatWallet.History;
import com.isep.projectjavawallet.dao.AccountDao;
import com.isep.projectjavawallet.dao.WalletListDao;

import java.sql.SQLException;

public class accountDBTest {
    public static void main(String[] args) throws SQLException {
        // find
        /*
        Account account = new AccountDao().findAccount("username2");
        if (account!= null){
            System.out.println(account.toString());
        }
         */


        // insert
        /*
        Account account = new Account("username6","1","E","mail@fr5");
        boolean a = new AccountDao().insertAccount(account);
        System.out.println(a);
        */

        // modify PWD / Mail
        /*
        Account account = new Account("username5","1","E","mail@fr5");
        String newPWD = "321654";
        boolean a = new AccountDao().modifyPassword(account,newPWD);
        System.out.println(a);

        String newMail = "mailXX";
        boolean b = new AccountDao().modifyMail(account,newMail);
        System.out.println(b);
         */








    }


}
