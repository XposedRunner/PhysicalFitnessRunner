package com.umeng.socialize;

import java.util.HashMap;
import java.util.Map;

public class PlatformConfig {
    public static Map<by, Platform> configs = new HashMap();

    static {
        configs.put(by.O0000O0o, new APPIDPlatform(by.O0000O0o));
        configs.put(by.O00000oo, new APPIDPlatform(by.O00000oo));
        configs.put(by.O0000Oo0, new APPIDPlatform(by.O0000Oo0));
        configs.put(by.O000O0oo, new APPIDPlatform(by.O0000Oo0));
        configs.put(by.O0000Oo, new APPIDPlatform(by.O0000Oo));
        configs.put(by.O0000OoO, new APPIDPlatform(by.O0000OoO));
        configs.put(by.O0000o0O, new CustomPlatform(by.O0000o0O));
        configs.put(by.O0000o00, new CustomPlatform(by.O0000o00));
        configs.put(by.O0000o, new APPIDPlatform(by.O0000o));
        configs.put(by.O0000oO0, new APPIDPlatform(by.O0000oO0));
        configs.put(by.O0000oO, new APPIDPlatform(by.O0000oO));
        configs.put(by.O0000oOO, new APPIDPlatform(by.O0000oOO));
        configs.put(by.O00000oO, new APPIDPlatform(by.O00000oO));
        configs.put(by.O0000Ooo, new CustomPlatform(by.O0000Ooo));
        configs.put(by.O000O0o0, new APPIDPlatform(by.O000O0o0));
        configs.put(by.O0000OOo, new CustomPlatform(by.O0000OOo));
        configs.put(by.O000O0oO, new APPIDPlatform(by.O000O0oO));
        configs.put(by.O000000o, new CustomPlatform(by.O000000o));
        configs.put(by.O0000o0, new CustomPlatform(by.O0000o0));
        configs.put(by.O0000o0o, new APPIDPlatform(by.O0000o0o));
        configs.put(by.O00oOoOo, new CustomPlatform(by.O00oOoOo));
        configs.put(by.O0000oo0, new APPIDPlatform(by.O0000oo0));
        configs.put(by.O0000ooO, new CustomPlatform(by.O0000ooO));
        configs.put(by.O000O00o, new CustomPlatform(by.O000O00o));
        configs.put(by.O00000o, new CustomPlatform(by.O00000o));
        configs.put(by.O00000o0, new CustomPlatform(by.O00000o0));
        configs.put(by.O0000ooo, new CustomPlatform(by.O0000ooo));
        configs.put(by.O000O0OO, new CustomPlatform(by.O000O0OO));
        configs.put(by.O000O0Oo, new CustomPlatform(by.O000O0Oo));
        configs.put(by.O0000oo, new CustomPlatform(by.O0000oo));
        configs.put(by.O00oOooO, new CustomPlatform(by.O00oOooO));
        configs.put(by.O00oOooo, new CustomPlatform(by.O00oOooo));
        configs.put(by.O000O0o, new APPIDPlatform(by.O000O0o));
        configs.put(by.O0000oOo, new CustomPlatform(by.O0000oOo));
        configs.put(by.O000OO0o, new CustomPlatform(by.O000OO0o));
        configs.put(by.O000OO00, new APPIDPlatform(by.O000OO0o));
    }

    public static Platform getPlatform(by byVar) {
        return (Platform) configs.get(byVar);
    }

    public static void setAlipay(String str) {
        ((APPIDPlatform) configs.get(by.O000O0o0)).appId = str.replace(" ", "");
    }

    public static void setDing(String str) {
        ((APPIDPlatform) configs.get(by.O000OO00)).appId = str.replace(" ", "");
    }

    public static void setDropbox(String str, String str2) {
        APPIDPlatform aPPIDPlatform = (APPIDPlatform) configs.get(by.O000O0oO);
        aPPIDPlatform.appId = str.replace(" ", "");
        aPPIDPlatform.appkey = str2.replace(" ", "");
    }

    public static void setKakao(String str) {
        ((APPIDPlatform) configs.get(by.O000O0o)).appId = str.replace(" ", "");
    }

    public static void setLaiwang(String str, String str2) {
        APPIDPlatform aPPIDPlatform = (APPIDPlatform) configs.get(by.O0000o);
        aPPIDPlatform.appId = str.replace(" ", "");
        aPPIDPlatform.appkey = str2.replace(" ", "");
        aPPIDPlatform = (APPIDPlatform) configs.get(by.O0000oO0);
        aPPIDPlatform.appId = str.replace(" ", "");
        aPPIDPlatform.appkey = str2.replace(" ", "");
    }

    public static void setPinterest(String str) {
        ((APPIDPlatform) configs.get(by.O0000oo0)).appId = str.replace(" ", "");
    }

    public static void setQQZone(String str, String str2) {
        APPIDPlatform aPPIDPlatform = (APPIDPlatform) configs.get(by.O00000oo);
        aPPIDPlatform.appId = str.replace(" ", "");
        aPPIDPlatform.appkey = str2.replace(" ", "");
        aPPIDPlatform = (APPIDPlatform) configs.get(by.O0000O0o);
        aPPIDPlatform.appId = str.replace(" ", "");
        aPPIDPlatform.appkey = str2.replace(" ", "");
    }

    public static void setSinaWeibo(String str, String str2, String str3) {
        APPIDPlatform aPPIDPlatform = (APPIDPlatform) configs.get(by.O00000oO);
        aPPIDPlatform.appId = str.replace(" ", "");
        aPPIDPlatform.appkey = str2.replace(" ", "");
        aPPIDPlatform.redirectUrl = str3;
    }

    public static void setTwitter(String str, String str2) {
        APPIDPlatform aPPIDPlatform = (APPIDPlatform) configs.get(by.O0000o0o);
        aPPIDPlatform.appId = str.replace(" ", "");
        aPPIDPlatform.appkey = str2.replace(" ", "");
    }

    public static void setVKontakte(String str, String str2) {
        APPIDPlatform aPPIDPlatform = (APPIDPlatform) configs.get(by.O000O0oo);
        aPPIDPlatform.appId = str.replace(" ", "");
        aPPIDPlatform.appkey = str2.replace(" ", "");
    }

    public static void setWeixin(String str, String str2) {
        APPIDPlatform aPPIDPlatform = (APPIDPlatform) configs.get(by.O0000Oo0);
        aPPIDPlatform.appId = str.replace(" ", "");
        aPPIDPlatform.appkey = str2.replace(" ", "");
        aPPIDPlatform = (APPIDPlatform) configs.get(by.O0000Oo);
        aPPIDPlatform.appId = str.replace(" ", "");
        aPPIDPlatform.appkey = str2.replace(" ", "");
        aPPIDPlatform = (APPIDPlatform) configs.get(by.O0000OoO);
        aPPIDPlatform.appId = str.replace(" ", "");
        aPPIDPlatform.appkey = str2.replace(" ", "");
    }

    public static void setYixin(String str) {
        ((APPIDPlatform) configs.get(by.O0000oO)).appId = str.replace(" ", "");
        ((APPIDPlatform) configs.get(by.O0000oOO)).appId = str.replace(" ", "");
    }
}
