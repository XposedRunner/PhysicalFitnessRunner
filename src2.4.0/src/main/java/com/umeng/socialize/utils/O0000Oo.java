package com.umeng.socialize.utils;

import android.content.Context;
import android.os.Build;
import defpackage.by;
import defpackage.ce;

/* compiled from: URLBuilder */
public class O0000Oo {
    private String O000000o = "0";
    private String O00000Oo = null;
    private String O00000o = null;
    private String O00000o0 = null;
    private String O00000oO = null;
    private String O00000oo = null;
    private String O0000O0o = null;
    private String O0000OOo = null;
    private String O0000Oo = null;
    private String O0000Oo0 = null;
    private String O0000OoO = null;
    private String O0000Ooo = null;
    private String O0000o = null;
    private String O0000o0 = null;
    private String O0000o00 = null;
    private String O0000o0O = null;
    private String O0000o0o = null;

    public O0000Oo(Context context) {
        this.O0000Oo = O00000o.O000000o(context);
        this.O0000OoO = O00000o.O00000oo(context);
        this.O0000Ooo = O00000o.O00000Oo(context)[0];
        this.O0000o00 = Build.MODEL;
        this.O0000o0 = "6.9.4";
        this.O0000o0O = "Android";
        this.O0000o0o = String.valueOf(System.currentTimeMillis());
        this.O0000o = ce.O0000Oo0;
    }

    private String O00000o0() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("via=");
        stringBuilder.append(this.O0000Oo0.toLowerCase());
        stringBuilder.append("&opid=");
        stringBuilder.append(this.O00000oo);
        stringBuilder.append("&ak=");
        stringBuilder.append(this.O00000o);
        stringBuilder.append("&pcv=");
        stringBuilder.append(this.O0000o);
        stringBuilder.append("&tp=");
        stringBuilder.append(this.O000000o);
        if (this.O0000Oo != null) {
            stringBuilder.append("&imei=");
            stringBuilder.append(this.O0000Oo);
        }
        if (this.O0000OoO != null) {
            stringBuilder.append("&mac=");
            stringBuilder.append(this.O0000OoO);
        }
        if (this.O0000Ooo != null) {
            stringBuilder.append("&en=");
            stringBuilder.append(this.O0000Ooo);
        }
        if (this.O0000o00 != null) {
            stringBuilder.append("&de=");
            stringBuilder.append(this.O0000o00);
        }
        if (this.O0000o0 != null) {
            stringBuilder.append("&sdkv=");
            stringBuilder.append(this.O0000o0);
        }
        if (this.O0000o0O != null) {
            stringBuilder.append("&os=");
            stringBuilder.append(this.O0000o0O);
        }
        if (this.O0000o0o != null) {
            stringBuilder.append("&dt=");
            stringBuilder.append(this.O0000o0o);
        }
        if (this.O0000O0o != null) {
            stringBuilder.append("&uid=");
            stringBuilder.append(this.O0000O0o);
        }
        if (this.O00000oO != null) {
            stringBuilder.append("&ek=");
            stringBuilder.append(this.O00000oO);
        }
        if (this.O0000OOo != null) {
            stringBuilder.append("&sid=");
            stringBuilder.append(this.O0000OOo);
        }
        return stringBuilder.toString();
    }

    public O0000Oo O000000o(by byVar) {
        this.O0000Oo0 = byVar.toString();
        return this;
    }

    public O0000Oo O000000o(String str) {
        this.O00000Oo = str;
        return this;
    }

    public String O000000o() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.O00000Oo);
        stringBuilder.append(this.O00000o0);
        stringBuilder.append(this.O00000o);
        stringBuilder.append("/");
        stringBuilder.append(this.O00000oO);
        stringBuilder.append("/?");
        stringBuilder.append(O00000o0());
        return stringBuilder.toString();
    }

    public O0000Oo O00000Oo(String str) {
        this.O00000o0 = str;
        return this;
    }

    public String O00000Oo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.O00000Oo);
        stringBuilder.append(this.O00000o0);
        stringBuilder.append(this.O00000o);
        stringBuilder.append("/");
        stringBuilder.append(this.O00000oO);
        stringBuilder.append("/?");
        String O00000o0 = O00000o0();
        try {
            stringBuilder.append(O00000o0);
        } catch (Exception unused) {
            stringBuilder.append(O00000o0);
        }
        return stringBuilder.toString();
    }

    public O0000Oo O00000o(String str) {
        this.O00000oO = str;
        return this;
    }

    public O0000Oo O00000o0(String str) {
        this.O00000o = str;
        return this;
    }

    public O0000Oo O00000oO(String str) {
        this.O00000oo = str;
        return this;
    }

    public O0000Oo O00000oo(String str) {
        this.O0000OOo = str;
        return this;
    }

    public O0000Oo O0000O0o(String str) {
        this.O0000O0o = str;
        return this;
    }
}
