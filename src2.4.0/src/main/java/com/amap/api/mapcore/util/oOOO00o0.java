package com.amap.api.mapcore.util;

import java.io.File;
import java.util.List;

/* compiled from: LogEngine */
public class oOOO00o0 {
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a3 A:{SYNTHETIC, Splitter:B:48:0x00a3} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x009d A:{SYNTHETIC, Splitter:B:44:0x009d} */
    public static void O000000o(com.amap.api.mapcore.util.oOOO00Oo r8) {
        /*
        r0 = 0;
        r1 = r8.O00000oo;	 Catch:{ Throwable -> 0x0093 }
        r1 = r1.O00000o0();	 Catch:{ Throwable -> 0x0093 }
        if (r1 == 0) goto L_0x0085;
    L_0x0009:
        r1 = r8.O00000oo;	 Catch:{ Throwable -> 0x0093 }
        r2 = 1;
        r1.O000000o(r2);	 Catch:{ Throwable -> 0x0093 }
        r1 = new java.io.File;	 Catch:{ Throwable -> 0x0093 }
        r3 = r8.O000000o;	 Catch:{ Throwable -> 0x0093 }
        r1.<init>(r3);	 Catch:{ Throwable -> 0x0093 }
        r3 = r8.O00000Oo;	 Catch:{ Throwable -> 0x0093 }
        r1 = com.amap.api.mapcore.util.oOo0o0oO.O000000o(r1, r2, r2, r3);	 Catch:{ Throwable -> 0x0093 }
        r3 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x0082, all -> 0x0080 }
        r3.<init>();	 Catch:{ Throwable -> 0x0082, all -> 0x0080 }
        r4 = O000000o(r1, r8, r3);	 Catch:{ Throwable -> 0x0082, all -> 0x0080 }
        if (r4 == 0) goto L_0x0075;
    L_0x0027:
        r5 = r4.length;	 Catch:{ Throwable -> 0x0082, all -> 0x0080 }
        if (r5 != 0) goto L_0x002b;
    L_0x002a:
        goto L_0x0075;
    L_0x002b:
        r5 = new com.amap.api.mapcore.util.oO000OOO;	 Catch:{ Throwable -> 0x0082, all -> 0x0080 }
        r6 = r8.O00000o0;	 Catch:{ Throwable -> 0x0082, all -> 0x0080 }
        r5.<init>(r4, r6);	 Catch:{ Throwable -> 0x0082, all -> 0x0080 }
        r6 = com.amap.api.mapcore.util.ooooOO00.O000000o();	 Catch:{ Throwable -> 0x0082, all -> 0x0080 }
        r5 = r6.O00000Oo(r5);	 Catch:{ Throwable -> 0x0082, all -> 0x0080 }
        r6 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0082, all -> 0x0080 }
        r7 = new java.lang.String;	 Catch:{ Throwable -> 0x0082, all -> 0x0080 }
        r7.<init>(r5);	 Catch:{ Throwable -> 0x0082, all -> 0x0080 }
        r6.<init>(r7);	 Catch:{ Throwable -> 0x0082, all -> 0x0080 }
        r5 = "code";
        r5 = r6.has(r5);	 Catch:{ Throwable -> 0x0082, all -> 0x0080 }
        if (r5 == 0) goto L_0x0073;
    L_0x004c:
        r5 = "code";
        r5 = r6.getInt(r5);	 Catch:{ Throwable -> 0x0082, all -> 0x0080 }
        if (r5 != r2) goto L_0x0073;
    L_0x0054:
        r2 = r8.O00000oo;	 Catch:{ Throwable -> 0x0082, all -> 0x0080 }
        if (r2 == 0) goto L_0x0060;
    L_0x0058:
        if (r4 == 0) goto L_0x0060;
    L_0x005a:
        r2 = r8.O00000oo;	 Catch:{ Throwable -> 0x0082, all -> 0x0080 }
        r4 = r4.length;	 Catch:{ Throwable -> 0x0082, all -> 0x0080 }
        r2.O000000o(r4);	 Catch:{ Throwable -> 0x0082, all -> 0x0080 }
    L_0x0060:
        r8 = r8.O00000oo;	 Catch:{ Throwable -> 0x0082, all -> 0x0080 }
        r8 = r8.O00000Oo();	 Catch:{ Throwable -> 0x0082, all -> 0x0080 }
        r2 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        if (r8 >= r2) goto L_0x006f;
    L_0x006b:
        O000000o(r1, r3);	 Catch:{ Throwable -> 0x0082, all -> 0x0080 }
        goto L_0x0085;
    L_0x006f:
        O000000o(r1);	 Catch:{ Throwable -> 0x0082, all -> 0x0080 }
        goto L_0x0085;
    L_0x0073:
        r0 = r1;
        goto L_0x0085;
    L_0x0075:
        if (r1 == 0) goto L_0x007f;
    L_0x0077:
        r1.close();	 Catch:{ Throwable -> 0x007b }
        goto L_0x007f;
    L_0x007b:
        r8 = move-exception;
        r8.printStackTrace();
    L_0x007f:
        return;
    L_0x0080:
        r8 = move-exception;
        goto L_0x00a1;
    L_0x0082:
        r8 = move-exception;
        r0 = r1;
        goto L_0x0094;
    L_0x0085:
        if (r0 == 0) goto L_0x00a0;
    L_0x0087:
        r0.close();	 Catch:{ Throwable -> 0x008b }
        goto L_0x00a0;
    L_0x008b:
        r8 = move-exception;
        r8.printStackTrace();
        goto L_0x00a0;
    L_0x0090:
        r8 = move-exception;
        r1 = r0;
        goto L_0x00a1;
    L_0x0093:
        r8 = move-exception;
    L_0x0094:
        r1 = "leg";
        r2 = "uts";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r8, r1, r2);	 Catch:{ all -> 0x0090 }
        if (r0 == 0) goto L_0x00a0;
    L_0x009d:
        r0.close();	 Catch:{ Throwable -> 0x008b }
    L_0x00a0:
        return;
    L_0x00a1:
        if (r1 == 0) goto L_0x00ab;
    L_0x00a3:
        r1.close();	 Catch:{ Throwable -> 0x00a7 }
        goto L_0x00ab;
    L_0x00a7:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x00ab:
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.oOOO00o0.O000000o(com.amap.api.mapcore.util.oOOO00Oo):void");
    }

    private static void O000000o(oOo0o0oO ooo0o0oo) {
        if (ooo0o0oo != null) {
            try {
                ooo0o0oo.O00000oo();
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "ofm", "dlo");
            }
        }
    }

    private static void O000000o(oOo0o0oO ooo0o0oo, List<String> list) {
        if (ooo0o0oo != null) {
            try {
                for (String O00000o0 : list) {
                    ooo0o0oo.O00000o0(O00000o0);
                }
                ooo0o0oo.close();
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "ofm", "dlo");
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x005c A:{SYNTHETIC, Splitter:B:30:0x005c} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066 A:{SYNTHETIC, Splitter:B:35:0x0066} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005c A:{SYNTHETIC, Splitter:B:30:0x005c} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066 A:{SYNTHETIC, Splitter:B:35:0x0066} */
    public static void O000000o(java.lang.String r5, byte[] r6, com.amap.api.mapcore.util.oOOO00Oo r7) throws java.io.IOException, java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, javax.crypto.IllegalBlockSizeException, javax.crypto.BadPaddingException, javax.crypto.NoSuchPaddingException, java.security.InvalidKeyException, java.security.spec.InvalidKeySpecException {
        /*
        r0 = 0;
        r1 = r7.O000000o;	 Catch:{ all -> 0x0058 }
        r1 = O000000o(r1, r5);	 Catch:{ all -> 0x0058 }
        if (r1 == 0) goto L_0x000a;
    L_0x0009:
        return;
    L_0x000a:
        r1 = new java.io.File;	 Catch:{ all -> 0x0058 }
        r2 = r7.O000000o;	 Catch:{ all -> 0x0058 }
        r1.<init>(r2);	 Catch:{ all -> 0x0058 }
        r2 = r1.exists();	 Catch:{ all -> 0x0058 }
        if (r2 != 0) goto L_0x001a;
    L_0x0017:
        r1.mkdirs();	 Catch:{ all -> 0x0058 }
    L_0x001a:
        r2 = r7.O00000Oo;	 Catch:{ all -> 0x0058 }
        r4 = 1;
        r1 = com.amap.api.mapcore.util.oOo0o0oO.O000000o(r1, r4, r4, r2);	 Catch:{ all -> 0x0058 }
        r2 = r7.O00000o;	 Catch:{ all -> 0x0056 }
        r1.O000000o(r2);	 Catch:{ all -> 0x0056 }
        r7 = r7.O00000oO;	 Catch:{ all -> 0x0056 }
        r6 = r7.O00000Oo(r6);	 Catch:{ all -> 0x0056 }
        r5 = r1.O00000Oo(r5);	 Catch:{ all -> 0x0056 }
        r7 = 0;
        r7 = r5.O000000o(r7);	 Catch:{ all -> 0x0056 }
        r7.write(r6);	 Catch:{ all -> 0x0053 }
        r5.O000000o();	 Catch:{ all -> 0x0053 }
        r1.O00000oO();	 Catch:{ all -> 0x0053 }
        if (r7 == 0) goto L_0x0048;
    L_0x0040:
        r7.close();	 Catch:{ Throwable -> 0x0044 }
        goto L_0x0048;
    L_0x0044:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x0048:
        if (r1 == 0) goto L_0x0052;
    L_0x004a:
        r1.close();	 Catch:{ Throwable -> 0x004e }
        goto L_0x0052;
    L_0x004e:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x0052:
        return;
    L_0x0053:
        r5 = move-exception;
        r0 = r7;
        goto L_0x005a;
    L_0x0056:
        r5 = move-exception;
        goto L_0x005a;
    L_0x0058:
        r5 = move-exception;
        r1 = r0;
    L_0x005a:
        if (r0 == 0) goto L_0x0064;
    L_0x005c:
        r0.close();	 Catch:{ Throwable -> 0x0060 }
        goto L_0x0064;
    L_0x0060:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x0064:
        if (r1 == 0) goto L_0x006e;
    L_0x0066:
        r1.close();	 Catch:{ Throwable -> 0x006a }
        goto L_0x006e;
    L_0x006a:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x006e:
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.oOOO00o0.O000000o(java.lang.String, byte[], com.amap.api.mapcore.util.oOOO00Oo):void");
    }

    private static boolean O000000o(String str, String str2) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str2);
            stringBuilder.append(".0");
            return new File(str, stringBuilder.toString()).exists();
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "leg", "fet");
            return false;
        }
    }

    private static byte[] O000000o(oOo0o0oO ooo0o0oo, oOOO00Oo oooo00oo, List<String> list) {
        try {
            File O00000o0 = ooo0o0oo.O00000o0();
            if (O00000o0 != null && O00000o0.exists()) {
                String[] list2 = O00000o0.list();
                int length = list2.length;
                int i = 0;
                int i2 = i;
                while (i < length) {
                    String str = list2[i];
                    if (str.contains(".0")) {
                        str = str.split("\\.")[0];
                        byte[] O000000o = oOOo0000.O000000o(ooo0o0oo, str, false);
                        i2 += O000000o.length;
                        list.add(str);
                        if (i2 > oooo00oo.O00000oo.O00000Oo()) {
                            break;
                        }
                        oooo00oo.O0000O0o.O00000Oo(O000000o);
                    }
                    i++;
                }
                return oooo00oo.O0000O0o.O000000o();
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "leg", "gCo");
        }
        return new byte[0];
    }
}
