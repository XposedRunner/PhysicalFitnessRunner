package com.amap.api.mapcore.util;

import android.content.Context;
import org.json.JSONObject;

/* compiled from: DexSoModel */
public class oO0O00Oo {
    private o0OO0o00 O000000o;
    private String O00000Oo;
    private String O00000o;
    private String O00000o0;
    private boolean O00000oO;
    private boolean O00000oo;
    private boolean O0000O0o;

    private oO0O00Oo(o0OO0o00 o0oo0o00, String str, String str2, boolean z, boolean z2, boolean z3, String str3) {
        this.O000000o = o0oo0o00;
        this.O00000Oo = str;
        this.O00000o0 = str2;
        this.O00000o = str3;
        this.O00000oO = z;
        this.O00000oo = z2;
        this.O0000O0o = z3;
    }

    public static oO0O00Oo O000000o(o0OO0o00 o0oo0o00, String str, String str2, boolean z, boolean z2, boolean z3, String str3) {
        return new oO0O00Oo(o0oo0o00, str, str2, z, z2, z3, str3);
    }

    public o0OO0o00 O000000o() {
        return this.O000000o;
    }

    public String O000000o(Context context) {
        try {
            return new JSONObject(this.O00000o).optJSONObject(o0OOOO00.O000000o(context)).optString("dexmd5", "");
        } catch (Throwable unused) {
            return "";
        }
    }

    public String O00000Oo() {
        return this.O00000Oo;
    }

    public String O00000Oo(Context context) {
        try {
            return new JSONObject(this.O00000o).optJSONObject(o0OOOO00.O000000o(context)).optString("so_md5_vals", "");
        } catch (Throwable unused) {
            return "";
        }
    }

    public String O00000o() {
        return this.O00000o;
    }

    public String O00000o0() {
        return this.O00000o0;
    }

    public boolean O00000oO() {
        return this.O00000oO;
    }

    public boolean O00000oo() {
        return this.O00000oo;
    }

    public boolean O0000O0o() {
        return this.O0000O0o;
    }
}
