package com.qiyukf.basesdk.c.d;

import java.math.BigDecimal;

public final class f {
    public static long a(long j) {
        return (long) new BigDecimal((double) (((float) j) / 1000.0f)).setScale(0, 4).intValue();
    }

    public static String a(int i) {
        if (i < 0 || i >= 10) {
            return String.valueOf(i);
        }
        StringBuilder stringBuilder = new StringBuilder("0");
        stringBuilder.append(Integer.toString(i));
        return stringBuilder.toString();
    }
}
