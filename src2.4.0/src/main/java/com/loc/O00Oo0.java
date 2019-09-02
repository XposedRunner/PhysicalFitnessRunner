package com.loc;

import java.io.File;
import java.util.List;

/* compiled from: LogEngine */
public final class O00Oo0 {
    private static void O000000o(O00O0O0o o00O0O0o, List<String> list) {
        if (o00O0O0o != null) {
            try {
                for (String O00000o0 : list) {
                    o00O0O0o.O00000o0(O00000o0);
                }
                o00O0O0o.close();
            } catch (Throwable th) {
                O0000o.O00000Oo(th, "ofm", "dlo");
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x008a A:{Splitter:B:5:0x001c, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b2 A:{SYNTHETIC, Splitter:B:59:0x00b2} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008a A:{Splitter:B:5:0x001c, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:36:0x008a, code skipped:
            r8 = th;
     */
    /* JADX WARNING: Missing block: B:37:0x008c, code skipped:
            r8 = th;
     */
    /* JADX WARNING: Missing block: B:38:0x008d, code skipped:
            r0 = r1;
     */
    /* JADX WARNING: Missing block: B:60:?, code skipped:
            r1.close();
     */
    /* JADX WARNING: Missing block: B:61:0x00b6, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:62:0x00b7, code skipped:
            r0.printStackTrace();
     */
    public static void O000000o(com.loc.O00Oo00o r8) {
        /*
        r0 = 0;
        r1 = r8.O00000oo;	 Catch:{ Throwable -> 0x009d }
        r1 = r1.O00000o0();	 Catch:{ Throwable -> 0x009d }
        if (r1 == 0) goto L_0x008f;
    L_0x0009:
        r1 = r8.O00000oo;	 Catch:{ Throwable -> 0x009d }
        r2 = 1;
        r1.O000000o(r2);	 Catch:{ Throwable -> 0x009d }
        r1 = new java.io.File;	 Catch:{ Throwable -> 0x009d }
        r3 = r8.O000000o;	 Catch:{ Throwable -> 0x009d }
        r1.<init>(r3);	 Catch:{ Throwable -> 0x009d }
        r3 = r8.O00000Oo;	 Catch:{ Throwable -> 0x009d }
        r1 = com.loc.O00O0O0o.O000000o(r1, r3);	 Catch:{ Throwable -> 0x009d }
        r3 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x008c, all -> 0x008a }
        r3.<init>();	 Catch:{ Throwable -> 0x008c, all -> 0x008a }
        r4 = O000000o(r1, r8, r3);	 Catch:{ Throwable -> 0x008c, all -> 0x008a }
        if (r4 == 0) goto L_0x007f;
    L_0x0027:
        r5 = r4.length;	 Catch:{ Throwable -> 0x008c, all -> 0x008a }
        if (r5 != 0) goto L_0x002b;
    L_0x002a:
        goto L_0x007f;
    L_0x002b:
        r5 = new com.loc.O0000o0;	 Catch:{ Throwable -> 0x008c, all -> 0x008a }
        r6 = r8.O00000o0;	 Catch:{ Throwable -> 0x008c, all -> 0x008a }
        r5.<init>(r4, r6);	 Catch:{ Throwable -> 0x008c, all -> 0x008a }
        com.loc.O00O0o.O000000o();	 Catch:{ Throwable -> 0x008c, all -> 0x008a }
        r5 = com.loc.O00O0o.O00000Oo(r5);	 Catch:{ Throwable -> 0x008c, all -> 0x008a }
        r6 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x008c, all -> 0x008a }
        r7 = new java.lang.String;	 Catch:{ Throwable -> 0x008c, all -> 0x008a }
        r7.<init>(r5);	 Catch:{ Throwable -> 0x008c, all -> 0x008a }
        r6.<init>(r7);	 Catch:{ Throwable -> 0x008c, all -> 0x008a }
        r5 = "code";
        r5 = r6.has(r5);	 Catch:{ Throwable -> 0x008c, all -> 0x008a }
        if (r5 == 0) goto L_0x007d;
    L_0x004b:
        r5 = "code";
        r5 = r6.getInt(r5);	 Catch:{ Throwable -> 0x008c, all -> 0x008a }
        if (r5 != r2) goto L_0x007d;
    L_0x0053:
        r2 = r8.O00000oo;	 Catch:{ Throwable -> 0x008c, all -> 0x008a }
        if (r2 == 0) goto L_0x005f;
    L_0x0057:
        if (r4 == 0) goto L_0x005f;
    L_0x0059:
        r2 = r8.O00000oo;	 Catch:{ Throwable -> 0x008c, all -> 0x008a }
        r4 = r4.length;	 Catch:{ Throwable -> 0x008c, all -> 0x008a }
        r2.O000000o(r4);	 Catch:{ Throwable -> 0x008c, all -> 0x008a }
    L_0x005f:
        r8 = r8.O00000oo;	 Catch:{ Throwable -> 0x008c, all -> 0x008a }
        r8 = r8.O00000Oo();	 Catch:{ Throwable -> 0x008c, all -> 0x008a }
        r2 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        if (r8 >= r2) goto L_0x006e;
    L_0x006a:
        O000000o(r1, r3);	 Catch:{ Throwable -> 0x008c, all -> 0x008a }
        goto L_0x008f;
    L_0x006e:
        if (r1 == 0) goto L_0x008f;
    L_0x0070:
        r1.O00000o();	 Catch:{ Throwable -> 0x0074, all -> 0x008a }
        goto L_0x008f;
    L_0x0074:
        r8 = move-exception;
        r2 = "ofm";
        r3 = "dlo";
        com.loc.O0000o.O00000Oo(r8, r2, r3);	 Catch:{ Throwable -> 0x008c, all -> 0x008a }
        goto L_0x008f;
    L_0x007d:
        r0 = r1;
        goto L_0x008f;
    L_0x007f:
        if (r1 == 0) goto L_0x0089;
    L_0x0081:
        r1.close();	 Catch:{ Throwable -> 0x0085 }
        return;
    L_0x0085:
        r8 = move-exception;
        r8.printStackTrace();
    L_0x0089:
        return;
    L_0x008a:
        r8 = move-exception;
        goto L_0x00b0;
    L_0x008c:
        r8 = move-exception;
        r0 = r1;
        goto L_0x009e;
    L_0x008f:
        if (r0 == 0) goto L_0x0099;
    L_0x0091:
        r0.close();	 Catch:{ Throwable -> 0x0095 }
        return;
    L_0x0095:
        r8 = move-exception;
        r8.printStackTrace();
    L_0x0099:
        return;
    L_0x009a:
        r8 = move-exception;
        r1 = r0;
        goto L_0x00b0;
    L_0x009d:
        r8 = move-exception;
    L_0x009e:
        r1 = "leg";
        r2 = "uts";
        com.loc.O0000o.O00000Oo(r8, r1, r2);	 Catch:{ all -> 0x009a }
        if (r0 == 0) goto L_0x00af;
    L_0x00a7:
        r0.close();	 Catch:{ Throwable -> 0x00ab }
        return;
    L_0x00ab:
        r8 = move-exception;
        r8.printStackTrace();
    L_0x00af:
        return;
    L_0x00b0:
        if (r1 == 0) goto L_0x00ba;
    L_0x00b2:
        r1.close();	 Catch:{ Throwable -> 0x00b6 }
        goto L_0x00ba;
    L_0x00b6:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x00ba:
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O00Oo0.O000000o(com.loc.O00Oo00o):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x005a A:{SYNTHETIC, Splitter:B:31:0x005a} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0064 A:{SYNTHETIC, Splitter:B:36:0x0064} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005a A:{SYNTHETIC, Splitter:B:31:0x005a} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0064 A:{SYNTHETIC, Splitter:B:36:0x0064} */
    public static void O000000o(java.lang.String r4, byte[] r5, com.loc.O00Oo00o r6) throws java.io.IOException, java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, javax.crypto.IllegalBlockSizeException, javax.crypto.BadPaddingException, javax.crypto.NoSuchPaddingException, java.security.InvalidKeyException, java.security.spec.InvalidKeySpecException {
        /*
        r0 = 0;
        r1 = r6.O000000o;	 Catch:{ all -> 0x0056 }
        r1 = O000000o(r1, r4);	 Catch:{ all -> 0x0056 }
        if (r1 == 0) goto L_0x000a;
    L_0x0009:
        return;
    L_0x000a:
        r1 = new java.io.File;	 Catch:{ all -> 0x0056 }
        r2 = r6.O000000o;	 Catch:{ all -> 0x0056 }
        r1.<init>(r2);	 Catch:{ all -> 0x0056 }
        r2 = r1.exists();	 Catch:{ all -> 0x0056 }
        if (r2 != 0) goto L_0x001a;
    L_0x0017:
        r1.mkdirs();	 Catch:{ all -> 0x0056 }
    L_0x001a:
        r2 = r6.O00000Oo;	 Catch:{ all -> 0x0056 }
        r1 = com.loc.O00O0O0o.O000000o(r1, r2);	 Catch:{ all -> 0x0056 }
        r2 = r6.O00000o;	 Catch:{ all -> 0x0054 }
        r1.O000000o(r2);	 Catch:{ all -> 0x0054 }
        r6 = r6.O00000oO;	 Catch:{ all -> 0x0054 }
        r5 = r6.O000000o(r5);	 Catch:{ all -> 0x0054 }
        r4 = r1.O00000Oo(r4);	 Catch:{ all -> 0x0054 }
        r6 = r4.O000000o();	 Catch:{ all -> 0x0054 }
        r6.write(r5);	 Catch:{ all -> 0x0051 }
        r4.O00000Oo();	 Catch:{ all -> 0x0051 }
        r1.O00000o0();	 Catch:{ all -> 0x0051 }
        if (r6 == 0) goto L_0x0046;
    L_0x003e:
        r6.close();	 Catch:{ Throwable -> 0x0042 }
        goto L_0x0046;
    L_0x0042:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x0046:
        if (r1 == 0) goto L_0x0050;
    L_0x0048:
        r1.close();	 Catch:{ Throwable -> 0x004c }
        return;
    L_0x004c:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x0050:
        return;
    L_0x0051:
        r4 = move-exception;
        r0 = r6;
        goto L_0x0058;
    L_0x0054:
        r4 = move-exception;
        goto L_0x0058;
    L_0x0056:
        r4 = move-exception;
        r1 = r0;
    L_0x0058:
        if (r0 == 0) goto L_0x0062;
    L_0x005a:
        r0.close();	 Catch:{ Throwable -> 0x005e }
        goto L_0x0062;
    L_0x005e:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x0062:
        if (r1 == 0) goto L_0x006c;
    L_0x0064:
        r1.close();	 Catch:{ Throwable -> 0x0068 }
        goto L_0x006c;
    L_0x0068:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x006c:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O00Oo0.O000000o(java.lang.String, byte[], com.loc.O00Oo00o):void");
    }

    private static boolean O000000o(String str, String str2) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str2);
            stringBuilder.append(".0");
            return new File(str, stringBuilder.toString()).exists();
        } catch (Throwable th) {
            O0000o.O00000Oo(th, "leg", "fet");
            return false;
        }
    }

    private static byte[] O000000o(O00O0O0o o00O0O0o, O00Oo00o o00Oo00o, List<String> list) {
        try {
            File O00000Oo = o00O0O0o.O00000Oo();
            if (O00000Oo != null && O00000Oo.exists()) {
                String[] list2 = O00000Oo.list();
                int length = list2.length;
                int i = 0;
                int i2 = i;
                while (i < length) {
                    String str = list2[i];
                    if (str.contains(".0")) {
                        str = str.split("\\.")[0];
                        byte[] O000000o = O00Ooo00.O000000o(o00O0O0o, str);
                        i2 += O000000o.length;
                        list.add(str);
                        if (i2 > o00Oo00o.O00000oo.O00000Oo()) {
                            break;
                        }
                        o00Oo00o.O0000O0o.O00000Oo(O000000o);
                    }
                    i++;
                }
                return o00Oo00o.O0000O0o.O000000o();
            }
        } catch (Throwable th) {
            O0000o.O00000Oo(th, "leg", "gCo");
        }
        return new byte[0];
    }
}
