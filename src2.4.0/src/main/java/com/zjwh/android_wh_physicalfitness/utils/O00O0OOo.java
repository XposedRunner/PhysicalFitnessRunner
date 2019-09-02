package com.zjwh.android_wh_physicalfitness.utils;

/* compiled from: Regexp */
public class O00O0OOo {
    public static final String O000000o = "[1]\\d{10}";
    public static final String O00000Oo = "^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{6,12}$";
    public static final String O00000o = "^[\\u4e00-\\u9fa5A-Za-z\\s]*$";
    public static final String O00000o0 = "^[0-9a-zA-Z]*$";
    public static final String O00000oO = "^[\\u4e00-\\u9fa5A-Za-z0-9\\s]*$";

    public static boolean O000000o(String str) {
        return str.matches(O000000o);
    }

    public static boolean O00000Oo(String str) {
        return str.matches(O00000Oo);
    }

    public static boolean O00000o(String str) {
        return str.matches(O00000o);
    }

    public static boolean O00000o0(String str) {
        return str.matches(O00000o0);
    }

    public static boolean O00000oO(String str) {
        return str.matches(O00000oO);
    }
}
