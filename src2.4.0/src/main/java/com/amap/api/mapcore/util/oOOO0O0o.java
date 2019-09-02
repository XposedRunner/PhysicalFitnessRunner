package com.amap.api.mapcore.util;

import android.content.Context;

/* compiled from: OfflineLocEntity */
public class oOOO0O0o {
    private Context O000000o;
    private o0OO0o00 O00000Oo;
    private String O00000o0;

    public oOOO0O0o(Context context, o0OO0o00 o0oo0o00, String str) {
        this.O000000o = context.getApplicationContext();
        this.O00000Oo = o0oo0o00;
        this.O00000o0 = str;
    }

    private static String O000000o(Context context, o0OO0o00 o0oo0o00, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("\"sdkversion\":\"");
            stringBuilder.append(o0oo0o00.O00000o0());
            stringBuilder.append("\",\"product\":\"");
            stringBuilder.append(o0oo0o00.O000000o());
            stringBuilder.append("\",\"nt\":\"");
            stringBuilder.append(o0O0o000.O00000oO(context));
            stringBuilder.append("\",\"details\":");
            stringBuilder.append(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return stringBuilder.toString();
    }

    /* Access modifiers changed, original: 0000 */
    public byte[] O000000o() {
        return o0OOOO00.O000000o(O000000o(this.O000000o, this.O00000Oo, this.O00000o0));
    }
}
