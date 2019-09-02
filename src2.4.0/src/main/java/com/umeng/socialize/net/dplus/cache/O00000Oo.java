package com.umeng.socialize.net.dplus.cache;

import android.content.Context;
import android.os.Handler;

/* compiled from: CacheApi */
public class O00000Oo {
    private static String O000000o = "O00000Oo";
    private static O00000Oo O00000oO;
    private Handler O00000Oo;
    private Context O00000o;
    private O00000o0 O00000o0 = new O00000o0(O000000o());

    private O00000Oo(Context context) {
        this.O00000o = context;
    }

    public static O00000Oo O000000o(Context context) {
        if (O00000oO == null) {
            O00000oO = new O00000Oo(context);
        }
        return O00000oO;
    }

    private String O000000o() {
        return this.O00000o == null ? null : this.O00000o.getFilesDir().getPath();
    }

    public double O000000o(String str) {
        return this.O00000o0 == null ? 0.0d : this.O00000o0.O000000o(str);
    }

    public O0000OOo O000000o(String str, Class cls) {
        return this.O00000o0 == null ? null : this.O00000o0.O000000o(str, cls);
    }

    public boolean O000000o(String str, String str2) {
        return this.O00000o0 == null ? false : this.O00000o0.O000000o(str, str2);
    }

    public boolean O00000Oo(String str) {
        return this.O00000o0 == null ? false : this.O00000o0.O00000Oo(str);
    }
}
