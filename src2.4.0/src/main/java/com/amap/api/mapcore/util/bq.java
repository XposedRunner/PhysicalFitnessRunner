package com.amap.api.mapcore.util;

import com.sina.weibo.sdk.statistic.LogBuilder;
import java.util.Calendar;
import java.util.Date;

/* compiled from: DateUtil */
public final class bq {
    private static long O000000o(long j) {
        return j - O00000Oo(j);
    }

    public static long O000000o(long j, long j2) {
        try {
            if (Math.abs(j - j2) > 31536000000L) {
                return O00000Oo(j, j2);
            }
        } catch (Throwable unused) {
        }
        return j;
    }

    private static long O00000Oo(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date(j));
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return instance.getTimeInMillis();
    }

    private static long O00000Oo(long j, long j2) {
        long O00000Oo = O00000Oo(j2) + O000000o(j);
        j = Math.abs(O00000Oo - j2);
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date(O00000Oo));
        int i = instance.get(11);
        if (i == 23 && j >= 82800000) {
            O00000Oo -= LogBuilder.MAX_INTERVAL;
        }
        return (i != 0 || j < 82800000) ? O00000Oo : O00000Oo + LogBuilder.MAX_INTERVAL;
    }
}
