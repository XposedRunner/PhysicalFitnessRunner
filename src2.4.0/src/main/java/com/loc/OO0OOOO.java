package com.loc;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: MD5 */
public final class OO0OOOO {
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005c A:{SYNTHETIC, Splitter:B:31:0x005c} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x006d A:{SYNTHETIC, Splitter:B:40:0x006d} */
    public static java.lang.String O000000o(java.lang.String r5) {
        /*
        r0 = 0;
        r1 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Throwable -> 0x0051, all -> 0x004f }
        if (r1 == 0) goto L_0x0008;
    L_0x0007:
        return r0;
    L_0x0008:
        r1 = new java.io.File;	 Catch:{ Throwable -> 0x0051, all -> 0x004f }
        r1.<init>(r5);	 Catch:{ Throwable -> 0x0051, all -> 0x004f }
        r5 = r1.isFile();	 Catch:{ Throwable -> 0x0051, all -> 0x004f }
        if (r5 == 0) goto L_0x004e;
    L_0x0013:
        r5 = r1.exists();	 Catch:{ Throwable -> 0x0051, all -> 0x004f }
        if (r5 != 0) goto L_0x001a;
    L_0x0019:
        return r0;
    L_0x001a:
        r5 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        r5 = new byte[r5];	 Catch:{ Throwable -> 0x0051, all -> 0x004f }
        r2 = "MD5";
        r2 = java.security.MessageDigest.getInstance(r2);	 Catch:{ Throwable -> 0x0051, all -> 0x004f }
        r3 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x0051, all -> 0x004f }
        r3.<init>(r1);	 Catch:{ Throwable -> 0x0051, all -> 0x004f }
    L_0x0029:
        r1 = r3.read(r5);	 Catch:{ Throwable -> 0x004c }
        r4 = -1;
        if (r1 == r4) goto L_0x0035;
    L_0x0030:
        r4 = 0;
        r2.update(r5, r4, r1);	 Catch:{ Throwable -> 0x004c }
        goto L_0x0029;
    L_0x0035:
        r5 = r2.digest();	 Catch:{ Throwable -> 0x004c }
        r5 = com.loc.OO0o000.O00000oO(r5);	 Catch:{ Throwable -> 0x004c }
        if (r3 == 0) goto L_0x004b;
    L_0x003f:
        r3.close();	 Catch:{ IOException -> 0x0043 }
        return r5;
    L_0x0043:
        r0 = move-exception;
        r1 = "MD5";
        r2 = "gfm";
        com.loc.O0000Oo.O000000o(r0, r1, r2);
    L_0x004b:
        return r5;
    L_0x004c:
        r5 = move-exception;
        goto L_0x0053;
    L_0x004e:
        return r0;
    L_0x004f:
        r5 = move-exception;
        goto L_0x006b;
    L_0x0051:
        r5 = move-exception;
        r3 = r0;
    L_0x0053:
        r1 = "MD5";
        r2 = "gfm";
        com.loc.O0000Oo.O000000o(r5, r1, r2);	 Catch:{ all -> 0x0069 }
        if (r3 == 0) goto L_0x0068;
    L_0x005c:
        r3.close();	 Catch:{ IOException -> 0x0060 }
        return r0;
    L_0x0060:
        r5 = move-exception;
        r1 = "MD5";
        r2 = "gfm";
        com.loc.O0000Oo.O000000o(r5, r1, r2);
    L_0x0068:
        return r0;
    L_0x0069:
        r5 = move-exception;
        r0 = r3;
    L_0x006b:
        if (r0 == 0) goto L_0x0079;
    L_0x006d:
        r0.close();	 Catch:{ IOException -> 0x0071 }
        goto L_0x0079;
    L_0x0071:
        r0 = move-exception;
        r1 = "MD5";
        r2 = "gfm";
        com.loc.O0000Oo.O000000o(r0, r1, r2);
    L_0x0079:
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.OO0OOOO.O000000o(java.lang.String):java.lang.String");
    }

    public static String O000000o(byte[] bArr) {
        return OO0o000.O00000oO(O000000o(bArr, "MD5"));
    }

    public static byte[] O000000o(byte[] bArr, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr);
            return instance.digest();
        } catch (Throwable th) {
            O0000Oo.O000000o(th, "MD5", "gmb");
            return null;
        }
    }

    public static String O00000Oo(String str) {
        return str == null ? null : OO0o000.O00000oO(O00000o(str));
    }

    private static byte[] O00000o(String str) {
        try {
            return O00000oo(str);
        } catch (Throwable th) {
            O0000Oo.O000000o(th, "MD5", "gmb");
            return new byte[0];
        }
    }

    public static String O00000o0(String str) {
        return OO0o000.O00000oo(O00000oO(str));
    }

    private static byte[] O00000oO(String str) {
        try {
            return O00000oo(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    private static byte[] O00000oo(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(OO0o000.O000000o(str));
        return instance.digest();
    }
}
