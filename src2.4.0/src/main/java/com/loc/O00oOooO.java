package com.loc;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ErrorLogManager */
public class O00oOooO {
    private static WeakReference<O00Oo00o> O000000o = null;
    private static boolean O00000Oo = true;
    private static WeakReference<O0O0OO0> O00000o;
    private static WeakReference<O0O0OO0> O00000o0;
    private static String[] O00000oO = new String[10];
    private static int O00000oo;
    private static boolean O0000O0o;
    private static int O0000OOo;
    private static OO0Oo0 O0000Oo0;

    private static OO0Oo0 O000000o(Context context, String str) {
        List O00000o0 = O0000o00.O00000o0(context);
        if (O00000o0 == null) {
            O00000o0 = new ArrayList();
        }
        if (str == null || "".equals(str)) {
            return null;
        }
        for (OO0Oo0 oO0Oo0 : O00000o0) {
            if (O0000o00.O000000o(oO0Oo0.O00000oo(), str)) {
                return oO0Oo0;
            }
        }
        if (str.contains("com.amap.api.col")) {
            try {
                return OO0o000.O000000o();
            } catch (OO00Oo0 e) {
                e.printStackTrace();
            }
        }
        if (str.contains("com.amap.co") || str.contains("com.amap.opensdk.co") || str.contains("com.amap.location")) {
            try {
                OO0Oo0 O00000Oo = OO0o000.O00000Oo();
                O00000Oo.O000000o(true);
                return O00000Oo;
            } catch (OO00Oo0 e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x0129 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x010f A:{SYNTHETIC, Splitter:B:92:0x010f} */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x011d A:{SYNTHETIC, Splitter:B:97:0x011d} */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0129 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0129 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A:{SYNTHETIC, Splitter:B:12:0x002b, ExcHandler: EOFException (unused java.io.EOFException)} */
    /* JADX WARNING: Removed duplicated region for block: B:91:? A:{SYNTHETIC, Splitter:B:12:0x002b, ExcHandler: FileNotFoundException (unused java.io.FileNotFoundException)} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00db A:{SYNTHETIC, Splitter:B:69:0x00db} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00e9 A:{SYNTHETIC, Splitter:B:74:0x00e9} */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0129 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00f0 A:{SYNTHETIC, Splitter:B:78:0x00f0} */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00fe A:{SYNTHETIC, Splitter:B:83:0x00fe} */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x010f A:{SYNTHETIC, Splitter:B:92:0x010f} */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x011d A:{SYNTHETIC, Splitter:B:97:0x011d} */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0129 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00db A:{SYNTHETIC, Splitter:B:69:0x00db} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00e9 A:{SYNTHETIC, Splitter:B:74:0x00e9} */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0129 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00f0 A:{SYNTHETIC, Splitter:B:78:0x00f0} */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00fe A:{SYNTHETIC, Splitter:B:83:0x00fe} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:28:0x006b, code skipped:
            r6 = move-exception;
     */
    /* JADX WARNING: Missing block: B:30:?, code skipped:
            com.loc.O0000o.O00000Oo(r6, "alg", "aDa");
     */
    /* JADX WARNING: Missing block: B:93:?, code skipped:
            r1.close();
     */
    /* JADX WARNING: Missing block: B:94:0x0113, code skipped:
            r10 = move-exception;
     */
    /* JADX WARNING: Missing block: B:95:0x0114, code skipped:
            com.loc.O0000o.O00000Oo(r10, "alg", "getA");
     */
    /* JADX WARNING: Missing block: B:98:?, code skipped:
            r2.close();
     */
    private static java.lang.String O000000o(java.util.List<com.loc.OO0Oo0> r10) {
        /*
        r0 = 0;
        r1 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x010b, Throwable -> 0x00cf, all -> 0x00cb }
        r2 = "/data/anr/traces.txt";
        r1.<init>(r2);	 Catch:{ FileNotFoundException -> 0x010b, Throwable -> 0x00cf, all -> 0x00cb }
        r2 = r1.exists();	 Catch:{ FileNotFoundException -> 0x010b, Throwable -> 0x00cf, all -> 0x00cb }
        if (r2 != 0) goto L_0x000f;
    L_0x000e:
        return r0;
    L_0x000f:
        r2 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x010b, Throwable -> 0x00cf, all -> 0x00cb }
        r2.<init>(r1);	 Catch:{ FileNotFoundException -> 0x010b, Throwable -> 0x00cf, all -> 0x00cb }
        r1 = r2.available();	 Catch:{ FileNotFoundException -> 0x00c9, Throwable -> 0x00c6, all -> 0x00c3 }
        r3 = 1024000; // 0xfa000 float:1.43493E-39 double:5.05923E-318;
        if (r1 <= r3) goto L_0x0022;
    L_0x001d:
        r1 = r1 - r3;
        r3 = (long) r1;	 Catch:{ FileNotFoundException -> 0x00c9, Throwable -> 0x00c6, all -> 0x00c3 }
        r2.skip(r3);	 Catch:{ FileNotFoundException -> 0x00c9, Throwable -> 0x00c6, all -> 0x00c3 }
    L_0x0022:
        r1 = new com.loc.O00O0Oo0;	 Catch:{ FileNotFoundException -> 0x00c9, Throwable -> 0x00c6, all -> 0x00c3 }
        r3 = com.loc.O00O0o00.O000000o;	 Catch:{ FileNotFoundException -> 0x00c9, Throwable -> 0x00c6, all -> 0x00c3 }
        r1.<init>(r2, r3);	 Catch:{ FileNotFoundException -> 0x00c9, Throwable -> 0x00c6, all -> 0x00c3 }
        r3 = 0;
        r4 = r3;
    L_0x002b:
        r5 = r1.O000000o();	 Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x010d, Throwable -> 0x00a2 }
        r5 = r5.trim();	 Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x010d, Throwable -> 0x00a2 }
        r6 = "pid";
        r6 = r5.contains(r6);	 Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x010d, Throwable -> 0x00a2 }
        r7 = 1;
        if (r6 == 0) goto L_0x004a;
    L_0x003c:
        r4 = "\"main\"";
        r4 = r5.startsWith(r4);	 Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x010d, Throwable -> 0x00a2 }
        if (r4 != 0) goto L_0x0049;
    L_0x0044:
        r5 = r1.O000000o();	 Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x010d, Throwable -> 0x00a2 }
        goto L_0x003c;
    L_0x0049:
        r4 = r7;
    L_0x004a:
        r6 = "";
        r6 = r5.equals(r6);	 Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x010d, Throwable -> 0x00a2 }
        if (r6 == 0) goto L_0x0055;
    L_0x0052:
        if (r4 == 0) goto L_0x0055;
    L_0x0054:
        goto L_0x00a4;
    L_0x0055:
        if (r4 == 0) goto L_0x002b;
    L_0x0057:
        r6 = O00000oo;	 Catch:{ Throwable -> 0x006b, EOFException -> 0x00a4, FileNotFoundException -> 0x010d }
        r8 = 9;
        if (r6 <= r8) goto L_0x005f;
    L_0x005d:
        O00000oo = r3;	 Catch:{ Throwable -> 0x006b, EOFException -> 0x00a4, FileNotFoundException -> 0x010d }
    L_0x005f:
        r6 = O00000oO;	 Catch:{ Throwable -> 0x006b, EOFException -> 0x00a4, FileNotFoundException -> 0x010d }
        r8 = O00000oo;	 Catch:{ Throwable -> 0x006b, EOFException -> 0x00a4, FileNotFoundException -> 0x010d }
        r6[r8] = r5;	 Catch:{ Throwable -> 0x006b, EOFException -> 0x00a4, FileNotFoundException -> 0x010d }
        r6 = O00000oo;	 Catch:{ Throwable -> 0x006b, EOFException -> 0x00a4, FileNotFoundException -> 0x010d }
        r6 = r6 + r7;
        O00000oo = r6;	 Catch:{ Throwable -> 0x006b, EOFException -> 0x00a4, FileNotFoundException -> 0x010d }
        goto L_0x0073;
    L_0x006b:
        r6 = move-exception;
        r8 = "alg";
        r9 = "aDa";
        com.loc.O0000o.O00000Oo(r6, r8, r9);	 Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x010d, Throwable -> 0x00a2 }
    L_0x0073:
        r6 = O0000OOo;	 Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x010d, Throwable -> 0x00a2 }
        r8 = 5;
        if (r6 != r8) goto L_0x0079;
    L_0x0078:
        goto L_0x00a4;
    L_0x0079:
        r6 = O0000O0o;	 Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x010d, Throwable -> 0x00a2 }
        if (r6 != 0) goto L_0x009c;
    L_0x007d:
        r6 = r10.iterator();	 Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x010d, Throwable -> 0x00a2 }
    L_0x0081:
        r7 = r6.hasNext();	 Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x010d, Throwable -> 0x00a2 }
        if (r7 == 0) goto L_0x002b;
    L_0x0087:
        r7 = r6.next();	 Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x010d, Throwable -> 0x00a2 }
        r7 = (com.loc.OO0Oo0) r7;	 Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x010d, Throwable -> 0x00a2 }
        r8 = r7.O00000oo();	 Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x010d, Throwable -> 0x00a2 }
        r8 = com.loc.O0000o00.O00000Oo(r8, r5);	 Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x010d, Throwable -> 0x00a2 }
        O0000O0o = r8;	 Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x010d, Throwable -> 0x00a2 }
        if (r8 == 0) goto L_0x0081;
    L_0x0099:
        O0000Oo0 = r7;	 Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x010d, Throwable -> 0x00a2 }
        goto L_0x002b;
    L_0x009c:
        r5 = O0000OOo;	 Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x010d, Throwable -> 0x00a2 }
        r5 = r5 + r7;
        O0000OOo = r5;	 Catch:{ EOFException -> 0x00a4, FileNotFoundException -> 0x010d, Throwable -> 0x00a2 }
        goto L_0x002b;
    L_0x00a2:
        r10 = move-exception;
        goto L_0x00d2;
    L_0x00a4:
        if (r1 == 0) goto L_0x00b2;
    L_0x00a6:
        r1.close();	 Catch:{ Throwable -> 0x00aa }
        goto L_0x00b2;
    L_0x00aa:
        r10 = move-exception;
        r1 = "alg";
        r3 = "getA";
        com.loc.O0000o.O00000Oo(r10, r1, r3);
    L_0x00b2:
        if (r2 == 0) goto L_0x0120;
    L_0x00b4:
        r2.close();	 Catch:{ Throwable -> 0x00b9 }
        goto L_0x0120;
    L_0x00b9:
        r10 = move-exception;
        r1 = "alg";
        r2 = "getA";
        com.loc.O0000o.O00000Oo(r10, r1, r2);
        goto L_0x0120;
    L_0x00c3:
        r10 = move-exception;
        r1 = r0;
        goto L_0x00ee;
    L_0x00c6:
        r10 = move-exception;
        r1 = r0;
        goto L_0x00d2;
    L_0x00c9:
        r1 = r0;
        goto L_0x010d;
    L_0x00cb:
        r10 = move-exception;
        r1 = r0;
        r2 = r1;
        goto L_0x00ee;
    L_0x00cf:
        r10 = move-exception;
        r1 = r0;
        r2 = r1;
    L_0x00d2:
        r3 = "alg";
        r4 = "getA";
        com.loc.O0000o.O00000Oo(r10, r3, r4);	 Catch:{ all -> 0x00ed }
        if (r1 == 0) goto L_0x00e7;
    L_0x00db:
        r1.close();	 Catch:{ Throwable -> 0x00df }
        goto L_0x00e7;
    L_0x00df:
        r10 = move-exception;
        r1 = "alg";
        r3 = "getA";
        com.loc.O0000o.O00000Oo(r10, r1, r3);
    L_0x00e7:
        if (r2 == 0) goto L_0x0120;
    L_0x00e9:
        r2.close();	 Catch:{ Throwable -> 0x00b9 }
        goto L_0x0120;
    L_0x00ed:
        r10 = move-exception;
    L_0x00ee:
        if (r1 == 0) goto L_0x00fc;
    L_0x00f0:
        r1.close();	 Catch:{ Throwable -> 0x00f4 }
        goto L_0x00fc;
    L_0x00f4:
        r0 = move-exception;
        r1 = "alg";
        r3 = "getA";
        com.loc.O0000o.O00000Oo(r0, r1, r3);
    L_0x00fc:
        if (r2 == 0) goto L_0x010a;
    L_0x00fe:
        r2.close();	 Catch:{ Throwable -> 0x0102 }
        goto L_0x010a;
    L_0x0102:
        r0 = move-exception;
        r1 = "alg";
        r2 = "getA";
        com.loc.O0000o.O00000Oo(r0, r1, r2);
    L_0x010a:
        throw r10;
    L_0x010b:
        r1 = r0;
        r2 = r1;
    L_0x010d:
        if (r1 == 0) goto L_0x011b;
    L_0x010f:
        r1.close();	 Catch:{ Throwable -> 0x0113 }
        goto L_0x011b;
    L_0x0113:
        r10 = move-exception;
        r1 = "alg";
        r3 = "getA";
        com.loc.O0000o.O00000Oo(r10, r1, r3);
    L_0x011b:
        if (r2 == 0) goto L_0x0120;
    L_0x011d:
        r2.close();	 Catch:{ Throwable -> 0x00b9 }
    L_0x0120:
        r10 = O0000O0o;
        if (r10 == 0) goto L_0x0129;
    L_0x0124:
        r10 = O00000Oo();
        return r10;
    L_0x0129:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O00oOooO.O000000o(java.util.List):java.lang.String");
    }

    static void O000000o(Context context) {
        List O00000o0 = O0000o00.O00000o0(context);
        if (O00000o0 != null && O00000o0.size() != 0) {
            String O000000o = O000000o(O00000o0);
            if (O000000o != null && !"".equals(O000000o) && O0000Oo0 != null) {
                O000000o(context, O0000Oo0, 2, "ANR", O000000o);
            }
        }
    }

    private static void O000000o(final Context context, final O0O0OO0 o0o0oo0, final String str) {
        O0000o.O00000o().submit(new Runnable() {
            public final void run() {
                try {
                    synchronized (O00oOooO.class) {
                        O00Oo00o O000000o = O00Ooo00.O000000o(O00oOooO.O000000o);
                        O00Ooo00.O000000o(context, O000000o, str, 1000, 20480, "1");
                        O000000o.O00000oo = o0o0oo0;
                        if (O000000o.O0000O0o == null) {
                            O000000o.O0000O0o = new O00oo000(new O00o0(context, new O0O000o(), new OO0o(new O00000o0(new O0000O0o())), "EImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMiLA=", OO00o00.O00000oo(context), OO0O0o0.O0000oo0(context), OO00o00.O00000o0(context), Build.MODEL, OO00o00.O00000Oo(context), OO00o00.O00000o(context), VERSION.RELEASE));
                        }
                        O000000o.O0000OOo = 3600000;
                        O00Oo0.O000000o(O000000o);
                    }
                } catch (Throwable th) {
                    O0000o.O00000Oo(th, "lg", "pul");
                }
            }
        });
    }

    private static void O000000o(Context context, OO0Oo0 oO0Oo0, int i, String str, String str2) {
        String O000000o = OO0o000.O000000o(System.currentTimeMillis());
        String O000000o2 = O00Ooo00.O000000o(context, oO0Oo0);
        OO00o00.O000000o(context);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(O000000o2);
        stringBuffer.append(",\"timestamp\":\"");
        stringBuffer.append(O000000o);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(i);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str);
        stringBuffer.append("\",");
        stringBuffer.append("\"detail\":\"");
        stringBuffer.append(str2);
        stringBuffer.append("\"");
        O000000o2 = stringBuffer.toString();
        if (O000000o2 != null && !"".equals(O000000o2)) {
            String str3;
            str = OO0OOOO.O00000o0(str2);
            if (i == 1) {
                str3 = O0000o00.O00000Oo;
            } else if (i == 2) {
                str3 = O0000o00.O00000o;
            } else {
                if (i == 0) {
                    str3 = O0000o00.O00000o0;
                }
            }
            String str4 = str3;
            O00Oo00o O000000o3 = O00Ooo00.O000000o(O000000o);
            O00Ooo00.O000000o(context, O000000o3, str4, 1000, 20480, "1");
            if (O000000o3.O00000oO == null) {
                O000000o3.O00000oO = new OO0o0(new OO0o(new O00000o0(new O0000O0o())));
            }
            try {
                O00Oo0.O000000o(str, OO0o000.O000000o(O000000o2), O000000o3);
            } catch (Throwable unused) {
            }
        }
    }

    public static void O000000o(Context context, Throwable th, int i, String str, String str2) {
        String O000000o = OO0o000.O000000o(th);
        OO0Oo0 O000000o2 = O000000o(context, O000000o);
        if (O000000o(O000000o2)) {
            O000000o = O000000o.replaceAll("\n", "<br/>");
            String th2 = th.toString();
            if (th2 != null && !"".equals(th2)) {
                StringBuilder stringBuilder = new StringBuilder();
                if (str != null) {
                    stringBuilder.append("class:");
                    stringBuilder.append(str);
                }
                if (str2 != null) {
                    stringBuilder.append(" method:");
                    stringBuilder.append(str2);
                    stringBuilder.append("$<br/>");
                }
                stringBuilder.append(O000000o);
                O000000o(context, O000000o2, i, th2, stringBuilder.toString());
            }
        }
    }

    static void O000000o(OO0Oo0 oO0Oo0, Context context, String str, String str2) {
        if (O000000o(oO0Oo0) && str != null && !"".equals(str)) {
            O000000o(context, oO0Oo0, 0, str, str2);
        }
    }

    private static boolean O000000o(OO0Oo0 oO0Oo0) {
        return oO0Oo0 != null && oO0Oo0.O00000oO();
    }

    private static String O00000Oo() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            int i = O00000oo;
            while (i < 10 && i <= 9) {
                stringBuilder.append(O00000oO[i]);
                i++;
            }
            for (i = 0; i < O00000oo; i++) {
                stringBuilder.append(O00000oO[i]);
            }
        } catch (Throwable th) {
            O0000o.O00000Oo(th, "alg", "gLI");
        }
        return stringBuilder.toString();
    }

    static void O00000Oo(Context context) {
        O0O0O0o o0O0O0o = new O0O0O0o(O00000Oo);
        O00000Oo = false;
        O000000o(context, o0O0O0o, O0000o00.O00000o0);
    }

    static void O00000Oo(OO0Oo0 oO0Oo0, Context context, String str, String str2) {
        if (O000000o(oO0Oo0) && str != null && !"".equals(str)) {
            O000000o(context, oO0Oo0, 1, str, str2);
        }
    }

    static void O00000o(Context context) {
        if (O00000o == null || O00000o.get() == null) {
            O00000o = new WeakReference(new O0O0O(context, 3600000, "gKey", new O0O0OO(context)));
        }
        O000000o(context, (O0O0OO0) O00000o.get(), O0000o00.O00000Oo);
    }

    static void O00000o0(Context context) {
        if (O00000o0 == null || O00000o0.get() == null) {
            O00000o0 = new WeakReference(new O0O0O(context, 3600000, "hKey", new O0O0OO(context)));
        }
        O000000o(context, (O0O0OO0) O00000o0.get(), O0000o00.O00000o);
    }
}
