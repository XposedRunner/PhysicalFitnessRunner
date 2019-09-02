package com.umeng.socialize.handler;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

public class QQPreferences {
    private static final String O000000o = "access_token";
    private static final String O00000Oo = "openid";
    private static final String O00000o = "unionid";
    private static final String O00000o0 = "uid";
    private static final String O00000oO = "expires_in";
    private static long O0000O0o;
    private String O00000oo = null;
    private String O0000OOo = null;
    private String O0000Oo = null;
    private String O0000Oo0 = null;
    private SharedPreferences O0000OoO = null;

    public QQPreferences(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("full");
        this.O0000OoO = context.getSharedPreferences(stringBuilder.toString(), 0);
        this.O00000oo = this.O0000OoO.getString("access_token", null);
        this.O0000OOo = this.O0000OoO.getString("uid", null);
        this.O0000Oo = this.O0000OoO.getString("openid", null);
        O0000O0o = this.O0000OoO.getLong("expires_in", 0);
        this.O0000Oo0 = this.O0000OoO.getString("unionid", null);
    }

    public static long O00000o0() {
        return O0000O0o;
    }

    public QQPreferences O000000o(Bundle bundle) {
        this.O00000oo = bundle.getString("access_token");
        O0000O0o = (Long.valueOf(bundle.getString("expires_in")).longValue() * 1000) + System.currentTimeMillis();
        this.O0000Oo = bundle.getString("openid");
        this.O0000OOo = bundle.getString("openid");
        this.O0000Oo0 = bundle.getString("unionid");
        return this;
    }

    public String O000000o() {
        return this.O00000oo;
    }

    public void O000000o(String str) {
        this.O0000OOo = str;
    }

    public String O00000Oo() {
        return this.O0000Oo0;
    }

    public void O00000Oo(String str) {
        this.O0000Oo0 = str;
    }

    public String O00000o() {
        return this.O0000OOo;
    }

    public void O00000o0(String str) {
        this.O0000Oo = str;
    }

    public boolean O00000oO() {
        return (this.O00000oo == null || (O0000O0o - System.currentTimeMillis() <= 0)) ? false : true;
    }

    public void O00000oo() {
        this.O0000OoO.edit().putString("access_token", this.O00000oo).putLong("expires_in", O0000O0o).putString("uid", this.O0000OOo).putString("openid", this.O0000Oo).putString("unionid", this.O0000Oo0).commit();
    }

    public void O0000O0o() {
        this.O00000oo = null;
        O0000O0o = 0;
        this.O0000OoO.edit().clear().commit();
    }
}
