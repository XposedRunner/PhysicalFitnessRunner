package com.loc;

import java.util.HashMap;
import java.util.Map;

@ap(a = "file")
/* compiled from: DynamicPlugin */
public class O00O000o {
    @aq(a = "fname", b = 6)
    private String O000000o;
    @aq(a = "md", b = 6)
    private String O00000Oo;
    @aq(a = "version", b = 6)
    private String O00000o;
    @aq(a = "sname", b = 6)
    private String O00000o0;
    @aq(a = "dversion", b = 6)
    private String O00000oO;
    @aq(a = "status", b = 6)
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

        public final O000000o O000000o(String str) {
            this.O00000oo = str;
            return this;
        }

        public final O00O000o O000000o() {
            return new O00O000o(this);
        }
    }

    private O00O000o() {
    }

    public O00O000o(O000000o o000000o) {
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
        return O000O0o.O000000o(hashMap);
    }

    public static String O000000o(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("sname", str);
        hashMap.put("dversion", str2);
        return O000O0o.O000000o(hashMap);
    }

    public static String O000000o(String str, String str2, String str3, String str4) {
        Map hashMap = new HashMap();
        hashMap.put("fname", str);
        hashMap.put("sname", str2);
        hashMap.put("dversion", str4);
        hashMap.put("version", str3);
        return O000O0o.O000000o(hashMap);
    }

    public static String O00000Oo(String str) {
        Map hashMap = new HashMap();
        hashMap.put("fname", str);
        return O000O0o.O000000o(hashMap);
    }

    public static String O00000Oo(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("sname", str);
        hashMap.put("status", str2);
        return O000O0o.O000000o(hashMap);
    }

    public final String O000000o() {
        return this.O000000o;
    }

    public final String O00000Oo() {
        return this.O00000Oo;
    }

    public final String O00000o() {
        return this.O00000o;
    }

    public final String O00000o0() {
        return this.O00000o0;
    }

    public final void O00000o0(String str) {
        this.O00000oo = str;
    }

    public final String O00000oO() {
        return this.O00000oO;
    }

    public final String O00000oo() {
        return this.O00000oo;
    }
}
