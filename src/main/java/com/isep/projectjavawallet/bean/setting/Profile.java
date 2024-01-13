package com.isep.projectjavawallet.bean.setting;


/* completed */
public class Profile {
    private Account account;
    private final Help help;
    private final About about;
    private final Policy policy;



    // constructors
    public Profile(){
        account = new Account();
        help = new Help();
        about = new About();
        policy = new Policy();
    }
    public Profile(Account account){
        this.account = account;
        help = new Help();
        about = new About();
        policy = new Policy();
    }

    // getters
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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
