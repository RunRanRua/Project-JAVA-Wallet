package com.isep.projectjavawallet.bean.setting;


import com.isep.projectjavawallet.bean.setting.Account;

/* completed */
public class Profile {
    private Account account;
    private final Help help = new Help();
    private final About about = new About();
    private final Policy policy = new Policy();

    // loading method
    public void loadAccount(Account account){
        this.account = account;
    }


    public Profile(Account account) {
        this.account = account;
    }

    // getters
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
