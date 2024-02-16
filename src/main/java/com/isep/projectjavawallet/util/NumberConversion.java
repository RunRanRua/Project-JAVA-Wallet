package com.isep.projectjavawallet.util;

import java.math.BigDecimal;

public class NumberConversion {
    public static double conversion(double num, int precision){
        BigDecimal bigDecimalValue = new BigDecimal(num);
        BigDecimal roundedValue = bigDecimalValue.setScale(precision, BigDecimal.ROUND_HALF_UP);
        return roundedValue.doubleValue();
    }
}
