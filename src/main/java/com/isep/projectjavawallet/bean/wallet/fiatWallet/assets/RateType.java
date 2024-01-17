package com.isep.projectjavawallet.bean.wallet.fiatWallet.assets;

public enum RateType {

    FLAT,           // interest rate that is the same in all cases (Not dependent on market evolution)
    FLOATING,       // interest rate that changes periodically (depending on market evolution)
    ZERO            // the sum of interest will be paid at the maturated day
}
