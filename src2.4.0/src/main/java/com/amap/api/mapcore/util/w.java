package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: DexSoFileProvider */
public final class w extends u {
    private String O00000o = "";
    private String O00000o0 = "";
    private String O00000oO = null;

    public w(Context context, o0OO0o00 o0oo0o00) {
        super(context, o0oo0o00);
    }

    public static boolean O000000o(String str) {
        return str != null && str.equalsIgnoreCase("dex.png");
    }

    /* Access modifiers changed, original: protected|final */
    public final String O000000o() {
        return "s";
    }

    public final String O0000Oo() {
        String str;
        ap O000000o = this.O00000Oo.O000000o(O00000o0());
        if (TextUtils.isEmpty(this.O00000o0)) {
            this.O00000o0 = t.O000000o(this.O000000o, "SoPng");
            str = this.O00000o0;
        } else {
            str = this.O00000o0;
        }
        return O000000o.O00000Oo(str).O000000o();
    }

    public final String O0000OoO() {
        String str;
        ap O000000o = this.O00000Oo.O000000o(O00000o0());
        if (TextUtils.isEmpty(this.O00000o)) {
            this.O00000o = t.O000000o(this.O000000o, "DexPng");
            str = this.O00000o;
        } else {
            str = this.O00000o;
        }
        return O000000o.O00000Oo(str).O000000o();
    }

    public final String O0000Ooo() {
        if (!TextUtils.isEmpty(this.O00000oO)) {
            return this.O00000oO;
        }
        if (this.O000000o == null) {
            return "";
        }
        this.O00000oO = this.O00000Oo.O000000o(O0000O0o()).O00000Oo(O00000oO()).O000000o();
        return this.O00000oO;
    }
}
