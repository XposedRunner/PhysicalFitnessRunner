package com.qiyukf.basesdk.c.c;

import cn.jiguang.net.HttpUtils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

public final class c {
    public static String a(String str) {
        if (str == null || str.trim().length() <= 0) {
            return null;
        }
        try {
            return a(str.getBytes(HttpUtils.ENCODING_UTF_8));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private static String a(byte[] bArr) {
        try {
            return a.a(MessageDigest.getInstance("MD5").digest(bArr));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x004d A:{SYNTHETIC, Splitter:B:30:0x004d} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003f A:{SYNTHETIC, Splitter:B:21:0x003f} */
    public static java.lang.String b(java.lang.String r5) {
        /*
        r0 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r0 = new byte[r0];
        r1 = 0;
        r2 = "MD5";
        r2 = java.security.MessageDigest.getInstance(r2);	 Catch:{ Exception -> 0x0038, all -> 0x0036 }
        r3 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x0038, all -> 0x0036 }
        r4 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0038, all -> 0x0036 }
        r4.<init>(r5);	 Catch:{ Exception -> 0x0038, all -> 0x0036 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x0038, all -> 0x0036 }
    L_0x0015:
        r5 = r3.read(r0);	 Catch:{ Exception -> 0x0034 }
        if (r5 <= 0) goto L_0x0020;
    L_0x001b:
        r4 = 0;
        r2.update(r0, r4, r5);	 Catch:{ Exception -> 0x0034 }
        goto L_0x0015;
    L_0x0020:
        r3.close();	 Catch:{ Exception -> 0x0034 }
        r5 = r2.digest();	 Catch:{ Exception -> 0x0034 }
        r5 = com.qiyukf.basesdk.c.c.a.a(r5);	 Catch:{ Exception -> 0x0034 }
        r3.close();	 Catch:{ Exception -> 0x002f }
        return r5;
    L_0x002f:
        r0 = move-exception;
        r0.printStackTrace();
        return r5;
    L_0x0034:
        r5 = move-exception;
        goto L_0x003a;
    L_0x0036:
        r5 = move-exception;
        goto L_0x004b;
    L_0x0038:
        r5 = move-exception;
        r3 = r1;
    L_0x003a:
        r5.printStackTrace();	 Catch:{ all -> 0x0049 }
        if (r3 == 0) goto L_0x0047;
    L_0x003f:
        r3.close();	 Catch:{ Exception -> 0x0043 }
        goto L_0x0047;
    L_0x0043:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x0047:
        r5 = r1;
        return r5;
    L_0x0049:
        r5 = move-exception;
        r1 = r3;
    L_0x004b:
        if (r1 == 0) goto L_0x0055;
    L_0x004d:
        r1.close();	 Catch:{ Exception -> 0x0051 }
        goto L_0x0055;
    L_0x0051:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0055:
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.c.c.c.b(java.lang.String):java.lang.String");
    }
}
