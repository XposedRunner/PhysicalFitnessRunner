package com.amap.api.mapcore.util;

import java.util.HashMap;
import java.util.Map;

@hz(a = "file")
/* compiled from: DynamicPlugin */
public class oOOoOOO0 {
    @ia(a = "fname", b = 6)
    private String O000000o;
    @ia(a = "md", b = 6)
    private String O00000Oo;
    @ia(a = "version", b = 6)
    private String O00000o;
    @ia(a = "sname", b = 6)
    private String O00000o0;
    @ia(a = "dversion", b = 6)
    private String O00000oO;
    @ia(a = "status", b = 6)
    private String O00000oo;

    /* compiled from: DynamicPlugin */
    public static class O000000o {
        private String O000000o;
        private String O00000Oo;
        private String O00000o;
        private String O00000o0;
        private String O00000oO;
        private String O00000oo = "copy";

        public O000000o(String str, String str2, String str3, String str4, String str5) {
            this.O000000o = str;
            this.O00000Oo = str2;
            this.O00000o0 = str3;
            this.O00000o = str4;
            this.O00000oO = str5;
        }

        public O000000o O000000o(String str) {
            this.O00000oo = str;
            return this;
        }

        public oOOoOOO0 O000000o() {
            return new oOOoOOO0(this);
        }
    }

    private oOOoOOO0() {
    }

    public oOOoOOO0(O000000o o000000o) {
        this.O000000o = o000000o.O000000o;
        this.O00000Oo = o000000o.O00000Oo;
        this.O00000o0 = o000000o.O00000o0;
        this.O00000o = o000000o.O00000o;
        this.O00000oO = o000000o.O00000oO;
        this.O00000oo = o000000o.O00000oo;
    }

    public static String O000000o(String str) {
        Map hashMap = new HashMap();
        hashMap.put("sname", str);
        return oO0O0o0o.O000000o(hashMap);
    }

    public static String O000000o(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("sname", str);
        hashMap.put("dversion", str2);
        return oO0O0o0o.O000000o(hashMap);
    }

    public static String O000000o(String str, String str2, String str3, String str4) {
        Map hashMap = new HashMap();
        hashMap.put("fname", str);
        hashMap.put("sname", str2);
        hashMap.put("dversion", str4);
        hashMap.put("version", str3);
        return oO0O0o0o.O000000o(hashMap);
    }

    public static String O00000Oo(String str) {
        Map hashMap = new HashMap();
        hashMap.put("fname", str);
        return oO0O0o0o.O000000o(hashMap);
    }

    public static String O00000Oo(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("sname", str);
        hashMap.put("status", str2);
        return oO0O0o0o.O000000o(hashMap);
    }

    public String O000000o() {
        return this.O000000o;
    }

    public String O00000Oo() {
        return this.O00000Oo;
    }

    public String O00000o() {
        return this.O00000o;
    }

    public String O00000o0() {
        return this.O00000o0;
    }

    public void O00000o0(String str) {
        this.O00000oo = str;
    }

    public String O00000oO() {
        return this.O00000oO;
    }

    public String O00000oo() {
        return this.O00000oo;
    }
}
