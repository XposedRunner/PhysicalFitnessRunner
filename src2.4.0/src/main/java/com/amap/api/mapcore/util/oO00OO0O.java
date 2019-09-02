package com.amap.api.mapcore.util;

import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DexDownloadItem */
public class oO00OO0O {
    protected String O000000o;
    String O00000Oo;
    String O00000o;
    String O00000o0;
    String O00000oO;
    String O00000oo;
    int O0000O0o;
    int O0000OOo;
    private boolean O0000Oo;
    private String O0000Oo0;
    private boolean O0000OoO;

    public oO00OO0O(String str, String str2, String str3) {
        this(str, str2, str3, false);
    }

    public oO00OO0O(String str, String str2, String str3, boolean z) {
        this.O0000Oo = false;
        this.O0000OoO = false;
        this.O000000o = str;
        this.O0000Oo0 = str2;
        this.O0000Oo = z;
        try {
            String[] split = str.split(HttpUtils.PATHS_SEPARATOR);
            int length = split.length;
            if (length > 1) {
                this.O00000Oo = split[length - 1];
                split = this.O00000Oo.split("_");
                this.O00000o0 = split[0];
                this.O00000o = split[2];
                this.O00000oO = split[1];
                this.O0000O0o = Integer.parseInt(split[3]);
                this.O0000OOo = Integer.parseInt(split[4].split("\\.")[0]);
            }
        } catch (Throwable th) {
            oOo00ooO.O000000o(th, "DexDownloadItem", "DexDownloadItem");
        }
    }

    public static oO00OO0O O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return new oO00OO0O(null, null, null);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new oO00OO0O(jSONObject.optString("ak", ""), jSONObject.optString("bk", ""), "");
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("DexDownloadItem#fromJson json ex ");
            stringBuilder.append(th);
            oOo00o0o.O000000o(stringBuilder.toString());
            return new oO00OO0O(null, null, null);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public String O000000o() {
        return this.O000000o;
    }

    public void O000000o(boolean z) {
        this.O0000OoO = z;
    }

    public String O00000Oo() {
        return this.O0000Oo0;
    }

    public boolean O00000o() {
        return this.O0000Oo;
    }

    /* Access modifiers changed, original: 0000 */
    public String O00000o0() {
        return this.O00000o;
    }

    public boolean O00000oO() {
        return this.O0000OoO;
    }

    public String O00000oo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ak", this.O000000o);
            jSONObject.put("bk", this.O00000oo);
        } catch (JSONException e) {
            oOo00o0o.O000000o(e);
        }
        return jSONObject.toString();
    }

    public boolean O0000O0o() {
        return !TextUtils.isEmpty(this.O00000o0) && oO0OO00o.O000000o(this.O00000oO) && oO0OO00o.O000000o(this.O00000o) && this.O0000OOo > 0 && this.O0000OOo > 0;
    }

    public String O0000OOo() {
        return this.O00000o0;
    }

    public String O0000Oo() {
        return this.O00000oO;
    }

    public String O0000Oo0() {
        return this.O00000o;
    }
}
