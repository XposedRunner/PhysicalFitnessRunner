package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;

/* compiled from: LocationRequest */
public final class O0Oo0 extends O00OO0O {
    Map<String, String> O00000oo = null;
    String O0000O0o = "";
    byte[] O0000OOo = null;
    boolean O0000Oo = false;
    byte[] O0000Oo0 = null;
    String O0000OoO = null;
    Map<String, String> O0000Ooo = null;
    private String O0000o0 = "";
    boolean O0000o00 = false;

    public O0Oo0(Context context, OO0Oo0 oO0Oo0) {
        super(context, oO0Oo0);
    }

    public final Map<String, String> O000000o() {
        return this.O00000oo;
    }

    public final void O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            this.O0000o0 = "";
        } else {
            this.O0000o0 = str;
        }
    }

    public final Map<String, String> O00000Oo() {
        return this.O0000Ooo;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x003b A:{SYNTHETIC, Splitter:B:30:0x003b} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0030 A:{SYNTHETIC, Splitter:B:23:0x0030} */
    public final void O00000Oo(byte[] r3) {
        /*
        r2 = this;
        r0 = 0;
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ Throwable -> 0x002a }
        r1.<init>();	 Catch:{ Throwable -> 0x002a }
        if (r3 == 0) goto L_0x0018;
    L_0x0008:
        r0 = com.loc.O00OO0O.O000000o(r3);	 Catch:{ Throwable -> 0x0015, all -> 0x0013 }
        r1.write(r0);	 Catch:{ Throwable -> 0x0015, all -> 0x0013 }
        r1.write(r3);	 Catch:{ Throwable -> 0x0015, all -> 0x0013 }
        goto L_0x0018;
    L_0x0013:
        r3 = move-exception;
        goto L_0x0039;
    L_0x0015:
        r3 = move-exception;
        r0 = r1;
        goto L_0x002b;
    L_0x0018:
        r3 = r1.toByteArray();	 Catch:{ Throwable -> 0x0015, all -> 0x0013 }
        r2.O0000Oo0 = r3;	 Catch:{ Throwable -> 0x0015, all -> 0x0013 }
        r1.close();	 Catch:{ IOException -> 0x0022 }
        return;
    L_0x0022:
        r3 = move-exception;
        r3.printStackTrace();
        return;
    L_0x0027:
        r3 = move-exception;
        r1 = r0;
        goto L_0x0039;
    L_0x002a:
        r3 = move-exception;
    L_0x002b:
        r3.printStackTrace();	 Catch:{ all -> 0x0027 }
        if (r0 == 0) goto L_0x0038;
    L_0x0030:
        r0.close();	 Catch:{ IOException -> 0x0034 }
        return;
    L_0x0034:
        r3 = move-exception;
        r3.printStackTrace();
    L_0x0038:
        return;
    L_0x0039:
        if (r1 == 0) goto L_0x0043;
    L_0x003b:
        r1.close();	 Catch:{ IOException -> 0x003f }
        goto L_0x0043;
    L_0x003f:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0043:
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0Oo0.O00000Oo(byte[]):void");
    }

    public final String O00000o0() {
        return this.O0000O0o;
    }

    public final boolean O00000oO() {
        return this.O0000Oo;
    }

    public final String O00000oo() {
        return this.O0000OoO;
    }

    public final byte[] O0000OOo() {
        return this.O0000OOo;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean O0000Oo() {
        return this.O0000o00;
    }

    public final byte[] O0000Oo0() {
        return this.O0000Oo0;
    }

    /* Access modifiers changed, original: protected|final */
    public final String O0000OoO() {
        return this.O0000o0;
    }
}
