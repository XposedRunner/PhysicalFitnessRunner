package com.qiyukf.nimlib.b;

public final class d {

    public enum a {
        TEST("t", "223.252.220.222:2000", "http://223.252.220.223/lbs/conf"),
        PRE_REL("p", "106.2.34.102:8080", "http://223.252.220.223/lbsrc/conf.jsp"),
        REL("r", "link.netease.im:8080", "https://lbs.netease.im/lbs/conf.jsp");
        
        String d;
        String e;
        String f;

        private a(String str, String str2, String str3) {
            this.d = str;
            this.e = str2;
            this.f = str3;
        }
    }

    public static int a() {
        return e.b();
    }

    public static boolean b() {
        return e.a();
    }

    public static void c() {
        e.c();
    }

    public static boolean d() {
        return e.a == a.PRE_REL;
    }

    public static boolean e() {
        return com.qiyukf.basesdk.a.d() != null;
    }
}
