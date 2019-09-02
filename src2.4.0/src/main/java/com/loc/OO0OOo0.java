package com.loc;

import android.content.Context;
import android.net.Proxy;
import android.os.Build.VERSION;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;

/* compiled from: ProxyUtil */
public final class OO0OOo0 {
    private static String O000000o() {
        String defaultHost;
        try {
            defaultHost = Proxy.getDefaultHost();
        } catch (Throwable th) {
            O0000o.O00000Oo(th, "pu", "gdh");
            defaultHost = null;
        }
        return defaultHost == null ? "null" : defaultHost;
    }

    public static java.net.Proxy O000000o(Context context) {
        try {
            return VERSION.SDK_INT >= 11 ? O000000o(context, new URI("http://restapi.amap.com")) : O00000Oo(context);
        } catch (Throwable th) {
            O0000o.O00000Oo(th, "pu", "gp");
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
                    if (proxy2 != null) {
                        if (proxy2.type() == Type.DIRECT) {
                            return null;
                        }
                        proxy = proxy2;
                    }
                }
                return proxy;
            } catch (Throwable th) {
                O0000o.O00000Oo(th, "pu", "gpsc");
            }
        }
        return null;
    }

    private static int O00000Oo() {
        try {
            return Proxy.getDefaultPort();
        } catch (Throwable th) {
            O0000o.O00000Oo(th, "pu", "gdp");
            return -1;
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:68:0x00d0=Splitter:B:68:0x00d0, B:76:0x00e5=Splitter:B:76:0x00e5} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b9 A:{SYNTHETIC, Splitter:B:59:0x00b9} */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0153 A:{SYNTHETIC, Splitter:B:107:0x0153} */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0161 A:{Catch:{ Throwable -> 0x015d }} */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0153 A:{SYNTHETIC, Splitter:B:107:0x0153} */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0161 A:{Catch:{ Throwable -> 0x015d }} */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x014e A:{SYNTHETIC, Splitter:B:104:0x014e} */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0153 A:{SYNTHETIC, Splitter:B:107:0x0153} */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0161 A:{Catch:{ Throwable -> 0x015d }} */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0153 A:{SYNTHETIC, Splitter:B:107:0x0153} */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0161 A:{Catch:{ Throwable -> 0x015d }} */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f2 A:{Catch:{ all -> 0x0178 }} */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x014e A:{SYNTHETIC, Splitter:B:104:0x014e} */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0153 A:{SYNTHETIC, Splitter:B:107:0x0153} */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0161 A:{Catch:{ Throwable -> 0x015d }} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00dc A:{SYNTHETIC, Splitter:B:71:0x00dc} */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0153 A:{SYNTHETIC, Splitter:B:107:0x0153} */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0161 A:{Catch:{ Throwable -> 0x015d }} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00dc A:{SYNTHETIC, Splitter:B:71:0x00dc} */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0153 A:{SYNTHETIC, Splitter:B:107:0x0153} */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0161 A:{Catch:{ Throwable -> 0x015d }} */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f2 A:{Catch:{ all -> 0x0178 }} */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x014e A:{SYNTHETIC, Splitter:B:104:0x014e} */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0153 A:{SYNTHETIC, Splitter:B:107:0x0153} */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0161 A:{Catch:{ Throwable -> 0x015d }} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00dc A:{SYNTHETIC, Splitter:B:71:0x00dc} */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0153 A:{SYNTHETIC, Splitter:B:107:0x0153} */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0161 A:{Catch:{ Throwable -> 0x015d }} */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x017b A:{SYNTHETIC, Splitter:B:121:0x017b} */
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
        if (r0 == 0) goto L_0x0188;
    L_0x0007:
        r0 = "content://telephony/carriers/preferapn";
        r3 = android.net.Uri.parse(r0);
        r2 = r11.getContentResolver();
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r0 = 80;
        r8 = 0;
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
        r5 = r1;
        r3 = r8;
    L_0x005d:
        if (r3 != 0) goto L_0x006e;
    L_0x005f:
        r3 = "QMTAuMC4wLjIwMA==";
        r3 = com.loc.OO0o000.O00000o0(r3);	 Catch:{ SecurityException -> 0x006b, Throwable -> 0x0066 }
        goto L_0x006f;
    L_0x0066:
        r11 = move-exception;
        r0 = r4;
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
        r0 = r4;
        goto L_0x00b7;
    L_0x0074:
        r11 = move-exception;
        r3 = r1;
        r0 = r4;
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
        r5 = r1;
        r3 = r8;
    L_0x00a2:
        if (r3 != 0) goto L_0x00ab;
    L_0x00a4:
        r3 = "QMTAuMC4wLjE3Mg==";
        r3 = com.loc.OO0o000.O00000o0(r3);	 Catch:{ SecurityException -> 0x006b, Throwable -> 0x0066 }
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
        r0 = r10;
    L_0x00b7:
        if (r2 == 0) goto L_0x0151;
    L_0x00b9:
        r2.close();	 Catch:{ Throwable -> 0x00be }
        goto L_0x0151;
    L_0x00be:
        r11 = move-exception;
        r2 = "pu";
        r4 = "gPx2";
        com.loc.O0000o.O00000Oo(r11, r2, r4);
        goto L_0x0151;
    L_0x00c8:
        r11 = move-exception;
        r2 = r1;
        goto L_0x0179;
    L_0x00cc:
        r11 = move-exception;
        r2 = r1;
        r3 = r2;
    L_0x00cf:
        r0 = r10;
    L_0x00d0:
        r4 = "pu";
        r5 = "gPx1";
        com.loc.O0000o.O00000Oo(r11, r4, r5);	 Catch:{ all -> 0x0178 }
        r11.printStackTrace();	 Catch:{ all -> 0x0178 }
        if (r2 == 0) goto L_0x0151;
    L_0x00dc:
        r2.close();	 Catch:{ Throwable -> 0x00be }
        goto L_0x0151;
    L_0x00e1:
        r3 = move-exception;
        r2 = r1;
        r5 = r2;
    L_0x00e4:
        r4 = r10;
    L_0x00e5:
        r6 = "pu";
        r7 = "ghp";
        com.loc.O0000o.O00000Oo(r3, r6, r7);	 Catch:{ all -> 0x0178 }
        r11 = com.loc.OO0O0o0.O0000oOO(r11);	 Catch:{ all -> 0x0178 }
        if (r11 == 0) goto L_0x014a;
    L_0x00f2:
        r3 = java.util.Locale.US;	 Catch:{ all -> 0x0178 }
        r11 = r11.toLowerCase(r3);	 Catch:{ all -> 0x0178 }
        r3 = O000000o();	 Catch:{ all -> 0x0178 }
        r4 = O00000Oo();	 Catch:{ all -> 0x0178 }
        r6 = "ctwap";
        r6 = r11.indexOf(r6);	 Catch:{ all -> 0x0178 }
        if (r6 == r10) goto L_0x0127;
    L_0x0108:
        r11 = android.text.TextUtils.isEmpty(r3);	 Catch:{ all -> 0x0178 }
        if (r11 != 0) goto L_0x0118;
    L_0x010e:
        r11 = "null";
        r11 = r3.equals(r11);	 Catch:{ all -> 0x0178 }
        if (r11 != 0) goto L_0x0118;
    L_0x0116:
        r11 = r9;
        goto L_0x011a;
    L_0x0118:
        r3 = r5;
        r11 = r8;
    L_0x011a:
        if (r11 != 0) goto L_0x0122;
    L_0x011c:
        r11 = "QMTAuMC4wLjIwMA==";
        r3 = com.loc.OO0o000.O00000o0(r11);	 Catch:{ all -> 0x0178 }
    L_0x0122:
        if (r4 != r10) goto L_0x0125;
    L_0x0124:
        goto L_0x014c;
    L_0x0125:
        r0 = r4;
        goto L_0x014c;
    L_0x0127:
        r6 = "wap";
        r11 = r11.indexOf(r6);	 Catch:{ all -> 0x0178 }
        if (r11 == r10) goto L_0x014a;
    L_0x012f:
        r11 = android.text.TextUtils.isEmpty(r3);	 Catch:{ all -> 0x0178 }
        if (r11 != 0) goto L_0x013f;
    L_0x0135:
        r11 = "null";
        r11 = r3.equals(r11);	 Catch:{ all -> 0x0178 }
        if (r11 != 0) goto L_0x013f;
    L_0x013d:
        r11 = r9;
        goto L_0x0141;
    L_0x013f:
        r3 = r5;
        r11 = r8;
    L_0x0141:
        if (r11 != 0) goto L_0x014c;
    L_0x0143:
        r11 = "QMTAuMC4wLjE3Mg==";
        r3 = com.loc.OO0o000.O00000o0(r11);	 Catch:{ all -> 0x0178 }
        goto L_0x014c;
    L_0x014a:
        r0 = r4;
        r3 = r5;
    L_0x014c:
        if (r2 == 0) goto L_0x0151;
    L_0x014e:
        r2.close();	 Catch:{ Throwable -> 0x00be }
    L_0x0151:
        if (r3 == 0) goto L_0x015f;
    L_0x0153:
        r11 = r3.length();	 Catch:{ Throwable -> 0x015d }
        if (r11 <= 0) goto L_0x015f;
    L_0x0159:
        if (r0 == r10) goto L_0x015f;
    L_0x015b:
        r8 = r9;
        goto L_0x015f;
    L_0x015d:
        r11 = move-exception;
        goto L_0x016d;
    L_0x015f:
        if (r8 == 0) goto L_0x0188;
    L_0x0161:
        r11 = new java.net.Proxy;	 Catch:{ Throwable -> 0x015d }
        r2 = java.net.Proxy.Type.HTTP;	 Catch:{ Throwable -> 0x015d }
        r0 = java.net.InetSocketAddress.createUnresolved(r3, r0);	 Catch:{ Throwable -> 0x015d }
        r11.<init>(r2, r0);	 Catch:{ Throwable -> 0x015d }
        return r11;
    L_0x016d:
        r0 = "pu";
        r2 = "gp2";
        com.loc.O0000Oo.O000000o(r11, r0, r2);
        r11.printStackTrace();
        return r1;
    L_0x0178:
        r11 = move-exception;
    L_0x0179:
        if (r2 == 0) goto L_0x0187;
    L_0x017b:
        r2.close();	 Catch:{ Throwable -> 0x017f }
        goto L_0x0187;
    L_0x017f:
        r0 = move-exception;
        r1 = "pu";
        r2 = "gPx2";
        com.loc.O0000o.O00000Oo(r0, r1, r2);
    L_0x0187:
        throw r11;
    L_0x0188:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.OO0OOo0.O00000Oo(android.content.Context):java.net.Proxy");
    }

    private static boolean O00000o0(Context context) {
        return OO0O0o0.O0000oO0(context) == 0;
    }
}
