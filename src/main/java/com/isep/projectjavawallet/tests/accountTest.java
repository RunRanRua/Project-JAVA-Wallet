package com.isep.projectjavawallet.tests;

import com.isep.projectjavawallet.bean.setting.Account;
import com.isep.projectjavawallet.dao.AccountDao;

import java.sql.SQLException;

public class accountTest {
    public static void main(String[] args) throws SQLException {
        boolean a = new AccountDao().insertUser(new Account());

    }


}
