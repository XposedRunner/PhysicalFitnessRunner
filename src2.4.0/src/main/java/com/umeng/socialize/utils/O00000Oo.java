package com.umeng.socialize.utils;

import android.content.Context;
import com.umeng.socialize.utils.O0000o00.O0000Oo0;
import defpackage.cx;
import java.io.File;

/* compiled from: ContextUtil */
public class O00000Oo {
    private static Context O000000o;

    public static Context O000000o() {
        if (O000000o == null) {
            O0000O0o.O000000o(O0000Oo0.O00000o0);
        }
        return O000000o;
    }

    public static File O000000o(String str) {
        return O000000o != null ? O000000o.getDatabasePath(cx.O00000o) : null;
    }

    public static void O000000o(Context context) {
        O000000o = context;
    }

    public static final String O00000Oo() {
        return O000000o == null ? "" : O000000o.getPackageName();
    }

    public static final int O00000o0() {
        return O000000o == null ? 0 : O000000o.getApplicationInfo().icon;
    }
}
