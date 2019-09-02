package com.zjwh.android_wh_physicalfitness.utils;

/* compiled from: TimeCommonUtils */
public class O00OOo0 {
    private static long O000000o;

    public static boolean O000000o() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - O000000o;
        if (0 < j && j < 1000) {
            return true;
        }
        O000000o = currentTimeMillis;
        return false;
    }
}
