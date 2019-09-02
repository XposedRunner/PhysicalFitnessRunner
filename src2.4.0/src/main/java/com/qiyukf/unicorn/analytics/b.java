package com.qiyukf.unicorn.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import com.sina.weibo.sdk.statistic.LogBuilder;
import java.util.Random;

public final class b {
    private static Context a;

    public static void a(float f) {
        if (f != d().getFloat("YSF_SAMPLING_RATE", 0.0f)) {
            d().edit().putFloat("YSF_SAMPLING_RATE", f).commit();
            d().edit().putBoolean("YSF_SWITCH", new Random().nextFloat() < f).commit();
        }
    }

    public static void a(long j) {
        c("YSF_DISTINCT_PERIOD", j * 60000);
    }

    public static void a(Context context) {
        a = context.getApplicationContext();
    }

    public static void a(String str, long j) {
        StringBuilder stringBuilder = new StringBuilder("YSF_ERROR_");
        stringBuilder.append(str);
        c(stringBuilder.toString(), j);
    }

    public static boolean a() {
        return d().getBoolean("YSF_SWITCH", false);
    }

    public static boolean a(String str) {
        if (!a()) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder("YSF_ERROR_");
        stringBuilder.append(str);
        return System.currentTimeMillis() - b(stringBuilder.toString(), 0) > b("YSF_DISTINCT_PERIOD", 3600000);
    }

    private static long b(String str, long j) {
        return d().getLong(str, j);
    }

    public static boolean b() {
        return System.currentTimeMillis() - b("YSF_LAST_CONFIG_TIME", 0) >= LogBuilder.MAX_INTERVAL;
    }

    public static void c() {
        c("YSF_LAST_CONFIG_TIME", System.currentTimeMillis());
    }

    private static void c(String str, long j) {
        d().edit().putLong(str, j).commit();
    }

    private static SharedPreferences d() {
        return a.getSharedPreferences("com.qiyukf.analytics", 0);
    }
}
