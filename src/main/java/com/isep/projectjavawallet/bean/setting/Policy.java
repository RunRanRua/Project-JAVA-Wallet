package com.isep.projectjavawallet.bean.setting;



/* uncompleted
        - contents
*/
public class Policy {
    private static String personalInformation;
    private static String security;
    private static String accountDeletion;


    // constructor
    public Policy(){
        personalInformation = "There is no personal information ";
        security = "we have no security";
        accountDeletion = "your demand will be denied";
    }

    // getters
    public String getPersonalInformation() {
        return personalInformation;
    }

    public String getSecurity() {
        return security;
    }

    public String getAccountDeletion() {
        return accountDeletion;
    }
}
