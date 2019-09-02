package com.umeng.socialize.handler;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class WeixinPreferences {
    private static final String O000000o = "access_token";
    private static final String O00000Oo = "refresh_token";
    private static final String O00000o = "openid";
    private static final String O00000o0 = "rt_expires_in";
    private static final String O00000oO = "unionid";
    private static final String O00000oo = "expires_in";
    private SharedPreferences O0000O0o = null;
    private String O0000OOo;
    private String O0000Oo;
    private String O0000Oo0;
    private long O0000OoO;
    private String O0000Ooo;
    private long O0000o00;

    public WeixinPreferences(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("full");
        this.O0000O0o = context.getSharedPreferences(stringBuilder.toString(), 0);
        this.O0000OOo = this.O0000O0o.getString("unionid", null);
        this.O0000Oo0 = this.O0000O0o.getString("openid", null);
        this.O0000Oo = this.O0000O0o.getString("access_token", null);
        this.O0000OoO = this.O0000O0o.getLong("expires_in", 0);
        this.O0000Ooo = this.O0000O0o.getString("refresh_token", null);
        this.O0000o00 = this.O0000O0o.getLong(O00000o0, 0);
    }

    public WeixinPreferences O000000o(Bundle bundle) {
        if (TextUtils.isEmpty(bundle.getString("unionid"))) {
            this.O0000OOo = bundle.getString("unionid");
        }
        if (TextUtils.isEmpty(bundle.getString("openid"))) {
            this.O0000Oo0 = bundle.getString("openid");
        }
        this.O0000Oo = bundle.getString("access_token");
        this.O0000Ooo = bundle.getString("refresh_token");
        String string = bundle.getString("expires_in");
        if (!TextUtils.isEmpty(string)) {
            this.O0000OoO = (Long.valueOf(string).longValue() * 1000) + System.currentTimeMillis();
        }
        long j = bundle.getLong("refresh_token_expires");
        if (j != 0) {
            this.O0000o00 = (j * 1000) + System.currentTimeMillis();
        }
        O0000OoO();
        return this;
    }

    public String O000000o() {
        return this.O0000OOo;
    }

    public String O00000Oo() {
        return this.O0000Oo0;
    }

    public Map<String, String> O00000o() {
        HashMap hashMap = new HashMap();
        hashMap.put("access_token", this.O0000Oo);
        hashMap.put("unionid", this.O0000OOo);
        hashMap.put("openid", this.O0000Oo0);
        hashMap.put("refresh_token", this.O0000Ooo);
        hashMap.put("expires_in", String.valueOf(this.O0000OoO));
        return hashMap;
    }

    public String O00000o0() {
        return this.O0000Ooo;
    }

    public boolean O00000oO() {
        return (TextUtils.isEmpty(this.O0000Oo) || (this.O0000OoO - System.currentTimeMillis() <= 0)) ? false : true;
    }

    public String O00000oo() {
        return this.O0000Oo;
    }

    public long O0000O0o() {
        return this.O0000OoO;
    }

    public boolean O0000OOo() {
        return (TextUtils.isEmpty(this.O0000Ooo) || (this.O0000o00 - System.currentTimeMillis() <= 0)) ? false : true;
    }

    public void O0000Oo() {
        this.O0000O0o.edit().clear().commit();
        this.O0000Oo = "";
        this.O0000Ooo = "";
    }

    public boolean O0000Oo0() {
        return TextUtils.isEmpty(O00000oo()) ^ 1;
    }

    public void O0000OoO() {
        this.O0000O0o.edit().putString("unionid", this.O0000OOo).putString("openid", this.O0000Oo0).putString("access_token", this.O0000Oo).putString("refresh_token", this.O0000Ooo).putLong(O00000o0, this.O0000o00).putLong("expires_in", this.O0000OoO).commit();
    }
}
