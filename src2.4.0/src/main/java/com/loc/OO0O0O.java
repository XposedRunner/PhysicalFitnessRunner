package com.loc;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;

/* compiled from: ClientInfo */
public final class OO0O0O {

    /* compiled from: ClientInfo */
    private static class O000000o {
        String O000000o;
        String O00000Oo;
        String O00000o;
        String O00000o0;
        String O00000oO;
        String O00000oo;
        String O0000O0o;
        String O0000OOo;
        String O0000Oo;
        String O0000Oo0;
        String O0000OoO;
        String O0000Ooo;
        String O0000o;
        String O0000o0;
        String O0000o00;
        String O0000o0O;
        String O0000o0o;
        String O0000oO;
        String O0000oO0;
        String O0000oOO;
        String O0000oOo;
        String O0000oo;
        String O0000oo0;
        String O0000ooO;
        String O0000ooo;

        private O000000o() {
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }
    }

    public static String O000000o() {
        Throwable th;
        String valueOf;
        try {
            valueOf = String.valueOf(System.currentTimeMillis());
            try {
                String str = "1";
                if (!OO00o00.O000000o()) {
                    str = "0";
                }
                int length = valueOf.length();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(valueOf.substring(0, length - 2));
                stringBuilder.append(str);
                stringBuilder.append(valueOf.substring(length - 1));
                return stringBuilder.toString();
            } catch (Throwable th2) {
                th = th2;
                O0000Oo.O000000o(th, "CI", "TS");
                return valueOf;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            valueOf = null;
            th = th4;
            O0000Oo.O000000o(th, "CI", "TS");
            return valueOf;
        }
    }

    public static String O000000o(Context context, String str, String str2) {
        try {
            String O00000oO = OO00o00.O00000oO(context);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(O00000oO);
            stringBuilder.append(":");
            stringBuilder.append(str.substring(0, str.length() - 3));
            stringBuilder.append(":");
            stringBuilder.append(str2);
            return OO0OOOO.O00000Oo(stringBuilder.toString());
        } catch (Throwable th) {
            O0000Oo.O000000o(th, "CI", "Sco");
            return null;
        }
    }

    private static void O000000o(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (TextUtils.isEmpty(str)) {
            OO0o000.O000000o(byteArrayOutputStream, (byte) 0, new byte[0]);
        } else {
            OO0o000.O000000o(byteArrayOutputStream, str.getBytes().length > 255 ? (byte) -1 : (byte) str.getBytes().length, OO0o000.O000000o(str));
        }
    }

    public static byte[] O000000o(Context context, boolean z) {
        try {
            String str;
            StringBuilder stringBuilder;
            O000000o o000000o = new O000000o();
            o000000o.O000000o = OO0O0o0.O0000oo0(context);
            o000000o.O00000Oo = OO0O0o0.O0000o00(context);
            String O0000OOo = OO0O0o0.O0000OOo(context);
            if (O0000OOo == null) {
                O0000OOo = "";
            }
            o000000o.O00000o0 = O0000OOo;
            o000000o.O00000o = OO00o00.O00000o0(context);
            o000000o.O00000oO = Build.MODEL;
            o000000o.O00000oo = Build.MANUFACTURER;
            o000000o.O0000O0o = Build.DEVICE;
            o000000o.O0000OOo = OO00o00.O00000Oo(context);
            o000000o.O0000Oo0 = OO00o00.O00000o(context);
            o000000o.O0000Oo = String.valueOf(VERSION.SDK_INT);
            o000000o.O0000OoO = OO0O0o0.O0000ooO(context);
            o000000o.O0000Ooo = OO0O0o0.O0000oOo(context);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(OO0O0o0.O0000oO0(context));
            o000000o.O0000o00 = stringBuilder2.toString();
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(OO0O0o0.O0000o(context));
            o000000o.O0000o0 = stringBuilder2.toString();
            o000000o.O0000o0O = OO0O0o0.O00oOooO(context);
            o000000o.O0000o0o = OO0O0o0.O0000o0o(context);
            o000000o.O0000o = z ? "" : OO0O0o0.O0000Ooo(context);
            o000000o.O0000oO0 = z ? "" : OO0O0o0.O0000OoO(context);
            if (z) {
                o000000o.O0000oO = "";
                str = "";
            } else {
                String[] O0000o0 = OO0O0o0.O0000o0(context);
                o000000o.O0000oO = O0000o0[0];
                str = O0000o0[1];
            }
            o000000o.O0000oOO = str;
            o000000o.O0000oo = OO0O0o0.O000000o();
            str = OO0O0o0.O00000Oo(context);
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            o000000o.O0000ooO = str;
            StringBuilder stringBuilder3 = new StringBuilder("aid=");
            stringBuilder3.append(OO0O0o0.O0000Oo(context));
            stringBuilder3.append("|serial=");
            stringBuilder3.append(OO0O0o0.O0000Oo0(context));
            stringBuilder3.append("|storage=");
            stringBuilder3.append(OO0O0o0.O00000o0());
            stringBuilder3.append("|ram=");
            stringBuilder3.append(OO0O0o0.O0000ooo(context));
            stringBuilder3.append("|arch=");
            stringBuilder3.append(OO0O0o0.O00000o());
            o000000o.O0000ooo = stringBuilder3.toString();
            str = OO0O0o0.O000000o(context);
            if (!TextUtils.isEmpty(str)) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(o000000o.O0000ooo);
                stringBuilder.append("|adiuExtras=");
                stringBuilder.append(str);
                o000000o.O0000ooo = stringBuilder.toString();
            }
            str = OO0O0o0.O000000o(context, ",");
            if (!TextUtils.isEmpty(str)) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(o000000o.O0000ooo);
                stringBuilder.append("|multiImeis=");
                stringBuilder.append(str);
                o000000o.O0000ooo = stringBuilder.toString();
            }
            String O0000oo = OO0O0o0.O0000oo(context);
            if (!TextUtils.isEmpty(O0000oo)) {
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(o000000o.O0000ooo);
                stringBuilder3.append("|meid=");
                stringBuilder3.append(O0000oo);
                o000000o.O0000ooo = stringBuilder3.toString();
            }
            return O000000o(o000000o);
        } catch (Throwable th) {
            O0000Oo.O000000o(th, "CI", "gz");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00d7 A:{SYNTHETIC, Splitter:B:30:0x00d7} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00cb A:{SYNTHETIC, Splitter:B:22:0x00cb} */
    private static byte[] O000000o(com.loc.OO0O0O.O000000o r7) {
        /*
        r0 = 0;
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ Throwable -> 0x00c0, all -> 0x00bd }
        r1.<init>();	 Catch:{ Throwable -> 0x00c0, all -> 0x00bd }
        r2 = r7.O000000o;	 Catch:{ Throwable -> 0x00bb }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x00bb }
        r2 = r7.O00000Oo;	 Catch:{ Throwable -> 0x00bb }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x00bb }
        r2 = r7.O00000o0;	 Catch:{ Throwable -> 0x00bb }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x00bb }
        r2 = r7.O00000o;	 Catch:{ Throwable -> 0x00bb }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x00bb }
        r2 = r7.O00000oO;	 Catch:{ Throwable -> 0x00bb }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x00bb }
        r2 = r7.O00000oo;	 Catch:{ Throwable -> 0x00bb }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x00bb }
        r2 = r7.O0000O0o;	 Catch:{ Throwable -> 0x00bb }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x00bb }
        r2 = r7.O0000OOo;	 Catch:{ Throwable -> 0x00bb }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x00bb }
        r2 = r7.O0000Oo0;	 Catch:{ Throwable -> 0x00bb }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x00bb }
        r2 = r7.O0000Oo;	 Catch:{ Throwable -> 0x00bb }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x00bb }
        r2 = r7.O0000OoO;	 Catch:{ Throwable -> 0x00bb }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x00bb }
        r2 = r7.O0000Ooo;	 Catch:{ Throwable -> 0x00bb }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x00bb }
        r2 = r7.O0000o00;	 Catch:{ Throwable -> 0x00bb }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x00bb }
        r2 = r7.O0000o0;	 Catch:{ Throwable -> 0x00bb }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x00bb }
        r2 = r7.O0000o0O;	 Catch:{ Throwable -> 0x00bb }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x00bb }
        r2 = r7.O0000o0o;	 Catch:{ Throwable -> 0x00bb }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x00bb }
        r2 = r7.O0000o;	 Catch:{ Throwable -> 0x00bb }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x00bb }
        r2 = r7.O0000oO0;	 Catch:{ Throwable -> 0x00bb }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x00bb }
        r2 = r7.O0000oO;	 Catch:{ Throwable -> 0x00bb }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x00bb }
        r2 = r7.O0000oOO;	 Catch:{ Throwable -> 0x00bb }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x00bb }
        r2 = r7.O0000oOo;	 Catch:{ Throwable -> 0x00bb }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x00bb }
        r2 = r7.O0000oo0;	 Catch:{ Throwable -> 0x00bb }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x00bb }
        r2 = r7.O0000oo;	 Catch:{ Throwable -> 0x00bb }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x00bb }
        r2 = r7.O0000ooO;	 Catch:{ Throwable -> 0x00bb }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x00bb }
        r7 = r7.O0000ooo;	 Catch:{ Throwable -> 0x00bb }
        O000000o(r1, r7);	 Catch:{ Throwable -> 0x00bb }
        r7 = r1.toByteArray();	 Catch:{ Throwable -> 0x00bb }
        r7 = com.loc.OO0o000.O00000Oo(r7);	 Catch:{ Throwable -> 0x00bb }
        r2 = com.loc.OO0o000.O00000o();	 Catch:{ Throwable -> 0x00bb }
        r3 = r7.length;	 Catch:{ Throwable -> 0x00bb }
        r4 = 117; // 0x75 float:1.64E-43 double:5.8E-322;
        if (r3 <= r4) goto L_0x00ae;
    L_0x0094:
        r3 = new byte[r4];	 Catch:{ Throwable -> 0x00bb }
        r5 = 0;
        java.lang.System.arraycopy(r7, r5, r3, r5, r4);	 Catch:{ Throwable -> 0x00bb }
        r2 = com.loc.oOo00.O000000o(r3, r2);	 Catch:{ Throwable -> 0x00bb }
        r3 = r7.length;	 Catch:{ Throwable -> 0x00bb }
        r6 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r3 = r3 + r6;
        r3 = r3 - r4;
        r3 = new byte[r3];	 Catch:{ Throwable -> 0x00bb }
        java.lang.System.arraycopy(r2, r5, r3, r5, r6);	 Catch:{ Throwable -> 0x00bb }
        r2 = r7.length;	 Catch:{ Throwable -> 0x00bb }
        r2 = r2 - r4;
        java.lang.System.arraycopy(r7, r4, r3, r6, r2);	 Catch:{ Throwable -> 0x00bb }
        goto L_0x00b2;
    L_0x00ae:
        r3 = com.loc.oOo00.O000000o(r7, r2);	 Catch:{ Throwable -> 0x00bb }
    L_0x00b2:
        r1.close();	 Catch:{ Throwable -> 0x00b6 }
        return r3;
    L_0x00b6:
        r7 = move-exception;
        r7.printStackTrace();
        return r3;
    L_0x00bb:
        r7 = move-exception;
        goto L_0x00c2;
    L_0x00bd:
        r7 = move-exception;
        r1 = r0;
        goto L_0x00d5;
    L_0x00c0:
        r7 = move-exception;
        r1 = r0;
    L_0x00c2:
        r2 = "CI";
        r3 = "gzx";
        com.loc.O0000Oo.O000000o(r7, r2, r3);	 Catch:{ all -> 0x00d4 }
        if (r1 == 0) goto L_0x00d3;
    L_0x00cb:
        r1.close();	 Catch:{ Throwable -> 0x00cf }
        return r0;
    L_0x00cf:
        r7 = move-exception;
        r7.printStackTrace();
    L_0x00d3:
        return r0;
    L_0x00d4:
        r7 = move-exception;
    L_0x00d5:
        if (r1 == 0) goto L_0x00df;
    L_0x00d7:
        r1.close();	 Catch:{ Throwable -> 0x00db }
        goto L_0x00df;
    L_0x00db:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x00df:
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.OO0O0O.O000000o(com.loc.OO0O0O$O000000o):byte[]");
    }
}
