package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.alibaba.wireless.security.SecExceptionCode;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: ClientInfo */
public class o0O0OOOo {

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
    }

    public static String O000000o() {
        Throwable th;
        String valueOf;
        try {
            valueOf = String.valueOf(System.currentTimeMillis());
            try {
                String str = "1";
                if (!o0O0O0Oo.O000000o()) {
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
                oO0OoOO0.O000000o(th, "CI", "TS");
                return valueOf;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            valueOf = null;
            th = th4;
            oO0OoOO0.O000000o(th, "CI", "TS");
            return valueOf;
        }
    }

    public static String O000000o(Context context) {
        try {
            O000000o o000000o = new O000000o();
            o000000o.O00000o = o0O0O0Oo.O00000o0(context);
            o000000o.O0000Oo0 = o0O0O0Oo.O00000o(context);
            return O000000o(context, o000000o);
        } catch (Throwable th) {
            oO0OoOO0.O000000o(th, "CI", "IX");
            return null;
        }
    }

    private static String O000000o(Context context, O000000o o000000o) {
        return o0OO000o.O00000Oo(O00000Oo(context, o000000o));
    }

    public static String O000000o(Context context, String str, String str2) {
        try {
            String O00000oO = o0O0O0Oo.O00000oO(context);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(O00000oO);
            stringBuilder.append(":");
            stringBuilder.append(str.substring(0, str.length() - 3));
            stringBuilder.append(":");
            stringBuilder.append(str2);
            return o0OO00o0.O00000Oo(stringBuilder.toString());
        } catch (Throwable th) {
            oO0OoOO0.O000000o(th, "CI", "Sco");
            return null;
        }
    }

    public static void O000000o(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (TextUtils.isEmpty(str)) {
            o0OOOO00.O000000o(byteArrayOutputStream, (byte) 0, new byte[0]);
        } else {
            o0OOOO00.O000000o(byteArrayOutputStream, str.getBytes().length > 255 ? (byte) -1 : (byte) str.getBytes().length, o0OOOO00.O000000o(str));
        }
    }

    private static byte[] O000000o(Context context, ByteArrayOutputStream byteArrayOutputStream) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return O00000Oo(context, o0OOOO00.O00000Oo(byteArrayOutputStream.toByteArray()));
    }

    public static byte[] O000000o(Context context, boolean z) {
        try {
            return O00000Oo(context, O00000Oo(context, z));
        } catch (Throwable th) {
            oO0OoOO0.O000000o(th, "CI", "gz");
            return null;
        }
    }

    public static byte[] O000000o(Context context, byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        return o0OO000o.O000000o(bArr);
    }

    private static O000000o O00000Oo(Context context, boolean z) {
        O000000o o000000o = new O000000o();
        o000000o.O000000o = o0O0o000.O0000oo0(context);
        o000000o.O00000Oo = o0O0o000.O0000o00(context);
        String O0000OOo = o0O0o000.O0000OOo(context);
        if (O0000OOo == null) {
            O0000OOo = "";
        }
        o000000o.O00000o0 = O0000OOo;
        o000000o.O00000o = o0O0O0Oo.O00000o0(context);
        o000000o.O00000oO = Build.MODEL;
        o000000o.O00000oo = Build.MANUFACTURER;
        o000000o.O0000O0o = Build.DEVICE;
        o000000o.O0000OOo = o0O0O0Oo.O00000Oo(context);
        o000000o.O0000Oo0 = o0O0O0Oo.O00000o(context);
        o000000o.O0000Oo = String.valueOf(VERSION.SDK_INT);
        o000000o.O0000OoO = o0O0o000.O0000ooO(context);
        o000000o.O0000Ooo = o0O0o000.O0000oOo(context);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(o0O0o000.O0000oO0(context));
        stringBuilder.append("");
        o000000o.O0000o00 = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(o0O0o000.O0000o(context));
        stringBuilder.append("");
        o000000o.O0000o0 = stringBuilder.toString();
        o000000o.O0000o0O = o0O0o000.O00oOooO(context);
        o000000o.O0000o0o = o0O0o000.O0000o0o(context);
        if (z) {
            o000000o.O0000o = "";
        } else {
            o000000o.O0000o = o0O0o000.O0000Ooo(context);
        }
        if (z) {
            o000000o.O0000oO0 = "";
        } else {
            o000000o.O0000oO0 = o0O0o000.O0000OoO(context);
        }
        if (z) {
            o000000o.O0000oO = "";
            o000000o.O0000oOO = "";
        } else {
            String[] O0000o0 = o0O0o000.O0000o0(context);
            o000000o.O0000oO = O0000o0[0];
            o000000o.O0000oOO = O0000o0[1];
        }
        o000000o.O0000oo = o0O0o000.O000000o();
        String O00000Oo = o0O0o000.O00000Oo(context);
        if (TextUtils.isEmpty(O00000Oo)) {
            o000000o.O0000ooO = "";
        } else {
            o000000o.O0000ooO = O00000Oo;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("aid=");
        stringBuilder2.append(o0O0o000.O0000Oo(context));
        stringBuilder2.append("|serial=");
        stringBuilder2.append(o0O0o000.O0000Oo0(context));
        stringBuilder2.append("|storage=");
        stringBuilder2.append(o0O0o000.O00000o0());
        stringBuilder2.append("|ram=");
        stringBuilder2.append(o0O0o000.O0000ooo(context));
        stringBuilder2.append("|arch=");
        stringBuilder2.append(o0O0o000.O00000o());
        o000000o.O0000ooo = stringBuilder2.toString();
        O00000Oo = o0O0o000.O000000o(context);
        if (!TextUtils.isEmpty(O00000Oo)) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(o000000o.O0000ooo);
            stringBuilder3.append("|adiuExtras=");
            stringBuilder3.append(O00000Oo);
            o000000o.O0000ooo = stringBuilder3.toString();
        }
        O00000Oo = o0O0o000.O000000o(context, ",", true);
        if (!TextUtils.isEmpty(O00000Oo)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(o000000o.O0000ooo);
            stringBuilder.append("|multiImeis=");
            stringBuilder.append(O00000Oo);
            o000000o.O0000ooo = stringBuilder.toString();
        }
        String O0000oo = o0O0o000.O0000oo(context);
        if (!TextUtils.isEmpty(O0000oo)) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(o000000o.O0000ooo);
            stringBuilder2.append("|meid=");
            stringBuilder2.append(O0000oo);
            o000000o.O0000ooo = stringBuilder2.toString();
        }
        return o000000o;
    }

    public static String O00000Oo(Context context) {
        try {
            return O000000o(context, O00000Oo(context, false));
        } catch (Throwable th) {
            oO0OoOO0.O000000o(th, "CI", "gCX");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00a2 A:{SYNTHETIC, Splitter:B:19:0x00a2} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ae A:{SYNTHETIC, Splitter:B:26:0x00ae} */
    private static byte[] O00000Oo(android.content.Context r3, com.amap.api.mapcore.util.o0O0OOOo.O000000o r4) {
        /*
        r0 = 0;
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ Throwable -> 0x0097, all -> 0x0094 }
        r1.<init>();	 Catch:{ Throwable -> 0x0097, all -> 0x0094 }
        r2 = r4.O000000o;	 Catch:{ Throwable -> 0x0092 }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x0092 }
        r2 = r4.O00000Oo;	 Catch:{ Throwable -> 0x0092 }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x0092 }
        r2 = r4.O00000o0;	 Catch:{ Throwable -> 0x0092 }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x0092 }
        r2 = r4.O00000o;	 Catch:{ Throwable -> 0x0092 }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x0092 }
        r2 = r4.O00000oO;	 Catch:{ Throwable -> 0x0092 }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x0092 }
        r2 = r4.O00000oo;	 Catch:{ Throwable -> 0x0092 }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x0092 }
        r2 = r4.O0000O0o;	 Catch:{ Throwable -> 0x0092 }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x0092 }
        r2 = r4.O0000OOo;	 Catch:{ Throwable -> 0x0092 }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x0092 }
        r2 = r4.O0000Oo0;	 Catch:{ Throwable -> 0x0092 }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x0092 }
        r2 = r4.O0000Oo;	 Catch:{ Throwable -> 0x0092 }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x0092 }
        r2 = r4.O0000OoO;	 Catch:{ Throwable -> 0x0092 }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x0092 }
        r2 = r4.O0000Ooo;	 Catch:{ Throwable -> 0x0092 }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x0092 }
        r2 = r4.O0000o00;	 Catch:{ Throwable -> 0x0092 }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x0092 }
        r2 = r4.O0000o0;	 Catch:{ Throwable -> 0x0092 }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x0092 }
        r2 = r4.O0000o0O;	 Catch:{ Throwable -> 0x0092 }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x0092 }
        r2 = r4.O0000o0o;	 Catch:{ Throwable -> 0x0092 }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x0092 }
        r2 = r4.O0000o;	 Catch:{ Throwable -> 0x0092 }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x0092 }
        r2 = r4.O0000oO0;	 Catch:{ Throwable -> 0x0092 }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x0092 }
        r2 = r4.O0000oO;	 Catch:{ Throwable -> 0x0092 }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x0092 }
        r2 = r4.O0000oOO;	 Catch:{ Throwable -> 0x0092 }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x0092 }
        r2 = r4.O0000oOo;	 Catch:{ Throwable -> 0x0092 }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x0092 }
        r2 = r4.O0000oo0;	 Catch:{ Throwable -> 0x0092 }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x0092 }
        r2 = r4.O0000oo;	 Catch:{ Throwable -> 0x0092 }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x0092 }
        r2 = r4.O0000ooO;	 Catch:{ Throwable -> 0x0092 }
        O000000o(r1, r2);	 Catch:{ Throwable -> 0x0092 }
        r4 = r4.O0000ooo;	 Catch:{ Throwable -> 0x0092 }
        O000000o(r1, r4);	 Catch:{ Throwable -> 0x0092 }
        r3 = O000000o(r3, r1);	 Catch:{ Throwable -> 0x0092 }
        if (r1 == 0) goto L_0x0091;
    L_0x0089:
        r1.close();	 Catch:{ Throwable -> 0x008d }
        goto L_0x0091;
    L_0x008d:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x0091:
        return r3;
    L_0x0092:
        r3 = move-exception;
        goto L_0x0099;
    L_0x0094:
        r3 = move-exception;
        r1 = r0;
        goto L_0x00ac;
    L_0x0097:
        r3 = move-exception;
        r1 = r0;
    L_0x0099:
        r4 = "CI";
        r2 = "gzx";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r3, r4, r2);	 Catch:{ all -> 0x00ab }
        if (r1 == 0) goto L_0x00aa;
    L_0x00a2:
        r1.close();	 Catch:{ Throwable -> 0x00a6 }
        goto L_0x00aa;
    L_0x00a6:
        r3 = move-exception;
        r3.printStackTrace();
    L_0x00aa:
        return r0;
    L_0x00ab:
        r3 = move-exception;
    L_0x00ac:
        if (r1 == 0) goto L_0x00b6;
    L_0x00ae:
        r1.close();	 Catch:{ Throwable -> 0x00b2 }
        goto L_0x00b6;
    L_0x00b2:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x00b6:
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.o0O0OOOo.O00000Oo(android.content.Context, com.amap.api.mapcore.util.o0O0OOOo$O000000o):byte[]");
    }

    public static byte[] O00000Oo(Context context, byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        Key O00000o = o0OOOO00.O00000o();
        if (bArr.length <= SecExceptionCode.SEC_ERROR_INIT_RESERVE_DEPENDENCY_NOT_MEET) {
            return o0OO000o.O000000o(bArr, O00000o);
        }
        byte[] bArr2 = new byte[SecExceptionCode.SEC_ERROR_INIT_RESERVE_DEPENDENCY_NOT_MEET];
        System.arraycopy(bArr, 0, bArr2, 0, SecExceptionCode.SEC_ERROR_INIT_RESERVE_DEPENDENCY_NOT_MEET);
        byte[] bArr3 = new byte[((bArr.length + 128) - SecExceptionCode.SEC_ERROR_INIT_RESERVE_DEPENDENCY_NOT_MEET)];
        System.arraycopy(o0OO000o.O000000o(bArr2, O00000o), 0, bArr3, 0, 128);
        System.arraycopy(bArr, SecExceptionCode.SEC_ERROR_INIT_RESERVE_DEPENDENCY_NOT_MEET, bArr3, 128, bArr.length - SecExceptionCode.SEC_ERROR_INIT_RESERVE_DEPENDENCY_NOT_MEET);
        return bArr3;
    }
}
