package com.amap.api.mapcore.util;

import android.content.Context;

/* compiled from: SoManager */
public final class z {
    public static volatile boolean O000000o;
    public static volatile o0OO0o00 O00000Oo;
    private t O00000o0;

    private t O000000o(Context context, o0OO0o00 o0oo0o00, kr krVar) {
        if (this.O00000o0 == null) {
            this.O00000o0 = new t(context, o0oo0o00, krVar);
        }
        return this.O00000o0;
    }

    private boolean O00000Oo(Context context, o0OO0o00 o0oo0o00, kr krVar, String str) {
        if (o0oo0o00 == null) {
            return false;
        }
        try {
            t O000000o = O000000o(context, o0oo0o00, krVar);
            return O000000o == null ? false : O000000o.O00000Oo(str);
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("SoManagerCore ex ");
            stringBuilder.append(th);
            t.O000000o(stringBuilder.toString());
            return false;
        }
    }

    public final boolean O000000o(Context context, o0OO0o00 o0oo0o00, kr krVar, String str) {
        return O00000Oo(context, o0oo0o00, krVar, str);
    }
}
