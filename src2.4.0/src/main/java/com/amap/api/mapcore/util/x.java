package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: SoFileProvider */
public final class x extends u {
    private static x O00000o0;

    public x(Context context, o0OO0o00 o0oo0o00) {
        super(context, o0oo0o00);
    }

    public static x O000000o(Context context, o0OO0o00 o0oo0o00) {
        if (O00000o0 == null) {
            O00000o0 = new x(context, o0oo0o00);
        }
        return O00000o0;
    }

    private static String O000000o(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(o0O0o000.O0000oo0(context));
        return t.O000000o(context, stringBuilder.toString());
    }

    /* Access modifiers changed, original: protected|final */
    public final String O000000o() {
        return "j";
    }

    public final String O000000o(String str) throws an {
        str = O000000o(this.O000000o, str);
        if (!TextUtils.isEmpty(str)) {
            return this.O00000Oo.O000000o(O00000oo()).O00000Oo(str).O000000o();
        }
        throw new an("Wrong so file name");
    }

    public final String O00000Oo(String str) {
        return this.O00000Oo.O000000o(O0000O0o()).O00000Oo(O000000o(this.O000000o, str)).O000000o();
    }

    public final String O00000o0(String str) {
        return this.O00000Oo.O000000o(O00000oo()).O00000Oo(O000000o(this.O000000o, str)).O000000o();
    }
}
