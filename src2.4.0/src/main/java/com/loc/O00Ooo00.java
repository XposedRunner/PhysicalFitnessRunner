package com.loc;

import android.content.Context;
import java.lang.ref.WeakReference;

/* compiled from: Utils */
public final class O00Ooo00 {
    public static O00Oo00o O000000o(WeakReference<O00Oo00o> weakReference) {
        WeakReference weakReference2;
        if (weakReference2 == null || weakReference2.get() == null) {
            weakReference2 = new WeakReference(new O00Oo00o());
        }
        return (O00Oo00o) weakReference2.get();
    }

    public static String O000000o(Context context, OO0Oo0 oO0Oo0) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String O0000O0o = OO0O0o0.O0000O0o(context);
            stringBuilder.append("\"sim\":\"");
            stringBuilder.append(O0000O0o);
            stringBuilder.append("\",\"sdkversion\":\"");
            stringBuilder.append(oO0Oo0.O00000o0());
            stringBuilder.append("\",\"product\":\"");
            stringBuilder.append(oO0Oo0.O000000o());
            stringBuilder.append("\",\"ed\":\"");
            stringBuilder.append(oO0Oo0.O00000o());
            stringBuilder.append("\",\"nt\":\"");
            stringBuilder.append(OO0O0o0.O00000oO(context));
            stringBuilder.append("\",\"np\":\"");
            stringBuilder.append(OO0O0o0.O00000o0(context));
            stringBuilder.append("\",\"mnc\":\"");
            stringBuilder.append(OO0O0o0.O00000o(context));
            stringBuilder.append("\",\"ant\":\"");
            stringBuilder.append(OO0O0o0.O00000oo(context));
            stringBuilder.append("\"");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static void O000000o(Context context, O00Oo00o o00Oo00o, String str, int i, int i2, String str2) {
        o00Oo00o.O000000o = O0000o00.O00000o0(context, str);
        o00Oo00o.O00000o = i;
        o00Oo00o.O00000Oo = (long) i2;
        o00Oo00o.O00000o0 = str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x0084 A:{SYNTHETIC, Splitter:B:69:0x0084} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x008e A:{SYNTHETIC, Splitter:B:74:0x008e} */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x006e A:{SYNTHETIC, Splitter:B:56:0x006e} */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0078 A:{SYNTHETIC, Splitter:B:61:0x0078} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0084 A:{SYNTHETIC, Splitter:B:69:0x0084} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x008e A:{SYNTHETIC, Splitter:B:74:0x008e} */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x006e A:{SYNTHETIC, Splitter:B:56:0x006e} */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0078 A:{SYNTHETIC, Splitter:B:61:0x0078} */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x006e A:{SYNTHETIC, Splitter:B:56:0x006e} */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0078 A:{SYNTHETIC, Splitter:B:61:0x0078} */
    static byte[] O000000o(com.loc.O00O0O0o r5, java.lang.String r6) {
        /*
        r0 = 0;
        r0 = new byte[r0];
        r1 = 0;
        r5 = r5.O000000o(r6);	 Catch:{ Throwable -> 0x0061, all -> 0x005d }
        if (r5 != 0) goto L_0x0015;
    L_0x000a:
        if (r5 == 0) goto L_0x0014;
    L_0x000c:
        r5.close();	 Catch:{ Throwable -> 0x0010 }
        return r0;
    L_0x0010:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x0014:
        return r0;
    L_0x0015:
        r6 = r5.O000000o();	 Catch:{ Throwable -> 0x0058, all -> 0x0055 }
        if (r6 != 0) goto L_0x0030;
    L_0x001b:
        if (r6 == 0) goto L_0x0025;
    L_0x001d:
        r6.close();	 Catch:{ Throwable -> 0x0021 }
        goto L_0x0025;
    L_0x0021:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x0025:
        if (r5 == 0) goto L_0x002f;
    L_0x0027:
        r5.close();	 Catch:{ Throwable -> 0x002b }
        return r0;
    L_0x002b:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x002f:
        return r0;
    L_0x0030:
        r1 = r6.available();	 Catch:{ Throwable -> 0x0053 }
        r1 = new byte[r1];	 Catch:{ Throwable -> 0x0053 }
        r6.read(r1);	 Catch:{ Throwable -> 0x004e }
        if (r6 == 0) goto L_0x0043;
    L_0x003b:
        r6.close();	 Catch:{ Throwable -> 0x003f }
        goto L_0x0043;
    L_0x003f:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x0043:
        if (r5 == 0) goto L_0x004d;
    L_0x0045:
        r5.close();	 Catch:{ Throwable -> 0x0049 }
        return r1;
    L_0x0049:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x004d:
        return r1;
    L_0x004e:
        r0 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x0065;
    L_0x0053:
        r1 = move-exception;
        goto L_0x0065;
    L_0x0055:
        r0 = move-exception;
        r6 = r1;
        goto L_0x0082;
    L_0x0058:
        r6 = move-exception;
        r4 = r1;
        r1 = r6;
        r6 = r4;
        goto L_0x0065;
    L_0x005d:
        r0 = move-exception;
        r5 = r1;
        r6 = r5;
        goto L_0x0082;
    L_0x0061:
        r5 = move-exception;
        r6 = r1;
        r1 = r5;
        r5 = r6;
    L_0x0065:
        r2 = "sui";
        r3 = "rdS";
        com.loc.O0000o.O00000Oo(r1, r2, r3);	 Catch:{ all -> 0x0081 }
        if (r6 == 0) goto L_0x0076;
    L_0x006e:
        r6.close();	 Catch:{ Throwable -> 0x0072 }
        goto L_0x0076;
    L_0x0072:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x0076:
        if (r5 == 0) goto L_0x0080;
    L_0x0078:
        r5.close();	 Catch:{ Throwable -> 0x007c }
        return r0;
    L_0x007c:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x0080:
        return r0;
    L_0x0081:
        r0 = move-exception;
    L_0x0082:
        if (r6 == 0) goto L_0x008c;
    L_0x0084:
        r6.close();	 Catch:{ Throwable -> 0x0088 }
        goto L_0x008c;
    L_0x0088:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x008c:
        if (r5 == 0) goto L_0x0096;
    L_0x008e:
        r5.close();	 Catch:{ Throwable -> 0x0092 }
        goto L_0x0096;
    L_0x0092:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x0096:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O00Ooo00.O000000o(com.loc.O00O0O0o, java.lang.String):byte[]");
    }
}
