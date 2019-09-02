package com.umeng.socialize;

public class Config {
    public static String Descriptor = "com.umeng.share";
    public static String EntityKey = "-1";
    public static String EntityName = "share";
    @Deprecated
    public static int KaKaoLoginType = 0;
    @Deprecated
    public static int LinkedInProfileScope = 0;
    @Deprecated
    public static int LinkedInShareCode = 0;
    public static final int MINIPTOGRAM_TYPE_RELEASE = 0;
    public static String MORE_TITLE = "分享";
    @Deprecated
    public static boolean OpenEditor = true;
    @Deprecated
    public static String QQAPPNAME = "";
    @Deprecated
    public static int QQWITHQZONE = 2;
    public static String SessionId = null;
    private static int a = 0;
    @Deprecated
    public static String appName = null;
    public static int connectionTimeOut = 30000;
    public static boolean isFacebookRead = false;
    public static boolean isJumptoAppStore = false;
    @Deprecated
    public static boolean isNeedAuth = false;
    public static Boolean isUmengQQ = Boolean.valueOf(true);
    public static Boolean isUmengSina = Boolean.valueOf(true);
    public static Boolean isUmengWx = Boolean.valueOf(true);
    public static final boolean mEncrypt = false;
    public static int readSocketTimeOut = 30000;
    public static String shareType = "native";

    public static int getMINITYPE() {
        return a;
    }

    public static void setMiniPreView() {
        a = 2;
    }

    public static void setMiniTest() {
        a = 1;
    }
}
