package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

/* compiled from: SoLoader */
public class oOo0oooO {
    private WeakReference<Context> O000000o;
    private z O00000Oo;

    /* compiled from: SoLoader */
    static class O000000o {
        public static oOo0oooO O000000o = new oOo0oooO();
    }

    private oOo0oooO() {
        this.O00000Oo = new z();
    }

    /* synthetic */ oOo0oooO(byte b) {
        this();
    }

    public static oOo0oooO O000000o() {
        return O000000o.O000000o;
    }

    private void O000000o(Context context) {
        if (context != null && context.getApplicationContext() != null) {
            this.O000000o = null;
            this.O000000o = new WeakReference(context.getApplicationContext());
        }
    }

    private static boolean O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            System.loadLibrary(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean O000000o(Context context, o0OO0o00 o0oo0o00, kr krVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (o0oo0o00 == null || krVar == null || context == null) {
            O000000o(str);
            return false;
        } else if (TextUtils.isEmpty(o0oo0o00.O00000o0()) || TextUtils.isEmpty(o0oo0o00.O00000Oo()) || o0oo0o00.O00000Oo().equals(o0oo0o00.O00000o0())) {
            O000000o(str);
            return false;
        } else if (!oO0O000o.O000000o(o0oo0o00)) {
            O000000o(str);
            return false;
        } else if (ar.O00000Oo(o0oo0o00.O00000Oo(), krVar.O000000o())) {
            O000000o(context);
            return this.O00000Oo.O000000o(this.O000000o == null ? null : (Context) this.O000000o.get(), o0oo0o00, krVar, str);
        } else {
            O000000o(str);
            return false;
        }
    }
}
