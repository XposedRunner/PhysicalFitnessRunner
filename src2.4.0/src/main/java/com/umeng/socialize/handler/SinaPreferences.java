package com.umeng.socialize.handler;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class SinaPreferences {
    private static final String O000000o = "access_key";
    private static final String O00000Oo = "access_secret";
    private static final String O00000o = "expires_in";
    private static final String O00000o0 = "uid";
    private static final String O00000oO = "access_token";
    private static final String O00000oo = "refresh_token";
    private static final String O0000O0o = "expires_in";
    private static final String O0000OOo = "userName";
    private static final String O0000Oo = "isfollow";
    private static final String O0000Oo0 = "uid";
    private String O0000OoO = null;
    private String O0000Ooo = null;
    private String O0000o = null;
    private long O0000o0 = 0;
    private String O0000o00 = null;
    private String O0000o0O = null;
    private String O0000o0o = null;
    private SharedPreferences O0000oO = null;
    private boolean O0000oO0 = false;

    public SinaPreferences(Context context, String str) {
        this.O0000oO = context.getSharedPreferences(str, 0);
        this.O0000OoO = this.O0000oO.getString(O000000o, null);
        this.O0000o0o = this.O0000oO.getString("refresh_token", null);
        this.O0000Ooo = this.O0000oO.getString(O00000Oo, null);
        this.O0000o0O = this.O0000oO.getString("access_token", null);
        this.O0000o00 = this.O0000oO.getString("uid", null);
        this.O0000o0 = this.O0000oO.getLong("expires_in", 0);
        this.O0000oO0 = this.O0000oO.getBoolean(O0000Oo, false);
    }

    public SinaPreferences O000000o(Bundle bundle) {
        this.O0000o0O = bundle.getString("access_token");
        this.O0000o0o = bundle.getString("refresh_token");
        this.O0000o00 = bundle.getString("uid");
        if (!TextUtils.isEmpty(bundle.getString("expires_in"))) {
            this.O0000o0 = (Long.valueOf(bundle.getString("expires_in")).longValue() * 1000) + System.currentTimeMillis();
        }
        return this;
    }

    public SinaPreferences O000000o(Map<String, String> map) {
        this.O0000OoO = (String) map.get(O000000o);
        this.O0000Ooo = (String) map.get(O00000Oo);
        this.O0000o0O = (String) map.get("access_token");
        this.O0000o0o = (String) map.get("refresh_token");
        this.O0000o00 = (String) map.get("uid");
        if (!TextUtils.isEmpty((CharSequence) map.get("expires_in"))) {
            this.O0000o0 = (Long.valueOf((String) map.get("expires_in")).longValue() * 1000) + System.currentTimeMillis();
        }
        return this;
    }

    public String O000000o() {
        return this.O0000o0O;
    }

    public long O00000Oo() {
        return this.O0000o0;
    }

    public Map<String, String> O00000o() {
        HashMap hashMap = new HashMap();
        hashMap.put(O000000o, this.O0000OoO);
        hashMap.put(O00000Oo, this.O0000Ooo);
        hashMap.put("uid", this.O0000o00);
        hashMap.put("expires_in", String.valueOf(this.O0000o0));
        return hashMap;
    }

    public String O00000o0() {
        return this.O0000o0o;
    }

    public String O00000oO() {
        return this.O0000o00;
    }

    public boolean O00000oo() {
        return TextUtils.isEmpty(this.O0000o0O) ^ 1;
    }

    public boolean O0000O0o() {
        return O00000oo() && !(this.O0000o0 - System.currentTimeMillis() <= 0);
    }

    public void O0000OOo() {
        this.O0000oO.edit().putString(O000000o, this.O0000OoO).putString(O00000Oo, this.O0000Ooo).putString("access_token", this.O0000o0O).putString("refresh_token", this.O0000o0o).putString("uid", this.O0000o00).putLong("expires_in", this.O0000o0).commit();
    }

    public void O0000Oo0() {
        this.O0000OoO = null;
        this.O0000Ooo = null;
        this.O0000o0O = null;
        this.O0000o00 = null;
        this.O0000o0 = 0;
        this.O0000oO.edit().clear().commit();
    }
}
