package com.amap.api.mapcore.util;

import android.content.Context;
import java.lang.ref.WeakReference;

/* compiled from: Utils */
public class oOOo0000 {
    public static oOOO00Oo O000000o(WeakReference<oOOO00Oo> weakReference) {
        WeakReference weakReference2;
        if (weakReference2 == null || weakReference2.get() == null) {
            weakReference2 = new WeakReference(new oOOO00Oo());
        }
        return (oOOO00Oo) weakReference2.get();
    }

    public static String O000000o() {
        return o0OOOO00.O000000o(System.currentTimeMillis());
    }

    public static String O000000o(Context context, o0OO0o00 o0oo0o00) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String O0000O0o = o0O0o000.O0000O0o(context);
            stringBuilder.append("\"sim\":\"");
            stringBuilder.append(O0000O0o);
            stringBuilder.append("\",\"sdkversion\":\"");
            stringBuilder.append(o0oo0o00.O00000o0());
            stringBuilder.append("\",\"product\":\"");
            stringBuilder.append(o0oo0o00.O000000o());
            stringBuilder.append("\",\"ed\":\"");
            stringBuilder.append(o0oo0o00.O00000oO());
            stringBuilder.append("\",\"nt\":\"");
            stringBuilder.append(o0O0o000.O00000oO(context));
            stringBuilder.append("\",\"np\":\"");
            stringBuilder.append(o0O0o000.O00000o0(context));
            stringBuilder.append("\",\"mnc\":\"");
            stringBuilder.append(o0O0o000.O00000o(context));
            stringBuilder.append("\",\"ant\":\"");
            stringBuilder.append(o0O0o000.O00000oo(context));
            stringBuilder.append("\"");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static String O000000o(String str, String str2, String str3, int i, String str4, String str5) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str2);
        stringBuffer.append(",");
        stringBuffer.append("\"timestamp\":\"");
        stringBuffer.append(str3);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(i);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str4);
        stringBuffer.append("\",");
        stringBuffer.append("\"detail\":\"");
        stringBuffer.append(str5);
        stringBuffer.append("\"");
        return stringBuffer.toString();
    }

    public static void O000000o(Context context, oOOO00Oo oooo00oo, String str, int i, int i2, String str2) {
        oooo00oo.O000000o = oO0Oo0oo.O00000o0(context, str);
        oooo00oo.O00000o = i;
        oooo00oo.O00000Oo = (long) i2;
        oooo00oo.O00000o0 = str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x006c A:{SYNTHETIC, Splitter:B:55:0x006c} */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0076 A:{SYNTHETIC, Splitter:B:60:0x0076} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x006c A:{SYNTHETIC, Splitter:B:55:0x006c} */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0076 A:{SYNTHETIC, Splitter:B:60:0x0076} */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0082 A:{SYNTHETIC, Splitter:B:67:0x0082} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x008c A:{SYNTHETIC, Splitter:B:72:0x008c} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x006c A:{SYNTHETIC, Splitter:B:55:0x006c} */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0076 A:{SYNTHETIC, Splitter:B:60:0x0076} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0056 A:{Splitter:B:24:0x0030, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0082 A:{SYNTHETIC, Splitter:B:67:0x0082} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x008c A:{SYNTHETIC, Splitter:B:72:0x008c} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:41:0x0053, code skipped:
            r4 = th;
     */
    /* JADX WARNING: Missing block: B:42:0x0054, code skipped:
            r1 = r2;
     */
    /* JADX WARNING: Missing block: B:43:0x0056, code skipped:
            r4 = th;
     */
    /* JADX WARNING: Missing block: B:44:0x0057, code skipped:
            r2 = r0;
     */
    /* JADX WARNING: Missing block: B:68:?, code skipped:
            r2.close();
     */
    /* JADX WARNING: Missing block: B:69:0x0086, code skipped:
            r5 = move-exception;
     */
    /* JADX WARNING: Missing block: B:70:0x0087, code skipped:
            r5.printStackTrace();
     */
    /* JADX WARNING: Missing block: B:73:?, code skipped:
            r3.close();
     */
    /* JADX WARNING: Missing block: B:74:0x0090, code skipped:
            r5 = move-exception;
     */
    /* JADX WARNING: Missing block: B:75:0x0091, code skipped:
            r5.printStackTrace();
     */
    static byte[] O000000o(com.amap.api.mapcore.util.oOo0o0oO r4, java.lang.String r5, boolean r6) {
        /*
        r0 = 0;
        r1 = new byte[r0];
        r2 = 0;
        r3 = r4.O000000o(r5);	 Catch:{ Throwable -> 0x0061, all -> 0x005e }
        if (r3 != 0) goto L_0x0015;
    L_0x000a:
        if (r3 == 0) goto L_0x0014;
    L_0x000c:
        r3.close();	 Catch:{ Throwable -> 0x0010 }
        goto L_0x0014;
    L_0x0010:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x0014:
        return r1;
    L_0x0015:
        r0 = r3.O000000o(r0);	 Catch:{ Throwable -> 0x005c }
        if (r0 != 0) goto L_0x0030;
    L_0x001b:
        if (r0 == 0) goto L_0x0025;
    L_0x001d:
        r0.close();	 Catch:{ Throwable -> 0x0021 }
        goto L_0x0025;
    L_0x0021:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x0025:
        if (r3 == 0) goto L_0x002f;
    L_0x0027:
        r3.close();	 Catch:{ Throwable -> 0x002b }
        goto L_0x002f;
    L_0x002b:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x002f:
        return r1;
    L_0x0030:
        r2 = r0.available();	 Catch:{ Throwable -> 0x0059, all -> 0x0056 }
        r2 = new byte[r2];	 Catch:{ Throwable -> 0x0059, all -> 0x0056 }
        r0.read(r2);	 Catch:{ Throwable -> 0x0053, all -> 0x0056 }
        if (r6 == 0) goto L_0x003e;
    L_0x003b:
        r4.O00000o0(r5);	 Catch:{ Throwable -> 0x0053, all -> 0x0056 }
    L_0x003e:
        if (r0 == 0) goto L_0x0048;
    L_0x0040:
        r0.close();	 Catch:{ Throwable -> 0x0044 }
        goto L_0x0048;
    L_0x0044:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x0048:
        if (r3 == 0) goto L_0x0052;
    L_0x004a:
        r3.close();	 Catch:{ Throwable -> 0x004e }
        goto L_0x0052;
    L_0x004e:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x0052:
        return r2;
    L_0x0053:
        r4 = move-exception;
        r1 = r2;
        goto L_0x005a;
    L_0x0056:
        r4 = move-exception;
        r2 = r0;
        goto L_0x0080;
    L_0x0059:
        r4 = move-exception;
    L_0x005a:
        r2 = r0;
        goto L_0x0063;
    L_0x005c:
        r4 = move-exception;
        goto L_0x0063;
    L_0x005e:
        r4 = move-exception;
        r3 = r2;
        goto L_0x0080;
    L_0x0061:
        r4 = move-exception;
        r3 = r2;
    L_0x0063:
        r5 = "sui";
        r6 = "rdS";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r4, r5, r6);	 Catch:{ all -> 0x007f }
        if (r2 == 0) goto L_0x0074;
    L_0x006c:
        r2.close();	 Catch:{ Throwable -> 0x0070 }
        goto L_0x0074;
    L_0x0070:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x0074:
        if (r3 == 0) goto L_0x007e;
    L_0x0076:
        r3.close();	 Catch:{ Throwable -> 0x007a }
        goto L_0x007e;
    L_0x007a:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x007e:
        return r1;
    L_0x007f:
        r4 = move-exception;
    L_0x0080:
        if (r2 == 0) goto L_0x008a;
    L_0x0082:
        r2.close();	 Catch:{ Throwable -> 0x0086 }
        goto L_0x008a;
    L_0x0086:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x008a:
        if (r3 == 0) goto L_0x0094;
    L_0x008c:
        r3.close();	 Catch:{ Throwable -> 0x0090 }
        goto L_0x0094;
    L_0x0090:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x0094:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.oOOo0000.O000000o(com.amap.api.mapcore.util.oOo0o0oO, java.lang.String, boolean):byte[]");
    }
}
