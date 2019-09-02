package com.loc;

import com.sina.weibo.sdk.statistic.LogBuilder;
import java.util.Calendar;
import java.util.Date;

/* compiled from: DateUtil */
public final class O0o000 {
    private static long O000000o(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date(j));
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return instance.getTimeInMillis();
    }

    public static long O000000o(long j, long j2, int i) {
        if (i <= 0) {
            return j;
        }
        try {
            if (Math.abs(j - j2) <= ((long) i) * 31536000000L) {
                return j;
            }
            long O000000o = O000000o(j2) + (j - O000000o(j));
            j2 = Math.abs(O000000o - j2);
            Calendar instance = Calendar.getInstance();
            instance.setTime(new Date(O000000o));
            i = instance.get(11);
            j = (i != 23 || j2 < 82800000) ? O000000o : O000000o - LogBuilder.MAX_INTERVAL;
            return (i != 0 || j2 < 82800000) ? j : j + LogBuilder.MAX_INTERVAL;
        } catch (Throwable unused) {
            return j;
        }
    }
}
