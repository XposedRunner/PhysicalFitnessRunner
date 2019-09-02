package com.amap.api.mapcore.util;

import android.content.Context;
import android.net.Proxy;
import android.os.Build.VERSION;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;

/* compiled from: ProxyUtil */
public class o0OO0OO0 {
    private static String O000000o() {
        String defaultHost;
        try {
            defaultHost = Proxy.getDefaultHost();
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "pu", "gdh");
            defaultHost = null;
        }
        return defaultHost == null ? "null" : defaultHost;
    }

    public static String O000000o(String str) {
        return o0OOOO00.O00000o0(str);
    }

    public static java.net.Proxy O000000o(Context context) {
        try {
            return VERSION.SDK_INT >= 11 ? O000000o(context, new URI("http://restapi.amap.com")) : O00000Oo(context);
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "pu", "gp");
            return null;
        }
    }

    private static java.net.Proxy O000000o(Context context, URI uri) {
        java.net.Proxy proxy = null;
        if (O00000o0(context)) {
            try {
                List select = ProxySelector.getDefault().select(uri);
                if (!(select == null || select.isEmpty())) {
                    java.net.Proxy proxy2 = (java.net.Proxy) select.get(0);
                    if (!(proxy2 == null || proxy2.type() == Type.DIRECT)) {
                        proxy = proxy2;
                    }
                }
                return proxy;
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "pu", "gpsc");
            }
        }
        return null;
    }

    private static boolean O000000o(String str, int i) {
        return (str == null || str.length() <= 0 || i == -1) ? false : true;
    }

    private static int O00000Oo() {
        try {
            return Proxy.getDefaultPort();
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "pu", "gdp");
            return -1;
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:68:0x00d0=Splitter:B:68:0x00d0, B:76:0x00e5=Splitter:B:76:0x00e5} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b9 A:{SYNTHETIC, Splitter:B:59:0x00b9} */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0155 A:{Catch:{ Throwable -> 0x0161 }} */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0155 A:{Catch:{ Throwable -> 0x0161 }} */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x014c A:{SYNTHETIC, Splitter:B:104:0x014c} */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0155 A:{Catch:{ Throwable -> 0x0161 }} */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0155 A:{Catch:{ Throwable -> 0x0161 }} */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f2 A:{Catch:{ all -> 0x016d }} */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x014c A:{SYNTHETIC, Splitter:B:104:0x014c} */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0155 A:{Catch:{ Throwable -> 0x0161 }} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00dc A:{SYNTHETIC, Splitter:B:71:0x00dc} */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0155 A:{Catch:{ Throwable -> 0x0161 }} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00dc A:{SYNTHETIC, Splitter:B:71:0x00dc} */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0155 A:{Catch:{ Throwable -> 0x0161 }} */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f2 A:{Catch:{ all -> 0x016d }} */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x014c A:{SYNTHETIC, Splitter:B:104:0x014c} */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0155 A:{Catch:{ Throwable -> 0x0161 }} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00dc A:{SYNTHETIC, Splitter:B:71:0x00dc} */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0155 A:{Catch:{ Throwable -> 0x0161 }} */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0170 A:{SYNTHETIC, Splitter:B:115:0x0170} */
    /* JADX WARNING: Missing block: B:30:0x006f, code skipped:
            if (r4 == -1) goto L_0x00b7;
     */
    /* JADX WARNING: Missing block: B:52:0x00ac, code skipped:
            if (r4 == -1) goto L_0x00b7;
     */
    private static java.net.Proxy O00000Oo(android.content.Context r11) {
        /*
        r0 = O00000o0(r11);
        r1 = 0;
        if (r0 == 0) goto L_0x017d;
    L_0x0007:
        r0 = "content://telephony/carriers/preferapn";
        r3 = android.net.Uri.parse(r0);
        r2 = r11.getContentResolver();
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r0 = 0;
        r8 = 80;
        r9 = 1;
        r10 = -1;
        r2 = r2.query(r3, r4, r5, r6, r7);	 Catch:{ SecurityException -> 0x00e1, Throwable -> 0x00cc, all -> 0x00c8 }
        if (r2 == 0) goto L_0x00b5;
    L_0x0020:
        r3 = r2.moveToFirst();	 Catch:{ SecurityException -> 0x00b2, Throwable -> 0x00af }
        if (r3 == 0) goto L_0x00b5;
    L_0x0026:
        r3 = "apn";
        r3 = r2.getColumnIndex(r3);	 Catch:{ SecurityException -> 0x00b2, Throwable -> 0x00af }
        r3 = r2.getString(r3);	 Catch:{ SecurityException -> 0x00b2, Throwable -> 0x00af }
        if (r3 == 0) goto L_0x0038;
    L_0x0032:
        r4 = java.util.Locale.US;	 Catch:{ SecurityException -> 0x00b2, Throwable -> 0x00af }
        r3 = r3.toLowerCase(r4);	 Catch:{ SecurityException -> 0x00b2, Throwable -> 0x00af }
    L_0x0038:
        if (r3 == 0) goto L_0x007d;
    L_0x003a:
        r4 = "ctwap";
        r4 = r3.contains(r4);	 Catch:{ SecurityException -> 0x00b2, Throwable -> 0x00af }
        if (r4 == 0) goto L_0x007d;
    L_0x0042:
        r3 = O000000o();	 Catch:{ SecurityException -> 0x00b2, Throwable -> 0x00af }
        r4 = O00000Oo();	 Catch:{ SecurityException -> 0x00b2, Throwable -> 0x00af }
        r5 = android.text.TextUtils.isEmpty(r3);	 Catch:{ SecurityException -> 0x0079, Throwable -> 0x0074 }
        if (r5 != 0) goto L_0x005b;
    L_0x0050:
        r5 = "null";
        r5 = r3.equals(r5);	 Catch:{ SecurityException -> 0x0079, Throwable -> 0x0074 }
        if (r5 != 0) goto L_0x005b;
    L_0x0058:
        r5 = r3;
        r3 = r9;
        goto L_0x005d;
    L_0x005b:
        r3 = r0;
        r5 = r1;
    L_0x005d:
        if (r3 != 0) goto L_0x006e;
    L_0x005f:
        r3 = "QMTAuMC4wLjIwMA==";
        r3 = O000000o(r3);	 Catch:{ SecurityException -> 0x006b, Throwable -> 0x0066 }
        goto L_0x006f;
    L_0x0066:
        r11 = move-exception;
        r8 = r4;
        r3 = r5;
        goto L_0x00d0;
    L_0x006b:
        r3 = move-exception;
        goto L_0x00e5;
    L_0x006e:
        r3 = r5;
    L_0x006f:
        if (r4 != r10) goto L_0x0072;
    L_0x0071:
        goto L_0x00b7;
    L_0x0072:
        r8 = r4;
        goto L_0x00b7;
    L_0x0074:
        r11 = move-exception;
        r3 = r1;
        r8 = r4;
        goto L_0x00d0;
    L_0x0079:
        r3 = move-exception;
        r5 = r1;
        goto L_0x00e5;
    L_0x007d:
        if (r3 == 0) goto L_0x00b5;
    L_0x007f:
        r4 = "wap";
        r3 = r3.contains(r4);	 Catch:{ SecurityException -> 0x00b2, Throwable -> 0x00af }
        if (r3 == 0) goto L_0x00b5;
    L_0x0087:
        r3 = O000000o();	 Catch:{ SecurityException -> 0x00b2, Throwable -> 0x00af }
        r4 = O00000Oo();	 Catch:{ SecurityException -> 0x00b2, Throwable -> 0x00af }
        r5 = android.text.TextUtils.isEmpty(r3);	 Catch:{ SecurityException -> 0x0079, Throwable -> 0x0074 }
        if (r5 != 0) goto L_0x00a0;
    L_0x0095:
        r5 = "null";
        r5 = r3.equals(r5);	 Catch:{ SecurityException -> 0x0079, Throwable -> 0x0074 }
        if (r5 != 0) goto L_0x00a0;
    L_0x009d:
        r5 = r3;
        r3 = r9;
        goto L_0x00a2;
    L_0x00a0:
        r3 = r0;
        r5 = r1;
    L_0x00a2:
        if (r3 != 0) goto L_0x00ab;
    L_0x00a4:
        r3 = "QMTAuMC4wLjE3Mg==";
        r3 = O000000o(r3);	 Catch:{ SecurityException -> 0x006b, Throwable -> 0x0066 }
        goto L_0x00ac;
    L_0x00ab:
        r3 = r5;
    L_0x00ac:
        if (r4 != r10) goto L_0x0072;
    L_0x00ae:
        goto L_0x00b7;
    L_0x00af:
        r11 = move-exception;
        r3 = r1;
        goto L_0x00cf;
    L_0x00b2:
        r3 = move-exception;
        r5 = r1;
        goto L_0x00e4;
    L_0x00b5:
        r3 = r1;
        r8 = r10;
    L_0x00b7:
        if (r2 == 0) goto L_0x014f;
    L_0x00b9:
        r2.close();	 Catch:{ Throwable -> 0x00be }
        goto L_0x014f;
    L_0x00be:
        r11 = move-exception;
        r0 = "pu";
        r2 = "gPx2";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r11, r0, r2);
        goto L_0x014f;
    L_0x00c8:
        r11 = move-exception;
        r2 = r1;
        goto L_0x016e;
    L_0x00cc:
        r11 = move-exception;
        r2 = r1;
        r3 = r2;
    L_0x00cf:
        r8 = r10;
    L_0x00d0:
        r0 = "pu";
        r4 = "gPx1";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r11, r0, r4);	 Catch:{ all -> 0x016d }
        r11.printStackTrace();	 Catch:{ all -> 0x016d }
        if (r2 == 0) goto L_0x014f;
    L_0x00dc:
        r2.close();	 Catch:{ Throwable -> 0x00be }
        goto L_0x014f;
    L_0x00e1:
        r3 = move-exception;
        r2 = r1;
        r5 = r2;
    L_0x00e4:
        r4 = r10;
    L_0x00e5:
        r6 = "pu";
        r7 = "ghp";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r3, r6, r7);	 Catch:{ all -> 0x016d }
        r11 = com.amap.api.mapcore.util.o0O0o000.O0000oOO(r11);	 Catch:{ all -> 0x016d }
        if (r11 == 0) goto L_0x0148;
    L_0x00f2:
        r3 = java.util.Locale.US;	 Catch:{ all -> 0x016d }
        r11 = r11.toLowerCase(r3);	 Catch:{ all -> 0x016d }
        r3 = O000000o();	 Catch:{ all -> 0x016d }
        r4 = O00000Oo();	 Catch:{ all -> 0x016d }
        r6 = "ctwap";
        r6 = r11.indexOf(r6);	 Catch:{ all -> 0x016d }
        if (r6 == r10) goto L_0x0126;
    L_0x0108:
        r11 = android.text.TextUtils.isEmpty(r3);	 Catch:{ all -> 0x016d }
        if (r11 != 0) goto L_0x0118;
    L_0x010e:
        r11 = "null";
        r11 = r3.equals(r11);	 Catch:{ all -> 0x016d }
        if (r11 != 0) goto L_0x0118;
    L_0x0116:
        r0 = r9;
        goto L_0x0119;
    L_0x0118:
        r3 = r5;
    L_0x0119:
        if (r0 != 0) goto L_0x0121;
    L_0x011b:
        r11 = "QMTAuMC4wLjIwMA==";
        r3 = O000000o(r11);	 Catch:{ all -> 0x016d }
    L_0x0121:
        if (r4 != r10) goto L_0x0124;
    L_0x0123:
        goto L_0x014a;
    L_0x0124:
        r8 = r4;
        goto L_0x014a;
    L_0x0126:
        r6 = "wap";
        r11 = r11.indexOf(r6);	 Catch:{ all -> 0x016d }
        if (r11 == r10) goto L_0x0148;
    L_0x012e:
        r11 = android.text.TextUtils.isEmpty(r3);	 Catch:{ all -> 0x016d }
        if (r11 != 0) goto L_0x013e;
    L_0x0134:
        r11 = "null";
        r11 = r3.equals(r11);	 Catch:{ all -> 0x016d }
        if (r11 != 0) goto L_0x013e;
    L_0x013c:
        r0 = r9;
        goto L_0x013f;
    L_0x013e:
        r3 = r5;
    L_0x013f:
        if (r0 != 0) goto L_0x014a;
    L_0x0141:
        r11 = "QMTAuMC4wLjE3Mg==";
        r3 = O000000o(r11);	 Catch:{ all -> 0x016d }
        goto L_0x014a;
    L_0x0148:
        r8 = r4;
        r3 = r5;
    L_0x014a:
        if (r2 == 0) goto L_0x014f;
    L_0x014c:
        r2.close();	 Catch:{ Throwable -> 0x00be }
    L_0x014f:
        r11 = O000000o(r3, r8);	 Catch:{ Throwable -> 0x0161 }
        if (r11 == 0) goto L_0x017d;
    L_0x0155:
        r11 = new java.net.Proxy;	 Catch:{ Throwable -> 0x0161 }
        r0 = java.net.Proxy.Type.HTTP;	 Catch:{ Throwable -> 0x0161 }
        r2 = java.net.InetSocketAddress.createUnresolved(r3, r8);	 Catch:{ Throwable -> 0x0161 }
        r11.<init>(r0, r2);	 Catch:{ Throwable -> 0x0161 }
        return r11;
    L_0x0161:
        r11 = move-exception;
        r0 = "pu";
        r2 = "gp2";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r11, r0, r2);
        r11.printStackTrace();
        goto L_0x017d;
    L_0x016d:
        r11 = move-exception;
    L_0x016e:
        if (r2 == 0) goto L_0x017c;
    L_0x0170:
        r2.close();	 Catch:{ Throwable -> 0x0174 }
        goto L_0x017c;
    L_0x0174:
        r0 = move-exception;
        r1 = "pu";
        r2 = "gPx2";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r0, r1, r2);
    L_0x017c:
        throw r11;
    L_0x017d:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.o0OO0OO0.O00000Oo(android.content.Context):java.net.Proxy");
    }

    private static boolean O00000o0(Context context) {
        return o0O0o000.O0000oO0(context) == 0;
    }
}
