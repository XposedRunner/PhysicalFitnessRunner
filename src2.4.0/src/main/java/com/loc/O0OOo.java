package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ExecutorService;

/* compiled from: DnsManager */
public final class O0OOo {
    private static O0OOo O00000o0;
    O0Oo0 O000000o;
    int O00000Oo;
    private Object O00000o;
    private Context O00000oO;
    private ExecutorService O00000oo;
    private boolean O0000O0o;
    private boolean O0000OOo;
    private String O0000Oo;
    private final int O0000Oo0;
    private String O0000OoO;
    private String[] O0000Ooo;
    private final int O0000o0;
    private final int O0000o00;

    /* compiled from: DnsManager */
    class O000000o implements Runnable {
        O0Oo0 O000000o = null;

        O000000o(O0Oo0 o0Oo0) {
            this.O000000o = o0Oo0;
        }

        public final void run() {
            O0OOo o0OOo = O0OOo.this;
            o0OOo.O00000Oo++;
            O0OOo.this.O00000Oo(this.O000000o);
            o0OOo = O0OOo.this;
            o0OOo.O00000Oo--;
        }
    }

    private O0OOo() {
        this.O00000o = null;
        this.O00000oO = null;
        this.O00000oo = null;
        this.O0000O0o = false;
        this.O0000OOo = true;
        this.O000000o = null;
        this.O0000Oo0 = 2;
        this.O0000Oo = "";
        this.O0000OoO = "";
        this.O0000Ooo = null;
        this.O00000Oo = 0;
        this.O0000o00 = 5;
        this.O0000o0 = 2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d1 A:{Catch:{ Throwable -> 0x00d8 }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00cd */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:27|28|29|30|(1:32)|33) */
    private O0OOo(android.content.Context r13) {
        /*
        r12 = this;
        r12.<init>();
        r0 = 0;
        r12.O00000o = r0;
        r12.O00000oO = r0;
        r12.O00000oo = r0;
        r1 = 0;
        r12.O0000O0o = r1;
        r2 = 1;
        r12.O0000OOo = r2;
        r12.O000000o = r0;
        r3 = 2;
        r12.O0000Oo0 = r3;
        r4 = "";
        r12.O0000Oo = r4;
        r4 = "";
        r12.O0000OoO = r4;
        r12.O0000Ooo = r0;
        r12.O00000Oo = r1;
        r0 = 5;
        r12.O0000o00 = r0;
        r12.O0000o0 = r3;
        r12.O00000oO = r13;
        r13 = r12.O00000oO;
        r0 = new java.lang.Object[r2];
        r3 = "DnsManager ==> init ";
        r0[r1] = r3;
        com.loc.OO000OO.O000000o();
        r0 = com.loc.OoO0o.O0000oo0();	 Catch:{ Throwable -> 0x00ed }
        if (r0 != 0) goto L_0x003a;
    L_0x0039:
        return;
    L_0x003a:
        r0 = r12.O00000o;	 Catch:{ Throwable -> 0x00ed }
        if (r0 != 0) goto L_0x00ec;
    L_0x003e:
        r0 = "pref";
        r3 = "ok6";
        r0 = com.loc.OO0000o.O00000Oo(r13, r0, r3, r1);	 Catch:{ Throwable -> 0x00ed }
        r3 = "pref";
        r4 = "ok8";
        r10 = 0;
        r3 = com.loc.OO0000o.O00000Oo(r13, r3, r4, r10);	 Catch:{ Throwable -> 0x00ed }
        if (r0 == 0) goto L_0x0064;
    L_0x0052:
        r5 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1));
        if (r5 == 0) goto L_0x0064;
    L_0x0056:
        r5 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x00ed }
        r7 = r5 - r3;
        r3 = 259200000; // 0xf731400 float:1.1984677E-29 double:1.280618154E-315;
        r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1));
        if (r5 >= 0) goto L_0x0064;
    L_0x0063:
        return;
    L_0x0064:
        r3 = "pref";
        r4 = "ok6";
        r0 = r0 + r2;
        com.loc.OO0000o.O000000o(r13, r3, r4, r0);	 Catch:{ Throwable -> 0x00ed }
        r0 = "pref";
        r3 = "ok8";
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x00ed }
        com.loc.OO0000o.O000000o(r13, r0, r3, r4);	 Catch:{ Throwable -> 0x00ed }
        r0 = O00000o0();	 Catch:{ Throwable -> 0x00ed }
        if (r0 == 0) goto L_0x00a2;
    L_0x007d:
        r0 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x00ed }
        r3 = "DnsManager ==> initForJar ";
        r0[r1] = r3;	 Catch:{ Throwable -> 0x00ed }
        com.loc.OO000OO.O000000o();	 Catch:{ Throwable -> 0x00ed }
        r0 = "com.autonavi.httpdns.HttpDnsManager";
        r3 = new java.lang.Class[r2];	 Catch:{ Throwable -> 0x0099 }
        r4 = android.content.Context.class;
        r3[r1] = r4;	 Catch:{ Throwable -> 0x0099 }
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0099 }
        r2[r1] = r13;	 Catch:{ Throwable -> 0x0099 }
        r0 = com.loc.O0o.O000000o(r0, r3, r2);	 Catch:{ Throwable -> 0x0099 }
        r12.O00000o = r0;	 Catch:{ Throwable -> 0x0099 }
        goto L_0x00de;
    L_0x0099:
        r0 = move-exception;
        r2 = "DnsManager";
        r3 = "initForJar";
    L_0x009e:
        com.loc.O0o0000.O000000o(r0, r2, r3);	 Catch:{ Throwable -> 0x00ed }
        goto L_0x00de;
    L_0x00a2:
        r0 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x00ed }
        r3 = "DnsManager ==> initHttpDnsDex ";
        r0[r1] = r3;	 Catch:{ Throwable -> 0x00ed }
        com.loc.OO000OO.O000000o();	 Catch:{ Throwable -> 0x00ed }
        r0 = "HttpDNS";
        r3 = "1.0.0";
        r5 = com.loc.O0o0000.O000000o(r0, r3);	 Catch:{ Throwable -> 0x00d8 }
        r0 = com.loc.ooO0Ooo.O000000o(r13, r5);	 Catch:{ Throwable -> 0x00d8 }
        if (r0 == 0) goto L_0x00de;
    L_0x00b9:
        r6 = "com.autonavi.httpdns.HttpDnsManager";
        r7 = 0;
        r8 = new java.lang.Class[r2];	 Catch:{ Throwable -> 0x00cd }
        r0 = android.content.Context.class;
        r8[r1] = r0;	 Catch:{ Throwable -> 0x00cd }
        r9 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x00cd }
        r9[r1] = r13;	 Catch:{ Throwable -> 0x00cd }
        r4 = r13;
        r0 = com.loc.O000OOo.O000000o(r4, r5, r6, r7, r8, r9);	 Catch:{ Throwable -> 0x00cd }
        r12.O00000o = r0;	 Catch:{ Throwable -> 0x00cd }
    L_0x00cd:
        r0 = r12.O00000o;	 Catch:{ Throwable -> 0x00d8 }
        if (r0 != 0) goto L_0x00d2;
    L_0x00d1:
        r2 = r1;
    L_0x00d2:
        r0 = "HttpDns";
        com.loc.ooO0Ooo.O000000o(r13, r0, r2);	 Catch:{ Throwable -> 0x00d8 }
        goto L_0x00de;
    L_0x00d8:
        r0 = move-exception;
        r2 = "DNSManager";
        r3 = "initHttpDns";
        goto L_0x009e;
    L_0x00de:
        r0 = "pref";
        r2 = "ok6";
        com.loc.OO0000o.O000000o(r13, r0, r2, r1);	 Catch:{ Throwable -> 0x00ed }
        r0 = "pref";
        r1 = "ok8";
        com.loc.OO0000o.O000000o(r13, r0, r1, r10);	 Catch:{ Throwable -> 0x00ed }
    L_0x00ec:
        return;
    L_0x00ed:
        r13 = move-exception;
        r0 = "APSCoManager";
        r1 = "init";
        com.loc.O0o0000.O000000o(r13, r0, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0OOo.<init>(android.content.Context):void");
    }

    public static O0OOo O000000o(Context context) {
        if (O00000o0 == null) {
            O00000o0 = new O0OOo(context);
        }
        return O00000o0;
    }

    private String O000000o(String str) {
        String str2 = null;
        if (O00000oo()) {
            int i;
            try {
                String str3;
                String[] strArr = (String[]) O0o.O000000o(this.O00000o, "getIpsByHostAsync", str);
                if (strArr == null || strArr.length <= 0) {
                    str3 = null;
                } else if (this.O0000Ooo == null) {
                    this.O0000Ooo = strArr;
                    str3 = strArr[0];
                } else if (O000000o(strArr, this.O0000Ooo)) {
                    str3 = this.O0000Ooo[0];
                } else {
                    this.O0000Ooo = strArr;
                    str3 = strArr[0];
                }
                str2 = str3;
                i = 1;
            } catch (Throwable unused) {
                i = 0;
            }
            ooO0Ooo.O00000Oo(this.O00000oO, "HttpDns", i);
        }
        Object[] objArr = new Object[1];
        StringBuilder stringBuilder = new StringBuilder("DnsManager ==> getIpAsync  host ： ");
        stringBuilder.append(str);
        stringBuilder.append(" ， ip ： ");
        stringBuilder.append(str2);
        objArr[0] = stringBuilder.toString();
        OO000OO.O000000o();
        return str2;
    }

    private static boolean O000000o(String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 == null) {
            return false;
        }
        if (strArr == null && strArr2 != null) {
            return false;
        }
        if (strArr == null && strArr2 == null) {
            return true;
        }
        try {
            if (strArr.length != strArr2.length) {
                return false;
            }
            ArrayList arrayList = new ArrayList(12);
            ArrayList arrayList2 = new ArrayList(12);
            arrayList.addAll(Arrays.asList(strArr));
            arrayList2.addAll(Arrays.asList(strArr2));
            Collections.sort(arrayList);
            Collections.sort(arrayList2);
            for (int i = 0; i < arrayList.size(); i++) {
                if (!((String) arrayList.get(i)).equals(arrayList2.get(i))) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean O00000o0() {
        try {
            Class.forName("com.autonavi.httpdns.HttpDnsManager");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void O00000oO() {
        O00000o0 = null;
    }

    private boolean O00000oo() {
        return OoO0o.O0000oo0() && this.O00000o != null && !O0000O0o() && OO0000o.O00000Oo(this.O00000oO, "pref", "dns_faile_count_total", 0) < 2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x003e A:{SKIP} */
    private boolean O0000O0o() {
        /*
        r7 = this;
        r0 = 0;
        r1 = 1;
        r2 = -1;
        r3 = 0;
        r4 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x0034 }
        r5 = 14;
        if (r4 < r5) goto L_0x000c;
    L_0x000a:
        r4 = r1;
        goto L_0x000d;
    L_0x000c:
        r4 = r0;
    L_0x000d:
        if (r4 == 0) goto L_0x0027;
    L_0x000f:
        r4 = "http.proxyHost";
        r4 = java.lang.System.getProperty(r4);	 Catch:{ Throwable -> 0x0034 }
        r3 = "http.proxyPort";
        r3 = java.lang.System.getProperty(r3);	 Catch:{ Throwable -> 0x0025 }
        if (r3 == 0) goto L_0x001e;
    L_0x001d:
        goto L_0x0020;
    L_0x001e:
        r3 = "-1";
    L_0x0020:
        r3 = java.lang.Integer.parseInt(r3);	 Catch:{ Throwable -> 0x0025 }
        goto L_0x003c;
    L_0x0025:
        r3 = move-exception;
        goto L_0x0038;
    L_0x0027:
        r4 = r7.O00000oO;	 Catch:{ Throwable -> 0x0034 }
        r4 = android.net.Proxy.getHost(r4);	 Catch:{ Throwable -> 0x0034 }
        r3 = r7.O00000oO;	 Catch:{ Throwable -> 0x0025 }
        r3 = android.net.Proxy.getPort(r3);	 Catch:{ Throwable -> 0x0025 }
        goto L_0x003c;
    L_0x0034:
        r4 = move-exception;
        r6 = r4;
        r4 = r3;
        r3 = r6;
    L_0x0038:
        r3.printStackTrace();
        r3 = r2;
    L_0x003c:
        if (r4 == 0) goto L_0x0041;
    L_0x003e:
        if (r3 == r2) goto L_0x0041;
    L_0x0040:
        return r1;
    L_0x0041:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0OOo.O0000O0o():boolean");
    }

    public final void O000000o() {
        if (!TextUtils.isEmpty(this.O0000OoO)) {
            if (TextUtils.isEmpty(this.O0000Oo) || !this.O0000OoO.equals(this.O0000Oo)) {
                this.O0000Oo = this.O0000OoO;
                OO0000o.O000000o(this.O00000oO, "ip", "last_ip", this.O0000OoO);
            }
        }
    }

    public final void O000000o(O0Oo0 o0Oo0) {
        try {
            this.O0000O0o = false;
            if (O00000oo() && o0Oo0 != null) {
                this.O000000o = o0Oo0;
                String O00000o0 = o0Oo0.O00000o0();
                String host = new URL(O00000o0).getHost();
                if (!"http://abroad.apilocate.amap.com/mobile/binary".equals(O00000o0) && !"abroad.apilocate.amap.com".equals(host)) {
                    String str = "apilocate.amap.com".equalsIgnoreCase(host) ? "httpdns.apilocate.amap.com" : host;
                    CharSequence O000000o = O000000o(str);
                    if (this.O0000OOo && TextUtils.isEmpty(O000000o)) {
                        this.O0000OOo = false;
                        O000000o = OO0000o.O00000Oo(this.O00000oO, "ip", "last_ip", "");
                        if (!TextUtils.isEmpty(O000000o)) {
                            this.O0000Oo = O000000o;
                        }
                    }
                    if (!TextUtils.isEmpty(O000000o)) {
                        this.O0000OoO = O000000o;
                        o0Oo0.O0000O0o = O00000o0.replace(host, O000000o);
                        o0Oo0.O000000o().put("host", str);
                        o0Oo0.O000000o(str);
                        this.O0000O0o = true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void O00000Oo() {
        if (this.O0000O0o) {
            OO0000o.O000000o(this.O00000oO, "pref", "dns_faile_count_total", 0);
        }
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0040 */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing block: B:17:?, code skipped:
            com.loc.OO0000o.O000000o(r10.O00000oO, "pref", "dns_faile_count_total", 0);
     */
    /* JADX WARNING: Missing block: B:19:0x004a, code skipped:
            return;
     */
    public final synchronized void O00000Oo(com.loc.O0Oo0 r11) {
        /*
        r10 = this;
        monitor-enter(r10);
        r0 = 0;
        r2 = com.loc.O0o0000.O000000o();	 Catch:{ Throwable -> 0x0040 }
        r11.O0000O0o = r2;	 Catch:{ Throwable -> 0x0040 }
        r2 = r10.O00000oO;	 Catch:{ Throwable -> 0x0040 }
        r3 = "pref";
        r4 = "dns_faile_count_total";
        r2 = com.loc.OO0000o.O00000Oo(r2, r3, r4, r0);	 Catch:{ Throwable -> 0x0040 }
        r4 = 2;
        r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r6 < 0) goto L_0x001b;
    L_0x0019:
        monitor-exit(r10);
        return;
    L_0x001b:
        com.loc.O00O0o.O000000o();	 Catch:{ Throwable -> 0x0040 }
        r6 = 0;
        com.loc.O00O0o.O000000o(r11, r6);	 Catch:{ Throwable -> 0x0040 }
        r6 = 1;
        r8 = r2 + r6;
        r11 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));
        if (r11 < 0) goto L_0x0033;
    L_0x002a:
        r11 = r10.O00000oO;	 Catch:{ Throwable -> 0x0040 }
        r2 = "HttpDNS";
        r3 = "dns failed too much";
        com.loc.OO0000.O000000o(r11, r2, r3);	 Catch:{ Throwable -> 0x0040 }
    L_0x0033:
        r11 = r10.O00000oO;	 Catch:{ Throwable -> 0x0040 }
        r2 = "pref";
        r3 = "dns_faile_count_total";
        com.loc.OO0000o.O000000o(r11, r2, r3, r8);	 Catch:{ Throwable -> 0x0040 }
        monitor-exit(r10);
        return;
    L_0x003e:
        r11 = move-exception;
        goto L_0x004b;
    L_0x0040:
        r11 = r10.O00000oO;	 Catch:{ all -> 0x003e }
        r2 = "pref";
        r3 = "dns_faile_count_total";
        com.loc.OO0000o.O000000o(r11, r2, r3, r0);	 Catch:{ all -> 0x003e }
        monitor-exit(r10);
        return;
    L_0x004b:
        monitor-exit(r10);
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0OOo.O00000Oo(com.loc.O0Oo0):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0046 A:{Catch:{ Throwable -> 0x0060 }} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0054 A:{Catch:{ Throwable -> 0x0060 }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public final void O00000o() {
        /*
        r4 = this;
        r0 = r4.O00000oo();	 Catch:{ Throwable -> 0x0060 }
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = r4.O0000O0o;	 Catch:{ Throwable -> 0x0060 }
        if (r0 == 0) goto L_0x0039;
    L_0x000b:
        r0 = r4.O0000Ooo;	 Catch:{ Throwable -> 0x0060 }
        if (r0 == 0) goto L_0x0039;
    L_0x000f:
        r0 = r4.O0000Ooo;	 Catch:{ Throwable -> 0x0060 }
        if (r0 == 0) goto L_0x0039;
    L_0x0013:
        r1 = r0.length;	 Catch:{ Throwable -> 0x0039 }
        r2 = 1;
        if (r1 > r2) goto L_0x0018;
    L_0x0017:
        goto L_0x0039;
    L_0x0018:
        r1 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x0039 }
        r2 = 12;
        r1.<init>(r2);	 Catch:{ Throwable -> 0x0039 }
        r2 = java.util.Arrays.asList(r0);	 Catch:{ Throwable -> 0x0039 }
        r1.addAll(r2);	 Catch:{ Throwable -> 0x0039 }
        r2 = r1.iterator();	 Catch:{ Throwable -> 0x0039 }
        r3 = r2.next();	 Catch:{ Throwable -> 0x0039 }
        r3 = (java.lang.String) r3;	 Catch:{ Throwable -> 0x0039 }
        r2.remove();	 Catch:{ Throwable -> 0x0039 }
        r1.add(r3);	 Catch:{ Throwable -> 0x0039 }
        r1.toArray(r0);	 Catch:{ Throwable -> 0x0039 }
    L_0x0039:
        r0 = r4.O00000Oo;	 Catch:{ Throwable -> 0x0060 }
        r1 = 5;
        if (r0 > r1) goto L_0x0060;
    L_0x003e:
        r0 = r4.O0000O0o;	 Catch:{ Throwable -> 0x0060 }
        if (r0 == 0) goto L_0x0060;
    L_0x0042:
        r0 = r4.O00000oo;	 Catch:{ Throwable -> 0x0060 }
        if (r0 != 0) goto L_0x004c;
    L_0x0046:
        r0 = com.loc.O0000o.O00000o();	 Catch:{ Throwable -> 0x0060 }
        r4.O00000oo = r0;	 Catch:{ Throwable -> 0x0060 }
    L_0x004c:
        r0 = r4.O00000oo;	 Catch:{ Throwable -> 0x0060 }
        r0 = r0.isShutdown();	 Catch:{ Throwable -> 0x0060 }
        if (r0 != 0) goto L_0x0060;
    L_0x0054:
        r0 = r4.O00000oo;	 Catch:{ Throwable -> 0x0060 }
        r1 = new com.loc.O0OOo$O000000o;	 Catch:{ Throwable -> 0x0060 }
        r2 = r4.O000000o;	 Catch:{ Throwable -> 0x0060 }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x0060 }
        r0.submit(r1);	 Catch:{ Throwable -> 0x0060 }
    L_0x0060:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0OOo.O00000o():void");
    }
}
