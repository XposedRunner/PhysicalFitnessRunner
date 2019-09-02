package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ErrorLogManager */
public class oO0OOo0o {
    private static WeakReference<oOOO00Oo> O000000o = null;
    private static boolean O00000Oo = true;
    private static WeakReference<p> O00000o;
    private static WeakReference<p> O00000o0;
    private static String[] O00000oO = new String[10];
    private static int O00000oo;
    private static boolean O0000O0o;
    private static int O0000OOo;
    private static o0OO0o00 O0000Oo0;

    static o0OO0o00 O000000o(Context context, String str) {
        List O00000o0 = oO0Oo0oo.O00000o0(context);
        if (O00000o0 == null) {
            O00000o0 = new ArrayList();
        }
        if (str == null || "".equals(str)) {
            return null;
        }
        for (o0OO0o00 o0oo0o00 : O00000o0) {
            if (oO0Oo0oo.O000000o(o0oo0o00.O0000O0o(), str)) {
                return o0oo0o00;
            }
        }
        if (str.contains("com.amap.api.col")) {
            try {
                return o0OOOO00.O000000o();
            } catch (o0O0oo0o e) {
                e.printStackTrace();
            }
        }
        if (str.contains("com.amap.co") || str.contains("com.amap.opensdk.co") || str.contains("com.amap.location")) {
            try {
                o0OO0o00 O00000Oo = o0OOOO00.O00000Oo();
                O00000Oo.O000000o(true);
                return O00000Oo;
            } catch (o0O0oo0o e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    private static String O000000o(Throwable th) {
        return th.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:96:0x0111 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0111 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00f7 A:{SYNTHETIC, Splitter:B:85:0x00f7} */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0105 A:{SYNTHETIC, Splitter:B:90:0x0105} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0111 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00c3 A:{SYNTHETIC, Splitter:B:62:0x00c3} */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d1 A:{SYNTHETIC, Splitter:B:67:0x00d1} */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0111 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00d8 A:{SYNTHETIC, Splitter:B:71:0x00d8} */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e6 A:{SYNTHETIC, Splitter:B:76:0x00e6} */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00f7 A:{SYNTHETIC, Splitter:B:85:0x00f7} */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0105 A:{SYNTHETIC, Splitter:B:90:0x0105} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0111 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00c3 A:{SYNTHETIC, Splitter:B:62:0x00c3} */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d1 A:{SYNTHETIC, Splitter:B:67:0x00d1} */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0111 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00d8 A:{SYNTHETIC, Splitter:B:71:0x00d8} */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e6 A:{SYNTHETIC, Splitter:B:76:0x00e6} */
    static java.lang.String O000000o(java.util.List<com.amap.api.mapcore.util.o0OO0o00> r8) {
        /*
        r0 = 0;
        r1 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x00f3, Throwable -> 0x00b7, all -> 0x00b3 }
        r2 = "/data/anr/traces.txt";
        r1.<init>(r2);	 Catch:{ FileNotFoundException -> 0x00f3, Throwable -> 0x00b7, all -> 0x00b3 }
        r2 = r1.exists();	 Catch:{ FileNotFoundException -> 0x00f3, Throwable -> 0x00b7, all -> 0x00b3 }
        if (r2 != 0) goto L_0x000f;
    L_0x000e:
        return r0;
    L_0x000f:
        r2 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x00f3, Throwable -> 0x00b7, all -> 0x00b3 }
        r2.<init>(r1);	 Catch:{ FileNotFoundException -> 0x00f3, Throwable -> 0x00b7, all -> 0x00b3 }
        r1 = r2.available();	 Catch:{ FileNotFoundException -> 0x00b1, Throwable -> 0x00ae, all -> 0x00ab }
        r3 = 1024000; // 0xfa000 float:1.43493E-39 double:5.05923E-318;
        if (r1 <= r3) goto L_0x0022;
    L_0x001d:
        r1 = r1 - r3;
        r3 = (long) r1;	 Catch:{ FileNotFoundException -> 0x00b1, Throwable -> 0x00ae, all -> 0x00ab }
        r2.skip(r3);	 Catch:{ FileNotFoundException -> 0x00b1, Throwable -> 0x00ae, all -> 0x00ab }
    L_0x0022:
        r1 = new com.amap.api.mapcore.util.oO0o0000;	 Catch:{ FileNotFoundException -> 0x00b1, Throwable -> 0x00ae, all -> 0x00ab }
        r3 = com.amap.api.mapcore.util.oOo00o00.O000000o;	 Catch:{ FileNotFoundException -> 0x00b1, Throwable -> 0x00ae, all -> 0x00ab }
        r1.<init>(r2, r3);	 Catch:{ FileNotFoundException -> 0x00b1, Throwable -> 0x00ae, all -> 0x00ab }
        r3 = 0;
    L_0x002a:
        r4 = r1.O000000o();	 Catch:{ EOFException -> 0x008c, FileNotFoundException -> 0x00f5, Throwable -> 0x008a }
        r4 = r4.trim();	 Catch:{ EOFException -> 0x008c, FileNotFoundException -> 0x00f5, Throwable -> 0x008a }
        r5 = "pid";
        r5 = r4.contains(r5);	 Catch:{ EOFException -> 0x008c, FileNotFoundException -> 0x00f5, Throwable -> 0x008a }
        r6 = 1;
        if (r5 == 0) goto L_0x0049;
    L_0x003b:
        r3 = "\"main\"";
        r3 = r4.startsWith(r3);	 Catch:{ EOFException -> 0x008c, FileNotFoundException -> 0x00f5, Throwable -> 0x008a }
        if (r3 != 0) goto L_0x0048;
    L_0x0043:
        r4 = r1.O000000o();	 Catch:{ EOFException -> 0x008c, FileNotFoundException -> 0x00f5, Throwable -> 0x008a }
        goto L_0x003b;
    L_0x0048:
        r3 = r6;
    L_0x0049:
        r5 = "";
        r5 = r4.equals(r5);	 Catch:{ EOFException -> 0x008c, FileNotFoundException -> 0x00f5, Throwable -> 0x008a }
        if (r5 == 0) goto L_0x0054;
    L_0x0051:
        if (r3 == 0) goto L_0x0054;
    L_0x0053:
        goto L_0x008c;
    L_0x0054:
        if (r3 == 0) goto L_0x002a;
    L_0x0056:
        O000000o(r4);	 Catch:{ EOFException -> 0x008c, FileNotFoundException -> 0x00f5, Throwable -> 0x008a }
        r5 = O0000OOo;	 Catch:{ EOFException -> 0x008c, FileNotFoundException -> 0x00f5, Throwable -> 0x008a }
        r7 = 5;
        if (r5 != r7) goto L_0x005f;
    L_0x005e:
        goto L_0x008c;
    L_0x005f:
        r5 = O0000O0o;	 Catch:{ EOFException -> 0x008c, FileNotFoundException -> 0x00f5, Throwable -> 0x008a }
        if (r5 != 0) goto L_0x0084;
    L_0x0063:
        r5 = r8.iterator();	 Catch:{ EOFException -> 0x008c, FileNotFoundException -> 0x00f5, Throwable -> 0x008a }
    L_0x0067:
        r6 = r5.hasNext();	 Catch:{ EOFException -> 0x008c, FileNotFoundException -> 0x00f5, Throwable -> 0x008a }
        if (r6 == 0) goto L_0x002a;
    L_0x006d:
        r6 = r5.next();	 Catch:{ EOFException -> 0x008c, FileNotFoundException -> 0x00f5, Throwable -> 0x008a }
        r6 = (com.amap.api.mapcore.util.o0OO0o00) r6;	 Catch:{ EOFException -> 0x008c, FileNotFoundException -> 0x00f5, Throwable -> 0x008a }
        r7 = r6.O0000O0o();	 Catch:{ EOFException -> 0x008c, FileNotFoundException -> 0x00f5, Throwable -> 0x008a }
        r7 = com.amap.api.mapcore.util.oO0Oo0oo.O00000Oo(r7, r4);	 Catch:{ EOFException -> 0x008c, FileNotFoundException -> 0x00f5, Throwable -> 0x008a }
        O0000O0o = r7;	 Catch:{ EOFException -> 0x008c, FileNotFoundException -> 0x00f5, Throwable -> 0x008a }
        r7 = O0000O0o;	 Catch:{ EOFException -> 0x008c, FileNotFoundException -> 0x00f5, Throwable -> 0x008a }
        if (r7 == 0) goto L_0x0067;
    L_0x0081:
        O0000Oo0 = r6;	 Catch:{ EOFException -> 0x008c, FileNotFoundException -> 0x00f5, Throwable -> 0x008a }
        goto L_0x002a;
    L_0x0084:
        r4 = O0000OOo;	 Catch:{ EOFException -> 0x008c, FileNotFoundException -> 0x00f5, Throwable -> 0x008a }
        r4 = r4 + r6;
        O0000OOo = r4;	 Catch:{ EOFException -> 0x008c, FileNotFoundException -> 0x00f5, Throwable -> 0x008a }
        goto L_0x002a;
    L_0x008a:
        r8 = move-exception;
        goto L_0x00ba;
    L_0x008c:
        if (r1 == 0) goto L_0x009a;
    L_0x008e:
        r1.close();	 Catch:{ Throwable -> 0x0092 }
        goto L_0x009a;
    L_0x0092:
        r8 = move-exception;
        r1 = "alg";
        r3 = "getA";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r8, r1, r3);
    L_0x009a:
        if (r2 == 0) goto L_0x0108;
    L_0x009c:
        r2.close();	 Catch:{ Throwable -> 0x00a1 }
        goto L_0x0108;
    L_0x00a1:
        r8 = move-exception;
        r1 = "alg";
        r2 = "getA";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r8, r1, r2);
        goto L_0x0108;
    L_0x00ab:
        r8 = move-exception;
        r1 = r0;
        goto L_0x00d6;
    L_0x00ae:
        r8 = move-exception;
        r1 = r0;
        goto L_0x00ba;
    L_0x00b1:
        r1 = r0;
        goto L_0x00f5;
    L_0x00b3:
        r8 = move-exception;
        r1 = r0;
        r2 = r1;
        goto L_0x00d6;
    L_0x00b7:
        r8 = move-exception;
        r1 = r0;
        r2 = r1;
    L_0x00ba:
        r3 = "alg";
        r4 = "getA";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r8, r3, r4);	 Catch:{ all -> 0x00d5 }
        if (r1 == 0) goto L_0x00cf;
    L_0x00c3:
        r1.close();	 Catch:{ Throwable -> 0x00c7 }
        goto L_0x00cf;
    L_0x00c7:
        r8 = move-exception;
        r1 = "alg";
        r3 = "getA";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r8, r1, r3);
    L_0x00cf:
        if (r2 == 0) goto L_0x0108;
    L_0x00d1:
        r2.close();	 Catch:{ Throwable -> 0x00a1 }
        goto L_0x0108;
    L_0x00d5:
        r8 = move-exception;
    L_0x00d6:
        if (r1 == 0) goto L_0x00e4;
    L_0x00d8:
        r1.close();	 Catch:{ Throwable -> 0x00dc }
        goto L_0x00e4;
    L_0x00dc:
        r0 = move-exception;
        r1 = "alg";
        r3 = "getA";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r0, r1, r3);
    L_0x00e4:
        if (r2 == 0) goto L_0x00f2;
    L_0x00e6:
        r2.close();	 Catch:{ Throwable -> 0x00ea }
        goto L_0x00f2;
    L_0x00ea:
        r0 = move-exception;
        r1 = "alg";
        r2 = "getA";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r0, r1, r2);
    L_0x00f2:
        throw r8;
    L_0x00f3:
        r1 = r0;
        r2 = r1;
    L_0x00f5:
        if (r1 == 0) goto L_0x0103;
    L_0x00f7:
        r1.close();	 Catch:{ Throwable -> 0x00fb }
        goto L_0x0103;
    L_0x00fb:
        r8 = move-exception;
        r1 = "alg";
        r3 = "getA";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r8, r1, r3);
    L_0x0103:
        if (r2 == 0) goto L_0x0108;
    L_0x0105:
        r2.close();	 Catch:{ Throwable -> 0x00a1 }
    L_0x0108:
        r8 = O0000O0o;
        if (r8 == 0) goto L_0x0111;
    L_0x010c:
        r8 = O00000Oo();
        return r8;
    L_0x0111:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.oO0OOo0o.O000000o(java.util.List):java.lang.String");
    }

    static void O000000o(Context context) {
        List O00000o0 = oO0Oo0oo.O00000o0(context);
        if (O00000o0 != null && O00000o0.size() != 0) {
            String O000000o = O000000o(O00000o0);
            if (O000000o != null && !"".equals(O000000o) && O0000Oo0 != null) {
                O000000o(context, O0000Oo0, 2, "ANR", O000000o);
            }
        }
    }

    private static void O000000o(Context context, o0OO0o00 o0oo0o00, int i, String str, String str2) {
        String O000000o = oOOo0000.O000000o();
        String O000000o2 = oOOo0000.O000000o(o0O0O0Oo.O000000o(context), oOOo0000.O000000o(context, o0oo0o00), O000000o, i, str, str2);
        if (O000000o2 != null && !"".equals(O000000o2)) {
            String str3;
            str = o0OO00o0.O00000o0(str2);
            if (i == 1) {
                str3 = oO0Oo0oo.O00000Oo;
            } else if (i == 2) {
                str3 = oO0Oo0oo.O00000o;
            } else if (i == 0) {
                str3 = oO0Oo0oo.O00000o0;
            } else {
                return;
            }
            O000000o(context, str, str3, O000000o2);
        }
    }

    public static void O000000o(Context context, o0OO0o00 o0oo0o00, String str, int i, String str2, String str3) {
        if (str2 != null && !"".equals(str2)) {
            StringBuilder stringBuilder = new StringBuilder();
            if (str2 != null) {
                stringBuilder.append("class:");
                stringBuilder.append(str2);
            }
            if (str3 != null) {
                stringBuilder.append(" method:");
                stringBuilder.append(str3);
                stringBuilder.append("$");
                stringBuilder.append("<br/>");
            }
            stringBuilder.append(str);
            O000000o(context, o0oo0o00, i, str2, stringBuilder.toString());
        }
    }

    private static void O000000o(final Context context, final p pVar, final String str) {
        ooOOOOoo.O00000o().submit(new Runnable() {
            public void run() {
                try {
                    synchronized (oO0OOo0o.class) {
                        oOOO00Oo O000000o = oOOo0000.O000000o(oO0OOo0o.O000000o);
                        oOOo0000.O000000o(context, O000000o, str, 1000, 20480, "1");
                        O000000o.O00000oo = pVar;
                        if (O000000o.O0000O0o == null) {
                            O000000o.O0000O0o = new c(new b(context, new j(), new o0Oo0000(new oO0000Oo(new oO000O0O())), "EImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMiLA=", o0O0O0Oo.O00000oo(context), o0O0o000.O0000oo0(context), o0O0O0Oo.O00000o0(context), Build.MODEL, o0O0O0Oo.O00000Oo(context), o0O0O0Oo.O00000o(context), VERSION.RELEASE));
                        }
                        O000000o.O0000OOo = 3600000;
                        oOOO00o0.O000000o(O000000o);
                    }
                } catch (Throwable th) {
                    ooOOOOoo.O00000o0(th, "lg", "pul");
                }
            }
        });
    }

    private static void O000000o(Context context, String str, String str2, String str3) {
        oOOO00Oo O000000o = oOOo0000.O000000o(O000000o);
        oOOo0000.O000000o(context, O000000o, str2, 1000, 20480, "1");
        if (O000000o.O00000oO == null) {
            O000000o.O00000oO = new o0OOo000(new o0Oo0000(new oO0000Oo(new oO000O0O())));
        }
        try {
            oOOO00o0.O000000o(str, o0OOOO00.O000000o(str3), O000000o);
        } catch (Throwable unused) {
        }
    }

    public static void O000000o(Context context, Throwable th, int i, String str, String str2) {
        String O000000o = o0OOOO00.O000000o(th);
        o0OO0o00 O000000o2 = O000000o(context, O000000o);
        if (O000000o(O000000o2)) {
            O000000o = O000000o.replaceAll("\n", "<br/>");
            String O000000o3 = O000000o(th);
            if (O000000o3 != null && !"".equals(O000000o3)) {
                StringBuilder stringBuilder = new StringBuilder();
                if (str != null) {
                    stringBuilder.append("class:");
                    stringBuilder.append(str);
                }
                if (str2 != null) {
                    stringBuilder.append(" method:");
                    stringBuilder.append(str2);
                    stringBuilder.append("$");
                    stringBuilder.append("<br/>");
                }
                stringBuilder.append(O000000o);
                O000000o(context, O000000o2, i, O000000o3, stringBuilder.toString());
            }
        }
    }

    static void O000000o(o0OO0o00 o0oo0o00, Context context, String str, String str2) {
        if (O000000o(o0oo0o00) && str != null && !"".equals(str)) {
            O000000o(context, o0oo0o00, 0, str, str2);
        }
    }

    private static void O000000o(String str) {
        try {
            if (O00000oo > 9) {
                O00000oo = 0;
            }
            O00000oO[O00000oo] = str;
            O00000oo++;
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "alg", "aDa");
        }
    }

    private static boolean O000000o(o0OO0o00 o0oo0o00) {
        return o0oo0o00 != null && o0oo0o00.O00000oo();
    }

    private static String O00000Oo() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            int i;
            for (i = O00000oo; i < 10; i++) {
                if (i > 9) {
                    break;
                }
                stringBuilder.append(O00000oO[i]);
            }
            for (i = 0; i < O00000oo; i++) {
                stringBuilder.append(O00000oO[i]);
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "alg", "gLI");
        }
        return stringBuilder.toString();
    }

    static void O00000Oo(Context context) {
        m mVar = new m(O00000Oo);
        O00000Oo = false;
        O000000o(context, mVar, oO0Oo0oo.O00000o0);
    }

    static void O00000Oo(o0OO0o00 o0oo0o00, Context context, String str, String str2) {
        if (O000000o(o0oo0o00) && str != null && !"".equals(str)) {
            O000000o(context, o0oo0o00, 1, str, str2);
        }
    }

    static void O00000o(Context context) {
        if (O00000o == null || O00000o.get() == null) {
            O00000o = new WeakReference(new n(context, 3600000, "gKey", new q(context, false)));
        }
        O000000o(context, (p) O00000o.get(), oO0Oo0oo.O00000Oo);
    }

    static void O00000o0(Context context) {
        if (O00000o0 == null || O00000o0.get() == null) {
            O00000o0 = new WeakReference(new n(context, 3600000, "hKey", new q(context, false)));
        }
        O000000o(context, (p) O00000o0.get(), oO0Oo0oo.O00000o);
    }
}
