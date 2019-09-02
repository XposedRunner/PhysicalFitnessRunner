package com.loc;

import android.content.Context;

/* compiled from: OfflineLocEntity */
public final class O00Oo0o0 {
    private Context O000000o;
    private OO0Oo0 O00000Oo;
    private String O00000o0;

    public O00Oo0o0(Context context, OO0Oo0 oO0Oo0, String str) {
        this.O000000o = context.getApplicationContext();
        this.O00000Oo = oO0Oo0;
        this.O00000o0 = str;
    }

    private static String O000000o(Context context, OO0Oo0 oO0Oo0, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("\"sdkversion\":\"");
            stringBuilder.append(oO0Oo0.O00000o0());
            stringBuilder.append("\",\"product\":\"");
            stringBuilder.append(oO0Oo0.O000000o());
            stringBuilder.append("\",\"nt\":\"");
            stringBuilder.append(OO0O0o0.O00000oO(context));
            stringBuilder.append("\",\"details\":");
            stringBuilder.append(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return stringBuilder.toString();
    }

    /* Access modifiers changed, original: final */
    public final byte[] O000000o() {
        return OO0o000.O000000o(O000000o(this.O000000o, this.O00000Oo, this.O00000o0));
    }
}
