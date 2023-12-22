package com.isep.projectjavawallet.bean.setting;

import com.isep.projectjavawallet.bean.setting.About;
import com.isep.projectjavawallet.bean.setting.Account;
import com.isep.projectjavawallet.bean.setting.Help;



public class Profil {
    private final Account account;
    private final Help help;
    private final About about;
    private final Policy policy;




    public Profil(){
        account = new Account();
        help = new Help();
        about = new About();
        policy = new Policy();
    }


    public Account getAccount() {
        return account;
    }

    public Help getHelp() {
        return help;
    }

    public About getAbout() {
        return about;
    }

    public Policy getPolicy() {
        return policy;
    }
}
